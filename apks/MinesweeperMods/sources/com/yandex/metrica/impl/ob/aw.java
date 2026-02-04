package com.yandex.metrica.impl.ob;

import android.os.SystemClock;
import com.yandex.metrica.impl.q;

/* loaded from: classes.dex */
public class aw {
    private at a;
    private ar b;
    private i c;

    public aw(i iVar, bo boVar) {
        this.c = iVar;
        this.a = new at(iVar, new au(boVar));
        this.b = new ar(iVar, new as(boVar));
    }

    public void a() {
        this.a.e();
    }

    public void b() {
        this.a.j();
        this.b.j();
    }

    public boolean a(com.yandex.metrica.impl.g gVar) {
        if (!this.a.g()) {
            if (this.a.c()) {
                this.c.e(com.yandex.metrica.impl.g.a(gVar, q.a.EVENT_TYPE_ALIVE));
            }
            this.a.a();
            this.b.j();
            return true;
        }
        this.a.e();
        return false;
    }

    public boolean b(com.yandex.metrica.impl.g gVar) {
        if (this.a.g()) {
            return false;
        }
        if (!this.b.g()) {
            if (this.a.c()) {
                this.c.e(com.yandex.metrica.impl.g.a(gVar, q.a.EVENT_TYPE_ALIVE));
                this.a.a(false);
            }
            this.b.a();
            return true;
        }
        this.b.k();
        return false;
    }

    public void a(boolean z) {
        this.a.a(z);
    }

    public long c() {
        return this.a.g() ? this.a.f() : this.b.f();
    }

    public ax d() {
        av avVar = this.a.g() ? this.a : this.b;
        return new ax().a(avVar.f()).b(avVar.l()).c(avVar.h()).a(avVar.b());
    }

    public ax f() {
        return new ax().a(this.a.f()).a(this.a.b()).b(this.a.l()).c(this.a.d());
    }

    public ax e() {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.c.i().a(jCurrentTimeMillis, az.BACKGROUND);
        return new ax().a(jCurrentTimeMillis).a(az.BACKGROUND).b(0L).c(jElapsedRealtime);
    }
}
