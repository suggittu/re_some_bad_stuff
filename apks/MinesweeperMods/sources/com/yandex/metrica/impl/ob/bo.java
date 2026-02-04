package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.b;

/* loaded from: classes.dex */
public class bo extends bm {
    private bu A;
    private bu B;
    private bu C;
    private bu D;
    private bu E;
    private bu F;
    private bu G;
    private bu H;
    private bu I;
    private bu J;
    private bu u;
    private bu v;
    private bu w;
    private bu x;
    private bu y;
    private bu z;
    private static final bu e = new bu("SESSION_SLEEP_START_");
    private static final bu f = new bu("SESSION_ID_");
    private static final bu g = new bu("SESSION_COUNTER_ID_");
    private static final bu h = new bu("SESSION_INIT_TIME_");
    private static final bu i = new bu("SESSION_ALIVE_TIME_");
    private static final bu j = new bu("SESSION_IS_ALIVE_REPORT_NEEDED_");
    private static final bu k = new bu("BG_SESSION_ID_");
    private static final bu l = new bu("BG_SESSION_SLEEP_START_");
    private static final bu m = new bu("BG_SESSION_COUNTER_ID_");
    private static final bu n = new bu("BG_SESSION_INIT_TIME_");
    private static final bu o = new bu("COLLECT_INSTALLED_APPS_");
    private static final bu p = new bu("IDENTITY_SEND_TIME_");
    private static final bu q = new bu("USER_INFO_");
    private static final bu r = new bu("REFERRER_");
    public static final bu c = new bu("APP_ENVIRONMENT");
    public static final bu d = new bu("APP_ENVIRONMENT_REVISION");
    private static final bu s = new bu("APP_ENVIRONMENT_");
    private static final bu t = new bu("APP_ENVIRONMENT_REVISION_");

    public bo(Context context, String str) {
        super(context, str);
        d();
        a(-1);
        b(0);
        c(0);
    }

    @Override // com.yandex.metrica.impl.ob.bm
    protected void i() {
        super.i();
        this.u = new bu(e.a(), j());
        this.v = new bu(f.a(), j());
        this.w = new bu(g.a(), j());
        this.x = new bu(h.a(), j());
        this.y = new bu(i.a(), j());
        this.z = new bu(j.a(), j());
        this.A = new bu(k.a(), j());
        this.B = new bu(l.a(), j());
        this.C = new bu(m.a(), j());
        this.D = new bu(n.a(), j());
        this.E = new bu(p.a(), j());
        this.F = new bu(o.a(), j());
        this.G = new bu(q.a(), j());
        this.H = new bu(r.a(), j());
        this.I = new bu(s.a(), j());
        this.J = new bu(t.a(), j());
    }

    @Override // com.yandex.metrica.impl.ob.bm
    protected String g() {
        return "_boundentrypreferences";
    }

    public long a(long j2) {
        return this.b.getLong(this.x.b(), j2);
    }

    public long b(long j2) {
        return this.b.getLong(this.D.b(), j2);
    }

    public long c(long j2) {
        return this.b.getLong(this.y.b(), j2);
    }

    public long d(long j2) {
        return this.b.getLong(this.E.b(), j2);
    }

    public long e(long j2) {
        return this.b.getLong(this.v.b(), j2);
    }

    public long f(long j2) {
        return this.b.getLong(this.A.b(), j2);
    }

    public long g(long j2) {
        return this.b.getLong(this.w.b(), j2);
    }

    public long h(long j2) {
        return this.b.getLong(this.C.b(), j2);
    }

    public b.a a() {
        b.a aVar;
        synchronized (this) {
            aVar = new b.a(this.b.getString(this.I.b(), "{}"), this.b.getLong(this.J.b(), 0L));
        }
        return aVar;
    }

    public long i(long j2) {
        return this.b.getLong(this.u.b(), j2);
    }

    public long j(long j2) {
        return this.b.getLong(this.B.b(), j2);
    }

    public boolean a(boolean z) {
        return this.b.getBoolean(this.z.b(), z);
    }

    public CounterConfiguration.a b() {
        return CounterConfiguration.a.a(this.b.getInt(this.F.b(), CounterConfiguration.a.UNDEFINED.d));
    }

    public String a(String str) {
        return this.b.getString(this.G.b(), str);
    }

    public String b(String str) {
        return this.b.getString(this.H.b(), str);
    }

    public bo k(long j2) {
        return (bo) a(this.x.b(), Long.valueOf(j2));
    }

    public bo l(long j2) {
        return (bo) a(this.D.b(), Long.valueOf(j2));
    }

    public bo a(b.a aVar) {
        synchronized (this) {
            a(this.I.b(), aVar.a);
            a(this.J.b(), Long.valueOf(aVar.b));
        }
        return this;
    }

    public bo m(long j2) {
        return (bo) a(this.y.b(), Long.valueOf(j2));
    }

    public bo n(long j2) {
        return (bo) a(this.E.b(), Long.valueOf(j2));
    }

    public bo o(long j2) {
        return (bo) a(this.v.b(), Long.valueOf(j2));
    }

    public bo p(long j2) {
        return (bo) a(this.A.b(), Long.valueOf(j2));
    }

    public bo q(long j2) {
        return (bo) a(this.w.b(), Long.valueOf(j2));
    }

    public bo r(long j2) {
        return (bo) a(this.C.b(), Long.valueOf(j2));
    }

    public bo s(long j2) {
        return (bo) a(this.u.b(), Long.valueOf(j2));
    }

    public bo t(long j2) {
        return (bo) a(this.B.b(), Long.valueOf(j2));
    }

    public bo a(CounterConfiguration.a aVar) {
        return (bo) a(this.F.b(), Integer.valueOf(aVar.d));
    }

    public bo c(String str) {
        return (bo) a(this.G.b(), str);
    }

    public bo d(String str) {
        return (bo) a(this.H.b(), str);
    }

    public bo c() {
        return (bo) i(this.H.b());
    }

    public bo b(boolean z) {
        return (bo) a(this.z.b(), Boolean.valueOf(z));
    }

    public void a(int i2) {
        bv.a(this.b, this.y.b(), i2);
    }

    public void b(int i2) {
        bv.a(this.b, this.u.b(), i2);
    }

    public void c(int i2) {
        bv.a(this.b, this.w.b(), i2);
    }

    public void d() {
        SharedPreferences sharedPreferences = this.b;
        String strB = this.F.b();
        if (sharedPreferences != null && sharedPreferences.contains(strB)) {
            try {
                sharedPreferences.getBoolean(strB, false);
                sharedPreferences.edit().remove(strB).putInt(strB, CounterConfiguration.a.UNDEFINED.d).commit();
            } catch (ClassCastException e2) {
            }
        }
    }
}
