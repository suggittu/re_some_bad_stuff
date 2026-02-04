package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class GetPermissionsRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzak();
    final int mVersionCode;
    final DriveId zzaoz;

    GetPermissionsRequest(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaoz = driveId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzak.zza(this, parcel, i);
    }
}
