package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

/* loaded from: classes2.dex */
public final class AppContentTupleRef extends zzc implements AppContentTuple {
    AppContentTupleRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public final boolean equals(Object obj) {
        return AppContentTupleEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentTuple
    public final String getName() {
        return getString("tuple_name");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentTuple
    public final String getValue() {
        return getString("tuple_value");
    }

    @Override // com.google.android.gms.common.data.zzc
    public final int hashCode() {
        return AppContentTupleEntity.zza(this);
    }

    public final String toString() {
        return AppContentTupleEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((AppContentTupleEntity) freeze()).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzwq, reason: merged with bridge method [inline-methods] */
    public final AppContentTuple freeze() {
        return new AppContentTupleEntity(this);
    }
}
