static char rcsid[] = "$Id$";
/* 
 * $TSUKUBA_Release: Omni OpenMP Compiler 3 $
 * $TSUKUBA_Copyright:
 *  PLEASE DESCRIBE LICENSE AGREEMENT HERE
 *  $
 */
/* error case of parallel for 004:
 * if ���Ф��ơ�parallel for ����ꤷ�����
 */

#include <omp.h>


main ()
{
  int	true = 1;

  #pragma omp parallel for
  if (true) {
    true = 0;
  }

  printf ("err_parallel_for 004 : FAILED, can not compile this program.\n");
  return 1;
}