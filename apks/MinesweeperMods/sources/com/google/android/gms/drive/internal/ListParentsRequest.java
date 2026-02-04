package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class ListParentsRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzaq();
    final int mVersionCode;
    final DriveId zzarP;

    ListParentsRequest(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzarP = driveId;
    }

    public ListParentsRequest(DriveId driveId) {
        this(1, driveId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaq.zza(this, parcel, i);
    }
}
