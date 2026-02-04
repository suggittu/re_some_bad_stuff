package com.yandex.metrica.impl.ob;

/* loaded from: classes.dex */
public abstract class k<T> {
    private final p<T> a;

    protected abstract boolean a(com.yandex.metrica.impl.g gVar, m<T> mVar);

    protected k(p<T> pVar) {
        this.a = pVar;
    }

    public boolean a(com.yandex.metrica.impl.g gVar) {
        return a(gVar, b(gVar));
    }

    m<T> b(com.yandex.metrica.impl.g gVar) {
        return this.a.a(gVar.c());
    }
}
