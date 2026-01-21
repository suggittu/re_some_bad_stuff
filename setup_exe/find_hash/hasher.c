#include <stdint.h>
#include <string.h>

#define ROTL32(v, n) ((v << n) | (v >> (32 - n)))

void make_rotation(uint32_t* data) {
    uint32_t a = data[0]; // param_1 + 0x0
    uint32_t b = data[1]; // param_1 + 0x4
    uint32_t c = data[2]; // param_1 + 0x8
    uint32_t d = data[3]; // param_1 + 0xc

    uint32_t uVar1, uVar2, uVar3, uVar4, uVar5;


    uVar4 = d;
    uVar3 = b;
    uVar1 = c + uVar4;
    uVar2 = ROTL32(uVar4, 16) ^ uVar1;
    
    uVar4 = ROTL32(uVar3, 13) ^ (a + uVar3);
    uVar1 = uVar1 + uVar4;
    uVar5 = ROTL32(uVar4, 17) ^ uVar1;
    
    uVar4 = uVar2 + (a + uVar3);
    uVar3 = ROTL32(uVar2, 25) ^ uVar4;
    
    uVar4 = uVar5 + uVar4;
    uVar1 = uVar1 + uVar3;
    uVar3 = ROTL32(uVar3, 11) ^ uVar1;

    // Final assignments back to the pointer
    data[2] = ROTL32(uVar5, 5) ^ uVar4 ^ uVar3; // param_1 + 0x8
    data[0] = ROTL32(uVar3, 19);               // param_1 + 0x0
    data[3] = ROTL32(uVar1, 9);                // param_1 + 0xc (uVar1 * 0x200 is << 9)
    data[1] = uVar4 ^ uVar1;                   
}

// Global or external state mentioned in decompilation as "start_as_zero"
uint8_t start_as_zero = 0; 

