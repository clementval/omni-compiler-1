#include <sys/stat.h>
#include "acc_internal.h"
#include "acc_internal_cl.h"
#include <stdio.h>


struct _ACC_kernel_type {
  char *name;
  cl_kernel kernel;
};

struct _ACC_program_type {
  cl_program program;
  int num_kernels;
  _ACC_kernel_t *kernels;
};

void _ACC_launch(_ACC_program_t *program, int kernel_num, int *_ACC_conf, int async_num, int num_args, unsigned long long/*instead of size_t*/ *arg_sizes, void **args)
{
  cl_kernel kernel = program->kernels[kernel_num].kernel;

  int i;
  for(i=0;i<num_args; i++){
    CL_CHECK(clSetKernelArg(kernel, i, arg_sizes[i], args[i]));
  }

  int num_gangs = _ACC_conf[0];
  int vector_length = _ACC_conf[2];
  size_t global_work_size = num_gangs * vector_length;
  size_t local_work_size = vector_length;

  _ACC_DEBUG("enqueue \"%s\" (%zd, %zd)\n", program->kernels[kernel_num].name,global_work_size, local_work_size)

  cl_event event;
  _ACC_queue_t *queue = _ACC_queue_map_get_queue(async_num);
  cl_command_queue command_queue = _ACC_queue_get_command_queue(queue);
  CL_CHECK(clEnqueueNDRangeKernel(command_queue, kernel, 1, NULL, &global_work_size, &local_work_size, 0, NULL, &event));
  //FIXME set last event  //_ACC_queue_set_last_event(event);

  //wait kernel execution
  if(async_num == ACC_ASYNC_SYNC){
    //CL_CHECK(clFlush(command_queue));
    CL_CHECK(clWaitForEvents(1, &event));
  }
}

void _ACC_program_init(_ACC_program_t **desc, char * kernel_src_filename, int num_kernels, char ** kernel_names)
{
  _ACC_program_t *program = _ACC_alloc(sizeof(_ACC_program_t));
  cl_int ret;
  int i;

  //open kernel file
  FILE *fp = fopen(kernel_src_filename, "r");
  if (fp == NULL){
    fprintf(stderr, "Faild to open kernel file.\n");
    exit(1);
  }

  //get kernel file size
  struct stat filestat;
  stat(kernel_src_filename, &filestat);

  //read kernel file
  size_t kernel_src_size = filestat.st_size;
  char *kernel_src = (char*)_ACC_alloc(sizeof(char)*(kernel_src_size));
  size_t read_byte = fread(kernel_src, sizeof(char), kernel_src_size, fp);

  //close kernel source file
  fclose(fp);

  //fprintf(stderr, "filesize = %ld\n", kernel_src_size);
  //fprintf(stderr, "read bytes %zd\n", read_byte);
  //fprintf(stderr, "%s\n", _kernel_src);

  //create program
  _ACC_DEBUG("create program \"%s\"\n", kernel_src_filename);
  
  program->program = clCreateProgramWithSource(_ACC_cl_current_context, 1, (const char **)&kernel_src, &kernel_src_size, &ret);
  CL_CHECK(ret);
  free(kernel_src);

  //build program
  char *build_option="-I/home/tabuchi/bin/xmp-git-pezy/include";
  ret = clBuildProgram(program->program, _ACC_cl_num_devices, _ACC_cl_device_ids, build_option,  NULL, NULL);
  if(ret != CL_SUCCESS){
    //print build error
    const int max_error_length = 1024;
    size_t returned_size;
    char *error_log = _ACC_alloc(sizeof(char) * max_error_length + 1);
    CL_CHECK(clGetProgramBuildInfo(program->program,
				   _ACC_cl_device_ids[_ACC_cl_device_num], 
				   CL_PROGRAM_BUILD_LOG,
				   max_error_length, error_log, &returned_size));
    fprintf(stderr, "build log:\n%s\n", error_log);
    _ACC_free(error_log);
    exit(1);
  }

  //create kernels
  program->kernels = _ACC_alloc(sizeof(_ACC_kernel_t) * num_kernels);
  for(i = 0; i < num_kernels; i++){
    _ACC_DEBUG("create kernel \"%s\"\n", kernel_names[i]);
    program->kernels[i].kernel = clCreateKernel(program->program, kernel_names[i], &ret);
    CL_CHECK(ret);
    program->kernels[i].name = kernel_names[i];
  }

  program->num_kernels = num_kernels;

  *desc = program;
}

void _ACC_program_finalize(_ACC_program_t *program)
{
  int i;
  for(i = 0; i < program->num_kernels; i++){
    CL_CHECK(clReleaseKernel(program->kernels[i].kernel));
  }
  _ACC_free(program->kernels);

  CL_CHECK(clReleaseProgram(program->program));

  _ACC_free(program);
}
