package com.yandex.metrica.impl;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.yandex.metrica.impl.d;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class bm implements d {
    private static volatile bm b;
    private static final Object c = new Object();
    private final WifiManager a;
    private d.a<JSONArray> d = new d.a<>();
    private d.a<List<a>> e = new d.a<>();

    private bm(Context context) {
        this.a = (WifiManager) context.getSystemService("wifi");
    }

    static bm a(Context context) {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new bm(context.getApplicationContext());
                }
            }
        }
        return b;
    }

    synchronized JSONArray a() {
        JSONArray jSONArrayB;
        if (!d()) {
            jSONArrayB = new JSONArray();
        } else {
            if (this.d.c() || this.d.d()) {
                this.d.a(c());
            }
            jSONArrayB = this.d.b();
        }
        return jSONArrayB;
    }

    private JSONArray c() throws JSONException {
        String bssid;
        try {
            List<ScanResult> scanResults = this.a.getScanResults();
            JSONArray jSONArray = new JSONArray();
            WifiInfo connectionInfo = this.a.getConnectionInfo();
            if (connectionInfo == null) {
                bssid = null;
            } else {
                bssid = connectionInfo.getBSSID();
            }
            for (ScanResult scanResult : scanResults) {
                if (scanResult != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("mac", scanResult.BSSID.toUpperCase(Locale.US).replace(":", ""));
                    jSONObject.put("signal_strength", scanResult.level);
                    jSONObject.put("ssid", scanResult.SSID);
                    jSONObject.put("is_connected", scanResult.BSSID.equals(bssid));
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray;
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    private boolean d() {
        try {
            return this.a.isWifiEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public List<a> b() {
        if (this.e.c() || this.e.d()) {
            ArrayList arrayList = new ArrayList();
            if (bk.a(9)) {
                a(arrayList);
            } else {
                String strE = e();
                if (strE != null) {
                    arrayList.add(new a("wlan0", strE));
                }
            }
            this.e.a(arrayList);
        }
        return this.e.b();
    }

    private static void a(List<a> list) {
        StringBuilder sb = new StringBuilder();
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                if (hardwareAddress != null) {
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format(Locale.US, "%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                        list.add(new a(networkInterface.getName(), sb.toString()));
                        sb.setLength(0);
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    private static String e() {
        try {
            return s.a("/sys/class/net/wlan0/address").toUpperCase(Locale.US);
        } catch (Exception e) {
            return null;
        }
    }

    public static final class a {
        public final String a;
        public final String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }
}
