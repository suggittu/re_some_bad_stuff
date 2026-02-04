package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class TimeInterval implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzg();
    private final int mVersionCode;
    long zzbqP;
    long zzbqQ;

    TimeInterval() {
        this.mVersionCode = 1;
    }

    TimeInterval(int i, long j, long j2) {
        this.mVersionCode = i;
        this.zzbqP = j;
        this.zzbqQ = j2;
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
        zzg.zza(this, parcel, i);
    }
}
