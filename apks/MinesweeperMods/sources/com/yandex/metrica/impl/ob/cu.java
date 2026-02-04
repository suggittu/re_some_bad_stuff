package com.yandex.metrica.impl.ob;

import java.security.cert.X509Certificate;
import java.util.Set;

/* loaded from: classes.dex */
public class cu extends cq {
    private dh a;

    public cu(dh dhVar) {
        super(dhVar);
        this.a = dhVar;
    }

    @Override // com.yandex.metrica.impl.ob.cq
    public boolean a(X509Certificate[] x509CertificateArr) {
        Set<String> setB = this.a.b();
        if (setB.isEmpty()) {
            return false;
        }
        return setB.contains(dm.a(x509CertificateArr[0]));
    }
}
