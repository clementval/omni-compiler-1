module mod1
  interface mpi_abort
    subroutine mpi_abort(comm, errorcode, ierror)
      integer, intent(in) :: comm
      integer, intent(in) :: errorcode
      integer, intent(out) :: ierror
    end subroutine mpi_abort
  end interface
end module mod1
