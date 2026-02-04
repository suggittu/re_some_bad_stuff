package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmr;
import java.util.Set;

/* loaded from: classes2.dex */
public final class UserDataType implements SafeParcelable {
    final int mVersionCode;
    final String zzJN;
    final int zzaQb;
    public static final UserDataType zzaPX = zzy("test_type", 1);
    public static final UserDataType zzaPY = zzy("labeled_place", 6);
    public static final UserDataType zzaPZ = zzy("here_content", 7);
    public static final Set zzaQa = zzmr.zza(zzaPX, zzaPY, zzaPZ);
    public static final zzm CREATOR = new zzm();

    UserDataType(int i, String str, int i2) {
        zzx.zzcM(str);
        this.mVersionCode = i;
        this.zzJN = str;
        this.zzaQb = i2;
    }

    private static UserDataType zzy(String str, int i) {
        return new UserDataType(0, str, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserDataType)) {
            return false;
        }
        UserDataType userDataType = (UserDataType) obj;
        return this.zzJN.equals(userDataType.zzJN) && this.zzaQb == userDataType.zzaQb;
    }

    public final int hashCode() {
        return this.zzJN.hashCode();
    }

    public final String toString() {
        return this.zzJN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
