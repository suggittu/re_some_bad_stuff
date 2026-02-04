package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.query.Filter;

/* loaded from: classes2.dex */
public class NotFilter extends AbstractFilter {
    public static final Parcelable.Creator CREATOR = new zzm();
    final int mVersionCode;
    final FilterHolder zzauw;

    NotFilter(int i, FilterHolder filterHolder) {
        this.mVersionCode = i;
        this.zzauw = filterHolder;
    }

    public NotFilter(Filter filter) {
        this(1, new FilterHolder(filter));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public Object zza(zzf zzfVar) {
        return zzfVar.zzB(this.zzauw.getFilter().zza(zzfVar));
    }
}
