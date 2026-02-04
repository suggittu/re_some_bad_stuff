package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzms;

/* loaded from: classes2.dex */
public final class AchievementEntity implements SafeParcelable, Achievement {
    public static final Parcelable.Creator CREATOR = new AchievementEntityCreator();
    private final String mName;
    private final int mState;
    private final int mVersionCode;
    private final String zzaDj;
    private final Uri zzaDk;
    private final String zzaDl;
    private final Uri zzaDm;
    private final String zzaDn;
    private final int zzaDo;
    private final String zzaDp;
    private final PlayerEntity zzaDq;
    private final int zzaDr;
    private final String zzaDs;
    private final long zzaDt;
    private final long zzaDu;
    private final int zzabB;
    private final String zzaxl;

    AchievementEntity(int i, String str, int i2, String str2, String str3, Uri uri, String str4, Uri uri2, String str5, int i3, String str6, PlayerEntity playerEntity, int i4, int i5, String str7, long j, long j2) {
        this.mVersionCode = i;
        this.zzaDj = str;
        this.zzabB = i2;
        this.mName = str2;
        this.zzaxl = str3;
        this.zzaDk = uri;
        this.zzaDl = str4;
        this.zzaDm = uri2;
        this.zzaDn = str5;
        this.zzaDo = i3;
        this.zzaDp = str6;
        this.zzaDq = playerEntity;
        this.mState = i4;
        this.zzaDr = i5;
        this.zzaDs = str7;
        this.zzaDt = j;
        this.zzaDu = j2;
    }

    public AchievementEntity(Achievement achievement) {
        this.mVersionCode = 1;
        this.zzaDj = achievement.getAchievementId();
        this.zzabB = achievement.getType();
        this.mName = achievement.getName();
        this.zzaxl = achievement.getDescription();
        this.zzaDk = achievement.getUnlockedImageUri();
        this.zzaDl = achievement.getUnlockedImageUrl();
        this.zzaDm = achievement.getRevealedImageUri();
        this.zzaDn = achievement.getRevealedImageUrl();
        this.zzaDq = (PlayerEntity) achievement.getPlayer().freeze();
        this.mState = achievement.getState();
        this.zzaDt = achievement.getLastUpdatedTimestamp();
        this.zzaDu = achievement.getXpValue();
        if (achievement.getType() == 1) {
            this.zzaDo = achievement.getTotalSteps();
            this.zzaDp = achievement.getFormattedTotalSteps();
            this.zzaDr = achievement.getCurrentSteps();
            this.zzaDs = achievement.getFormattedCurrentSteps();
        } else {
            this.zzaDo = 0;
            this.zzaDp = null;
            this.zzaDr = 0;
            this.zzaDs = null;
        }
        zzb.zzv(this.zzaDj);
        zzb.zzv(this.zzaxl);
    }

    static int zza(Achievement achievement) {
        int totalSteps;
        int currentSteps;
        if (achievement.getType() == 1) {
            currentSteps = achievement.getCurrentSteps();
            totalSteps = achievement.getTotalSteps();
        } else {
            totalSteps = 0;
            currentSteps = 0;
        }
        return zzw.hashCode(achievement.getAchievementId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.getPlayer(), Integer.valueOf(currentSteps), Integer.valueOf(totalSteps));
    }

    static boolean zza(Achievement achievement, Object obj) {
        boolean zEqual;
        boolean zEqual2;
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        Achievement achievement2 = (Achievement) obj;
        if (achievement.getType() == 1) {
            zEqual2 = zzw.equal(Integer.valueOf(achievement2.getCurrentSteps()), Integer.valueOf(achievement.getCurrentSteps()));
            zEqual = zzw.equal(Integer.valueOf(achievement2.getTotalSteps()), Integer.valueOf(achievement.getTotalSteps()));
        } else {
            zEqual = true;
            zEqual2 = true;
        }
        return zzw.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && zzw.equal(achievement2.getName(), achievement.getName()) && zzw.equal(Integer.valueOf(achievement2.getType()), Integer.valueOf(achievement.getType())) && zzw.equal(achievement2.getDescription(), achievement.getDescription()) && zzw.equal(Long.valueOf(achievement2.getXpValue()), Long.valueOf(achievement.getXpValue())) && zzw.equal(Integer.valueOf(achievement2.getState()), Integer.valueOf(achievement.getState())) && zzw.equal(Long.valueOf(achievement2.getLastUpdatedTimestamp()), Long.valueOf(achievement.getLastUpdatedTimestamp())) && zzw.equal(achievement2.getPlayer(), achievement.getPlayer()) && zEqual2 && zEqual;
    }

    static String zzb(Achievement achievement) {
        zzw.zza zzaVarZzg = zzw.zzy(achievement).zzg("Id", achievement.getAchievementId()).zzg("Type", Integer.valueOf(achievement.getType())).zzg("Name", achievement.getName()).zzg("Description", achievement.getDescription()).zzg("Player", achievement.getPlayer()).zzg("State", Integer.valueOf(achievement.getState()));
        if (achievement.getType() == 1) {
            zzaVarZzg.zzg("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            zzaVarZzg.zzg("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return zzaVarZzg.toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final Achievement freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getAchievementId() {
        return this.zzaDj;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getCurrentSteps() {
        zzb.zzab(getType() == 1);
        return zzvM();
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getDescription() {
        return this.zzaxl;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        zzms.zzb(this.zzaxl, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getFormattedCurrentSteps() {
        zzb.zzab(getType() == 1);
        return zzvN();
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        zzb.zzab(getType() == 1);
        zzms.zzb(this.zzaDs, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getFormattedTotalSteps() {
        zzb.zzab(getType() == 1);
        return zzvL();
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        zzb.zzab(getType() == 1);
        zzms.zzb(this.zzaDp, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final long getLastUpdatedTimestamp() {
        return this.zzaDt;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getName() {
        return this.mName;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getName(CharArrayBuffer charArrayBuffer) {
        zzms.zzb(this.mName, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Player getPlayer() {
        return this.zzaDq;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Uri getRevealedImageUri() {
        return this.zzaDm;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getRevealedImageUrl() {
        return this.zzaDn;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getState() {
        return this.mState;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getTotalSteps() {
        zzb.zzab(getType() == 1);
        return zzvK();
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getType() {
        return this.zzabB;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Uri getUnlockedImageUri() {
        return this.zzaDk;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getUnlockedImageUrl() {
        return this.zzaDl;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final long getXpValue() {
        return this.zzaDu;
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
        AchievementEntityCreator.zza(this, parcel, i);
    }

    public final int zzvK() {
        return this.zzaDo;
    }

    public final String zzvL() {
        return this.zzaDp;
    }

    public final int zzvM() {
        return this.zzaDr;
    }

    public final String zzvN() {
        return this.zzaDs;
    }
}
