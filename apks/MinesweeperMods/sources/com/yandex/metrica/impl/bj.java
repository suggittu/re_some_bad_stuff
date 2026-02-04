package com.yandex.metrica.impl;

import android.content.ContentValues;
import com.yandex.metrica.impl.au;
import java.io.Closeable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class bj implements Closeable {
    private com.yandex.metrica.impl.ob.i a;
    private final az b;
    private final ag d;
    private final bh e;
    private final Object c = new Object();
    private boolean f = false;
    private Runnable g = new Runnable() { // from class: com.yandex.metrica.impl.bj.1
        @Override // java.lang.Runnable
        public void run() {
            bj.this.a();
        }
    };

    public bj(com.yandex.metrica.impl.ob.i iVar, Executor executor) {
        this.a = iVar;
        this.b = iVar.h();
        this.d = a(iVar, executor);
        this.d.start();
        this.e = a(this.a);
    }

    bh a(com.yandex.metrica.impl.ob.i iVar) {
        return new bh(iVar);
    }

    ag a(com.yandex.metrica.impl.ob.i iVar, Executor executor) {
        ag agVar = new ag(executor);
        agVar.setName("NetworkCore [" + iVar.l() + "]");
        return agVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.c) {
            if (!this.f) {
                d();
                if (this.d.isAlive()) {
                    this.d.a();
                }
                this.f = true;
            }
        }
    }

    public void a() {
        synchronized (this.c) {
            if (!this.f) {
                synchronized (this.c) {
                    if (!this.f) {
                        if (this.e.n()) {
                            this.d.a(this.e);
                        }
                        if (bk.c(this.b.a())) {
                            a(ao.p(), (Long) (-2L));
                            a(au.u(), (Long) null);
                        }
                    }
                }
                d();
            }
        }
    }

    private void a(au.a aVar, Long l) {
        List<ContentValues> listA = this.a.i().a(l);
        if (listA.isEmpty()) {
            listA.add(l.a);
        }
        for (ContentValues contentValues : listA) {
            try {
                this.d.a(aVar.a(this.a).a(contentValues));
            } catch (Exception e) {
                return;
            }
        }
    }

    private void d() {
        this.a.n().removeCallbacks(this.g);
    }

    public void b() {
        synchronized (this.c) {
            if (!this.f) {
                d();
                if (this.a.j().b() > 0) {
                    this.a.n().postDelayed(this.g, TimeUnit.SECONDS.toMillis(this.a.j().b()));
                }
            }
        }
    }

    public void c() {
        synchronized (this.c) {
            if (!this.f && !this.d.b(this.e)) {
                this.e.a(true);
                this.e.a(0L);
                this.d.a(this.e);
            }
        }
    }
}
