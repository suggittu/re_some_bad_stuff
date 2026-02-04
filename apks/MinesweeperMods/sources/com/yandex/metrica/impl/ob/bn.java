package com.yandex.metrica.impl.ob;

import android.content.Context;

/* loaded from: classes.dex */
public class bn extends bm {
    private static final bu c = new bu("UUID");
    private static final bu d = new bu("DEVICEID");
    private static final bu e = new bu("DEVICEID_2");
    private static final bu f = new bu("DEVICEID_3");
    private static final bu g = new bu("AD_URL_GET");
    private static final bu h = new bu("AD_URL_REPORT");
    private static final bu i = new bu("HOST_URL");
    private static final bu j = new bu("UUID_SOURCE");
    private static final bu k = new bu("SERVER_TIME_OFFSET");
    private static final bu l = new bu("STARTUP_REQUEST_TIME");
    private static final bu m = new bu("CLIDS");
    private bu n;
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

    public bn(Context context) {
        this(context, null);
    }

    public bn(Context context, String str) {
        super(context, str);
    }

    @Override // com.yandex.metrica.impl.ob.bm
    protected void i() {
        super.i();
        this.n = new bu(c.a());
        this.o = new bu(d.a());
        this.p = new bu(e.a());
        this.q = new bu(f.a());
        this.r = new bu(g.a());
        this.s = new bu(h.a());
        this.t = new bu(i.a());
        this.u = new bu(j.a());
        this.v = new bu(k.a());
        this.w = new bu(l.a());
        this.x = new bu(m.a());
    }

    @Override // com.yandex.metrica.impl.ob.bm
    protected String g() {
        return "_startupinfopreferences";
    }

    public String a(String str) {
        return this.b.getString(this.n.b(), str);
    }

    public String b(String str) {
        return this.b.getString(this.q.b(), str);
    }

    public String a() {
        return this.b.getString(this.p.b(), this.b.getString(this.o.b(), ""));
    }

    public String c(String str) {
        return this.b.getString(this.r.b(), str);
    }

    public String d(String str) {
        return this.b.getString(this.s.b(), str);
    }

    public String e(String str) {
        return this.b.getString(this.t.b(), str);
    }

    public cd b() {
        return cd.a(this.b.getString(this.u.b(), null));
    }

    public long a(long j2) {
        return this.b.getLong(this.v.a(), j2);
    }

    public long b(long j2) {
        return this.b.getLong(this.w.b(), j2);
    }

    public String f(String str) {
        return this.b.getString(this.x.b(), str);
    }

    public bn g(String str) {
        return (bn) a(this.n.b(), str);
    }

    public bn h(String str) {
        return (bn) a(this.q.b(), str);
    }

    public bn j(String str) {
        return (bn) a(this.r.b(), str);
    }

    public bn k(String str) {
        return (bn) a(this.t.b(), str);
    }

    public bn l(String str) {
        return (bn) a(this.s.b(), str);
    }

    public bn a(cd cdVar) {
        return (bn) a(this.u.b(), cdVar.a());
    }

    public bn c(long j2) {
        return (bn) a(this.v.b(), Long.valueOf(j2));
    }

    public bn d(long j2) {
        return (bn) a(this.w.b(), Long.valueOf(j2));
    }

    public bn m(String str) {
        return (bn) a(this.x.b(), str);
    }
}
