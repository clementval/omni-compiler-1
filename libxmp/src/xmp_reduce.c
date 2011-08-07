/*
 * $TSUKUBA_Release: $
 * $TSUKUBA_Copyright:
 *  $
 */

#include <string.h>
#include <stdarg.h>
#include <limits.h>
#include "mpi.h"
#include "xmp_constant.h"
#include "xmp_internal.h"

static void _XMP_setup_reduce_type(MPI_Datatype *mpi_datatype, size_t *datatype_size, int datatype) {
  switch (datatype) {
//  case _XMP_N_TYPE_BOOL:
//    { *mpi_datatype = MPI_C_BOOL;			*datatype_size = sizeof(_Bool); 			break; }
    case _XMP_N_TYPE_CHAR:
      { *mpi_datatype = MPI_SIGNED_CHAR;		*datatype_size = sizeof(char); 				break; }
    case _XMP_N_TYPE_UNSIGNED_CHAR:
      { *mpi_datatype = MPI_UNSIGNED_CHAR;		*datatype_size = sizeof(unsigned char); 		break; }
    case _XMP_N_TYPE_SHORT:
      { *mpi_datatype = MPI_SHORT;			*datatype_size = sizeof(short); 			break; }
    case _XMP_N_TYPE_UNSIGNED_SHORT:
      { *mpi_datatype = MPI_UNSIGNED_SHORT;		*datatype_size = sizeof(unsigned short); 		break; }
    case _XMP_N_TYPE_INT:
      { *mpi_datatype = MPI_INT;			*datatype_size = sizeof(int); 				break; }
    case _XMP_N_TYPE_UNSIGNED_INT:
      { *mpi_datatype = MPI_UNSIGNED;			*datatype_size = sizeof(unsigned int); 			break; }
    case _XMP_N_TYPE_LONG:
      { *mpi_datatype = MPI_LONG;			*datatype_size = sizeof(long); 				break; }
    case _XMP_N_TYPE_UNSIGNED_LONG:
      { *mpi_datatype = MPI_UNSIGNED_LONG;		*datatype_size = sizeof(unsigned long); 		break; }
    case _XMP_N_TYPE_LONGLONG:
      { *mpi_datatype = MPI_LONG_LONG;			*datatype_size = sizeof(long long); 			break; }
    case _XMP_N_TYPE_UNSIGNED_LONGLONG:
      { *mpi_datatype = MPI_UNSIGNED_LONG_LONG;		*datatype_size = sizeof(unsigned long long); 		break; }
    case _XMP_N_TYPE_FLOAT:
      { *mpi_datatype = MPI_FLOAT;			*datatype_size = sizeof(float); 			break; }
    case _XMP_N_TYPE_DOUBLE:
      { *mpi_datatype = MPI_DOUBLE;			*datatype_size = sizeof(double); 			break; }
    case _XMP_N_TYPE_LONG_DOUBLE:
      { *mpi_datatype = MPI_LONG_DOUBLE;		*datatype_size = sizeof(long double); 			break; }
//  case _XMP_N_TYPE_FLOAT_IMAGINARY:
//    { *mpi_datatype = MPI_FLOAT;			*datatype_size = sizeof(float _Imaginary); 		break; }
//  case _XMP_N_TYPE_DOUBLE_IMAGINARY:
//    { *mpi_datatype = MPI_DOUBLE;			*datatype_size = sizeof(double _Imaginary); 		break; }
//  case _XMP_N_TYPE_LONG_DOUBLE_IMAGINARY:
//    { *mpi_datatype = MPI_LONG_DOUBLE;		*datatype_size = sizeof(long double _Imaginary);	break; }
//  case _XMP_N_TYPE_FLOAT_COMPLEX:
//    { *mpi_datatype = MPI_C_FLOAT_COMPLEX;		*datatype_size = sizeof(float _Complex); 		break; }
//  case _XMP_N_TYPE_DOUBLE_COMPLEX:
//    { *mpi_datatype = MPI_C_DOUBLE_COMPLEX;		*datatype_size = sizeof(double _Complex); 		break; }
//  case _XMP_N_TYPE_LONG_DOUBLE_COMPLEX:
//    { *mpi_datatype = MPI_C_LONG_DOUBLE_COMPLEX;	*datatype_size = sizeof(long double _Complex); 		break; }
    default:
      _XMP_fatal("unknown data type for reduction");
  }
}

