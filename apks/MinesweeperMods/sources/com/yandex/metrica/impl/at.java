package com.yandex.metrica.impl;

/* loaded from: classes.dex */
public class at extends as {
    private a d;
    private a e;

    public interface a {
        g a(g gVar, aw awVar);
    }

    @Override // com.yandex.metrica.impl.as
    public /* bridge */ /* synthetic */ as a(aw awVar) {
        return super.a(awVar);
    }

    @Override // com.yandex.metrica.impl.as
    public /* bridge */ /* synthetic */ as a(g gVar) {
        return super.a(gVar);
    }

    public at(t tVar) {
        super(tVar);
    }

    public at a(a aVar) {
        this.d = aVar;
        return this;
    }

    public at b(a aVar) {
        this.e = aVar;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVarA = this.a;
        if (this.d != null) {
            gVarA = this.d.a(gVarA, this.b);
        }
        if (this.e != null) {
            this.e.a(gVarA, this.b);
        }
    }
}
