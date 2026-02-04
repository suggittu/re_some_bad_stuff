package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzhb;

@zzhb
/* loaded from: classes2.dex */
public final class GInAppPurchaseManagerInfoParcel implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public final int versionCode;
    public final zzgc zzFw;
    public final Context zzFx;
    public final zzj zzFy;
    public final zzk zzrI;

    GInAppPurchaseManagerInfoParcel(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.versionCode = i;
        this.zzrI = (zzk) com.google.android.gms.dynamic.zze.zzp(zzd.zza.zzbs(iBinder));
        this.zzFw = (zzgc) com.google.android.gms.dynamic.zze.zzp(zzd.zza.zzbs(iBinder2));
        this.zzFx = (Context) com.google.android.gms.dynamic.zze.zzp(zzd.zza.zzbs(iBinder3));
        this.zzFy = (zzj) com.google.android.gms.dynamic.zze.zzp(zzd.zza.zzbs(iBinder4));
    }

    public GInAppPurchaseManagerInfoParcel(Context context, zzk zzkVar, zzgc zzgcVar, zzj zzjVar) {
        this.versionCode = 2;
        this.zzFx = context;
        this.zzrI = zzkVar;
        this.zzFw = zzgcVar;
        this.zzFy = zzjVar;
    }

    public static void zza(Intent intent, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", gInAppPurchaseManagerInfoParcel);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    public static GInAppPurchaseManagerInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
            return (GInAppPurchaseManagerInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
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
        zza.zza(this, parcel, i);
    }

    final IBinder zzfS() {
        return com.google.android.gms.dynamic.zze.zzC(this.zzFy).asBinder();
    }

    final IBinder zzfT() {
        return com.google.android.gms.dynamic.zze.zzC(this.zzrI).asBinder();
    }

    final IBinder zzfU() {
        return com.google.android.gms.dynamic.zze.zzC(this.zzFw).asBinder();
    }

    final IBinder zzfV() {
        return com.google.android.gms.dynamic.zze.zzC(this.zzFx).asBinder();
    }
}
