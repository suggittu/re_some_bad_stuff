package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class IsReadyToPayRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzi();
    final int mVersionCode;

    public final class zza {
        private zza() {
        }

        public final IsReadyToPayRequest zzIk() {
            return IsReadyToPayRequest.this;
        }
    }

    IsReadyToPayRequest() {
        this.mVersionCode = 1;
    }

    IsReadyToPayRequest(int i) {
        this.mVersionCode = i;
    }

    public static zza zzIj() {
        IsReadyToPayRequest isReadyToPayRequest = new IsReadyToPayRequest();
        isReadyToPayRequest.getClass();
        return new zza();
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
        zzi.zza(this, parcel, i);
    }
}
