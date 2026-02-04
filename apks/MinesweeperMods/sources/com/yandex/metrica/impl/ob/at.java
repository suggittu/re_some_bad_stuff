package com.yandex.metrica.impl.ob;

/* loaded from: classes.dex */
public class at extends av {
    private au f;
    private boolean g;
    private long h;

    boolean c() {
        return this.g && f() > 0;
    }

    long d() {
        return this.h;
    }

    at(i iVar, au auVar) {
        super(iVar, auVar);
        this.f = auVar;
        this.g = this.f.b(true);
        this.h = this.f.j(h());
    }

    void e() {
        this.f.k(h()).a();
        k();
    }

    @Override // com.yandex.metrica.impl.ob.av
    void a() {
        super.a();
        this.h = h();
        this.f.k(this.h).a();
        a(true);
    }

    @Override // com.yandex.metrica.impl.ob.av
    protected az b() {
        return az.FOREGROUND;
    }

    void a(boolean z) {
        if (this.g != z) {
            this.g = z;
            this.f.a(this.g).a();
        }
    }
}
