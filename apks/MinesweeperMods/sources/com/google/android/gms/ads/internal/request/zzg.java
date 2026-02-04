package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.internal.zzhb;
import java.lang.ref.WeakReference;

@zzhb
/* loaded from: classes2.dex */
public final class zzg extends zzk.zza {
    private final WeakReference zzHR;

    public zzg(zzc.zza zzaVar) {
        this.zzHR = new WeakReference(zzaVar);
    }

    @Override // com.google.android.gms.ads.internal.request.zzk
    public final void zzb(AdResponseParcel adResponseParcel) {
        zzc.zza zzaVar = (zzc.zza) this.zzHR.get();
        if (zzaVar != null) {
            zzaVar.zzb(adResponseParcel);
        }
    }
}
