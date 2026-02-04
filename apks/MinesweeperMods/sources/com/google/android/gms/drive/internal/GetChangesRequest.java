package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class GetChangesRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzah();
    final int mVersionCode;
    final List zzapB;
    private final Set zzapC;
    final ChangeSequenceNumber zzarJ;
    final int zzarK;
    final boolean zzarL;

    private GetChangesRequest(int i, ChangeSequenceNumber changeSequenceNumber, int i2, List list, Set set, boolean z) {
        this.mVersionCode = i;
        this.zzarJ = changeSequenceNumber;
        this.zzarK = i2;
        this.zzapB = list;
        this.zzapC = set;
        this.zzarL = z;
    }

    GetChangesRequest(int i, ChangeSequenceNumber changeSequenceNumber, int i2, List list, boolean z) {
        this(i, changeSequenceNumber, i2, list, list == null ? null : new HashSet(list), z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzah.zza(this, parcel, i);
    }
}
