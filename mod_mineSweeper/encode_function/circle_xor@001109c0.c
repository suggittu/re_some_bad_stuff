
/* circle_xor(void*, unsigned long, int) */

void circle_xor(char *array_address, int number_elements, int just_zero)
{
	byte bVar1;
	byte *pbVar2;
	byte *pbVar3;
	byte bVar4;

	if (number_elements != 0)
	{
		if (just_zero != 0)
		{
			bVar4 = 0;
			for(int i=0;i <= array_address[number_elements]; i++)
			{
				bVar4 = array_address[i] ^ bVar4;
				*array_address = bVar4;
			} 
			return;
		}
		bVar4 = 0;
		for(int i=0;i<= array_address[number_elements];i++)
		{

			*array_address = bVar4 ^ array_address[i];
			bVar4 = array_address[i];
		}
	}
	return;
}
