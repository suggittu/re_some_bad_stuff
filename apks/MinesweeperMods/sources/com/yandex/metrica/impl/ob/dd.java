package com.yandex.metrica.impl.ob;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class dd {
    public static X509Certificate a(InputStream inputStream) throws IOException {
        try {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    return (X509Certificate) certificateFactory.generateCertificate(bufferedInputStream);
                } finally {
                    bufferedInputStream.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e2) {
            }
        }
    }

    public static X509Certificate a(String str) {
        try {
            return a(new ByteArrayInputStream(str.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class a extends SSLSocketFactory {
        private final SSLContext a;

        public a(SSLContext sSLContext) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
            super(null);
            this.a = sSLContext;
            setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
        public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException {
            return this.a.getSocketFactory().createSocket(socket, host, port, autoClose);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
        public Socket createSocket() throws IOException {
            return this.a.getSocketFactory().createSocket();
        }
    }
}
