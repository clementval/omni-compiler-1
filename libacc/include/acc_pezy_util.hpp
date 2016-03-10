#ifndef _ACC_PEZY_UTIL
#define _ACC_PEZY_UTIL


// these values are copied from /opt/pzsdk.ver2.1/inc/pzcl/cl_platform.h
#define INT_MAX          2147483647
#define INT_MIN          (-2147483647-1)
#define FLT_MAX          0x1.fffffep127f
#define FLT_MIN          0x1.0p-126f
#define DBL_MAX          0x1.fffffffffffffp1023
#define DBL_MIN          0x1.0p-1022
// end cl_platform.h


// these funcitons are copied from pzcutil.h
inline void wait_pe( void )
{
  __asm__ __volatile__( "c.sync 1" );
}
inline void wait_prefecture( void )
{
  __asm__ __volatile__( "c.sync 4" );
}
#define wait_village sync_L1
#define wait_city    sync_L2
volatile
inline void do_prefetch_L1( const void* a, int offset )
{
        // c.prefetch level, addr
        asm volatile("c.prefetch 1 %0 %1" :: "p"(a), "i"(offset));
}
volatile
static
inline void f_ld( const void * ptr, int offset, float& d  )
{
	asm volatile( "f.ld %0 %1,%2;": "=w"(d):"p"(ptr), "i"(offset) );
}


volatile
static
inline void f_sw( void * ptr, int offset, float d  )
{
	asm volatile( "f.sw %0,%1, %2 ": :"p"(ptr),"i"(offset), "w"(d) );
}



volatile
static
inline void d_ld( const void * ptr, int offset, double& d  )
{
	asm volatile( "d.ldd %0 %1,%2;": "=w"(d):"p"(ptr), "i"(offset) );
}


volatile
static
inline void d_sd( void * ptr, int offset, double d  )
{
	asm volatile( "d.sd %0,%1, %2 ": :"p"(ptr),"i"(offset), "w"(d) );
}

volatile
static
inline void f_ld( volatile const void * ptr, int offset, float& d  )
{
	asm volatile( "f.ld %0 %1,%2;": "=w"(d):"p"(ptr), "i"(offset) );
}


volatile
static
inline void f_sw( volatile void * ptr, int offset, float d  )
{
	asm volatile( "f.sw %0,%1, %2 ": :"p"(ptr),"i"(offset), "w"(d) );
}



volatile
static
inline void d_ld( volatile const void * ptr, int offset, double& d  )
{
	asm volatile( "d.ldd %0 %1,%2;": "=w"(d):"p"(ptr), "i"(offset) );
}


volatile
static
inline void d_sd( volatile void * ptr, int offset, double d  )
{
	asm volatile( "d.sd %0,%1, %2 ": :"p"(ptr),"i"(offset), "w"(d) );
}
// end pzcutil.h

////////////////////////////////////////////////////////////////////////////////
// these functions are copied from reduction.pzc
volatile
static
inline void f_ld_add( const void * ptr, int offset, float& d, float&o, float a, float b  )
{
//	asm volatile( "f.ld %0 %2,%3; f.add %1 %1 %4": "=w"(d),"=w"(o):"p"(ptr), "i"(offset),"w"(a), "w"(b) );
	asm volatile( "f.add %0 %4 %5; f.ld %1 %2,%3;": "=w"(o), "=w"(d): "p"(ptr), "i"(offset),"w"(a), "w"(b) );
}

volatile
static
inline void d_ld_add( const void * ptr, int offset, double& d, double&o, double a, double b  )
{
//	asm volatile( "f.ld %0 %2,%3; f.add %1 %1 %4": "=w"(d),"=w"(o):"p"(ptr), "i"(offset),"w"(a), "w"(b) );
	asm volatile( "d.add %0 %4 %5; d.ldd %1 %2,%3;": "=w"(o), "=w"(d): "p"(ptr), "i"(offset),"w"(a), "w"(b) );
}

volatile
static
inline void f_ld_add( volatile const void * ptr, int offset, float& d, float&o, float a, float b  )
{
//	asm volatile( "f.ld %0 %2,%3; f.add %1 %1 %4": "=w"(d),"=w"(o):"p"(ptr), "i"(offset),"w"(a), "w"(b) );
	asm volatile( "f.add %0 %4 %5; f.ld %1 %2,%3;": "=w"(o), "=w"(d): "p"(ptr), "i"(offset),"w"(a), "w"(b) );
}

volatile
static
inline void d_ld_add( volatile const void * ptr, int offset, double& d, double&o, double a, double b  )
{
//	asm volatile( "f.ld %0 %2,%3; f.add %1 %1 %4": "=w"(d),"=w"(o):"p"(ptr), "i"(offset),"w"(a), "w"(b) );
	asm volatile( "d.add %0 %4 %5; d.ldd %1 %2,%3;": "=w"(o), "=w"(d): "p"(ptr), "i"(offset),"w"(a), "w"(b) );
}

volatile
static
inline void f_ld_nop( const void * ptr, int offset, float& d  )
{
	asm volatile( "f.ld %0 %1,%2;c.nop;": "=w"(d):"p"(ptr), "i"(offset) );
}

volatile
static
inline void d_ld_nop( const void * ptr, int offset, double& d  )
{
	asm volatile( "d.ldd %0 %1,%2;c.nop;": "=w"(d):"p"(ptr), "i"(offset) );
}
// end reduction.pzc
////////////////////////////////////////////////////////////////////////////////

#endif // _ACC_PEZY_UTIL
