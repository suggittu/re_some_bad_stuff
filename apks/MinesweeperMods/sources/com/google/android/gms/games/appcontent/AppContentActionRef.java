package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class AppContentActionRef extends MultiDataBufferRef implements AppContentAction {
    AppContentActionRef(ArrayList arrayList, int i) {
        super(arrayList, 1, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public final boolean equals(Object obj) {
        return AppContentActionEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public final Bundle getExtras() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "action_data", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public final String getId() {
        return getString("action_id");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public final String getType() {
        return getString("action_type");
    }

    @Override // com.google.android.gms.common.data.zzc
    public final int hashCode() {
        return AppContentActionEntity.zza(this);
    }

    public final String toString() {
        return AppContentActionEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((AppContentActionEntity) freeze()).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public final AppContentAnnotation zzvO() {
        ArrayList arrayListZzb = AppContentUtils.zzb(this.zzahi, this.zzaDN, "action_annotation", this.zzaje);
        if (arrayListZzb.size() == 1) {
            return (AppContentAnnotation) arrayListZzb.get(0);
        }
        return null;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public final List zzvP() {
        return AppContentUtils.zzc(this.zzahi, this.zzaDN, "action_conditions", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public final String zzvQ() {
        return getString("action_content_description");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public final String zzvR() {
        return getString("overflow_text");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzvS, reason: merged with bridge method [inline-methods] */
    public final AppContentAction freeze() {
        return new AppContentActionEntity(this);
    }
}
