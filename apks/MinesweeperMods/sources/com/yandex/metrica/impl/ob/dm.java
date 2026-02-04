package com.yandex.metrica.impl.ob;

import android.os.Build;
import android.util.Base64;
import com.yandex.metrica.impl.ob.dd;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;

/* loaded from: classes.dex */
class dm {
    static String a(X509Certificate x509Certificate) {
        try {
            return Base64.encodeToString(MessageDigest.getInstance("SHA-256").digest(x509Certificate.getPublicKey().getEncoded()), 2);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    static dy a(List<X509Certificate> list) throws GeneralSecurityException, IOException {
        TrustManager[] trustManagers;
        ds drVar;
        if (list == null || list.isEmpty()) {
            trustManagers = null;
        } else {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                keyStore.setCertificateEntry("ca" + i2, list.get(i2));
                i = i2 + 1;
            }
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            trustManagers = trustManagerFactory.getTrustManagers();
        }
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, trustManagers, null);
        if (Build.VERSION.SDK_INT >= 9) {
            drVar = new dt(sSLContext.getSocketFactory());
        } else {
            dd.a aVar = new dd.a(sSLContext);
            PlainSocketFactory socketFactory = PlainSocketFactory.getSocketFactory();
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", socketFactory, 80));
            schemeRegistry.register(new Scheme("https", aVar, 443));
            drVar = new dr(new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams));
        }
        return new dy(new dw(drVar));
    }

    static boolean a(dj djVar) {
        return !"https://certificate.mobile.yandex.net/api/v1/pins".equals(djVar.b());
    }
}
