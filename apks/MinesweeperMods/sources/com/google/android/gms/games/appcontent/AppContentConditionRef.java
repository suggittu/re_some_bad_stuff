package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class AppContentConditionRef extends MultiDataBufferRef implements AppContentCondition {
    AppContentConditionRef(ArrayList arrayList, int i) {
        super(arrayList, 4, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public final boolean equals(Object obj) {
        return AppContentConditionEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.common.data.zzc
    public final int hashCode() {
        return AppContentConditionEntity.zza(this);
    }

    public final String toString() {
        return AppContentConditionEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((AppContentConditionEntity) freeze()).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public final String zzwf() {
        return getString("condition_default_value");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public final String zzwg() {
        return getString("condition_expected_value");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public final String zzwh() {
        return getString("condition_predicate");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public final Bundle zzwi() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "condition_predicate_parameters", this.zzaje);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzwj, reason: merged with bridge method [inline-methods] */
    public final AppContentCondition freeze() {
        return new AppContentConditionEntity(this);
    }
}
