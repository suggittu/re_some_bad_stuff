package com.yandex.metrica.impl.ob;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class ea<T> {
    private final int a;
    private final String b;
    private ec c;
    private volatile b<T> d;
    private volatile a e;

    public interface a {
        void a(dx dxVar);
    }

    public interface b<T> {
        void a(T t);
    }

    protected abstract T b(dz dzVar) throws dx;

    public ea(int i, String str) {
        this.a = i;
        this.b = str;
        a(new ec());
    }

    public int d() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ea<?> a(ec ecVar) {
        this.c = ecVar;
        return this;
    }

    public String a() {
        return this.b;
    }

    protected b<T> e() {
        return this.d;
    }

    protected void a(b<T> bVar) {
        this.d = bVar;
    }

    protected a f() {
        return this.e;
    }

    protected void a(a aVar) {
        this.e = aVar;
    }

    public Map<String, String> b() throws dx {
        return Collections.emptyMap();
    }

    protected Map<String, String> g() throws dx {
        return k();
    }

    protected String h() {
        return l();
    }

    public String i() {
        return m();
    }

    public byte[] j() throws dx {
        Map<String, String> mapG = g();
        if (mapG == null || mapG.size() <= 0) {
            return null;
        }
        return a(mapG, h());
    }

    protected Map<String, String> k() throws dx {
        return null;
    }

    protected String l() {
        return "UTF-8";
    }

    public String m() {
        return "application/x-www-form-urlencoded; charset=" + l();
    }

    public byte[] c() throws dx {
        Map<String, String> mapK = k();
        if (mapK == null || mapK.size() <= 0) {
            return null;
        }
        return a(mapK, l());
    }

    private static byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    public final int n() {
        return this.c.a();
    }

    public ec o() {
        return this.c;
    }
}
