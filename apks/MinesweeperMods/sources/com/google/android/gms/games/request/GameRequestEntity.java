package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final Parcelable.Creator CREATOR = new GameRequestEntityCreator();
    private final int mVersionCode;
    private final int zzBc;
    private final String zzEY;
    private final GameEntity zzaJE;
    private final long zzaJF;
    private final PlayerEntity zzaKG;
    private final ArrayList zzaKH;
    private final long zzaKI;
    private final Bundle zzaKJ;
    private final byte[] zzaKm;
    private final int zzabB;

    GameRequestEntity(int i, GameEntity gameEntity, PlayerEntity playerEntity, byte[] bArr, String str, ArrayList arrayList, int i2, long j, long j2, Bundle bundle, int i3) {
        this.mVersionCode = i;
        this.zzaJE = gameEntity;
        this.zzaKG = playerEntity;
        this.zzaKm = bArr;
        this.zzEY = str;
        this.zzaKH = arrayList;
        this.zzabB = i2;
        this.zzaJF = j;
        this.zzaKI = j2;
        this.zzaKJ = bundle;
        this.zzBc = i3;
    }

    public GameRequestEntity(GameRequest gameRequest) {
        this.mVersionCode = 2;
        this.zzaJE = new GameEntity(gameRequest.getGame());
        this.zzaKG = new PlayerEntity(gameRequest.getSender());
        this.zzEY = gameRequest.getRequestId();
        this.zzabB = gameRequest.getType();
        this.zzaJF = gameRequest.getCreationTimestamp();
        this.zzaKI = gameRequest.getExpirationTimestamp();
        this.zzBc = gameRequest.getStatus();
        byte[] data = gameRequest.getData();
        if (data == null) {
            this.zzaKm = null;
        } else {
            this.zzaKm = new byte[data.length];
            System.arraycopy(data, 0, this.zzaKm, 0, data.length);
        }
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        this.zzaKH = new ArrayList(size);
        this.zzaKJ = new Bundle();
        for (int i = 0; i < size; i++) {
            Player player = (Player) ((Player) recipients.get(i)).freeze();
            String playerId = player.getPlayerId();
            this.zzaKH.add((PlayerEntity) player);
            this.zzaKJ.putInt(playerId, gameRequest.getRecipientStatus(playerId));
        }
    }

    static int zza(GameRequest gameRequest) {
        return zzw.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), zzb(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    static boolean zza(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return zzw.equal(gameRequest2.getGame(), gameRequest.getGame()) && zzw.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && zzw.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && zzw.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(zzb(gameRequest2), zzb(gameRequest)) && zzw.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && zzw.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && zzw.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    private static int[] zzb(GameRequest gameRequest) {
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(((Player) recipients.get(i)).getPlayerId());
        }
        return iArr;
    }

    static String zzc(GameRequest gameRequest) {
        return zzw.zzy(gameRequest).zzg("Game", gameRequest.getGame()).zzg("Sender", gameRequest.getSender()).zzg("Recipients", gameRequest.getRecipients()).zzg("Data", gameRequest.getData()).zzg("RequestId", gameRequest.getRequestId()).zzg("Type", Integer.valueOf(gameRequest.getType())).zzg("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).zzg("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final GameRequest freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final long getCreationTimestamp() {
        return this.zzaJF;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final byte[] getData() {
        return this.zzaKm;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final long getExpirationTimestamp() {
        return this.zzaKI;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final Game getGame() {
        return this.zzaJE;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final int getRecipientStatus(String str) {
        return this.zzaKJ.getInt(str, 0);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final List getRecipients() {
        return new ArrayList(this.zzaKH);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final String getRequestId() {
        return this.zzEY;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final Player getSender() {
        return this.zzaKG;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final int getStatus() {
        return this.zzBc;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final int getType() {
        return this.zzabB;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final boolean isConsumed(String str) {
        return getRecipientStatus(str) == 1;
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
        GameRequestEntityCreator.zza(this, parcel, i);
    }

    public final Bundle zzxT() {
        return this.zzaKJ;
    }
}
