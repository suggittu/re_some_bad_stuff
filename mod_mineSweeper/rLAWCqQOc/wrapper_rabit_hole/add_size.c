
size_t * add_size(undefined1 *start_string,undefined1 *finish_string)

{
  size_t *buffer;
  size_t *__dest;
  size_t lenght;
  
  if (start_string == finish_string) {
    return (size_t *)&DAT_001ad738;
  }
  if ((start_string == (undefined1 *)0x0) && (finish_string != (undefined1 *)0x0)) {
                    /* WARNING: Subroutine does not return */
    FUN_001497e0("basic_string::_S_construct null not valid");
  }
  lenght = (long)finish_string - (long)start_string;
  buffer = (size_t *)buffer(lenght,0);
  __dest = buffer + 3;
  if (lenght == 1) 
  {
    *(buffer + 3) = *start_string;
  }
  else 
  {
    __dest = memcpy(__dest,start_string,lenght);
  }
  if (buffer != &DAT_001ad720) {
    *(buffer + 2) = 0;
    *buffer = lenght;
    *(buffer + lenght + 0x18) = 0;
  }
  return __dest;
}

