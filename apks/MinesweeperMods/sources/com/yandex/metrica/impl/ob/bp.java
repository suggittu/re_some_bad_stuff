package com.yandex.metrica.impl.ob;

import android.content.Context;

/* loaded from: classes.dex */
public class bp extends bm {
    private static final bu c = new bu("SERVICE_API_LEVEL");
    private static final bu d = new bu("CLIENT_API_LEVEL");
    private bu e;
    private bu f;

    public bp(Context context) {
        super(context, null);
    }

    @Override // com.yandex.metrica.impl.ob.bm
    protected void i() {
        super.i();
        this.e = new bu(c.a());
        this.f = new bu(d.a());
    }

    public int a() {
        return this.b.getInt(this.f.b(), -1);
    }

    public bp a(int i) {
        return (bp) a(this.f.b(), Integer.valueOf(i));
    }

    public int b() {
        return this.b.getInt(this.e.b(), -1);
    }

    public bp b(int i) {
        return (bp) a(this.e.b(), Integer.valueOf(i));
    }

    @Override // com.yandex.metrica.impl.ob.bm
    protected String g() {
        return "_migrationpreferences";
    }
}
