package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzaw;

/* loaded from: classes2.dex */
public class RemoveListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzbg();
    final int mVersionCode;
    public final zzaw zzbrB;

    RemoveListenerRequest(int i, IBinder iBinder) {
        this.mVersionCode = i;
        if (iBinder != null) {
            this.zzbrB = zzaw.zza.zzet(iBinder);
        } else {
            this.zzbrB = null;
        }
    }

    public RemoveListenerRequest(zzaw zzawVar) {
        this.mVersionCode = 1;
        this.zzbrB = zzawVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbg.zza(this, parcel, i);
    }

    IBinder zzIy() {
        if (this.zzbrB == null) {
            return null;
        }
        return this.zzbrB.asBinder();
    }
}
