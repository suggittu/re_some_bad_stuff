
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */
/* unpacker_unpack(void*, unsigned long*, unsigned int) */

void unpacker_unpack(char *array_address, ulong *number_elements, uint __bss_start)

{
	int iVar1;
	void *pvVar2;
	ulong number_elements_copy;
	ulong uVar4;
	local_10 = random_value;

	circle_xor(array_address, *number_elements, 0);
	number_elements_copy = *number_elements;
	if (number_elements_copy == 0)
	{
		pvVar2 = (void *)0x0;
	}
	else
	{
		for(int i = 0; i < number_elements; i++)
		{
			xor_array(array_address, number_elements_copy, i, &local_10);
			number_elements_copy = *number_elements;
		}
		uVar4 = array_address[4] + 5;
		if (number_elements_copy < uVar4)
		{
			pvVar2 = (void *)0x0;
		}
		else
		{
			number_elements_copy = number_elements_copy - uVar4;
			pvVar2 = operator_new__(number_elements_copy);
			pvVar2 = memcpy(pvVar2, (void *)((long)array_address + uVar4), number_elements_copy);
			*number_elements = number_elements_copy;
		}
	}
}
