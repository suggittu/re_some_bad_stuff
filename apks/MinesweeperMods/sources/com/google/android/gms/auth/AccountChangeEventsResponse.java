package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

/* loaded from: classes2.dex */
public class AccountChangeEventsResponse implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzc();
    final int mVersion;
    final List zzpH;

    AccountChangeEventsResponse(int i, List list) {
        this.mVersion = i;
        this.zzpH = (List) zzx.zzz(list);
    }

    public AccountChangeEventsResponse(List list) {
        this.mVersion = 1;
        this.zzpH = (List) zzx.zzz(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List getEvents() {
        return this.zzpH;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
