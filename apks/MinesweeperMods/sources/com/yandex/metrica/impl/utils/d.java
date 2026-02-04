package com.yandex.metrica.impl.utils;

import android.util.Base64;
import com.yandex.metrica.impl.bk;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class d {
    private final String a;
    private final String b;

    public d() {
        this("AES/CBC/PKCS7Padding", "RSA/ECB/PKCS1Padding");
    }

    d(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public byte[] a(byte[] bArr) {
        try {
            SecureRandom secureRandom = new SecureRandom();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[16];
            secureRandom.nextBytes(bArr3);
            secureRandom.nextBytes(bArr2);
            return a(bArr, bArr3, bArr2, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDhmH/m2qrRjxDHP794CeaZpENQNYydf8pqyXJilo6XxK+n+pvo27VxWfB3Z1yHrtKow+eZXKLQzrQ8wZMfRgADrYCQJ20y2hGZEUCN1tGSM+xqVKMeCtVi3NvQa54Cx7mT5ECVsH5DKEs/aeScDHP56FzcgEbtOSwyRZ8dsEM0wwIDAQAB", 0))));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return null;
        }
    }

    byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, PublicKey publicKey) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        byte[] byteArray = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance(this.a);
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            Cipher cipher2 = Cipher.getInstance(this.b);
            cipher2.init(1, publicKey);
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            try {
                byte[] bArrDoFinal = cipher.doFinal(bArr);
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(bArr2.length + bArr3.length);
                byteArrayOutputStream2.write(bArr2);
                byteArrayOutputStream2.write(bArr3);
                byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                byteArrayOutputStream2.close();
                byteArrayOutputStream.write(cipher2.doFinal(byteArray2));
                byteArrayOutputStream.write(bArrDoFinal);
                byteArray = byteArrayOutputStream.toByteArray();
                bk.a((Closeable) byteArrayOutputStream);
            } catch (Exception e) {
                bk.a((Closeable) byteArrayOutputStream);
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                bk.a((Closeable) byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            byteArrayOutputStream = null;
            th = th3;
        }
        return byteArray;
    }
}
