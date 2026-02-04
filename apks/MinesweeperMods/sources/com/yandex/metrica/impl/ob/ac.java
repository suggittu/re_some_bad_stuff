package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.q;

/* loaded from: classes.dex */
public class ac extends u {
    public ac(i iVar) {
        super(iVar);
    }

    @Override // com.yandex.metrica.impl.ob.u
    public boolean a(com.yandex.metrica.impl.g gVar) {
        String strB = b();
        if (!com.yandex.metrica.impl.bi.a(strB)) {
            c();
            a().a(new com.yandex.metrica.impl.g(gVar).c("").b(strB).a(q.a.EVENT_TYPE_REFERRER_DEPRECATED.a()));
            return false;
        }
        return false;
    }

    String b() {
        return a().r();
    }

    void c() {
        a().s();
    }
}
