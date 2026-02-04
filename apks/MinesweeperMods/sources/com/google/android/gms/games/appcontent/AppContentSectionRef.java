package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
    private final int zzaDQ;

    AppContentSectionRef(ArrayList arrayList, int i, int i2) {
        super(arrayList, 0, i);
        this.zzaDQ = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public final boolean equals(Object obj) {
        return AppContentSectionEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final Bundle getExtras() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "section_data", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final String getId() {
        return getString("section_id");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final String getTitle() {
        return getString("section_title");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final String getType() {
        return getString("section_type");
    }

    @Override // com.google.android.gms.common.data.zzc
    public final int hashCode() {
        return AppContentSectionEntity.zza(this);
    }

    public final String toString() {
        return AppContentSectionEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((AppContentSectionEntity) freeze()).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final String zzvQ() {
        return getString("section_content_description");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final String zzwc() {
        return getString("section_subtitle");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final String zzwl() {
        return getString("section_card_type");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzwm, reason: merged with bridge method [inline-methods] */
    public final AppContentSection freeze() {
        return new AppContentSectionEntity(this);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    /* renamed from: zzwn, reason: merged with bridge method [inline-methods] */
    public final ArrayList getActions() {
        return AppContentUtils.zza(this.zzahi, this.zzaDN, "section_actions", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    /* renamed from: zzwo, reason: merged with bridge method [inline-methods] */
    public final ArrayList zzwa() {
        return AppContentUtils.zzb(this.zzahi, this.zzaDN, "section_annotations", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    /* renamed from: zzwp, reason: merged with bridge method [inline-methods] */
    public final ArrayList zzwk() {
        ArrayList arrayList = new ArrayList(this.zzaDQ);
        for (int i = 0; i < this.zzaDQ; i++) {
            arrayList.add(new AppContentCardRef(this.zzaDN, this.zzaje + i));
        }
        return arrayList;
    }
}
