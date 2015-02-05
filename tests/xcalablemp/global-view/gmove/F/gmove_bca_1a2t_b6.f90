program tgmove
integer :: i
integer,parameter :: n=4
integer a(n),b(n)
!$xmp nodes p(2)
!$xmp template tx(n,n)
!$xmp template ty(n,n)
!$xmp distribute tx(block,*) onto p
!$xmp distribute ty(*,block) onto p
!$xmp align a(i0) with tx(i0,*)
!$xmp align b(i1) with ty(*,i1)

!$xmp loop (i0) on tx(i0,*)
do i0=1,n
  a(i0)=i0
end do

!$xmp loop (i1) on ty(*,i1)
do i1=1,n
  b(i1)=0
end do

!$xmp gmove
b(1:n)=a(1:n)

myrank=xmp_node_num()
ierr=0
!$xmp loop (i1) on ty(*,i1)
do i1=1,n
  ierr=ierr+abs(b(i1)-i1)
end do

!$xmp reduction (+:ierr)
call chk_int(ierr)

stop
end program
