      program main
      include 'xmp_lib.h'
!$xmp nodes p(4,4)
!$xmp template t(:,:)
!$xmp distribute t(gblock(*),gblock(*)) onto p
      integer,parameter:: N=1000
      integer,allocatable:: m1(:), m2(:)
      integer s, remain
      integer,allocatable:: a(:,:)
!$xmp align a(i,j) with t(i,j)
      character(len=2) result

      if(xmp_num_nodes().ne.16) then
         print *, 'You have to run this program by 16 nodes.'
      endif

      allocate(m1(4), m2(4))
      remain = N
      do i=1, 3
         m1(i) = remain/2
         remain = remain-m1(i)
      enddo
      m1(4) = remain
      remain = N
      do i=1, 3
         m2(i) = remain/3
         remain = remain-m2(i)
      enddo
      m2(4) = remain
      
!$xmp template_fix (gblock(m1),gblock(m2)) t(N,N)
      allocate(a(N,N))

!$xmp loop (i,j) on t(i,j)
      do j=1, N
         do i=1, N
            a(i,j) = xmp_node_num()
         enddo
      enddo
         
      s = 0
!$xmp loop (i,j) on t(i,j) reduction(+: s)
      do j=1, N
         do i=1, N
            s = s+a(i,j)
         enddo
      enddo

      result = 'OK'
      if(s .ne. 45000000) then
         result = 'NG'
      endif

      print *, xmp_node_num(), 'testp008.f ', result
      deallocate(a, m1, m2)

      end