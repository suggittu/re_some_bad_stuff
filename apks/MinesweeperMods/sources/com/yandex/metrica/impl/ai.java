package com.yandex.metrica.impl;

import android.content.pm.PackageManager;

/* loaded from: classes.dex */
final class ai {
    public static boolean a(PackageManager packageManager, String str, String str2) {
        return str2 == null || packageManager.checkPermission(str2, str) == 0;
    }
}
