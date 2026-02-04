package com.yandex.metrica.impl.ob;

import android.util.Log;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
class da {
    private static final String a = da.class.getSimpleName();
    private cq c;
    private dl g;
    private ArrayList<Object> b = new ArrayList<>();
    private final Lock d = new ReentrantLock();
    private final Lock e = new ReentrantLock();
    private final Condition f = this.d.newCondition();

    da(dh dhVar) {
        this.c = new cu(dhVar);
    }

    void a(X509Certificate[] x509CertificateArr) {
        this.e.lock();
        try {
            if (!this.c.a(x509CertificateArr)) {
                this.g = new dl(x509CertificateArr);
                boolean z = false;
                Iterator<Object> it = this.b.iterator();
                while (it.hasNext()) {
                    it.next();
                    z = true;
                }
                if (z) {
                    Log.i(a, "waiting for trust issue resolve");
                    this.d.lock();
                    while (!this.g.b()) {
                        try {
                            try {
                                this.f.await(30000L, TimeUnit.MILLISECONDS);
                                this.g.c();
                            } catch (InterruptedException e) {
                            }
                        } finally {
                            this.d.unlock();
                        }
                    }
                }
            }
        } finally {
            this.e.unlock();
        }
    }
}
