package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public class StringListResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzbw();
    private final int mVersionCode;
    private final List zzasD;

    StringListResponse(int i, List list) {
        this.mVersionCode = i;
        this.zzasD = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbw.zza(this, parcel, i);
    }

    public List zztx() {
        return this.zzasD;
    }
}
