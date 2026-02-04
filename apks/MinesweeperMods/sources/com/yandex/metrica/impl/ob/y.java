package com.yandex.metrica.impl.ob;

import com.yandex.metrica.CounterConfiguration;

/* loaded from: classes.dex */
public class y extends u {
    private bl a;

    public y(i iVar) {
        super(iVar);
        this.a = a().v();
    }

    @Override // com.yandex.metrica.impl.ob.u
    public boolean a(com.yandex.metrica.impl.g gVar) {
        if (c()) {
            CounterConfiguration counterConfigurationJ = a().j();
            bk bkVarB = b();
            if (counterConfigurationJ.B()) {
                bkVarB.c();
                return false;
            }
            bkVarB.b();
            return false;
        }
        return false;
    }

    bk b() {
        return new bk(a().v());
    }

    boolean c() {
        return this.a.b(null) == null;
    }
}
