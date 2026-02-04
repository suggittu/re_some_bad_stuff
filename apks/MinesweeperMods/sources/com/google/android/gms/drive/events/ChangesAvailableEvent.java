package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class ChangesAvailableEvent implements SafeParcelable, DriveEvent {
    public static final Parcelable.Creator CREATOR = new zzb();
    final int mVersionCode;
    final String zzVa;
    final ChangesAvailableOptions zzapy;

    ChangesAvailableEvent(int i, String str, ChangesAvailableOptions changesAvailableOptions) {
        this.mVersionCode = i;
        this.zzVa = str;
        this.zzapy = changesAvailableOptions;
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
        ChangesAvailableEvent changesAvailableEvent = (ChangesAvailableEvent) obj;
        return zzw.equal(this.zzapy, changesAvailableEvent.zzapy) && zzw.equal(this.zzVa, changesAvailableEvent.zzVa);
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 4;
    }

    public final int hashCode() {
        return zzw.hashCode(this.zzapy, this.zzVa);
    }

    public final String toString() {
        return String.format(Locale.US, "ChangesAvailableEvent [changesAvailableOptions=%s]", this.zzapy);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
