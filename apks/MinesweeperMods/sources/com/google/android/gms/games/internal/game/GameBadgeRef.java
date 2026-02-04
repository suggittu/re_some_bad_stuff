package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

/* loaded from: classes2.dex */
public final class GameBadgeRef extends zzc implements GameBadge {
    public GameBadgeRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public final boolean equals(Object obj) {
        return GameBadgeEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public final String getDescription() {
        return getString("badge_description");
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public final Uri getIconImageUri() {
        return zzcA("badge_icon_image_uri");
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public final String getTitle() {
        return getString("badge_title");
    }

    @Override // com.google.android.gms.games.internal.game.GameBadge
    public final int getType() {
        return getInteger("badge_type");
    }

    @Override // com.google.android.gms.common.data.zzc
    public final int hashCode() {
        return GameBadgeEntity.zza(this);
    }

    public final String toString() {
        return GameBadgeEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((GameBadgeEntity) freeze()).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzxm, reason: merged with bridge method [inline-methods] */
    public final GameBadge freeze() {
        return new GameBadgeEntity(this);
    }
}
