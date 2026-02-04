package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzb;

/* loaded from: classes2.dex */
public class zzal extends zzb.zza {
    private com.google.android.gms.ads.internal.reward.client.zzd zzvb;

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void destroy() {
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public boolean isLoaded() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void pause() {
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void resume() {
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void setUserId(String str) {
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void show() {
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        com.google.android.gms.ads.internal.util.client.zzb.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzal.1
            @Override // java.lang.Runnable
            public void run() {
                if (zzal.this.zzvb != null) {
                    try {
                        zzal.this.zzvb.onRewardedVideoAdFailedToLoad(1);
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e);
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zzb
    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzdVar) {
        this.zzvb = zzdVar;
    }
}
