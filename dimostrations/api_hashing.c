#include <windows.h>
#include <stdio.h>
#include <stdint.h>

// Calculate hash of a function name (XOR with a constant, then ROR)
DWORD CalculateHash(const char *str, DWORD xorConstant)
{
    DWORD hash = 0;
    while (*str)
    {
        hash = (hash >> 13) | (hash << 19); // ROR 13
        hash += (*str ^ xorConstant);       // XOR with constant
        str++;
    }
    return hash;
}

// Find function by hash in a specific module
FARPROC FindFunctionByHash(HMODULE hModule, DWORD targetHash, DWORD xorConstant)
{
    if (!hModule)
        return NULL;

    // Get DOS header
    PIMAGE_DOS_HEADER pDosHeader = (PIMAGE_DOS_HEADER)hModule;
    if (pDosHeader->e_magic != IMAGE_DOS_SIGNATURE)
    {
        return NULL;
    }

    // Get NT headers
    PIMAGE_NT_HEADERS pNtHeaders = (PIMAGE_NT_HEADERS)((BYTE *)hModule + pDosHeader->e_lfanew);
    if (pNtHeaders->Signature != IMAGE_NT_SIGNATURE)
    {
        return NULL;
    }

    // Get export directory
    DWORD exportRVA = pNtHeaders->OptionalHeader.DataDirectory[IMAGE_DIRECTORY_ENTRY_EXPORT].VirtualAddress;
    if (!exportRVA)
        return NULL;

    PIMAGE_EXPORT_DIRECTORY pExportDir = (PIMAGE_EXPORT_DIRECTORY)((BYTE *)hModule + exportRVA);

    // Get pointers to export tables
    DWORD *nameRVAs = (DWORD *)((BYTE *)hModule + pExportDir->AddressOfNames);
    WORD *ordinalRVAs = (WORD *)((BYTE *)hModule + pExportDir->AddressOfNameOrdinals);
    DWORD *functionRVAs = (DWORD *)((BYTE *)hModule + pExportDir->AddressOfFunctions);

    // Iterate through exported functions
    for (DWORD i = 0; i < pExportDir->NumberOfNames; i++)
    {
        const char *functionName = (const char *)((BYTE *)hModule + nameRVAs[i]);

        // Calculate hash of function name
        DWORD functionHash = CalculateHash(functionName, xorConstant);

        // Compare with target hash
        if (functionHash == targetHash)
        {
            // Get function address
            DWORD functionRVA = functionRVAs[ordinalRVAs[i]];
            return (FARPROC)((BYTE *)hModule + functionRVA);
        }
    }

    return NULL;
}

// Find function by hash in all loaded modules
FARPROC FindFunctionInAllModules(DWORD targetHash, DWORD xorConstant, HMODULE *foundInModule)
{
// Get the PEB (Process Environment Block)
#ifdef _WIN64
    PPEB pPeb = (PPEB)__readgsqword(0x60);
#else
    PPEB pPeb = (PPEB)__readfsdword(0x30);
#endif

    // Walk the module list
    PEB_LDR_DATA *ldr = pPeb->Ldr;
    LIST_ENTRY *moduleList = &ldr->InMemoryOrderModuleList;

    for (LIST_ENTRY *entry = moduleList->Flink; entry != moduleList; entry = entry->Flink)
    {
        LDR_DATA_TABLE_ENTRY *module = CONTAINING_RECORD(entry, LDR_DATA_TABLE_ENTRY, InMemoryOrderLinks);

        if (module->DllBase)
        {
            FARPROC func = FindFunctionByHash((HMODULE)module->DllBase, targetHash, xorConstant);
            if (func)
            {
                if (foundInModule)
                    *foundInModule = (HMODULE)module->DllBase;
                return func;
            }
        }
    }

    return NULL;
}

// Main usage example
int main()
{
    // Configuration
    DWORD xorConstant = 0xDEADBEEF; // Your XOR constant

    // Precomputed hashes (you need to calculate these in advance)
    DWORD winExecHash = 0;     // Calculate this for "WinExec"
    DWORD loadLibraryHash = 0; // Calculate this for "LoadLibraryA"
    DWORD getProcAddrHash = 0; // Calculate this for "GetProcAddress"

    // Example: Calculate hash for "MessageBoxA" at runtime to see the value
    const char *testFunc = "MessageBoxA";
    DWORD testHash = CalculateHash(testFunc, xorConstant);
    printf("Hash for '%s' with XOR 0x%08X: 0x%08X\n", testFunc, xorConstant, testHash);

    // If we had precomputed hash for MessageBoxA, we could find it like this:
    // HMODULE foundModule = NULL;
    // FARPROC func = FindFunctionInAllModules(precomputedMessageBoxHash, xorConstant, &foundModule);
    // if (func) {
    //     printf("Found function at 0x%p in module 0x%p\n", func, foundModule);
    // }

    // To use this in shellcode/similar, you would:
    // 1. Calculate hashes offline for functions you need
    // 2. Store only the hashes in your code
    // 3. At runtime, search for functions using these hashes

    // Helper: Calculate hashes for common functions
    printf("\nCommon function hashes (XOR=0x%08X):\n", xorConstant);
    const char *commonFuncs[] = {
        "WinExec", "LoadLibraryA", "GetProcAddress",
        "VirtualAlloc", "VirtualProtect", "CreateProcessA",
        "MessageBoxA", "ExitProcess", NULL};

    for (int i = 0; commonFuncs[i]; i++)
    {
        DWORD hash = CalculateHash(commonFuncs[i], xorConstant);
        printf("  %-20s: 0x%08X\n", commonFuncs[i], hash);
    }

    return 0;
}

// Alternative: Simpler PEB walking for educational purposes
FARPROC FindFunctionSimple(DWORD targetHash, DWORD xorConstant)
{
    HMODULE modules[1024];
    DWORD needed;

    // Get list of all modules in current process
    if (EnumProcessModules(GetCurrentProcess(), modules, sizeof(modules), &needed))
    {
        DWORD moduleCount = needed / sizeof(HMODULE);

        for (DWORD i = 0; i < moduleCount; i++)
        {
            FARPROC func = FindFunctionByHash(modules[i], targetHash, xorConstant);
            if (func)
            {
                return func;
            }
        }
    }

    return NULL;
}