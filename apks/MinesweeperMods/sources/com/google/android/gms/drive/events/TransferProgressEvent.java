package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.events.internal.TransferProgressData;

/* loaded from: classes2.dex */
public final class TransferProgressEvent implements DriveEvent {
    public static final Parcelable.Creator CREATOR = new zzn();
    final int mVersionCode;
    final TransferProgressData zzapS;

    TransferProgressEvent(int i, TransferProgressData transferProgressData) {
        this.mVersionCode = i;
        this.zzapS = transferProgressData;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return zzw.equal(this.zzapS, ((TransferProgressEvent) obj).zzapS);
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 8;
    }

    public final int hashCode() {
        return zzw.hashCode(this.zzapS);
    }

    public final String toString() {
        return String.format("TransferProgressEvent[%s]", this.zzapS.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }

    public final TransferProgressData zzta() {
        return this.zzapS;
    }
}
