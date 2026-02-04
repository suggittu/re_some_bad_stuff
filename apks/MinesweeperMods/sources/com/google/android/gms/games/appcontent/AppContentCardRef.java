package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class AppContentCardRef extends MultiDataBufferRef implements AppContentCard {
    AppContentCardRef(ArrayList arrayList, int i) {
        super(arrayList, 0, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public final boolean equals(Object obj) {
        return AppContentCardEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final List getActions() {
        return AppContentUtils.zza(this.zzahi, this.zzaDN, "card_actions", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final String getDescription() {
        return getString("card_description");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final Bundle getExtras() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "card_data", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final String getId() {
        return getString("card_id");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final String getTitle() {
        return getString("card_title");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final String getType() {
        return getString("card_type");
    }

    @Override // com.google.android.gms.common.data.zzc
    public final int hashCode() {
        return AppContentCardEntity.zza(this);
    }

    public final String toString() {
        return AppContentCardEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((AppContentCardEntity) freeze()).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final List zzvP() {
        return AppContentUtils.zzc(this.zzahi, this.zzaDN, "card_conditions", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final String zzvQ() {
        return getString("card_content_description");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final List zzwa() {
        return AppContentUtils.zzb(this.zzahi, this.zzaDN, "card_annotations", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final int zzwb() {
        return getInteger("card_current_steps");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final String zzwc() {
        return getString("card_subtitle");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final int zzwd() {
        return getInteger("card_total_steps");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzwe, reason: merged with bridge method [inline-methods] */
    public final AppContentCard freeze() {
        return new AppContentCardEntity(this);
    }
}
