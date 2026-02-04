package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zzms;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class QuestEntity implements SafeParcelable, Quest {
    public static final Parcelable.Creator CREATOR = new QuestEntityCreator();
    private final String mName;
    private final int mState;
    private final int mVersionCode;
    private final long zzaDt;
    private final GameEntity zzaJE;
    private final long zzaKA;
    private final Uri zzaKB;
    private final String zzaKC;
    private final long zzaKD;
    private final long zzaKE;
    private final ArrayList zzaKF;
    private final String zzaKw;
    private final long zzaKx;
    private final Uri zzaKy;
    private final String zzaKz;
    private final int zzabB;
    private final String zzaxl;

    QuestEntity(int i, GameEntity gameEntity, String str, long j, Uri uri, String str2, String str3, long j2, long j3, Uri uri2, String str4, String str5, long j4, long j5, int i2, int i3, ArrayList arrayList) {
        this.mVersionCode = i;
        this.zzaJE = gameEntity;
        this.zzaKw = str;
        this.zzaKx = j;
        this.zzaKy = uri;
        this.zzaKz = str2;
        this.zzaxl = str3;
        this.zzaKA = j2;
        this.zzaDt = j3;
        this.zzaKB = uri2;
        this.zzaKC = str4;
        this.mName = str5;
        this.zzaKD = j4;
        this.zzaKE = j5;
        this.mState = i2;
        this.zzabB = i3;
        this.zzaKF = arrayList;
    }

    public QuestEntity(Quest quest) {
        this.mVersionCode = 2;
        this.zzaJE = new GameEntity(quest.getGame());
        this.zzaKw = quest.getQuestId();
        this.zzaKx = quest.getAcceptedTimestamp();
        this.zzaxl = quest.getDescription();
        this.zzaKy = quest.getBannerImageUri();
        this.zzaKz = quest.getBannerImageUrl();
        this.zzaKA = quest.getEndTimestamp();
        this.zzaKB = quest.getIconImageUri();
        this.zzaKC = quest.getIconImageUrl();
        this.zzaDt = quest.getLastUpdatedTimestamp();
        this.mName = quest.getName();
        this.zzaKD = quest.zzxS();
        this.zzaKE = quest.getStartTimestamp();
        this.mState = quest.getState();
        this.zzabB = quest.getType();
        List listZzxR = quest.zzxR();
        int size = listZzxR.size();
        this.zzaKF = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzaKF.add((MilestoneEntity) ((Milestone) listZzxR.get(i)).freeze());
        }
    }

    static int zza(Quest quest) {
        return zzw.hashCode(quest.getGame(), quest.getQuestId(), Long.valueOf(quest.getAcceptedTimestamp()), quest.getBannerImageUri(), quest.getDescription(), Long.valueOf(quest.getEndTimestamp()), quest.getIconImageUri(), Long.valueOf(quest.getLastUpdatedTimestamp()), quest.zzxR(), quest.getName(), Long.valueOf(quest.zzxS()), Long.valueOf(quest.getStartTimestamp()), Integer.valueOf(quest.getState()));
    }

    static boolean zza(Quest quest, Object obj) {
        if (!(obj instanceof Quest)) {
            return false;
        }
        if (quest == obj) {
            return true;
        }
        Quest quest2 = (Quest) obj;
        return zzw.equal(quest2.getGame(), quest.getGame()) && zzw.equal(quest2.getQuestId(), quest.getQuestId()) && zzw.equal(Long.valueOf(quest2.getAcceptedTimestamp()), Long.valueOf(quest.getAcceptedTimestamp())) && zzw.equal(quest2.getBannerImageUri(), quest.getBannerImageUri()) && zzw.equal(quest2.getDescription(), quest.getDescription()) && zzw.equal(Long.valueOf(quest2.getEndTimestamp()), Long.valueOf(quest.getEndTimestamp())) && zzw.equal(quest2.getIconImageUri(), quest.getIconImageUri()) && zzw.equal(Long.valueOf(quest2.getLastUpdatedTimestamp()), Long.valueOf(quest.getLastUpdatedTimestamp())) && zzw.equal(quest2.zzxR(), quest.zzxR()) && zzw.equal(quest2.getName(), quest.getName()) && zzw.equal(Long.valueOf(quest2.zzxS()), Long.valueOf(quest.zzxS())) && zzw.equal(Long.valueOf(quest2.getStartTimestamp()), Long.valueOf(quest.getStartTimestamp())) && zzw.equal(Integer.valueOf(quest2.getState()), Integer.valueOf(quest.getState()));
    }

    static String zzb(Quest quest) {
        return zzw.zzy(quest).zzg("Game", quest.getGame()).zzg("QuestId", quest.getQuestId()).zzg("AcceptedTimestamp", Long.valueOf(quest.getAcceptedTimestamp())).zzg("BannerImageUri", quest.getBannerImageUri()).zzg("BannerImageUrl", quest.getBannerImageUrl()).zzg("Description", quest.getDescription()).zzg("EndTimestamp", Long.valueOf(quest.getEndTimestamp())).zzg("IconImageUri", quest.getIconImageUri()).zzg("IconImageUrl", quest.getIconImageUrl()).zzg("LastUpdatedTimestamp", Long.valueOf(quest.getLastUpdatedTimestamp())).zzg("Milestones", quest.zzxR()).zzg("Name", quest.getName()).zzg("NotifyTimestamp", Long.valueOf(quest.zzxS())).zzg("StartTimestamp", Long.valueOf(quest.getStartTimestamp())).zzg("State", Integer.valueOf(quest.getState())).toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final Quest freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final long getAcceptedTimestamp() {
        return this.zzaKx;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final Uri getBannerImageUri() {
        return this.zzaKy;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final String getBannerImageUrl() {
        return this.zzaKz;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final Milestone getCurrentMilestone() {
        return (Milestone) zzxR().get(0);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final String getDescription() {
        return this.zzaxl;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        zzms.zzb(this.zzaxl, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final long getEndTimestamp() {
        return this.zzaKA;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final Game getGame() {
        return this.zzaJE;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final Uri getIconImageUri() {
        return this.zzaKB;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final String getIconImageUrl() {
        return this.zzaKC;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final long getLastUpdatedTimestamp() {
        return this.zzaDt;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final String getName() {
        return this.mName;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final void getName(CharArrayBuffer charArrayBuffer) {
        zzms.zzb(this.mName, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final String getQuestId() {
        return this.zzaKw;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final long getStartTimestamp() {
        return this.zzaKE;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final int getState() {
        return this.mState;
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final int getType() {
        return this.zzabB;
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

    @Override // com.google.android.gms.games.quest.Quest
    public final boolean isEndingSoon() {
        return this.zzaKD <= System.currentTimeMillis() + 1800000;
    }

    public final String toString() {
        return zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        QuestEntityCreator.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final List zzxR() {
        return new ArrayList(this.zzaKF);
    }

    @Override // com.google.android.gms.games.quest.Quest
    public final long zzxS() {
        return this.zzaKD;
    }
}
