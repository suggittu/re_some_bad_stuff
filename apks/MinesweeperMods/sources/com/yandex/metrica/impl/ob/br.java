package com.yandex.metrica.impl.ob;

import android.content.Context;

/* loaded from: classes.dex */
public class br extends bm {
    static final bu c = new bu("PREF_KEY_DEVICE_ID_");
    static final bu d = new bu("PREF_KEY_UID_");
    private static final bu e = new bu("PREF_KEY_HOST_URL_");
    private static final bu f = new bu("PREF_KEY_REPORT_URL_");
    private static final bu g = new bu("PREF_KEY_GET_AD_URL");
    private static final bu h = new bu("PREF_KEY_REPORT_AD_URL");
    private static final bu i = new bu("PREF_KEY_STARTUP_OBTAIN_TIME_");
    private static final bu j = new bu("PREF_KEY_STARTUP_ENCODED_CLIDS_");
    private static final bu k = new bu("PREF_KEY_DISTRIBUTION_REFERRER_");
    private static final bu l = new bu("STARTUP_CLIDS_MATCH_WITH_APP_CLIDS_");
    private static final bu m = new bu("PREF_KEY_PINNING_UPDATE_URL");
    private static final bu n = new bu("PREF_KEY_EASY_COLLECTING_ENABLED_");
    private bu o;
    private bu p;
    private bu q;
    private bu r;
    private bu s;
    private bu t;
    private bu u;
    private bu v;
    private bu w;
    private bu x;
    private bu y;

    public br(Context context) {
        this(context, null);
    }

    public br(Context context, String str) {
        super(context, str);
    }

    @Override // com.yandex.metrica.impl.ob.bm
    protected void i() {
        super.i();
        this.o = new bu(c.a());
        this.p = new bu(d.a(), j());
        this.q = new bu(e.a(), j());
        this.r = new bu(f.a(), j());
        this.s = new bu(g.a(), j());
        this.t = new bu(h.a(), j());
        this.u = new bu(i.a(), j());
        this.v = new bu(j.a(), j());
        this.w = new bu(k.a(), j());
        this.x = new bu(l.a(), j());
        this.y = new bu(n.a(), j());
    }

    @Override // com.yandex.metrica.impl.ob.bm
    protected String g() {
        return "_startupserviceinfopreferences";
    }

    public long a(long j2) {
        return this.b.getLong(this.u.b(), j2);
    }

    public String a(String str) {
        return this.b.getString(this.o.b(), str);
    }

    public String b(String str) {
        return this.b.getString(this.p.b(), str);
    }

    public String c(String str) {
        return this.b.getString(this.q.b(), str);
    }

    public String d(String str) {
        return this.b.getString(this.v.b(), str);
    }

    public String e(String str) {
        return this.b.getString(this.r.b(), str);
    }

    public String f(String str) {
        return this.b.getString(this.s.b(), str);
    }

    public String g(String str) {
        return this.b.getString(this.t.b(), str);
    }

    public String a() {
        return this.b.getString(this.w.a(), null);
    }

    public boolean b() {
        return this.b.getBoolean(this.x.a(), true);
    }

    public boolean c() {
        return this.b.getBoolean(this.y.b(), false);
    }

    public String h(String str) {
        return this.b.getString(m.b(), str);
    }

    public br j(String str) {
        return (br) a(m.b(), str);
    }

    public br k(String str) {
        return (br) a(this.p.b(), str);
    }

    public br l(String str) {
        return (br) a(this.o.b(), str);
    }

    public br m(String str) {
        return (br) a(this.r.b(), str);
    }

    public br n(String str) {
        return (br) a(this.t.b(), str);
    }

    public br o(String str) {
        return (br) a(this.s.b(), str);
    }

    public br p(String str) {
        return (br) a(this.q.b(), str);
    }

    public br b(long j2) {
        return (br) a(this.u.b(), Long.valueOf(j2));
    }

    public br q(String str) {
        return (br) a(this.v.b(), str);
    }

    public br r(String str) {
        return (br) a(this.w.a(), str);
    }

    public br a(boolean z) {
        return (br) a(this.x.a(), Boolean.valueOf(z));
    }

    public br b(boolean z) {
        return (br) a(this.y.b(), Boolean.valueOf(z));
    }

    public static void a(Context context, String str) {
        bv.a(context, "_startupserviceinfopreferences").edit().remove(f.a(str)).commit();
    }

    public static void b(Context context) {
        bv.a(context, "_startupserviceinfopreferences").edit().remove(c.a()).commit();
    }
}
