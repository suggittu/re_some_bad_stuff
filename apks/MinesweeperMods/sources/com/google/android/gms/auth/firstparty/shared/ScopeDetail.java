package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public class ScopeDetail implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    String description;
    final int version;
    List zzYA;
    public FACLData zzYB;
    String zzYw;
    String zzYx;
    String zzYy;
    String zzYz;

    ScopeDetail(int i, String str, String str2, String str3, String str4, String str5, List list, FACLData fACLData) {
        this.version = i;
        this.description = str;
        this.zzYw = str2;
        this.zzYx = str3;
        this.zzYy = str4;
        this.zzYz = str5;
        this.zzYA = list;
        this.zzYB = fACLData;
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
