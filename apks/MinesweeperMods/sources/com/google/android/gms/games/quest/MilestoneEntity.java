package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public final class MilestoneEntity implements SafeParcelable, Milestone {
    public static final Parcelable.Creator CREATOR = new MilestoneEntityCreator();
    private final int mState;
    private final int mVersionCode;
    private final String zzaDU;
    private final String zzaFd;
    private final long zzaKt;
    private final long zzaKu;
    private final byte[] zzaKv;

    MilestoneEntity(int i, String str, long j, long j2, byte[] bArr, int i2, String str2) {
        this.mVersionCode = i;
        this.zzaFd = str;
        this.zzaKt = j;
        this.zzaKu = j2;
        this.zzaKv = bArr;
        this.mState = i2;
        this.zzaDU = str2;
    }

    public MilestoneEntity(Milestone milestone) {
        this.mVersionCode = 4;
        this.zzaFd = milestone.getMilestoneId();
        this.zzaKt = milestone.getCurrentProgress();
        this.zzaKu = milestone.getTargetProgress();
        this.mState = milestone.getState();
        this.zzaDU = milestone.getEventId();
        byte[] completionRewardData = milestone.getCompletionRewardData();
        if (completionRewardData == null) {
            this.zzaKv = null;
        } else {
            this.zzaKv = new byte[completionRewardData.length];
            System.arraycopy(completionRewardData, 0, this.zzaKv, 0, completionRewardData.length);
        }
    }

    static int zza(Milestone milestone) {
        return zzw.hashCode(milestone.getMilestoneId(), Long.valueOf(milestone.getCurrentProgress()), Long.valueOf(milestone.getTargetProgress()), Integer.valueOf(milestone.getState()), milestone.getEventId());
    }

    static boolean zza(Milestone milestone, Object obj) {
        if (!(obj instanceof Milestone)) {
            return false;
        }
        if (milestone == obj) {
            return true;
        }
        Milestone milestone2 = (Milestone) obj;
        return zzw.equal(milestone2.getMilestoneId(), milestone.getMilestoneId()) && zzw.equal(Long.valueOf(milestone2.getCurrentProgress()), Long.valueOf(milestone.getCurrentProgress())) && zzw.equal(Long.valueOf(milestone2.getTargetProgress()), Long.valueOf(milestone.getTargetProgress())) && zzw.equal(Integer.valueOf(milestone2.getState()), Integer.valueOf(milestone.getState())) && zzw.equal(milestone2.getEventId(), milestone.getEventId());
    }

    static String zzb(Milestone milestone) {
        return zzw.zzy(milestone).zzg("MilestoneId", milestone.getMilestoneId()).zzg("CurrentProgress", Long.valueOf(milestone.getCurrentProgress())).zzg("TargetProgress", Long.valueOf(milestone.getTargetProgress())).zzg("State", Integer.valueOf(milestone.getState())).zzg("CompletionRewardData", milestone.getCompletionRewardData()).zzg("EventId", milestone.getEventId()).toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final Milestone freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final byte[] getCompletionRewardData() {
        return this.zzaKv;
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final long getCurrentProgress() {
        return this.zzaKt;
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final String getEventId() {
        return this.zzaDU;
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final String getMilestoneId() {
        return this.zzaFd;
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final int getState() {
        return this.mState;
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final long getTargetProgress() {
        return this.zzaKu;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        MilestoneEntityCreator.zza(this, parcel, i);
    }
}