uint32_t hasher(uint8_t *buf, int len) {
    if (buf == NULL || len <= 0) {
        start_as_zero ^= 0xaa;
        return 0;
    }

    // Internal State
    uint32_t state[4];
    state[0] = 0x1eca950c; // local_30
    state[1] = 0x24aa7021; // uStack_2c
    state[2] = 0x6c92ea91; // uStack_28
    state[3] = 0xbf21234d; // uStack_24

    uint32_t uVar8 = (len < 0x101) ? len : 0x100;
    uint32_t processed_len = 0;

    // Initial mixing
    make_rotation(state);

    uint32_t local_30 = state[0];
    uint32_t uStack_2c = state[1];
    uint32_t uStack_28 = state[2];
    uint32_t uStack_24 = state[3];

    // Main Loop: Process 16-byte blocks
    while ((int)processed_len <= (int)(uVar8 - 0x10)) {
        uint32_t block[4];
        memcpy(block, buf + processed_len, 16);

        // Mix input into internal variables
        uint32_t local_10 = block[0] ^ uVar8;
        uint32_t uStack_c  = block[1] ^ processed_len;
        uint32_t uStack_8  = block[2] ^ 0x1a6ed677;
        uint32_t uStack_4  = block[3] ^ 0x50fc19e3;

        uStack_2c += uStack_c;
        uStack_24 += uStack_4;

        uint32_t uVar4 = local_10 + local_30 + uStack_2c;
        uint32_t uVar9 = ROTL32(uStack_2c, 13) ^ uVar4;
        
        uint32_t uVar1 = uStack_8 + uStack_28 + uStack_24;
        uint32_t uVar10 = ROTL32(uStack_24, 16) ^ uVar1;
        
        uVar1 += uVar9;
        uVar4 += uVar10;
        uVar9 = ROTL32(uVar9, 17) ^ uVar1;
        uVar10 = ROTL32(uVar10, 25) ^ uVar4;
        
        uVar4 += uVar9;
        uVar1 += uVar10;
        uVar10 = ROTL32(uVar10, 11) ^ uVar1;
        
        uint32_t uVar11 = uVar1 ^ uVar4;
        uStack_2c = ROTL32(uVar1, 9) + (ROTL32(uVar9, 5) ^ uVar10 ^ uVar4);
        
        uint32_t uVar4_inner = ROTL32(uVar1, 25) ^ uStack_2c;
        uStack_28 = ROTL32(uVar10, 19) + uVar11;
        
        uint32_t uVar1_inner = ROTL32(uVar11, 13) ^ uStack_28;
        uStack_28 += uVar4_inner;
        uStack_2c += uVar1_inner;
        
        uVar4_inner = ROTL32(uVar4_inner, 25) ^ uStack_28;
        uVar1_inner = ROTL32(uVar1_inner, 17) ^ uStack_2c;
        
        uStack_28 += uVar1_inner;
        uStack_2c += uVar4_inner;
        
        uVar4_inner = ROTL32(uVar4_inner, 11) ^ uStack_2c;
        uStack_24 = ROTL32(uStack_2c, 9);
        uStack_2c ^= uStack_28;
        uStack_28 = ROTL32(uVar1_inner, 5) ^ uVar4_inner ^ uStack_28;
        
        processed_len += 0x10;
        local_30 = ROTL32(uVar4_inner, 19);
        start_as_zero ^= (uint8_t)processed_len;
    }

    // Handle Remaining Bytes (Tail)
    uint32_t remaining = uVar8 - processed_len;
    uint32_t t[4] = {0, 0, 0, 0};
    uint32_t uVar4 = 0, uVar1 = 0, uVar9 = 0, uVar10 = 0;

    if (remaining > 0) {
        memcpy(t, buf + processed_len, remaining);
        uVar1 = t[1] ^ uVar8;
        start_as_zero += (uint8_t)remaining;
        uVar4 = t[0] ^ (remaining * 0x9E3779B9); // 0x9E3779B9 is -0x61c88647
        uVar9 = t[2] ^ processed_len;
        uVar10 = t[3] ^ 0x1a6ed677;
    }

    uVar4 += local_30;
    uVar1 += uStack_2c;
    uVar9 += uStack_28;
    uVar10 += uStack_24;

    // Finalization Rounds (8 times)
    uint32_t local_38 = 0;
    uint32_t i_pi = 0;
    uint32_t local_48 = 0;

    for (int i = 0; i < 8; i++) {
        uint32_t uVar11 = uVar1 + 0x243f6a88 + i_pi;
        i_pi += 0x243f6a88;
        uVar4 = (uVar11 - local_48) + uVar4;
        uVar1 = ROTL32(uVar10, 16) ^ (uVar10 + uVar9);
        uVar11 = ROTL32(uVar11, 13) ^ uVar4;
        uVar4 += uVar1;
        uVar9 = uVar10 + uVar9 + uVar11;
        uVar1 = ROTL32(uVar1, 25) ^ uVar4;
        uVar11 = ROTL32(uVar11, 17) ^ uVar9;
        uVar9 += uVar1;
        uVar10 = ROTL32(uVar1, 11) ^ uVar9;
        uVar1 = uVar11 + uVar4;
        uVar4 = uVar9 ^ uVar1;
        uVar1 = ROTL32(uVar11, 5) ^ uVar10 ^ uVar1;
        uVar9 = ROTL32(uVar9, 9);
        start_as_zero ^= (uint8_t)local_38;
        uVar10 = ROTL32(uVar10, 19) ^ local_38;
        local_38++;
        local_48 += 0x61c88647;
    }

    uVar1 = ROTL32(uVar4, 7) ^ uVar1;
    uVar9 = ROTL32(uVar1, 11) ^ uVar9;
    uVar8 = ROTL32(uVar9, 17) ^ uVar10 ^ uVar8;
    start_as_zero ^= (uint8_t)uVar8;

    return uVar8;
}
int main()
{
const char* nt_api_matrix[] = {
    "CreateFileA",
    "CreateFileW",
    "ReadFile",
    "WriteFile",
    "DeleteFileW",
    "MoveFileExW",
    "GetFileInformationByHandle",
    "CreateProcessA",
    "CreateProcessW",
    "ShellExecuteExW",
    "CreateThread",
    "_beginthreadex",
    "ExitProcess",
    "TerminateProcess",
    "VirtualAlloc",
    "VirtualProtect",
    "VirtualFree",
    "HeapAlloc",
    "HeapFree",
    "malloc",
    "free",
    "LoadLibraryA",
    "LoadLibraryW",
    "GetProcAddress",
    "FreeLibrary",
    "RegOpenKeyExW",
    "RegQueryValueExW",
    "RegSetValueExW",
    "RegCloseKey",
    "Sleep",
    "WaitForSingleObject",
    "WaitForMultipleObjects",
    "CreateMutexW",
    "ReleaseMutex",
    "IsDebuggerPresent",
    "CheckRemoteDebuggerPresent",
    "GetExitCodeProcess",
    "GetCurrentProcessId",
    "socket",
    "connect",
    "send",
    "recv",
    "GetStdHandle",
    "ReadConsoleW",
    "WriteConsoleW"
};

int num_apis = sizeof(nt_api_matrix) / sizeof(nt_api_matrix[0]);

for (int i = 0; i < num_apis; i++)
{
    const char *api_name = nt_api_matrix[i];
    int len = 0;

    // Manual length calculation to avoid string.h if necessary
    while (api_name[len] != '\0')
        len++;

    // Calling your hasher function
    uint32_t hash_result = hasher((uint8_t *)api_name, len);

    printf("API: %-25s | Hash: 0x%08X\n", api_name, hash_result);
}
}


