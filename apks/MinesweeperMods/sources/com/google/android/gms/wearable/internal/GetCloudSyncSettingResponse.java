package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class GetCloudSyncSettingResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzan();
    public final boolean enabled;
    public final int statusCode;
    public final int versionCode;

    GetCloudSyncSettingResponse(int i, int i2, boolean z) {
        this.versionCode = i;
        this.statusCode = i2;
        this.enabled = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzan.zza(this, parcel, i);
    }
}
