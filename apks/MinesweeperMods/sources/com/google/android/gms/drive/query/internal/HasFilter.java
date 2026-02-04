package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class HasFilter extends AbstractFilter {
    public static final zzi CREATOR = new zzi();
    final int mVersionCode;
    final MetadataBundle zzauh;
    final MetadataField zzaui;

    HasFilter(int i, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzauh = metadataBundle;
        this.zzaui = zze.zza(metadataBundle);
    }

    public HasFilter(SearchableMetadataField searchableMetadataField, Object obj) {
        this(1, MetadataBundle.zzb(searchableMetadataField, obj));
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
        zzi.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public Object zza(zzf zzfVar) {
        return zzfVar.zze(this.zzaui, getValue());
    }
}
