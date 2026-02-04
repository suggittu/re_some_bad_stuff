package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.client.zza;

@zzhb
/* loaded from: classes2.dex */
public class zzhr extends zza.AbstractBinderC0018zza {
    private final String zzJN;
    private final int zzKt;

    public zzhr(String str, int i) {
        this.zzJN = str;
        this.zzKt = i;
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zza
    public int getAmount() {
        return this.zzKt;
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zza
    public String getType() {
        return this.zzJN;
    }
}
