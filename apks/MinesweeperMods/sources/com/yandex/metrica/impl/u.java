package com.yandex.metrica.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.SystemClock;
import android.util.Base64;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class u {
    JSONObject a;

    public u(String str) {
        try {
            this.a = new JSONObject(str);
        } catch (Exception e) {
            this.a = new JSONObject();
        }
    }

    public u a() {
        try {
            c();
            b();
        } catch (Exception e) {
        }
        return this;
    }

    u b() throws JSONException {
        ((JSONObject) a(this.a, "dfid", new JSONObject())).put("boot_time", (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000);
        return this;
    }

    u a(Context context) throws JSONException, UnsupportedEncodingException {
        JSONObject jSONObject = (JSONObject) a((JSONObject) a(this.a, "dfid", new JSONObject()), "au", new JSONObject());
        JSONArray jSONArray = (JSONArray) a(jSONObject, "aun", new JSONArray());
        JSONArray jSONArray2 = (JSONArray) a(jSONObject, "ausf", new JSONArray());
        JSONArray jSONArray3 = (JSONArray) a(jSONObject, "audf", new JSONArray());
        JSONArray jSONArray4 = (JSONArray) a(jSONObject, "aulu", new JSONArray());
        jSONObject.put("auv", 0);
        HashSet hashSet = new HashSet();
        Iterator<ResolveInfo> it = bk.a(context, new String(Base64.decode("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLk1BSU4=", 0), "UTF-8"), new String(Base64.decode("YW5kcm9pZC5pbnRlbnQuY2F0ZWdvcnkuTEFVTkNIRVI=", 0), "UTF-8")).iterator();
        while (it.hasNext()) {
            ApplicationInfo applicationInfo = it.next().activityInfo.applicationInfo;
            if (hashSet.add(applicationInfo.packageName)) {
                jSONArray.put(applicationInfo.packageName);
                jSONArray2.put((applicationInfo.flags & 1) == 1);
                jSONArray4.put(new File(applicationInfo.sourceDir).lastModified());
                jSONArray3.put(!applicationInfo.enabled);
            }
        }
        return this;
    }

    u b(Context context) throws JSONException {
        JSONObject jSONObject = (JSONObject) a((JSONObject) a(this.a, "dfid", new JSONObject()), "apps", new JSONObject());
        JSONArray jSONArray = (JSONArray) a(jSONObject, "names", new JSONArray());
        JSONArray jSONArray2 = (JSONArray) a(jSONObject, "system_flags", new JSONArray());
        JSONArray jSONArray3 = (JSONArray) a(jSONObject, "disabled_flags", new JSONArray());
        JSONArray jSONArray4 = (JSONArray) a(jSONObject, "first_install_time", new JSONArray());
        JSONArray jSONArray5 = (JSONArray) a(jSONObject, "last_update_time", new JSONArray());
        jSONObject.put("version", 0);
        for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(0)) {
            jSONArray.put(packageInfo.packageName);
            jSONArray2.put((packageInfo.applicationInfo.flags & 1) == 1);
            jSONArray3.put(!packageInfo.applicationInfo.enabled);
            if (Build.VERSION.SDK_INT >= 9) {
                jSONArray4.put(packageInfo.firstInstallTime / 1000);
                jSONArray5.put(packageInfo.lastUpdateTime / 1000);
            }
        }
        return this;
    }

    u c() throws JSONException {
        JSONObject jSONObject = (JSONObject) a(this.a, "dfid", new JSONObject());
        long jA = bk.a(true);
        long jA2 = bk.a(false);
        long jB = bk.b(true);
        long jB2 = bk.b(false);
        jSONObject.put("tds", jA + jA2);
        jSONObject.put("fds", jB + jB2);
        return this;
    }

    static <T> T a(JSONObject jSONObject, String str, T t) throws JSONException {
        if (!jSONObject.has(str)) {
            jSONObject.put(str, t);
        }
        return (T) jSONObject.get(str);
    }

    public String toString() {
        return this.a.toString();
    }

    public String d() {
        return Base64.encodeToString(new com.yandex.metrica.impl.utils.d().a(bi.c(this.a.toString())), 0);
    }
}
