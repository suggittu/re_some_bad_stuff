
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void more_suspect_thing_ever(char *param_1,undefined4 param_2,undefined8 *param_3)

{
  uint uVar1;
  bool bVar2;
  bool bVar3;
  bool bVar4;
  int iVar5;
  int iVar6;
  __pid_t pid_child;
  int iVar7;
  __pid_t _Var8;
  uint fd_pty_master;
  uint uVar14;
  long __number;
  size_t size_path;
  char *path2;
  size_t sVar9;
  passwd *ppVar10;
  uint *puVar11;
  ssize_t sVar12;
  size_t sVar13;
  undefined8 *puVar15;
  int iVar16;
  ulong uVar17;
  ulong uVar18;
  ulong uVar19;
  undefined1 *__number;
  bool bVar20;
  undefined8 uVar21;
  uint local_114c;
  int local_1148;
  uint copy_fd_master;
  uint local_1140;
  int local_113c;
  uint local_1138;
  int local_1134;
  short local_1130;
  short local_112e;
  short buf4;
  short local_1126;
  timeval local_1120;
  fd_set buf1;
  fd_set buf2;
  undefined1 buf3 [4104];
  undefined8 local_8;
  undefined8 *__number;
  int copy_of_number;
  long other_number;
  char *path_some_binaries;
  
  local_8 = ___stack_chk_guard;
  iVar5 = search_avaible_shell();
  if (iVar5 == 0) {
                    /* WARNING: Subroutine does not return */
    wrapper_wrapper_torewhatch();
  }
  iVar5 = -1;
  wrapper_torewhatch(1,&su_from,&su_to);
  if (config_log != 0) {
    iVar5 = try_create_log_return_fd(1,&su_from);
  }
  iVar6 = attach_to_current_mnt(param_2,0);
  path2 = strrchr(param_1,0x2f);
  path_some_binaries = PTR_s__system_bin_sh_0012a058;
  copy_of_number = strcmp(PTR_s__system_bin_sh_0012a058,"/system/bin/sh");
  if (copy_of_number == 0) {
    copy_of_number = some_number_container + 2;
    other_number = -((-(ulong)(some_number_container + 3 >> 0x1f) & 0xfffffff800000000 |
                     (ulong)(some_number_container + 3) << 3) + 0x16 & 0xfffffffffffffff0);
    __number = &stack0xffffffffffffede0 + other_number;
    *(char **)(&stack0xffffffffffffede0 + other_number) = path2 + 1;
    *(undefined **)(&stack0xffffffffffffede8 + other_number) = &DAT_00114058;
    if (0 < (int)some_number_container) {
      __number = ((long)DAT_0012a074 + 2) * 8;
      __number = (undefined8 *)(DAT_0012a068 + __number + -0x10);
      if ((__number < &stack0xffffffffffffee00 + other_number &&
           &stack0xffffffffffffedf0 + other_number < (undefined8 *)(DAT_0012a068 + __number)) ||
         (some_number_container < 0xb)) {
        __number = 0;
        do {
          iVar7 = (int)__number;
          puVar15 = __number + __number;
          __number = __number + 1;
          *(undefined8 *)(&stack0xffffffffffffede0 + (long)(iVar7 + 2) * 8 + other_number) =
               *puVar15;
        } while ((int)__number < (int)some_number_container);
        bVar2 = true;
        goto LAB_00110a28;
      }
      uVar14 = (some_number_container - 2 >> 1) + 1;
      uVar1 = uVar14 * 2;
      fd_pty_master = 0;
      puVar15 = (undefined8 *)(&stack0xffffffffffffedf0 + other_number);
      do {
        uVar21 = *__number;
        fd_pty_master = fd_pty_master + 1;
        puVar15[1] = __number[1];
        *puVar15 = uVar21;
        puVar15 = puVar15 + 2;
        __number = __number + 2;
      } while (fd_pty_master < uVar14);
      if (some_number_container != uVar1) {
        *(undefined8 *)(&stack0xffffffffffffede0 + (long)(int)(uVar1 + 2) * 8 + other_number) =
             *(undefined8 *)(DAT_0012a068 + (long)(int)(uVar1 + DAT_0012a074) * 8);
      }
    }
    bVar2 = true;
    __number = &stack0xffffffffffffede0 + other_number;
  }
  else {
    copy_of_number = some_number_container + 3;
    other_number = -((-(ulong)(some_number_container + 4 >> 0x1f) & 0xfffffff800000000 |
                     (ulong)(some_number_container + 4) << 3) + 0x16 & 0xfffffffffffffff0);
    __number = &stack0xffffffffffffede0 + other_number;
    *(char **)(&stack0xffffffffffffede0 + other_number) = path2 + 1;
    *(char **)(&stack0xffffffffffffede8 + other_number) = "-c";
    *(char **)(&stack0xffffffffffffedf0 + other_number) = path_some_binaries;
    if (0 < (int)some_number_container) {
      __number = ((long)DAT_0012a074 + 2) * 8;
      __number = (undefined8 *)(DAT_0012a068 + __number + -0x10);
      if ((__number < &stack0xffffffffffffee08 + other_number &&
           &stack0xffffffffffffedf8 + other_number < (undefined8 *)(DAT_0012a068 + __number)) ||
         (some_number_container < 0xb)) {
        __number = 0;
        do {
          iVar7 = (int)__number;
          puVar15 = __number + __number;
          __number = __number + 1;
          *(undefined8 *)(&stack0xffffffffffffede0 + (long)(iVar7 + 3) * 8 + other_number) =
               *puVar15;
        } while ((int)__number < (int)some_number_container);
      }
      else {
        fd_pty_master = 0;
        uVar14 = (some_number_container - 2 >> 1) + 1;
        uVar1 = uVar14 * 2;
        puVar15 = (undefined8 *)(&stack0xffffffffffffedf8 + other_number);
        do {
          uVar21 = *__number;
          fd_pty_master = fd_pty_master + 1;
          puVar15[1] = __number[1];
          *puVar15 = uVar21;
          puVar15 = puVar15 + 2;
          __number = __number + 2;
        } while (fd_pty_master < uVar14);
        if (uVar1 != some_number_container) {
          *(undefined8 *)(&stack0xffffffffffffede0 + (long)(int)(uVar1 + 3) * 8 + other_number) =
               *(undefined8 *)(DAT_0012a068 + (long)(int)(uVar1 + DAT_0012a074) * 8);
        }
      }
    }
    bVar2 = false;
  }
LAB_00110a28:
  *(undefined8 *)(__number + (long)copy_of_number * 8) = 0;
  if (config_in_server != 0) {
    path_some_binaries = (char *)*param_3;
    while (path_some_binaries != (char *)0x0) {
      putenv(path_some_binaries);
      param_3 = param_3 + 1;
      path_some_binaries = (char *)*param_3;
    }
    if (systemless_used_default == 0) {
      if (systemless_used_sbin != 0) {
        path_some_binaries = getenv("PATH");
        size_path = strlen(path_some_binaries);
        path2 = (char *)memset_wrapper(size_path + 1);
        size_path = strlen(path_some_binaries);
        memcpy(path2,path_some_binaries,size_path + 1);
        if (path2 != (char *)0x0) {
          path_some_binaries = strstr(path2,"/sbin/supersu/bin:");
          if (((path_some_binaries == (char *)0x0) &&
              (path_some_binaries = strstr(path2,"/sbin:"), path_some_binaries != (char *)0x0)) &&
             (copy_of_number = (int)((long)path_some_binaries - (long)path2), -1 < copy_of_number))
          {
            size_path = strlen(path2);
            sVar9 = strlen("/sbin:");
            iVar7 = (int)sVar9 + copy_of_number;
            sVar13 = strlen("/sbin/supersu/bin:");
            iVar16 = (int)sVar13;
            sVar13 = (size_t)iVar7;
            path_some_binaries = (char *)memset_wrapper((long)(iVar16 + (int)size_path + 1));
            memcpy(path_some_binaries,path2,sVar13);
            memcpy(path_some_binaries + sVar13,"/sbin/supersu/bin:",(long)iVar16);
            memcpy(path_some_binaries + (iVar7 + iVar16),path2 + sVar13,
                   (long)((((int)size_path - (int)sVar9) - copy_of_number) + 1));
            free(path2);
            path2 = strstr(path_some_binaries,":/sbin/supersu/xbin");
            if (path2 == (char *)0x0) {
              bVar3 = true;
LAB_00110ae8:
              path2 = strstr(path_some_binaries,":/system/xbin");
              size_path = strlen(path_some_binaries);
              sVar9 = strlen(":/sbin/supersu/xbin");
              copy_of_number = (int)sVar9;
              iVar7 = (int)size_path;
              if (path2 == (char *)0x0) {
                path2 = (char *)memset_wrapper((long)(copy_of_number + iVar7 + 1));
                memcpy(path2,path_some_binaries,(long)iVar7);
                memcpy(path2 + iVar7,":/sbin/supersu/xbin",(long)copy_of_number);
                free(path_some_binaries);
                path_some_binaries = path2;
              }
              else {
                iVar16 = (int)path2 - (int)path_some_binaries;
                if (iVar16 < 1) {
                  if (!bVar3) goto LAB_00110bd8;
                }
                else {
                  size_path = (size_t)iVar16;
                  path2 = (char *)memset_wrapper((long)(copy_of_number + iVar7 + 1));
                  memcpy(path2,path_some_binaries,size_path);
                  memcpy(path2 + size_path,":/sbin/supersu/xbin",(long)copy_of_number);
                  memcpy(path2 + (iVar16 + copy_of_number),path_some_binaries + size_path,
                         (long)((iVar7 - iVar16) + 1));
                  free(path_some_binaries);
                  path_some_binaries = path2;
                }
              }
            }
            setenv("PATH",path_some_binaries,1);
          }
          else {
            path_some_binaries = strstr(path2,":/sbin/supersu/xbin");
            if (path_some_binaries == (char *)0x0) {
              bVar3 = false;
              path_some_binaries = path2;
              goto LAB_00110ae8;
            }
          }
        }
      }
    }
    else {
      path_some_binaries = getenv("PATH");
      size_path = strlen(path_some_binaries);
      path2 = (char *)memset_wrapper(size_path + 1);
      size_path = strlen(path_some_binaries);
      memcpy(path2,path_some_binaries,size_path + 1);
      if (path2 != (char *)0x0) {
        path_some_binaries = strstr(path2,"/su/bin:");
        if (path_some_binaries == (char *)0x0) {
          size_path = strlen(path2);
          sVar9 = strlen("/su/bin:");
          copy_of_number = (int)sVar9;
          path_some_binaries = (char *)memset_wrapper((long)(copy_of_number + (int)size_path + 1));
          memcpy(path_some_binaries,"/su/bin:",(long)copy_of_number);
          memcpy(path_some_binaries + copy_of_number,path2,(long)((int)size_path + 1));
          free(path2);
          path2 = strstr(path_some_binaries,":/su/xbin");
          if ((path2 == (char *)0x0) &&
             (path2 = strstr(path_some_binaries,":/system/xbin"), path2 != (char *)0x0)) {
            size_path = strlen(path_some_binaries);
            copy_of_number = (int)size_path;
            size_path = strlen(":/su/xbin");
            iVar7 = (int)size_path;
            iVar16 = (int)path2 - (int)path_some_binaries;
            if (0 < iVar16) goto LAB_00111108;
          }
LAB_001111a8:
          setenv("PATH",path_some_binaries,1);
        }
        else {
          path_some_binaries = strstr(path2,":/su/xbin");
          if ((path_some_binaries == (char *)0x0) &&
             (path_some_binaries = strstr(path2,":/system/xbin"), path_some_binaries != (char *)0x0)
             ) {
            size_path = strlen(path2);
            copy_of_number = (int)size_path;
            size_path = strlen(":/su/xbin");
            iVar7 = (int)size_path;
            iVar16 = (int)path_some_binaries - (int)path2;
            path_some_binaries = path2;
            if (0 < iVar16) {
LAB_00111108:
              size_path = (size_t)iVar16;
              path2 = (char *)memset_wrapper((long)(iVar7 + copy_of_number + 1));
              memcpy(path2,path_some_binaries,size_path);
              memcpy(path2 + size_path,":/su/xbin",(long)iVar7);
              memcpy(path2 + (iVar16 + iVar7),path_some_binaries + size_path,
                     (long)((copy_of_number - iVar16) + 1));
              free(path_some_binaries);
              path_some_binaries = path2;
              goto LAB_001111a8;
            }
          }
        }
      }
    }
  }
LAB_00110bd8:
  copy_of_number = bits64_sdk;
  if (bits64_sdk == 0) {
    copy_of_number = putenv("LD_LIBRARY_PATH=/vendor/lib:/system/lib");
  }
  path_some_binaries = (char *)check_Set_ld_library(copy_of_number);
  if (path_some_binaries != (char *)0x0) {
    putenv(path_some_binaries);
  }
  if ((DAT_0012a060 != 1) && (ppVar10 = getpwuid(su_to), ppVar10 != (passwd *)0x0)) {
    setenv("HOME",ppVar10->pw_dir,1);
    setenv("SHELL",param_1,1);
    if ((bVar2) || (su_to != 0)) {
      setenv("USER",ppVar10->pw_name,1);
      setenv("LOGNAME",ppVar10->pw_name,1);
    }
  }
  path_some_binaries = PTR_s__system_bin_sh_0012a058;
  if (((iVar5 < 0) || (config_log < 2)) && (config_server_pty == 0)) {
    if (-1 < iVar5) {
      close(iVar5);
    }
    if ((iVar6 != 0) &&
       (iVar5 = execv_sh_with_obfuscated_command(param_1,param_2,__number), iVar5 != -1))
    goto LAB_00110fac;
    pid_child = fork();
    if (pid_child == -1) goto LAB_00110db8;
    if (pid_child != 0) {
      pid_child = waitpid(pid_child,(int *)&local_1120,0);
      if ((pid_child == -1) ||
         (uVar14 = (uint)((ulong)local_1120.tv_sec >> 8) & 0xffffff,
         (local_1120.tv_sec & 0x7fU) != 0)) goto LAB_00110fac;
      goto LAB_0011100c;
    }
LAB_00110da8:
    execv_sh_with_obfuscated_command(param_1,param_2,__number);
LAB_00110db8:
                    /* WARNING: Subroutine does not return */
    exit(1);
  }
  if ((config_log != 2) && (config_server_pty == 0)) goto LAB_00110fac;
  size_path = (size_t)config_logsize;
  other_number = -(size_path + 0xf & 0xfffffffffffffff0);
  bVar3 = config_server_pty != 0 && config_log != 2;
  bVar2 = config_server_pty == 0 || config_log == 2;
  iVar6 = strcmp(PTR_s__system_bin_sh_0012a058,"/system/bin/sh");
  if (iVar6 == 0) {
    snprintf(__number + other_number,size_path,"%s\n","INTERACTIVE");
  }
  else {
    snprintf(__number + other_number,size_path,"%s\n",path_some_binaries);
  }
  if (bVar2) {
    size_path = strlen(__number + other_number);
    write(iVar5,__number + other_number,size_path);
  }
  iVar6 = isatty(0);
  uVar14 = 0xffffffff;
  if ((iVar6 == 0) ||
     (fd_pty_master = open("/dev/ptmx",2), uVar14 = fd_pty_master, (int)fd_pty_master < 0)) {
LAB_00110d30:
    pipe(&local_1148);
    pipe((int *)&local_1140);
    pipe((int *)&local_1138);
    pid_child = fork();
    if (pid_child == -1) goto LAB_00110db8;
    if (pid_child == 0) {
      similare_to_cmp(local_1148,0);
      similare_to_cmp(local_113c,1);
      similare_to_cmp(local_1134,2);
      close(copy_fd_master);
      close(local_1140);
      close(local_1138);
      goto LAB_00110da8;
    }
    bVar4 = false;
    close(local_1148);
    close(local_113c);
    close(local_1134);
    fd_pty_master = uVar14;
  }
  else {
    fcntl(fd_pty_master,2,1);
    iVar6 = grantpt(fd_pty_master);
    if ((iVar6 != 0) ||
       ((iVar6 = unlockpt(fd_pty_master), iVar6 != 0 ||
        (path_some_binaries = (char *)get_name_slave(fd_pty_master),
        path_some_binaries == (char *)0x0)))) {
      uVar14 = 0xffffffff;
      close(fd_pty_master);
      goto LAB_00110d30;
    }
    iVar6 = ioctl(0,21523,&local_1130);
    if (-1 < iVar6) {
      ioctl(fd_pty_master,21524,&local_1130);
    }
    pid_child = fork();
    if (pid_child == -1) goto LAB_00110db8;
    if (pid_child == 0) {
      close(fd_pty_master);
      setsid();
      iVar5 = open(path_some_binaries,2);
      if (iVar5 < 0) {
                    /* WARNING: Subroutine does not return */
        exit(-1);
      }
      similare_to_cmp(iVar5,0);
      similare_to_cmp(iVar5,1);
      similare_to_cmp(iVar5,2);
      free(path_some_binaries);
      goto LAB_00110da8;
    }
    local_1138 = 0xffffffff;
    copy_fd_master = fd_pty_master;
    local_1140 = fd_pty_master;
    iVar6 = tcgetattr(0,(termios *)&buf2);
    if (iVar6 != -1) {
      buf2.fds_bits[1]._4_4_ = buf2.fds_bits[1]._4_4_ & 0xffff7ff4;
      buf2.fds_bits[0]._4_4_ = buf2.fds_bits[0]._4_4_ & 0xfffffffe;
      buf2.fds_bits[0]._0_4_ = (uint)buf2.fds_bits[0] & 0xfffffa04;
      buf2.fds_bits[2]._7_1_ = '\x01';
      buf2.fds_bits[2]._6_1_ = '\0';
      tcsetattr(0,1,(termios *)&buf2);
    }
    bVar4 = true;
    free(path_some_binaries);
  }
  bVar20 = false;
  iVar6 = 0;
  local_114c = 0xffffffff;
  copy_of_number = iVar6;
  do {
    while( true ) {
      while( true ) {
        memset(&buf1,0,0x80);
        memset(&buf2,0,0x80);
        if (!bVar20) {
          buf1.fds_bits[0] = buf1.fds_bits[0] | 1;
        }
        uVar18 = 1L << (local_1140 & 0x3f);
        uVar17 = (ulong)(long)(int)local_1140 >> 6;
        buf1.fds_bits[uVar17] = buf1.fds_bits[uVar17] | uVar18;
        if (bVar4) {
          local_1120.tv_sec = 0;
          buf2.fds_bits[uVar17] = buf2.fds_bits[uVar17] | uVar18;
          local_1120.tv_usec = 250000;
          iVar7 = select(local_1140 + 1,&buf1,(fd_set *)0x0,&buf2,&local_1120);
          iVar16 = ioctl(0,21523,&buf4);
          if (((-1 < iVar16) && (buf4 != local_1130)) && (local_1126 != local_112e)) {
            ioctl(fd_pty_master,0x5414,&buf4);
            memcpy(&local_1130,&buf4,8);
          }
        }
        else {
          buf2.fds_bits[uVar17] = buf2.fds_bits[uVar17] | uVar18;
          local_1120.tv_usec = 250000;
          uVar17 = (ulong)(long)(int)local_1138 >> 6;
          local_1120.tv_sec = 0;
          uVar18 = 1L << (local_1138 & 0x3f);
          uVar19 = buf2.fds_bits[uVar17];
          buf1.fds_bits[uVar17] = buf1.fds_bits[uVar17] | uVar18;
          buf2.fds_bits[uVar17] = uVar19 | uVar18;
          iVar7 = select(local_1138 + 1,&buf1,(fd_set *)0x0,&buf2,&local_1120);
        }
        if (iVar7 != -1) break;
        _Var8 = waitpid(pid_child,(int *)&local_114c,1);
        if (((copy_of_number == 0) && (copy_of_number = FUN_00108df0(0), copy_of_number != 0)) &&
           (bVar20 = true, !bVar4)) {
          close(copy_fd_master);
        }
        if (0 < _Var8) goto LAB_00110efc;
        wrapper_sleep(0x80);
      }
      if (iVar7 != 0) break;
      if (((copy_of_number == 0) && (copy_of_number = FUN_00108df0(0), copy_of_number != 0)) &&
         (bVar20 = true, !bVar4)) {
        close(copy_fd_master);
      }
      _Var8 = waitpid(pid_child,(int *)&local_114c,1);
      if ((0 < _Var8) || (iVar7 = kill(pid_child,0), iVar7 < 0)) goto LAB_00110efc;
      wrapper_sleep(0x10);
    }
    if (bVar20) {
      bVar20 = true;
      iVar7 = 0;
    }
    else {
      iVar7 = 0;
      if ((buf1.fds_bits[0] & 1U) != 0) {
        sVar12 = read(0,buf3,0x1000);
        iVar7 = (int)sVar12;
        if (iVar7 < 1) {
          iVar6 = iVar6 + iVar7;
          if (iVar7 == 0) {
            bVar20 = true;
            iVar7 = 1;
            close(copy_fd_master);
          }
        }
        else {
          write(copy_fd_master,buf3,(long)iVar7);
          if (((bool)(bVar2 & (bVar4 ^ 1U))) && (iVar6 < 0x10000)) {
            buf4 = 1;
            write(iVar5,&buf4,2);
            buf4 = (short)sVar12;
            write(iVar5,&buf4,2);
            write(iVar5,buf3,(long)iVar7);
          }
          iVar6 = iVar6 + iVar7;
        }
      }
    }
    if (((ulong)buf1.fds_bits[(ulong)(long)(int)local_1140 >> 6] >> (local_1140 & 0x3f) & 1) == 0) {
      if (!bVar4) goto LAB_00111378;
LAB_00111448:
      puVar11 = &local_1140;
LAB_001113bc:
      if (((ulong)buf2.fds_bits[(ulong)(long)(int)*puVar11 >> 6] >> (*puVar11 & 0x3f) & 1) != 0)
      break;
    }
    else {
      sVar12 = read(local_1140,buf3,0x1000);
      iVar16 = (int)sVar12;
      iVar7 = iVar7 + iVar16;
      if (0 < iVar16) {
        write(1,buf3,(long)iVar16);
        if (bVar3 < (iVar6 < 0x10000)) {
          buf4 = 2;
          write(iVar5,&buf4,2);
          buf4 = (short)sVar12;
          write(iVar5,&buf4,2);
          write(iVar5,buf3,(long)iVar16);
        }
      }
      iVar6 = iVar6 + iVar16;
      if (bVar4) goto LAB_00111448;
LAB_00111378:
      if (((ulong)buf1.fds_bits[(ulong)(long)(int)local_1138 >> 6] >> (local_1138 & 0x3f) & 1) != 0)
      {
        sVar12 = read(local_1138,buf3,0x1000);
        iVar16 = (int)sVar12;
        iVar7 = iVar7 + iVar16;
        if (0 < iVar16) {
          write(2,buf3,(long)iVar16);
          if (bVar3 < (iVar6 < 0x10000)) {
            buf4 = 3;
            write(iVar5,&buf4,2);
            buf4 = (short)sVar12;
            write(iVar5,&buf4,2);
            write(iVar5,buf3,(long)iVar16);
          }
        }
        iVar6 = iVar6 + iVar16;
      }
      if (((ulong)buf2.fds_bits[(ulong)(long)(int)local_1140 >> 6] >> (local_1140 & 0x3f) & 1) != 0)
      {
        puVar11 = &local_1138;
        goto LAB_001113bc;
      }
    }
  } while (0 < iVar7);
LAB_00110efc:
  uVar14 = local_114c >> 8;
  if ((local_114c & 0x7f) != 0) {
    for (uVar14 = 0x10;
        (_Var8 = waitpid(pid_child,(int *)&local_114c,0), _Var8 == 0 &&
        ((wrapper_sleep(0x10), uVar14 < 30000 || (kill(pid_child,9), uVar14 != 60000))));
        uVar14 = uVar14 + 0x10) {
    }
    uVar14 = local_114c >> 8;
    if ((local_114c & 0x7f) != 0) {
      close(0);
      close(1);
      close(2);
      close(copy_fd_master);
      close(local_1140);
      close(local_1138);
      close(iVar5);
LAB_00110fac:
                    /* WARNING: Subroutine does not return */
      exit(0);
    }
  }
LAB_0011100c:
                    /* WARNING: Subroutine does not return */
  exit(uVar14 & 0xff);
}

