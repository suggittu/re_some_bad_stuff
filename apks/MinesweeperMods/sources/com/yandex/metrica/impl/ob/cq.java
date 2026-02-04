package com.yandex.metrica.impl.ob;

import java.security.cert.X509Certificate;
import java.util.Set;

/* loaded from: classes.dex */
class cq {
    private dh a;

    public cq(dh dhVar) {
        this.a = dhVar;
    }

    public boolean a(X509Certificate[] x509CertificateArr) {
        Set<String> setB = this.a.b();
        if (setB.isEmpty()) {
            return false;
        }
        for (X509Certificate x509Certificate : x509CertificateArr) {
            if (setB.contains(dm.a(x509Certificate))) {
                return true;
            }
        }
        return false;
    }
}
