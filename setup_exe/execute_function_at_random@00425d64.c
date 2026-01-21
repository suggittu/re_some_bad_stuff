//questa funzione esegue una funzione a caso (contando cicli di clock) da una tabella
//tutta le funzioni contenute nella tabella non fanno nulla di speciale
void execute_function_at_random(void)

{
  int random_value;
  int iVar1;
  
  if (pretty_random == 0) {
    count_clock_cycle();
  }
  iVar1 = 0x14;
  do {
    random_value = return_value();
    (*(code *)(&PTR_LAB_0042d000)[random_value])();
    iVar1 = iVar1 + -1;
  } while (iVar1 != 0);
  return;
}

