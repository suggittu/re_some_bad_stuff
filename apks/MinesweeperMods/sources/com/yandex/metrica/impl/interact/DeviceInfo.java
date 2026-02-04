package com.yandex.metrica.impl.interact;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.yandex.metrica.impl.aj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class DeviceInfo {
    private static Context a;
    public final String deviceType;
    public String locale;
    public final String platformDeviceId;
    public final float scaleFactor;
    public final int screenDpi;
    public final int screenHeight;
    public final int screenWidth;
    public final String platform = "android";
    public final String appPlatform = "android";
    public final String manufacturer = Build.MANUFACTURER;
    public final String model = Build.MODEL;
    public final String osVersion = Build.VERSION.RELEASE;
    public final String deviceRootStatus = String.valueOf(aj.a.c());
    public final List<String> deviceRootStatusMarkers = Collections.unmodifiableList(new ArrayList<String>() { // from class: com.yandex.metrica.impl.interact.DeviceInfo.1
        {
            if (aj.a.a()) {
                add("Superuser.apk");
            }
            if (aj.a.b()) {
                add("su.so");
            }
        }
    });

    private static class a {
        public static DeviceInfo a = new DeviceInfo(DeviceInfo.a);
    }

    public static DeviceInfo getInstance(Context context) {
        a = context;
        return a.a;
    }

    DeviceInfo(Context context) {
        this.platformDeviceId = Settings.Secure.getString(context.getContentResolver(), "android_id");
        this.screenWidth = aj.b(context);
        this.screenHeight = aj.c(context);
        this.screenDpi = context.getResources().getDisplayMetrics().densityDpi;
        this.scaleFactor = context.getResources().getDisplayMetrics().density;
        this.locale = aj.d(context);
        this.deviceType = aj.a(context).name().toLowerCase(Locale.US);
    }

    public String getLocale() {
        this.locale = aj.d(a);
        return this.locale;
    }
}
