package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class ParentDriveIdSet implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzl();
    final int mVersionCode;
    final List zzasS;

    public ParentDriveIdSet() {
        this(1, new ArrayList());
    }

    ParentDriveIdSet(int i, List list) {
        this.mVersionCode = i;
        this.zzasS = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    public Set zzD(long j) {
        HashSet hashSet = new HashSet();
        Iterator it = this.zzasS.iterator();
        while (it.hasNext()) {
            hashSet.add(((PartialDriveId) it.next()).zzE(j));
        }
        return hashSet;
    }

    public void zza(PartialDriveId partialDriveId) {
        this.zzasS.add(partialDriveId);
    }
}