static void _XMP_setup_reduce_op(MPI_Op *mpi_op, int op) {
  switch (op) {
    case _XMP_N_REDUCE_SUM:
      *mpi_op = MPI_SUM;
      break;
    case _XMP_N_REDUCE_PROD:
      *mpi_op = MPI_PROD;
      break;
    case _XMP_N_REDUCE_BAND:
      *mpi_op = MPI_BAND;
      break;
    case _XMP_N_REDUCE_LAND:
      *mpi_op = MPI_LAND;
      break;
    case _XMP_N_REDUCE_BOR:
      *mpi_op = MPI_BOR;
      break;
    case _XMP_N_REDUCE_LOR:
      *mpi_op = MPI_LOR;
      break;
    case _XMP_N_REDUCE_BXOR:
      *mpi_op = MPI_BXOR;
      break;
    case _XMP_N_REDUCE_LXOR:
      *mpi_op = MPI_LXOR;
      break;
    case _XMP_N_REDUCE_MAX:
      *mpi_op = MPI_MAX;
      break;
    case _XMP_N_REDUCE_MIN:
      *mpi_op = MPI_MIN;
      break;
    case _XMP_N_REDUCE_FIRSTMAX:
      *mpi_op = MPI_MAX;
      break;
    case _XMP_N_REDUCE_FIRSTMIN:
      *mpi_op = MPI_MIN;
      break;
    case _XMP_N_REDUCE_LASTMAX:
      *mpi_op = MPI_MAX;
      break;
    case _XMP_N_REDUCE_LASTMIN:
      *mpi_op = MPI_MIN;
      break;
    default:
      _XMP_fatal("unknown reduce operation");
  }
}

static void _XMP_setup_reduce_FLMM_op(MPI_Op *mpi_op, int op) {
  switch (op) {
    case _XMP_N_REDUCE_FIRSTMAX:
    case _XMP_N_REDUCE_FIRSTMIN:
      *mpi_op = MPI_MIN;
      break;
    case _XMP_N_REDUCE_LASTMAX:
    case _XMP_N_REDUCE_LASTMIN:
      *mpi_op = MPI_MAX;
      break;
    default:
      _XMP_fatal("unknown reduce operation");
  }
}

#define _XMP_M_COMPARE_REDUCE_RESULTS_MAIN(type) \
{ \
  type *buf1 = (type *)temp_buffer; \
  type *buf2 = (type *)addr; \
  for (int i = 0; i < count; i++) { \
    if (buf1[i] == buf2[i]) cmp_buffer[i] = true; \
    else                    cmp_buffer[i] = false; \
  } \
  break; \
}

