package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class BleDevicesResult implements Result, SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zza();
    private final int mVersionCode;
    private final Status zzUX;
    private final List zzaBE;

    BleDevicesResult(int i, List list, Status status) {
        this.mVersionCode = i;
        this.zzaBE = Collections.unmodifiableList(list);
        this.zzUX = status;
    }

    public BleDevicesResult(List list, Status status) {
        this.mVersionCode = 3;
        this.zzaBE = Collections.unmodifiableList(list);
        this.zzUX = status;
    }

    public static BleDevicesResult zzQ(Status status) {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    private boolean zzb(BleDevicesResult bleDevicesResult) {
        return this.zzUX.equals(bleDevicesResult.zzUX) && zzw.equal(this.zzaBE, bleDevicesResult.zzaBE);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof BleDevicesResult) && zzb((BleDevicesResult) obj));
    }

    public List getClaimedBleDevices() {
        return this.zzaBE;
    }

    public List getClaimedBleDevices(DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (BleDevice bleDevice : this.zzaBE) {
            if (bleDevice.getDataTypes().contains(dataType)) {
                arrayList.add(bleDevice);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzaBE);
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", this.zzUX).zzg("bleDevices", this.zzaBE).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
