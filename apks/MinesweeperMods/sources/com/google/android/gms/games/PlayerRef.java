package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

/* loaded from: classes2.dex */
public final class PlayerRef extends zzc implements Player {
    private final PlayerLevelInfo zzaCS;
    private final PlayerColumnNames zzaDh;
    private final MostRecentGameInfoRef zzaDi;

    public PlayerRef(DataHolder dataHolder, int i) {
        this(dataHolder, i, null);
    }

    public PlayerRef(DataHolder dataHolder, int i, String str) {
        super(dataHolder, i);
        this.zzaDh = new PlayerColumnNames(str);
        this.zzaDi = new MostRecentGameInfoRef(dataHolder, i, this.zzaDh);
        if (!zzvJ()) {
            this.zzaCS = null;
            return;
        }
        int integer = getInteger(this.zzaDh.zzaIC);
        int integer2 = getInteger(this.zzaDh.zzaIF);
        PlayerLevel playerLevel = new PlayerLevel(integer, getLong(this.zzaDh.zzaID), getLong(this.zzaDh.zzaIE));
        this.zzaCS = new PlayerLevelInfo(getLong(this.zzaDh.zzaIB), getLong(this.zzaDh.zzaIH), playerLevel, integer != integer2 ? new PlayerLevel(integer2, getLong(this.zzaDh.zzaIE), getLong(this.zzaDh.zzaIG)) : playerLevel);
    }

    private boolean zzvJ() {
        return (zzcB(this.zzaDh.zzaIB) || getLong(this.zzaDh.zzaIB) == -1) ? false : true;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public final boolean equals(Object obj) {
        return PlayerEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final Player freeze() {
        return new PlayerEntity(this);
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImageLandscapeUri() {
        return zzcA(this.zzaDh.zzaIS);
    }

    @Override // com.google.android.gms.games.Player
    public final String getBannerImageLandscapeUrl() {
        return getString(this.zzaDh.zzaIT);
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImagePortraitUri() {
        return zzcA(this.zzaDh.zzaIU);
    }

    @Override // com.google.android.gms.games.Player
    public final String getBannerImagePortraitUrl() {
        return getString(this.zzaDh.zzaIV);
    }

    @Override // com.google.android.gms.games.Player
    public final String getDisplayName() {
        return getString(this.zzaDh.zzaIt);
    }

    @Override // com.google.android.gms.games.Player
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        zza(this.zzaDh.zzaIt, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getHiResImageUri() {
        return zzcA(this.zzaDh.zzaIw);
    }

    @Override // com.google.android.gms.games.Player
    public final String getHiResImageUrl() {
        return getString(this.zzaDh.zzaIx);
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getIconImageUri() {
        return zzcA(this.zzaDh.zzaIu);
    }

    @Override // com.google.android.gms.games.Player
    public final String getIconImageUrl() {
        return getString(this.zzaDh.zzaIv);
    }

    @Override // com.google.android.gms.games.Player
    public final long getLastPlayedWithTimestamp() {
        if (!zzcz(this.zzaDh.zzaIA) || zzcB(this.zzaDh.zzaIA)) {
            return -1L;
        }
        return getLong(this.zzaDh.zzaIA);
    }

    @Override // com.google.android.gms.games.Player
    public final PlayerLevelInfo getLevelInfo() {
        return this.zzaCS;
    }

    @Override // com.google.android.gms.games.Player
    public final String getName() {
        return getString(this.zzaDh.name);
    }

    @Override // com.google.android.gms.games.Player
    public final String getPlayerId() {
        return getString(this.zzaDh.zzaIs);
    }

    @Override // com.google.android.gms.games.Player
    public final long getRetrievedTimestamp() {
        return getLong(this.zzaDh.zzaIy);
    }

    @Override // com.google.android.gms.games.Player
    public final String getTitle() {
        return getString(this.zzaDh.title);
    }

    @Override // com.google.android.gms.games.Player
    public final void getTitle(CharArrayBuffer charArrayBuffer) {
        zza(this.zzaDh.title, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    @Override // com.google.android.gms.common.data.zzc
    public final int hashCode() {
        return PlayerEntity.zzb(this);
    }

    public final String toString() {
        return PlayerEntity.zzc(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((PlayerEntity) freeze()).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.Player
    public final String zzvE() {
        return getString(this.zzaDh.zzaIR);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzvF() {
        return getBoolean(this.zzaDh.zzaIQ);
    }

    @Override // com.google.android.gms.games.Player
    public final int zzvG() {
        return getInteger(this.zzaDh.zzaIz);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzvH() {
        return getBoolean(this.zzaDh.zzaIJ);
    }

    @Override // com.google.android.gms.games.Player
    public final MostRecentGameInfo zzvI() {
        if (zzcB(this.zzaDh.zzaIK)) {
            return null;
        }
        return this.zzaDi;
    }
}
