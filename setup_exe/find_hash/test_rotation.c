#include <stdio.h> 
int main()
{
    char a = 55;
    a = a & 0xfff;
    printf("Value: %d\n", a);
}