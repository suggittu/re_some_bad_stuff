package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class FACLData implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    final int version;
    FACLConfig zzYs;
    String zzYt;
    boolean zzYu;
    String zzYv;

    FACLData(int i, FACLConfig fACLConfig, String str, boolean z, String str2) {
        this.version = i;
        this.zzYs = fACLConfig;
        this.zzYt = str;
        this.zzYu = z;
        this.zzYv = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
