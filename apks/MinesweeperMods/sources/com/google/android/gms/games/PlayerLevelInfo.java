package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public final class PlayerLevelInfo implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new PlayerLevelInfoCreator();
    private final int mVersionCode;
    private final long zzaDd;
    private final long zzaDe;
    private final PlayerLevel zzaDf;
    private final PlayerLevel zzaDg;

    PlayerLevelInfo(int i, long j, long j2, PlayerLevel playerLevel, PlayerLevel playerLevel2) {
        zzx.zzab(j != -1);
        zzx.zzz(playerLevel);
        zzx.zzz(playerLevel2);
        this.mVersionCode = i;
        this.zzaDd = j;
        this.zzaDe = j2;
        this.zzaDf = playerLevel;
        this.zzaDg = playerLevel2;
    }

    public PlayerLevelInfo(long j, long j2, PlayerLevel playerLevel, PlayerLevel playerLevel2) {
        this(1, j, j2, playerLevel, playerLevel2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return zzw.equal(Long.valueOf(this.zzaDd), Long.valueOf(playerLevelInfo.zzaDd)) && zzw.equal(Long.valueOf(this.zzaDe), Long.valueOf(playerLevelInfo.zzaDe)) && zzw.equal(this.zzaDf, playerLevelInfo.zzaDf) && zzw.equal(this.zzaDg, playerLevelInfo.zzaDg);
    }

    public final PlayerLevel getCurrentLevel() {
        return this.zzaDf;
    }

    public final long getCurrentXpTotal() {
        return this.zzaDd;
    }

    public final long getLastLevelUpTimestamp() {
        return this.zzaDe;
    }

    public final PlayerLevel getNextLevel() {
        return this.zzaDg;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzaDd), Long.valueOf(this.zzaDe), this.zzaDf, this.zzaDg);
    }

    public final boolean isMaxLevel() {
        return this.zzaDf.equals(this.zzaDg);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        PlayerLevelInfoCreator.zza(this, parcel, i);
    }
}
