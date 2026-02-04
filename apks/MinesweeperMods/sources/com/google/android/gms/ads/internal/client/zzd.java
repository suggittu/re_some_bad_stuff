package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzt;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzhb;

@zzhb
/* loaded from: classes2.dex */
public final class zzd extends com.google.android.gms.dynamic.zzg {
    private static final zzd zztB = new zzd();

    private zzd() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public static zzs zza(Context context, String str, zzew zzewVar) {
        zzs zzsVarZzb;
        if (zzn.zzcS().zzU(context) && (zzsVarZzb = zztB.zzb(context, str, zzewVar)) != null) {
            return zzsVarZzb;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Using AdLoader from the client jar.");
        return zzn.zzcU().createAdLoaderBuilder(context, str, zzewVar, new VersionInfoParcel(8487000, 8487000, true));
    }

    private zzs zzb(Context context, String str, zzew zzewVar) {
        try {
            return zzs.zza.zzi(((zzt) zzaB(context)).zza(com.google.android.gms.dynamic.zze.zzC(context), str, zzewVar, 8487000));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (zzg.zza e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzt zzd(IBinder iBinder) {
        return zzt.zza.zzj(iBinder);
    }
}
