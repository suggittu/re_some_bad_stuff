package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.CounterConfiguration;

/* loaded from: classes.dex */
public class h {
    private boolean a;
    private final String b;
    private final String c;

    public h(String str, String str2, boolean z) {
        this.a = z;
        this.b = str;
        this.c = str2;
    }

    public String a() {
        return this.b;
    }

    public String toString() {
        String str = this.b;
        if (!this.a) {
            return str + "_" + this.c;
        }
        return str;
    }

    public static h a(Context context, CounterConfiguration counterConfiguration, Integer num, String str) {
        String strF = counterConfiguration.f();
        if (com.yandex.metrica.impl.bi.a(strF)) {
            if (num != null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(num.intValue());
                strF = (packagesForUid == null || packagesForUid.length <= 0) ? null : packagesForUid[0];
            } else {
                strF = str;
            }
        }
        if (com.yandex.metrica.impl.bi.a(strF)) {
            return null;
        }
        return new h(strF, com.yandex.metrica.impl.bk.a(context, counterConfiguration, strF), counterConfiguration.B());
    }

    public static h a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new h(str, null, true);
    }
}
