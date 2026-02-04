package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.TransferProgressOptions;
import com.google.android.gms.drive.events.TransferStateOptions;

/* loaded from: classes2.dex */
public class AddEventListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zza();
    final int mVersionCode;
    final int zzanf;
    final DriveId zzaoz;
    final TransferStateOptions zzapY;
    final TransferProgressOptions zzapZ;
    final ChangesAvailableOptions zzapy;

    public AddEventListenerRequest(int i, DriveId driveId) {
        this(1, (DriveId) com.google.android.gms.common.internal.zzx.zzz(driveId), i, null, null, null);
    }

    AddEventListenerRequest(int i, DriveId driveId, int i2, ChangesAvailableOptions changesAvailableOptions, TransferStateOptions transferStateOptions, TransferProgressOptions transferProgressOptions) {
        this.mVersionCode = i;
        this.zzaoz = driveId;
        this.zzanf = i2;
        this.zzapy = changesAvailableOptions;
        this.zzapY = transferStateOptions;
        this.zzapZ = transferProgressOptions;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzaoz;
    }

    public int getEventType() {
        return this.zzanf;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
