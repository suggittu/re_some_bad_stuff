
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */
/* replaceStringForInt(int) */

void replaceStringForInt(int param_1)

{
	int iVar1;
	char cVar2;
	bool bVar3;
	char *__dest;
	char *pcVar4;
	int *piVar5;
	long taken_string;
	char *local_18;
	char local_10[8];
	long local_8;

	local_8 = ___stack_chk_guard;
	if ((uint)param_1 < 0x2c)
	{
		local_10[3] = 0x6b;
		local_10[2] = 0x53;
		local_10[0] = '\0';
		local_10[1] = 0xbc;
		FUN_0014d980(&taken_string, (&arrayDiStringheBase64)[param_1], &local_18);
		base64_decode(&taken_string);
		__dest = operator_new__(0x400);
		pcVar4 = stpcpy(__dest, local_18); // local_18 non viene mai inizializzata
		xor_array(__dest, __dest.lenght(), 0, local_10);

		if (local_18 + -0x18 != &MaiInizilazzata) 
		{
			piVar5 = (local_18 + -8);
			do
			{
				iVar1 = *piVar5;
				cVar2 = '\x01';
				bVar3 = (bool)ExclusiveMonitorPass(piVar5, 0x10);
				if (bVar3)
				{
					*piVar5 = iVar1 + -1;
					cVar2 = ExclusiveMonitorsStatus();
				}
			} while (cVar2 != '\0');
			if (iVar1 < 1)
			{
				operator_delete(local_18 + -0x18);
			}
		}
		if ((undefined8 *)(taken_string + -0x18) != &MaiInizilazzata)
		{
			piVar5 = (int *)(taken_string + -8);
			do
			{
				iVar1 = *piVar5;
				cVar2 = '\x01';
				bVar3 = (bool)ExclusiveMonitorPass(piVar5, 0x10);
				if (bVar3)
				{
					*piVar5 = iVar1 + -1;
					cVar2 = ExclusiveMonitorsStatus();
				}
			} while (cVar2 != '\0');
			if (iVar1 < 1)
			{
				operator_delete((undefined8 *)(taken_string + -0x18));
			}
		}
	}
	else
	{
		__dest = "";
	}
	if (local_8 != ___stack_chk_guard)
	{
		/* WARNING: Subroutine does not return */
		__stack_chk_fail(__dest);
	}
	return;
}
