
void count_clock_cycle(void)

{
  undefined8 uVar1;
  
  uVar1 = rdtsc();
  pretty_random = (uint)uVar1 | 1;
  return;
}

