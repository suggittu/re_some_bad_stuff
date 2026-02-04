package com.yandex.metrica.impl.ob;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: classes.dex */
public class bk {
    static final HashMap<String, String> a = new HashMap<String, String>() { // from class: com.yandex.metrica.impl.ob.bk.1
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
    private bl b;

    public bk(bl blVar) {
        this.b = blVar;
    }

    public void a() {
        if (f()) {
            g();
            h();
        }
    }

    public void b() {
        a(d());
    }

    public void c() {
        a(e());
    }

    void a(String str) {
        if (str != null) {
            b(str);
            g();
        }
    }

    String d() {
        return a.get(this.b.j());
    }

    String e() {
        Map<String, ?> mapH = this.b.h();
        Iterator<String> it = a.values().iterator();
        while (it.hasNext()) {
            mapH.remove(bl.g(it.next()));
        }
        LinkedList linkedList = new LinkedList();
        Iterator<String> it2 = mapH.keySet().iterator();
        while (it2.hasNext()) {
            try {
                linkedList.add(Integer.valueOf(Integer.parseInt(bl.h(it2.next()))));
            } catch (Throwable th) {
            }
        }
        if (linkedList.size() == 1) {
            return ((Integer) linkedList.getFirst()).toString();
        }
        return null;
    }

    boolean f() {
        return this.b.a((String) null) != null;
    }

    void g() {
        this.b.a();
    }

    void b(String str) {
        this.b.d(str);
    }

    void h() {
        this.b.c();
    }
}
