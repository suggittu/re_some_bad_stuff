package com.yandex.metrica.impl.utils;

import android.content.Context;
import com.yandex.metrica.impl.ob.bq;

/* loaded from: classes.dex */
public class g {
    private volatile long a;
    private bq b;

    /* JADX INFO: Access modifiers changed from: private */
    static class a {
        static g a = new g(0);
    }

    /* synthetic */ g(byte b) {
        this();
    }

    public static g a() {
        return a.a;
    }

    private g() {
    }

    public synchronized long b() {
        return this.a;
    }

    public synchronized void a(Context context) {
        if (context != null) {
            this.b = new bq(context, context.getPackageName());
            this.a = this.b.a(0);
        }
    }

    public synchronized void a(long j) {
        this.a = (j - System.currentTimeMillis()) / 1000;
        if (this.b != null) {
            this.b.a(this.a);
            this.b.k();
        }
    }
}
