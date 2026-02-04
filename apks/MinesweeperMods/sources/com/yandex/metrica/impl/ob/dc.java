package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class dc implements dq {
    private final a a;

    public dc(Context context, dj djVar) {
        this(new dk(context), djVar);
    }

    dc(dk dkVar, dj djVar) {
        if (djVar.d() != null) {
            this.a = new a(dkVar, djVar);
            return;
        }
        throw new IllegalArgumentException("UUID provider must be set");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        throw new UnsupportedOperationException();
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        if (chain == null || chain.length == 0 || authType == null || authType.length() == 0) {
            throw new IllegalArgumentException("null or zero-length parameter");
        }
        if (!b(a(chain))) {
            throw new CertificateException("Can't trust certificate chain");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.a.d().a();
    }

    private boolean c(X509Certificate[] x509CertificateArr) {
        dn dnVarD = this.a.a().d();
        if (dnVarD != null) {
            ReentrantLock reentrantLockA = dnVarD.a();
            reentrantLockA.lock();
            try {
                try {
                    if (d(x509CertificateArr)) {
                        reentrantLockA.unlock();
                        return true;
                    }
                } finally {
                    reentrantLockA.unlock();
                }
            } catch (CertificateException e) {
            }
            if (dnVarD.b()) {
                try {
                    return d(x509CertificateArr);
                } catch (CertificateException e2) {
                }
            }
        }
        return false;
    }

    private boolean e(X509Certificate[] x509CertificateArr) throws CertificateException {
        for (cx cxVar : this.a.e()) {
            if (cxVar.c(x509CertificateArr)) {
                return true;
            }
        }
        this.a.c();
        throw new cr(new dl(x509CertificateArr));
    }

    X509Certificate[] a(X509Certificate[] x509CertificateArr) {
        X509Certificate[] x509CertificateArr2;
        boolean z;
        int i = 0;
        X509Certificate[] x509CertificateArr3 = x509CertificateArr;
        while (i < x509CertificateArr3.length) {
            int i2 = i + 1;
            while (true) {
                if (i2 >= x509CertificateArr3.length) {
                    x509CertificateArr2 = x509CertificateArr3;
                    z = false;
                    break;
                }
                if (!x509CertificateArr3[i].getIssuerDN().equals(x509CertificateArr3[i2].getSubjectDN())) {
                    i2++;
                } else if (i2 == i + 1) {
                    x509CertificateArr2 = x509CertificateArr3;
                    z = true;
                } else {
                    if (x509CertificateArr3 == x509CertificateArr) {
                        x509CertificateArr3 = (X509Certificate[]) x509CertificateArr.clone();
                    }
                    X509Certificate x509Certificate = x509CertificateArr3[i2];
                    x509CertificateArr3[i2] = x509CertificateArr3[i + 1];
                    x509CertificateArr3[i + 1] = x509Certificate;
                    x509CertificateArr2 = x509CertificateArr3;
                    z = true;
                }
            }
            if (z) {
                i++;
                x509CertificateArr3 = x509CertificateArr2;
            } else {
                if (i + 1 != x509CertificateArr2.length) {
                    X509Certificate[] x509CertificateArr4 = new X509Certificate[i + 1];
                    System.arraycopy(x509CertificateArr2, 0, x509CertificateArr4, 0, i + 1);
                    return x509CertificateArr4;
                }
                return x509CertificateArr2;
            }
        }
        return x509CertificateArr3;
    }

    private static class a {
        private final dk a;
        private final dj b;
        private volatile cx[] c;
        private volatile di d;
        private volatile da e;
        private volatile cp f;
        private volatile cw g;

        public a(dk dkVar, dj djVar) {
            this.a = dkVar;
            this.b = djVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public cw a() {
            if (this.g == null) {
                synchronized (this) {
                    if (this.g == null) {
                        this.g = new cw(this.a, this.b);
                    }
                }
            }
            return this.g;
        }

        private cp b() {
            if (this.f == null) {
                synchronized (this) {
                    if (this.f == null) {
                        this.f = new cp();
                    }
                }
            }
            return this.f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public da c() {
            if (this.e == null) {
                synchronized (this) {
                    if (this.e == null) {
                        this.e = new da(b().b());
                    }
                }
            }
            return this.e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public di d() {
            if (this.d == null) {
                synchronized (this) {
                    if (this.d == null) {
                        try {
                            this.d = new di();
                        } catch (GeneralSecurityException e) {
                            throw new IllegalStateException("Can't get system trust manager", e);
                        }
                    }
                }
            }
            return this.d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public cx[] e() {
            if (this.c == null) {
                synchronized (this) {
                    if (this.c == null) {
                        this.c = new cx[]{new co(b()), new cv(a())};
                    }
                }
            }
            return this.c;
        }
    }

    private boolean b(X509Certificate[] x509CertificateArr) throws CertificateException {
        try {
            if (this.a.d().a(x509CertificateArr)) {
                boolean zD = d(x509CertificateArr);
                this.a.a().e();
                return zD;
            }
            throw new CertificateException("System doesn't trust certificate chain");
        } catch (cr e) {
            boolean zC = c(x509CertificateArr);
            if (zC) {
                return zC;
            }
            this.a.c().a(x509CertificateArr);
            return d(x509CertificateArr);
        }
    }

    private boolean d(X509Certificate[] x509CertificateArr) throws CertificateException {
        boolean z;
        cx[] cxVarArrE = this.a.e();
        int length = cxVarArrE.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (cxVarArrE[i].b(x509CertificateArr)) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            for (cx cxVar : this.a.e()) {
                if (cxVar.a(x509CertificateArr)) {
                    throw new CertificateException("There is blacklisted certificate in chain");
                }
            }
            if (!e(x509CertificateArr)) {
                return false;
            }
        }
        return true;
    }
}