static void _XMP_compare_reduce_results(_Bool *cmp_buffer, void *temp_buffer, void *addr, int count, int datatype) {
  switch (datatype) {
    case _XMP_N_TYPE_BOOL:			_XMP_M_COMPARE_REDUCE_RESULTS_MAIN(_Bool);
    case _XMP_N_TYPE_CHAR:			_XMP_M_COMPARE_REDUCE_RESULTS_MAIN(char);
    case _XMP_N_TYPE_UNSIGNED_CHAR:		_XMP_M_COMPARE_REDUCE_RESULTS_MAIN(unsigned char);
    case _XMP_N_TYPE_SHORT:			_XMP_M_COMPARE_REDUCE_RESULTS_MAIN(short);
    case _XMP_N_TYPE_UNSIGNED_SHORT:		_XMP_M_COMPARE_REDUCE_RESULTS_MAIN(unsigned short);
    case _XMP_N_TYPE_INT:			_XMP_M_COMPARE_REDUCE_RESULTS_MAIN(int);
    case _XMP_N_TYPE_UNSIGNED_INT:		_XMP_M_COMPARE_REDUCE_RESULTS_MAIN(unsigned int);
    case _XMP_N_TYPE_LONG:			_XMP_M_COMPARE_REDUCE_RESULTS_MAIN(long);
    case _XMP_N_TYPE_UNSIGNED_LONG:		_XMP_M_COMPARE_REDUCE_RESULTS_MAIN(unsigned long);
    case _XMP_N_TYPE_LONGLONG:			_XMP_M_COMPARE_REDUCE_RESULTS_MAIN(long long);
    case _XMP_N_TYPE_UNSIGNED_LONGLONG:		_XMP_M_COMPARE_REDUCE_RESULTS_MAIN(unsigned long long);
    case _XMP_N_TYPE_FLOAT:			_XMP_M_COMPARE_REDUCE_RESULTS_MAIN(float);
    case _XMP_N_TYPE_DOUBLE:			_XMP_M_COMPARE_REDUCE_RESULTS_MAIN(double);
    case _XMP_N_TYPE_LONG_DOUBLE:		_XMP_M_COMPARE_REDUCE_RESULTS_MAIN(long double);
    case _XMP_N_TYPE_FLOAT_IMAGINARY:
    case _XMP_N_TYPE_DOUBLE_IMAGINARY:
    case _XMP_N_TYPE_LONG_DOUBLE_IMAGINARY:
    case _XMP_N_TYPE_FLOAT_COMPLEX:
    case _XMP_N_TYPE_DOUBLE_COMPLEX:
    case _XMP_N_TYPE_LONG_DOUBLE_COMPLEX:
      // FIXME
      _XMP_fatal("not implemented yet");
    default:
      _XMP_fatal("unknown data type for reduction");
  }
}

#define _XMP_M_INIT_LOCATION_VARIABLES_MAIN(type, init_min, init_max) \
{ \
  type *buf = (type *)loc; \
  for (int i = 0; i < count; i++) { \
    if (!cmp_buffer[i]) { \
      switch (op) { \
        case _XMP_N_REDUCE_FIRSTMAX: \
        case _XMP_N_REDUCE_FIRSTMIN: \
          buf[i] = init_max; \
          break; \
        case _XMP_N_REDUCE_LASTMAX: \
        case _XMP_N_REDUCE_LASTMIN: \
          buf[i] = init_min; \
          break; \
        default: \
          _XMP_fatal("unknown reduce operation"); \
      } \
    } \
  } \
  break; \
}

static void _XMP_init_localtion_variables(void *loc, int count, int loc_datatype, _Bool *cmp_buffer, int op) {
  switch (loc_datatype) {
    case _XMP_N_TYPE_CHAR:		_XMP_M_INIT_LOCATION_VARIABLES_MAIN(char, SCHAR_MIN, SCHAR_MAX);
    case _XMP_N_TYPE_UNSIGNED_CHAR:	_XMP_M_INIT_LOCATION_VARIABLES_MAIN(unsigned char, 0, UCHAR_MAX);
    case _XMP_N_TYPE_SHORT:		_XMP_M_INIT_LOCATION_VARIABLES_MAIN(short, SHRT_MIN, SHRT_MAX);
    case _XMP_N_TYPE_UNSIGNED_SHORT:	_XMP_M_INIT_LOCATION_VARIABLES_MAIN(unsigned short, 0, USHRT_MAX);
    case _XMP_N_TYPE_INT:		_XMP_M_INIT_LOCATION_VARIABLES_MAIN(int, INT_MIN, INT_MAX);
    case _XMP_N_TYPE_UNSIGNED_INT:	_XMP_M_INIT_LOCATION_VARIABLES_MAIN(unsigned int, 0, UINT_MAX);
    case _XMP_N_TYPE_LONG:		_XMP_M_INIT_LOCATION_VARIABLES_MAIN(long, LONG_MIN, LONG_MAX);
    case _XMP_N_TYPE_UNSIGNED_LONG:	_XMP_M_INIT_LOCATION_VARIABLES_MAIN(unsigned long, 0, ULONG_MAX);
    case _XMP_N_TYPE_LONGLONG:		_XMP_M_INIT_LOCATION_VARIABLES_MAIN(long long, LLONG_MIN, LLONG_MAX);
    case _XMP_N_TYPE_UNSIGNED_LONGLONG:	_XMP_M_INIT_LOCATION_VARIABLES_MAIN(unsigned long long, 0, ULLONG_MAX);
    default:
      _XMP_fatal("wrong data type for <location-variables>");
  }
}

