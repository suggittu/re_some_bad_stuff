package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.q;

/* loaded from: classes.dex */
public class am extends u {
    public am(i iVar) {
        super(iVar);
    }

    @Override // com.yandex.metrica.impl.ob.u
    public boolean a(com.yandex.metrica.impl.g gVar) {
        i iVarA = a();
        if (iVarA.a().a(gVar)) {
            iVarA.b(true);
            iVarA.d(com.yandex.metrica.impl.g.a(gVar, q.a.EVENT_TYPE_ACTIVITY_START));
            return false;
        }
        return false;
    }
}
