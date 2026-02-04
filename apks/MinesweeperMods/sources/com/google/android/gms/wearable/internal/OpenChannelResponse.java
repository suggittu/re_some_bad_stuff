package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class OpenChannelResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzbd();
    public final int statusCode;
    public final int versionCode;
    public final ChannelImpl zzbsc;

    OpenChannelResponse(int i, int i2, ChannelImpl channelImpl) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzbsc = channelImpl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbd.zza(this, parcel, i);
    }
}
