
void FUN_0014cf74(long *param_1,long *param_2)

{
  char cVar1;
  bool bVar2;
  int *piVar3;
  long lVar4;
  undefined1 auStack_8 [8];
  
  lVar4 = *param_2;
  if (*(int *)(lVar4 + -8) < 0) {
    lVar4 = FUN_0014c7c0((undefined8 *)(lVar4 + -0x18),auStack_8,0);
    *param_1 = lVar4;
    return;
  }
  if ((undefined8 *)(lVar4 + -0x18) != &DAT_001ad720) {
    piVar3 = (int *)(lVar4 + -8);
    do {
      cVar1 = '\x01';
      bVar2 = (bool)ExclusiveMonitorPass(piVar3,0x10);
      if (bVar2) {
        *piVar3 = *piVar3 + 1;
        cVar1 = ExclusiveMonitorsStatus();
      }
    } while (cVar1 != '\0');
  }
  *param_1 = lVar4;
  return;
}

