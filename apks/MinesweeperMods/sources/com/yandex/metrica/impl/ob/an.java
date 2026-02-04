package com.yandex.metrica.impl.ob;

import java.util.Iterator;

/* loaded from: classes.dex */
public class an extends k<u> {
    public an(p<u> pVar) {
        super(pVar);
    }

    @Override // com.yandex.metrica.impl.ob.k
    protected boolean a(com.yandex.metrica.impl.g gVar, m<u> mVar) {
        Iterator<? extends u> it = mVar.a().iterator();
        while (it.hasNext()) {
            if (it.next().a(gVar)) {
                return true;
            }
        }
        return false;
    }
}
