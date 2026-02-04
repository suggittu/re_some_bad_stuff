package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes2.dex */
public abstract class zze implements zzq.zzb {
    private final DataHolder zzahi;

    public zze(DataHolder dataHolder) {
        this.zzahi = dataHolder;
    }

    protected abstract void zza(Object obj, DataHolder dataHolder);

    @Override // com.google.android.gms.common.api.internal.zzq.zzb
    public void zzpr() {
        if (this.zzahi != null) {
            this.zzahi.close();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzq.zzb
    public final void zzt(Object obj) {
        zza(obj, this.zzahi);
    }
}
