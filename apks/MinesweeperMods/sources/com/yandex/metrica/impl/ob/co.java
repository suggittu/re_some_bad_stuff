package com.yandex.metrica.impl.ob;

import java.security.cert.X509Certificate;

/* loaded from: classes.dex */
class co implements cx {
    private final cq a;
    private final cq b;
    private final cq c;

    co(de deVar) {
        this.a = new cq(deVar.a());
        this.b = new cu(deVar.b());
        this.c = new cq(deVar.c());
    }

    @Override // com.yandex.metrica.impl.ob.cx
    public boolean a(X509Certificate[] x509CertificateArr) {
        return this.a.a(x509CertificateArr);
    }

    @Override // com.yandex.metrica.impl.ob.cx
    public boolean b(X509Certificate[] x509CertificateArr) {
        return this.b.a(x509CertificateArr);
    }

    @Override // com.yandex.metrica.impl.ob.cx
    public boolean c(X509Certificate[] x509CertificateArr) {
        return this.c.a(x509CertificateArr);
    }
}
