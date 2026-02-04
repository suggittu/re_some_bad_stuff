package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public final class PlayerLevel implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new PlayerLevelCreator();
    private final int mVersionCode;
    private final int zzaDa;
    private final long zzaDb;
    private final long zzaDc;

    PlayerLevel(int i, int i2, long j, long j2) {
        zzx.zza(j >= 0, "Min XP must be positive!");
        zzx.zza(j2 > j, "Max XP must be more than min XP!");
        this.mVersionCode = i;
        this.zzaDa = i2;
        this.zzaDb = j;
        this.zzaDc = j2;
    }

    public PlayerLevel(int i, long j, long j2) {
        this(1, i, j, j2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlayerLevel playerLevel = (PlayerLevel) obj;
        return zzw.equal(Integer.valueOf(playerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) && zzw.equal(Long.valueOf(playerLevel.getMinXp()), Long.valueOf(getMinXp())) && zzw.equal(Long.valueOf(playerLevel.getMaxXp()), Long.valueOf(getMaxXp()));
    }

    public final int getLevelNumber() {
        return this.zzaDa;
    }

    public final long getMaxXp() {
        return this.zzaDc;
    }

    public final long getMinXp() {
        return this.zzaDb;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaDa), Long.valueOf(this.zzaDb), Long.valueOf(this.zzaDc));
    }

    public final String toString() {
        return zzw.zzy(this).zzg("LevelNumber", Integer.valueOf(getLevelNumber())).zzg("MinXp", Long.valueOf(getMinXp())).zzg("MaxXp", Long.valueOf(getMaxXp())).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        PlayerLevelCreator.zza(this, parcel, i);
    }
}
