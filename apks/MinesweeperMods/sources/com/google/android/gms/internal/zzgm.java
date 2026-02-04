package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzgh;

@zzhb
/* loaded from: classes2.dex */
public final class zzgm extends zzgh.zza {
    private final PlayStorePurchaseListener zzuP;

    public zzgm(PlayStorePurchaseListener playStorePurchaseListener) {
        this.zzuP = playStorePurchaseListener;
    }

    @Override // com.google.android.gms.internal.zzgh
    public final boolean isValidPurchase(String str) {
        return this.zzuP.isValidPurchase(str);
    }

    @Override // com.google.android.gms.internal.zzgh
    public final void zza(zzgg zzggVar) {
        this.zzuP.onInAppPurchaseFinished(new zzgk(zzggVar));
    }
}
