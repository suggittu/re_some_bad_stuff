package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.internal.zzey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzhb
/* loaded from: classes2.dex */
public final class zzfj extends zzey.zza {
    private final MediationAdapter zzCO;
    private final NetworkExtras zzCP;

    public zzfj(MediationAdapter mediationAdapter, NetworkExtras networkExtras) {
        this.zzCO = mediationAdapter;
        this.zzCP = networkExtras;
    }

    private MediationServerParameters zzb(String str, int i, String str2) throws RemoteException {
        HashMap map;
        try {
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                map = new HashMap(jSONObject.length());
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
            } else {
                map = new HashMap(0);
            }
            Class serverParametersType = this.zzCO.getServerParametersType();
            if (serverParametersType == null) {
                return null;
            }
            MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
            mediationServerParameters.load(map);
            return mediationServerParameters;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get MediationServerParameters.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public final void destroy() throws RemoteException {
        try {
            this.zzCO.destroy();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzey
    public final com.google.android.gms.dynamic.zzd getView() throws RemoteException {
        if (!(this.zzCO instanceof MediationBannerAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationBannerAdapter: " + this.zzCO.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            return com.google.android.gms.dynamic.zze.zzC(this.zzCO.getBannerView());
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.android.gms.internal.zzey
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzey
    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzey
    public final void showInterstitial() throws RemoteException {
        if (!(this.zzCO instanceof MediationInterstitialAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzCO.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Showing interstitial from adapter.");
        try {
            this.zzCO.showInterstitial();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public final void showVideo() {
    }

    @Override // com.google.android.gms.internal.zzey
    public final void zza(AdRequestParcel adRequestParcel, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.zzey
    public final void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zzaVar, String str2) {
    }

    @Override // com.google.android.gms.internal.zzey
    public final void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, zzez zzezVar) throws RemoteException {
        zza(zzdVar, adRequestParcel, str, (String) null, zzezVar);
    }

    @Override // com.google.android.gms.internal.zzey
    public final void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzez zzezVar) throws RemoteException {
        if (!(this.zzCO instanceof MediationInterstitialAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzCO.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Requesting interstitial ad from adapter.");
        try {
            this.zzCO.requestInterstitialAd(new zzfk(zzezVar), (Activity) com.google.android.gms.dynamic.zze.zzp(zzdVar), zzb(str, adRequestParcel.zztG, str2), zzfl.zzj(adRequestParcel), this.zzCP);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public final void zza(com.google.android.gms.dynamic.zzd zzdVar, AdRequestParcel adRequestParcel, String str, String str2, zzez zzezVar, NativeAdOptionsParcel nativeAdOptionsParcel, List list) {
    }

    @Override // com.google.android.gms.internal.zzey
    public final void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzez zzezVar) throws RemoteException {
        zza(zzdVar, adSizeParcel, adRequestParcel, str, null, zzezVar);
    }

    @Override // com.google.android.gms.internal.zzey
    public final void zza(com.google.android.gms.dynamic.zzd zzdVar, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzez zzezVar) throws RemoteException {
        if (!(this.zzCO instanceof MediationBannerAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("MediationAdapter is not a MediationBannerAdapter: " + this.zzCO.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaI("Requesting banner ad from adapter.");
        try {
            this.zzCO.requestBannerAd(new zzfk(zzezVar), (Activity) com.google.android.gms.dynamic.zze.zzp(zzdVar), zzb(str, adRequestParcel.zztG, str2), zzfl.zzb(adSizeParcel), zzfl.zzj(adRequestParcel), this.zzCP);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.zzey
    public final void zzb(AdRequestParcel adRequestParcel, String str) {
    }

    @Override // com.google.android.gms.internal.zzey
    public final zzfb zzeF() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzey
    public final zzfc zzeG() {
        return null;
    }

    @Override // com.google.android.gms.internal.zzey
    public final Bundle zzeH() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.zzey
    public final Bundle zzeI() {
        return new Bundle();
    }
}
