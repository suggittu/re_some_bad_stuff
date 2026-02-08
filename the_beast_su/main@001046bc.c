
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

int main(int argc,char **argv)

{
  char cVar1;
  int iVar2;
  __mode_t default_permissions;
  int iVar3;
  __pid_t _Var4;
  int some_number;
  int iVar5;
  time_t tVar6;
  long lVar7;
  char *pcVar8;
  int *piVar9;
  size_t sVar10;
  size_t sVar11;
  ssize_t sVar12;
  passwd *ppVar13;
  uint uVar14;
  char *__src;
  char *pcVar15;
  char **in_x2;
  uint uVar16;
  char *parameters;
  ulong uVar17;
  char **ppcVar18;
  long lVar19;
  int iVar20;
  ulong uVar21;
  int multi_purpose;
  undefined1 uid [4];
  int euid;
  int gid;
  uint egid;
  char *strings_util [7];
  char *local_4090;
  stat buf_29_char [29];
  undefined1 local_3009;
  undefined1 auStack_3008 [4096];
  char path_some_file [4096];
  char buf_4096_char [4096];
  long local_8;
  
  local_8 = ___stack_chk_guard;
  make_correct_context(argc,(char *)argv,in_x2);
  setbuf((FILE *)strcmp,(char *)0x0);
  pass_sigpipe_signal();
  if (argc < 2) {
LAB_00104810:
    fstat_file(0);
    fstat_file(1);
    fstat_file(2);
    if (config_in_server == 0) {
      my_pid = getpid();
      my_ppid = getppid();
      my_uid = getuid();
      my_gid = getgid();
    }
    check_capabilities();
    char_set_conversion();
    set_up_normal_stuff(my_uid);
    selinux_presence();
    if (argc == 2) {
      parameters = argv[1];
      multi_purpose = strcmp(parameters,"--self-test");
      if (multi_purpose == 0) {
LAB_00105cd4:
        printf("version_code: %d\nversion_name: %s\nversion_arch: %s:%s\n",0x11a,"2.82:SUPERSU",
               &DAT_00113f30,"arm64-v8a");
        printf("sdk: %d\ndaemon_sdk: %d\nmultiuser_sdk: %d\nsystemless_sdk: %d\nsystemless_used: %d\n"
               ,(ulong)sdk,(ulong)daemon_sdk,(ulong)multiuser_sdk,(ulong)systemless_sdk,
               (ulong)systemless_used);
        if (multiuser_sdk != 0) {
          printf("multiuser_userid: %d\nmultiuser_username: %s\n",(ulong)multiuser_userid,
                 multiuser_username);
        }
        printf("selinux_present: %d\n",(ulong)selinux_present);
        if (selinux_present != 0) {
          printf("selinux_enforcing: %d\n",(ulong)selinux_enforcing);
        }
        lVar7 = 0;
        execute_command_on_shell(0,0);
        strings_util[0] = "u:r:shell:s0";
        strings_util[1] = "u:r:system:s0";
        strings_util[2] = "u:r:system_server:s0";
        strings_util[3] = "u:r:system_app:s0";
        strings_util[4] = "u:r:priv_app:s0";
        strings_util[5] = "u:r:platform_app:s0";
        strings_util[6] = "u:r:untrusted_app:s0";
        local_4090 = "u:r:recovery:s0";
        do {
          lVar19 = 0;
          parameters = strings_util[lVar7];
          execute_command_on_shell(parameters);
          execute_command_on_shell(0,parameters);
          do {
            if ((int)lVar7 != (int)lVar19) {
              execute_command_on_shell(parameters,strings_util[lVar19]);
            }
            lVar19 = lVar19 + 1;
          } while (lVar19 != 7);
          lVar7 = lVar7 + 1;
        } while (lVar7 != 7);
                    /* WARNING: Subroutine does not return */
        exit(0);
      }
      if (config_in_server != 0) {
        tVar6 = time((time_t *)0x0);
        srand((uint)tVar6);
        multi_purpose = rand();
        DAT_0012a070 = 2;
        randomcode = my_ppid ^ my_pid ^ multi_purpose % 1000000 + 1U;
LAB_00104a44:
        buf_29_char[0].__unused[1]._0_1_ = 0;
        multi_purpose = -1;
        uVar14 = 0;
        uVar21 = 1;
        uVar16 = uVar14;
        DAT_0012a068 = argv;
        do {
          uVar17 = -(uVar21 >> 0x1f) & 0xfffffff800000000 | uVar21 << 3;
          parameters = *(char **)((long)argv + uVar17);
          iVar2 = strcmp(parameters,"-c");
          some_number = (int)uVar21;
          if ((iVar2 == 0) || (iVar2 = strcmp(parameters,"--command"), iVar2 == 0)) {
            PTR_s__system_bin_sh_0012a058 = (char *)0x0;
            if (argc + -1 <= some_number) {
LAB_00105ccc:
              information_use(2);
              goto LAB_00105cd4;
            }
            iVar2 = some_number + 1;
            if (iVar2 < argc) {
              ppcVar18 = (char **)((long)argv + uVar17 + 8);
              do {
                sVar11 = strlen(*ppcVar18);
                sVar11 = (size_t)((int)sVar11 + 1);
                PTR_s__system_bin_sh_0012a058 = (char *)memset_wrapper(sVar11);
                snprintf(PTR_s__system_bin_sh_0012a058,sVar11,"%s",*ppcVar18);
                while( true ) {
                  ppcVar18 = ppcVar18 + 1;
                  if (ppcVar18 == argv + (long)iVar2 + 1 + (ulong)(uint)((argc + -2) - some_number))
                  {
                    uVar16 = 1;
                    some_number = (argc + -1 + iVar2) - some_number;
                    goto LAB_00104f50;
                  }
                  if (PTR_s__system_bin_sh_0012a058 == (char *)0x0) break;
                  sVar11 = strlen(PTR_s__system_bin_sh_0012a058);
                  sVar10 = strlen(*ppcVar18);
                  sVar11 = (size_t)((int)sVar10 + (int)sVar11 + 2);
                  parameters = (char *)memset_wrapper(sVar11);
                  snprintf(parameters,sVar11,"%s %s",PTR_s__system_bin_sh_0012a058,*ppcVar18);
                  free(PTR_s__system_bin_sh_0012a058);
                  PTR_s__system_bin_sh_0012a058 = parameters;
                }
              } while( true );
            }
LAB_0010517c:
            some_number = iVar2;
            uVar16 = 1;
          }
          else {
            iVar2 = strcmp(parameters,"-s");
            if ((iVar2 == 0) || (iVar2 = strcmp(parameters,"--shell"), iVar2 == 0)) {
              some_number = some_number + 1;
              if (argc <= some_number) goto LAB_00105ccc;
              uVar16 = 1;
              strncpy((char *)(buf_29_char[0].__unused + 1),*(char **)((long)argv + uVar17 + 8),
                      0x1000);
              local_3009 = 0;
            }
            else {
              iVar2 = strcmp(parameters,"-cn");
              if ((iVar2 == 0) || (iVar2 = strcmp(parameters,"--context"), iVar2 == 0)) {
                some_number = some_number + 1;
                if (argc <= some_number) goto LAB_00105ccc;
                sVar11 = strlen(*(char **)((long)argv + uVar17 + 8));
                parameters = (char *)memset_wrapper(sVar11 + 1);
                pcVar8 = *(char **)((long)argv + uVar17 + 8);
                DAT_0012a080 = parameters;
                sVar11 = strlen(pcVar8);
                strncpy(parameters,pcVar8,sVar11);
              }
              else {
                iVar2 = strcmp(parameters,"-mns");
                if ((iVar2 == 0) || (iVar2 = strcmp(parameters,"--mount-namespace"), iVar2 == 0)) {
                  some_number = some_number + 1;
                  if (argc <= some_number) goto LAB_00105ccc;
                  lVar7 = atol(*(char **)((long)argv + uVar17 + 8));
                  DAT_0012a088 = (undefined4)lVar7;
                }
                else {
                  iVar2 = strcmp(parameters,"-m");
                  if (((iVar2 == 0) || (iVar2 = strcmp(parameters,"-p"), iVar2 == 0)) ||
                     (iVar2 = strcmp(parameters,"--preserve-environment"), iVar2 == 0)) {
                    uVar16 = 1;
                    DAT_0012a060 = 1;
                  }
                  else {
                    iVar3 = strcmp(parameters,"-");
                    iVar2 = some_number;
                    if (((iVar3 == 0) || (iVar3 = strcmp(parameters,"-l"), iVar3 == 0)) ||
                       ((iVar3 = strcmp(parameters,"--login"), iVar3 == 0 ||
                        (iVar3 = strcmp(parameters,"--"), iVar3 == 0)))) goto LAB_0010517c;
                    iVar2 = strcmp(parameters,"-i");
                    if ((((iVar2 != 0) && (iVar2 = strcmp(parameters,"--install"), iVar2 != 0)) &&
                        ((iVar2 = strcmp(parameters,"-u"), iVar2 != 0 &&
                         (((((iVar2 = strcmp(parameters,"--uninstall"), iVar2 != 0 &&
                             (iVar2 = strcmp(parameters,"-d"), iVar2 != 0)) &&
                            (iVar2 = strcmp(parameters,"--daemon"), iVar2 != 0)) &&
                           ((iVar2 = strcmp(parameters,"-ad"), iVar2 != 0 &&
                            (iVar2 = strcmp(parameters,"--auto-daemon"), iVar2 != 0)))) &&
                          (iVar2 = strcmp(parameters,"-r"), iVar2 != 0)))))) &&
                       (((iVar2 = strcmp(parameters,"--reload"), iVar2 != 0 &&
                         (iVar2 = strcmp(parameters,"-mm"), iVar2 != 0)) &&
                        (iVar2 = strcmp(parameters,"--mount-master"), iVar2 != 0)))) {
                      if (uVar14 != 0) {
                        some_number_container = argc - some_number;
                        uVar14 = 1;
                        DAT_0012a074 = some_number;
                        break;
                      }
                      ppVar13 = getpwnam(parameters);
                      multi_purpose = some_number;
                      if (ppVar13 == (passwd *)0x0) {
                        gid = 0;
                        egid = uVar14;
                        buf_29_char[0].st_dev._0_4_ = uVar14;
                        if (multiuser_username == (char *)0x0) {
LAB_00105bf8:
                          su_to = atoi(*(char **)((long)argv + uVar17));
                        }
                        else {
                          iVar2 = sscanf(multiuser_username,"u%d_a%d",&gid,&egid);
                          if (iVar2 == 2) {
                            su_to = gid * 100000 + 10000 + egid;
                          }
                          else {
                            if ((multiuser_username == (char *)0x0) ||
                               (iVar2 = sscanf(multiuser_username,"u%d_i%d",&gid,buf_29_char),
                               iVar2 != 2)) goto LAB_00105bf8;
                            su_to = gid * 100000 + 99000 + (uint)buf_29_char[0].st_dev;
                          }
                        }
                        uVar14 = 1;
                      }
                      else {
                        su_to = ppVar13->pw_uid;
                        uVar14 = 1;
                      }
                    }
                  }
                }
              }
            }
          }
LAB_00104f50:
          uVar21 = (ulong)(some_number + 1U);
        } while ((int)(some_number + 1U) < argc);
        if ((((uVar14 != 0) && (multi_purpose == 1)) && (uVar16 == 0)) && (2 < argc)) {
          ppcVar18 = argv + 2;
          multi_purpose = 2;
          DAT_0012a074 = -1;
          some_number_container = 0;
          PTR_s__system_bin_sh_0012a058 = (char *)0x0;
          do {
            if (PTR_s__system_bin_sh_0012a058 == (char *)0x0) {
              sVar11 = strlen(*ppcVar18);
              sVar11 = (size_t)((int)sVar11 + 1);
              PTR_s__system_bin_sh_0012a058 = (char *)memset_wrapper(sVar11);
              snprintf(PTR_s__system_bin_sh_0012a058,sVar11,"%s",*ppcVar18);
            }
            else {
              sVar11 = strlen(PTR_s__system_bin_sh_0012a058);
              sVar10 = strlen(*ppcVar18);
              sVar11 = (size_t)((int)sVar10 + (int)sVar11 + 2);
              parameters = (char *)memset_wrapper(sVar11);
              snprintf(parameters,sVar11,"%s %s",PTR_s__system_bin_sh_0012a058,*ppcVar18);
              free(PTR_s__system_bin_sh_0012a058);
              PTR_s__system_bin_sh_0012a058 = parameters;
            }
            multi_purpose = multi_purpose + 1;
            ppcVar18 = ppcVar18 + 1;
          } while (multi_purpose < argc);
        }
        goto LAB_00105048;
      }
      multi_purpose = strcmp(parameters,"-i");
      uVar16 = 0;
      if ((multi_purpose == 0) ||
         (multi_purpose = strcmp(parameters,"--install"), multi_purpose == 0)) {
        switch_file_ddexe_persistence_();
      }
      else {
        multi_purpose = strcmp(parameters,"-u");
        if ((multi_purpose != 0) &&
           (multi_purpose = strcmp(parameters,"--uninstall"), multi_purpose != 0))
        goto LAB_00104878;
        ddexe_operation();
      }
    }
    else {
      if (config_in_server != 0) {
LAB_001049bc:
        tVar6 = time((time_t *)0x0);
        srand((uint)tVar6);
        multi_purpose = rand();
        buf_29_char[0].__unused[1]._0_1_ = 0;
        randomcode = my_ppid ^ my_pid ^ multi_purpose % 1000000 + 1U;
        DAT_0012a068 = argv;
        DAT_0012a070 = argc;
        if (1 < argc) goto LAB_00104a44;
LAB_00105048:
        DAT_0012701c = my_uid;
        su_from = my_ppid;
        uVar16 = search_for_app(my_ppid);
        if (-1 < (int)uVar16) {
          su_from = uVar16;
        }
        parameters = auStack_3008 + 8;
        DAT_00127020 = (uint)(-1 < (int)uVar16);
        snprintf(auStack_3008,0x1000,"/proc/%u/cmdline",(ulong)su_from);
        multi_purpose = open(auStack_3008,0);
        if (multi_purpose < 0) {
LAB_00105870:
                    /* WARNING: Subroutine does not return */
          exit(1);
        }
        sVar12 = read(multi_purpose,buf_4096_char,0x1000);
        close(multi_purpose);
        if ((sVar12 == 0x1000) || (sVar12 < 0)) goto LAB_00105870;
        if (sVar12 == 0) {
          buf_4096_char[0] = '\0';
LAB_00105460:
          sus_data = 0;
        }
        else {
          pcVar8 = buf_4096_char + 1;
          pcVar15 = (char *)0x0;
          do {
            __src = pcVar15;
            if ((pcVar8[-1] == '\0') && (__src = pcVar8, pcVar15 != (char *)0x0)) {
              pcVar8[-1] = ' ';
              __src = pcVar15;
            }
            pcVar8 = pcVar8 + 1;
            pcVar15 = __src;
          } while (pcVar8 != buf_4096_char + sVar12 + 1);
          buf_4096_char[sVar12] = '\0';
          if (__src == (char *)0x0) goto LAB_00105460;
          strncpy(&sus_data,__src,0x1000);
          DAT_0012a023 = 0;
        }
        pcVar8 = path_some_file;
        snprintf(auStack_3008,0x1000,"/proc/%u/exe",(ulong)su_from);
        sVar12 = readlink(auStack_3008,pcVar8,0x1000);
        if ((sVar12 < 0) || (pcVar8[sVar12] = '\0', DAT_00127020 != 0)) {
          pcVar8 = buf_4096_char;
        }
        strncpy(&matrix_maybe_some_commands,pcVar8,0x1000);
        DAT_00129023 = 0;
        if (DAT_00127020 == 0) {
          if (DAT_0012701c == 2000) {
            snprintf(&contain_string,0x1000,"%s","ADB shell [UID]");
          }
          else if (DAT_0012701c < 10000) {
            snprintf(&contain_string,0x1000,"system_user_%d");
          }
          else {
            snprintf(&contain_string,0x1000,"app_user_%d",(ulong)(DAT_0012701c % 100000));
          }
        }
        else {
          memset(&contain_string,0,0x1000);
          uVar21 = 0;
          uVar17 = 0xffffffff;
          do {
            multi_purpose = (int)uVar17;
            if ((&matrix_maybe_some_commands)[uVar21] == '/') {
              uVar17 = uVar21 & 0xffffffff;
            }
            else if ((&matrix_maybe_some_commands)[uVar21] == '\0') break;
            multi_purpose = (int)uVar17;
            uVar21 = uVar21 + 1;
          } while (uVar21 != 0x1000);
          if (0 < 0xfff - multi_purpose) {
            cVar1 = (&matrix_maybe_some_commands)[multi_purpose + 1];
            if ((cVar1 != ':') && (cVar1 != '\0')) {
              some_number = multi_purpose + 2;
              pcVar8 = &contain_string;
              while (*pcVar8 = cVar1, some_number != multi_purpose + 1 + (0xfff - multi_purpose)) {
                lVar7 = (long)some_number;
                pcVar8 = pcVar8 + 1;
                some_number = some_number + 1;
                cVar1 = (&matrix_maybe_some_commands)[lVar7];
                if ((cVar1 == ':') || (cVar1 == '\0')) break;
              }
            }
          }
        }
        format_string_strange_way(&contain_string,0x1000);
        get_uid_euid(uid,&euid,&gid,&egid);
        default_permissions = umask(23);
        multi_purpose = set_permission(0);
        if (euid != 0) goto LAB_001056c4;
        some_number = strcmp(&matrix_maybe_some_commands,"/system/bin/dumpstate");
        if (some_number == 0) goto LAB_001056c4;
        some_number = strcmp(&matrix_maybe_some_commands,"dumpstate");
        if (some_number == 0) goto LAB_001056c4;
        if (DAT_0012701c == 0) goto LAB_0010570c;
        if ((DAT_0012701c == 2000) && (some_number = FUN_00108930(su_from), 0 < some_number)) {
          snprintf(&contain_string,0x1000,"%s","ADB shell");
        }
        some_number = FUN_00111b14("ro.secure",auStack_3008);
        if ((some_number == 0) || (some_number = strcmp(auStack_3008,""), some_number == 0)) {
LAB_00104cb8:
          parameters = (char *)&su_from;
          some_number = strcmp(&contain_string,"eu.chainfire.supersu");
          if (some_number == 0) goto LAB_001056c8;
LAB_00104cd0:
          parameters = *argv;
          pcVar8 = strstr(parameters,"daemonsu");
          if (pcVar8 != (char *)0x0) goto LAB_001056c4;
          pcVar8 = strstr(parameters,".su");
          if (pcVar8 != (char *)0x0) goto LAB_001056c4;
          parameters = (char *)buf_29_char;
          some_number = stat("/data/data/eu.chainfire.supersu",(stat *)parameters);
          if ((some_number != 0) && (piVar9 = (int *)__errno(), *piVar9 == 2)) {
            some_number = stat("/system/.pin",(stat *)parameters);
            if (some_number == 0) goto LAB_001056c4;
            some_number = stat("/system/xbin/.pin",(stat *)parameters);
            if (some_number == 0) goto LAB_001056c4;
            some_number = stat("/su/etc/pin",(stat *)parameters);
            if (some_number == 0) goto LAB_001056c4;
            some_number = stat("/sbin/supersu/etc/pin",(stat *)parameters);
            if (some_number != 0) {
LAB_0010570c:
              do {
                set_config_log_0(buf_29_char[0].__unused + 1,default_permissions);
LAB_00105720:
                control(parameters,0,0,384,1);
                mkdir(PATH_LOGS_CURRENT_USER,493);
                chown(PATH_LOGS_CURRENT_USER,0,0);
                chmod(PATH_LOGS_CURRENT_USER,493);
                control(PATH_LOGS_CURRENT_USER,0,0,0x1ed,1);
LAB_00104da0:
                parameters = (char *)0x126000;
                take_configuration_supersu_cfg(multiuser_userid);
                if (config_enabled != 0) {
                  if (DAT_0012701c < 2000) {
                    if (config_trustsystem == 1) goto LAB_0010570c;
                  }
                  else if (9999 < DAT_0012701c) {
                    if (config_uid == 0) {
                      if (0 < config_found) {
LAB_0010557c:
                        config_access = 2;
                        config_uid_mismatch = 1;
                      }
                    }
                    else if (DAT_0012701c % 10000 != config_uid % 10000) goto LAB_0010557c;
                  }
                  if ((config_enablemultiuser != 0) ||
                     (parameters = (char *)&multiuser_userid, multiuser_userid == 0)) {
                    check_device_is_rooted();
                    if ((cm_present == 1) && (config_respectcm == 1)) {
                      if (cm_root_mode != 1) {
                        if (cm_root_mode == 2) {
                          if (DAT_0012701c == 2000) goto LAB_00104e18;
                        }
                        else if (cm_root_mode != 0) goto LAB_00104e18;
                        goto LAB_001056c4;
                      }
                      if (DAT_0012701c == 2000) goto LAB_001056c4;
                    }
LAB_00104e18:
                    multi_purpose = 1204224;
                    if (config_access == 2) {
                      some_number = check_app_permission();
                      argv = (char **)0x2;
                      if (some_number != 0) goto LAB_001056c4;
                      _Var4 = fork();
                      if (_Var4 != -1) {
                        if (_Var4 == 0) {
                          set_permission(1);
                          config_access = 2;
                          multi_purpose = get_time();
                          goto LAB_001058f8;
                        }
                        _Var4 = waitpid(_Var4,(int *)buf_29_char,0);
                        if ((_Var4 != -1) && (((uint)buf_29_char[0].st_dev & 0x7f) == 0)) {
                          config_access = (uint)buf_29_char[0].st_dev >> 8 & 0xff;
                        }
                      }
                    }
                    if (config_access == 0) {
                    /* WARNING: Subroutine does not return */
                      wrapper_wrapper_torewhatch();
                    }
                    if (config_access == 1) {
                      sVar11 = strlen(&config_forceshell);
                      if (sVar11 != 0) {
                        strcpy((char *)(buf_29_char[0].__unused + 1),&config_forceshell);
                      }
                      if (-1 < (int)config_forceuser) {
                        su_to = config_forceuser;
                      }
                    /* WARNING: Subroutine does not return */
                      more_suspect_thing_ever(buf_29_char[0].__unused + 1,default_permissions);
                    }
                    goto LAB_00104e40;
                  }
                }
LAB_001056c4:
                set_log__notify_to_0();
LAB_001056c8:
                some_number = stat("/data/data/eu.chainfire.supersu",buf_29_char);
                if ((some_number != 0) ||
                   (buf_29_char[0].st_mode !=
                    *(uint *)((long)&((stat *)parameters)->st_dev + 4) % 100000)) goto LAB_00104cd0;
              } while( true );
            }
            set_log__notify_to_0();
            goto LAB_00105b68;
          }
          if (fbe_sdk != 1) {
            parameters = "/data/data/eu.chainfire.supersu/requests/";
            goto LAB_00104d44;
          }
        }
        else {
          some_number = FUN_00111b14("dev.bootcomplete",auStack_3008);
          if ((some_number != 0) && (some_number = strcmp(auStack_3008,"1"), some_number == 0)) {
            FUN_00111b14("sys.boot_completed",auStack_3008);
            goto LAB_00104cb8;
          }
          parameters = auStack_3008;
          some_number = FUN_00111b14("sys.boot_completed",parameters);
          if ((some_number != 0) && (some_number = strcmp(parameters,"1"), some_number == 0))
          goto LAB_00104cb8;
          take_configuration_supersu_cfg(0xffffffff);
          if (config_enableduringboot != 0) goto LAB_0010570c;
          set_log__notify_to_0();
        }
        parameters = "/data/user_de/0/eu.chainfire.supersu/requests/";
LAB_00104d44:
        mkdir(parameters,0x180);
        chown(parameters,0,0);
        chmod(parameters,0x180);
        if (multi_purpose != 0) goto LAB_00105720;
        mkdir(PATH_LOGS_CURRENT_USER,0x1ed);
        chown(PATH_LOGS_CURRENT_USER,0,0);
        chmod(PATH_LOGS_CURRENT_USER,0x1ed);
        goto LAB_00104da0;
      }
      if (argc < 2) {
LAB_001049a4:
        multi_purpose = establish_connection_termianl(argc,argv);
        if (multi_purpose == 0) goto LAB_001049bc;
LAB_0010550c:
        uVar16 = 0;
      }
      else {
        parameters = argv[1];
LAB_00104878:
        multi_purpose = strcmp(parameters,"-d");
        if ((multi_purpose != 0) &&
           (multi_purpose = strcmp(parameters,"--daemon"), multi_purpose != 0)) {
          multi_purpose = strcmp(parameters,"-ad");
          if ((multi_purpose != 0) &&
             (multi_purpose = strcmp(parameters,"--auto-daemon"), multi_purpose != 0)) {
            if (argc == 2) {
              multi_purpose = strcmp(parameters,"-r");
              if ((multi_purpose == 0) ||
                 (multi_purpose = strcmp(parameters,"--reload"), multi_purpose == 0)) {
LAB_00105b68:
                send_number_to_connection();
                uVar16 = 0;
                goto LAB_001048b4;
              }
            }
            else if (argc < 2) goto LAB_001049a4;
            multi_purpose = strcmp(parameters,"-mm");
            if (((multi_purpose != 0) &&
                (multi_purpose = strcmp(parameters,"--mount-master"), multi_purpose != 0)) ||
               (multi_purpose = establish_connection_termianl(argc,argv), multi_purpose == 0))
            goto LAB_001049a4;
            goto LAB_0010550c;
          }
          if ((daemon_sdk == 0) && (selinux_enforcing == 0)) {
            uVar16 = 1;
            goto LAB_001048b4;
          }
        }
        multi_purpose = FUN_0010e6f0(argv);
        uVar16 = (uint)(multi_purpose == 0);
      }
    }
  }
  else {
    parameters = argv[1];
    multi_purpose = strcmp(parameters,"-v");
    if ((multi_purpose == 0) || (multi_purpose = strcmp(parameters,"--version"), multi_purpose == 0)
       ) {
      printf("%s\n","2.82:SUPERSU");
                    /* WARNING: Subroutine does not return */
      exit(0);
    }
    multi_purpose = strcmp(parameters,"-V");
    if (multi_purpose == 0) {
      printf("%d\n",0x11a);
                    /* WARNING: Subroutine does not return */
      exit(0);
    }
    multi_purpose = strcmp(parameters,"-h");
    if ((multi_purpose == 0) || (multi_purpose = strcmp(parameters,"--help"), multi_purpose == 0)) {
      information_use(0);
      goto LAB_00105b7c;
    }
    if ((argc != 3) || (multi_purpose = strcmp(parameters,"--id"), multi_purpose != 0))
    goto LAB_00104810;
    multi_purpose = atoi(argv[2]);
    if (0 < multi_purpose) {
      FUN_00108afc(multi_purpose,&egid,buf_29_char,buf_4096_char);
      if (-1 < (int)egid) {
        printf("%d %d %s\n",(ulong)(uint)buf_29_char[0].st_dev,(ulong)egid,buf_4096_char);
        uVar16 = 0;
        goto LAB_001048b4;
      }
    }
LAB_00104e40:
    uVar16 = 1;
  }
LAB_001048b4:
  if (local_8 == ___stack_chk_guard) {
    return uVar16;
  }
LAB_00105b7c:
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
LAB_001058f8:
  uVar21 = wrapper_torewhatch(2,&su_from,&su_to);
  some_number = get_time();
  parameters = "/data/user_de/0/eu.chainfire.supersu/requests/";
  if (fbe_sdk != 1) {
    parameters = "/data/data/eu.chainfire.supersu/requests/";
  }
  snprintf(path_some_file,0x1000,"%s%d",parameters,uVar21 & 0xffffffff);
  do {
    iVar2 = access(path_some_file,4);
    if ((((iVar2 == 0) && (iVar2 = lstat(path_some_file,buf_29_char), iVar2 == 0)) &&
        (CONCAT44(buf_29_char[0].st_uid,buf_29_char[0].st_mode) == 0)) &&
       ((((uint)buf_29_char[0].st_nlink & 0x1ff) == 0x180 &&
        (((uint)buf_29_char[0].st_nlink & 0xf000) != 0xa000)))) {
      config_found = 1;
      some_number = open(path_some_file,0);
      config_access = iVar2;
      if (-1 < some_number) {
        sVar12 = read(some_number,buf_4096_char,0xffa);
        iVar5 = (int)sVar12;
        buf_4096_char[iVar5] = ':';
        buf_4096_char[iVar5 + 1] = '\0';
        buf_4096_char[iVar5 + 2] = '\0';
        buf_4096_char[iVar5 + 3] = '\0';
        buf_4096_char[iVar5 + 4] = '\0';
        buf_4096_char[iVar5 + 5] = '\0';
        iVar2 = 0;
        iVar3 = 0;
        lVar7 = 0;
        while (((iVar20 = (int)lVar7, iVar20 <= iVar5 + 5 &&
                (cVar1 = buf_4096_char[lVar7], cVar1 != '\x1a' && (cVar1 != '\v' && cVar1 != '\0')))
               && (1 < (byte)(cVar1 - 7U)))) {
          if (cVar1 == ':') {
            buf_4096_char[lVar7] = '\0';
            if (iVar2 < iVar20) {
              if (iVar3 == 0) {
                config_access = atoi(buf_4096_char + iVar2);
              }
              else if (iVar3 == 1) {
                config_log = atoi(buf_4096_char + iVar2);
              }
              else if (iVar3 == 2) {
                config_forceuser = atoi(buf_4096_char + iVar2);
              }
              else if (iVar3 == 3) {
                FUN_00106d4c(buf_4096_char + iVar2,iVar5 - iVar2);
              }
              else if (iVar3 == 4) {
                strcpy(&config_forceshell,buf_4096_char + iVar2);
              }
            }
            iVar2 = iVar20 + 1;
            iVar3 = iVar3 + 1;
            lVar7 = lVar7 + 1;
          }
          else {
            lVar7 = lVar7 + 1;
          }
        }
        close(some_number);
      }
      break;
    }
    wrapper_sleep(0x32);
    lVar7 = get_time();
  } while (lVar7 <= some_number + config_wait);
  if (config_access != 2) {
    unlink(path_some_file);
    goto LAB_001059e0;
  }
  lVar7 = get_time();
  if (multi_purpose + config_wait * 0x10 < lVar7) {
    config_access = 0;
LAB_001059e0:
                    /* WARNING: Subroutine does not return */
    exit(config_access);
  }
  goto LAB_001058f8;
}

