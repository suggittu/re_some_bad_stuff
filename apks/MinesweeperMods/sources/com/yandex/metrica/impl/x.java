package com.yandex.metrica.impl;

import android.os.Handler;
import android.os.SystemClock;

/* loaded from: classes.dex */
class x {
    private final Handler a;
    private final c b;
    private final y c;

    x(Handler handler, c cVar) {
        this.a = handler;
        this.b = cVar;
        this.c = new y(handler, cVar);
    }

    void a() {
        b(this.a, this.b, this.c);
    }

    void b() {
        a(this.a, this.b, this.c);
    }

    static void a(Handler handler, c cVar, Runnable runnable) {
        b(handler, cVar, runnable);
        handler.postAtTime(runnable, a(cVar), SystemClock.uptimeMillis() + (cVar.d().b().d() * 500));
    }

    private static void b(Handler handler, c cVar, Runnable runnable) {
        handler.removeCallbacks(runnable, a(cVar));
    }

    private static String a(c cVar) {
        return cVar.d().b().j();
    }
}
