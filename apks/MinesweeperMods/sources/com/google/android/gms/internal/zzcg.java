package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.internal.zzcf;

@zzhb
/* loaded from: classes2.dex */
public final class zzcg extends zzcf.zza {
    private final OnCustomRenderedAdLoadedListener zzuQ;

    public zzcg(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzuQ = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzcf
    public final void zza(zzce zzceVar) {
        this.zzuQ.onCustomRenderedAdLoaded(new zzcd(zzceVar));
    }
}
