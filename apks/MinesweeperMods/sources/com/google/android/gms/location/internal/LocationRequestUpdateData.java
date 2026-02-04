package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.internal.zzg;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzd;

/* loaded from: classes2.dex */
public class LocationRequestUpdateData implements SafeParcelable {
    public static final zzn CREATOR = new zzn();
    PendingIntent mPendingIntent;
    private final int mVersionCode;
    int zzaOU;
    LocationRequestInternal zzaOV;
    com.google.android.gms.location.zzd zzaOW;
    com.google.android.gms.location.zzc zzaOX;
    zzg zzaOY;

    LocationRequestUpdateData(int i, int i2, LocationRequestInternal locationRequestInternal, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.mVersionCode = i;
        this.zzaOU = i2;
        this.zzaOV = locationRequestInternal;
        this.zzaOW = iBinder == null ? null : zzd.zza.zzcf(iBinder);
        this.mPendingIntent = pendingIntent;
        this.zzaOX = iBinder2 == null ? null : zzc.zza.zzce(iBinder2);
        this.zzaOY = iBinder3 != null ? zzg.zza.zzch(iBinder3) : null;
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent, @Nullable zzg zzgVar) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, pendingIntent, null, zzgVar != null ? zzgVar.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, com.google.android.gms.location.zzc zzcVar, @Nullable zzg zzgVar) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, null, zzcVar.asBinder(), zzgVar != null ? zzgVar.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, com.google.android.gms.location.zzd zzdVar, @Nullable zzg zzgVar) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, zzdVar.asBinder(), null, null, zzgVar != null ? zzgVar.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(com.google.android.gms.location.zzc zzcVar, @Nullable zzg zzgVar) {
        return new LocationRequestUpdateData(1, 2, null, null, null, zzcVar.asBinder(), zzgVar != null ? zzgVar.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(com.google.android.gms.location.zzd zzdVar, @Nullable zzg zzgVar) {
        return new LocationRequestUpdateData(1, 2, null, zzdVar.asBinder(), null, null, zzgVar != null ? zzgVar.asBinder() : null);
    }

    public static LocationRequestUpdateData zzb(PendingIntent pendingIntent, @Nullable zzg zzgVar) {
        return new LocationRequestUpdateData(1, 2, null, null, pendingIntent, null, zzgVar != null ? zzgVar.asBinder() : null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }

    IBinder zzyQ() {
        if (this.zzaOW == null) {
            return null;
        }
        return this.zzaOW.asBinder();
    }

    IBinder zzyR() {
        if (this.zzaOX == null) {
            return null;
        }
        return this.zzaOX.asBinder();
    }

    IBinder zzyS() {
        if (this.zzaOY == null) {
            return null;
        }
        return this.zzaOY.asBinder();
    }
}
