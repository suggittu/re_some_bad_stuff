package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.q;

/* loaded from: classes.dex */
public class ad extends u {
    private bl a;

    public ad(i iVar) {
        super(iVar);
        this.a = iVar.v();
    }

    @Override // com.yandex.metrica.impl.ob.u
    public boolean a(com.yandex.metrica.impl.g gVar) {
        i iVarA = a();
        if (!this.a.d()) {
            iVarA.d(com.yandex.metrica.impl.g.a(gVar, q.a.EVENT_TYPE_INIT).c(this.a.f("")));
            iVarA.b(true);
            this.a.a();
            this.a.f();
            return false;
        }
        return false;
    }
}
