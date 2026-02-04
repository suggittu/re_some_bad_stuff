package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public class SessionDataSet implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzr();
    final int mVersionCode;
    private final Session zzavX;
    private final DataSet zzaxn;

    SessionDataSet(int i, Session session, DataSet dataSet) {
        this.mVersionCode = i;
        this.zzavX = session;
        this.zzaxn = dataSet;
    }

    private boolean zza(SessionDataSet sessionDataSet) {
        return zzw.equal(this.zzavX, sessionDataSet.zzavX) && zzw.equal(this.zzaxn, sessionDataSet.zzaxn);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionDataSet) && zza((SessionDataSet) obj));
    }

    public DataSet getDataSet() {
        return this.zzaxn;
    }

    public Session getSession() {
        return this.zzavX;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzavX, this.zzaxn);
    }

    public String toString() {
        return zzw.zzy(this).zzg("session", this.zzavX).zzg("dataSet", this.zzaxn).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }
}
