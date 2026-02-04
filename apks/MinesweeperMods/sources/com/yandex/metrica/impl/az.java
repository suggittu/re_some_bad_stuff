package com.yandex.metrica.impl;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.GoogleAdvertisingIdGetter;
import com.yandex.metrica.impl.ba;
import com.yandex.metrica.impl.bg;
import com.yandex.metrica.impl.interact.DeviceInfo;
import com.yandex.metrica.impl.o;
import com.yandex.metrica.impl.ob.br;
import com.yandex.metrica.impl.ob.bs;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class az {
    private boolean B;
    private String C;
    private String D;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private int n;
    private int o;
    private int p;
    private float q;
    private String s;
    private String t;
    private String u;
    private String v;
    private String x;
    private String y;
    private String z;
    private String a = Build.MANUFACTURER;
    private String b = Build.MODEL;
    private String c = Build.VERSION.RELEASE;
    private String d = "242";
    private String e = bc.a();
    private String f = "android";
    private String g = "2";
    private String r = com.yandex.metrica.a.PHONE.name().toLowerCase(Locale.US);
    private String w = "https://startup.mobile.yandex.net/";
    private String A = "0";

    public String a() {
        return this.l;
    }

    public synchronized String b() {
        return a(this.h, "");
    }

    public synchronized void a(String str) {
        if (!bi.a(str)) {
            this.h = str;
        }
    }

    public synchronized void b(String str) {
        if (bi.a(this.i) && !bi.a(str)) {
            this.i = str;
        }
    }

    public synchronized String c() {
        return a(this.i, "");
    }

    public String d() {
        return a(this.m, "");
    }

    public void c(String str) {
        this.m = str;
    }

    public synchronized void d(String str) {
        this.j = str;
    }

    public synchronized String e() {
        return this.j;
    }

    public String f() {
        return this.g;
    }

    public String g() {
        return this.e;
    }

    public void e(String str) {
        this.d = str;
    }

    public String h() {
        return this.d;
    }

    public void f(String str) {
        this.t = str;
    }

    public String i() {
        return this.t;
    }

    public int j() {
        return com.yandex.metrica.impl.utils.e.a(this.t, 0);
    }

    public String k() {
        return this.f;
    }

    public String l() {
        return a(this.k, "");
    }

    public String m() {
        return a(this.a, "");
    }

    public String n() {
        return a(this.b, "");
    }

    public String o() {
        return a(this.c, "");
    }

    public void g(String str) {
        this.c = str;
    }

    public int p() {
        return this.n;
    }

    public int q() {
        return this.o;
    }

    public int r() {
        return this.p;
    }

    public float s() {
        return this.q;
    }

    public String t() {
        return a(this.s, "");
    }

    public void h(String str) {
        this.s = str;
    }

    public String u() {
        return a(this.u, "");
    }

    public void j(String str) {
        this.C = str;
    }

    public String v() {
        return a(this.C, "");
    }

    public String w() {
        return a(this.v, "");
    }

    public void l(String str) {
        this.x = str;
    }

    public void m(String str) {
        this.y = str;
    }

    public String x() {
        return a(this.y, "");
    }

    public String y() {
        return a(this.z, "");
    }

    public void n(String str) {
        this.z = str;
    }

    public String z() {
        return a(this.x, "");
    }

    public String A() {
        return a(this.w, "https://startup.mobile.yandex.net/");
    }

    public void o(String str) {
        this.A = str;
    }

    public String B() {
        return a(this.A, "0");
    }

    public String C() {
        return a(this.r, com.yandex.metrica.a.PHONE.name().toLowerCase(Locale.US));
    }

    public boolean D() {
        return this.B;
    }

    public void a(boolean z) {
        this.B = z;
    }

    public String E() {
        return a(this.D, "https://certificate.mobile.yandex.net/api/v1/pins");
    }

    public void p(String str) {
        this.D = str;
    }

    public synchronized boolean F() {
        boolean z;
        synchronized (this) {
            z = bi.a(b(), c(), z()) ? false : true;
        }
        return z;
    }

    public synchronized boolean a(long j) {
        boolean z = false;
        synchronized (this) {
            if (F()) {
                long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - j;
                if (jCurrentTimeMillis <= 86400 && jCurrentTimeMillis >= 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    public void a(com.yandex.metrica.impl.ob.i iVar) {
        Context contextM = iVar.m();
        String strA = iVar.l().a();
        CounterConfiguration counterConfigurationJ = iVar.j();
        DeviceInfo deviceInfo = DeviceInfo.getInstance(contextM);
        br brVarW = iVar.w();
        bs bsVarF = f(iVar);
        this.l = bk.a(contextM, counterConfigurationJ, strA);
        this.r = a(contextM, counterConfigurationJ);
        List<ResolveInfo> listA = be.a(contextM, be.a(contextM).setPackage(strA));
        ba.a aVarA = ba.a;
        if (!listA.isEmpty()) {
            aVarA = ba.a(be.a(listA.get(0).serviceInfo));
        }
        this.t = aVarA.a;
        a(deviceInfo);
        a(brVarW, iVar);
        a(iVar, brVarW, bsVarF);
        b(brVarW);
        String strP = counterConfigurationJ.p();
        if (bi.a(strP)) {
            strP = u();
            if (bi.a(strP)) {
                strP = bk.b(contextM, strA);
            }
        }
        i(strP);
        String strQ = counterConfigurationJ.q();
        if (bi.a(strQ)) {
            strQ = w();
            if (bi.a(strQ)) {
                strQ = bk.a(contextM, strA);
            }
        }
        k(strQ);
        a(brVarW);
        d(iVar);
    }

    private void a(br brVar) {
        a(brVar.c());
    }

    private void b(br brVar) {
        this.C = brVar.d(null);
    }

    public void b(com.yandex.metrica.impl.ob.i iVar) {
        a(DeviceInfo.getInstance(iVar.m()));
        b(iVar.w());
    }

    String a(Context context, CounterConfiguration counterConfiguration) {
        com.yandex.metrica.a aVarE = counterConfiguration.e();
        return aVarE == null ? b(context) : aVarE.a();
    }

    String b(Context context) {
        return DeviceInfo.getInstance(context).deviceType;
    }

    void c(com.yandex.metrica.impl.ob.i iVar) {
        br brVarW = iVar.w();
        a(iVar, brVarW, f(iVar));
        a(brVarW, iVar);
        a(brVarW);
    }

    private synchronized void a(com.yandex.metrica.impl.ob.i iVar, br brVar, bs bsVar) {
        String strC = c();
        if (bi.a(strC)) {
            strC = iVar.j().h();
            if (bi.a(strC)) {
                strC = brVar.a("");
                if (bi.a(strC)) {
                    strC = bsVar.a("");
                    if (bi.a(strC)) {
                        strC = o.b.a.c(iVar.m());
                    }
                }
            }
        }
        b(strC);
        String strG = iVar.j().g();
        if (bi.a(strG)) {
            strG = b();
            if (bi.a(strG)) {
                strG = brVar.b("");
                if (bi.a(strG)) {
                    strG = bsVar.b("");
                }
            }
        }
        a(strG);
    }

    private void a(DeviceInfo deviceInfo) {
        this.k = deviceInfo.platformDeviceId;
        this.p = deviceInfo.screenDpi;
        this.q = deviceInfo.scaleFactor;
        int i = deviceInfo.screenWidth;
        int i2 = deviceInfo.screenHeight;
        this.n = Math.max(i, i2);
        this.o = Math.min(i, i2);
        this.s = deviceInfo.getLocale();
        this.A = deviceInfo.deviceRootStatus;
    }

    private void a(br brVar, com.yandex.metrica.impl.ob.i iVar) {
        this.y = brVar.f("");
        this.z = brVar.g("");
        this.w = brVar.c("https://startup.mobile.yandex.net/");
        this.x = brVar.e("");
        e(iVar);
    }

    public synchronized void a(bg.a aVar) {
        a(aVar.g());
        b(aVar.f());
        m(aVar.b());
        l(aVar.c());
        n(aVar.d());
        p(aVar.e());
        j(aVar.h());
        a(aVar.a());
    }

    public synchronized void d(com.yandex.metrica.impl.ob.i iVar) {
        CounterConfiguration counterConfigurationJ = iVar.j();
        a(counterConfigurationJ.g());
        d(counterConfigurationJ.i());
        i(counterConfigurationJ.p());
        k(counterConfigurationJ.q());
        c(counterConfigurationJ.D());
        e(iVar);
    }

    private void e(com.yandex.metrica.impl.ob.i iVar) {
        String strO = iVar.j().o();
        if (!bi.a(strO)) {
            if (!strO.equals(this.w)) {
                this.x = null;
                br.a(iVar.m(), iVar.l().a());
            }
            this.w = strO;
        }
    }

    private static bs f(com.yandex.metrica.impl.ob.i iVar) {
        return new bs(iVar.m(), iVar.l().a());
    }

    public String a(Context context) {
        return a(GoogleAdvertisingIdGetter.b.a.b(context), "");
    }

    public void i(String str) {
        if (!bi.a(str)) {
            this.u = str;
        }
    }

    public void k(String str) {
        if (!bi.a(str)) {
            this.v = str;
        }
    }

    private static String a(String str, String str2) {
        return !bi.a(str) ? str : str2;
    }
}
