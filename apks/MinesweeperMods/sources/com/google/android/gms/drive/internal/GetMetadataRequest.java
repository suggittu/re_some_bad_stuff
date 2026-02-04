package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class GetMetadataRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzaj();
    final int mVersionCode;
    final DriveId zzaqj;
    final boolean zzarN;

    GetMetadataRequest(int i, DriveId driveId, boolean z) {
        this.mVersionCode = i;
        this.zzaqj = driveId;
        this.zzarN = z;
    }

    public GetMetadataRequest(DriveId driveId, boolean z) {
        this(1, driveId, z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaj.zza(this, parcel, i);
    }
}
