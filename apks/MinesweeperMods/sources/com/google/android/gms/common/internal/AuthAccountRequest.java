package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class AuthAccountRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzc();
    final int mVersionCode;
    final Scope[] zzafT;
    final IBinder zzakA;
    Integer zzakB;
    Integer zzakC;

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2) {
        this.mVersionCode = i;
        this.zzakA = iBinder;
        this.zzafT = scopeArr;
        this.zzakB = num;
        this.zzakC = num2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
