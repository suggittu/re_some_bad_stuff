package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

/* loaded from: classes2.dex */
public final class TransferStateEvent implements DriveEvent {
    public static final Parcelable.Creator CREATOR = new zzp();
    final int mVersionCode;
    final String zzVa;
    final List zzapU;

    TransferStateEvent(int i, String str, List list) {
        this.mVersionCode = i;
        this.zzVa = str;
        this.zzapU = list;
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
        TransferStateEvent transferStateEvent = (TransferStateEvent) obj;
        return zzw.equal(this.zzVa, transferStateEvent.zzVa) && zzw.equal(this.zzapU, transferStateEvent.zzapU);
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 7;
    }

    public final int hashCode() {
        return zzw.hashCode(this.zzVa, this.zzapU);
    }

    public final String toString() {
        return String.format("TransferStateEvent[%s]", TextUtils.join("','", this.zzapU));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
