
void FUN_00428590(byte *pagina_allocata, int size)

{
	undefined1 *puVar1;
	uint8_t uVar2;
	char cVar3;
	byte bVar4;
	undefined1 uVar5;
	int iVar6;
	int iVar7;
	int iVar8;
	code *pcVar9;
	undefined1 *buf;
	uint uVar11;
	int size;
	uint8_t *puVar12;
	byte bVar13;
	uint in_EDX;
	uint uVar14;
	uint uVar15;
	undefined1 *puVar16;
	uint uVar17;
	byte *pbVar18;
	uint uVar19;
	short *psVar20;
	int unaff_FS_OFFSET;
	undefined1 *buf;
	undefined1 *buf4;
	undefined1 *buf2;
	undefined1 *buf3;
	uint local_38;
	undefined1 *local_34;
	undefined1 *local_30;
	uint local_2c;
	undefined1 *local_28;
	uint local_24;
	undefined1 *i;
	undefined4 local_1c;
	undefined1 *local_18;
	uint local_14;
	int local_10;
	uint local_c;
	short *size;
	uint local_4;

	buf = (undefined1 *)0x0;
	buf2 = (undefined1 *)0x0;
	buf4 = (undefined1 *)0x0;
	buf3 = (undefined1 *)0x0;
	local_1c = 0;
	local_18 = (undefined1 *)in_EDX;
	size = (short *)size;
	success= call_virtual_alloc(&buf, &local_1c);

	if (buf != 0x0)
	{
		buf = buf;
		for (success= 0x400; success!= 0; success= success+ -1)
		{
			*buf = 0;
			buf = buf + 1;
		}
	} //azzera il buffer allocato
	success= call_virtual_alloc2(&buf2, &local_1c);
	if (success== 0)
	{
		if (buf2 != (undefined1 *)0x0)
		{
			buf = buf2;
			for (success= 0x100; success!= 0; success= success+ -1)
			{
				*buf = 0;
				buf = buf + 1;
			}
		}
		success= call_virtual_alloc2(&buf4, &local_1c);
		if (success== 0)
		{
			if (buf4 != (undefined1 *)0x0)
			{
				buf = buf4;
				for (success= 0x80; success!= 0; success= success+ -1)
				{
					*buf = 0;
					buf = buf + 1;
				}
			}
			success= call_virtual_alloc2(&buf3, &local_1c);
			if (success== 0)
			{
				if (buf3 != (undefined1 *)0x0)
				{
					buf = buf3;
					for (success= 0x100; success!= 0; success= success+ -1)
					{
						*buf = 0;
						buf = buf + 1;
					}
				}
				//quindi le prime allocazioni di memoria anche qui erano inutili
				decode_data(buf4, buf3, pagina_allocata, 0x80);  //da vedere
				local_2c = 0;
				bVar4 = pagina_allocata[0x7f] ^ pagina_allocata[0x40] ^ pagina_allocata[0x2a] ^ *pagina_allocata ^ 0xbc;
				local_30 = (undefined1 *)0x0;
				local_14 = (uint)bVar4;
				local_24 = 0;
				i = (undefined1 *)0x0;
				for(int i=0; i<0x2000;i++ )
				{
					local_2c = local_2c + 1 & 0x800003ff;
					if ((int)local_2c < 0)
					{
						local_2c = (local_2c - 1 | 0xfffffc00) + 1;
					}
					bVar13 = buf[local_2c];
					buf = ((&DAT_0042a010)[i & 0x1f] + 
												local_14 +buf4[i & 0x7f] +pagina_allocata[i & 0x7f] +
												buf2[i & 0xff] + bVar13 +buf3[i & 0xff] + local_30 & 0x800003ff);
					if (buf < 0)
					{
						buf = (((int)buf - 1U | 0xfffffc00) + 1);
					}
					uVar17 = (int)i + 2U & 0x8000007f;
					if (uVar17 < 0)
					{
						uVar17 = (uVar17 - 1 | 0xffffff80) + 1;
					}
					local_24 = buf[buf] +
					pagina_allocata[uVar17] + local_24 + (((&DAT_0042a030)[i & 0x1f] ^ bVar4 ^ buf3[i & 0xff]) ^i) & 0x800003ff;
					if ((int)local_24 < 0)
					{
						local_24 = (local_24 - 1 | 0xfffffc00) + 1;
					}
					i = (undefined1 *)((int)i + 1);
					buf[local_2c] = buf[(int)buf];
					buf[(int)buf] = buf[local_24];
					buf[local_24] = bVar13;
					local_30 = buf;
				} 
				local_38 = 0;
				if (local_18 == 0x0)
				{
					i = buf;
					local_30 = buf4;
					local_28 = buf2;
					local_34 = buf3;
				}
				else
				{
					local_c = 0;
					local_10 = 0;
					local_4 = local_14 * 3;
					i = buf;
					local_28 = buf2;
					local_30 = buf4;
					local_34 = buf3;
					puVar16 = buf;
					do
					{
						uVar17 = local_38;
						local_2c = local_2c + 1 + puVar16[local_38 + local_2c & 0x3ff] &
								   0x800003ff;
						if ((int)local_2c < 0)
						{
							local_2c = (local_2c - 1 | 0xfffffc00) + 1;
						}
						uVar14 = local_38 + (int)buf;
						local_30 = (undefined1 *)((uint)(byte)i[(int)buf] +
													  (uint)pagina_allocata[local_38 + local_2c & 0x7f] + (int)buf +
													  (uint)(byte)local_34[uVar14 + local_2c & 0xff] +
													  (uint)(byte)local_30[uVar14 & 0x7f] +
													  (uint)(byte)(&DAT_0042a010)[uVar14 & 0x1f] +
													  (uint)(byte)local_28[local_38 + local_2c & 0xff] &
												  0x800003ff);
						if ((int)local_30 < 0)
						{
							local_30 = (undefined1 *)(((int)local_30 - 1U | 0xfffffc00) + 1);
						}
						uVar14 = ((uint)local_30 ^ local_2c) & 0x800003ff;
						if ((int)uVar14 < 0)
						{
							uVar14 = (uVar14 - 1 | 0xfffffc00) + 1;
						}
						local_24 = (uint)(byte)i[local_24] +
									   (byte)i[uVar14] + local_24 +
									   ((uint)(byte)(&DAT_0042a030)[local_38 + local_24 & 0x1f] * 7 ^ local_4 ^
										local_38) +
									   (uint)(byte)local_34[local_10 + local_24 & 0xff] &
								   0x800003ff;
						if ((int)local_24 < 0)
						{
							local_24 = (local_24 - 1 | 0xfffffc00) + 1;
						}
						uVar5 = i[local_2c];
						i[local_2c] = i[(int)local_30];
						buf[(int)local_30] = buf[local_24];
						buf[local_24] = uVar5;
						local_34 = (undefined1 *)(local_38 + 6);
						cVar3 = buf[local_2c];
						uVar14 = local_24 & 0x800000ff;
						if ((int)uVar14 < 0)
						{
							uVar14 = (uVar14 - 1 | 0xffffff00) + 1;
						}
						uVar11 = (int)local_30 + local_2c & 0x8000007f;
						if ((int)uVar11 < 0)
						{
							uVar11 = (uVar11 - 1 | 0xffffff80) + 1;
						}
						bVar13 = (char)((uint)(byte)buf[(int)local_30] * 199) + buf2[uVar14] * -99 + cVar3 * -5 ^ buf4[uVar11] ^ pagina_allocata[local_38 + 4 & 0x7f] ^
								 buf3[local_c & 0xff] ^ (&DAT_0042a010)[local_38 + 5 & 0x1f] ^
								 (&DAT_0042a030)[local_38 + 6 & 0x1f];
						local_28 = (undefined1 *)
							CONCAT31((int3)((uint)(byte)buf[(int)local_30] * 199 >> 8), bVar13);
						i = (undefined1 *)(local_38 & 0xff);
						uVar14 = local_38 & 0x7f;
						buf[local_2c] =
							buf2[pagina_allocata[local_38 & 0x7f] + local_14 + local_38 & 0xff] +
							buf4[uVar14] + buf3[(int)i] + cVar3 + bVar13;
						puVar1 = buf + (int)local_30;
						uVar5 = FUN_00428220(buf, buf2, buf4, buf3, pagina_allocata, local_30);
						buf = local_30;
						puVar16 = buf;
						*puVar1 = uVar5;
						buf[local_24] =
							buf[local_24] ^
							buf4[uVar14] + buf3[(int)i] + buf2[(int)i] + bVar13;
						uVar11 = uVar17 & 0x1f;
						buf2[(int)i] =
							pagina_allocata[uVar17 + 5 & 0x7f] >> 3 ^ buf4[uVar14] ^ buf3[(int)i] ^
							buf[local_2c] ^ bVar4 ^ buf2[(int)i] ^ (&DAT_0042a010)[uVar11];
						buf4[uVar14] =
							buf[(int)local_30] + buf4[uVar14] ^ pagina_allocata[uVar17 + 2 & 0x7f] ^
							buf2[uVar17 + 4 & 0xff] ^ (&DAT_0042a030)[uVar11] ^ buf3[(int)i];
						buf[local_2c] =
							buf[local_2c] ^
							buf2[local_38 + 3 & 0xff] << 5 ^ (byte)buf4[uVar17 + 4 & 0x7f] >> 2 ^
							pagina_allocata[(uint)local_34 & 0x7f] ^ buf3[(int)i] ^
							(&DAT_0042a010)[uVar11];
						pbVar18 = (byte *)((int)size + local_38);
						local_34 = buf3;
						i = buf;
						local_30 = buf4;
						local_28 = buf2;
						bVar13 = FUN_004283e0(buf4, buf3, local_2c, buf, local_24, local_38, pagina_allocata);
						*pbVar18 = *pbVar18 ^ bVar13;
						local_38 = local_38 + 1;
						local_10 = local_10 + 5;
						local_c = local_c + 7;
					} while (local_38 < local_18);
				}
				uVar17 = 0;
				if (local_18 != (undefined1 *)0x0)
				{
					local_4 = 2 - (int)size;
					do
					{
						pbVar18 = (byte *)(uVar17 + (int)size);
						uVar19 = uVar17 & 0xff;
						uVar14 = uVar17 & 0x7f;
						uVar15 = uVar17 & 0x1f;
						uVar11 = uVar17 & 0x7f;
						uVar17 = uVar17 + 1;
						*pbVar18 = *pbVar18 ^
								   pagina_allocata[(uint)(pbVar18 + local_4) & 0x7f] ^ local_30[uVar14] ^
								   pagina_allocata[uVar11] ^ (&DAT_0042a030)[uVar15] ^ (&DAT_0042a010)[uVar15] ^
								   local_34[uVar19] ^ local_28[uVar19] ^ bVar4 << 4;
					} while (uVar17 < local_18);
				}
				if (i != (undefined1 *)0x0)
				{
					psVar20 = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
					size = psVar20;
					if ((((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
						 (*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550)) &&
						(success= *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
						 success!= 0))
					{
						uVar17 = 0;
						local_14 = *(int *)(success+ 0x1c) + (int)psVar20;
						local_c = *(int *)(success+ 0x20) + (int)psVar20;
						local_10 = *(int *)(success+ 0x24) + (int)psVar20;
						if (*(int *)(success+ 0x18) != 0)
						{
							do
							{
								uVar14 = 0;
								local_4 = 0;
								puVar12 = (uint8_t *)(*(int *)(local_c + uVar17 * 4) + (int)psVar20);
								if (puVar12 != (uint8_t *)0x0)
								{
									uVar2 = *puVar12;
									uVar11 = uVar14;
									while (uVar14 = uVar11, uVar2 != '\0')
									{
										uVar11 = uVar14 + 1;
										local_4 = uVar14;
										uVar2 = puVar12[uVar14 + 1];
									}
								}
								iVar8 = hasher(puVar12, uVar14);
								if (iVar8 == 0x1d499ba0)
								{
									pcVar9 = (code *)(*(int *)(local_14 +
															   (uint) * (ushort *)(local_10 + uVar17 * 2) * 4) +
													  (int)psVar20);
									goto LAB_00429247;
								}
								uVar17 = uVar17 + 1;
							} while (uVar17 < *(uint *)(success+ 0x18));
						}
					}
					pcVar9 = (code *)0x0;
				LAB_00429247:
					(*pcVar9)(i, 0, 0x8000);
					local_28 = buf2;
					local_30 = buf4;
					local_34 = buf3;
				}
				if (local_28 != (undefined1 *)0x0)
				{
					psVar20 = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
					size = psVar20;
					if (((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
						((*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550 &&
						  (success= *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
						   success!= 0))))
					{
						uVar17 = 0;
						local_14 = *(int *)(success+ 0x1c) + (int)psVar20;
						local_c = *(int *)(success+ 0x20) + (int)psVar20;
						local_10 = *(int *)(success+ 0x24) + (int)psVar20;
						if (*(int *)(success+ 0x18) != 0)
						{
							do
							{
								uVar14 = 0;
								local_4 = 0;
								puVar12 = (uint8_t *)(*(int *)(local_c + uVar17 * 4) + (int)psVar20);
								if (puVar12 != (uint8_t *)0x0)
								{
									uVar2 = *puVar12;
									uVar11 = uVar14;
									while (uVar14 = uVar11, uVar2 != '\0')
									{
										uVar11 = uVar14 + 1;
										local_4 = uVar14;
										uVar2 = puVar12[uVar14 + 1];
									}
								}
								iVar8 = hasher(puVar12, uVar14);
								if (iVar8 == 0x1d499ba0)
								{
									pcVar9 = (code *)(*(int *)(local_14 +
															   (uint) * (ushort *)(local_10 + uVar17 * 2) * 4) +
													  (int)psVar20);
									goto LAB_0042932b;
								}
								uVar17 = uVar17 + 1;
							} while (uVar17 < *(uint *)(success+ 0x18));
						}
					}
					pcVar9 = (code *)0x0;
				LAB_0042932b:
					(*pcVar9)(local_28, 0, 0x8000);
					local_30 = buf4;
					local_34 = buf3;
				}
				if (local_30 != (undefined1 *)0x0)
				{
					psVar20 = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
					size = psVar20;
					if (((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
						((*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550 &&
						  (success= *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
						   success!= 0))))
					{
						uVar17 = 0;
						local_14 = *(int *)(success+ 0x1c) + (int)psVar20;
						local_c = *(int *)(success+ 0x20) + (int)psVar20;
						local_10 = *(int *)(success+ 0x24) + (int)psVar20;
						if (*(int *)(success+ 0x18) != 0)
						{
							do
							{
								uVar14 = 0;
								local_4 = 0;
								puVar12 = (uint8_t *)(*(int *)(local_c + uVar17 * 4) + (int)psVar20);
								if (puVar12 != (uint8_t *)0x0)
								{
									uVar2 = *puVar12;
									uVar11 = uVar14;
									while (uVar14 = uVar11, uVar2 != '\0')
									{
										uVar11 = uVar14 + 1;
										local_4 = uVar14;
										uVar2 = puVar12[uVar14 + 1];
									}
								}
								iVar8 = hasher(puVar12, uVar14);
								if (iVar8 == 0x1d499ba0)
								{
									pcVar9 = (code *)(*(int *)(local_14 +
															   (uint) * (ushort *)(local_10 + uVar17 * 2) * 4) +
													  (int)psVar20);
									goto LAB_00429417;
								}
								uVar17 = uVar17 + 1;
							} while (uVar17 < *(uint *)(success+ 0x18));
						}
					}
					pcVar9 = (code *)0x0;
				LAB_00429417:
					(*pcVar9)(local_30, 0, 0x8000);
					local_34 = buf3;
				}
				if (local_34 != (undefined1 *)0x0)
				{
					psVar20 = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
					size = psVar20;
					if ((((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
						 (*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550)) &&
						(success= *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
						 success!= 0))
					{
						uVar17 = 0;
						iVar8 = *(int *)(success+ 0x20);
						local_10 = *(int *)(success+ 0x1c) + (int)psVar20;
						local_c = *(int *)(success+ 0x24) + (int)psVar20;
						if (*(int *)(success+ 0x18) != 0)
						{
							do
							{
								uVar14 = 0;
								local_4 = 0;
								puVar12 = (uint8_t *)(*(int *)((int)psVar20 + uVar17 * 4 + iVar8) + (int)psVar20);
								if (puVar12 != (uint8_t *)0x0)
								{
									uVar2 = *puVar12;
									uVar11 = uVar14;
									while (uVar14 = uVar11, uVar2 != '\0')
									{
										uVar11 = uVar14 + 1;
										local_4 = uVar14;
										uVar2 = puVar12[uVar14 + 1];
									}
								}
								iVar7 = hasher(puVar12, uVar14);
								if (iVar7 == 0x1d499ba0)
								{
									(*(code *)(*(int *)(local_10 + (uint) * (ushort *)(local_c + uVar17 * 2) * 4) +
											   (int)psVar20))(local_34, 0, 0x8000);
									return;
								}
								uVar17 = uVar17 + 1;
							} while (uVar17 < *(uint *)(success+ 0x18));
						}
					}
					(*(code *)0x0)(local_34, 0, 0x8000);
				}
			}
			else
			{
				i = buf;
				if (buf != (undefined1 *)0x0)
				{
					psVar20 = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
					size = psVar20;
					if (((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
						((*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550 &&
						  (success= *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
						   success!= 0))))
					{
						uVar17 = 0;
						local_18 = (undefined1 *)(*(int *)(success+ 0x1c) + (int)psVar20);
						local_10 = *(int *)(success+ 0x20) + (int)psVar20;
						local_14 = *(int *)(success+ 0x24) + (int)psVar20;
						if (*(int *)(success+ 0x18) != 0)
						{
							do
							{
								uVar14 = 0;
								local_c = 0;
								puVar12 = (uint8_t *)(*(int *)(local_10 + uVar17 * 4) + (int)psVar20);
								if (puVar12 != (uint8_t *)0x0)
								{
									uVar2 = *puVar12;
									uVar11 = uVar14;
									while (uVar14 = uVar11, uVar2 != '\0')
									{
										uVar11 = uVar14 + 1;
										local_c = uVar14;
										uVar2 = puVar12[uVar14 + 1];
									}
								}
								iVar8 = hasher(puVar12, uVar14);
								if (iVar8 == 0x1d499ba0)
								{
									pcVar9 = (code *)(*(int *)((int)local_18 +
															   (uint) * (ushort *)(local_14 + uVar17 * 2) * 4) +
													  (int)psVar20);
									goto LAB_004289dd;
								}
								uVar17 = uVar17 + 1;
							} while (uVar17 < *(uint *)(success+ 0x18));
						}
					}
					pcVar9 = (code *)0x0;
				LAB_004289dd:
					(*pcVar9)(i, 0, 0x8000);
				}
				i = buf2;
				if (buf2 != (undefined1 *)0x0)
				{
					psVar20 = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
					size = psVar20;
					if (((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
						((*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550 &&
						  (success= *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
						   success!= 0))))
					{
						uVar17 = 0;
						local_18 = (undefined1 *)(*(int *)(success+ 0x1c) + (int)psVar20);
						local_10 = *(int *)(success+ 0x20) + (int)psVar20;
						local_14 = *(int *)(success+ 0x24) + (int)psVar20;
						if (*(int *)(success+ 0x18) != 0)
						{
							do
							{
								uVar14 = 0;
								local_c = 0;
								puVar12 = (uint8_t *)(*(int *)(local_10 + uVar17 * 4) + (int)psVar20);
								if (puVar12 != (uint8_t *)0x0)
								{
									uVar2 = *puVar12;
									uVar11 = uVar14;
									while (uVar14 = uVar11, uVar2 != '\0')
									{
										uVar11 = uVar14 + 1;
										local_c = uVar14;
										uVar2 = puVar12[uVar14 + 1];
									}
								}
								iVar8 = hasher(puVar12, uVar14);
								if (iVar8 == 0x1d499ba0)
								{
									pcVar9 = (code *)(*(int *)((int)local_18 +
															   (uint) * (ushort *)(local_14 + uVar17 * 2) * 4) +
													  (int)psVar20);
									goto LAB_00428ac7;
								}
								uVar17 = uVar17 + 1;
							} while (uVar17 < *(uint *)(success+ 0x18));
						}
					}
					pcVar9 = (code *)0x0;
				LAB_00428ac7:
					(*pcVar9)(i, 0, 0x8000);
				}
				local_18 = buf4;
				if (buf4 != (undefined1 *)0x0)
				{
					psVar20 = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
					size = psVar20;
					if ((((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
						 (*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550)) &&
						(success= *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
						 success!= 0))
					{
						uVar17 = 0;
						iVar8 = *(int *)(success+ 0x20);
						local_14 = *(int *)(success+ 0x1c) + (int)psVar20;
						local_10 = *(int *)(success+ 0x24) + (int)psVar20;
						if (*(int *)(success+ 0x18) != 0)
						{
							do
							{
								uVar14 = 0;
								local_c = 0;
								puVar12 = (uint8_t *)(*(int *)((int)psVar20 + uVar17 * 4 + iVar8) + (int)psVar20);
								if (puVar12 != (uint8_t *)0x0)
								{
									uVar2 = *puVar12;
									uVar11 = uVar14;
									while (uVar14 = uVar11, uVar2 != '\0')
									{
										uVar11 = uVar14 + 1;
										local_c = uVar14;
										uVar2 = puVar12[uVar14 + 1];
									}
								}
								iVar7 = hasher(puVar12, uVar14);
								if (iVar7 == 0x1d499ba0)
									goto LAB_004286f8;
								uVar17 = uVar17 + 1;
							} while (uVar17 < *(uint *)(success+ 0x18));
						}
					}
					goto LAB_004286e2;
				}
			}
		}
		else
		{
			i = buf;
			if (buf != (undefined1 *)0x0)
			{
				psVar20 = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
				size = psVar20;
				if (((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
					((*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550 &&
					  (success= *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
					   success!= 0))))
				{
					uVar17 = 0;
					local_18 = (undefined1 *)(*(int *)(success+ 0x1c) + (int)psVar20);
					local_10 = *(int *)(success+ 0x20) + (int)psVar20;
					local_14 = *(int *)(success+ 0x24) + (int)psVar20;
					if (*(int *)(success+ 0x18) != 0)
					{
						do
						{
							uVar14 = 0;
							local_c = 0;
							puVar12 = (uint8_t *)(*(int *)(local_10 + uVar17 * 4) + (int)psVar20);
							if (puVar12 != (uint8_t *)0x0)
							{
								uVar2 = *puVar12;
								uVar11 = uVar14;
								while (uVar14 = uVar11, uVar2 != '\0')
								{
									uVar11 = uVar14 + 1;
									local_c = uVar14;
									uVar2 = puVar12[uVar14 + 1];
								}
							}
							iVar8 = hasher(puVar12, uVar14);
							if (iVar8 == 0x1d499ba0)
							{
								pcVar9 = (code *)(*(int *)((int)local_18 +
														   (uint) * (ushort *)(local_14 + uVar17 * 2) * 4) +
												  (int)psVar20);
								goto LAB_0042880b;
							}
							uVar17 = uVar17 + 1;
						} while (uVar17 < *(uint *)(success+ 0x18));
					}
				}
				pcVar9 = (code *)0x0;
			LAB_0042880b:
				(*pcVar9)(i, 0, 0x8000);
			}
			local_18 = buf2;
			if (buf2 != (undefined1 *)0x0)
			{
				psVar20 = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
				size = psVar20;
				if (((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
					((*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550 &&
					  (success= *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
					   success!= 0))))
				{
					uVar17 = 0;
					iVar8 = *(int *)(success+ 0x20);
					local_14 = *(int *)(success+ 0x1c) + (int)psVar20;
					local_10 = *(int *)(success+ 0x24) + (int)psVar20;
					if (*(int *)(success+ 0x18) != 0)
					{
						do
						{
							uVar14 = 0;
							local_c = 0;
							puVar12 = (uint8_t *)(*(int *)((int)psVar20 + uVar17 * 4 + iVar8) + (int)psVar20);
							if (puVar12 != (uint8_t *)0x0)
							{
								uVar2 = *puVar12;
								uVar11 = uVar14;
								while (uVar14 = uVar11, uVar2 != '\0')
								{
									uVar11 = uVar14 + 1;
									local_c = uVar14;
									uVar2 = puVar12[uVar14 + 1];
								}
							}
							iVar7 = hasher(puVar12, uVar14);
							if (iVar7 == 0x1d499ba0)
								goto LAB_004286f8;
							uVar17 = uVar17 + 1;
						} while (uVar17 < *(uint *)(success+ 0x18));
					}
				}
				goto LAB_004286e2;
			}
		}
	}
	else
	{
		local_18 = buf;
		if (buf != (undefined1 *)0x0)
		{
			psVar20 = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
			size = psVar20;
			if ((((psVar20 != (short *)0x0) && (*psVar20 == 0x5a4d)) &&
				 (*(int *)(*(int *)(psVar20 + 0x1e) + (int)psVar20) == 0x4550)) &&
				(success= *(int *)(*(int *)(psVar20 + 0x1e) + 0x78 + (int)psVar20) + (int)psVar20,
				 success!= 0))
			{
				uVar17 = 0;
				iVar8 = *(int *)(success+ 0x20);
				local_14 = *(int *)(success+ 0x1c) + (int)psVar20;
				local_10 = *(int *)(success+ 0x24) + (int)psVar20;
				if (*(int *)(success+ 0x18) != 0)
				{
					do
					{
						uVar14 = 0;
						local_c = 0;
						puVar12 = (uint8_t *)(*(int *)((int)psVar20 + uVar17 * 4 + iVar8) + (int)psVar20);
						if (puVar12 != (uint8_t *)0x0)
						{
							uVar2 = *puVar12;
							uVar11 = uVar14;
							while (uVar14 = uVar11, uVar2 != '\0')
							{
								uVar11 = uVar14 + 1;
								local_c = uVar14;
								uVar2 = puVar12[uVar14 + 1];
							}
						}
						iVar7 = hasher(puVar12, uVar14);
						if (iVar7 == 0x1d499ba0)
						{
						LAB_004286f8:
							(*(code *)(*(int *)(local_14 + (uint) * (ushort *)(local_10 + uVar17 * 2) * 4) +
									   (int)psVar20))(local_18, 0, 0x8000);
							return;
						}
						uVar17 = uVar17 + 1;
					} while (uVar17 < *(uint *)(success+ 0x18));
				}
			}
		LAB_004286e2:
			(*(code *)0x0)(local_18, 0, 0x8000);
			return;
		}
	}

	return;
}
