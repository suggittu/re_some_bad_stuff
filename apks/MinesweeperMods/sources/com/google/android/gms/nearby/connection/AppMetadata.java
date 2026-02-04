package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

/* loaded from: classes2.dex */
public final class AppMetadata implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    private final List zzbaZ;

    AppMetadata(int i, List list) {
        this.mVersionCode = i;
        this.zzbaZ = (List) zzx.zzb(list, "Must specify application identifiers");
        zzx.zza(list.size(), (Object) "Application identifiers cannot be empty");
    }

    public AppMetadata(List list) {
        this(1, list);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final List getAppIdentifiers() {
        return this.zzbaZ;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
