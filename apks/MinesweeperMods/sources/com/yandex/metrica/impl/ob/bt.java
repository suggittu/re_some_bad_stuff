package com.yandex.metrica.impl.ob;

import android.content.Context;

/* loaded from: classes.dex */
public class bt extends bm {
    private bu c;

    public bt(Context context) {
        this(context, null);
    }

    public bt(Context context, String str) {
        super(context, str);
    }

    @Override // com.yandex.metrica.impl.ob.bm
    protected void i() {
        super.i();
        this.c = new bu("LOCATION_TRACKING_ENABLED");
    }

    @Override // com.yandex.metrica.impl.ob.bm
    protected String g() {
        return "_serviceproviderspreferences";
    }

    public void a(boolean z) {
        a(this.c.b(), Boolean.valueOf(z)).k();
    }

    public boolean a() {
        return this.b.getBoolean(this.c.b(), false);
    }
}
