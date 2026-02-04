package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class SortOrder implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    final int mVersionCode;
    final List zzaud;
    final boolean zzaue;

    public class Builder {
        private final List zzaud = new ArrayList();
        private boolean zzaue = false;

        public Builder addSortAscending(SortableMetadataField sortableMetadataField) {
            this.zzaud.add(new FieldWithSortOrder(sortableMetadataField.getName(), true));
            return this;
        }

        public Builder addSortDescending(SortableMetadataField sortableMetadataField) {
            this.zzaud.add(new FieldWithSortOrder(sortableMetadataField.getName(), false));
            return this;
        }

        public SortOrder build() {
            return new SortOrder(this.zzaud, this.zzaue);
        }
    }

    SortOrder(int i, List list, boolean z) {
        this.mVersionCode = i;
        this.zzaud = list;
        this.zzaue = z;
    }

    private SortOrder(List list, boolean z) {
        this(1, list, z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "SortOrder[%s, %s]", TextUtils.join(",", this.zzaud), Boolean.valueOf(this.zzaue));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
