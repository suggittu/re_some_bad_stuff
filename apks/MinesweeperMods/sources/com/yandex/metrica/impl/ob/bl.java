package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.Map;

/* loaded from: classes.dex */
public class bl extends bm {
    private final bu c;
    private final bu d;
    private final bu e;
    private final bu f;

    public bl(Context context, String str) {
        super(context, str);
        this.c = new bu("init_event_pref_key", j());
        this.d = new bu("init_event_pref_key");
        this.e = new bu("first_event_pref_key", j());
        this.f = new bu("fitst_event_description_key", j());
    }

    public void a() {
        a(this.c.b(), "DONE").k();
    }

    public String a(String str) {
        return this.b.getString(this.d.b(), str);
    }

    public void b() {
        a(this.e.b(), "DONE").k();
    }

    public String b(String str) {
        return this.b.getString(this.c.b(), str);
    }

    public String c(String str) {
        return this.b.getString(this.e.b(), str);
    }

    public void c() {
        a(this.d);
    }

    public void d(String str) {
        a(new bu("init_event_pref_key", str));
    }

    public boolean d() {
        return b(null) != null;
    }

    public boolean e() {
        return c(null) != null;
    }

    public void e(String str) {
        a(this.f.b(), str).k();
    }

    public String f(String str) {
        return this.b.getString(this.f.b(), str);
    }

    public void f() {
        a(this.f);
    }

    private void a(bu buVar) {
        this.b.edit().remove(buVar.b()).commit();
    }

    @Override // com.yandex.metrica.impl.ob.bm
    protected String g() {
        return "_initpreferences";
    }

    Map<String, ?> h() {
        return this.b.getAll();
    }

    static String g(String str) {
        return new bu("init_event_pref_key", str).b();
    }

    static String h(String str) {
        return str.replace("init_event_pref_key", "");
    }
}
