package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzh();
    final int mVersionCode;
    final String zzaoV;
    final boolean zzaoW;
    final boolean zzapa;
    final DriveId zzaqj;
    final MetadataBundle zzaqk;
    final Contents zzaql;
    final int zzaqm;
    final int zzaqn;
    final boolean zzaqo;

    CloseContentsAndUpdateMetadataRequest(int i, DriveId driveId, MetadataBundle metadataBundle, Contents contents, boolean z, String str, int i2, int i3, boolean z2, boolean z3) {
        this.mVersionCode = i;
        this.zzaqj = driveId;
        this.zzaqk = metadataBundle;
        this.zzaql = contents;
        this.zzaoW = z;
        this.zzaoV = str;
        this.zzaqm = i2;
        this.zzaqn = i3;
        this.zzaqo = z2;
        this.zzapa = z3;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId driveId, MetadataBundle metadataBundle, int i, boolean z, com.google.android.gms.drive.zzi zziVar) {
        this(1, driveId, metadataBundle, null, zziVar.zzsC(), zziVar.zzsB(), zziVar.zzsD(), i, z, zziVar.zzsI());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
