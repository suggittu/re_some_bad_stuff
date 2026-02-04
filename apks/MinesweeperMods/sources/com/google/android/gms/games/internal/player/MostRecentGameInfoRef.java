package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

/* loaded from: classes2.dex */
public final class MostRecentGameInfoRef extends zzc implements MostRecentGameInfo {
    private final PlayerColumnNames zzaDh;

    public MostRecentGameInfoRef(DataHolder dataHolder, int i, PlayerColumnNames playerColumnNames) {
        super(dataHolder, i);
        this.zzaDh = playerColumnNames;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public final boolean equals(Object obj) {
        return MostRecentGameInfoEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.common.data.zzc
    public final int hashCode() {
        return MostRecentGameInfoEntity.zza(this);
    }

    public final String toString() {
        return MostRecentGameInfoEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((MostRecentGameInfoEntity) freeze()).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public final long zzxA() {
        return getLong(this.zzaDh.zzaIM);
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public final Uri zzxB() {
        return zzcA(this.zzaDh.zzaIN);
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public final Uri zzxC() {
        return zzcA(this.zzaDh.zzaIO);
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public final Uri zzxD() {
        return zzcA(this.zzaDh.zzaIP);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzxE, reason: merged with bridge method [inline-methods] */
    public final MostRecentGameInfo freeze() {
        return new MostRecentGameInfoEntity(this);
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public final String zzxy() {
        return getString(this.zzaDh.zzaIK);
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public final String zzxz() {
        return getString(this.zzaDh.zzaIL);
    }
}
