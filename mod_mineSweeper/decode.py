import base64

def decrypt_malware_string(encoded_str):
    # 1. Clean the string from possible debris
    s = encoded_str.strip().replace('"', '').replace(' ', '')
    
    # 2. Fix Base64 alignment 
    # Base64 strings must be multiples of 4. If length % 4 == 1, 
    # the last character is usually a partial/garbage byte from truncation.
    data_chars = s.rstrip('=')
    if len(data_chars) % 4 == 1:
        s = data_chars[:-1]
    
    # 3. Re-apply correct padding
    missing_padding = len(s) % 4
    if missing_padding:
        s += '=' * (4 - missing_padding)

    try:
        # 4. Decode to raw bytes
        data = bytearray(base64.b64decode(s))
        
        # 5. The XOR Key from your C code (local_10)
        # local_10[0]=0x00, local_10[1]=0xbc, local_10[2]=0x53, local_10[3]=0x6b
        key = [0x00, 0xbc, 0x53, 0x6b]
        
        # 6. XOR only the first 4 bytes (as per the nested 'if' in xor_array)
        for i in range(min(4, len(data))):
            data[i] = data[i] ^ key[i]
            
        return data.decode('utf-8', errors='ignore')
    except Exception:
        return "[Decoding Error]"

# The full list of strings in your exact order
encoded_strings = [
    "at0lCi9pby9GaWxl",
    "Z9knKGxhc3NMb2FkZXI=",
    "KJUfAWF2YS9sYW5nL0NsYXNzTG9hZGVyOw==",
    "at0lCi9sYW5nL1N0cmluZw==",
    "at0lCi91dGlsL3ppcC9aaXBGaWxl",
    "ZN0/HWlrL3N5c3RlbS9EZXhGaWxl",
    "bd04DkRleEVsZW1lbnRz",
    "KPA5CnZhL3V0aWwvQXJyYXlMaXN0O0xqYXZhL2lvL0ZpbGU7KVtMZGFsdmlr",
    "KPA5CnZhL3V0aWwvQXJyYXlMaXN0O0xqYXZhL2lvL0ZpbGU7TGphdmEvdXRp",
    "bd04DlBhdGhFbGVtZW50cw==",
    "KPA5CnZhL3V0aWwvTGlzdDtMamF2YS9pby9GaWxlO0xqYXZhL3V0aWwvTGlz",
    "TNgyB3Zpay9zeXN0ZW0vRGV4UGF0aExpc3Q7",
    "at0lCi9sYW5nL1N0cmluZ0J1aWxkZXI=",
    "KPA5CnZhL2lvL0ZpbGU7KVY=",
    "KPA5CnZhL2xhbmcvU3RyaW5nO0xqYXZhL2xhbmcvU3RyaW5nO0kpTGRhbHZp",
    "PNU9AnQ+",
    "KPA5CnZhL2lvL0ZpbGU7TGphdmEvbGFuZy9TdHJpbmc7KVY=",
    "KJUfAWF2YS9sYW5nL1N0cmluZzs=",
    "KPA5CnZhL2xhbmcvU3RyaW5nOylW",
    "YcwjDm5k",
    "KP96J2phdmEvbGFuZy9TdHJpbmdCdWlsZGVyOw==",
    "KPA5CnZhL2xhbmcvU3RyaW5nOylMamF2YS9sYW5nL1N0cmluZ0J1aWxkZXI7",
    "cN0nA0xpc3Q=",
    "ZNkrLmxlbWVudHM=",
    "W/A3Cmx2aWsvc3lzdGVtL0RleFBhdGhMaXN0JEVsZW1lbnQ7",
    "ZN0/HWlrL3N5c3RlbS9EZXhQYXRoTGlzdCRFbGVtZW50",
    "LtgyHy5qYXI=",
    "cN0nAw==",
    "TNYyHWEvbGFuZy9TdHJpbmc7",
    "Z9knKmJzb2x1dGVQYXRo",
    "bewyH2hz",
    "W/A5CnZhL2xhbmcvU3RyaW5nOw==",
    "bfo6B2Vz",
    "W/A5CnZhL2lvL0ZpbGU7",
    "beY6G3M=",
    "W/A5CnZhL3V0aWwvemlwL1ppcEZpbGU7",
    "bfg2E3M=",
    "W/A3Cmx2aWsvc3lzdGVtL0RleEZpbGU7",
    "ZcQ6GHRz",


]

print(f"{'INDEX':<5} | {'DECODED STRING'}")
print("-" * 50)
for idx, s in enumerate(encoded_strings):
    print(f"{idx:<5} | {decrypt_malware_string(s)}")