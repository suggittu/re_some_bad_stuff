package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;

@zzhb
/* loaded from: classes2.dex */
public class zzn extends zzj {
    @Override // com.google.android.gms.ads.internal.overlay.zzj
    @Nullable
    public zzi zza(Context context, zzjp zzjpVar, int i, zzcb zzcbVar, zzbz zzbzVar) {
        if (zzx(context)) {
            return new zzc(context, new zzt(context, zzjpVar.zzhX(), zzjpVar.getRequestId(), zzcbVar, zzbzVar));
        }
        return null;
    }
}
