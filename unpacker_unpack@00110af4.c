
/* unpacker_unpack(void*, unsigned long*) */

void unpacker_unpack(void *array_address,ulong *number_elements)

{
  unpacker_unpack(array_address,number_elements,__bss_start);
  return;
}

