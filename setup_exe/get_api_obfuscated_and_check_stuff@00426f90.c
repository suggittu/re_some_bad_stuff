
undefined4 get_api_obfuscated_and_check_stuff(void)

{
	short *psVar1;
	uint8_t uVar2;
	short sVar3;
	uint uVar4;
	char *pcVar5;
	undefined *return_3b0991ae;
	int iVar7;
	int AddressOfNames;
	uint8_t *puVar9;
	short *psVar10;
	int iVar11;
	short *psVar12;
	uint len;
	short *psVar13;
	char *pcVar14;
	int export_directory;
	code *function_147dd28;
	code *function_3b0991ae;
	uint uVar18;
	int unaff_FS_OFFSET;
	bool bVar19;
	short *addressOfFunctions;
	short *copy_table_export;
	short *AddressOfnameOrdinals;
	short *local_24;
	int iStack_20;
	int iStack_1c;
	char *RB[2];
	int iStack_10;
	undefined *puStack_c;
	undefined *local_8[2];
	short *dll_base;
	// the FS segment register points to the Thread Information Block (TIB)
	// The offset 0x30 within the TIB always contains a pointer to the PEB (Process Environment Block)
	// ci sono lì informazioni sul processo come i moduli caricati, argomenti passati...
	// At offset 0x0c inside the PEB structure, there is a pointer to PEB_LDR_DATA
	// Qui nello specifico ci sono i moduli caricati
	// PEB_LDR_DATA structure, at offset 0x0c, is the InLoadOrderModuleList
	// A 0x18 c'è probabilemente ntdll.dll
	// Quindi da questo indirizzo potrà fare chiamaete indirette a api di windows
	dll_base = *(***(*(*(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
	if (dll_base != (short *)0x0)
	{
		copy_table_export = dll_base;
		// 0x5a4d = "MZ" che è DOS Header Magic Number
		// poi nella parte dopo cde if controlla se esiste la export directory
		// if (((*dll_base == 0x5a4d) && (*(*(dll_base + 0x1e) + dll_base) == 0x4550)) &&
		//	(export_directory = *(*(dll_base + 0x1e) + 0x78 + dll_base) + dll_base, export_directory != 0))
		uVar18 = 0;
		AddressOfNames = *(export_directory + 0x20);										  // sono contenuti i nomi delle funzioni
		addressOfFunctions = (*(export_directory + 0x1c) + dll_base);						  // L'indirizzo delle funzioni in se
		AddressOfnameOrdinals = (short *)(*(int *)(export_directory + 0x24) + (int)dll_base); // Connette i due

		for (int i = 0; i < export_directory->NumberOfNames; i++)
		{

			function_name = (uint8_t *)(*(int *)((int)dll_base + AddressOfNames) + (int)dll_base);
			name_lenght = function_name.lenght();
			hashed_name = hasher(function_name, name_lenght);
			if (hashed_name == -0x3b0991ae)
			{
				function_3b0991ae = (*(addressOfFunctions + AddressOfnameOrdinals[i] * 2) + dll_base);
				goto LAB_00427031;
			}
		}
		for (int i = 0; i < export_directory->NumberOfNames; i++)
		{

			function_name = (uint8_t *)(*(int *)((int)dll_base + AddressOfNames) + (int)dll_base);
			name_lenght = function_name.lenght();
			hashed_name = hasher(function_name, name_lenght);
			if (hashed_name == 0x147dd28)
			{
				function_147dd28 = (*(dll_base + addressOfFunctions[i] * 4 + AddressOfNames) + dll_base);
				goto LAB_00427031;
			}
		}

		RB[0] = "R";
		RB[1] = "B";
		local_8[0] = "r";
		local_8[1] = "b";
		return_3b0991ae = (*function_3b0991ae)(); //GetCurrentProcess() or simiar
		buf = 0;
		iStack_20 = 0;
		local_24 = dll_base;
		puStack_c = return_3b0991ae;
		success = call_virtual_alloc(&buf, &iStack_20);
		if ((success == 0) && (buf != (short *)0x0))
		{
			success = (*function_147dd28)(return_3b0991ae, 90, buf, 4); //NtQueryInformationProcess la flag 90 (informazioni non troppo utili sul processo)
			buf = buf;
			if (0 < export_directory)
			{
				uVar18 = 0;
				do
				{
					psVar12 = (short *)RB[uVar18];
					if (buf == (short *)0x0)
					{
						bVar19 = psVar12 == (short *)0x0;
					LAB_004271b4:
						if (bVar19)
						{
							if (buf == (short *)0x0)
							{
								return 1;
							}
							dll_base = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
							copy_table_export = dll_base;
							if ((((dll_base == (short *)0x0) || (*dll_base != 0x5a4d)) ||
								 (*(int *)(*(int *)(dll_base + 0x1e) + (int)dll_base) != 0x4550)) ||
								(export_directory = *(int *)(*(int *)(dll_base + 0x1e) + 0x78 + (int)dll_base) +
													(int)dll_base,
								 export_directory == 0))
								goto LAB_004272f1;
							AddressOfNames = *(int *)(export_directory + 0x1c);
							uVar18 = 0;
							iVar11 = *(int *)(export_directory + 0x20);
							AddressOfnameOrdinals = (short *)(*(int *)(export_directory + 0x24) + (int)dll_base);
							if (*(int *)(export_directory + 0x18) == 0)
								goto LAB_004272f1;
							goto LAB_004272c2;
						}
					}
					else if (psVar12 != (short *)0x0)
					{
						sVar3 = *buf;
						psVar10 = buf;
						while ((sVar3 != 0 && (sVar3 == *psVar12)))
						{
							psVar1 = psVar10 + 1;
							psVar10 = psVar10 + 1;
							psVar12 = psVar12 + 1;
							sVar3 = *psVar1;
						}
						bVar19 = *psVar10 == *psVar12;
						goto LAB_004271b4;
					}
					uVar18 = uVar18 + 1;
				} while (uVar18 < 2);
			}
			if (buf != (short *)0x0)
			{
				psVar12 = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
				AddressOfnameOrdinals = psVar12;
				if (((psVar12 != (short *)0x0) && (*psVar12 == 0x5a4d)) &&
					((*(int *)(*(int *)(psVar12 + 0x1e) + (int)psVar12) == 0x4550 &&
					  (export_directory = *(int *)(*(int *)(psVar12 + 0x1e) + 0x78 + (int)psVar12) + (int)psVar12,
					   export_directory != 0))))
				{
					uVar18 = 0;
					AddressOfNames = *(int *)(export_directory + 0x20);
					iStack_10 = *(int *)(export_directory + 0x1c) + (int)psVar12;
					RB[0] = (char *)(*(int *)(export_directory + 0x24) + (int)psVar12);
					dll_base = local_24;
					if (*(int *)(export_directory + 0x18) != 0)
					{
						do
						{
							iVar11 = 0;
							iStack_1c = 0;
							puVar9 = (uint8_t *)(*(int *)((int)psVar12 + uVar18 * 4 + AddressOfNames) + (int)psVar12);
							if (puVar9 != (uint8_t *)0x0)
							{
								uVar2 = *puVar9;
								iVar7 = iVar11;
								while (iVar11 = iVar7, uVar2 != '\0')
								{
									iVar7 = iVar11 + 1;
									iStack_1c = iVar11;
									uVar2 = puVar9[iVar11 + 1];
								}
							}
							iVar11 = hasher(puVar9, iVar11);
							dll_base = local_24;
							if (iVar11 == 0x1d499ba0)//virtualfree 0x8000 flag for mem_release
							{
								function_1d499ba0= (code *)(*(int *)(iStack_10 +
															(uint) * (ushort *)(RB[0] + uVar18 * 2) * 4) +
												   (int)psVar12);
								goto LAB_00427353;
							}
							uVar18 = uVar18 + 1;
						} while (uVar18 < *(uint *)(export_directory + 0x18));
					}
				}
				function_1d499ba0= (code *)0x0;
			LAB_00427353:
				(*function_1d499ba0)(buf, 0, 0x8000); //chiama VirtualFree
			}

			buf = (short *)0x0;
			iStack_10 = 0;
			export_directory = call_virtual_alloc(&buf, &iStack_10);
			if ((export_directory == 0) && (buf != (short *)0x0))
			{
				export_directory = (*function_147dd28)(dll_base & 0xffff, 0x59, buf, 4); //NtqueryInformationProcess flag 0x59
				dll_base = buf;
				if (0 < export_directory)
				{
					uVar18 = 0;
					do
					{
						buf = (short *)local_8[uVar18];
						if (buf == (short *)0x0)
						{
							bVar19 = buf == (short *)0x0;
						LAB_0042740e:
							if (bVar19)
							{
								if (buf == (short *)0x0)
								{
									return 1;
								}
								buf = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) +
													  0x18);
								local_24 = buf;
								if ((((buf == (short *)0x0) || (*buf != 0x5a4d)) ||
									 (*(int *)(*(int *)(buf + 0x1e) + (int)buf) != 0x4550)) ||
									(export_directory = *(int *)(*(int *)(buf + 0x1e) + 0x78 + (int)buf) + (int)buf, export_directory == 0))
									goto LAB_00427562;
								uVar18 = 0;
								AddressOfnameOrdinals = (short *)(*(int *)(export_directory + 0x1c) + (int)buf);
								iStack_1c = *(int *)(export_directory + 0x20) + (int)buf;
								iStack_20 = *(int *)(export_directory + 0x24) + (int)buf;
								if (*(int *)(export_directory + 0x18) == 0)
									goto LAB_00427562;
								goto LAB_00427530;
							}
						}
						else if (buf != (short *)0x0)
						{
							sVar3 = *buf;
							psVar12 = buf;
							while ((sVar3 != 0 && (sVar3 == *buf)))
							{
								psVar10 = psVar12 + 1;
								psVar12 = psVar12 + 1;
								buf = buf + 1;
								sVar3 = *psVar10;
							}
							bVar19 = *psVar12 == *buf;
							goto LAB_0042740e;
						}
						uVar18 = uVar18 + 1;
					} while (uVar18 < 2);
				}
				if (buf != (short *)0x0)
				{
					buf = *(short **)(*(int *)**(undefined4 **)(*(int *)(*(int *)(unaff_FS_OFFSET + 0x30) + 0xc) + 0xc) + 0x18);
					local_24 = buf;
					if (((buf != (short *)0x0) && (*buf == 0x5a4d)) &&
						((*(int *)(*(int *)(buf + 0x1e) + (int)buf) == 0x4550 &&
						  (export_directory = *(int *)(*(int *)(buf + 0x1e) + 0x78 + (int)buf) + (int)buf,
						   export_directory != 0))))
					{
						uVar18 = 0;
						AddressOfnameOrdinals = (short *)(*(int *)(export_directory + 0x1c) + (int)buf);
						iStack_1c = *(int *)(export_directory + 0x20) + (int)buf;
						iStack_20 = *(int *)(export_directory + 0x24) + (int)buf;
						if (*(int *)(export_directory + 0x18) != 0)
						{
							do
							{
								pcVar14 = (char *)0x0;
								RB[0] = (char *)0x0;
								puVar9 = (uint8_t *)(*(int *)(iStack_1c + uVar18 * 4) + (int)buf);
								if (puVar9 != (uint8_t *)0x0)
								{
									uVar2 = *puVar9;
									pcVar5 = pcVar14;
									while (pcVar14 = pcVar5, uVar2 != '\0')
									{
										pcVar5 = pcVar14 + 1;
										RB[0] = pcVar14;
										uVar2 = puVar9[(int)(pcVar14 + 1)];
									}
								}
								AddressOfNames = hasher(puVar9, (int)pcVar14);
								if (AddressOfNames == 0x1d499ba0)// ancora virtualfree 
								{
									function_1d499ba0= (code *)(*(int *)(AddressOfnameOrdinals +
																(uint) * (ushort *)(iStack_20 + uVar18 * 2) * 2) +
													   (int)buf);
									goto LAB_004275b9;
								}
								uVar18 = uVar18 + 1;
							} while (uVar18 < *(uint *)(export_directory + 0x18));
						}
					}
					function_1d499ba0= (code *)0x0;
				LAB_004275b9:
					(*function_3b0991ae)(dll_base, 0, 0x8000);
				}
			}
			uVar18 = 0;
			local_8[0] = (undefined *)0x419;
			local_8[1] = (undefined *)0x423;
			do
			{
				if (puStack_c == local_8[uVar18])
				{
					return 1;
				}
				uVar18 = uVar18 + 1;
			} while (uVar18 < 2);
		}
	}
	return 0;
LAB_004272c2:
	len = 0;
	local_24 = (short *)0x0;
	puVar9 = (uint8_t *)(*(int *)((int)dll_base + uVar18 * 4 + iVar11) + (int)dll_base);
	if (puVar9 != (uint8_t *)0x0)
	{
		uVar2 = *puVar9;
		uVar4 = len;
		while (len = uVar4, uVar2 != '\0')
		{
			uVar4 = len + 1;
			local_24 = (short *)len;
			uVar2 = puVar9[len + 1];
		}
	}
	iVar7 = hasher(puVar9, len);
	if (iVar7 == 0x1d499ba0)
	{
		function_1d499ba0= (*((int)dll_base + (uint)(ushort)AddressOfnameOrdinals[uVar18] * 4 + AddressOfNames) +
						   (int)dll_base);
		goto LAB_004272f3;
	}
	uVar18 = uVar18 + 1;
	if (*(uint *)(export_directory + 0x18) <= uVar18)
	{
	LAB_004272f1:
		function_1d499ba0= (code *)0x0;
	LAB_004272f3:
		(*function_3b0991ae)(buf, 0, 0x8000);
		return 1;
	}
	goto LAB_004272c2;
LAB_00427530:
	pcVar14 = (char *)0x0;
	RB[0] = (char *)0x0;
	puVar9 = (uint8_t *)(*(int *)(iStack_1c + uVar18 * 4) + (int)buf);
	if (puVar9 != (uint8_t *)0x0)
	{
		uVar2 = *puVar9;
		pcVar5 = pcVar14;
		while (pcVar14 = pcVar5, uVar2 != '\0')
		{
			pcVar5 = pcVar14 + 1;
			RB[0] = pcVar14;
			uVar2 = puVar9[(int)(pcVar14 + 1)];
		}
	}
	AddressOfNames = hasher(puVar9, (int)pcVar14);
	if (AddressOfNames == 0x1d499ba0)
	{
		function_1d499ba0= (code *)(*(int *)(AddressOfnameOrdinals + (uint) * (ushort *)(iStack_20 + uVar18 * 2) * 2) +
						   (int)buf);
		goto LAB_00427564;
	}
	uVar18 = uVar18 + 1;
	if (*(uint *)(export_directory + 0x18) <= uVar18)
	{
	LAB_00427562:
		function_1d499ba0= (code *)0x0;
	LAB_00427564:
		(*function_3b0991ae)(dll_base, 0, 0x8000);
		return 1;
	}
	goto LAB_00427530;
}
