package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.q;

/* loaded from: classes.dex */
public class v extends u {
    private bl a;

    public v(i iVar) {
        super(iVar);
        this.a = a().v();
    }

    @Override // com.yandex.metrica.impl.ob.u
    public boolean a(com.yandex.metrica.impl.g gVar) {
        i iVarA = a();
        if (!this.a.e()) {
            if (!this.a.d()) {
                String strB = gVar.b();
                this.a.e(strB);
                iVarA.d(com.yandex.metrica.impl.g.a(gVar, q.a.EVENT_TYPE_FIRST_ACTIVATION).c(strB));
                iVarA.b(true);
            }
            this.a.b();
            return false;
        }
        return false;
    }
}
