package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;

/* loaded from: classes2.dex */
public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final String zzaJA;
    private final String zzaJB;
    private final String zzaJC;
    private final int zzaJr;
    private final int zzaJs;
    private final boolean zzaJt;
    private final long zzaJu;
    private final String zzaJv;
    private final long zzaJw;
    private final String zzaJx;
    private final String zzaJy;
    private final long zzaJz;

    public LeaderboardVariantEntity(LeaderboardVariant leaderboardVariant) {
        this.zzaJr = leaderboardVariant.getTimeSpan();
        this.zzaJs = leaderboardVariant.getCollection();
        this.zzaJt = leaderboardVariant.hasPlayerInfo();
        this.zzaJu = leaderboardVariant.getRawPlayerScore();
        this.zzaJv = leaderboardVariant.getDisplayPlayerScore();
        this.zzaJw = leaderboardVariant.getPlayerRank();
        this.zzaJx = leaderboardVariant.getDisplayPlayerRank();
        this.zzaJy = leaderboardVariant.getPlayerScoreTag();
        this.zzaJz = leaderboardVariant.getNumScores();
        this.zzaJA = leaderboardVariant.zzxL();
        this.zzaJB = leaderboardVariant.zzxM();
        this.zzaJC = leaderboardVariant.zzxN();
    }

    static int zza(LeaderboardVariant leaderboardVariant) {
        return zzw.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.zzxL(), leaderboardVariant.zzxN(), leaderboardVariant.zzxM());
    }

    static boolean zza(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return zzw.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && zzw.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && zzw.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && zzw.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && zzw.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && zzw.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && zzw.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && zzw.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && zzw.equal(leaderboardVariant2.zzxL(), leaderboardVariant.zzxL()) && zzw.equal(leaderboardVariant2.zzxN(), leaderboardVariant.zzxN()) && zzw.equal(leaderboardVariant2.zzxM(), leaderboardVariant.zzxM());
    }

    static String zzb(LeaderboardVariant leaderboardVariant) {
        return zzw.zzy(leaderboardVariant).zzg("TimeSpan", TimeSpan.zzgw(leaderboardVariant.getTimeSpan())).zzg("Collection", LeaderboardCollection.zzgw(leaderboardVariant.getCollection())).zzg("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").zzg("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").zzg("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").zzg("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").zzg("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).zzg("TopPageNextToken", leaderboardVariant.zzxL()).zzg("WindowPageNextToken", leaderboardVariant.zzxN()).zzg("WindowPagePrevToken", leaderboardVariant.zzxM()).toString();
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final int getCollection() {
        return this.zzaJs;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getDisplayPlayerRank() {
        return this.zzaJx;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getDisplayPlayerScore() {
        return this.zzaJv;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getNumScores() {
        return this.zzaJz;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getPlayerRank() {
        return this.zzaJw;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getPlayerScoreTag() {
        return this.zzaJy;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getRawPlayerScore() {
        return this.zzaJu;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final int getTimeSpan() {
        return this.zzaJr;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final boolean hasPlayerInfo() {
        return this.zzaJt;
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

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzxL() {
        return this.zzaJA;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzxM() {
        return this.zzaJB;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzxN() {
        return this.zzaJC;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzxO, reason: merged with bridge method [inline-methods] */
    public final LeaderboardVariant freeze() {
        return this;
    }
}
