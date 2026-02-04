package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class SessionReadResult implements Result, SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzj();
    private final int mVersionCode;
    private final Status zzUX;
    private final List zzaAG;
    private final List zzaBO;

    SessionReadResult(int i, List list, List list2, Status status) {
        this.mVersionCode = i;
        this.zzaAG = list;
        this.zzaBO = Collections.unmodifiableList(list2);
        this.zzUX = status;
    }

    public SessionReadResult(List list, List list2, Status status) {
        this.mVersionCode = 3;
        this.zzaAG = list;
        this.zzaBO = Collections.unmodifiableList(list2);
        this.zzUX = status;
    }

    public static SessionReadResult zzU(Status status) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    private boolean zzb(SessionReadResult sessionReadResult) {
        return this.zzUX.equals(sessionReadResult.zzUX) && zzw.equal(this.zzaAG, sessionReadResult.zzaAG) && zzw.equal(this.zzaBO, sessionReadResult.zzaBO);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionReadResult) && zzb((SessionReadResult) obj));
    }

    public List getDataSet(Session session) {
        zzx.zzb(this.zzaAG.contains(session), "Attempting to read data for session %s which was not returned", session);
        ArrayList arrayList = new ArrayList();
        for (SessionDataSet sessionDataSet : this.zzaBO) {
            if (zzw.equal(session, sessionDataSet.getSession())) {
                arrayList.add(sessionDataSet.getDataSet());
            }
        }
        return arrayList;
    }

    public List getDataSet(Session session, DataType dataType) {
        zzx.zzb(this.zzaAG.contains(session), "Attempting to read data for session %s which was not returned", session);
        ArrayList arrayList = new ArrayList();
        for (SessionDataSet sessionDataSet : this.zzaBO) {
            if (zzw.equal(session, sessionDataSet.getSession()) && dataType.equals(sessionDataSet.getDataSet().getDataType())) {
                arrayList.add(sessionDataSet.getDataSet());
            }
        }
        return arrayList;
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
        return zzw.hashCode(this.zzUX, this.zzaAG, this.zzaBO);
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", this.zzUX).zzg("sessions", this.zzaAG).zzg("sessionDataSets", this.zzaBO).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public List zzvp() {
        return this.zzaBO;
    }
}
