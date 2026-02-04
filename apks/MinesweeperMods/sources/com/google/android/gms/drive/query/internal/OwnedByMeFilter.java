package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

/* loaded from: classes2.dex */
public class OwnedByMeFilter extends AbstractFilter {
    public static final zzo CREATOR = new zzo();
    final int mVersionCode;

    public OwnedByMeFilter() {
        this(1);
    }

    OwnedByMeFilter(int i) {
        this.mVersionCode = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public Object zza(zzf zzfVar) {
        return zzfVar.zztP();
    }
}
