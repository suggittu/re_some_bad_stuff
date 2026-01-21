
undefined4 FUN_004283e0(int param_1,int param_2)

{
  byte bVar1;
  byte bVar2;
  byte bVar3;
  byte bVar4;
  byte bVar5;
  byte bVar6;
  char cVar7;
  uint uVar8;
  uint uVar9;
  byte bVar10;
  int in_EDX;
  uint uVar11;
  uint uVar12;
  uint in_stack_00000018;
  int in_stack_0000001c;
  
  uVar8 = in_stack_00000018 & 0x8000007f;
  if ((int)uVar8 < 0) {
    uVar8 = (uVar8 - 1 | 0xffffff80) + 1;
  }
  uVar12 = in_stack_00000018 & 0x8000001f;
  if ((int)uVar12 < 0) {
    uVar12 = (uVar12 - 1 | 0xffffffe0) + 1;
  }
  bVar10 = (&DAT_0042a010)[uVar12];
  uVar11 = in_stack_00000018 + 8 & 0x8000007f;
  if ((int)uVar11 < 0) {
    uVar11 = (uVar11 - 1 | 0xffffff80) + 1;
  }
  uVar9 = in_stack_00000018 + 4 & 0x800000ff;
  if ((int)uVar9 < 0) {
    uVar9 = (uVar9 - 1 | 0xffffff00) + 1;
  }
  bVar1 = *(byte *)(uVar11 + in_stack_0000001c);
  bVar2 = *(byte *)(uVar9 + in_EDX);
  uVar11 = in_stack_00000018 + 4 & 0x8000007f;
  if ((int)uVar11 < 0) {
    uVar11 = (uVar11 - 1 | 0xffffff80) + 1;
  }
  bVar3 = *(byte *)(uVar11 + param_1);
  uVar11 = in_stack_00000018 & 0x800000ff;
  if ((int)uVar11 < 0) {
    uVar11 = (uVar11 - 1 | 0xffffff00) + 1;
  }
  bVar4 = *(byte *)(uVar11 + param_2);
  bVar5 = (&DAT_0042a030)[uVar12];
  bVar6 = *(byte *)(uVar8 + in_stack_0000001c);
  cVar7 = FUN_00428220();
  bVar10 = cVar7 + (bVar1 ^ bVar2 ^ bVar3 ^ bVar4 ^ bVar5 ^ bVar6 ^ bVar10) * '\t';
  bVar10 = bVar10 ^ (bVar10 >> 6 | bVar10 * '\x04');
  uVar8 = bVar10 + in_stack_00000018 & 0x800000ff;
  if ((int)uVar8 < 0) {
    uVar8 = (uVar8 - 1 | 0xffffff00) + 1;
  }
  bVar10 = bVar10 + *(char *)(uVar8 + param_2);
  uVar8 = bVar10 + in_stack_00000018 & 0x8000001f;
  if ((int)uVar8 < 0) {
    uVar8 = (uVar8 - 1 | 0xffffffe0) + 1;
  }
  return CONCAT31((int3)(uVar8 >> 8),
                  (&DAT_0042a030)[uVar8] ^ (&DAT_0042a010)[bVar10 & 0x1f] ^ bVar10);
}