//(shell.dll)"CommandLineToArgvW", "DoEnvironmentSubstA", "DoEnvironmentSubstW", "DragAcceptFiles", "DragFinish", "DragQueryFile", "DragQueryFileA", "DragQueryFileW", "DragQueryPoint", "DuplicateIcon", "ExtractAssociatedIconA", "ExtractAssociatedIconW", "ExtractIconA", "ExtractIconExA", "ExtractIconExW", "ExtractIconW", "FindExecutableA", "FindExecutableW", "SHAppBarMessage", "SHBrowseForFolderA", "SHBrowseForFolderW", "SHCreateDirectoryExA", "SHCreateDirectoryExW", "SHCreateProcessAsUserW", "SHEmptyRecycleBinA", "SHEmptyRecycleBinW", "ShellAboutA", "ShellAboutW", "ShellExecuteA", "ShellExecuteExA", "ShellExecuteExW", "ShellExecuteW", "Shell_NotifyIconA", "Shell_NotifyIconW", "SHFileOperationA", "SHFileOperationW", "SHGetDesktopFolder", "SHGetFileInfoA", "SHGetFileInfoW", "SHGetFolderPathA", "SHGetFolderPathW", "SHGetKnownFolderPath", "SHGetMalloc", "SHGetPathFromIDListA", "SHGetPathFromIDListW", "SHGetSpecialFolderLocation", "SHGetSpecialFolderPathA", "SHGetSpecialFolderPathW", "SHOpenFolderAndSelectItems", "SHQueryRecycleBinA", "SHQueryRecycleBinW"
//dll)"CreateFileA","CreateFileW","ReadFile","WriteFile","DeleteFileW","MoveFileExW","GetFileInformationByHandle","CreateProcessA","CreateProcessW","ShellExecuteExW","CreateThread","_beginthreadex","ExitProcess","TerminateProcess","VirtualAlloc","VirtualProtect","VirtualFree","HeapAlloc","HeapFree","malloc","free","LoadLibraryA","LoadLibraryW","GetProcAddress","FreeLibrary","RegOpenKeyExW","RegQueryValueExW","RegSetValueExW","RegCloseKey","Sleep","WaitForSingleObject","WaitForMultipleObjects","CreateMutexW","ReleaseMutex","IsDebuggerPresent","CheckRemoteDebuggerPresent","GetExitCodeProcess","GetCurrentProcessId","socket","connect","send","recv","GetStdHandle","ReadConsoleW","WriteConsoleW"
//user32 "AdjustWindowRect", "AdjustWindowRectEx", "AppendMenuA", "AppendMenuW", "BeginPaint", "CallNextHookEx", "ChangeDisplaySettingsA", "ChangeDisplaySettingsW", "CheckMenuItem", "ChildWindowFromPoint", "ClientToScreen", "CloseWindow", "CopyIcon", "CopyRect", "CreateWindowExA", "CreateWindowExW", "DefWindowProcA", "DefWindowProcW", "DestroyIcon", "DestroyWindow", "DispatchMessageA", "DispatchMessageW", "DrawIcon", "DrawTextA", "DrawTextW", "EnableMenuItem", "EnableWindow", "EndDialog", "EndPaint", "EnumChildWindows", "EnumDisplayDevicesA", "EnumDisplaySettingsW", "EnumWindows", "FillRect", "FindWindowA", "FindWindowExA", "FindWindowExW", "FindWindowW", "GetActiveWindow", "GetAsyncKeyState", "GetClientRect", "GetDC", "GetDesktopWindow", "GetForegroundWindow", "GetKeyState", "GetMessageA", "GetMessageW", "GetParent", "GetSystemMetrics", "GetWindowLongA", "GetWindowLongW", "GetWindowRect", "GetWindowTextA", "GetWindowTextW", "InvalidateRect", "IsWindow", "IsWindowVisible", "KillTimer", "LoadIconA", "LoadIconW", "MessageBoxA", "MessageBoxW", "MoveWindow", "PeekMessageA", "PeekMessageW", "PostMessageA", "PostMessageW", "PostQuitMessage", "RegisterClassExA", "RegisterClassExW", "ReleaseDC", "ScreenToClient", "SendMessageA", "SendMessageW", "SetFocus", "SetForegroundWindow", "SetParent", "SetTimer", "SetWindowLongA", "SetWindowLongW", "SetWindowPos", "SetWindowTextA", "SetWindowTextW", "ShowCursor", "ShowWindow", "SystemParametersInfoA", "SystemParametersInfoW", "TrackMouseEvent", "TranslateMessage", "UpdateWindow"