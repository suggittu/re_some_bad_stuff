package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.internal.zzcu;

@zzhb
/* loaded from: classes2.dex */
public class zzcz extends zzcu.zza {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzyV;

    public zzcz(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzyV = onCustomTemplateAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzcu
    public void zza(zzcp zzcpVar) {
        this.zzyV.onCustomTemplateAdLoaded(new zzcq(zzcpVar));
    }
}
