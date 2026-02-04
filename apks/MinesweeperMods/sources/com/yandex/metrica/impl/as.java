package com.yandex.metrica.impl;

/* loaded from: classes.dex */
abstract class as implements Runnable {
    protected g a;
    protected aw b;
    protected final t c;

    public as(t tVar) {
        this.c = tVar;
    }

    public as a(g gVar) {
        this.a = gVar;
        return this;
    }

    public as a(aw awVar) {
        this.b = awVar;
        return this;
    }
}
