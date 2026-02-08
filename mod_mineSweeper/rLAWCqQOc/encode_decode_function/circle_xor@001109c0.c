

void circle_xor(char *buf, int size, int flag)
{
	char previus = 0;

	//se la flag è 0 fa questa operazione (in unpacker è sempre 0)
	for (int i = 0; i <= buf[size]; i++)
	{

		*buf = previus ^ buf[i];
		previus = buf[i];
	}

	return;
}
