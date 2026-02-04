package com.yandex.metrica.impl.ob;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
class di {
    private Collection<X509TrustManager> a = new ArrayList();

    public di() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
            if (trustManager instanceof X509TrustManager) {
                this.a.add((X509TrustManager) trustManager);
            }
        }
    }

    public boolean a(X509Certificate[] x509CertificateArr) throws CertificateException {
        try {
            Iterator<X509TrustManager> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().checkServerTrusted(x509CertificateArr, "RSA");
            }
            return true;
        } catch (CertificateException e) {
            return false;
        }
    }

    public X509Certificate[] a() {
        ArrayList arrayList = new ArrayList();
        Iterator<X509TrustManager> it = this.a.iterator();
        while (it.hasNext()) {
            arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
        }
        return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
    }
}
