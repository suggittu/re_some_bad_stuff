package com.yandex.metrica.impl.ob;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public abstract class av {
    protected i a;
    protected ay b;
    protected long c;
    protected long d;
    protected AtomicLong e;

    protected abstract az b();

    long f() {
        return this.c;
    }

    av(i iVar, ay ayVar) {
        this.a = iVar;
        this.b = ayVar;
        this.d = this.b.c(SystemClock.elapsedRealtime());
        this.c = this.b.a(-1L);
        this.e = new AtomicLong(this.b.e(0L));
        this.b.d(this.d).a();
    }

    boolean g() {
        return this.c >= 0 && !i();
    }

    long h() {
        return TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime() - this.d);
    }

    boolean i() {
        long jElapsedRealtime = (SystemClock.elapsedRealtime() / 1000) - this.b.g(0L);
        return jElapsedRealtime < 0 || jElapsedRealtime >= ((long) this.a.j().d());
    }

    void j() {
        this.b.h(-2147483648L).a();
    }

    void k() {
        this.b.h(SystemClock.elapsedRealtime() / 1000).a();
    }

    long l() {
        long andIncrement = this.e.getAndIncrement();
        this.b.f(this.e.get()).a();
        return andIncrement;
    }

    void a() {
        this.c = System.currentTimeMillis() / 1000;
        this.e.set(0L);
        this.d = SystemClock.elapsedRealtime();
        this.b.i(this.c).h(SystemClock.elapsedRealtime() / 1000).d(this.d).f(this.e.get()).a();
        this.a.i().a(this.c, b());
    }
}
