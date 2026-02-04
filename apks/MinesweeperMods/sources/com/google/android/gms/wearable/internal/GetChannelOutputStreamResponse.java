package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class GetChannelOutputStreamResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzak();
    public final int statusCode;
    public final int versionCode;
    public final ParcelFileDescriptor zzbsC;

    GetChannelOutputStreamResponse(int i, int i2, ParcelFileDescriptor parcelFileDescriptor) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzbsC = parcelFileDescriptor;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzak.zza(this, parcel, i);
    }
}
