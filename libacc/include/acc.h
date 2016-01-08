#define ACC_ASYNC_SYNC (-1)
#define ACC_ASYNC_NOVAL (-2)

#ifdef __cplusplus
extern "C" {
#endif

void _ACC_init(int argc, char** argv);
void _ACC_finalize(void);

#ifdef __cplusplus
}
#endif
