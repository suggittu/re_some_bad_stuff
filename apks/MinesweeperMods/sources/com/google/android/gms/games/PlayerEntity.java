package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.zzms;

/* loaded from: classes2.dex */
public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Parcelable.Creator CREATOR = new PlayerEntityCreatorCompat();
    private final String mName;
    private final int mVersionCode;
    private String zzWQ;
    private final long zzaCO;
    private final int zzaCP;
    private final long zzaCQ;
    private final MostRecentGameInfoEntity zzaCR;
    private final PlayerLevelInfo zzaCS;
    private final boolean zzaCT;
    private final boolean zzaCU;
    private final String zzaCV;
    private final Uri zzaCW;
    private final String zzaCX;
    private final Uri zzaCY;
    private final String zzaCZ;
    private final Uri zzaCd;
    private final Uri zzaCe;
    private final String zzaCo;
    private final String zzaCp;
    private String zzacX;
    private final String zzapg;

    final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
        PlayerEntityCreatorCompat() {
        }

        @Override // com.google.android.gms.games.PlayerEntityCreator, android.os.Parcelable.Creator
        /* renamed from: zzeb, reason: merged with bridge method [inline-methods] */
        public final PlayerEntity createFromParcel(Parcel parcel) {
            if (PlayerEntity.zzd(PlayerEntity.zzqB()) || PlayerEntity.zzcF(PlayerEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            return new PlayerEntity(13, string, string2, string3 == null ? null : Uri.parse(string3), string4 == null ? null : Uri.parse(string4), parcel.readLong(), -1, -1L, null, null, null, null, null, true, false, parcel.readString(), parcel.readString(), null, null, null, null);
        }
    }

    PlayerEntity(int i, String str, String str2, Uri uri, Uri uri2, long j, int i2, long j2, String str3, String str4, String str5, MostRecentGameInfoEntity mostRecentGameInfoEntity, PlayerLevelInfo playerLevelInfo, boolean z, boolean z2, String str6, String str7, Uri uri3, String str8, Uri uri4, String str9) {
        this.mVersionCode = i;
        this.zzacX = str;
        this.zzWQ = str2;
        this.zzaCd = uri;
        this.zzaCo = str3;
        this.zzaCe = uri2;
        this.zzaCp = str4;
        this.zzaCO = j;
        this.zzaCP = i2;
        this.zzaCQ = j2;
        this.zzapg = str5;
        this.zzaCT = z;
        this.zzaCR = mostRecentGameInfoEntity;
        this.zzaCS = playerLevelInfo;
        this.zzaCU = z2;
        this.zzaCV = str6;
        this.mName = str7;
        this.zzaCW = uri3;
        this.zzaCX = str8;
        this.zzaCY = uri4;
        this.zzaCZ = str9;
    }

    public PlayerEntity(Player player) {
        this(player, true);
    }

    public PlayerEntity(Player player, boolean z) {
        this.mVersionCode = 13;
        this.zzacX = z ? player.getPlayerId() : null;
        this.zzWQ = player.getDisplayName();
        this.zzaCd = player.getIconImageUri();
        this.zzaCo = player.getIconImageUrl();
        this.zzaCe = player.getHiResImageUri();
        this.zzaCp = player.getHiResImageUrl();
        this.zzaCO = player.getRetrievedTimestamp();
        this.zzaCP = player.zzvG();
        this.zzaCQ = player.getLastPlayedWithTimestamp();
        this.zzapg = player.getTitle();
        this.zzaCT = player.zzvH();
        MostRecentGameInfo mostRecentGameInfoZzvI = player.zzvI();
        this.zzaCR = mostRecentGameInfoZzvI != null ? new MostRecentGameInfoEntity(mostRecentGameInfoZzvI) : null;
        this.zzaCS = player.getLevelInfo();
        this.zzaCU = player.zzvF();
        this.zzaCV = player.zzvE();
        this.mName = player.getName();
        this.zzaCW = player.getBannerImageLandscapeUri();
        this.zzaCX = player.getBannerImageLandscapeUrl();
        this.zzaCY = player.getBannerImagePortraitUri();
        this.zzaCZ = player.getBannerImagePortraitUrl();
        if (z) {
            zzb.zzv(this.zzacX);
        }
        zzb.zzv(this.zzWQ);
        zzb.zzab(this.zzaCO > 0);
    }

    static boolean zza(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return zzw.equal(player2.getPlayerId(), player.getPlayerId()) && zzw.equal(player2.getDisplayName(), player.getDisplayName()) && zzw.equal(Boolean.valueOf(player2.zzvF()), Boolean.valueOf(player.zzvF())) && zzw.equal(player2.getIconImageUri(), player.getIconImageUri()) && zzw.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && zzw.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && zzw.equal(player2.getTitle(), player.getTitle()) && zzw.equal(player2.getLevelInfo(), player.getLevelInfo()) && zzw.equal(player2.zzvE(), player.zzvE()) && zzw.equal(player2.getName(), player.getName()) && zzw.equal(player2.getBannerImageLandscapeUri(), player.getBannerImageLandscapeUri()) && zzw.equal(player2.getBannerImagePortraitUri(), player.getBannerImagePortraitUri());
    }

    static int zzb(Player player) {
        return zzw.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzvF()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zzvE(), player.getName(), player.getBannerImageLandscapeUri(), player.getBannerImagePortraitUri());
    }

    static String zzc(Player player) {
        return zzw.zzy(player).zzg("PlayerId", player.getPlayerId()).zzg("DisplayName", player.getDisplayName()).zzg("HasDebugAccess", Boolean.valueOf(player.zzvF())).zzg("IconImageUri", player.getIconImageUri()).zzg("IconImageUrl", player.getIconImageUrl()).zzg("HiResImageUri", player.getHiResImageUri()).zzg("HiResImageUrl", player.getHiResImageUrl()).zzg("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).zzg("Title", player.getTitle()).zzg("LevelInfo", player.getLevelInfo()).zzg("GamerTag", player.zzvE()).zzg("Name", player.getName()).zzg("BannerImageLandscapeUri", player.getBannerImageLandscapeUri()).zzg("BannerImageLandscapeUrl", player.getBannerImageLandscapeUrl()).zzg("BannerImagePortraitUri", player.getBannerImagePortraitUri()).zzg("BannerImagePortraitUrl", player.getBannerImagePortraitUrl()).toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final Player freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImageLandscapeUri() {
        return this.zzaCW;
    }

    @Override // com.google.android.gms.games.Player
    public final String getBannerImageLandscapeUrl() {
        return this.zzaCX;
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImagePortraitUri() {
        return this.zzaCY;
    }

    @Override // com.google.android.gms.games.Player
    public final String getBannerImagePortraitUrl() {
        return this.zzaCZ;
    }

    @Override // com.google.android.gms.games.Player
    public final String getDisplayName() {
        return this.zzWQ;
    }

    @Override // com.google.android.gms.games.Player
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        zzms.zzb(this.zzWQ, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getHiResImageUri() {
        return this.zzaCe;
    }

    @Override // com.google.android.gms.games.Player
    public final String getHiResImageUrl() {
        return this.zzaCp;
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getIconImageUri() {
        return this.zzaCd;
    }

    @Override // com.google.android.gms.games.Player
    public final String getIconImageUrl() {
        return this.zzaCo;
    }

    @Override // com.google.android.gms.games.Player
    public final long getLastPlayedWithTimestamp() {
        return this.zzaCQ;
    }

    @Override // com.google.android.gms.games.Player
    public final PlayerLevelInfo getLevelInfo() {
        return this.zzaCS;
    }

    @Override // com.google.android.gms.games.Player
    public final String getName() {
        return this.mName;
    }

    @Override // com.google.android.gms.games.Player
    public final String getPlayerId() {
        return this.zzacX;
    }

    @Override // com.google.android.gms.games.Player
    public final long getRetrievedTimestamp() {
        return this.zzaCO;
    }

    @Override // com.google.android.gms.games.Player
    public final String getTitle() {
        return this.zzapg;
    }

    @Override // com.google.android.gms.games.Player
    public final void getTitle(CharArrayBuffer charArrayBuffer) {
        zzms.zzb(this.zzapg, charArrayBuffer);
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public final int hashCode() {
        return zzb(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzc(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (!zzqC()) {
            PlayerEntityCreator.zza(this, parcel, i);
            return;
        }
        parcel.writeString(this.zzacX);
        parcel.writeString(this.zzWQ);
        parcel.writeString(this.zzaCd == null ? null : this.zzaCd.toString());
        parcel.writeString(this.zzaCe != null ? this.zzaCe.toString() : null);
        parcel.writeLong(this.zzaCO);
    }

    @Override // com.google.android.gms.games.Player
    public final String zzvE() {
        return this.zzaCV;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzvF() {
        return this.zzaCU;
    }

    @Override // com.google.android.gms.games.Player
    public final int zzvG() {
        return this.zzaCP;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzvH() {
        return this.zzaCT;
    }

    @Override // com.google.android.gms.games.Player
    public final MostRecentGameInfo zzvI() {
        return this.zzaCR;
    }
}
