package com.yandex.metrica.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.yandex.metrica.IMetricaService;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class be {
    public static Intent a(Context context) {
        Intent intent = new Intent(IMetricaService.class.getName(), Uri.parse("metrica://" + context.getPackageName()));
        if (bk.b(11)) {
            intent.addFlags(32);
        }
        return intent;
    }

    public static List<ResolveInfo> a(Context context, Intent intent) {
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        return listQueryIntentServices != null ? listQueryIntentServices : new ArrayList();
    }

    static int a(PackageItemInfo packageItemInfo) {
        if (packageItemInfo.metaData == null) {
            return -1;
        }
        return packageItemInfo.metaData.getInt("metrica:api:level");
    }

    public static Intent b(Context context) {
        return a(context).putExtras(d(context)).setPackage(context.getApplicationContext().getPackageName());
    }

    private static Bundle d(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            return bundle == null ? new Bundle() : bundle;
        } catch (Exception e) {
            return new Bundle();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(android.content.Context r14) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.be.c(android.content.Context):java.lang.String");
    }
}
