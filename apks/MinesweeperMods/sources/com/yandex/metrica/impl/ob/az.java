package com.yandex.metrica.impl.ob;

/* loaded from: classes.dex */
public enum az {
    FOREGROUND(0),
    BACKGROUND(1);

    private final int c;

    az(int i) {
        this.c = i;
    }

    public int a() {
        return this.c;
    }

    public static az a(Integer num) {
        az azVar = FOREGROUND;
        if (num != null) {
            switch (num.intValue()) {
            }
            return azVar;
        }
        return azVar;
    }
}
