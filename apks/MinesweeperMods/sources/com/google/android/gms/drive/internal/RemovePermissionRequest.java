package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public class RemovePermissionRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzbq();
    final int mVersionCode;
    final String zzaoV;
    final DriveId zzaoz;
    final String zzapk;
    final boolean zzaqd;

    RemovePermissionRequest(int i, DriveId driveId, String str, boolean z, String str2) {
        this.mVersionCode = i;
        this.zzaoz = driveId;
        this.zzapk = str;
        this.zzaqd = z;
        this.zzaoV = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbq.zza(this, parcel, i);
    }
}
