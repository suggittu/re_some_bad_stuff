package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class SendMessageResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzbi();
    public final int statusCode;
    public final int versionCode;
    public final int zzaNj;

    SendMessageResponse(int i, int i2, int i3) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaNj = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbi.zza(this, parcel, i);
    }
}
