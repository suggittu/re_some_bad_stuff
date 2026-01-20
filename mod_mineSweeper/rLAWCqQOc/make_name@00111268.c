
/* make_name(char const*, char const*) */

char * make_name(char *param_1,char *param_2)

{
  size_t sVar1;
  size_t sVar2;
  char *pcVar3;
  size_t sVar4;
  
  sVar1 = strlen(param_1);
  sVar4 = sVar1;
  do {
    sVar4 = sVar4 - 1;
    if (sVar4 == 0xffffffffffffffff) break;
  } while (param_1[sVar4] != '.');
  if ((long)sVar4 < 0) {
    sVar4 = 0;
  }
  if (param_1[sVar4] == '.') {
    sVar4 = sVar4 + 1;
  }
  if (param_2 == (char *)0x0) {
    pcVar3 = operator_new__((sVar1 - sVar4) + 1);
    strcpy(pcVar3,param_1 + sVar4);
    return pcVar3;
  }
  sVar2 = strlen(param_2);
  pcVar3 = operator_new__(sVar2 + (sVar1 - sVar4) + 1);
  strcpy(pcVar3,param_1 + sVar4);
  strcpy(pcVar3 + (sVar1 - sVar4),param_2);
  return pcVar3;
}

