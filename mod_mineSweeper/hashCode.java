import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class HashCalc {
    public static void main(String[] args) {
        // --- OPTION 1: Hashing the SHA256 Fingerprint String ---
        String hexString = "3AC2A71A1D2B68DB5F1B8FAFB3D6AB2FD03A62008DC981C43D3F67D9A5487EE2";
        byte[] fingerprintBytes = hexToByteArray(hexString);
        printResults("Fingerprint Hash", hexString, Arrays.hashCode(fingerprintBytes));

        // --- OPTION 2: Hashing the actual Certificate File (mSignature) ---
        // Change "cert.der" to the path of your extracted certificate file
        try {
            byte[] certBytes = Files.readAllBytes(Paths.get("cert.der"));
            printResults("Actual mSignature Hash", "Raw Binary File", Arrays.hashCode(certBytes));
        } catch (IOException e) {
            System.out.println("\n[!] Could not find 'cert.der'. Please extract it from the .RSA first.");
        }
    }

    private static void printResults(String label, String input, int hashCode) {
        System.out.println("\n--- " + label + " ---");
        System.out.println("Input: " + input);
        System.out.println("Decimal HashCode: " + hashCode);
        System.out.println("Hex HashCode: 0x" + Integer.toHexString(hashCode));
    }

    public static byte[] hexToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}