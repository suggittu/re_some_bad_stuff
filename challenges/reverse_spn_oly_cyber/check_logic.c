undefined8 check_logic(char *passwd)

{
    int iVar1;
    size_t lenght;
    undefined8 uVar3;
    byte local_68[8];
    ulong bytes_xored;
    ulong buffer[8];
    int k;
    int j;
    int i;

    memset(buffer, 0, 0x31);
    lenght = strlen(passwd);

    for (i = 0; i < 6; i = i + 1) //guarda 8 char alla volta
    {
        local_68[0] = 0;
        local_68[1] = 0;
        local_68[2] = 0;
        local_68[3] = 0;
        local_68[4] = 0;
        local_68[5] = 0;
        local_68[6] = 0;
        local_68[7] = 0;
        //fa lo xor con deadbeef...
        buffer[0] = DAT_00104080 ^ *(passwd + i * 8); // DAT_00104080 = bebafecaefbeadde(little endian) -> 0xDEADBEEFCAFEBABE

        
        for (j = 0; j < 8; j = j + 1)//P-BOX
        {
            local_68[DAT_001040a0[j]] = *(buffer + j ); // 4625137 (-8 perché per prima accede a bytes_xored che è la variabile prima nello stack) 
                                                        //ora ha piu senso, ho sostituito il byte che usava ghidra con buffer[0]
        }

        for (k = 0; k < 8; k = k + 1)//S-BOX
        {
            *(buffer + k) = *(&DAT_001040c0 + local_68[k] * 4); // DAT_001040c0 è lunga 255 * 4
            buffer[i] = bytes_xored;
        }
        iVar1 = memcmp(buffer, PTR_DAT_001044c0, 0x30); //613d9554f622db60bdf86c1fd986743d70f80816d9616555e88c161da708640c7e1f2a289b3abd4ef85dae164114bd0a
        return iVar1;
    }

}
