package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzgf;

@zzhb
/* loaded from: classes2.dex */
public final class zzgj extends com.google.android.gms.dynamic.zzg {
    private static final zzgj zzGa = new zzgj();

    final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    private zzgj() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    @Nullable
    public static zzge createInAppPurchaseManager(Activity activity) {
        zzge zzgeVarZzd;
        try {
            if (!zzb(activity) && (zzgeVarZzd = zzGa.zzd(activity)) != null) {
                return zzgeVarZzd;
            }
            zzin.zzaI("Using AdOverlay from the client jar.");
            return com.google.android.gms.ads.internal.client.zzn.zzcU().createInAppPurchaseManager(activity);
        } catch (zza e) {
            zzin.zzaK(e.getMessage());
            return null;
        }
    }

    private static boolean zzb(Activity activity) throws zza {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new zza("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    private zzge zzd(Activity activity) {
        try {
            return zzge.zza.zzQ(((zzgf) zzaB(activity)).zzf(com.google.android.gms.dynamic.zze.zzC(activity)));
        } catch (RemoteException e) {
            zzin.zzd("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (zzg.zza e2) {
            zzin.zzd("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* renamed from: zzU, reason: merged with bridge method [inline-methods] */
    public final zzgf zzd(IBinder iBinder) {
        return zzgf.zza.zzR(iBinder);
    }
}
