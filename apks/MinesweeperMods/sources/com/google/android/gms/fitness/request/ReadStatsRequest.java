package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzot;
import java.util.List;

/* loaded from: classes2.dex */
public class ReadStatsRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzu();
    private final int mVersionCode;
    private final List zzaAF;
    private final zzot zzaBg;

    ReadStatsRequest(int i, IBinder iBinder, List list) {
        this.mVersionCode = i;
        this.zzaBg = zzot.zza.zzbO(iBinder);
        this.zzaAF = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        return this.zzaBg.asBinder();
    }

    public List getDataSources() {
        return this.zzaAF;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("ReadStatsRequest", new Object[0]);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzu.zza(this, parcel, i);
    }
}
