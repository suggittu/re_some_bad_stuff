package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;

/* loaded from: classes2.dex */
public final class RoomConfigImpl extends RoomConfig {
    private final String zzUO;
    private final int zzaJJ;
    private final RoomUpdateListener zzaJU;
    private final RoomStatusUpdateListener zzaJV;
    private final RealTimeMessageReceivedListener zzaJW;
    private final Bundle zzaJZ;
    private final String[] zzaKa;

    RoomConfigImpl(RoomConfig.Builder builder) {
        this.zzaJU = builder.zzaJU;
        this.zzaJV = builder.zzaJV;
        this.zzaJW = builder.zzaJW;
        this.zzUO = builder.zzaJX;
        this.zzaJJ = builder.zzaJJ;
        this.zzaJZ = builder.zzaJZ;
        this.zzaKa = (String[]) builder.zzaJY.toArray(new String[builder.zzaJY.size()]);
        zzx.zzb(this.zzaJW, "Must specify a message listener");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final Bundle getAutoMatchCriteria() {
        return this.zzaJZ;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final String getInvitationId() {
        return this.zzUO;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final String[] getInvitedPlayerIds() {
        return this.zzaKa;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.zzaJW;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.zzaJV;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final RoomUpdateListener getRoomUpdateListener() {
        return this.zzaJU;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public final int getVariant() {
        return this.zzaJJ;
    }
}
