package com.yandex.metrica.impl.ob;

/* loaded from: classes.dex */
public class w extends u {
    private bl a;

    public w(i iVar) {
        super(iVar);
        this.a = iVar.v();
    }

    @Override // com.yandex.metrica.impl.ob.u
    public boolean a(com.yandex.metrica.impl.g gVar) {
        i iVarA = a();
        if (this.a.e() && iVarA.u()) {
            iVarA.f(com.yandex.metrica.impl.g.a(iVarA, gVar));
            return false;
        }
        return false;
    }
}
