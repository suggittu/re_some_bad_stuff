package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class SafeBrowsingData implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    public final int mVersionCode;
    private String zzbgv;

    SafeBrowsingData(int i, String str) {
        this.mVersionCode = i;
        this.zzbgv = str;
    }

    public SafeBrowsingData(String str) {
        this(1, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMetadata() {
        return this.zzbgv;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
