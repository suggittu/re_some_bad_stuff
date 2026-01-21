
undefined4 FUN_00428220(int param_1,int param_2,int param_3,int param_4,int param_5)

{
  sbyte sVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  uint uVar5;
  byte in_CL;
  byte bVar6;
  uint uVar7;
  uint in_EDX;
  byte bVar8;
  byte bVar9;
  uint uVar10;
  
  uVar10 = in_EDX & 0x8000007f;
  if ((int)uVar10 < 0) {
    uVar10 = (uVar10 - 1 | 0xffffff80) + 1;
  }
  bVar9 = *(byte *)(uVar10 + param_5);
  uVar2 = in_EDX & 0x8000001f;
  if ((int)uVar2 < 0) {
    uVar2 = (uVar2 - 1 | 0xffffffe0) + 1;
  }
  uVar7 = in_EDX + 2 & 0x800000ff;
  if ((int)uVar7 < 0) {
    uVar7 = (uVar7 - 1 | 0xffffff00) + 1;
  }
  uVar3 = in_EDX + 9 & 0x8000007f;
  if ((int)uVar3 < 0) {
    uVar3 = (uVar3 - 1 | 0xffffff80) + 1;
  }
  uVar4 = in_EDX + 8 & 0x8000007f;
  if ((int)uVar4 < 0) {
    uVar4 = (uVar4 - 1 | 0xffffff80) + 1;
  }
  uVar5 = in_EDX & 0x800000ff;
  if ((int)uVar5 < 0) {
    uVar5 = (uVar5 - 1 | 0xffffff00) + 1;
  }
  sVar1 = (bVar9 & 7) + 1;
  bVar6 = *(byte *)(uVar7 + param_2) ^ *(byte *)(uVar3 + param_5) ^ *(byte *)(uVar4 + param_5) ^
          *(byte *)(uVar5 + param_4) ^ *(byte *)(uVar10 + param_3) ^ (&DAT_0042a010)[uVar2] ^
          (&DAT_0042a030)[uVar2] ^ bVar9;
  bVar8 = in_CL >> (8U - sVar1 & 0x1f) | in_CL << sVar1;
  uVar10 = in_EDX + bVar8 & 0x800000ff;
  if ((int)uVar10 < 0) {
    uVar10 = (uVar10 - 1 | 0xffffff00) + 1;
  }
  bVar8 = bVar8 ^ (bVar8 >> 5 | bVar8 << 3) ^ *(byte *)(uVar10 + param_2) ^
                  *(byte *)((bVar8 & 0x7f) + param_3);
  uVar10 = bVar8 + in_EDX & 0x800003ff;
  if ((int)uVar10 < 0) {
    uVar10 = (uVar10 - 1 | 0xfffffc00) + 1;
  }
  bVar9 = (*(char *)(uVar10 + param_1) + (&DAT_0042a010)[uVar2] + bVar8) * (bVar9 & 0xd7 | 5);
  uVar10 = bVar9 + in_EDX & 0x800000ff;
  if ((int)uVar10 < 0) {
    uVar10 = (uVar10 - 1 | 0xffffff00) + 1;
  }
  bVar9 = (*(byte *)(uVar10 + param_4) ^ bVar9) + (&DAT_0042a030)[uVar2] * '\a' + bVar6 * '\x05';
  bVar9 = bVar9 ^ (bVar9 >> 4 | bVar9 * '\x10') ^ *(byte *)((uint)bVar6 + (uint)bVar9 + param_1) ^
                  *(byte *)((uint)bVar9 + param_2);
  uVar10 = bVar9 + in_EDX;
  uVar2 = uVar10 & 0x800000ff;
  if ((int)uVar2 < 0) {
    uVar2 = (uVar2 - 1 | 0xffffff00) + 1;
  }
  uVar10 = uVar10 & 0x8000007f;
  if ((int)uVar10 < 0) {
    uVar10 = (uVar10 - 1 | 0xffffff80) + 1;
  }
  return CONCAT31((int3)(uVar10 >> 8),
                  (*(char *)(uVar10 + param_3) - *(char *)(uVar2 + param_4)) + bVar9);
}

