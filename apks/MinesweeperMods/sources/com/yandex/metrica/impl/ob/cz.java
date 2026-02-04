package com.yandex.metrica.impl.ob;

/* loaded from: classes.dex */
class cz implements de {
    private final dh a;
    private final dh b;
    private final dh c;

    cz() {
        cy cyVar = new cy();
        this.a = new dh(cyVar, "BLACK");
        this.b = new dh(cyVar, "WHITE");
        this.c = new dh(cyVar, "TRUST");
    }

    @Override // com.yandex.metrica.impl.ob.de
    public dh a() {
        return this.a;
    }

    @Override // com.yandex.metrica.impl.ob.de
    public dh b() {
        return this.b;
    }

    @Override // com.yandex.metrica.impl.ob.de
    public dh c() {
        return this.c;
    }
}
