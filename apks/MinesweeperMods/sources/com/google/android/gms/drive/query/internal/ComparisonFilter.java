package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class ComparisonFilter extends AbstractFilter {
    public static final zza CREATOR = new zza();
    final int mVersionCode;
    final Operator zzaug;
    final MetadataBundle zzauh;
    final MetadataField zzaui;

    ComparisonFilter(int i, Operator operator, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzaug = operator;
        this.zzauh = metadataBundle;
        this.zzaui = zze.zza(metadataBundle);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField searchableMetadataField, Object obj) {
        this(1, operator, MetadataBundle.zzb(searchableMetadataField, obj));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object getValue() {
        return this.zzauh.zza(this.zzaui);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public Object zza(zzf zzfVar) {
        return zzfVar.zzb(this.zzaug, this.zzaui, getValue());
    }
}
