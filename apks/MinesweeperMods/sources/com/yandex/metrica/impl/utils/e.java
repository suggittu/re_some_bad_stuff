package com.yandex.metrica.impl.utils;

/* loaded from: classes.dex */
public class e {
    public static int a(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public static long a(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return j;
        }
    }
}
