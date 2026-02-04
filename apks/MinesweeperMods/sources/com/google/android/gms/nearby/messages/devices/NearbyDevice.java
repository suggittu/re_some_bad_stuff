package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class NearbyDevice implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzf();
    private static final NearbyDeviceId[] zzbcb = new NearbyDeviceId[0];
    private static final String[] zzbcc = new String[0];
    public static final NearbyDevice zzbcd = new NearbyDevice("", zzbcb, zzbcc);
    final int mVersionCode;

    @Nullable
    @Deprecated
    private final String zzF;

    @Deprecated
    private final NearbyDeviceId zzbce;
    private final String zzbcf;
    private final NearbyDeviceId[] zzbcg;
    private final String[] zzbch;

    NearbyDevice(int i, @Nullable NearbyDeviceId nearbyDeviceId, @Nullable String str, @Nullable String str2, @Nullable NearbyDeviceId[] nearbyDeviceIdArr, @Nullable String[] strArr) {
        this.mVersionCode = ((Integer) zzx.zzz(Integer.valueOf(i))).intValue();
        this.zzbcf = str2 == null ? "" : str2;
        this.zzbcg = nearbyDeviceIdArr == null ? zzbcb : nearbyDeviceIdArr;
        this.zzbch = strArr == null ? zzbcc : strArr;
        this.zzbce = this.zzbcg.length == 0 ? NearbyDeviceId.zzbcl : this.zzbcg[0];
        this.zzF = this.zzbch.length == 0 ? null : this.zzbch[0];
    }

    public NearbyDevice(String str, NearbyDeviceId[] nearbyDeviceIdArr, String[] strArr) {
        this(1, null, null, str, nearbyDeviceIdArr, strArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NearbyDevice) {
            return zzw.equal(this.zzbcf, ((NearbyDevice) obj).zzbcf);
        }
        return false;
    }

    @Nullable
    @Deprecated
    public String getUrl() {
        if (this.zzbch.length == 0) {
            return null;
        }
        return this.zzbch[0];
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbcf);
    }

    public String toString() {
        return "NearbyDevice{deviceHandle=" + this.zzbcf + ", ids=" + Arrays.toString(this.zzbcg) + ", urls=" + Arrays.toString(this.zzbch) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public NearbyDeviceId[] zzEA() {
        return this.zzbcg;
    }

    public String[] zzEB() {
        return this.zzbch;
    }

    public String zzEC() {
        return this.zzbcf;
    }

    @Deprecated
    public NearbyDeviceId zzEz() {
        return this.zzbcg.length == 0 ? NearbyDeviceId.zzbcl : this.zzbcg[0];
    }
}
