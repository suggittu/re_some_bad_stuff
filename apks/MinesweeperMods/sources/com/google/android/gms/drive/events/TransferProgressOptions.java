package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class TransferProgressOptions implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzo();
    final int mVersionCode;
    final int zzapT;

    TransferProgressOptions(int i, int i2) {
        this.mVersionCode = i;
        this.zzapT = i2;
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
        return zzw.equal(Integer.valueOf(this.zzapT), Integer.valueOf(((TransferProgressOptions) obj).zzapT));
    }

    public final int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzapT));
    }

    public final String toString() {
        return String.format(Locale.US, "TransferProgressOptions[type=%d]", Integer.valueOf(this.zzapT));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
