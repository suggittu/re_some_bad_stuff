package com.yandex.metrica.impl;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.yandex.metrica.impl.q;
import java.util.Locale;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class g {
    String a;
    String b;
    int c;
    boolean d;
    private a e;
    private String f;
    private String g;
    private String h;
    private Bundle i;
    private int j;
    private String k;

    public g() {
        this.e = new a((byte) 0);
        this.d = false;
        this.j = 2;
    }

    public g(g gVar) {
        this.e = new a((byte) 0);
        this.d = false;
        this.j = 2;
        if (gVar != null) {
            this.a = gVar.a();
            this.b = gVar.b();
            this.c = gVar.c();
            this.f = gVar.j();
            this.h = gVar.k();
            this.g = gVar.h();
            this.e.a = gVar.d();
            this.e.b = gVar.e();
            this.e.c = gVar.g();
            this.i = gVar.i();
            this.d = gVar.n();
            this.j = gVar.o();
            this.k = gVar.p();
        }
    }

    public g(String str, String str2, int i) {
        this.e = new a((byte) 0);
        this.d = false;
        this.j = 2;
        this.a = str2;
        this.c = i;
        this.b = str;
    }

    public String a() {
        return this.a;
    }

    public g b(String str) {
        this.a = str;
        return this;
    }

    public String b() {
        return this.b;
    }

    public g c(String str) {
        this.b = str;
        return this;
    }

    public int c() {
        return this.c;
    }

    public g a(int i) {
        this.c = i;
        return this;
    }

    public Location d() {
        return this.e.a;
    }

    g a(Location location) {
        this.e.a = location;
        return this;
    }

    String e() {
        return this.e.b;
    }

    JSONArray f() {
        try {
            return new JSONArray(this.e.b);
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    g d(String str) {
        this.e.b = str;
        return this;
    }

    Integer g() {
        return this.e.c;
    }

    g a(Integer num) {
        this.e.c = num;
        return this;
    }

    String h() {
        return this.g;
    }

    public Bundle i() {
        return this.i;
    }

    g e(String str) {
        this.g = str;
        return this;
    }

    g a(String str, String str2) {
        if (this.i == null) {
            this.i = new Bundle();
        }
        this.i.putString(str, str2);
        return this;
    }

    public String j() {
        return this.f;
    }

    public g a(String str) {
        this.f = str;
        return this;
    }

    public String k() {
        return this.h;
    }

    public g f(String str) {
        this.h = str;
        return this;
    }

    protected g a(boolean z) {
        this.d = z;
        return this;
    }

    protected g b(int i) {
        this.j = i;
        return this;
    }

    protected g g(String str) {
        this.k = str;
        return this;
    }

    public boolean l() {
        return this.a == null;
    }

    public boolean m() {
        return q.a.EVENT_TYPE_UNDEFINED.a() == this.c;
    }

    public boolean n() {
        return this.d;
    }

    public int o() {
        return this.j;
    }

    public String p() {
        return this.k;
    }

    Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("CounterReport.Event", this.a);
        bundle2.putString("CounterReport.Value", this.b);
        bundle2.putInt("CounterReport.Type", this.c);
        bundle2.putString("CounterReport.Wifi", this.e.b);
        bundle2.putByteArray("CounterReport.GeoLocation", z.b(this.e.a));
        bundle2.putBoolean("CounterReport.TRUNCATED", this.d);
        bundle2.putInt("CounterReport.ConnectionType", this.j);
        bundle2.putString("CounterReport.CellularConnectionType", this.k);
        if (this.e.c != null) {
            bundle2.putInt("CounterReport.CellId", this.e.c.intValue());
        }
        if (this.g != null) {
            bundle2.putString("CounterReport.Environment", this.g);
        }
        if (this.f != null) {
            bundle2.putString("CounterReport.UserInfo", this.f);
        }
        if (this.h != null) {
            bundle2.putString("CounterReport.PackageName", this.h);
        }
        if (this.i != null) {
            bundle2.putBundle("CounterReport.AppEnvironmentDiff", this.i);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBundle("CounterReport.Object", bundle2);
        return bundle;
    }

    public static g b(Bundle bundle) {
        Bundle bundle2 = bundle.containsKey("CounterReport.Object") ? bundle.getBundle("CounterReport.Object") : new Bundle();
        g gVarF = new g().a(bundle2.getInt("CounterReport.Type", q.a.EVENT_TYPE_UNDEFINED.a())).a(z.a(bundle2.getByteArray("CounterReport.GeoLocation"))).c(bi.b(bundle2.getString("CounterReport.Value"), "")).a(bundle2.getString("CounterReport.UserInfo")).e(bundle2.getString("CounterReport.Environment")).d(bundle2.getString("CounterReport.Wifi")).a((Integer) bundle2.get("CounterReport.CellId")).b(bundle2.getString("CounterReport.Event")).f(bundle2.getString("CounterReport.PackageName"));
        gVarF.i = bundle2.getBundle("CounterReport.AppEnvironmentDiff");
        return gVarF.a(bundle2.getBoolean("CounterReport.TRUNCATED")).b(bundle2.getInt("CounterReport.ConnectionType")).g(bundle2.getString("CounterReport.CellularConnectionType"));
    }

    public static g a(g gVar, q.a aVar) {
        g gVar2 = new g(gVar);
        gVar2.b(aVar.b());
        gVar2.a(aVar.a());
        return gVar2;
    }

    public static g a(com.yandex.metrica.impl.ob.i iVar, g gVar) {
        Context contextM = iVar.m();
        u uVarA = new u(gVar.b()).a();
        try {
            if (iVar.x()) {
                uVarA.b(contextM);
            }
            if (iVar.h().D()) {
                uVarA.a(contextM);
            }
        } catch (Exception e) {
        }
        g gVar2 = new g(gVar);
        gVar2.a(q.a.EVENT_TYPE_IDENTITY.a()).c(uVarA.d());
        return gVar2;
    }

    public String toString() {
        return String.format(Locale.US, "[event: %s, type: %d, value: %s]", this.a, Integer.valueOf(this.c), this.b);
    }

    private static final class a {
        Location a;
        String b;
        Integer c;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }
}
