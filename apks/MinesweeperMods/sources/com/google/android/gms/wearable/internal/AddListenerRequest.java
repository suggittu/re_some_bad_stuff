package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzaw;

/* loaded from: classes2.dex */
public class AddListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzc();
    final int mVersionCode;
    public final zzaw zzbrB;
    public final IntentFilter[] zzbrC;
    public final String zzbrD;
    public final String zzbrE;

    AddListenerRequest(int i, IBinder iBinder, IntentFilter[] intentFilterArr, String str, String str2) {
        this.mVersionCode = i;
        if (iBinder != null) {
            this.zzbrB = zzaw.zza.zzet(iBinder);
        } else {
            this.zzbrB = null;
        }
        this.zzbrC = intentFilterArr;
        this.zzbrD = str;
        this.zzbrE = str2;
    }

    public AddListenerRequest(zzbq zzbqVar) {
        this.mVersionCode = 1;
        this.zzbrB = zzbqVar;
        this.zzbrC = zzbqVar.zzIO();
        this.zzbrD = zzbqVar.zzIP();
        this.zzbrE = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    IBinder zzIy() {
        if (this.zzbrB == null) {
            return null;
        }
        return this.zzbrB.asBinder();
    }
}
