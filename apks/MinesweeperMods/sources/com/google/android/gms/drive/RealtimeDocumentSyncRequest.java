package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

/* loaded from: classes2.dex */
public class RealtimeDocumentSyncRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzk();
    final int mVersionCode;
    final List zzapq;
    final List zzapr;

    RealtimeDocumentSyncRequest(int i, List list, List list2) {
        this.mVersionCode = i;
        this.zzapq = (List) zzx.zzz(list);
        this.zzapr = (List) zzx.zzz(list2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
