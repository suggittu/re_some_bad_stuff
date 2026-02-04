package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.telephony.TelephonyManager;

/* loaded from: classes.dex */
public class cl extends ce {
    private static final Object a = new Object();
    private static volatile cl b;
    private ce c;

    public static cl a(Context context) {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new cl(context.getApplicationContext());
                }
            }
        }
        return b;
    }

    cl(Context context) {
        if (((TelephonyManager) context.getSystemService("phone")).getPhoneType() == 0) {
            this.c = new ci();
        } else {
            this.c = new ch(context);
        }
    }

    @Override // com.yandex.metrica.impl.ob.cj
    public void a() {
        this.c.a();
    }

    @Override // com.yandex.metrica.impl.ob.cj
    public void b() {
        this.c.b();
    }

    @Override // com.yandex.metrica.impl.ob.ce
    public void a(cn cnVar) {
        this.c.a(cnVar);
    }

    @Override // com.yandex.metrica.impl.ob.ce
    public void a(cg cgVar) {
        this.c.a(cgVar);
    }
}
