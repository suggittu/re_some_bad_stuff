package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import com.yandex.metrica.IIdentifierCallback;
import java.util.Map;

/* loaded from: classes.dex */
public class cc {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private long f;
    private String g;
    private cd h;
    private final bn i;

    public enum a {
        IDENTIFIERS,
        URLS,
        ALL
    }

    public cc(bn bnVar, String str) {
        this.i = bnVar;
        this.b = this.i.b((String) null);
        this.c = this.i.c((String) null);
        this.d = this.i.d((String) null);
        this.e = this.i.e(null);
        this.h = this.i.b();
        this.a = this.i.a((String) null);
        this.f = this.i.a(0L);
        this.g = this.i.f(null);
        a(str, cd.EXTERNAL);
        f();
    }

    private void a(String str, cd cdVar) {
        if (com.yandex.metrica.impl.bi.a(this.a) && !com.yandex.metrica.impl.bi.a(str)) {
            this.a = str;
            this.h = cdVar;
        }
    }

    synchronized void a(Map<String, String> map) {
        b(map);
        c(map);
    }

    synchronized boolean a(a aVar) {
        boolean zH;
        if (a.ALL == aVar) {
            zH = i();
        } else if (a.IDENTIFIERS == aVar) {
            zH = g();
        } else if (a.URLS == aVar) {
            zH = h();
        } else {
            zH = false;
        }
        return zH;
    }

    synchronized void b(Map<String, String> map) {
        if (!com.yandex.metrica.impl.bi.a(this.a)) {
            map.put(IIdentifierCallback.YANDEX_MOBILE_METRICA_UUID, this.a);
        }
        if (!com.yandex.metrica.impl.bi.a(this.b)) {
            map.put(IIdentifierCallback.YANDEX_MOBILE_METRICA_DEVICE_ID, this.b);
        }
    }

    synchronized void c(Map<String, String> map) {
        if (!com.yandex.metrica.impl.bi.a(this.c)) {
            map.put(IIdentifierCallback.YANDEX_MOBILE_METRICA_GET_AD_URL, this.c);
        }
        if (!com.yandex.metrica.impl.bi.a(this.d)) {
            map.put(IIdentifierCallback.YANDEX_MOBILE_METRICA_REPORT_AD_URL, this.d);
        }
    }

    synchronized void a(Bundle bundle) {
        b(bundle);
        c(bundle);
        b(bundle.getLong("ServerTimeOffset"));
        String string = bundle.getString("Clids");
        if (!com.yandex.metrica.impl.bi.a(string)) {
            this.g = string;
        }
        f();
    }

    private void f() {
        this.i.g(this.a).a(this.h).h(this.b).j(this.c).l(this.d).c(this.f).m(this.g).k();
    }

    void a(long j) {
        this.i.d(j).k();
    }

    String b() {
        return this.e;
    }

    void a(String str) {
        this.e = str;
        this.i.k(str).k();
    }

    private synchronized boolean g() {
        boolean z;
        synchronized (this) {
            z = com.yandex.metrica.impl.bi.a(this.a, this.b) ? false : true;
        }
        return z;
    }

    private synchronized boolean h() {
        boolean z;
        synchronized (this) {
            z = com.yandex.metrica.impl.bi.a(this.c) ? false : true;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized boolean i() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.g()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            boolean r0 = r1.h()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            r0 = 1
        Le:
            monitor-exit(r1)
            return r0
        L10:
            r0 = 0
            goto Le
        L12:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.cc.i():boolean");
    }

    private synchronized void b(Bundle bundle) {
        a(bundle.getString("UuId"), cd.STORED);
        String string = bundle.getString("DeviceId");
        if (!com.yandex.metrica.impl.bi.a(string)) {
            b(string);
        }
    }

    private synchronized void c(Bundle bundle) {
        String string = bundle.getString("AdUrlGet");
        if (!com.yandex.metrica.impl.bi.a(string)) {
            c(string);
        }
        String string2 = bundle.getString("AdUrlReport");
        if (!com.yandex.metrica.impl.bi.a(string2)) {
            d(string2);
        }
    }

    synchronized void b(String str) {
        this.b = str;
    }

    private synchronized void c(String str) {
        this.c = str;
    }

    private synchronized void d(String str) {
        this.d = str;
    }

    private synchronized void b(long j) {
        this.f = j;
    }

    String c() {
        return this.a;
    }

    String d() {
        return this.b;
    }

    cd e() {
        return this.h;
    }

    boolean a() {
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - this.i.b(0L);
        return jCurrentTimeMillis > 86400 || jCurrentTimeMillis < 0;
    }
}
