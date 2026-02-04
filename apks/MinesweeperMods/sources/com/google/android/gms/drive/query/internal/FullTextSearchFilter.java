package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

/* loaded from: classes2.dex */
public class FullTextSearchFilter extends AbstractFilter {
    public static final zzh CREATOR = new zzh();
    final String mValue;
    final int mVersionCode;

    FullTextSearchFilter(int i, String str) {
        this.mVersionCode = i;
        this.mValue = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public Object zza(zzf zzfVar) {
        return zzfVar.zzdj(this.mValue);
    }
}
