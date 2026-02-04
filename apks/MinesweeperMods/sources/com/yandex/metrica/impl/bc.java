package com.yandex.metrica.impl;

/* loaded from: classes.dex */
public class bc {
    public static String a() {
        return "2.42".length() - "2.42".indexOf(46) < 3 ? "2.420" : "2.42";
    }

    public static String b() {
        return a.a;
    }

    private static class a {
        static final String a;

        static boolean a(String str) {
            try {
                return Class.forName(str) != null;
            } catch (ClassNotFoundException e) {
                return false;
            }
        }

        static {
            String str = "native";
            if (a("com.unity3d.player.UnityPlayer")) {
                str = "unity";
            } else if (a("mono.MonoPackageManager")) {
                str = "xamarin";
            }
            a = str;
        }
    }
}
