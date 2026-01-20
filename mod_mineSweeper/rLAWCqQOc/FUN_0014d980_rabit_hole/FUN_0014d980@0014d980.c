
void FUN_0014d980(undefined8 *taken_string,char *obfuscated_string,undefined8 param_3)

{
  size_t sVar1;
  undefined8 uVar2;
  
  if (obfuscated_string != 0) {
    sVar1 = strlen(obfuscated_string);
    uVar2 = FUN_0014d510(obfuscated_string,obfuscated_string + sVar1,param_3,0);
    *taken_string = uVar2;
    return;
  }
  uVar2 = FUN_0014d510(0,0xffffffffffffffff,param_3,0);
  *taken_string = uVar2;
  return;
}