void _XMP_reduce_NODES_ENTIRE(_XMP_nodes_t *nodes, void *addr, int count, int datatype, int op) {
  if (count == 0) {
    return; // FIXME not good implementation
  }

  if (!nodes->is_member) {
    return;
  }

  // setup information
  MPI_Datatype mpi_datatype;
  size_t datatype_size;
  MPI_Op mpi_op;
  _XMP_setup_reduce_type(&mpi_datatype, &datatype_size, datatype);
  _XMP_setup_reduce_op(&mpi_op, op);

  // reduce
  MPI_Allreduce(MPI_IN_PLACE, addr, count, mpi_datatype, mpi_op, *((MPI_Comm *)nodes->comm));
}

// _XMP_M_REDUCE_EXEC(addr, count, datatype, op) is in xmp_comm_macro.h

void _XMP_reduce_FLMM_NODES_ENTIRE(_XMP_nodes_t *nodes,
                                   void *addr, int count, int datatype, int op,
                                   int num_locs, ...) {
  if (count == 0) {
    return; // FIXME not good implementation
  }

  if (!nodes->is_member) {
    return;
  }

  // setup information
  MPI_Datatype mpi_datatype;
  size_t datatype_size;
  MPI_Op mpi_op;
  _XMP_setup_reduce_type(&mpi_datatype, &datatype_size, datatype);
  _XMP_setup_reduce_op(&mpi_op, op);

  // reduce <reduction-variable>
  size_t n = datatype_size * count;
  void *temp_buffer = _XMP_alloc(n);
  memcpy(temp_buffer, addr, n);

  MPI_Allreduce(temp_buffer, addr, count, mpi_datatype, mpi_op, *((MPI_Comm *)nodes->comm));

  // compare results
  n = sizeof(_Bool) * count;
  _Bool *cmp_buffer = _XMP_alloc(n);
  _XMP_compare_reduce_results(cmp_buffer, temp_buffer, addr, count, datatype);

  // reduce <location-variable>
  va_list args;
  va_start(args, num_locs);
  for (int i = 0; i < num_locs; i++) {
    void *loc = va_arg(args, void *);
    int loc_datatype = va_arg(args, int);

    _XMP_setup_reduce_type(&mpi_datatype, &datatype_size, loc_datatype);
    _XMP_setup_reduce_FLMM_op(&mpi_op, op);
    _XMP_init_localtion_variables(loc, count, loc_datatype, cmp_buffer, op);

    n = datatype_size * count;
    void *loc_temp = _XMP_alloc(n);
    memcpy(loc_temp, loc, n);

    MPI_Allreduce(loc_temp, loc, count, mpi_datatype, mpi_op, *((MPI_Comm *)nodes->comm));

    _XMP_free(loc_temp);
  }
  va_end(args);

  _XMP_free(temp_buffer);
  _XMP_free(cmp_buffer);
}

// _XMP_M_REDUCE_FLMM_EXEC(addr, count, datatype, op, num_locs, ...) is in xmp_comm_macro.h

void _XMP_reduce_CLAUSE(void *data_addr, int count, int datatype, int op) {
  // setup information
  MPI_Datatype mpi_datatype;
  size_t datatype_size; // not used in this function
  MPI_Op mpi_op;
  _XMP_setup_reduce_type(&mpi_datatype, &datatype_size, datatype);
  _XMP_setup_reduce_op(&mpi_op, op);

  // reduce
  MPI_Allreduce(MPI_IN_PLACE, data_addr, count, mpi_datatype, mpi_op, *((MPI_Comm *)(_XMP_get_execution_nodes())->comm));
}

