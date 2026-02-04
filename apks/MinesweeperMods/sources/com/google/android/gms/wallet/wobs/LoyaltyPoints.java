package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public final class LoyaltyPoints implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zze();
    String label;
    private final int mVersionCode;
    String type;
    TimeInterval zzboY;
    LoyaltyPointsBalance zzbqI;

    LoyaltyPoints() {
        this.mVersionCode = 1;
    }

    LoyaltyPoints(int i, String str, LoyaltyPointsBalance loyaltyPointsBalance, String str2, TimeInterval timeInterval) {
        this.mVersionCode = i;
        this.label = str;
        this.zzbqI = loyaltyPointsBalance;
        this.type = str2;
        this.zzboY = timeInterval;
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
