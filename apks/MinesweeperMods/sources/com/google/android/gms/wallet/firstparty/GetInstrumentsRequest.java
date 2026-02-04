package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class GetInstrumentsRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzd();
    private final int mVersionCode;
    int[] zzbpS;

    GetInstrumentsRequest() {
        this(1, null);
    }

    GetInstrumentsRequest(int i, int[] iArr) {
        this.mVersionCode = i;
        this.zzbpS = iArr;
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
        zzd.zza(this, parcel, i);
    }
}
