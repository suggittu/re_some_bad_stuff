package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class LabelValue implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    String label;
    private final int mVersionCode;
    String value;

    LabelValue() {
        this.mVersionCode = 1;
    }

    LabelValue(int i, String str, String str2) {
        this.mVersionCode = i;
        this.label = str;
        this.value = str2;
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
}
