package com.yandex.metrica.impl.ob;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.yandex.metrica.impl.ob.ea;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class dn {
    private static final String a = dn.class.getSimpleName();
    private dh b;
    private dh c;
    private dy d;
    private Cdo f;
    private String g;
    private dp h;
    private long i;
    private final ReentrantLock j = new ReentrantLock();
    private Map<String, String> e = new HashMap();

    dn(dk dkVar, de deVar, dy dyVar, dj djVar) {
        this.b = deVar.c();
        this.c = deVar.a();
        this.d = dyVar;
        this.g = djVar.b();
        this.e.put("app_id", dkVar.c());
        this.e.put("app_platform", "android_" + Build.VERSION.RELEASE);
        this.e.put("manufacturer", Build.MANUFACTURER);
        this.e.put("model", Build.MODEL);
        this.e.put("app_version", dkVar.a());
        this.i = djVar.a();
    }

    ReentrantLock a() {
        return this.j;
    }

    synchronized boolean b() {
        boolean zA;
        if (j()) {
            Log.i(a, "starting pins update on error");
            JSONObject jSONObjectG = g();
            if (jSONObjectG != null) {
                zA = a(jSONObjectG);
            } else {
                h();
                zA = false;
            }
        } else {
            zA = false;
        }
        return zA;
    }

    synchronized void c() {
        if (d() && j()) {
            Log.i(a, "starting pins update on schedule");
            this.f = i();
            this.d.a(this.f, new ea.b<JSONObject>() { // from class: com.yandex.metrica.impl.ob.dn.1
                @Override // com.yandex.metrica.impl.ob.ea.b
                public void a(JSONObject jSONObject) {
                    dn.this.a(jSONObject);
                    dn.this.f = null;
                }
            }, new ea.a() { // from class: com.yandex.metrica.impl.ob.dn.2
                @Override // com.yandex.metrica.impl.ob.ea.a
                public void a(dx dxVar) {
                    Log.i(dn.a, "can't update pins on schedule: " + dxVar.getMessage());
                    dn.this.h();
                    dn.this.f = null;
                }
            });
        }
    }

    synchronized void a(dp dpVar) {
        this.h = dpVar;
    }

    boolean d() {
        return !e() && (a(this.b, this.i) || a(this.c, this.i));
    }

    boolean e() {
        return this.f != null;
    }

    private JSONObject g() {
        try {
            eb ebVarA = eb.a();
            this.d.a(i(), ebVarA, ebVarA);
            return (JSONObject) ebVarA.get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            Log.i(a, "can't update pins on error: " + e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(JSONObject jSONObject) {
        try {
            a(jSONObject.getJSONArray("pins-sha256"), this.b);
            a(jSONObject.getJSONArray("blacklist"), this.c);
            Log.i(a, "pins have been updated");
            return true;
        } catch (JSONException e) {
            Log.i(a, "can't update pins: " + e.getMessage());
            return false;
        }
    }

    private static void a(JSONArray jSONArray, dh dhVar) throws JSONException {
        dhVar.a();
        for (int i = 0; i < jSONArray.length(); i++) {
            dhVar.a(jSONArray.getString(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.b.d();
        this.c.d();
    }

    private static boolean a(dh dhVar, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return jCurrentTimeMillis - dhVar.c() >= j || jCurrentTimeMillis < dhVar.c();
    }

    private Cdo i() {
        String strA = this.h.a();
        if (TextUtils.isEmpty(strA)) {
            this.e.remove("uuid");
        } else {
            this.e.put("uuid", strA);
        }
        return new Cdo(this.g, this.e);
    }

    private boolean j() {
        return this.d != null;
    }
}
