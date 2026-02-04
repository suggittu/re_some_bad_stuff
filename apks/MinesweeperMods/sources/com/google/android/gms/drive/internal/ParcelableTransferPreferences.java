package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class ParcelableTransferPreferences implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzbn();
    final int mVersionCode;
    final int zzarG;
    final int zzarH;
    final boolean zzasA;

    ParcelableTransferPreferences(int i, int i2, int i3, boolean z) {
        this.mVersionCode = i;
        this.zzarG = i2;
        this.zzarH = i3;
        this.zzasA = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbn.zza(this, parcel, i);
    }
}
