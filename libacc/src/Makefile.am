ACC_INC_DIR=../include
CC=@MPI_CC@
GPUCC=@GPU_CMD@
GPUCFLAGS=@GPU_CFLAGS@
CUDA_DIR=@GPGPU_PREFIX@
AM_CFLAGS     = -I$(ACC_INC_DIR) @MPI_CFLAGS@
#COMPILE = $(CC) $(DEFS) $(DEFAULT_INCLUDES) $(INCLUDES) $(AM_CPPFLAGS) \
#	$(CPPFLAGS) $(AM_CFLAGS)
#LINK = $(CCLD) $(AM_CFLAGS) $(AM_LDFLAGS) $(LDFLAGS) -o $@

lib_LIBRARIES		= libacc.a libacc_cuda.a libacc_cl.a
libacc_a_SOURCES	= $(ACC_INC_DIR)/acc_internal.h $(ACC_INC_DIR)/acc_gpu_internal.h \
			  $(ACC_INC_DIR)/acc_gpu_constant.h $(ACC_INC_DIR)/acc_gpu_data_struct.h \
			  acc.c acc_memory_table.c acc_runtime.c acc_util.c acc_data.c acc_queue_map.c 
libacc_a_LIBADD		= acc.o acc_memory_table.o acc_runtime.o acc_util.o acc_data.o acc_queue_map.o


if CUDA
libacc_cuda_a_SOURCES	= acc_cuda.c acc_memory_cuda.c acc_queue_cuda.c acc_mpool_cuda.c acc_cuda_util.c acc_cuda_pack.cu
libacc_cuda_a_LIBADD	= acc_cuda.o acc_memory_cuda.o acc_queue_cuda.o acc_mpool_cuda.o acc_cuda_util.o acc_cuda_pack.o
AM_CFLAGS		+= -I$(CUDA_DIR)/include
endif

if OPENCL
libacc_cl_a_SOURCES	= acc_cl.c acc_memory_cl.c acc_queue_cl.c acc_kernel_cl.c
libacc_cl_a_LIBADD	= acc_cl.o acc_memory_cl.o acc_queue_cl.o acc_kernel_cl.o
endif

.cu.o:
	$(GPUCC) $(GPUCFLAGS) -I$(ACC_INC_DIR) -c -o $@ $<

