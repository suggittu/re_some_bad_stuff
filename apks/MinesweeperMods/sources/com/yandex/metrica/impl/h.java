package com.yandex.metrica.impl;

/* loaded from: classes.dex */
abstract class h {
    protected final aw a;

    abstract boolean a(Throwable th);

    h(aw awVar) {
        this.a = awVar;
    }

    void a(Throwable th, ay ayVar) {
        if (a(th)) {
            ayVar.a(th, this.a);
        }
    }
}
