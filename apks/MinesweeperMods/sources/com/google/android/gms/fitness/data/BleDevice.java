package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznr;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class BleDevice implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    private final String mName;
    private final int mVersionCode;
    private final String zzawc;
    private final List zzawd;
    private final List zzawe;

    BleDevice(int i, String str, String str2, List list, List list2) {
        this.mVersionCode = i;
        this.zzawc = str;
        this.mName = str2;
        this.zzawd = Collections.unmodifiableList(list);
        this.zzawe = Collections.unmodifiableList(list2);
    }

    private boolean zza(BleDevice bleDevice) {
        return this.mName.equals(bleDevice.mName) && this.zzawc.equals(bleDevice.zzawc) && zznr.zza(bleDevice.zzawd, this.zzawd) && zznr.zza(this.zzawe, bleDevice.zzawe);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof BleDevice) && zza((BleDevice) obj));
    }

    public String getAddress() {
        return this.zzawc;
    }

    public List getDataTypes() {
        return this.zzawe;
    }

    public String getName() {
        return this.mName;
    }

    public List getSupportedProfiles() {
        return this.zzawd;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName, this.zzawc, this.zzawd, this.zzawe);
    }

    public String toString() {
        return zzw.zzy(this).zzg("name", this.mName).zzg("address", this.zzawc).zzg("dataTypes", this.zzawe).zzg("supportedProfiles", this.zzawd).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
