package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* loaded from: classes2.dex */
public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
    public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();
    private final int mVersionCode;
    private Uri zzaCd;
    private int zzabB;
    private String zzapg;
    private String zzaxl;

    final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
        GameBadgeEntityCreatorCompat() {
        }

        @Override // com.google.android.gms.games.internal.game.GameBadgeEntityCreator, android.os.Parcelable.Creator
        /* renamed from: zzen */
        public final GameBadgeEntity createFromParcel(Parcel parcel) {
            if (GameBadgeEntity.zzd(GameBadgeEntity.zzqB()) || GameBadgeEntity.zzcF(GameBadgeEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            int i = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            return new GameBadgeEntity(1, i, string, string2, string3 == null ? null : Uri.parse(string3));
        }
    }

    GameBadgeEntity(int i, int i2, String str, String str2, Uri uri) {
        this.mVersionCode = i;
        this.zzabB = i2;
        this.zzapg = str;
        this.zzaxl = str2;
        this.zzaCd = uri;
    }

    public GameBadgeEntity(GameBadge gameBadge) {
        this.mVersionCode = 1;
        this.zzabB = gameBadge.getType();
        this.zzapg = gameBadge.getTitle();
        this.zzaxl = gameBadge.getDescription();
        this.zzaCd = gameBadge.getIconImageUri();
    }

    static int zza(GameBadge gameBadge) {
        return zzw.hashCode(Integer.valueOf(gameBadge.getType()), gameBadge.getTitle(), gameBadge.getDescription(), gameBadge.getIconImageUri());
    }

    static boolean zza(GameBadge gameBadge, Object obj) {
        if (!(obj instanceof GameBadge)) {
            return false;
        }
        if (gameBadge == obj) {
            return true;
        }
        GameBadge gameBadge2 = (GameBadge) obj;
        return zzw.equal(Integer.valueOf(gameBadge2.getType()), gameBadge.getTitle()) && zzw.equal(gameBadge2.getDescription(), gameBadge.getIconImageUri());
    }

    static String zzb(GameBadge gameBadge) {
        return zzw.zzy(gameBadge).zzg("Type", Integer.valueOf(gameBadge.getType())).zzg("Title", gameBadge.getTitle()).zzg("Description", gameBadge.getDescription()).zzg("IconImageUri", gameBadge.getIconImageUri()).toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public final String getDescription() {
        return this.zzaxl;
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public final Uri getIconImageUri() {
        return this.zzaCd;
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public final String getTitle() {
        return this.zzapg;
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public final int getType() {
        return this.zzabB;
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
        if (!zzqC()) {
            GameBadgeEntityCreator.zza(this, parcel, i);
            return;
        }
        parcel.writeInt(this.zzabB);
        parcel.writeString(this.zzapg);
        parcel.writeString(this.zzaxl);
        parcel.writeString(this.zzaCd == null ? null : this.zzaCd.toString());
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzxm, reason: merged with bridge method [inline-methods] */
    public final GameBadge freeze() {
        return this;
    }
}
