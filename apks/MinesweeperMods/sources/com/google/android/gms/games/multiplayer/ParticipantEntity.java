package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzms;

/* loaded from: classes2.dex */
public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Parcelable.Creator CREATOR = new ParticipantEntityCreatorCompat();
    private final int mVersionCode;
    private final int zzBc;
    private final String zzWQ;
    private final Uri zzaCd;
    private final Uri zzaCe;
    private final String zzaCo;
    private final String zzaCp;
    private final String zzaDX;
    private final PlayerEntity zzaDq;
    private final String zzaFa;
    private final boolean zzaJM;
    private final ParticipantResult zzaJN;
    private final int zzaab;

    final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
        ParticipantEntityCreatorCompat() {
        }

        @Override // com.google.android.gms.games.multiplayer.ParticipantEntityCreator, android.os.Parcelable.Creator
        /* renamed from: zzes, reason: merged with bridge method [inline-methods] */
        public final ParticipantEntity createFromParcel(Parcel parcel) {
            if (ParticipantEntity.zzd(ParticipantEntity.zzqB()) || ParticipantEntity.zzcF(ParticipantEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            Uri uri = string3 == null ? null : Uri.parse(string3);
            String string4 = parcel.readString();
            return new ParticipantEntity(3, string, string2, uri, string4 == null ? null : Uri.parse(string4), parcel.readInt(), parcel.readString(), parcel.readInt() > 0, parcel.readInt() > 0 ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }
    }

    ParticipantEntity(int i, String str, String str2, Uri uri, Uri uri2, int i2, String str3, boolean z, PlayerEntity playerEntity, int i3, ParticipantResult participantResult, String str4, String str5) {
        this.mVersionCode = i;
        this.zzaFa = str;
        this.zzWQ = str2;
        this.zzaCd = uri;
        this.zzaCe = uri2;
        this.zzBc = i2;
        this.zzaDX = str3;
        this.zzaJM = z;
        this.zzaDq = playerEntity;
        this.zzaab = i3;
        this.zzaJN = participantResult;
        this.zzaCo = str4;
        this.zzaCp = str5;
    }

    public ParticipantEntity(Participant participant) {
        this.mVersionCode = 3;
        this.zzaFa = participant.getParticipantId();
        this.zzWQ = participant.getDisplayName();
        this.zzaCd = participant.getIconImageUri();
        this.zzaCe = participant.getHiResImageUri();
        this.zzBc = participant.getStatus();
        this.zzaDX = participant.zzwt();
        this.zzaJM = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.zzaDq = player == null ? null : new PlayerEntity(player);
        this.zzaab = participant.getCapabilities();
        this.zzaJN = participant.getResult();
        this.zzaCo = participant.getIconImageUrl();
        this.zzaCp = participant.getHiResImageUrl();
    }

    static int zza(Participant participant) {
        return zzw.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.zzwt(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    static boolean zza(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return zzw.equal(participant2.getPlayer(), participant.getPlayer()) && zzw.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && zzw.equal(participant2.zzwt(), participant.zzwt()) && zzw.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && zzw.equal(participant2.getDisplayName(), participant.getDisplayName()) && zzw.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && zzw.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && zzw.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && zzw.equal(participant2.getResult(), participant.getResult()) && zzw.equal(participant2.getParticipantId(), participant.getParticipantId());
    }

    static String zzb(Participant participant) {
        return zzw.zzy(participant).zzg("ParticipantId", participant.getParticipantId()).zzg("Player", participant.getPlayer()).zzg("Status", Integer.valueOf(participant.getStatus())).zzg("ClientAddress", participant.zzwt()).zzg("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).zzg("DisplayName", participant.getDisplayName()).zzg("IconImage", participant.getIconImageUri()).zzg("IconImageUrl", participant.getIconImageUrl()).zzg("HiResImage", participant.getHiResImageUri()).zzg("HiResImageUrl", participant.getHiResImageUrl()).zzg("Capabilities", Integer.valueOf(participant.getCapabilities())).zzg("Result", participant.getResult()).toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final Participant freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final int getCapabilities() {
        return this.zzaab;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getDisplayName() {
        return this.zzaDq == null ? this.zzWQ : this.zzaDq.getDisplayName();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        if (this.zzaDq == null) {
            zzms.zzb(this.zzWQ, charArrayBuffer);
        } else {
            this.zzaDq.getDisplayName(charArrayBuffer);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final Uri getHiResImageUri() {
        return this.zzaDq == null ? this.zzaCe : this.zzaDq.getHiResImageUri();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getHiResImageUrl() {
        return this.zzaDq == null ? this.zzaCp : this.zzaDq.getHiResImageUrl();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final Uri getIconImageUri() {
        return this.zzaDq == null ? this.zzaCd : this.zzaDq.getIconImageUri();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getIconImageUrl() {
        return this.zzaDq == null ? this.zzaCo : this.zzaDq.getIconImageUrl();
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String getParticipantId() {
        return this.zzaFa;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final Player getPlayer() {
        return this.zzaDq;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final ParticipantResult getResult() {
        return this.zzaJN;
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final int getStatus() {
        return this.zzBc;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final boolean isConnectedToRoom() {
        return this.zzaJM;
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
            ParticipantEntityCreator.zza(this, parcel, i);
            return;
        }
        parcel.writeString(this.zzaFa);
        parcel.writeString(this.zzWQ);
        parcel.writeString(this.zzaCd == null ? null : this.zzaCd.toString());
        parcel.writeString(this.zzaCe != null ? this.zzaCe.toString() : null);
        parcel.writeInt(this.zzBc);
        parcel.writeString(this.zzaDX);
        parcel.writeInt(this.zzaJM ? 1 : 0);
        parcel.writeInt(this.zzaDq != null ? 1 : 0);
        if (this.zzaDq != null) {
            this.zzaDq.writeToParcel(parcel, i);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.Participant
    public final String zzwt() {
        return this.zzaDX;
    }
}
