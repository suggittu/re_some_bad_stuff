undefined8 check_logic(char *passwd)

{
    int iVar1;
    size_t lenght;
    undefined8 uVar3;
    byte local_68[8];
    ulong local_60;
    ulong buffer[8];
    int k;
    int j;
    int i;

    memset(buffer, 0, 0x31);
    lenght = strlen(passwd);
    if (lenght == 0x30)
    {
        for (i = 0; i < 6; i = i + 1)
        {
            local_68[0] = 0;
            local_68[1] = 0;
            local_68[2] = 0;
            local_68[3] = 0;
            local_68[4] = 0;
            local_68[5] = 0;
            local_68[6] = 0;
            local_68[7] = 0;
            local_60 = DAT_00104080 ^ *(passwd + i * 8); //DAT_00104080 = bebafecaefbeadde(little endian) -> 0xDEADBEEFCAFEBABE
            for (j = 0; j < 8; j = j + 1)
            {
                local_68[*(&DAT_001040a0 + j * 4)] = *(buffer + j + -8); //0000000004000000060000000200000005000000010000000300000007000000
            }
            for (k = 0; k < 8; k = k + 1)
            {
                *(buffer + k + -8) = *(&DAT_001040c0 + local_68[k] * 4); //
            buffer[i] = local_60;
        }
        iVar1 = memcmp(buffer, PTR_DAT_001044c0, 0x30);
        if (iVar1 == 0)
        {
            uVar3 = 1;
        }
        else
        {
            uVar3 = 0;
        }
    }
    else
    {
        uVar3 = 0;
    }
    return uVar3;
}
