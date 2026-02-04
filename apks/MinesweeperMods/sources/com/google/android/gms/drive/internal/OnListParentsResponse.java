package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

/* loaded from: classes2.dex */
public class OnListParentsResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzbd();
    final int mVersionCode;
    final DataHolder zzast;

    OnListParentsResponse(int i, DataHolder dataHolder) {
        this.mVersionCode = i;
        this.zzast = dataHolder;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.drive.WriteAwareParcelable
    protected void zzJ(Parcel parcel, int i) {
        zzbd.zza(this, parcel, i);
    }

    public DataHolder zztv() {
        return this.zzast;
    }
}
