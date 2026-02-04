package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzhb;

@zzhb
/* loaded from: classes2.dex */
public class zzaf extends com.google.android.gms.dynamic.zzg {
    public zzaf() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    private zzy zzv(Context context) {
        try {
            return zzy.zza.zzo(((zzz) zzaB(context)).zza(com.google.android.gms.dynamic.zze.zzC(context), 8487000));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get remote MobileAdsSettingManager.", e);
            return null;
        } catch (zzg.zza e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public zzz zzd(IBinder iBinder) {
        return zzz.zza.zzp(iBinder);
    }

    public zzy zzu(Context context) {
        zzy zzyVarZzv;
        if (zzn.zzcS().zzU(context) && (zzyVarZzv = zzv(context)) != null) {
            return zzyVarZzv;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Using MobileAdsSettingManager from the client jar.");
        new VersionInfoParcel(8487000, 8487000, true);
        return zzn.zzcU().getMobileAdsSettingsManager(context);
    }
}
