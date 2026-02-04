package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class UntrashResourceRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzbz();
    final int mVersionCode;
    final DriveId zzaqj;

    UntrashResourceRequest(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaqj = driveId;
    }

    public UntrashResourceRequest(DriveId driveId) {
        this(1, driveId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbz.zza(this, parcel, i);
    }
}
