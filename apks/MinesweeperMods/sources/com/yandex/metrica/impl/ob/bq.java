package com.yandex.metrica.impl.ob;

import android.content.Context;

/* loaded from: classes.dex */
public class bq extends bm {
    private static final bu c = new bu("PREF_KEY_OFFSET");
    private bu d;

    public bq(Context context, String str) {
        super(context, str);
    }

    @Override // com.yandex.metrica.impl.ob.bm
    protected void i() {
        super.i();
        this.d = new bu(c.a(), null);
    }

    @Override // com.yandex.metrica.impl.ob.bm
    protected String g() {
        return "_servertimeoffset";
    }

    public long a(int i) {
        return this.b.getLong(this.d.b(), i);
    }

    public bq a(long j) {
        return (bq) a(this.d.b(), Long.valueOf(j));
    }
}
