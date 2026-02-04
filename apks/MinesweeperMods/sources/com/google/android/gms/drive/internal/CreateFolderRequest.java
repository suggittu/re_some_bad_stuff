package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class CreateFolderRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzo();
    final int mVersionCode;
    final MetadataBundle zzaqw;
    final DriveId zzaqy;

    CreateFolderRequest(int i, DriveId driveId, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzaqy = (DriveId) com.google.android.gms.common.internal.zzx.zzz(driveId);
        this.zzaqw = (MetadataBundle) com.google.android.gms.common.internal.zzx.zzz(metadataBundle);
    }

    public CreateFolderRequest(DriveId driveId, MetadataBundle metadataBundle) {
        this(1, driveId, metadataBundle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
