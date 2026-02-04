package com.yandex.metrica.impl.utils;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.c;
import com.yandex.metrica.impl.bi;
import com.yandex.metrica.impl.q;
import java.util.Locale;

/* loaded from: classes.dex */
public final class f extends a {
    private static final int[] a = {3, 6, 4};
    private static final f b = new f();
    private static String c = "";

    public f() {
        super(false);
    }

    public static f e() {
        return b;
    }

    public static void a(Context context) {
        c = String.format("[%s] : ", context.getPackageName());
    }

    @Override // com.yandex.metrica.impl.utils.a
    public String c() {
        return "AppMetrica";
    }

    @Override // com.yandex.metrica.impl.utils.a
    String d(String str, Object[] objArr) {
        return String.format(Locale.US, str, objArr);
    }

    @Override // com.yandex.metrica.impl.utils.a
    String d() {
        return bi.b(c, "");
    }

    public void a(com.yandex.metrica.impl.g gVar, String str) {
        if (q.b(gVar.c())) {
            a("%s: %s", str, gVar.a());
        }
    }

    public void a(c.a.g gVar, String str) {
        for (c.a.g.C0272a c0272a : gVar.d) {
            a(c0272a, str);
        }
    }

    public void a(c.a.g.C0272a c0272a, String str) {
        boolean z;
        String strB;
        int[] iArr = a;
        int length = iArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (c0272a.d == iArr[i]) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (c0272a.d == 3 && TextUtils.isEmpty(c0272a.e)) {
            strB = q.a.EVENT_TYPE_NATIVE_CRASH.b();
        } else {
            strB = c0272a.e;
        }
        objArr[1] = strB;
        a("%s: %s", objArr);
    }
}
