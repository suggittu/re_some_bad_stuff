package com.yandex.metrica.impl.ob;

import android.os.Bundle;

/* loaded from: classes.dex */
public enum bz {
    UNKNOWN(0),
    NETWORK(1),
    PARSE(2);

    private int d;

    bz(int i) {
        this.d = i;
    }

    public int a() {
        return this.d;
    }

    public Bundle a(Bundle bundle) {
        bundle.putInt("startup_error_key_code", a());
        return bundle;
    }

    public static bz b(Bundle bundle) {
        int i = bundle.getInt("startup_error_key_code");
        bz bzVar = UNKNOWN;
        switch (i) {
            case 1:
                return NETWORK;
            case 2:
                return PARSE;
            default:
                return bzVar;
        }
    }
}
