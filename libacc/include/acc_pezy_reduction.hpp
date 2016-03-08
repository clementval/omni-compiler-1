#ifndef _ACC_PEZY_REDUCTION
#define  _ACC_PEZY_REDUCTION

#include "/home/tabuchi/test/reduction/pzc/red_org.cpp"

// these values are copied from /opt/pzsdk.ver2.1/inc/pzcl/cl_platform.h
#define INT_MAX          2147483647
#define INT_MIN          (-2147483647-1)
#define FLT_MAX          0x1.fffffep127f
#define FLT_MIN          0x1.0p-126f
#define DBL_MAX          0x1.fffffffffffffp1023
#define DBL_MIN          0x1.0p-1022

typedef enum {
  PLUS   = 0,
  MUL    = 1,
  MAX    = 2,
  MIN    = 3,
  BITAND = 4,
  BITOR  = 5,
  BITXOR = 6,
  LOGAND = 7,
  LOGOR  = 8,
} _ACC_reduction_kind;

static inline
int _ACC_reduction_op(int a, int b, _ACC_reduction_kind kind)
{
  switch(kind){
  case PLUS: return a + b;
  case MUL: return a * b;
  case MAX: return (a > b)? a : b;
  case MIN: return (a < b)? a : b;
  case BITAND: return a & b;
  case BITOR: return a | b;
  case BITXOR: return a ^ b;
  case LOGAND: return a && b;
  case LOGOR: return a || b;
  default: return a;
  }
}

template<typename T>
static inline
T _ACC_reduction_op(T a, T b, _ACC_reduction_kind kind)
{
  switch(kind){
  case PLUS: return a + b;
  case MUL: return a * b;
  case MAX: return (a > b)? a : b;
  case MIN: return (a < b)? a : b;
  default: return a;
  }
}

static inline
void _ACC_reduction_init(int* var, _ACC_reduction_kind kind)
{
  switch(kind){
  case PLUS: *var = 0; return;
  case MUL: *var = 1; return;
  case MAX: *var = INT_MIN; return;
  case MIN: *var = INT_MAX; return;
  case BITAND: *var = ~0; return;
  case BITOR: *var = 0; return;
  case BITXOR: *var = 0; return;
  case LOGAND: *var = 1; return;
  case LOGOR: *var = 0; return;
  }
}

static inline
void _ACC_reduction_init(float* var, _ACC_reduction_kind kind)
{
  switch(kind){
  case PLUS: *var = 0.0f; return;
  case MUL: *var = 1.0f; return;
  case MAX: *var = FLT_MIN; return;
  case MIN: *var = FLT_MAX; return;
  default: return;
  }
}

static inline
void _ACC_reduction_init(double* var, _ACC_reduction_kind kind)
{
  switch(kind){
  case PLUS: *var = 0.0; return;
  case MUL: *var = 1.0; return;
  case MAX: *var = DBL_MIN; return;
  case MIN: *var = DBL_MAX; return;
  default: return;
  }
}


template<typename T>
static inline
void _ACC_pezy_reduction_thread(T* r, T v, _ACC_reduction_kind kind)
{
  // 全スレッドで実行する
  const T tmp = ReductionPe(v);

#if 0
  // なぜかこちらだとエラーが出る
  if(get_tid() == 0){
    *r = _ACC_reduction_op(*r, tmp, kind);
  }
#else
  *r = _ACC_reduction_op(*r, tmp, kind);
#endif
}

template<typename T>
static inline
void _ACC_pezy_reduction_pe(T* r, T v, _ACC_reduction_kind kind)
{
  //全PEで実行する
  const int tid    = get_tid();
  const int maxtid = get_maxtid();
  int pid = get_pid(); //  % MAX_CITY_NUM;
  int pidCity = pid / MAX_CITY_NUM * MAX_CITY_NUM;
	
  static T tmp[ 1024 ];
	
  // 1 個書く
  if ( 0 == tid )
    {
      tmp[ pid ] = v;
    }
	
  flush_L1();
	
  wait_city();
	
  int offset = pidCity;
  do_prefetch_L1( &tmp[ offset + tid          ], 0 );
	
	
  T sum = 0;
  if ( pid == pidCity )
    {
      sum = _ACC_reduction_op(sum, tmp[ offset + tid          ], kind);
      sum = _ACC_reduction_op(sum, tmp[ offset + tid + maxtid ], kind);

      // もう一回まとめる
      sum = ReductionPe( sum );
    }

  wait_city();
	
  if( pid == pidCity && tid == 0){
    *r = _ACC_reduction_op(*r, sum, kind);
  }
}



//interface
template<typename T>
static inline
void _ACC_gpu_init_reduction_var(T* v, int kind)
{
  _ACC_reduction_init(v, static_cast<_ACC_reduction_kind>(kind));
}
template<typename T>
static inline
void _ACC_gpu_reduction_thread(T* r, T v, int kind)
{
  _ACC_pezy_reduction_thread(r, v, static_cast<_ACC_reduction_kind>(kind));
}
template<typename T>
static inline
void _ACC_gpu_reduction_block(T* r, int kind, T v)
{
  _ACC_pezy_reduction_pe(r, v, static_cast<_ACC_reduction_kind>(kind));
}



// //いらない
// template<typename T>
// static inline
// void _ACC_gpu_reduction_bt(T* r, T v, int kind)
// {
//   //全PEで実行する (GPUでは1blockのみ)
//   T tmp = ReductionCityForPeSingle(v);
//   int offset = get_tid() + get_maxtid() * get_pid();
//   if(get_pid() == 0 && get_tid() == 0){
//     *r = _ACC_reduction_op(*r, tmp, kind); //op
//   }
// }

#endif //_ACC_PEZY_REDUCTION
