program test_inquiry
include 'xmp_lib.h'
integer*8 xmp_desc_of
integer ierr, irank, error
integer xmp_node_num
type(xmp_desc) dt, dt1, dn, dn1, dn2
integer lb(3),ub(3), st(3)
integer ival
logical lval
integer map(2)
integer a(6,9,16), a1(6), b(6)
integer m(2)=(/2,4/)
!$xmp nodes p(2,3,2)
!$xmp nodes p1(2)=p(1:2,1,1)
!$xmp template t(16,6,9)
!$xmp template t1(6)
!$xmp template t2(:)
!$xmp distribute t(block, cyclic, cyclic(2)) onto p
!$xmp distribute t1(gblock(m)) onto p1
!$xmp distribute t2(block) onto p1
!$xmp align a(i0,i1,i2) with t(i2,i0,i1)
!$xmp align a1(i0) with t1(i0)
!$xmp align b(i0) with t(i0,*,*)
!$xmp shadow a(1:2,0,0)

error=0
ierr=xmp_align_template(xmp_desc_of(a), dt)
ierr=xmp_dist_nodes(dt, dn)
ierr=xmp_align_template(xmp_desc_of(a1), dt1)
ierr=xmp_dist_nodes(dt1, dn1)
irank=xmp_node_num()

ierr=xmp_template_fixed(xmp_desc_of(t2),lval)
call check(lval, 0, error)

!$xmp template_fix(block) t2(6)

if (irank==11) then
  ierr=xmp_nodes_equiv(dn1, dn2, lb, ub, st)
  call check(lb(1), 1, error)
  call check(ub(1), 2, error)
  call check(st(1), 1, error)
  ierr=xmp_nodes_ndims(dn, ival)
  call check(ival, 3, error)

  ierr=xmp_nodes_index(dn, 1, ival)
  call check(ival, 1, error)
  ierr=xmp_nodes_index(dn, 2, ival)
  call check(ival, 3, error)
  ierr=xmp_nodes_index(dn, 3, ival)
  call check(ival, 2, error)

  ierr=xmp_nodes_size(dn, 1, ival)
  call check(ival, 2, error)
  ierr=xmp_nodes_size(dn, 2, ival)
  call check(ival, 3, error)
  ierr=xmp_nodes_size(dn, 3, ival)
  call check(ival, 2, error)

  !ierr=xmp_nodes_attr(dn, attr)
  !ierr=xmp_nodes_attr(dn1, attr)

  ierr=xmp_template_fixed(xmp_desc_of(t2),lval)
  call check(lval, 1, error)
  ierr=xmp_template_ndims(dt, ival)
  call check(ival, 3, error)
  ierr=xmp_template_lbound(dt, 1, ival)
  call check(ival, 1, error)
  ierr=xmp_template_lbound(dt, 2, ival)
  call check(ival, 1, error)
  ierr=xmp_template_lbound(dt, 3, ival)
  call check(ival, 1, error)
  ierr=xmp_template_ubound(dt, 1, ival)
  call check(ival, 16, error)
  ierr=xmp_template_ubound(dt, 2, ival)
  call check(ival, 6, error)
  ierr=xmp_template_ubound(dt, 3, ival)
  call check(ival, 9, error)
  ierr=xmp_dist_format(dt, 1, ival)
  call check(ival, 2101, error)
  ierr=xmp_dist_format(dt, 2, ival)
  call check(ival, 2102, error)
  ierr=xmp_dist_format(dt, 3, ival)
  call check(ival, 2102, error)
  ierr=xmp_dist_blocksize(dt, 1, ival)
  call check(ival, 8, error)
  ierr=xmp_dist_blocksize(dt, 2, ival)
  call check(ival, 1, error)
  ierr=xmp_dist_blocksize(dt, 3, ival)
  call check(ival, 2, error)
  ierr=xmp_dist_gblockmap(dt1, 1, map)
  call check(map(1), 2, error)
  call check(map(2), 4, error)
  ierr=xmp_dist_axis(dt, 1, ival)
  call check(ival, 1, error)
  ierr=xmp_dist_axis(dt, 2, ival)
  call check(ival, 2, error)
  ierr=xmp_dist_axis(dt, 3, ival)
  call check(ival, 3, error)

  ierr=xmp_align_axis(xmp_desc_of(a), 1, ival)
  call check(ival, 2, error)
  ierr=xmp_align_axis(xmp_desc_of(a), 2, ival)
  call check(ival, 3, error)
  ierr=xmp_align_axis(xmp_desc_of(a), 3, ival)
  call check(ival, 1, error)
  ierr=xmp_align_offset(xmp_desc_of(a), 1, ival)
  call check(ival, 0, error)
  ierr=xmp_align_offset(xmp_desc_of(a), 2, ival)
  call check(ival, 0, error)
  ierr=xmp_align_offset(xmp_desc_of(a), 3, ival)
  call check(ival, 0, error)
  ierr=xmp_align_replicated(xmp_desc_of(b), 1, lval)
  call check(lval, 0, error)
  ierr=xmp_align_replicated(xmp_desc_of(b), 2, lval)
  call check(lval, 1, error)
  ierr=xmp_align_replicated(xmp_desc_of(b), 3, lval)
  call check(lval, 1, error)
  ierr=xmp_array_ndims(xmp_desc_of(a), ival)
  call check(ival, 3, error)
  ierr=xmp_array_lbound(xmp_desc_of(a), 1, ival)
  call check(ival, 1, error)
  ierr=xmp_array_lbound(xmp_desc_of(a), 2, ival)
  call check(ival, 1, error)
  ierr=xmp_array_lbound(xmp_desc_of(a), 3, ival)
  call check(ival, 1, error)
  ierr=xmp_array_ubound(xmp_desc_of(a), 1, ival)
  call check(ival, 6, error)
  ierr=xmp_array_ubound(xmp_desc_of(a), 2, ival)
  call check(ival, 9, error)
  ierr=xmp_array_ubound(xmp_desc_of(a), 3, ival)
  call check(ival, 16, error)
  ierr=xmp_array_lshadow(xmp_desc_of(a), 1, ival)
  call check(ival, 1, error)
  ierr=xmp_array_ushadow(xmp_desc_of(a), 1, ival)
  call check(ival, 2, error)

  if ( error .eq. 0 ) then
     write(*,*) "PASS"
  else
     write(*,*) "ERROR"
     call exit(1)
  endif
end if

end program test_inquiry

subroutine check(iresult,ians,error)
  integer irslt,ians,error
  !print *, 'result=',irslt,'answer',ians
  if(iresult .ne. ians) then
    error=error+1
  end if
end subroutine