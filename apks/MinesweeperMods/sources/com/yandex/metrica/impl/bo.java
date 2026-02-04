package com.yandex.metrica.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.impl.GoogleAdvertisingIdGetter;
import com.yandex.metrica.impl.ax;
import com.yandex.metrica.impl.bk;
import com.yandex.metrica.impl.i;
import com.yandex.metrica.impl.ob.ca;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class bo implements i.a {
    private static bo a;
    private static n b = new n();
    private final Context c;
    private final ax d;
    private aa e;
    private final Thread.UncaughtExceptionHandler f;
    private final ca h;
    private final an i;
    private final ExecutorService g = Executors.newSingleThreadExecutor();
    private final Thread.UncaughtExceptionHandler j = new Thread.UncaughtExceptionHandler() { // from class: com.yandex.metrica.impl.bo.1
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable exception) {
            try {
                if (bo.this.e != null) {
                    bo.this.e.a(exception);
                }
            } finally {
                if (bo.this.f != null) {
                    bo.this.f.uncaughtException(thread, exception);
                }
            }
        }
    };

    private bo(Context context, String str) {
        Log.i(com.yandex.metrica.impl.utils.f.e().c(), "Initializing of Metrica, Release type, Version 2.42, API Level 45, Dated 17.06.2016.");
        com.yandex.metrica.impl.utils.f.a(context);
        this.c = context.getApplicationContext();
        GoogleAdvertisingIdGetter.b.a.a(this.c);
        this.f = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this.j);
        ArrayList arrayList = new ArrayList();
        Handler handler = new Handler(Looper.getMainLooper());
        ay ayVar = new ay(this.g, this.c, handler);
        ayVar.a(arrayList);
        new f().a(this.c);
        this.h = new ca(ayVar, this.c, str);
        ayVar.a(this.h);
        this.i = new an(ayVar);
        i iVar = new i(handler);
        iVar.a(this);
        ayVar.a(iVar);
        this.d = new ax.a().a(this.c).a(this.h).a(ayVar).a(handler).a(iVar).a(arrayList).a();
    }

    public static synchronized void a(Context context, com.yandex.metrica.e eVar) {
        boolean zI = b.i();
        com.yandex.metrica.e eVarA = b.a(eVar);
        b(context, eVarA);
        if (a.e == null) {
            if (Boolean.TRUE.equals(eVarA.isLogEnabled())) {
                com.yandex.metrica.impl.utils.f.e().a();
            }
            bo boVar = a;
            boVar.e = boVar.d.a(eVarA);
            a(boVar.e.d().b().k());
        }
        a.a(eVarA, zI);
    }

    public static synchronized void a(Context context) {
        b(context, (com.yandex.metrica.e) null);
    }

    public static synchronized void b(Context context, com.yandex.metrica.e eVar) {
        bk.a((Object) context, "App Context");
        if (a == null) {
            bo boVar = new bo(context.getApplicationContext(), eVar != null ? eVar.a() : null);
            a = boVar;
            w.a(boVar.c);
            if (eVar != null) {
                boVar.h.a(eVar.b());
                boVar.h.a(eVar.e());
                boVar.h.b(eVar.f());
            }
            boVar.h.d();
            boVar.g.execute(new bk.b(boVar.c));
        }
    }

    public static synchronized bo a() {
        if (a == null) {
            throw bl.a;
        }
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static synchronized boolean b() {
        /*
            java.lang.Class<com.yandex.metrica.impl.bo> r1 = com.yandex.metrica.impl.bo.class
            monitor-enter(r1)
            com.yandex.metrica.impl.bo r0 = com.yandex.metrica.impl.bo.a     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            com.yandex.metrica.impl.bo r0 = com.yandex.metrica.impl.bo.a     // Catch: java.lang.Throwable -> L12
            com.yandex.metrica.impl.aa r0 = r0.e     // Catch: java.lang.Throwable -> L12
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
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.bo.b():boolean");
    }

    void a(com.yandex.metrica.e eVar, boolean z) {
        this.e.a(eVar);
        if (z) {
            this.e.b();
        }
        this.e.b(eVar.i());
        this.e.a(eVar.getErrorEnvironment());
    }

    public com.yandex.metrica.b a(String str) {
        return this.d.a(str);
    }

    public void a(Application application) {
        this.e.a(application);
    }

    public void a(Activity activity) {
        this.e.a(activity);
    }

    public void b(Activity activity) {
        this.e.b(activity);
    }

    public void b(String str) {
        this.e.reportEvent(str);
    }

    public void a(String str, String str2) {
        this.e.reportEvent(str, str2);
    }

    public void a(String str, Map<String, Object> map) {
        if (map != null) {
            map = new HashMap(map);
        }
        this.e.reportEvent(str, map);
    }

    public void a(String str, Throwable th) {
        this.e.reportError(str, th);
    }

    public void a(Throwable th) {
        this.e.reportUnhandledException(th);
    }

    public void c(String str) {
        this.e.d(str);
    }

    public void d(String str) {
        this.i.a(str);
    }

    private static ac e() {
        return b() ? a().e : b;
    }

    public static void a(int i) {
        e().setSessionTimeout(i);
    }

    public static void a(boolean z) {
        if (b()) {
            bo boVarA = a();
            Thread.setDefaultUncaughtExceptionHandler(z ? boVarA.j : boVarA.f);
            boVarA.e.c(z);
            return;
        }
        b.c(z);
    }

    public static void b(boolean z) {
        e().d(z);
    }

    public static void a(Location location) {
        e().a(location);
    }

    public static void c(boolean z) {
        e().b(z);
    }

    public static void e(String str) {
        e().a(str);
    }

    public static void d(boolean z) {
        e().a(z);
    }

    public static boolean c() {
        return e().h();
    }

    public static void b(String str, String str2) {
        e().a(str, str2);
    }

    public String d() {
        return this.h.a();
    }

    public void a(IIdentifierCallback iIdentifierCallback) {
        this.h.a(iIdentifierCallback);
    }

    @Override // com.yandex.metrica.impl.i.a
    public void a(int i, Bundle bundle) {
        switch (i) {
            case 1:
                this.h.a(bundle);
                break;
            case 2:
                this.h.b(bundle);
                break;
        }
    }
}
