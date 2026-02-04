package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class UnsubscribeResourceRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzby();
    final int mVersionCode;
    final DriveId zzaqj;

    UnsubscribeResourceRequest(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaqj = driveId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzby.zza(this, parcel, i);
    }
}
