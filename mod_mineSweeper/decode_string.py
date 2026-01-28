import base64

def decrypt(b64_str):
    # Key from local_10: 00 BC 53 6B
    key = [0x00, 0xBC, 0x53, 0x6B]
    
    # Corrected function name: b64decode
    data = base64.b64decode(b64_str)
    
    decrypted = ""
    for i in range(len(data)):
        # Apply XOR cyclically
        decrypted += chr(data[i] ^ key[i % len(key)])
    return decrypted

# This should now return "java/lang/ClassLoader"
print(decrypt("Z9knKGxhc3NMb2FkZXI="))