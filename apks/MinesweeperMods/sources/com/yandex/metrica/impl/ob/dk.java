package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class dk {
    private String a;
    private String b;
    private String c;

    dk(Context context) {
        try {
            this.a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            this.a = "0.0";
        }
        this.b = context.getFilesDir().getAbsolutePath();
        this.c = context.getPackageName();
    }

    String a() {
        return this.a;
    }

    String b() {
        return this.b;
    }

    String c() {
        return this.c;
    }

    dy a(List<X509Certificate> list) throws GeneralSecurityException, IOException {
        return dm.a(list);
    }

    dy d() throws GeneralSecurityException, IOException {
        ArrayList arrayList = new ArrayList();
        for (String str : a.a()) {
            arrayList.add(dd.a(str));
        }
        return dm.a(arrayList);
    }
}
