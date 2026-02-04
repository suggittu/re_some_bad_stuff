package com.yandex.metrica;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import com.yandex.metrica.impl.am;
import com.yandex.metrica.impl.be;
import com.yandex.metrica.impl.bk;
import com.yandex.metrica.impl.bn;
import com.yandex.metrica.impl.bo;
import com.yandex.metrica.impl.interact.CellularNetworkInfo;
import com.yandex.metrica.impl.interact.DeviceInfo;
import com.yandex.metrica.impl.z;

/* loaded from: classes.dex */
public final class p {
    public static void rolu(Context context, Object registrant) {
        z.a(context).a(registrant);
    }

    public static void urolu(Context context, Object registrant) {
        z.a(context).b(registrant);
    }

    public static Location glkl(Context context) {
        return z.a(context).d();
    }

    public static String u(String sdkName) {
        return bk.a(sdkName);
    }

    public static Boolean plat() {
        return bk.a();
    }

    public static boolean iifa() {
        return bn.a();
    }

    public static String pgai() {
        return bn.b();
    }

    public static Integer gbc(Context context) {
        Intent intentRegisterReceiver = context.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return null;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("level", -1);
        int intExtra2 = intentRegisterReceiver.getIntExtra("scale", -1);
        if (intExtra < 0 || intExtra2 <= 0) {
            return null;
        }
        return Integer.valueOf(Math.round((intExtra / intExtra2) * 100.0f));
    }

    public static String gmsvn(int apiLevel) {
        return am.a(apiLevel);
    }

    public static YandexMetricaConfig cpcwh(YandexMetricaConfig config, String h) {
        return e.b(config).d(h).b();
    }

    public static void a(IIdentifierCallback callback) {
        bo.a().a(callback);
    }

    public static DeviceInfo gdi(Context context) {
        return DeviceInfo.getInstance(context);
    }

    public static String gcni(Context context) {
        return new CellularNetworkInfo(context).getCelluralInfo();
    }

    public static String guid() {
        return bo.a().d();
    }

    public static String mpn(Context context) {
        return be.c(context);
    }
}
