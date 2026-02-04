package com.yandex.metrica.impl;

import android.os.SystemClock;

/* loaded from: classes.dex */
class r {
    private long a = SystemClock.elapsedRealtime() - 2000000;
    private boolean b = true;

    r() {
    }

    boolean a() {
        boolean z = this.b;
        this.b = false;
        return z && SystemClock.elapsedRealtime() - this.a > 1000;
    }

    void b() {
        this.b = true;
        this.a = SystemClock.elapsedRealtime();
    }

    boolean c() {
        return this.b;
    }
}
