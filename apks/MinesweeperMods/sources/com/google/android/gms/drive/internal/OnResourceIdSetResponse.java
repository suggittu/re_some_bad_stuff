package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public class OnResourceIdSetResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzbh();
    private final int mVersionCode;
    private final List zzaqi;

    OnResourceIdSetResponse(int i, List list) {
        this.mVersionCode = i;
        this.zzaqi = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbh.zza(this, parcel, i);
    }

    public List zztc() {
        return this.zzaqi;
    }
}