void _XMP_reduce_FLMM_CLAUSE(void *data_addr, int count, int datatype, int op, int num_locs, ...) {
  _XMP_nodes_t *nodes = _XMP_get_execution_nodes();
  _XMP_ASSERT(nodes->is_member);

  // setup information
  MPI_Datatype mpi_datatype;
  size_t datatype_size; // not used in this function
  MPI_Op mpi_op;
  _XMP_setup_reduce_type(&mpi_datatype, &datatype_size, datatype);
  _XMP_setup_reduce_op(&mpi_op, op);

  // reduce <reduction-variable>
  size_t n = datatype_size * count;
  void *temp_buffer = _XMP_alloc(n);
  memcpy(temp_buffer, data_addr, n);

  MPI_Allreduce(temp_buffer, data_addr, count, mpi_datatype, mpi_op, *((MPI_Comm *)nodes->comm));

  // compare results
  n = sizeof(_Bool) * count;
  _Bool *cmp_buffer = _XMP_alloc(n);
  _XMP_compare_reduce_results(cmp_buffer, temp_buffer, data_addr, count, datatype);

  // reduce <location-variable>
  va_list args;
  va_start(args, num_locs);
  for (int i = 0; i < num_locs; i++) {
    void *loc = va_arg(args, void *);
    int loc_datatype = va_arg(args, int);

    _XMP_setup_reduce_type(&mpi_datatype, &datatype_size, loc_datatype);
    _XMP_setup_reduce_FLMM_op(&mpi_op, op);
    _XMP_init_localtion_variables(loc, count, loc_datatype, cmp_buffer, op);

    n = datatype_size * count;
    void *loc_temp = _XMP_alloc(n);
    memcpy(loc_temp, loc, n);

    MPI_Allreduce(loc_temp, loc, count, mpi_datatype, mpi_op, *((MPI_Comm *)nodes->comm));

    _XMP_free(loc_temp);
  }
  va_end(args);

  _XMP_free(temp_buffer);
  _XMP_free(cmp_buffer);
}

int _XMP_init_reduce_comm_NODES(_XMP_nodes_t *nodes, ...) {
  if (!nodes->is_member) {
    return _XMP_N_INT_FALSE;
  }

  int color = 1;
  int acc_nodes_size = 1;
  int nodes_dim = nodes->dim;

  va_list args;
  va_start(args, nodes);
  for (int i = 0; i < nodes_dim; i++) {
    int size = nodes->info[i].size;
    int rank = nodes->info[i].rank;

    if (va_arg(args, int) == 1) {
      color += (acc_nodes_size * rank);
    }

    acc_nodes_size *= size;
  }
  va_end(args);

  MPI_Comm *comm = _XMP_alloc(sizeof(MPI_Comm));
  MPI_Comm_split(*((MPI_Comm *)(_XMP_get_execution_nodes())->comm), color, nodes->comm_rank, comm);

  // create a new nodes descriptor
  _XMP_push_comm(comm);
  return _XMP_N_INT_TRUE;
}

int _XMP_init_reduce_comm_TEMPLATE(_XMP_template_t *template, ...) {
  _XMP_ASSERT(template->is_distributed);

  _XMP_nodes_t *onto_nodes = template->onto_nodes;
  if (!onto_nodes->is_member) {
    return _XMP_N_INT_FALSE;
  }

  int color = 1;
  int acc_nodes_size = 1;
  int template_dim = template->dim;

  va_list args;
  va_start(args, template);
  for (int i = 0; i < template_dim; i++) {
    _XMP_template_chunk_t *chunk = &(template->chunk[i]);

    int size, rank;
    if (chunk->dist_manner == _XMP_N_DIST_DUPLICATION) {
      size = 1;
      rank = 0;
    }
    else {
      _XMP_nodes_info_t *onto_nodes_info = chunk->onto_nodes_info;
      size = onto_nodes_info->size;
      rank = onto_nodes_info->rank;
    }

    if (va_arg(args, int) == 1) {
      color += (acc_nodes_size * rank);
    }

    acc_nodes_size *= size;
  }
  va_end(args);

  MPI_Comm *comm = _XMP_alloc(sizeof(MPI_Comm));
  MPI_Comm_split(*((MPI_Comm *)(_XMP_get_execution_nodes())->comm), color, onto_nodes->comm_rank, comm);

  // create a new nodes descriptor
  _XMP_push_comm(comm);
  return _XMP_N_INT_TRUE;
}
