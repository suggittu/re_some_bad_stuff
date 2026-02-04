package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.internal.zzif;

@zzhb
/* loaded from: classes2.dex */
public class zzgr {

    public interface zza {
        void zzb(zzif zzifVar);
    }

    public zzit zza(Context context, com.google.android.gms.ads.internal.zza zzaVar, zzif.zza zzaVar2, zzan zzanVar, zzjp zzjpVar, zzex zzexVar, zza zzaVar3, zzcb zzcbVar) {
        zzit zzgpVar;
        AdResponseParcel adResponseParcel = zzaVar2.zzLe;
        if (adResponseParcel.zzHT) {
            zzgpVar = new zzgu(context, zzaVar2, zzexVar, zzaVar3, zzcbVar, zzjpVar);
        } else if (!adResponseParcel.zzuk) {
            zzgpVar = adResponseParcel.zzHZ ? new zzgp(context, zzaVar2, zzjpVar, zzaVar3) : (((Boolean) zzbt.zzwu.get()).booleanValue() && zzne.zzsk() && !zzne.isAtLeastL() && zzjpVar.zzaN().zzui) ? new zzgt(context, zzaVar2, zzjpVar, zzaVar3) : new zzgs(context, zzaVar2, zzjpVar, zzaVar3);
        } else {
            if (!(zzaVar instanceof com.google.android.gms.ads.internal.zzp)) {
                throw new IllegalArgumentException("Invalid NativeAdManager type. Found: " + (zzaVar != null ? zzaVar.getClass().getName() : "null") + "; Required: NativeAdManager.");
            }
            zzgpVar = new zzgv(context, (com.google.android.gms.ads.internal.zzp) zzaVar, new zzee(), zzaVar2, zzanVar, zzaVar3);
        }
        zzin.zzaI("AdRenderer: " + zzgpVar.getClass().getName());
        zzgpVar.zzgd();
        return zzgpVar;
    }

    public zzit zza(Context context, String str, zzif.zza zzaVar, zzht zzhtVar) {
        zzhz zzhzVar = new zzhz(context, str, zzaVar, zzhtVar);
        zzin.zzaI("AdRenderer: " + zzhzVar.getClass().getName());
        zzhzVar.zzgd();
        return zzhzVar;
    }
}
