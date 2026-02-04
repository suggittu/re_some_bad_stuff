package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class AppContentAnnotationRef extends MultiDataBufferRef implements AppContentAnnotation {
    AppContentAnnotationRef(ArrayList arrayList, int i) {
        super(arrayList, 2, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public final boolean equals(Object obj) {
        return AppContentAnnotationEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public final String getDescription() {
        return getString("annotation_description");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public final String getId() {
        return getString("annotation_id");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public final String getTitle() {
        return getString("annotation_title");
    }

    @Override // com.google.android.gms.common.data.zzc
    public final int hashCode() {
        return AppContentAnnotationEntity.zza(this);
    }

    public final String toString() {
        return AppContentAnnotationEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((AppContentAnnotationEntity) freeze()).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public final String zzvT() {
        return getString("annotation_image_default_id");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public final int zzvU() {
        return getInteger("annotation_image_height");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public final Uri zzvV() {
        return zzcA("annotation_image_uri");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public final Bundle zzvW() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "annotation_modifiers", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public final int zzvX() {
        return getInteger("annotation_image_width");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public final String zzvY() {
        return getString("annotation_layout_slot");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzvZ, reason: merged with bridge method [inline-methods] */
    public final AppContentAnnotation freeze() {
        return new AppContentAnnotationEntity(this);
    }
}
