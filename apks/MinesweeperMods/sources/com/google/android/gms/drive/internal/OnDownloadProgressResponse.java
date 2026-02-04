package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class OnDownloadProgressResponse implements SafeParcelable {
    final int mVersionCode;
    final int zzBc;
    final long zzasi;
    final long zzasj;
    final List zzask;
    private static final List zzash = Collections.emptyList();
    public static final Parcelable.Creator CREATOR = new zzay();

    OnDownloadProgressResponse(int i, long j, long j2, int i2, List list) {
        this.mVersionCode = i;
        this.zzasi = j;
        this.zzasj = j2;
        this.zzBc = i2;
        this.zzask = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzay.zza(this, parcel, i);
    }

    public long zztq() {
        return this.zzasi;
    }

    public long zztr() {
        return this.zzasj;
    }
}
