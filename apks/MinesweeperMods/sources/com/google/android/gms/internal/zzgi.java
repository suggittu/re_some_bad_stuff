package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.zzgd;

@zzhb
/* loaded from: classes2.dex */
public final class zzgi extends zzgd.zza {
    private final InAppPurchaseListener zzuO;

    public zzgi(InAppPurchaseListener inAppPurchaseListener) {
        this.zzuO = inAppPurchaseListener;
    }

    @Override // com.google.android.gms.internal.zzgd
    public final void zza(zzgc zzgcVar) {
        this.zzuO.onInAppPurchaseRequested(new zzgl(zzgcVar));
    }
}
