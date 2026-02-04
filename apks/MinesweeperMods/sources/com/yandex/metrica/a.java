package com.yandex.metrica;

/* loaded from: classes.dex */
public enum a {
    PHONE("phone"),
    TABLET("tablet"),
    TV("tv");

    private final String d;

    a(String str) {
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    public static a a(String str) {
        for (a aVar : values()) {
            if (aVar.d.equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}
