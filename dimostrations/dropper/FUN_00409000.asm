
FUN_00409000                      
XCHG    EAX,ECX
MOV     ESI,ESP
LODSD   ESI
DEC     CL
    LAB_00409006
XOR     byte ptr [EAX + ECX*0x1],0xb0

LOOP    LAB_00409006
RET
