package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class PartialDriveId implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzn();
    final int mVersionCode;
    final String zzaoL;
    final long zzaoM;
    final int zzaoN;

    PartialDriveId(int i, String str, long j, int i2) {
        this.mVersionCode = i;
        this.zzaoL = str;
        this.zzaoM = j;
        this.zzaoN = i2;
    }

    public PartialDriveId(String str, long j, int i) {
        this(1, str, j, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }

    public DriveId zzE(long j) {
        return new DriveId(this.zzaoL, this.zzaoM, j, this.zzaoN);
    }
}
