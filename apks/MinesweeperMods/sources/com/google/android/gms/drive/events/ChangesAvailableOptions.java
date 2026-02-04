package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
public final class ChangesAvailableOptions implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzd();
    final int mVersionCode;
    final boolean zzapA;
    final List zzapB;
    private final Set zzapC;
    final int zzapz;

    ChangesAvailableOptions(int i, int i2, boolean z, List list) {
        this(i, i2, z, list, list == null ? null : new HashSet(list));
    }

    private ChangesAvailableOptions(int i, int i2, boolean z, List list, Set set) {
        this.mVersionCode = i;
        this.zzapz = i2;
        this.zzapA = z;
        this.zzapB = list;
        this.zzapC = set;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ChangesAvailableOptions changesAvailableOptions = (ChangesAvailableOptions) obj;
        return zzw.equal(this.zzapC, changesAvailableOptions.zzapC) && this.zzapz == changesAvailableOptions.zzapz && this.zzapA == changesAvailableOptions.zzapA;
    }

    public final int hashCode() {
        return zzw.hashCode(this.zzapC, Integer.valueOf(this.zzapz), Boolean.valueOf(this.zzapA));
    }

    public final String toString() {
        return String.format(Locale.US, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", Integer.valueOf(this.zzapz), Boolean.valueOf(this.zzapA), this.zzapB);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
