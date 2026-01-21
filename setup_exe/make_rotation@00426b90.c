
void __fastcall make_rotation(uint param_1)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  uint uVar5;
  
  uVar4 = *(uint *)(param_1 + 0xc);
  uVar3 = *(uint *)(param_1 + 4);
  uVar1 = *(int *)(param_1 + 8) + uVar4;
  uVar2 = (uVar4 >> 0x10 | uVar4 << 0x10) ^ uVar1;
  uVar4 = (uVar3 >> 0x13 | uVar3 << 0xd) ^ *(int *)param_1 + uVar3;
  uVar1 = uVar1 + uVar4;
  uVar5 = (uVar4 >> 0xf | uVar4 << 0x11) ^ uVar1;
  uVar4 = uVar2 + *(int *)param_1 + uVar3;
  uVar3 = (uVar2 >> 7 | uVar2 << 0x19) ^ uVar4;
  uVar4 = uVar5 + uVar4;
  uVar1 = uVar1 + uVar3;
  uVar3 = (uVar3 >> 0x15 | uVar3 << 0xb) ^ uVar1;
  *(uint *)(param_1 + 8) = (uVar5 >> 0x1b | uVar5 << 5) ^ uVar4 ^ uVar3;
  *(uint *)param_1 = uVar3 >> 0xd | uVar3 << 0x13;
  *(uint *)(param_1 + 0xc) = uVar1 >> 0x17 | uVar1 * 0x200;
  *(uint *)(param_1 + 4) = uVar4 ^ uVar1;
  return;
}

