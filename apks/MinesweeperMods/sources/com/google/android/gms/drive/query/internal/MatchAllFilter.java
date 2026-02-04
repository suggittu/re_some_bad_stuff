package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

/* loaded from: classes2.dex */
public class MatchAllFilter extends AbstractFilter {
    public static final zzl CREATOR = new zzl();
    final int mVersionCode;

    public MatchAllFilter() {
        this(1);
    }

    MatchAllFilter(int i) {
        this.mVersionCode = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public Object zza(zzf zzfVar) {
        return zzfVar.zztQ();
    }
}
