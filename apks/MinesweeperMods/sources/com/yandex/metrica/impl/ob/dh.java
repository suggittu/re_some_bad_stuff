package com.yandex.metrica.impl.ob;

import android.util.Base64;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
class dh {
    private db a;
    private String b;

    dh(db dbVar, String str) {
        this(dbVar, str, null);
    }

    dh(db dbVar, String str, String[] strArr) {
        this.a = dbVar;
        this.b = str;
        if (strArr != null) {
            this.a.a(this.b, strArr);
        }
    }

    public void a() {
        this.a.a(this.b, new HashSet());
    }

    Set<String> b() {
        Set<String> setA = this.a.a(this.b);
        if (setA == null) {
            return new HashSet();
        }
        return setA;
    }

    long c() {
        return this.a.a();
    }

    void d() {
        this.a.b();
    }

    public boolean a(String str) {
        if (Base64.decode(str, 2).length == 32) {
            return this.a.a(this.b, str);
        }
        throw new IllegalArgumentException("pin has bad length");
    }
}
