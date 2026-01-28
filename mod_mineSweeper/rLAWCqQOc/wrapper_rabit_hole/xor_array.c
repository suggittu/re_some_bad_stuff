void xor_array(void *param_1,ulong param_2,int param_3,char *param_4)

{
   ulong uVar1;
   ulong uVar2;
   
   uVar2 = (ulong)param_3;
   if (uVar2 < param_2)
   {
      uVar1 = (ulong)(param_3 + 1);
      *(byte *)((long)param_1 + uVar2) = *(byte *)((long)param_1 + uVar2) ^ *param_4;
      if (uVar1 < param_2)
      {
          uVar2 = (ulong)(param_3 + 2);
          *(byte *)((long)param_1 + uVar1) = *(byte *)((long)param_1 + uVar1) ^ param_4[1];
          if (uVar2 < param_2)
          {
             uVar1 = (ulong)(param_3 + 3);
             *(byte *)((long)param_1 + uVar2) = *(byte *)((long)param_1 + uVar2) ^ param_4[2];
             if (uVar1 < param_2)
             {
                *(byte *)((long)param_1 + uVar1) = *(byte *)((long)param_1 + uVar1) ^ param_4[3];
             }
          }
      }
   }
   return;
}
