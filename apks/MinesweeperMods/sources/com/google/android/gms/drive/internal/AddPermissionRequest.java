package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

/* loaded from: classes2.dex */
public class AddPermissionRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    final int mVersionCode;
    final String zzaoV;
    final DriveId zzaoz;
    final Permission zzaqa;
    final boolean zzaqb;
    final String zzaqc;
    final boolean zzaqd;

    AddPermissionRequest(int i, DriveId driveId, Permission permission, boolean z, String str, boolean z2, String str2) {
        this.mVersionCode = i;
        this.zzaoz = driveId;
        this.zzaqa = permission;
        this.zzaqb = z;
        this.zzaqc = str;
        this.zzaqd = z2;
        this.zzaoV = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
