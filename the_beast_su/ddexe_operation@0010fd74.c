
void ddexe_operation(void)

{
  int iVar1;
  
  if ((systemless_sdk == 0) && (iVar1 = get_information_binary("/system/bin/ddexe"), iVar1 != 0)) {
    iVar1 = get_information_binary("/system/bin/ddexe_real");
    if (iVar1 != 0) {
      like_copy_content_file("/system/bin/ddexe_real","/system/bin/ddexe");
      unlink("/system/bin/ddexe_real");
    }
    chown("/system/bin/ddexe",0,2000);
    chmod("/system/bin/ddexe",0x1ed);
    change_selinux_toyboxORtoolbox("/system/bin/ddexe");
    return;
  }
  return;
}

