package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Parcelable.Creator CREATOR = new InvitationEntityCreatorCompat();
    private final int mVersionCode;
    private final String zzUO;
    private final GameEntity zzaJE;
    private final long zzaJF;
    private final int zzaJG;
    private final ParticipantEntity zzaJH;
    private final ArrayList zzaJI;
    private final int zzaJJ;
    private final int zzaJK;

    final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
        InvitationEntityCreatorCompat() {
        }

        @Override // com.google.android.gms.games.multiplayer.InvitationEntityCreator, android.os.Parcelable.Creator
        /* renamed from: zzer, reason: merged with bridge method [inline-methods] */
        public final InvitationEntity createFromParcel(Parcel parcel) {
            if (InvitationEntity.zzd(InvitationEntity.zzqB()) || InvitationEntity.zzcF(InvitationEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            String string = parcel.readString();
            long j = parcel.readLong();
            int i = parcel.readInt();
            ParticipantEntity participantEntity = (ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(parcel);
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(2, gameEntity, string, j, i, participantEntity, arrayList, -1, 0);
        }
    }

    InvitationEntity(int i, GameEntity gameEntity, String str, long j, int i2, ParticipantEntity participantEntity, ArrayList arrayList, int i3, int i4) {
        this.mVersionCode = i;
        this.zzaJE = gameEntity;
        this.zzUO = str;
        this.zzaJF = j;
        this.zzaJG = i2;
        this.zzaJH = participantEntity;
        this.zzaJI = arrayList;
        this.zzaJJ = i3;
        this.zzaJK = i4;
    }

    InvitationEntity(Invitation invitation) {
        this.mVersionCode = 2;
        this.zzaJE = new GameEntity(invitation.getGame());
        this.zzUO = invitation.getInvitationId();
        this.zzaJF = invitation.getCreationTimestamp();
        this.zzaJG = invitation.getInvitationType();
        this.zzaJJ = invitation.getVariant();
        this.zzaJK = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        Participant participant = null;
        ArrayList participants = invitation.getParticipants();
        int size = participants.size();
        this.zzaJI = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Participant participant2 = (Participant) participants.get(i);
            if (participant2.getParticipantId().equals(participantId)) {
                participant = participant2;
            }
            this.zzaJI.add((ParticipantEntity) participant2.freeze());
        }
        zzx.zzb(participant, "Must have a valid inviter!");
        this.zzaJH = (ParticipantEntity) participant.freeze();
    }

    static int zza(Invitation invitation) {
        return zzw.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static boolean zza(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return zzw.equal(invitation2.getGame(), invitation.getGame()) && zzw.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && zzw.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && zzw.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) && zzw.equal(invitation2.getInviter(), invitation.getInviter()) && zzw.equal(invitation2.getParticipants(), invitation.getParticipants()) && zzw.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) && zzw.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static String zzb(Invitation invitation) {
        return zzw.zzy(invitation).zzg("Game", invitation.getGame()).zzg("InvitationId", invitation.getInvitationId()).zzg("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).zzg("InvitationType", Integer.valueOf(invitation.getInvitationType())).zzg("Inviter", invitation.getInviter()).zzg("Participants", invitation.getParticipants()).zzg("Variant", Integer.valueOf(invitation.getVariant())).zzg("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final Invitation freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final int getAvailableAutoMatchSlots() {
        return this.zzaJK;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final long getCreationTimestamp() {
        return this.zzaJF;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final Game getGame() {
        return this.zzaJE;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final String getInvitationId() {
        return this.zzUO;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final int getInvitationType() {
        return this.zzaJG;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final Participant getInviter() {
        return this.zzaJH;
    }

    @Override // com.google.android.gms.games.multiplayer.Participatable
    public final ArrayList getParticipants() {
        return new ArrayList(this.zzaJI);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitation
    public final int getVariant() {
        return this.zzaJJ;
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
            InvitationEntityCreator.zza(this, parcel, i);
            return;
        }
        this.zzaJE.writeToParcel(parcel, i);
        parcel.writeString(this.zzUO);
        parcel.writeLong(this.zzaJF);
        parcel.writeInt(this.zzaJG);
        this.zzaJH.writeToParcel(parcel, i);
        int size = this.zzaJI.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            ((ParticipantEntity) this.zzaJI.get(i2)).writeToParcel(parcel, i);
        }
    }
}
