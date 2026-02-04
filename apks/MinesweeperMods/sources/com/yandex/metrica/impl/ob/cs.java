package com.yandex.metrica.impl.ob;

import java.io.IOException;

/* loaded from: classes.dex */
class cs implements de {
    private final dh a;
    private final dh b;

    public cs(dk dkVar, String str) throws IOException {
        ct ctVar = new ct(dkVar.b(), Integer.toString(str.hashCode()));
        this.a = new dh(ctVar, "LIB-BLACK");
        this.b = new dh(ctVar, "LIB-TRUST");
    }

    @Override // com.yandex.metrica.impl.ob.de
    public dh a() {
        return this.a;
    }

    @Override // com.yandex.metrica.impl.ob.de
    public dh b() {
        throw new UnsupportedOperationException("white list isn't supported in custom container");
    }

    @Override // com.yandex.metrica.impl.ob.de
    public dh c() {
        return this.b;
    }
}
