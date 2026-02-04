package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class GetCloudSyncOptInOutDoneResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzal();
    public final int statusCode;
    public final int versionCode;
    public final boolean zzbsD;

    GetCloudSyncOptInOutDoneResponse(int i, int i2, boolean z) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzbsD = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzal.zza(this, parcel, i);
    }
}
