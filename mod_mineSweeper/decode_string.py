import base64

def decrypt_string(b64_data):
    # Key extracted from local_10:
    # local_10[0]=00, [1]=bc, [2]=53, [3]=6b
    key = [0x00, 0xBC, 0x53, 0x6B]
    
    try:
        # 1. Decode from Base64
        binary_data = base64.b64decode(b64_data)
        
        # 2. Apply XOR logic (cycling the 4-byte key)
        decrypted_bytes = bytearray()
        for i in range(len(binary_data)):
            xor_byte = binary_data[i] ^ key[i % 4]
            decrypted_bytes.append(xor_byte)
            
        return decrypted_bytes.decode('utf-8', errors='replace')
    
    except Exception as e:
        return f"Error: {e}"

# The string from your previous attempt
target_string = "Z9knKGxhc3NMb2FkZXI="

print(f"Decoded string: {decrypt_string(target_string)}")