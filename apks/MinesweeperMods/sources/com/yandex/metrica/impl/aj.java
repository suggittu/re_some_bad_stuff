package com.yandex.metrica.impl;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class aj {

    public static final class a {
        private static final String[] a = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};

        public static boolean a() {
            return new File("/system/app/Superuser.apk").exists();
        }

        public static boolean b() {
            for (String str : a) {
                if (new File(str + "su").exists()) {
                    return true;
                }
            }
            return false;
        }

        public static int c() {
            return (a() || b()) ? 1 : 0;
        }
    }

    public static com.yandex.metrica.a a(Context context) throws NoSuchMethodException, SecurityException {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Point pointE = e(context);
        int i = pointE.x;
        int i2 = pointE.y;
        float fMin = Math.min(i / displayMetrics.density, i2 / displayMetrics.density);
        float f = i / displayMetrics.xdpi;
        float f2 = i2 / displayMetrics.ydpi;
        double dSqrt = Math.sqrt((f2 * f2) + (f * f));
        if (dSqrt >= 15.0d && !context.getPackageManager().hasSystemFeature("android.hardware.touchscreen")) {
            return com.yandex.metrica.a.TV;
        }
        if (dSqrt >= 7.0d || fMin >= 600.0f) {
            return com.yandex.metrica.a.TABLET;
        }
        return com.yandex.metrica.a.PHONE;
    }

    private static Point e(Context context) throws NoSuchMethodException, SecurityException {
        int width;
        int height;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            width = displayMetrics.widthPixels;
            height = displayMetrics.heightPixels;
        } else if (Build.VERSION.SDK_INT >= 14) {
            try {
                Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                width = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                height = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception e) {
                width = defaultDisplay.getWidth();
                height = defaultDisplay.getHeight();
            }
        } else {
            width = defaultDisplay.getWidth();
            height = defaultDisplay.getHeight();
        }
        return new Point(width, height);
    }

    public static int b(Context context) {
        return e(context).x;
    }

    public static int c(Context context) {
        return e(context).y;
    }

    public static String d(Context context) {
        String strTrim = context.getResources().getConfiguration().locale.toString().trim();
        if (2 == strTrim.indexOf("_")) {
            return strTrim.replaceFirst("_", "-");
        }
        return strTrim;
    }
}
