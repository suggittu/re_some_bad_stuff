package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class CreateFileRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzn();
    final int mVersionCode;
    final String zzaoV;
    final String zzaoY;
    final int zzaqA;
    final boolean zzaqd;
    final Contents zzaql;
    final MetadataBundle zzaqw;
    final Integer zzaqx;
    final DriveId zzaqy;
    final int zzaqz;

    CreateFileRequest(int i, DriveId driveId, MetadataBundle metadataBundle, Contents contents, Integer num, boolean z, String str, int i2, int i3, String str2) {
        if (contents != null && i3 != 0) {
            com.google.android.gms.common.internal.zzx.zzb(contents.getRequestId() == i3, "inconsistent contents reference");
        }
        if ((num == null || num.intValue() == 0) && contents == null && i3 == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.mVersionCode = i;
        this.zzaqy = (DriveId) com.google.android.gms.common.internal.zzx.zzz(driveId);
        this.zzaqw = (MetadataBundle) com.google.android.gms.common.internal.zzx.zzz(metadataBundle);
        this.zzaql = contents;
        this.zzaqx = num;
        this.zzaoV = str;
        this.zzaqz = i2;
        this.zzaqd = z;
        this.zzaqA = i3;
        this.zzaoY = str2;
    }

    public CreateFileRequest(DriveId driveId, MetadataBundle metadataBundle, int i, int i2, com.google.android.gms.drive.zzh zzhVar) {
        this(2, driveId, metadataBundle, null, Integer.valueOf(i2), zzhVar.zzsC(), zzhVar.zzsB(), zzhVar.zzsD(), i, zzhVar.zzsF());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }
}
