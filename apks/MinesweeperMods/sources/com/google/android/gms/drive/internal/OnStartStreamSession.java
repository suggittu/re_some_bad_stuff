package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class OnStartStreamSession implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzbi();
    final int mVersionCode;
    final ParcelFileDescriptor zzasv;
    final IBinder zzasw;
    final String zzsU;

    OnStartStreamSession(int i, ParcelFileDescriptor parcelFileDescriptor, IBinder iBinder, String str) {
        this.mVersionCode = i;
        this.zzasv = parcelFileDescriptor;
        this.zzasw = iBinder;
        this.zzsU = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbi.zza(this, parcel, i | 1);
    }
}
