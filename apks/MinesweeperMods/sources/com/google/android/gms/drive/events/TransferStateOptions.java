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
public final class TransferStateOptions implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzr();
    final int mVersionCode;
    final List zzapB;
    private final Set zzapC;

    TransferStateOptions(int i, List list) {
        this(i, list, list == null ? null : new HashSet(list));
    }

    private TransferStateOptions(int i, List list, Set set) {
        this.mVersionCode = i;
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
        return zzw.equal(this.zzapC, ((TransferStateOptions) obj).zzapC);
    }

    public final int hashCode() {
        return zzw.hashCode(this.zzapC);
    }

    public final String toString() {
        return String.format(Locale.US, "TransferStateOptions[Spaces=%s]", this.zzapB);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }
}
