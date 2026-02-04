package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes2.dex */
public class InFilter extends AbstractFilter {
    public static final zzj CREATOR = new zzj();
    final int mVersionCode;
    final MetadataBundle zzauh;
    private final com.google.android.gms.drive.metadata.zzb zzauu;

    InFilter(int i, MetadataBundle metadataBundle) {
        this.mVersionCode = i;
        this.zzauh = metadataBundle;
        this.zzauu = (com.google.android.gms.drive.metadata.zzb) zze.zza(metadataBundle);
    }

    public InFilter(SearchableCollectionMetadataField searchableCollectionMetadataField, Object obj) {
        this(1, MetadataBundle.zzb(searchableCollectionMetadataField, Collections.singleton(obj)));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object getValue() {
        return ((Collection) this.zzauh.zza(this.zzauu)).iterator().next();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public Object zza(zzf zzfVar) {
        return zzfVar.zzb(this.zzauu, getValue());
    }
}
