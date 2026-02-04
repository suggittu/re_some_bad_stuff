package com.yandex.metrica.impl.ob;

/* loaded from: classes.dex */
public class x extends u {
    public x(i iVar) {
        super(iVar);
    }

    @Override // com.yandex.metrica.impl.ob.u
    public boolean a(com.yandex.metrica.impl.g gVar) {
        if (c()) {
            b().a();
            return false;
        }
        return false;
    }

    bk b() {
        return new bk(a().v());
    }

    boolean c() {
        return a().j().B();
    }
}
