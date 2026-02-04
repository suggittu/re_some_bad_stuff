package com.yandex.metrica.impl.ob;

import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public abstract class dv<T> extends ea<T> {
    private final String a;

    @Override // com.yandex.metrica.impl.ob.ea
    protected abstract T b(dz dzVar) throws dx;

    static {
        String.format("application/json; charset=%s", "utf-8");
    }

    public dv(int i, String str, String str2) {
        super(i, str);
        this.a = str2;
    }

    @Override // com.yandex.metrica.impl.ob.ea
    public byte[] c() {
        try {
            if (this.a == null) {
                return null;
            }
            return this.a.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
