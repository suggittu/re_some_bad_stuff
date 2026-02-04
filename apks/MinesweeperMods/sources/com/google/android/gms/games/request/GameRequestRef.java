package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class GameRequestRef extends zzc implements GameRequest {
    private final int zzaDQ;

    public GameRequestRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaDQ = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public final boolean equals(Object obj) {
        return GameRequestEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final GameRequest freeze() {
        return new GameRequestEntity(this);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final byte[] getData() {
        return getByteArray("data");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final long getExpirationTimestamp() {
        return getLong("expiration_timestamp");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final Game getGame() {
        return new GameRef(this.zzahi, this.zzaje);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final int getRecipientStatus(String str) {
        for (int i = this.zzaje; i < this.zzaje + this.zzaDQ; i++) {
            int iZzbH = this.zzahi.zzbH(i);
            if (this.zzahi.zzd("recipient_external_player_id", i, iZzbH).equals(str)) {
                return this.zzahi.zzc("recipient_status", i, iZzbH);
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final List getRecipients() {
        ArrayList arrayList = new ArrayList(this.zzaDQ);
        for (int i = 0; i < this.zzaDQ; i++) {
            arrayList.add(new PlayerRef(this.zzahi, this.zzaje + i, "recipient_"));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final String getRequestId() {
        return getString("external_request_id");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final Player getSender() {
        return new PlayerRef(this.zzahi, zzqc(), "sender_");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final int getStatus() {
        return getInteger("status");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final int getType() {
        return getInteger("type");
    }

    @Override // com.google.android.gms.common.data.zzc
    public final int hashCode() {
        return GameRequestEntity.zza(this);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final boolean isConsumed(String str) {
        return getRecipientStatus(str) == 1;
    }

    public final String toString() {
        return GameRequestEntity.zzc(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((GameRequestEntity) freeze()).writeToParcel(parcel, i);
    }
}
