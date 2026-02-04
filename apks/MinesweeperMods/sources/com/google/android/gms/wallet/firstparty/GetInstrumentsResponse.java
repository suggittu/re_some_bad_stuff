package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class GetInstrumentsResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zze();
    private final int mVersionCode;
    String[] zzbpT;
    byte[][] zzbpU;

    GetInstrumentsResponse() {
        this(1, new String[0], new byte[0][]);
    }

    GetInstrumentsResponse(int i, String[] strArr, byte[][] bArr) {
        this.mVersionCode = i;
        this.zzbpT = strArr;
        this.zzbpU = bArr;
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
        zze.zza(this, parcel, i);
    }
}
