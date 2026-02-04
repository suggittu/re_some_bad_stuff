package com.yandex.metrica.impl.ob;

import android.telephony.SubscriptionInfo;

/* loaded from: classes.dex */
public final class ck {
    private final Integer a;
    private final Integer b;
    private final boolean c;
    private final String d;
    private final String e;

    public ck(Integer num, Integer num2, boolean z, String str, String str2) {
        this.a = num;
        this.b = num2;
        this.c = z;
        this.d = str;
        this.e = str2;
    }

    public ck(SubscriptionInfo subscriptionInfo) {
        this.a = Integer.valueOf(subscriptionInfo.getMcc());
        this.b = Integer.valueOf(subscriptionInfo.getMnc());
        this.c = subscriptionInfo.getDataRoaming() == 1;
        this.d = subscriptionInfo.getCarrierName().toString();
        this.e = subscriptionInfo.getIccId();
    }

    public Integer a() {
        return this.a;
    }

    public Integer b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }
}
