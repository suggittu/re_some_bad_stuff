package com.yandex.metrica.impl.ob;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* loaded from: classes.dex */
public class cr extends CertificateException {
    public cr(dl dlVar) {
        super("There is not pinned certificates among chain " + a(dlVar.a()));
    }

    private static String a(X509Certificate[] x509CertificateArr) {
        StringBuilder sb = new StringBuilder();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            sb.append("ISSUER=" + x509Certificate.getIssuerDN().toString() + "\n");
        }
        return sb.toString();
    }
}
