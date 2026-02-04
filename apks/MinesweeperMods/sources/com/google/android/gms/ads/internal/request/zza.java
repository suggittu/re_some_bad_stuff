package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzim;

@zzhb
/* loaded from: classes2.dex */
public class zza {

    /* renamed from: com.google.android.gms.ads.internal.request.zza$zza, reason: collision with other inner class name */
    public interface InterfaceC0014zza {
        void zza(zzif.zza zzaVar);
    }

    public zzim zza(Context context, AdRequestInfoParcel.zza zzaVar, zzan zzanVar, InterfaceC0014zza interfaceC0014zza) {
        zzim zzmVar = zzaVar.zzHt.extras.getBundle("sdk_less_server_data") != null ? new zzm(context, zzaVar, interfaceC0014zza) : new zzb(context, zzaVar, zzanVar, interfaceC0014zza);
        zzmVar.zzgd();
        return zzmVar;
    }
}
