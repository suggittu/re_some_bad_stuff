package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class RoomConfig {

    public final class Builder {
        int zzaJJ;
        final RoomUpdateListener zzaJU;
        RoomStatusUpdateListener zzaJV;
        RealTimeMessageReceivedListener zzaJW;
        String zzaJX;
        ArrayList zzaJY;
        Bundle zzaJZ;

        private Builder(RoomUpdateListener roomUpdateListener) {
            this.zzaJX = null;
            this.zzaJJ = -1;
            this.zzaJY = new ArrayList();
            this.zzaJU = (RoomUpdateListener) zzx.zzb(roomUpdateListener, "Must provide a RoomUpdateListener");
        }

        public final Builder addPlayersToInvite(ArrayList arrayList) {
            zzx.zzz(arrayList);
            this.zzaJY.addAll(arrayList);
            return this;
        }

        public final Builder addPlayersToInvite(String... strArr) {
            zzx.zzz(strArr);
            this.zzaJY.addAll(Arrays.asList(strArr));
            return this;
        }

        public final RoomConfig build() {
            return new RoomConfigImpl(this);
        }

        public final Builder setAutoMatchCriteria(Bundle bundle) {
            this.zzaJZ = bundle;
            return this;
        }

        public final Builder setInvitationIdToAccept(String str) {
            zzx.zzz(str);
            this.zzaJX = str;
            return this;
        }

        public final Builder setMessageReceivedListener(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            this.zzaJW = realTimeMessageReceivedListener;
            return this;
        }

        public final Builder setRoomStatusUpdateListener(RoomStatusUpdateListener roomStatusUpdateListener) {
            this.zzaJV = roomStatusUpdateListener;
            return this;
        }

        public final Builder setVariant(int i) {
            zzx.zzb(i == -1 || i > 0, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
            this.zzaJJ = i;
            return this;
        }
    }

    protected RoomConfig() {
    }

    public static Builder builder(RoomUpdateListener roomUpdateListener) {
        return new Builder(roomUpdateListener);
    }

    public static Bundle createAutoMatchCriteria(int i, int i2, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, i);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, i2);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, j);
        return bundle;
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String getInvitationId();

    public abstract String[] getInvitedPlayerIds();

    public abstract RealTimeMessageReceivedListener getMessageReceivedListener();

    public abstract RoomStatusUpdateListener getRoomStatusUpdateListener();

    public abstract RoomUpdateListener getRoomUpdateListener();

    public abstract int getVariant();
}
