package com.yandex.metrica.impl;

import android.os.Bundle;
import com.yandex.metrica.impl.utils.c;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    private JSONObject a;
    private long b;
    private boolean c;
    private c.a d = c.a.d();
    private final com.yandex.metrica.impl.utils.c e = new com.yandex.metrica.impl.utils.c();

    public static final class a {
        public final String a;
        public final long b;

        public a(String str, long j) {
            this.a = str;
            this.b = j;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            a aVar = (a) o;
            if (this.b != aVar.b) {
                return false;
            }
            if (this.a != null) {
                if (this.a.equals(aVar.a)) {
                    return true;
                }
            } else if (aVar.a == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((this.a != null ? this.a.hashCode() : 0) * 31) + ((int) (this.b ^ (this.b >>> 32)));
        }
    }

    public b(String str, long j) {
        this.a = new JSONObject();
        this.b = j;
        try {
            this.a = new JSONObject(str);
        } catch (JSONException e) {
            this.a = new JSONObject();
            this.b = 0L;
        }
    }

    public synchronized void a() {
        this.a = new JSONObject();
        this.b = 0L;
    }

    public synchronized void a(String str, String str2) {
        try {
            String strA = this.e.a(str, this.d.b(), "App Environment");
            String strA2 = this.e.a(str2, this.d.c(), "App Environment");
            if (this.a.has(strA)) {
                String string = this.a.getString(strA);
                if (strA2 == null || !strA2.equals(string)) {
                    b(strA, strA2);
                }
            } else if (strA2 != null) {
                b(strA, strA2);
            }
        } catch (JSONException e) {
        }
    }

    public synchronized void a(Bundle bundle) {
        for (String str : bundle.keySet()) {
            a(str, bundle.getString(str));
        }
    }

    synchronized void b(String str, String str2) throws JSONException {
        if (this.a.length() < this.d.a() || (this.d.a() == this.a.length() && this.a.has(str))) {
            this.a.put(str, str2);
            this.c = true;
        } else {
            this.e.b(str, this.d.a(), "App Environment");
        }
    }

    public synchronized a b() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new a(this.a.toString(), this.b);
    }

    public synchronized String toString() {
        return "Map size " + this.a.length() + ". Is changed " + this.c + ". Current revision " + this.b;
    }
}
