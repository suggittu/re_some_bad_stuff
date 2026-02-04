package com.yandex.metrica.impl.utils;

import android.util.Log;

/* loaded from: classes.dex */
public abstract class a {
    private volatile boolean a;

    abstract String c();

    abstract String d();

    abstract String d(String str, Object[] objArr);

    public void a() {
        this.a = true;
    }

    public boolean b() {
        return this.a;
    }

    public a(boolean z) {
        this.a = false;
        this.a = z;
    }

    public void a(String str, Object... objArr) {
        a(4, str, objArr);
    }

    public void b(String str, Object... objArr) {
        a(5, str, objArr);
    }

    public void c(String str, Object... objArr) {
        a(6, str, objArr);
    }

    void a(int i, String str, Object... objArr) {
        if (this.a) {
            Log.println(i, c(), d() + d(str, objArr));
        }
    }
}
