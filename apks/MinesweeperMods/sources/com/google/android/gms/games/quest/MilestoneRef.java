package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.GamesLog;

/* loaded from: classes2.dex */
public final class MilestoneRef extends zzc implements Milestone {
    MilestoneRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private long zzxQ() {
        return getLong("initial_value");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public final boolean equals(Object obj) {
        return MilestoneEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final Milestone freeze() {
        return new MilestoneEntity(this);
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final byte[] getCompletionRewardData() {
        return getByteArray("completion_reward_data");
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final long getCurrentProgress() {
        long jZzxQ;
        long j = 0;
        switch (getState()) {
            case 1:
                jZzxQ = 0;
                break;
            case 2:
                jZzxQ = getLong("current_value");
                if (getLong("quest_state") != 6) {
                    jZzxQ -= zzxQ();
                    break;
                }
                break;
            case 3:
            case 4:
                jZzxQ = getTargetProgress();
                break;
            default:
                jZzxQ = 0;
                break;
        }
        if (jZzxQ < 0) {
            GamesLog.zzA("MilestoneRef", "Current progress should never be negative");
        } else {
            j = jZzxQ;
        }
        if (j <= getTargetProgress()) {
            return j;
        }
        GamesLog.zzA("MilestoneRef", "Current progress should never exceed target progress");
        return getTargetProgress();
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final String getEventId() {
        return getString("external_event_id");
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final String getMilestoneId() {
        return getString("external_milestone_id");
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final int getState() {
        return getInteger("milestone_state");
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public final long getTargetProgress() {
        return getLong("target_value");
    }

    @Override // com.google.android.gms.common.data.zzc
    public final int hashCode() {
        return MilestoneEntity.zza(this);
    }

    public final String toString() {
        return MilestoneEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((MilestoneEntity) freeze()).writeToParcel(parcel, i);
    }
}
