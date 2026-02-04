package com.yandex.metrica;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes.dex */
public class d {
    private String a;
    private String b;
    private Map<String, String> c;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public Map<String, String> c() {
        return this.c;
    }

    public void a(Map<String, String> map) {
        this.c = map;
    }

    public boolean equals(Object o) {
        if (!(o instanceof d)) {
            return false;
        }
        d dVar = (d) o;
        if (TextUtils.equals(this.a, dVar.a) && TextUtils.equals(this.b, dVar.b)) {
            return this.c == dVar.c || this.c == null || this.c.equals(dVar.c);
        }
        return false;
    }
}
