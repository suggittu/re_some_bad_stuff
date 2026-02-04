package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzdh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;

@zzhb
/* loaded from: classes2.dex */
public final class AdOverlayInfoParcel implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    public final int orientation;
    public final String url;
    public final int versionCode;
    public final AdLauncherIntentInfoParcel zzEA;
    public final com.google.android.gms.ads.internal.client.zza zzEB;
    public final zzg zzEC;
    public final zzjp zzED;
    public final zzdb zzEE;
    public final String zzEF;
    public final boolean zzEG;
    public final String zzEH;
    public final zzp zzEI;
    public final int zzEJ;
    public final zzdh zzEK;
    public final String zzEL;
    public final InterstitialAdParameterParcel zzEM;
    public final VersionInfoParcel zzrl;

    AdOverlayInfoParcel(int i, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, VersionInfoParcel versionInfoParcel, IBinder iBinder6, String str4, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.versionCode = i;
        this.zzEA = adLauncherIntentInfoParcel;
        this.zzEB = (com.google.android.gms.ads.internal.client.zza) com.google.android.gms.dynamic.zze.zzp(zzd.zza.zzbs(iBinder));
        this.zzEC = (zzg) com.google.android.gms.dynamic.zze.zzp(zzd.zza.zzbs(iBinder2));
        this.zzED = (zzjp) com.google.android.gms.dynamic.zze.zzp(zzd.zza.zzbs(iBinder3));
        this.zzEE = (zzdb) com.google.android.gms.dynamic.zze.zzp(zzd.zza.zzbs(iBinder4));
        this.zzEF = str;
        this.zzEG = z;
        this.zzEH = str2;
        this.zzEI = (zzp) com.google.android.gms.dynamic.zze.zzp(zzd.zza.zzbs(iBinder5));
        this.orientation = i2;
        this.zzEJ = i3;
        this.url = str3;
        this.zzrl = versionInfoParcel;
        this.zzEK = (zzdh) com.google.android.gms.dynamic.zze.zzp(zzd.zza.zzbs(iBinder6));
        this.zzEL = str4;
        this.zzEM = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzg zzgVar, zzp zzpVar, zzjp zzjpVar, int i, VersionInfoParcel versionInfoParcel, String str, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.versionCode = 4;
        this.zzEA = null;
        this.zzEB = zzaVar;
        this.zzEC = zzgVar;
        this.zzED = zzjpVar;
        this.zzEE = null;
        this.zzEF = null;
        this.zzEG = false;
        this.zzEH = null;
        this.zzEI = zzpVar;
        this.orientation = i;
        this.zzEJ = 1;
        this.url = null;
        this.zzrl = versionInfoParcel;
        this.zzEK = null;
        this.zzEL = str;
        this.zzEM = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzg zzgVar, zzp zzpVar, zzjp zzjpVar, boolean z, int i, VersionInfoParcel versionInfoParcel) {
        this.versionCode = 4;
        this.zzEA = null;
        this.zzEB = zzaVar;
        this.zzEC = zzgVar;
        this.zzED = zzjpVar;
        this.zzEE = null;
        this.zzEF = null;
        this.zzEG = z;
        this.zzEH = null;
        this.zzEI = zzpVar;
        this.orientation = i;
        this.zzEJ = 2;
        this.url = null;
        this.zzrl = versionInfoParcel;
        this.zzEK = null;
        this.zzEL = null;
        this.zzEM = null;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzg zzgVar, zzdb zzdbVar, zzp zzpVar, zzjp zzjpVar, boolean z, int i, String str, VersionInfoParcel versionInfoParcel, zzdh zzdhVar) {
        this.versionCode = 4;
        this.zzEA = null;
        this.zzEB = zzaVar;
        this.zzEC = zzgVar;
        this.zzED = zzjpVar;
        this.zzEE = zzdbVar;
        this.zzEF = null;
        this.zzEG = z;
        this.zzEH = null;
        this.zzEI = zzpVar;
        this.orientation = i;
        this.zzEJ = 3;
        this.url = str;
        this.zzrl = versionInfoParcel;
        this.zzEK = zzdhVar;
        this.zzEL = null;
        this.zzEM = null;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzg zzgVar, zzdb zzdbVar, zzp zzpVar, zzjp zzjpVar, boolean z, int i, String str, String str2, VersionInfoParcel versionInfoParcel, zzdh zzdhVar) {
        this.versionCode = 4;
        this.zzEA = null;
        this.zzEB = zzaVar;
        this.zzEC = zzgVar;
        this.zzED = zzjpVar;
        this.zzEE = zzdbVar;
        this.zzEF = str2;
        this.zzEG = z;
        this.zzEH = str;
        this.zzEI = zzpVar;
        this.orientation = i;
        this.zzEJ = 3;
        this.url = null;
        this.zzrl = versionInfoParcel;
        this.zzEK = zzdhVar;
        this.zzEL = null;
        this.zzEM = null;
    }

    public AdOverlayInfoParcel(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, com.google.android.gms.ads.internal.client.zza zzaVar, zzg zzgVar, zzp zzpVar, VersionInfoParcel versionInfoParcel) {
        this.versionCode = 4;
        this.zzEA = adLauncherIntentInfoParcel;
        this.zzEB = zzaVar;
        this.zzEC = zzgVar;
        this.zzED = null;
        this.zzEE = null;
        this.zzEF = null;
        this.zzEG = false;
        this.zzEH = null;
        this.zzEI = zzpVar;
        this.orientation = -1;
        this.zzEJ = 4;
        this.url = null;
        this.zzrl = versionInfoParcel;
        this.zzEK = null;
        this.zzEL = null;
        this.zzEM = null;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzb(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    final IBinder zzfs() {
        return com.google.android.gms.dynamic.zze.zzC(this.zzEB).asBinder();
    }

    final IBinder zzft() {
        return com.google.android.gms.dynamic.zze.zzC(this.zzEC).asBinder();
    }

    final IBinder zzfu() {
        return com.google.android.gms.dynamic.zze.zzC(this.zzED).asBinder();
    }

    final IBinder zzfv() {
        return com.google.android.gms.dynamic.zze.zzC(this.zzEE).asBinder();
    }

    final IBinder zzfw() {
        return com.google.android.gms.dynamic.zze.zzC(this.zzEK).asBinder();
    }

    final IBinder zzfx() {
        return com.google.android.gms.dynamic.zze.zzC(this.zzEI).asBinder();
    }
}
