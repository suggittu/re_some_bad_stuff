package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class AttestationData implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zza();
    public final int mVersionCode;
    private String zzbgu;

    AttestationData(int i, String str) {
        this.mVersionCode = i;
        this.zzbgu = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getJwsResult() {
        return this.zzbgu;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
