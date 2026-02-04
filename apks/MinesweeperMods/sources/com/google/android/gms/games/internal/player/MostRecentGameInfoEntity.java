package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
    public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
    private final int mVersionCode;
    private final String zzaIm;
    private final String zzaIn;
    private final long zzaIo;
    private final Uri zzaIp;
    private final Uri zzaIq;
    private final Uri zzaIr;

    MostRecentGameInfoEntity(int i, String str, String str2, long j, Uri uri, Uri uri2, Uri uri3) {
        this.mVersionCode = i;
        this.zzaIm = str;
        this.zzaIn = str2;
        this.zzaIo = j;
        this.zzaIp = uri;
        this.zzaIq = uri2;
        this.zzaIr = uri3;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo mostRecentGameInfo) {
        this.mVersionCode = 2;
        this.zzaIm = mostRecentGameInfo.zzxy();
        this.zzaIn = mostRecentGameInfo.zzxz();
        this.zzaIo = mostRecentGameInfo.zzxA();
        this.zzaIp = mostRecentGameInfo.zzxB();
        this.zzaIq = mostRecentGameInfo.zzxC();
        this.zzaIr = mostRecentGameInfo.zzxD();
    }

    static int zza(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.hashCode(mostRecentGameInfo.zzxy(), mostRecentGameInfo.zzxz(), Long.valueOf(mostRecentGameInfo.zzxA()), mostRecentGameInfo.zzxB(), mostRecentGameInfo.zzxC(), mostRecentGameInfo.zzxD());
    }

    static boolean zza(MostRecentGameInfo mostRecentGameInfo, Object obj) {
        if (!(obj instanceof MostRecentGameInfo)) {
            return false;
        }
        if (mostRecentGameInfo == obj) {
            return true;
        }
        MostRecentGameInfo mostRecentGameInfo2 = (MostRecentGameInfo) obj;
        return zzw.equal(mostRecentGameInfo2.zzxy(), mostRecentGameInfo.zzxy()) && zzw.equal(mostRecentGameInfo2.zzxz(), mostRecentGameInfo.zzxz()) && zzw.equal(Long.valueOf(mostRecentGameInfo2.zzxA()), Long.valueOf(mostRecentGameInfo.zzxA())) && zzw.equal(mostRecentGameInfo2.zzxB(), mostRecentGameInfo.zzxB()) && zzw.equal(mostRecentGameInfo2.zzxC(), mostRecentGameInfo.zzxC()) && zzw.equal(mostRecentGameInfo2.zzxD(), mostRecentGameInfo.zzxD());
    }

    static String zzb(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.zzy(mostRecentGameInfo).zzg("GameId", mostRecentGameInfo.zzxy()).zzg("GameName", mostRecentGameInfo.zzxz()).zzg("ActivityTimestampMillis", Long.valueOf(mostRecentGameInfo.zzxA())).zzg("GameIconUri", mostRecentGameInfo.zzxB()).zzg("GameHiResUri", mostRecentGameInfo.zzxC()).zzg("GameFeaturedUri", mostRecentGameInfo.zzxD()).toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
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
        MostRecentGameInfoEntityCreator.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public final long zzxA() {
        return this.zzaIo;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public final Uri zzxB() {
        return this.zzaIp;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public final Uri zzxC() {
        return this.zzaIq;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public final Uri zzxD() {
        return this.zzaIr;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzxE, reason: merged with bridge method [inline-methods] */
    public final MostRecentGameInfo freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public final String zzxy() {
        return this.zzaIm;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public final String zzxz() {
        return this.zzaIn;
    }
}
