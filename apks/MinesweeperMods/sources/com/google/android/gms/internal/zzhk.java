package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzhj;
import java.util.WeakHashMap;

@zzhb
/* loaded from: classes2.dex */
public final class zzhk {
    private WeakHashMap zzKm = new WeakHashMap();

    class zza {
        public final long zzKn = com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis();
        public final zzhj zzKo;

        public zza(zzhj zzhjVar) {
            this.zzKo = zzhjVar;
        }

        public boolean hasExpired() {
            return ((Long) zzbt.zzwM.get()).longValue() + this.zzKn < com.google.android.gms.ads.internal.zzr.zzbG().currentTimeMillis();
        }
    }

    public final zzhj zzE(Context context) {
        zza zzaVar = (zza) this.zzKm.get(context);
        zzhj zzhjVarZzgI = (zzaVar == null || zzaVar.hasExpired() || !((Boolean) zzbt.zzwL.get()).booleanValue()) ? new zzhj.zza(context).zzgI() : new zzhj.zza(context, zzaVar.zzKo).zzgI();
        this.zzKm.put(context, new zza(zzhjVarZzgI));
        return zzhjVarZzgI;
    }
}
