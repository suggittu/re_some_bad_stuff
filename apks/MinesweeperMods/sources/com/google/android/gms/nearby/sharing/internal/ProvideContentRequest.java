package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zzb;
import com.google.android.gms.nearby.sharing.internal.zzc;
import java.util.List;

/* loaded from: classes2.dex */
public final class ProvideContentRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzf();
    final int versionCode;
    public IBinder zzbdk;
    public zzb zzbdl;

    @Deprecated
    public List zzbdm;
    public long zzbdn;
    public zzc zzbdo;

    ProvideContentRequest() {
        this.versionCode = 1;
    }

    ProvideContentRequest(int i, IBinder iBinder, IBinder iBinder2, List list, long j, IBinder iBinder3) {
        this.versionCode = i;
        this.zzbdk = iBinder;
        this.zzbdl = zzb.zza.zzdG(iBinder2);
        this.zzbdm = list;
        this.zzbdn = j;
        this.zzbdo = zzc.zza.zzdH(iBinder3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    final IBinder zzED() {
        return this.zzbdo.asBinder();
    }

    final IBinder zzEP() {
        if (this.zzbdl == null) {
            return null;
        }
        return this.zzbdl.asBinder();
    }
}
