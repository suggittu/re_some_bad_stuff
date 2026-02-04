package com.yandex.metrica.impl.ob;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class d {
    protected volatile int a = -1;

    public int a() {
        if (this.a < 0) {
            b();
        }
        return this.a;
    }

    public int b() {
        int iC = c();
        this.a = iC;
        return iC;
    }

    protected int c() {
        return 0;
    }

    public void a(b bVar) throws IOException {
    }

    public static final byte[] a(d dVar) {
        byte[] bArr = new byte[dVar.b()];
        try {
            b bVarA = b.a(bArr, 0, bArr.length);
            dVar.a(bVarA);
            bVarA.b();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public String toString() {
        return e.a(this);
    }
}
