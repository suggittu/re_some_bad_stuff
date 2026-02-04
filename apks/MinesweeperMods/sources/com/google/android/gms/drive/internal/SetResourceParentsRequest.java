package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

/* loaded from: classes2.dex */
public class SetResourceParentsRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzbt();
    final int mVersionCode;
    final DriveId zzaqf;
    final List zzasC;

    SetResourceParentsRequest(int i, DriveId driveId, List list) {
        this.mVersionCode = i;
        this.zzaqf = driveId;
        this.zzasC = list;
    }

    public SetResourceParentsRequest(DriveId driveId, List list) {
        this(1, driveId, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbt.zza(this, parcel, i);
    }
}
