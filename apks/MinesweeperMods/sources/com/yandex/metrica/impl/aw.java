package com.yandex.metrica.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.cb;
import com.yandex.metrica.impl.utils.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
class aw {
    static final HashMap<String, String> a = new HashMap<String, String>() { // from class: com.yandex.metrica.impl.aw.1
        {
            put("20799a27-fa80-4b36-b2db-0f8141f24180", "13");
            put("01528cc0-dd34-494d-9218-24af1317e1ee", "17233");
            put("4e610cd2-753f-4bfc-9b05-772ce8905c5e", "21952");
            put("67bb016b-be40-4c08-a190-96a3f3b503d3", "22675");
            put("e4250327-8d3c-4d35-b9e8-3c1720a64b91", "22678");
            put("6c5f504e-8928-47b5-bfb5-73af8d8bf4b4", "30404");
            put("7d962ba4-a392-449a-a02d-6c5be5613928", "30407");
        }
    };
    protected p d;
    protected ak e;
    private r f = new r();
    protected final CounterConfiguration b = new CounterConfiguration();
    protected final List<g> c = new ArrayList();

    protected aw() {
    }

    void a(c.a aVar) {
        this.d = new p(aVar);
    }

    CounterConfiguration b() {
        return this.b;
    }

    boolean c() {
        return this.b.m();
    }

    Bundle d() {
        return this.b.E();
    }

    void a(cb cbVar) {
        b(cbVar);
    }

    synchronized void a(g gVar) {
        this.c.add(gVar);
    }

    synchronized boolean e() {
        return !this.c.isEmpty();
    }

    synchronized List<g> f() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.c);
        this.c.clear();
        return arrayList;
    }

    void g() {
        this.f.b();
    }

    boolean h() {
        return this.f.a();
    }

    boolean a() {
        return this.f.c();
    }

    void b(cb cbVar) {
        if (cbVar != null) {
            this.b.d(cbVar.a());
            this.b.e(cbVar.c());
            this.b.f(cbVar.b());
        }
    }

    void a(i iVar) {
        this.b.a((ResultReceiver) iVar);
    }

    void a(String str, String str2) {
        this.d.a(str, str2);
    }

    String i() {
        return this.d.a();
    }

    ak j() {
        return this.e;
    }

    void a(ak akVar) {
        this.e = akVar;
    }
}
