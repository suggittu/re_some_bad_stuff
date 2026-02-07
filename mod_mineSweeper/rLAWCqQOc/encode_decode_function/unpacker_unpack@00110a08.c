
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */
/* unpacker_unpack(void*, unsigned long*, unsigned int) */

void unpacker_unpack(char *buf, int *ref_size,char *key)

{
	int iVar1;
	int size;
	char key;

	int real_size_of_file;

	circle_xor(buf, *ref_size, 0);
	size = *ref_size;
	if (size == 0)
	{
		return;
	}
	for (int i = 1; i < size; i++)
	{
		xor_array(buf, size, i-1, &key);
	}
	real_size_of_file =  buf[4] + 5;
	buf.resize(real_size_of_file)

}
