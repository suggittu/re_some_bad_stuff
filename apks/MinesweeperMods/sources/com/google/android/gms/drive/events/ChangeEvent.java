package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class ChangeEvent implements SafeParcelable, ResourceEvent {
    public static final Parcelable.Creator CREATOR = new zza();
    final int mVersionCode;
    final DriveId zzaoz;
    final int zzapx;

    ChangeEvent(int i, DriveId driveId, int i2) {
        this.mVersionCode = i;
        this.zzaoz = driveId;
        this.zzapx = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.drive.events.ResourceEvent
    public final DriveId getDriveId() {
        return this.zzaoz;
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 1;
    }

    public final boolean hasBeenDeleted() {
        return (this.zzapx & 4) != 0;
    }

    public final boolean hasContentChanged() {
        return (this.zzapx & 2) != 0;
    }

    public final boolean hasMetadataChanged() {
        return (this.zzapx & 1) != 0;
    }

    public final String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", this.zzaoz, Integer.valueOf(this.zzapx));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
