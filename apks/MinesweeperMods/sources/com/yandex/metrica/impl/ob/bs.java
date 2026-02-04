package com.yandex.metrica.impl.ob;

import android.content.Context;

/* loaded from: classes.dex */
public class bs extends bm {
    private bu c;
    private bu d;

    public bs(Context context, String str) {
        super(context, str);
    }

    @Override // com.yandex.metrica.impl.ob.bm
    protected void i() {
        this.c = new bu(br.c.a());
        this.d = new bu(br.d.a(), j());
    }

    @Override // com.yandex.metrica.impl.ob.bm
    protected String g() {
        return "_bidoptpreferences";
    }

    public String a(String str) {
        return this.b.getString(this.c.b(), str);
    }

    public String b(String str) {
        return this.b.getString(this.d.b(), str);
    }
}
