#ifndef _ACC_PEZY_HEADER
#define _ACC_PEZY_HEADER

#include "pzc_builtin.h"
#include "acc_pezy_reduction.hpp"

//Macro
#define _ACC_M_FLOORi(a_, b_) ((a_) / (b_))
#define _ACC_M_COUNT_TRIPLETi(l_, u_, s_) ( ((u_) >= (l_))? _ACC_M_FLOORi((u_) - (l_), s_) + 1 : 0)
#define _ACC_M_CEILi(a_, b_) (((a_) % (b_)) == 0 ? ((a_) / (b_)) : ((a_) / (b_)) + 1)
#define _ACC_M_MAX(a_, b_) ((a_) > (b_) ? (a_) : (b_))
#define _ACC_M_MIN(a_, b_) ((a_) > (b_) ? (b_) : (a_))

template<typename T, typename T0>
static inline 
void _ACC_init_iter_block_thread_x(T *bt_idx, T *bt_cond, T *bt_step, T0 totalIter)
{
  T gang_size = _ACC_M_CEILi(totalIter, /*gridDim.x*/get_maxpid());
  *bt_idx  = gang_size * /*blockIdx.x*/get_pid() + /*threadIdx.x*/get_tid();
  *bt_cond = _ACC_M_MIN(gang_size * (/*blockIdx.x*/get_pid() + 1), totalIter);
  *bt_step = /*blockDim.x*/get_maxtid();
}

template<typename T, typename T0>
static inline
void _ACC_init_iter_block_x(T *gang_iter, T *gang_cond, T *gang_step, T0 totaliter){
  T0 gang_size = _ACC_M_CEILi(totaliter, /*gridDim.x*/get_maxpid());
  *gang_iter = gang_size * /*blockIdx.x*/get_pid();
  *gang_cond = _ACC_M_MIN(*gang_iter + gang_size, totaliter);
  *gang_step = 1;
}

template<typename T, typename T0>
static inline
void _ACC_init_iter_thread_x(T *iter, T *cond, T *step, T0 totaliter){
  *iter = /*threadIdx.x*/get_tid();
  *cond = totaliter;
  *step = /*blockDim.x*/get_maxtid();
}

template<typename T, typename T0, typename T1, typename T2>
static inline
void _ACC_calc_niter(T *niter, T0 init, T1 cond, T2 step)
{
  *niter = _ACC_M_COUNT_TRIPLETi(init, cond - 1, step);
}

template<typename T, typename T0, typename T1, typename T2, typename T3>
static inline
void _ACC_calc_idx(T id, T0 *idx, T1 lower, T2 upper, T3 stride)
{
  *idx = lower + stride * id;
}

static inline
void _ACC_sync_threads()
{
  sync_L1();
}

static inline
void _ACC_flush()
{
  flush();
}

#define _ACC_thread_x_id (get_tid())

#endif
