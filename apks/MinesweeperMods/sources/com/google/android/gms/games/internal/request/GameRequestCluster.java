package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GameRequestCluster implements SafeParcelable, GameRequest {
    public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();
    private final int mVersionCode;
    private final ArrayList zzaIW;

    GameRequestCluster(int i, ArrayList arrayList) {
        this.mVersionCode = i;
        this.zzaIW = arrayList;
        zzxr();
    }

    private void zzxr() {
        zzb.zzab(!this.zzaIW.isEmpty());
        GameRequest gameRequest = (GameRequest) this.zzaIW.get(0);
        int size = this.zzaIW.size();
        for (int i = 1; i < size; i++) {
            GameRequest gameRequest2 = (GameRequest) this.zzaIW.get(i);
            zzb.zza(gameRequest.getType() == gameRequest2.getType(), "All the requests must be of the same type");
            zzb.zza(gameRequest.getSender().equals(gameRequest2.getSender()), "All the requests must be from the same sender");
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GameRequestCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        GameRequestCluster gameRequestCluster = (GameRequestCluster) obj;
        if (gameRequestCluster.zzaIW.size() != this.zzaIW.size()) {
            return false;
        }
        int size = this.zzaIW.size();
        for (int i = 0; i < size; i++) {
            if (!((GameRequest) this.zzaIW.get(i)).equals((GameRequest) gameRequestCluster.zzaIW.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final GameRequest freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final byte[] getData() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final long getExpirationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final int getRecipientStatus(String str) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final String getRequestId() {
        return ((GameRequestEntity) this.zzaIW.get(0)).getRequestId();
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final Player getSender() {
        return ((GameRequestEntity) this.zzaIW.get(0)).getSender();
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final int getStatus() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final int getType() {
        return ((GameRequestEntity) this.zzaIW.get(0)).getType();
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zzw.hashCode(this.zzaIW.toArray());
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final boolean isConsumed(String str) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        GameRequestClusterCreator.zza(this, parcel, i);
    }

    public final ArrayList zzxF() {
        return new ArrayList(this.zzaIW);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    /* renamed from: zzxG, reason: merged with bridge method [inline-methods] */
    public final ArrayList getRecipients() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
}
