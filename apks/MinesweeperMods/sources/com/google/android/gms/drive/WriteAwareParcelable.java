package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public abstract class WriteAwareParcelable implements Parcelable {
    private volatile transient boolean zzapw = false;

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzx.zzab(!zzsT());
        this.zzapw = true;
        zzJ(parcel, i);
    }

    protected abstract void zzJ(Parcel parcel, int i);

    public final boolean zzsT() {
        return this.zzapw;
    }
}
