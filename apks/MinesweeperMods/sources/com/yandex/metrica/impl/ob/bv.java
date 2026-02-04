package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class bv {
    public static SharedPreferences a(Context context, String str) {
        return context.getSharedPreferences(context.getPackageName() + str, 0);
    }

    public static void a(SharedPreferences sharedPreferences, String str, int i) {
        if (sharedPreferences != null && sharedPreferences.contains(str)) {
            try {
                sharedPreferences.edit().remove(str).putLong(str, sharedPreferences.getInt(str, i)).commit();
            } catch (ClassCastException e) {
            }
        }
    }
}
