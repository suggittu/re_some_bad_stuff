package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzhb;

@zzhb
/* loaded from: classes2.dex */
public class zze extends com.google.android.gms.dynamic.zzg {
    public zze() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    private zzu zza(Context context, AdSizeParcel adSizeParcel, String str, zzew zzewVar, int i) {
        try {
            return zzu.zza.zzk(((zzv) zzaB(context)).zza(com.google.android.gms.dynamic.zze.zzC(context), adSizeParcel, str, zzewVar, 8487000, i));
        } catch (RemoteException | zzg.zza e) {
            com.google.android.gms.ads.internal.util.client.zzb.zza("Could not create remote AdManager.", e);
            return null;
        }
    }

    public zzu zza(Context context, AdSizeParcel adSizeParcel, String str, zzew zzewVar) {
        zzu zzuVarZza;
        if (zzn.zzcS().zzU(context) && (zzuVarZza = zza(context, adSizeParcel, str, zzewVar, 1)) != null) {
            return zzuVarZza;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Using BannerAdManager from the client jar.");
        return zzn.zzcU().createBannerAdManager(context, adSizeParcel, str, zzewVar, new VersionInfoParcel(8487000, 8487000, true));
    }

    public zzu zzb(Context context, AdSizeParcel adSizeParcel, String str, zzew zzewVar) {
        zzu zzuVarZza;
        if (zzn.zzcS().zzU(context) && (zzuVarZza = zza(context, adSizeParcel, str, zzewVar, 2)) != null) {
            return zzuVarZza;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaK("Using InterstitialAdManager from the client jar.");
        return zzn.zzcU().createInterstitialAdManager(context, adSizeParcel, str, zzewVar, new VersionInfoParcel(8487000, 8487000, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public zzv zzd(IBinder iBinder) {
        return zzv.zza.zzl(iBinder);
    }
}
