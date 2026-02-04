package com.yandex.metrica.impl.ob;

/* loaded from: classes.dex */
public enum cd {
    EXTERNAL("external"),
    STORED("stored");

    private final String c;

    cd(String str) {
        this.c = str;
    }

    public String a() {
        return this.c;
    }

    public static cd a(String str) {
        for (cd cdVar : values()) {
            if (cdVar.c.equals(str)) {
                return cdVar;
            }
        }
        return STORED;
    }
}
