package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzin;

@KeepName
/* loaded from: classes2.dex */
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    CustomEventBanner zzOq;
    CustomEventInterstitial zzOr;
    CustomEventNative zzOs;
    private View zzbk;

    final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzOt;
        private final MediationBannerListener zzbc;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzOt = customEventAdapter;
            this.zzbc = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzin.zzaI("Custom event adapter called onAdClicked.");
            this.zzbc.onAdClicked(this.zzOt);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzin.zzaI("Custom event adapter called onAdClosed.");
            this.zzbc.onAdClosed(this.zzOt);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzin.zzaI("Custom event adapter called onAdFailedToLoad.");
            this.zzbc.onAdFailedToLoad(this.zzOt, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzin.zzaI("Custom event adapter called onAdLeftApplication.");
            this.zzbc.onAdLeftApplication(this.zzOt);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener
        public final void onAdLoaded(View view) {
            zzin.zzaI("Custom event adapter called onAdLoaded.");
            this.zzOt.zzbk = view;
            this.zzbc.onAdLoaded(this.zzOt);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzin.zzaI("Custom event adapter called onAdOpened.");
            this.zzbc.onAdOpened(this.zzOt);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzOt;
        private final MediationInterstitialListener zzbd;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzOt = customEventAdapter;
            this.zzbd = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdClicked() {
            zzin.zzaI("Custom event adapter called onAdClicked.");
            this.zzbd.onAdClicked(this.zzOt);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdClosed() {
            zzin.zzaI("Custom event adapter called onAdClosed.");
            this.zzbd.onAdClosed(this.zzOt);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdFailedToLoad(int i) {
            zzin.zzaI("Custom event adapter called onFailedToReceiveAd.");
            this.zzbd.onAdFailedToLoad(this.zzOt, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdLeftApplication() {
            zzin.zzaI("Custom event adapter called onAdLeftApplication.");
            this.zzbd.onAdLeftApplication(this.zzOt);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener
        public void onAdLoaded() {
            zzin.zzaI("Custom event adapter called onReceivedAd.");
            this.zzbd.onAdLoaded(CustomEventAdapter.this);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdOpened() {
            zzin.zzaI("Custom event adapter called onAdOpened.");
            this.zzbd.onAdOpened(this.zzOt);
        }
    }

    class zzc implements CustomEventNativeListener {
        private final CustomEventAdapter zzOt;
        private final MediationNativeListener zzbe;

        public zzc(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.zzOt = customEventAdapter;
            this.zzbe = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdClicked() {
            zzin.zzaI("Custom event adapter called onAdClicked.");
            this.zzbe.onAdClicked(this.zzOt);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdClosed() {
            zzin.zzaI("Custom event adapter called onAdClosed.");
            this.zzbe.onAdClosed(this.zzOt);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdFailedToLoad(int i) {
            zzin.zzaI("Custom event adapter called onAdFailedToLoad.");
            this.zzbe.onAdFailedToLoad(this.zzOt, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdLeftApplication() {
            zzin.zzaI("Custom event adapter called onAdLeftApplication.");
            this.zzbe.onAdLeftApplication(this.zzOt);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public void onAdLoaded(NativeAdMapper nativeAdMapper) {
            zzin.zzaI("Custom event adapter called onAdLoaded.");
            this.zzbe.onAdLoaded(this.zzOt, nativeAdMapper);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdOpened() {
            zzin.zzaI("Custom event adapter called onAdOpened.");
            this.zzbe.onAdOpened(this.zzOt);
        }
    }

    private void zza(View view) {
        this.zzbk = view;
    }

    private static Object zzj(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            zzin.zzaK("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.zzbk;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        if (this.zzOq != null) {
            this.zzOq.onDestroy();
        }
        if (this.zzOr != null) {
            this.zzOr.onDestroy();
        }
        if (this.zzOs != null) {
            this.zzOs.onDestroy();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        if (this.zzOq != null) {
            this.zzOq.onPause();
        }
        if (this.zzOr != null) {
            this.zzOr.onPause();
        }
        if (this.zzOs != null) {
            this.zzOs.onPause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        if (this.zzOq != null) {
            this.zzOq.onResume();
        }
        if (this.zzOr != null) {
            this.zzOr.onResume();
        }
        if (this.zzOs != null) {
            this.zzOs.onResume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzOq = (CustomEventBanner) zzj(bundle.getString("class_name"));
        if (this.zzOq == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzOq.requestBannerAd(context, new zza(this, mediationBannerListener), bundle.getString("parameter"), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzOr = (CustomEventInterstitial) zzj(bundle.getString("class_name"));
        if (this.zzOr == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzOr.requestInterstitialAd(context, zza(mediationInterstitialListener), bundle.getString("parameter"), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.zzOs = (CustomEventNative) zzj(bundle.getString("class_name"));
        if (this.zzOs == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzOs.requestNativeAd(context, new zzc(this, mediationNativeListener), bundle.getString("parameter"), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.zzOr.showInterstitial();
    }

    final zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, mediationInterstitialListener);
    }
}
