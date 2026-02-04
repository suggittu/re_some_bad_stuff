package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqg;

/* loaded from: classes2.dex */
public class StopScanRequest implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    final int versionCode;
    private final zzqg zzbaV;

    StopScanRequest(int i, IBinder iBinder) {
        this.versionCode = i;
        zzx.zzz(iBinder);
        this.zzbaV = zzqg.zza.zzds(iBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzh zzhVar = CREATOR;
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzbaV == null) {
            return null;
        }
        return this.zzbaV.asBinder();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh zzhVar = CREATOR;
        zzh.zza(this, parcel, i);
    }
}
