package com.yandex.metrica.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.MetricaService;
import com.yandex.metrica.impl.GoogleAdvertisingIdGetter;
import com.yandex.metrica.impl.o;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class bk {

    static class a extends JSONObject {
        public a(String str) throws JSONException {
            super(str);
        }

        public String a(String str) {
            try {
                return super.getString(str);
            } catch (Exception e) {
                return "";
            }
        }

        public Object a(String str, Object obj) {
            try {
                return super.get(str);
            } catch (Exception e) {
                return obj;
            }
        }

        public boolean b(String str) {
            try {
                return NULL != super.get(str);
            } catch (Exception e) {
                return false;
            }
        }
    }

    public static String a(Context context, String str) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(str, 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            return "0";
        }
    }

    public static String b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "0.0";
        }
    }

    public static String a(String str) {
        String strB;
        StringBuilder sbAppend = new StringBuilder().append(str).append("/").append(bc.a()).append(".4641 (");
        if (Build.MODEL.startsWith(Build.MANUFACTURER)) {
            strB = bi.b(Build.MODEL);
        } else {
            strB = bi.b(Build.MANUFACTURER) + " " + Build.MODEL;
        }
        return sbAppend.append(strB).append("; Android ").append(Build.VERSION.RELEASE).append(")").toString();
    }

    public static String a(String str, Throwable th) {
        String strB = b(th);
        if (!TextUtils.isEmpty(str)) {
            return str + ":\n" + strB;
        }
        return strB;
    }

    private static String b(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String string = stringWriter.toString();
        printWriter.close();
        return string;
    }

    public static boolean a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    public static boolean b(int i) {
        return Build.VERSION.SDK_INT > i;
    }

    public static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
            }
        }
    }

    public static void a(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public static void a(Object obj, String str) throws IllegalArgumentException {
        if (obj == null) {
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid %s. %s should not be null.", str, str));
        }
    }

    public static void a(String str, String str2) throws IllegalArgumentException {
        if (bi.a(str)) {
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid %s. %s should not be null/empty.", str2, str2));
        }
    }

    public static void b(String str) {
        a(str, "API Key");
        try {
            UUID.fromString(str);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format(Locale.US, "Invalid %s = %s. Please, read official documentation how to obtain one: %s", "API Key", str, "https://tech.yandex.com/metrica-mobile-sdk/doc/mobile-sdk-dg/concepts/android-initialize-docpage/"));
        }
    }

    public static long a(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        long jMax;
        long jLastModified = -1;
        try {
            if (b(8)) {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                jMax = Math.max(packageInfo.firstInstallTime, packageInfo.lastUpdateTime);
            } else {
                jMax = -1;
            }
        } catch (Exception e) {
            jMax = -1;
        }
        try {
            File file = new File(packageManager.getApplicationInfo(str, 0).sourceDir);
            if (file.exists()) {
                jLastModified = file.lastModified();
            }
        } catch (Exception e2) {
        }
        return Math.max(jMax, jLastModified);
    }

    public static List<ResolveInfo> a(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            Intent intent = new Intent(str, (Uri) null);
            intent.addCategory(str2);
            return context.getPackageManager().queryIntentActivities(intent, 0);
        } catch (Exception e) {
            return arrayList;
        }
    }

    static final class b implements Runnable {
        final Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() throws PackageManager.NameNotFoundException {
            Context context = this.a;
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 516);
                if (packageInfo.services != null) {
                    ServiceInfo[] serviceInfoArr = packageInfo.services;
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        if (MetricaService.class.getName().equals(serviceInfo.name) && !serviceInfo.enabled) {
                            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) MetricaService.class), 1, 1);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static String a(PackageManager packageManager, String str, String str2, String str3) {
        try {
            Bundle bundle = packageManager.getApplicationInfo(str, 128).metaData;
            Object obj = bundle != null ? bundle.get(str2) : null;
            return obj != null ? obj.toString() : str3;
        } catch (Exception e) {
            return str3;
        }
    }

    public static long a(boolean z) {
        try {
            StatFs statFsC = c(z);
            return (statFsC.getBlockSize() * statFsC.getBlockCount()) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        } catch (Throwable th) {
            return 0L;
        }
    }

    public static long b(boolean z) {
        try {
            StatFs statFsC = c(z);
            return (statFsC.getBlockSize() * statFsC.getAvailableBlocks()) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        } catch (Throwable th) {
            return 0L;
        }
    }

    public static StatFs c(boolean z) {
        return !z ? new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()) : new StatFs(Environment.getRootDirectory().getAbsolutePath());
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Exception e) {
            }
        }
    }

    public static boolean a(Map map) {
        return map == null || map.size() == 0;
    }

    public static boolean a(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static CounterConfiguration a(Bundle bundle) {
        CounterConfiguration counterConfiguration;
        if (bundle != null) {
            try {
                counterConfiguration = (CounterConfiguration) bundle.getParcelable("COUNTER_CFG_OBJ");
            } catch (Throwable th) {
                return null;
            }
        } else {
            counterConfiguration = null;
        }
        if (counterConfiguration == null) {
            counterConfiguration = new CounterConfiguration();
        }
        counterConfiguration.a(bundle);
        return counterConfiguration;
    }

    public static CounterConfiguration b(Bundle bundle) {
        CounterConfiguration counterConfiguration;
        if (bundle != null) {
            try {
                counterConfiguration = (CounterConfiguration) bundle.getParcelable("COUNTER_MIGRATION_CFG_OBJ");
            } catch (Throwable th) {
                return null;
            }
        } else {
            counterConfiguration = null;
        }
        return counterConfiguration;
    }

    public static String a(Context context, CounterConfiguration counterConfiguration, String str) {
        return counterConfiguration.C() ? counterConfiguration.j() : a(context.getPackageManager(), str, "metrica:api:key", null);
    }

    public static boolean c(String str) {
        return (bi.a(str) || "-1".equals(str)) ? false : true;
    }

    static boolean a(Throwable th) {
        String strB = b(th);
        return !TextUtils.isEmpty(strB) && strB.contains(new StringBuilder("at ").append("com.yandex.metrica").append(".").toString());
    }

    public static HashMap<String, String> a(JSONObject jSONObject) {
        if (JSONObject.NULL.equals(jSONObject)) {
            return null;
        }
        HashMap<String, String> map = new HashMap<>();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject.optString(next);
            if (strOptString != null) {
                map.put(next, strOptString);
            }
        }
        return map;
    }

    public static HashMap<String, String> d(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return a(new JSONObject(str));
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public static String b(Map map) {
        if (a(map)) {
            return null;
        }
        if (a(19)) {
            return new JSONObject(map).toString();
        }
        return a((Object) map).toString();
    }

    static Object a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            if (obj.getClass().isArray()) {
                int length = Array.getLength(obj);
                ArrayList arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(a(Array.get(obj, i)));
                }
                return new JSONArray((Collection) arrayList);
            }
            if (obj instanceof Collection) {
                Collection collection = (Collection) obj;
                ArrayList arrayList2 = new ArrayList(collection.size());
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    arrayList2.add(a(it.next()));
                }
                return new JSONArray((Collection) arrayList2);
            }
            if (obj instanceof Map) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    String string = entry.getKey().toString();
                    if (string != null) {
                        linkedHashMap.put(string, a(entry.getValue()));
                    }
                }
                return new JSONObject(linkedHashMap);
            }
            return obj;
        } catch (Exception e) {
            return null;
        }
    }

    public static String c(Context context, String str) {
        String strA = o.b.a.a(context);
        if (!bi.a(strA)) {
            Intent intentA = be.a(context);
            intentA.setPackage(str);
            Iterator<ResolveInfo> it = be.a(context, intentA).iterator();
            while (it.hasNext()) {
                if (be.a(it.next().serviceInfo) < 29) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("DEVICE_ID", strA);
                        if (!bi.a(strA)) {
                            context.getContentResolver().update(Uri.parse(String.format(Locale.US, "content://%s.MetricaContentProvider/DEVICE_ID", str)), contentValues, null, null);
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return strA;
    }

    public static Boolean a() {
        return GoogleAdvertisingIdGetter.b.a.c();
    }
}
