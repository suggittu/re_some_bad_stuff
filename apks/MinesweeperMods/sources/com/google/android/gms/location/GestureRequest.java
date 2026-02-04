package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class GestureRequest implements SafeParcelable {
    private final int mVersionCode;
    private final List zzaNT;
    private static final List zzaNP = Collections.unmodifiableList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19));
    private static final List zzaNQ = Collections.unmodifiableList(Arrays.asList(1));
    private static final List zzaNR = Collections.unmodifiableList(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 19));
    private static final List zzaNS = Collections.unmodifiableList(Arrays.asList(3, 5, 7, 9, 11, 13, 15, 17));
    public static final zzb CREATOR = new zzb();

    GestureRequest(int i, List list) {
        this.mVersionCode = i;
        this.zzaNT = list;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public final List zzyJ() {
        return this.zzaNT;
    }
}
