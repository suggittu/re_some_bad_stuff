int decode_base85(char *encoded_flag, char *input)

{
    byte bVar1;
    size_t lenght_flag;
    ushort **ppuVar2;
    long in_FS_OFFSET;
    int i;
    int increment_4;
    uint local_2c;
    int j;
    int local_24;
    int local_20;
    undefined1 local_14[4];
    long local_10;
    int increment_7;

    local_10 = *(long *)(in_FS_OFFSET + 0x28);
    lenght_flag = strlen(encoded_flag);
    increment_4 = 0;
    for(int i=0;i<lenght_flag;i++)
    {
        if (encoded_flag[i] == 'z')
        {
            input[increment_4] = '\0';
            input[increment_4 + 1] = '\0';
            increment_7 = increment_4 + 3;
            input[increment_4 + 2] = '\0';
            increment_4 = increment_4 + 4;
            input[increment_7] = '\0';
            i = i + 1;
        }
        else
        {
            local_2c = 0;
            for (j = 0; (j < 5 && (j + i < lenght_flag));j++)//al massino 5 caratteri
            {
                bVar1 = encoded_flag[j + i];
                ppuVar2 = __ctype_b_loc();
                if (((*ppuVar2)[bVar1] & 0x4000) == 0)
                    break;
                local_2c = *(&base85_decode_map + bVar1 * 4) + local_2c * 0x55;
            }
            if (j == 0)
                break;
            for (local_24 = j; local_24 < 5; local_24 = local_24 + 1)
            {
                local_2c = local_2c * 0x55 + 0x54;
            }
            for (local_20 = 3; -1 < local_20; local_20 = local_20 + -1)
            {
                local_14[local_20] = (char)local_2c;
                local_2c = local_2c >> 8;
            }
            increment_7 = j;
            if (5 < j)
            {
                increment_7 = 5;
            }
            increment_7 = increment_7 + -1;
            if (0 < increment_7)
            {
                memcpy(input + increment_4, local_14, (long)incremen t_7);
                increment_4 = increment_4 + increment_7;
            }
            i = i + j;
        }
    }
    if (local_10 == *(long *)(in_FS_OFFSET + 0x28))
    {
        return increment_4;
    }
    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
}