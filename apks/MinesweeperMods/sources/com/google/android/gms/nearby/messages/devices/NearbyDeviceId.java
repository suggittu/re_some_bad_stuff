package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public class NearbyDeviceId implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzh();
    public static final NearbyDeviceId zzbcl = new NearbyDeviceId();
    final int mVersionCode;
    private final int zzabB;
    final byte[] zzbbY;
    private final zzb zzbcm;
    private final zzd zzbcn;

    private NearbyDeviceId() {
        this(1, 1, null);
    }

    NearbyDeviceId(int i, int i2, byte[] bArr) {
        this.mVersionCode = i;
        this.zzabB = i2;
        this.zzbbY = bArr;
        this.zzbcm = i2 == 2 ? new zzb(bArr) : null;
        this.zzbcn = i2 == 3 ? new zzd(bArr) : null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyDeviceId)) {
            return false;
        }
        NearbyDeviceId nearbyDeviceId = (NearbyDeviceId) obj;
        return zzw.equal(Integer.valueOf(this.zzabB), Integer.valueOf(nearbyDeviceId.zzabB)) && zzw.equal(this.zzbbY, nearbyDeviceId.zzbbY);
    }

    public int getType() {
        return this.zzabB;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzabB), this.zzbbY);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NearbyDeviceId{");
        switch (this.zzabB) {
            case 1:
                sb.append("UNKNOWN");
                break;
            case 2:
                sb.append("eddystoneUid=").append(this.zzbcm);
                break;
            case 3:
                sb.append("iBeaconId=").append(this.zzbcn);
                break;
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
