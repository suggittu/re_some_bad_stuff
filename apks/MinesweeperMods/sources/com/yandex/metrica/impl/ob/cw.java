package com.yandex.metrica.impl.ob;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
class cw implements de {
    private final dj a;
    private de b;
    private dn c;

    cw(dk dkVar, dj djVar) {
        dy dyVarC;
        this.a = djVar;
        if (djVar.e()) {
            boolean zA = dm.a(djVar);
            boolean zF = djVar.f();
            this.b = new cz();
            if (zF) {
                if (zA) {
                    dyVarC = a(dkVar, djVar);
                } else {
                    dyVarC = dg.c(dkVar);
                }
                this.c = new dn(dkVar, this.b, dyVarC, djVar);
            }
        } else {
            boolean zA2 = dm.a(djVar);
            boolean z = ((86400000L > djVar.a() ? 1 : (86400000L == djVar.a() ? 0 : -1)) != 0) || zA2;
            boolean zF2 = djVar.f();
            if (zA2) {
                try {
                    this.b = new cs(dkVar, djVar.b());
                } catch (IOException e) {
                    this.b = new cz();
                }
            } else {
                this.b = dg.b(dkVar);
            }
            if (zF2) {
                if (z) {
                    this.c = new dn(dkVar, this.b, a(dkVar, djVar), djVar);
                } else {
                    this.c = dg.a(dkVar);
                }
            }
        }
        if (this.c != null) {
            this.c.a(djVar.d());
        }
    }

    dn d() {
        return this.c;
    }

    void e() {
        if (this.a.f()) {
            this.c.c();
        }
    }

    @Override // com.yandex.metrica.impl.ob.de
    public dh a() {
        return this.b.a();
    }

    @Override // com.yandex.metrica.impl.ob.de
    public dh b() {
        return this.b.b();
    }

    @Override // com.yandex.metrica.impl.ob.de
    public dh c() {
        return this.b.c();
    }

    private static dy a(dk dkVar, dj djVar) {
        dy dyVarD = null;
        try {
            if (dm.a(djVar)) {
                dyVarD = dkVar.a(djVar.c());
            } else {
                dyVarD = dkVar.d();
            }
        } catch (IOException e) {
        } catch (GeneralSecurityException e2) {
        }
        return dyVarD;
    }
}
