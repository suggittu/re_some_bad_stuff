package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public class GetPermissionsResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzal();
    final int mVersionCode;
    final List zzarO;
    final int zzzw;

    GetPermissionsResponse(int i, List list, int i2) {
        this.mVersionCode = i;
        this.zzarO = list;
        this.zzzw = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzal.zza(this, parcel, i);
    }
}
