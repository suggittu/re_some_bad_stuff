package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public class StorageInfoResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzbl();
    public final int statusCode;
    public final int versionCode;
    public final long zzbta;
    public final List zzbtc;

    StorageInfoResponse(int i, int i2, long j, List list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzbta = j;
        this.zzbtc = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbl.zza(this, parcel, i);
    }
}
