package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.internal.zzhb;

@zzhb
/* loaded from: classes2.dex */
public final class zzc extends zzq.zza {
    private final AdListener zztA;

    public zzc(AdListener adListener) {
        this.zztA = adListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public final void onAdClosed() {
        this.zztA.onAdClosed();
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public final void onAdFailedToLoad(int i) {
        this.zztA.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public final void onAdLeftApplication() {
        this.zztA.onAdLeftApplication();
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public final void onAdLoaded() {
        this.zztA.onAdLoaded();
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public final void onAdOpened() {
        this.zztA.onAdOpened();
    }
}
