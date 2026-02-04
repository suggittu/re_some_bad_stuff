package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class ZInvitationCluster implements SafeParcelable, Invitation {
    public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();
    private final int mVersionCode;
    private final ArrayList zzaIl;

    ZInvitationCluster(int i, ArrayList arrayList) {
        this.mVersionCode = i;
        this.zzaIl = arrayList;
        zzxr();
    }

    private void zzxr() {
        zzb.zzab(!this.zzaIl.isEmpty());
        Invitation invitation = (Invitation) this.zzaIl.get(0);
        int size = this.zzaIl.size();
        for (int i = 1; i < size; i++) {
            zzb.zza(invitation.getInviter().equals(((Invitation) this.zzaIl.get(i)).getInviter()), "All the invitations must be from the same inviter");
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ZInvitationCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ZInvitationCluster zInvitationCluster = (ZInvitationCluster) obj;
        if (zInvitationCluster.zzaIl.size() != this.zzaIl.size()) {
            return false;
        }
        int size = this.zzaIl.size();
        for (int i = 0; i < size; i++) {
            if (!((Invitation) this.zzaIl.get(i)).equals((Invitation) zInvitationCluster.zzaIl.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final Invitation freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final int getAvailableAutoMatchSlots() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final String getInvitationId() {
        return ((InvitationEntity) this.zzaIl.get(0)).getInvitationId();
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final int getInvitationType() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final Participant getInviter() {
        return ((InvitationEntity) this.zzaIl.get(0)).getInviter();
    }

    @Override // com.google.android.gms.games.multiplayer.Participatable
    public final ArrayList getParticipants() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final int getVariant() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zzw.hashCode(this.zzaIl.toArray());
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        InvitationClusterCreator.zza(this, parcel, i);
    }

    public final ArrayList zzxs() {
        return new ArrayList(this.zzaIl);
    }
}
