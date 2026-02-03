
/* xor_array(void*, unsigned long, int, char*) */

void xor_array(char *array_address, ulong number_elements, int i, char *local_10)

{
	
	if (i < number_elements)
	{
		array_address[i] = array_address[i] ^ *local_10;
		if (i+1 < number_elements)
		{
	
			array_address[i+1] = array_address[i+1] ^ local_10[1];
			if (i+2 < number_elements)
			{

				array_address[i+2] = array_address[i+2] ^ local_10[2];
				if (i+3 < number_elements)
				{
					array_address[i+3] = array_address[i+3] ^ local_10[3];
				}
			}
		}
	}
	return;
}
