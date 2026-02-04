package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.WriteAwareParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public class OnChangesResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzav();
    final int mVersionCode;
    final DataHolder zzasb;
    final List zzasc;
    final ChangeSequenceNumber zzasd;
    final boolean zzase;

    OnChangesResponse(int i, DataHolder dataHolder, List list, ChangeSequenceNumber changeSequenceNumber, boolean z) {
        this.mVersionCode = i;
        this.zzasb = dataHolder;
        this.zzasc = list;
        this.zzasd = changeSequenceNumber;
        this.zzase = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.drive.WriteAwareParcelable
    protected void zzJ(Parcel parcel, int i) {
        zzav.zza(this, parcel, i | 1);
    }
}
