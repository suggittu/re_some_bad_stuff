package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class SessionStopResult implements Result, SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzk();
    private final int mVersionCode;
    private final Status zzUX;
    private final List zzaAG;

    SessionStopResult(int i, Status status, List list) {
        this.mVersionCode = i;
        this.zzUX = status;
        this.zzaAG = Collections.unmodifiableList(list);
    }

    public SessionStopResult(Status status, List list) {
        this.mVersionCode = 3;
        this.zzUX = status;
        this.zzaAG = Collections.unmodifiableList(list);
    }

    public static SessionStopResult zzV(Status status) {
        return new SessionStopResult(status, Collections.emptyList());
    }

    private boolean zzb(SessionStopResult sessionStopResult) {
        return this.zzUX.equals(sessionStopResult.zzUX) && zzw.equal(this.zzaAG, sessionStopResult.zzaAG);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionStopResult) && zzb((SessionStopResult) obj));
    }

    public List getSessions() {
        return this.zzaAG;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzaAG);
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", this.zzUX).zzg("sessions", this.zzaAG).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
