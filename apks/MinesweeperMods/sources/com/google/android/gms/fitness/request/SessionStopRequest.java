package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzov;

/* loaded from: classes2.dex */
public class SessionStopRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzab();
    private final String mName;
    private final int mVersionCode;
    private final zzov zzaBz;
    private final String zzaxk;

    SessionStopRequest(int i, String str, String str2, IBinder iBinder) {
        this.mVersionCode = i;
        this.mName = str;
        this.zzaxk = str2;
        this.zzaBz = zzov.zza.zzbQ(iBinder);
    }

    public SessionStopRequest(String str, String str2, zzov zzovVar) {
        this.mVersionCode = 3;
        this.mName = str;
        this.zzaxk = str2;
        this.zzaBz = zzovVar;
    }

    private boolean zzb(SessionStopRequest sessionStopRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.mName, sessionStopRequest.mName) && com.google.android.gms.common.internal.zzw.equal(this.zzaxk, sessionStopRequest.zzaxk);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionStopRequest) && zzb((SessionStopRequest) obj));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaBz == null) {
            return null;
        }
        return this.zzaBz.asBinder();
    }

    public String getIdentifier() {
        return this.zzaxk;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.mName, this.zzaxk);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg("name", this.mName).zzg("identifier", this.zzaxk).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzab.zza(this, parcel, i);
    }
}
