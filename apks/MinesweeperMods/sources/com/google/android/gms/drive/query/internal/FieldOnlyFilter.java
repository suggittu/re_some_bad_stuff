package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public class FieldOnlyFilter extends AbstractFilter {
    public static final Parcelable.Creator CREATOR = new zzb();
    final int mVersionCode;
    final MetadataBundle zzauh;
    private final MetadataField zzaui;

    FieldOnlyFilter(int i, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzauh = metadataBundle;
        this.zzaui = zze.zza(metadataBundle);
    }

    public FieldOnlyFilter(SearchableMetadataField searchableMetadataField) {
        this(1, MetadataBundle.zzb(searchableMetadataField, null));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public Object zza(zzf zzfVar) {
        return zzfVar.zze(this.zzaui);
    }
}
