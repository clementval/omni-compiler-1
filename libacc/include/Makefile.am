include_HEADERS  = acc.h openacc.h

if CUDA
include_HEADERS += acc_gpu_func.hpp acc_gpu_reduction.hpp acc_gpu_atomic.hpp
endif

if OPENCL
include_HEADERS += acc_cl.h
endif

if PZCL
include_HEADERS += acc_pezy.hpp acc_pezy_util.hpp acc_pezy_reduction.hpp
endif
