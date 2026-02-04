package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zze;
import com.google.android.gms.common.api.internal.zzf;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.IGamesService;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.VideoBuffer;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.VideoConfiguration;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.signin.internal.zzh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class GamesClientImpl extends zzj {
    EventIncrementManager zzaDZ;
    private final String zzaEa;
    private PlayerEntity zzaEb;
    private GameEntity zzaEc;
    private final PopupManager zzaEd;
    private boolean zzaEe;
    private final Binder zzaEf;
    private final long zzaEg;
    private final Games.GamesOptions zzaEh;

    abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier {
        private final ArrayList zzaEj;

        AbstractPeerStatusNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder);
            this.zzaEj = new ArrayList();
            for (String str : strArr) {
                this.zzaEj.add(str);
            }
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomStatusNotifier
        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            zza(roomStatusUpdateListener, room, this.zzaEj);
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList);
    }

    abstract class AbstractRoomNotifier extends zze {
        AbstractRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zze
        public void zza(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            zza(roomUpdateListener, GamesClientImpl.zzY(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void zza(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    abstract class AbstractRoomStatusNotifier extends zze {
        AbstractRoomStatusNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zze
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            zza(roomStatusUpdateListener, GamesClientImpl.zzY(dataHolder));
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    final class AcceptQuestResultImpl extends GamesDataHolderResult implements Quests.AcceptQuestResult {
        private final Quest zzaEk;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaEk = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.zzaEk = null;
                }
            } finally {
                questBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.quest.Quests.AcceptQuestResult
        public final Quest getQuest() {
            return this.zzaEk;
        }
    }

    final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        AchievementUpdatedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzh(int i, String str) {
            this.zzamC.zzs(new UpdateAchievementResultImpl(i, str));
        }
    }

    final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        AchievementsLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzh(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaEl;

        public AppContentLoadedBinderCallbacks(zza.zzb zzbVar) {
            this.zzaEl = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zza(DataHolder[] dataHolderArr) {
            this.zzaEl.zzs(new LoadAppContentsResultImpl(dataHolderArr));
        }
    }

    final class CancelMatchResultImpl implements TurnBasedMultiplayer.CancelMatchResult {
        private final Status zzUX;
        private final String zzaEm;

        CancelMatchResultImpl(Status status, String str) {
            this.zzUX = status;
            this.zzaEm = str;
        }

        @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult
        public final String getMatchId() {
            return this.zzaEm;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    final class ClaimMilestoneResultImpl extends GamesDataHolderResult implements Quests.ClaimMilestoneResult {
        private final Quest zzaEk;
        private final Milestone zzaEn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        ClaimMilestoneResultImpl(DataHolder dataHolder, String str) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaEk = new QuestEntity((Quest) questBuffer.get(0));
                    List listZzxR = this.zzaEk.zzxR();
                    int size = listZzxR.size();
                    for (int i = 0; i < size; i++) {
                        if (((Milestone) listZzxR.get(i)).getMilestoneId().equals(str)) {
                            this.zzaEn = (Milestone) listZzxR.get(i);
                            return;
                        }
                    }
                    this.zzaEn = null;
                } else {
                    this.zzaEn = null;
                    this.zzaEk = null;
                }
            } finally {
                questBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
        public final Milestone getMilestone() {
            return this.zzaEn;
        }

        @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
        public final Quest getQuest() {
            return this.zzaEk;
        }
    }

    final class CommitSnapshotResultImpl extends GamesDataHolderResult implements Snapshots.CommitSnapshotResult {
        private final SnapshotMetadata zzaEo;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.zzaEo = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.zzaEo = null;
                }
            } finally {
                snapshotMetadataBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult
        public final SnapshotMetadata getSnapshotMetadata() {
            return this.zzaEo;
        }
    }

    final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier {
        ConnectedToRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomStatusNotifier
        public final void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    final class ContactSettingLoadResultImpl extends GamesDataHolderResult implements Notifications.ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        ContactSettingsLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzI(DataHolder dataHolder) {
            this.zzamC.zzs(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        ContactSettingsUpdatedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzgo(int i) {
            this.zzamC.zzs(GamesStatusCodes.zzgc(i));
        }
    }

    final class DeleteSnapshotResultImpl implements Snapshots.DeleteSnapshotResult {
        private final Status zzUX;
        private final String zzaEp;

        DeleteSnapshotResultImpl(int i, String str) {
            this.zzUX = GamesStatusCodes.zzgc(i);
            this.zzaEp = str;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult
        public final String getSnapshotId() {
            return this.zzaEp;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier {
        DisconnectedFromRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomStatusNotifier
        public final void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        EventsLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzi(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadEventResultImpl(dataHolder));
        }
    }

    final class ExperimentsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        ExperimentsLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zza(int i, long[] jArr) {
            this.zzamC.zzs(new LoadExperimentsResultImpl(i, jArr));
        }
    }

    class GameClientEventIncrementCache extends EventIncrementCache {
        public GameClientEventIncrementCache() {
            super(GamesClientImpl.this.getContext().getMainLooper(), 1000);
        }

        @Override // com.google.android.gms.games.internal.events.EventIncrementCache
        protected void zzs(String str, int i) {
            try {
                if (GamesClientImpl.this.isConnected()) {
                    ((IGamesService) GamesClientImpl.this.zzqJ()).zzp(str, i);
                } else {
                    GamesLog.zzA("GamesClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
                }
            } catch (RemoteException e) {
                GamesClientImpl.this.zzb(e);
            }
        }
    }

    final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        GameInstancesLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzp(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    final class GameMuteStatusChangeResultImpl implements Notifications.GameMuteStatusChangeResult {
        private final Status zzUX;
        private final String zzaEq;
        private final boolean zzaEr;

        public GameMuteStatusChangeResultImpl(int i, String str, boolean z) {
            this.zzUX = GamesStatusCodes.zzgc(i);
            this.zzaEq = str;
            this.zzaEr = z;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        GameMuteStatusChangedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zza(int i, String str, boolean z) {
            this.zzamC.zzs(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    final class GameMuteStatusLoadResultImpl implements Notifications.GameMuteStatusLoadResult {
        private final Status zzUX;
        private final String zzaEq;
        private final boolean zzaEr;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.zzUX = GamesStatusCodes.zzgc(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.zzaEq = dataHolder.zzd("external_game_id", 0, 0);
                    this.zzaEr = dataHolder.zze("muted", 0, 0);
                } else {
                    this.zzaEq = null;
                    this.zzaEr = false;
                }
            } finally {
                dataHolder.close();
            }
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        GameMuteStatusLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzG(DataHolder dataHolder) {
            this.zzamC.zzs(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        GameSearchSuggestionsLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzq(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    abstract class GamesDataHolderResult extends zzf {
        protected GamesDataHolderResult(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zzgc(dataHolder.getStatusCode()));
        }
    }

    final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        GamesLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzn(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadGamesResultImpl(dataHolder));
        }
    }

    final class GetAuthTokenBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        public GetAuthTokenBinderCallbacks(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzg(int i, String str) {
            this.zzamC.zzs(new GetTokenResultImpl(GamesStatusCodes.zzgc(i), str));
        }
    }

    final class GetServerAuthCodeBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        public GetServerAuthCodeBinderCallbacks(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzg(int i, String str) {
            this.zzamC.zzs(new GetServerAuthCodeResultImpl(GamesStatusCodes.zzgc(i), str));
        }
    }

    final class GetServerAuthCodeResultImpl implements Games.GetServerAuthCodeResult {
        private final Status zzUX;
        private final String zzaEs;

        GetServerAuthCodeResultImpl(Status status, String str) {
            this.zzUX = status;
            this.zzaEs = str;
        }

        @Override // com.google.android.gms.games.Games.GetServerAuthCodeResult
        public final String getCode() {
            return this.zzaEs;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    final class GetTokenResultImpl implements Games.GetTokenResult {
        private final Status zzUX;
        private final String zzVo;

        GetTokenResultImpl(Status status, String str) {
            this.zzUX = status;
            this.zzVo = str;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    final class InboxCountResultImpl implements Notifications.InboxCountResult {
        private final Status zzUX;
        private final Bundle zzaEt;

        InboxCountResultImpl(Status status, Bundle bundle) {
            this.zzUX = status;
            this.zzaEt = bundle;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        InboxCountsLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzg(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzamC.zzs(new InboxCountResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    final class InitiateMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzq zzari;

        InvitationReceivedBinderCallback(zzq zzqVar) {
            this.zzari = zzqVar;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void onInvitationRemoved(String str) {
            this.zzari.zza(new InvitationRemovedNotifier(str));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzs(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            try {
                Invitation invitation = invitationBuffer.getCount() > 0 ? (Invitation) ((Invitation) invitationBuffer.get(0)).freeze() : null;
                if (invitation != null) {
                    this.zzari.zza(new InvitationReceivedNotifier(invitation));
                }
            } finally {
                invitationBuffer.release();
            }
        }
    }

    final class InvitationReceivedNotifier implements zzq.zzb {
        private final Invitation zzaEu;

        InvitationReceivedNotifier(Invitation invitation) {
            this.zzaEu = invitation;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final void zzt(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.zzaEu);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public final void zzpr() {
        }
    }

    final class InvitationRemovedNotifier implements zzq.zzb {
        private final String zzUO;

        InvitationRemovedNotifier(String str) {
            this.zzUO = str;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final void zzt(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.zzUO);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public final void zzpr() {
        }
    }

    final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        InvitationsLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzr(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    final class JoinedRoomNotifier extends AbstractRoomNotifier {
        public JoinedRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomNotifier
        public final void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    final class LeaderboardMetadataResultImpl extends GamesDataHolderResult implements Leaderboards.LeaderboardMetadataResult {
        private final LeaderboardBuffer zzaEv;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEv = new LeaderboardBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult
        public final LeaderboardBuffer getLeaderboards() {
            return this.zzaEv;
        }
    }

    final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        LeaderboardScoresLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            this.zzamC.zzs(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        LeaderboardsLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzj(DataHolder dataHolder) {
            this.zzamC.zzs(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    final class LeaveMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    final class LeftRoomNotifier implements zzq.zzb {
        private final String zzaEw;
        private final int zzade;

        LeftRoomNotifier(int i, String str) {
            this.zzade = i;
            this.zzaEw = str;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final void zzt(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.zzade, this.zzaEw);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public final void zzpr() {
        }
    }

    final class ListVideosBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        ListVideosBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzX(DataHolder dataHolder) {
            this.zzamC.zzs(new ListVideosResultImpl(dataHolder));
        }
    }

    public final class ListVideosResultImpl extends GamesDataHolderResult implements Videos.ListVideosResult {
        private final VideoBuffer zzaEx;

        public ListVideosResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEx = new VideoBuffer(dataHolder);
        }
    }

    final class LoadAchievementsResultImpl extends GamesDataHolderResult implements Achievements.LoadAchievementsResult {
        private final AchievementBuffer zzaEy;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEy = new AchievementBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult
        public final AchievementBuffer getAchievements() {
            return this.zzaEy;
        }
    }

    final class LoadAclResultImpl extends GamesDataHolderResult implements Acls.LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    final class LoadAppContentsResultImpl extends GamesDataHolderResult implements AppContents.LoadAppContentResult {
        private final ArrayList zzaEz;

        LoadAppContentsResultImpl(DataHolder[] dataHolderArr) {
            super(dataHolderArr[0]);
            this.zzaEz = new ArrayList(Arrays.asList(dataHolderArr));
        }
    }

    final class LoadEventResultImpl extends GamesDataHolderResult implements Events.LoadEventsResult {
        private final EventBuffer zzaEA;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEA = new EventBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.event.Events.LoadEventsResult
        public final EventBuffer getEvents() {
            return this.zzaEA;
        }
    }

    final class LoadExperimentsResultImpl implements Games.LoadExperimentsResult {
        private final Status zzUX;
        private final Set zzaEB = new HashSet();

        LoadExperimentsResultImpl(int i, long[] jArr) {
            this.zzUX = new Status(i);
            for (long j : jArr) {
                this.zzaEB.add(Long.valueOf(j));
            }
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    final class LoadGameInstancesResultImpl extends GamesDataHolderResult implements GamesMetadata.LoadGameInstancesResult {
        private final GameInstanceBuffer zzaEC;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEC = new GameInstanceBuffer(dataHolder);
        }
    }

    final class LoadGameSearchSuggestionsResultImpl extends GamesDataHolderResult implements GamesMetadata.LoadGameSearchSuggestionsResult {
        private final GameSearchSuggestionBuffer zzaED;

        LoadGameSearchSuggestionsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaED = new GameSearchSuggestionBuffer(dataHolder);
        }
    }

    final class LoadGamesResultImpl extends GamesDataHolderResult implements GamesMetadata.LoadGamesResult {
        private final GameBuffer zzaEE;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEE = new GameBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.GamesMetadata.LoadGamesResult
        public final GameBuffer getGames() {
            return this.zzaEE;
        }
    }

    final class LoadInvitationsResultImpl extends GamesDataHolderResult implements Invitations.LoadInvitationsResult {
        private final InvitationBuffer zzaEF;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEF = new InvitationBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult
        public final InvitationBuffer getInvitations() {
            return this.zzaEF;
        }
    }

    final class LoadMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    final class LoadMatchesResultImpl implements TurnBasedMultiplayer.LoadMatchesResult {
        private final Status zzUX;
        private final LoadMatchesResponse zzaEG;

        LoadMatchesResultImpl(Status status, Bundle bundle) {
            this.zzUX = status;
            this.zzaEG = new LoadMatchesResponse(bundle);
        }

        @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult
        public final LoadMatchesResponse getMatches() {
            return this.zzaEG;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public final void release() {
            this.zzaEG.release();
        }
    }

    final class LoadPlayerScoreResultImpl extends GamesDataHolderResult implements Leaderboards.LoadPlayerScoreResult {
        private final LeaderboardScoreEntity zzaEH;

        LoadPlayerScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.zzaEH = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.zzaEH = null;
                }
            } finally {
                leaderboardScoreBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult
        public final LeaderboardScore getScore() {
            return this.zzaEH;
        }
    }

    final class LoadPlayerStatsResultImpl extends GamesDataHolderResult implements Stats.LoadPlayerStatsResult {
        private final PlayerStats zzaEI;

        LoadPlayerStatsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
            try {
                if (playerStatsBuffer.getCount() > 0) {
                    this.zzaEI = new PlayerStatsEntity(playerStatsBuffer.get(0));
                } else {
                    this.zzaEI = null;
                }
            } finally {
                playerStatsBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult
        public final PlayerStats getPlayerStats() {
            return this.zzaEI;
        }
    }

    final class LoadPlayersResultImpl extends GamesDataHolderResult implements Players.LoadPlayersResult {
        private final PlayerBuffer zzaEJ;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEJ = new PlayerBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.Players.LoadPlayersResult
        public final PlayerBuffer getPlayers() {
            return this.zzaEJ;
        }
    }

    final class LoadProfileSettingsResultImpl extends GamesDataHolderResult implements Players.LoadProfileSettingsResult {
        private final boolean zzaEK;
        private final boolean zzsj;

        LoadProfileSettingsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                if (dataHolder.getCount() > 0) {
                    int iZzbH = dataHolder.zzbH(0);
                    this.zzsj = dataHolder.zze("profile_visible", 0, iZzbH);
                    this.zzaEK = dataHolder.zze("profile_visibility_explicitly_set", 0, iZzbH);
                } else {
                    this.zzsj = true;
                    this.zzaEK = false;
                }
            } finally {
                dataHolder.close();
            }
        }

        @Override // com.google.android.gms.common.api.internal.zzf, com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    final class LoadQuestsResultImpl extends GamesDataHolderResult implements Quests.LoadQuestsResult {
        private final DataHolder zzahi;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzahi = dataHolder;
        }

        @Override // com.google.android.gms.games.quest.Quests.LoadQuestsResult
        public final QuestBuffer getQuests() {
            return new QuestBuffer(this.zzahi);
        }
    }

    final class LoadRequestSummariesResultImpl extends GamesDataHolderResult implements Requests.LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    final class LoadRequestsResultImpl implements Requests.LoadRequestsResult {
        private final Status zzUX;
        private final Bundle zzaEL;

        LoadRequestsResultImpl(Status status, Bundle bundle) {
            this.zzUX = status;
            this.zzaEL = bundle;
        }

        @Override // com.google.android.gms.games.request.Requests.LoadRequestsResult
        public final GameRequestBuffer getRequests(int i) {
            String strZzgw = RequestType.zzgw(i);
            if (this.zzaEL.containsKey(strZzgw)) {
                return new GameRequestBuffer((DataHolder) this.zzaEL.get(strZzgw));
            }
            return null;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public final void release() {
            Iterator<String> it = this.zzaEL.keySet().iterator();
            while (it.hasNext()) {
                DataHolder dataHolder = (DataHolder) this.zzaEL.getParcelable(it.next());
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    final class LoadScoresResultImpl extends GamesDataHolderResult implements Leaderboards.LoadScoresResult {
        private final LeaderboardEntity zzaEM;
        private final LeaderboardScoreBuffer zzaEN;

        LoadScoresResultImpl(DataHolder dataHolder, DataHolder dataHolder2) {
            super(dataHolder2);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.zzaEM = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.zzaEM = null;
                }
                leaderboardBuffer.release();
                this.zzaEN = new LeaderboardScoreBuffer(dataHolder2);
            } catch (Throwable th) {
                leaderboardBuffer.release();
                throw th;
            }
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
        public final Leaderboard getLeaderboard() {
            return this.zzaEM;
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
        public final LeaderboardScoreBuffer getScores() {
            return this.zzaEN;
        }
    }

    final class LoadSnapshotsResultImpl extends GamesDataHolderResult implements Snapshots.LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult
        public final SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.zzahi);
        }
    }

    final class LoadXpForGameCategoriesResultImpl implements Players.LoadXpForGameCategoriesResult {
        private final Status zzUX;
        private final List zzaEO;
        private final Bundle zzaEP;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle bundle) {
            this.zzUX = status;
            this.zzaEO = bundle.getStringArrayList("game_category_list");
            this.zzaEP = bundle;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    final class LoadXpStreamResultImpl extends GamesDataHolderResult implements Players.LoadXpStreamResult {
        private final ExperienceEventBuffer zzaEQ;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEQ = new ExperienceEventBuffer(dataHolder);
        }
    }

    final class MatchRemovedNotifier implements zzq.zzb {
        private final String zzaER;

        MatchRemovedNotifier(String str) {
            this.zzaER = str;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final void zzt(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.zzaER);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public final void zzpr() {
        }
    }

    final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzq zzari;

        MatchUpdateReceivedBinderCallback(zzq zzqVar) {
            this.zzari = zzqVar;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void onTurnBasedMatchRemoved(String str) {
            this.zzari.zza(new MatchRemovedNotifier(str));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzy(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                TurnBasedMatch turnBasedMatch = turnBasedMatchBuffer.getCount() > 0 ? (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze() : null;
                if (turnBasedMatch != null) {
                    this.zzari.zza(new MatchUpdateReceivedNotifier(turnBasedMatch));
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }
    }

    final class MatchUpdateReceivedNotifier implements zzq.zzb {
        private final TurnBasedMatch zzaES;

        MatchUpdateReceivedNotifier(TurnBasedMatch turnBasedMatch) {
            this.zzaES = turnBasedMatch;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final void zzt(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.zzaES);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public final void zzpr() {
        }
    }

    final class MessageReceivedNotifier implements zzq.zzb {
        private final RealTimeMessage zzaET;

        MessageReceivedNotifier(RealTimeMessage realTimeMessage) {
            this.zzaET = realTimeMessage;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final void zzt(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.zzaET);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public final void zzpr() {
        }
    }

    final class NearbyPlayerDetectedNotifier implements zzq.zzb {
        private final Player zzaEU;

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final void zzt(OnNearbyPlayerDetectedListener onNearbyPlayerDetectedListener) {
            onNearbyPlayerDetectedListener.zza(this.zzaEU);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public final void zzpr() {
        }
    }

    final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        NotifyAclLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzH(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadAclResultImpl(dataHolder));
        }
    }

    final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        NotifyAclUpdatedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzgn(int i) {
            this.zzamC.zzs(GamesStatusCodes.zzgc(i));
        }
    }

    final class OpenSnapshotResultImpl extends GamesDataHolderResult implements Snapshots.OpenSnapshotResult {
        private final Snapshot zzaEV;
        private final String zzaEW;
        private final Snapshot zzaEX;
        private final Contents zzaEY;
        private final SnapshotContents zzaEZ;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents contents) {
            this(dataHolder, null, contents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.zzaEV = null;
                    this.zzaEX = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    zzb.zzab(dataHolder.getStatusCode() != 4004);
                    this.zzaEV = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                    this.zzaEX = null;
                } else {
                    this.zzaEV = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                    this.zzaEX = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(contents2));
                }
                snapshotMetadataBuffer.release();
                this.zzaEW = str;
                this.zzaEY = contents3;
                this.zzaEZ = new SnapshotContentsEntity(contents3);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
                throw th;
            }
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public final String getConflictId() {
            return this.zzaEW;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public final Snapshot getConflictingSnapshot() {
            return this.zzaEX;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public final SnapshotContents getResolutionSnapshotContents() {
            return this.zzaEZ;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public final Snapshot getSnapshot() {
            return this.zzaEV;
        }
    }

    final class P2PConnectedNotifier implements zzq.zzb {
        private final String zzaFa;

        P2PConnectedNotifier(String str) {
            this.zzaFa = str;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final void zzt(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PConnected(this.zzaFa);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public final void zzpr() {
        }
    }

    final class P2PDisconnectedNotifier implements zzq.zzb {
        private final String zzaFa;

        P2PDisconnectedNotifier(String str) {
            this.zzaFa = str;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final void zzt(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PDisconnected(this.zzaFa);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public final void zzpr() {
        }
    }

    final class PeerConnectedNotifier extends AbstractPeerStatusNotifier {
        PeerConnectedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected final void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier {
        PeerDeclinedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected final void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier {
        PeerDisconnectedNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected final void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier {
        PeerInvitedToRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected final void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier {
        PeerJoinedRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected final void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier {
        PeerLeftRoomNotifier(DataHolder dataHolder, String[] strArr) {
            super(dataHolder, strArr);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected final void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        PlayerLeaderboardScoreLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzJ(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    final class PlayerStatsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        public PlayerStatsLoadedBinderCallbacks(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzW(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayerStatsResultImpl(dataHolder));
        }
    }

    final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        PlayerXpForGameCategoriesLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzf(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzamC.zzs(new LoadXpForGameCategoriesResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        PlayerXpStreamLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzU(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        PlayersLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzl(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayersResultImpl(dataHolder));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzm(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayersResultImpl(dataHolder));
        }
    }

    final class PopupLocationInfoBinderCallbacks extends AbstractGamesClient {
        private final PopupManager zzaEd;

        public PopupLocationInfoBinderCallbacks(PopupManager popupManager) {
            this.zzaEd = popupManager;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesClient, com.google.android.gms.games.internal.IGamesClient
        public final PopupLocationInfoParcelable zzws() {
            return new PopupLocationInfoParcelable(this.zzaEd.zzxk());
        }
    }

    final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        ProfileSettingsLoadedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzV(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadProfileSettingsResultImpl(dataHolder));
        }
    }

    final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        ProfileSettingsUpdatedBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzgp(int i) {
            this.zzamC.zzs(GamesStatusCodes.zzgc(i));
        }
    }

    final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFb;

        public QuestAcceptedBinderCallbacks(zza.zzb zzbVar) {
            this.zzaFb = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzQ(DataHolder dataHolder) {
            this.zzaFb.zzs(new AcceptQuestResultImpl(dataHolder));
        }
    }

    final class QuestCompletedNotifier implements zzq.zzb {
        private final Quest zzaEk;

        QuestCompletedNotifier(Quest quest) {
            this.zzaEk = quest;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final void zzt(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.zzaEk);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public final void zzpr() {
        }
    }

    final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFc;
        private final String zzaFd;

        public QuestMilestoneClaimBinderCallbacks(zza.zzb zzbVar, String str) {
            this.zzaFc = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
            this.zzaFd = (String) zzx.zzb(str, "MilestoneId must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzP(DataHolder dataHolder) {
            this.zzaFc.zzs(new ClaimMilestoneResultImpl(dataHolder, this.zzaFd));
        }
    }

    final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        private final zzq zzari;

        QuestUpdateBinderCallback(zzq zzqVar) {
            this.zzari = zzqVar;
        }

        private Quest zzaa(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                return questBuffer.getCount() > 0 ? (Quest) ((Quest) questBuffer.get(0)).freeze() : null;
            } finally {
                questBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzR(DataHolder dataHolder) {
            Quest questZzaa = zzaa(dataHolder);
            if (questZzaa != null) {
                this.zzari.zza(new QuestCompletedNotifier(questZzaa));
            }
        }
    }

    final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFe;

        public QuestsLoadedBinderCallbacks(zza.zzb zzbVar) {
            this.zzaFe = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzT(DataHolder dataHolder) {
            this.zzaFe.zzs(new LoadQuestsResultImpl(dataHolder));
        }
    }

    final class RealTimeMessageSentNotifier implements zzq.zzb {
        private final String zzaFf;
        private final int zzaFg;
        private final int zzade;

        RealTimeMessageSentNotifier(int i, int i2, String str) {
            this.zzade = i;
            this.zzaFg = i2;
            this.zzaFf = str;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final void zzt(RealTimeMultiplayer.ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.zzade, this.zzaFg, this.zzaFf);
            }
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public final void zzpr() {
        }
    }

    final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final zzq zzaFh;

        public RealTimeReliableMessageBinderCallbacks(zzq zzqVar) {
            this.zzaFh = zzqVar;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzb(int i, int i2, String str) {
            if (this.zzaFh != null) {
                this.zzaFh.zza(new RealTimeMessageSentNotifier(i, i2, str));
            }
        }
    }

    final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzq zzari;

        RequestReceivedBinderCallback(zzq zzqVar) {
            this.zzari = zzqVar;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void onRequestRemoved(String str) {
            this.zzari.zza(new RequestRemovedNotifier(str));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzt(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                GameRequest gameRequest = gameRequestBuffer.getCount() > 0 ? (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze() : null;
                if (gameRequest != null) {
                    this.zzari.zza(new RequestReceivedNotifier(gameRequest));
                }
            } finally {
                gameRequestBuffer.release();
            }
        }
    }

    final class RequestReceivedNotifier implements zzq.zzb {
        private final GameRequest zzaFi;

        RequestReceivedNotifier(GameRequest gameRequest) {
            this.zzaFi = gameRequest;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final void zzt(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.zzaFi);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public final void zzpr() {
        }
    }

    final class RequestRemovedNotifier implements zzq.zzb {
        private final String zzEY;

        RequestRemovedNotifier(String str) {
            this.zzEY = str;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final void zzt(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.zzEY);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public final void zzpr() {
        }
    }

    final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFj;

        public RequestSentBinderCallbacks(zza.zzb zzbVar) {
            this.zzaFj = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzL(DataHolder dataHolder) {
            this.zzaFj.zzs(new SendRequestResultImpl(dataHolder));
        }
    }

    final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFk;

        public RequestSummariesLoadedBinderCallbacks(zza.zzb zzbVar) {
            this.zzaFk = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzM(DataHolder dataHolder) {
            this.zzaFk.zzs(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFl;

        public RequestsLoadedBinderCallbacks(zza.zzb zzbVar) {
            this.zzaFl = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzd(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaFl.zzs(new LoadRequestsResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFm;

        public RequestsUpdatedBinderCallbacks(zza.zzb zzbVar) {
            this.zzaFm = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzK(DataHolder dataHolder) {
            this.zzaFm.zzs(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier {
        RoomAutoMatchingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomStatusNotifier
        public final void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        private final zzq zzaFn;
        private final zzq zzaFo;
        private final zzq zzaFp;

        public RoomBinderCallbacks(zzq zzqVar) {
            this.zzaFn = (zzq) zzx.zzb(zzqVar, "Callbacks must not be null");
            this.zzaFo = null;
            this.zzaFp = null;
        }

        public RoomBinderCallbacks(zzq zzqVar, zzq zzqVar2, zzq zzqVar3) {
            this.zzaFn = (zzq) zzx.zzb(zzqVar, "Callbacks must not be null");
            this.zzaFo = zzqVar2;
            this.zzaFp = zzqVar3;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void onLeftRoom(int i, String str) {
            this.zzaFn.zza(new LeftRoomNotifier(i, str));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void onP2PConnected(String str) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new P2PConnectedNotifier(str));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void onP2PDisconnected(String str) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new P2PDisconnectedNotifier(str));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {
            if (this.zzaFp != null) {
                this.zzaFp.zza(new MessageReceivedNotifier(realTimeMessage));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzA(DataHolder dataHolder) {
            this.zzaFn.zza(new JoinedRoomNotifier(dataHolder));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzB(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new RoomConnectingNotifier(dataHolder));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzC(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new RoomAutoMatchingNotifier(dataHolder));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzD(DataHolder dataHolder) {
            this.zzaFn.zza(new RoomConnectedNotifier(dataHolder));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzE(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new ConnectedToRoomNotifier(dataHolder));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzF(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new DisconnectedFromRoomNotifier(dataHolder));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zza(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerInvitedToRoomNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzb(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerJoinedRoomNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzc(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerLeftRoomNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzd(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerDeclinedNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zze(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerConnectedNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzf(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerDisconnectedNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzz(DataHolder dataHolder) {
            this.zzaFn.zza(new RoomCreatedNotifier(dataHolder));
        }
    }

    final class RoomConnectedNotifier extends AbstractRoomNotifier {
        RoomConnectedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomNotifier
        public final void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    final class RoomConnectingNotifier extends AbstractRoomStatusNotifier {
        RoomConnectingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomStatusNotifier
        public final void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    final class RoomCreatedNotifier extends AbstractRoomNotifier {
        public RoomCreatedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomNotifier
        public final void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    final class SendRequestResultImpl extends GamesDataHolderResult implements Requests.SendRequestResult {
        private final GameRequest zzaFi;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.zzaFi = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.zzaFi = null;
                }
            } finally {
                gameRequestBuffer.release();
            }
        }
    }

    final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        public SignOutCompleteBinderCallbacks(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzwr() {
            this.zzamC.zzs(GamesStatusCodes.zzgc(0));
        }
    }

    final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFq;

        public SnapshotCommittedBinderCallbacks(zza.zzb zzbVar) {
            this.zzaFq = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzO(DataHolder dataHolder) {
            this.zzaFq.zzs(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        public SnapshotDeletedBinderCallbacks(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzj(int i, String str) {
            this.zzamC.zzs(new DeleteSnapshotResultImpl(i, str));
        }
    }

    final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFr;

        public SnapshotOpenedBinderCallbacks(zza.zzb zzbVar) {
            this.zzaFr = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zza(DataHolder dataHolder, Contents contents) {
            this.zzaFr.zzs(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.zzaFr.zzs(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFs;

        public SnapshotsLoadedBinderCallbacks(zza.zzb zzbVar) {
            this.zzaFs = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzN(DataHolder dataHolder) {
            this.zzaFs.zzs(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    final class StartRecordingBinderCallback extends AbstractGamesCallbacks {
        private final Games.BaseGamesApiMethodImpl zzaFt;

        StartRecordingBinderCallback(Games.BaseGamesApiMethodImpl baseGamesApiMethodImpl) {
            this.zzaFt = (Games.BaseGamesApiMethodImpl) zzx.zzb(baseGamesApiMethodImpl, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzgq(int i) {
            this.zzaFt.zza(new Status(i));
        }
    }

    final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        public SubmitScoreBinderCallbacks(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzk(DataHolder dataHolder) {
            this.zzamC.zzs(new SubmitScoreResultImpl(dataHolder));
        }
    }

    final class SubmitScoreResultImpl extends GamesDataHolderResult implements Leaderboards.SubmitScoreResult {
        private final ScoreSubmissionData zzaFu;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.zzaFu = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult
        public final ScoreSubmissionData getScoreData() {
            return this.zzaFu;
        }
    }

    final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFv;

        public TurnBasedMatchCanceledBinderCallbacks(zza.zzb zzbVar) {
            this.zzaFv = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzi(int i, String str) {
            this.zzaFv.zzs(new CancelMatchResultImpl(GamesStatusCodes.zzgc(i), str));
        }
    }

    final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFw;

        public TurnBasedMatchInitiatedBinderCallbacks(zza.zzb zzbVar) {
            this.zzaFw = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzv(DataHolder dataHolder) {
            this.zzaFw.zzs(new InitiateMatchResultImpl(dataHolder));
        }
    }

    final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFx;

        public TurnBasedMatchLeftBinderCallbacks(zza.zzb zzbVar) {
            this.zzaFx = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzx(DataHolder dataHolder) {
            this.zzaFx.zzs(new LeaveMatchResultImpl(dataHolder));
        }
    }

    final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFy;

        public TurnBasedMatchLoadedBinderCallbacks(zza.zzb zzbVar) {
            this.zzaFy = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzu(DataHolder dataHolder) {
            this.zzaFy.zzs(new LoadMatchResultImpl(dataHolder));
        }
    }

    abstract class TurnBasedMatchResult extends GamesDataHolderResult {
        final TurnBasedMatch zzaES;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.zzaES = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.zzaES = null;
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.zzaES;
        }
    }

    final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFz;

        public TurnBasedMatchUpdatedBinderCallbacks(zza.zzb zzbVar) {
            this.zzaFz = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzw(DataHolder dataHolder) {
            this.zzaFz.zzs(new UpdateMatchResultImpl(dataHolder));
        }
    }

    final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb zzaFA;

        public TurnBasedMatchesLoadedBinderCallbacks(zza.zzb zzbVar) {
            this.zzaFA = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzc(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaFA.zzs(new LoadMatchesResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    final class UpdateAchievementResultImpl implements Achievements.UpdateAchievementResult {
        private final Status zzUX;
        private final String zzaDj;

        UpdateAchievementResultImpl(int i, String str) {
            this.zzUX = GamesStatusCodes.zzgc(i);
            this.zzaDj = str;
        }

        @Override // com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
        public final String getAchievementId() {
            return this.zzaDj;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    final class UpdateMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    final class UpdateRequestsResultImpl extends GamesDataHolderResult implements Requests.UpdateRequestsResult {
        private final RequestUpdateOutcomes zzaFB;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaFB = RequestUpdateOutcomes.zzab(dataHolder);
        }

        @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
        public final Set getRequestIds() {
            return this.zzaFB.getRequestIds();
        }

        @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
        public final int getRequestOutcome(String str) {
            return this.zzaFB.getRequestOutcome(str);
        }
    }

    public final class VideoAvailableResultImpl implements Videos.VideoAvailableResult {
        private final Status zzUX;
        private final boolean zzaFC;

        VideoAvailableResultImpl(Status status, boolean z) {
            this.zzUX = status;
            this.zzaFC = z;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    public final class VideoCapabilitiesResultImpl implements Videos.VideoCapabilitiesResult {
        private final Status zzUX;
        private final VideoCapabilities zzaFD;

        VideoCapabilitiesResultImpl(Status status, VideoCapabilities videoCapabilities) {
            this.zzUX = status;
            this.zzaFD = videoCapabilities;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.zzUX;
        }
    }

    final class VideoRecordingAvailableBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        VideoRecordingAvailableBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zzd(int i, boolean z) {
            this.zzamC.zzs(new VideoAvailableResultImpl(new Status(i), z));
        }
    }

    final class VideoRecordingCapabilitiesBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb zzamC;

        VideoRecordingCapabilitiesBinderCallback(zza.zzb zzbVar) {
            this.zzamC = (zza.zzb) zzx.zzb(zzbVar, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public final void zza(int i, VideoCapabilities videoCapabilities) {
            this.zzamC.zzs(new VideoCapabilitiesResultImpl(new Status(i), videoCapabilities));
        }
    }

    public GamesClientImpl(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Games.GamesOptions gamesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 1, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzaDZ = new EventIncrementManager() { // from class: com.google.android.gms.games.internal.GamesClientImpl.1
            @Override // com.google.android.gms.games.internal.events.EventIncrementManager
            public EventIncrementCache zzwS() {
                return GamesClientImpl.this.new GameClientEventIncrementCache();
            }
        };
        this.zzaEe = false;
        this.zzaEa = zzfVar.zzqv();
        this.zzaEf = new Binder();
        this.zzaEd = PopupManager.zza(this, zzfVar.zzqr());
        zzo(zzfVar.zzqx());
        this.zzaEg = hashCode();
        this.zzaEh = gamesOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Room zzY(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        try {
            return roomBuffer.getCount() > 0 ? (Room) ((Room) roomBuffer.get(0)).freeze() : null;
        } finally {
            roomBuffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(RemoteException remoteException) {
        GamesLog.zzb("GamesClientImpl", "service died", remoteException);
    }

    private void zzwv() {
        this.zzaEb = null;
        this.zzaEc = null;
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public final void disconnect() {
        this.zzaEe = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) zzqJ();
                iGamesService.zzwR();
                this.zzaDZ.flush();
                iGamesService.zzF(this.zzaEg);
            } catch (RemoteException e) {
                GamesLog.zzz("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.zzj
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzaEe = false;
    }

    public final int zza(zzq zzqVar, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) zzqJ()).zza(new RealTimeReliableMessageBinderCallbacks(zzqVar), bArr, str, str2);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public final int zza(byte[] bArr, String str, String[] strArr) {
        zzx.zzb(strArr, "Participant IDs must not be null");
        try {
            return ((IGamesService) zzqJ()).zzb(bArr, str, strArr);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public final Intent zza(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent intentZza = ((IGamesService) zzqJ()).zza(i, bArr, i2, str);
            zzx.zzb(bitmap, "Must provide a non null icon");
            intentZza.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return intentZza;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final Intent zza(PlayerEntity playerEntity) {
        try {
            return ((IGamesService) zzqJ()).zza(playerEntity);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final Intent zza(Room room, int i) {
        try {
            return ((IGamesService) zzqJ()).zza((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final Intent zza(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) zzqJ()).zza(str, z, z2, i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    public final void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(GamesClientImpl.class.getClassLoader());
            this.zzaEe = bundle.getBoolean("show_welcome_popup");
            this.zzaEb = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.zzaEc = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public final void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) zzqJ()).zza(iBinder, bundle);
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public final void zza(GoogleApiClient.zza zzaVar) {
        zzwv();
        super.zza(zzaVar);
    }

    public final void zza(zza.zzb zzbVar, int i) {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new InvitationsLoadedBinderCallback(zzbVar), i);
    }

    public final void zza(zza.zzb zzbVar, int i, int i2, int i3) {
        ((IGamesService) zzqJ()).zza(new RequestsLoadedBinderCallbacks(zzbVar), i, i2, i3);
    }

    public final void zza(zza.zzb zzbVar, int i, String str, String[] strArr, boolean z) {
        ((IGamesService) zzqJ()).zza(new AppContentLoadedBinderCallbacks(zzbVar), i, str, strArr, z);
    }

    public final void zza(zza.zzb zzbVar, int i, boolean z, boolean z2) {
        ((IGamesService) zzqJ()).zza(new PlayersLoadedBinderCallback(zzbVar), i, z, z2);
    }

    public final void zza(zza.zzb zzbVar, int i, int[] iArr) {
        ((IGamesService) zzqJ()).zza(new TurnBasedMatchesLoadedBinderCallbacks(zzbVar), i, iArr);
    }

    public final void zza(zza.zzb zzbVar, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        ((IGamesService) zzqJ()).zza(new LeaderboardScoresLoadedBinderCallback(zzbVar), leaderboardScoreBuffer.zzxJ().asBundle(), i, i2);
    }

    public final void zza(zza.zzb zzbVar, TurnBasedMatchConfig turnBasedMatchConfig) {
        ((IGamesService) zzqJ()).zza(new TurnBasedMatchInitiatedBinderCallbacks(zzbVar), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zzxP(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
    }

    public final void zza(zza.zzb zzbVar, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), "Snapshot already closed");
        BitmapTeleporter bitmapTeleporterZzxU = snapshotMetadataChange.zzxU();
        if (bitmapTeleporterZzxU != null) {
            bitmapTeleporterZzxU.zzc(getContext().getCacheDir());
        }
        Contents contentsZzsx = snapshotContents.zzsx();
        snapshotContents.close();
        ((IGamesService) zzqJ()).zza(new SnapshotCommittedBinderCallbacks(zzbVar), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, contentsZzsx);
    }

    public final void zza(zza.zzb zzbVar, String str) {
        ((IGamesService) zzqJ()).zza(zzbVar == null ? null : new AchievementUpdatedBinderCallback(zzbVar), str, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public final void zza(zza.zzb zzbVar, String str, int i) {
        ((IGamesService) zzqJ()).zza(zzbVar == null ? null : new AchievementUpdatedBinderCallback(zzbVar), str, i, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public final void zza(zza.zzb zzbVar, String str, int i, int i2, int i3, boolean z) {
        ((IGamesService) zzqJ()).zza(new LeaderboardScoresLoadedBinderCallback(zzbVar), str, i, i2, i3, z);
    }

    public final void zza(zza.zzb zzbVar, String str, int i, boolean z, boolean z2) {
        switch (str) {
            case "played_with":
                ((IGamesService) zzqJ()).zzd(new PlayersLoadedBinderCallback(zzbVar), str, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public final void zza(zza.zzb zzbVar, String str, int i, int[] iArr) {
        ((IGamesService) zzqJ()).zza(new TurnBasedMatchesLoadedBinderCallbacks(zzbVar), str, i, iArr);
    }

    public final void zza(zza.zzb zzbVar, String str, long j, String str2) {
        ((IGamesService) zzqJ()).zza(zzbVar == null ? null : new SubmitScoreBinderCallbacks(zzbVar), str, j, str2);
    }

    public final void zza(zza.zzb zzbVar, String str, String str2) {
        ((IGamesService) zzqJ()).zzc(new TurnBasedMatchLeftBinderCallbacks(zzbVar), str, str2);
    }

    public final void zza(zza.zzb zzbVar, String str, String str2, int i, int i2) {
        ((IGamesService) zzqJ()).zza(new PlayerLeaderboardScoreLoadedBinderCallback(zzbVar), str, str2, i, i2);
    }

    public final void zza(zza.zzb zzbVar, String str, String str2, int i, int i2, int i3) {
        ((IGamesService) zzqJ()).zza(new RequestsLoadedBinderCallbacks(zzbVar), str, str2, i, i2, i3);
    }

    public final void zza(zza.zzb zzbVar, String str, String str2, int i, int i2, int i3, boolean z) {
        ((IGamesService) zzqJ()).zza(new LeaderboardScoresLoadedBinderCallback(zzbVar), str, str2, i, i2, i3, z);
    }

    public final void zza(zza.zzb zzbVar, String str, String str2, int i, boolean z, boolean z2) {
        switch (str) {
            case "circled":
            case "played_with":
            case "nearby":
                ((IGamesService) zzqJ()).zza(new PlayersLoadedBinderCallback(zzbVar), str, str2, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public final void zza(zza.zzb zzbVar, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        zzx.zza(!snapshotContents.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter bitmapTeleporterZzxU = snapshotMetadataChange.zzxU();
        if (bitmapTeleporterZzxU != null) {
            bitmapTeleporterZzxU.zzc(getContext().getCacheDir());
        }
        Contents contentsZzsx = snapshotContents.zzsx();
        snapshotContents.close();
        ((IGamesService) zzqJ()).zza(new SnapshotOpenedBinderCallbacks(zzbVar), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, contentsZzsx);
    }

    public final void zza(zza.zzb zzbVar, String str, String str2, boolean z) {
        ((IGamesService) zzqJ()).zzb(new LeaderboardsLoadedBinderCallback(zzbVar), str, str2, z);
    }

    public final void zza(zza.zzb zzbVar, String str, String str2, boolean z, String[] strArr) {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza(new QuestsLoadedBinderCallbacks(zzbVar), str, str2, strArr, z);
    }

    public final void zza(zza.zzb zzbVar, String str, String str2, int[] iArr, int i, boolean z) {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza(new QuestsLoadedBinderCallbacks(zzbVar), str, str2, iArr, i, z);
    }

    public final void zza(zza.zzb zzbVar, String str, String str2, String[] strArr) {
        ((IGamesService) zzqJ()).zza(new RequestsUpdatedBinderCallbacks(zzbVar), str, str2, strArr);
    }

    public final void zza(zza.zzb zzbVar, String str, boolean z) {
        ((IGamesService) zzqJ()).zzf(new PlayersLoadedBinderCallback(zzbVar), str, z);
    }

    public final void zza(zza.zzb zzbVar, String str, boolean z, int i) {
        ((IGamesService) zzqJ()).zza(new SnapshotOpenedBinderCallbacks(zzbVar), str, z, i);
    }

    public final void zza(zza.zzb zzbVar, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        ((IGamesService) zzqJ()).zza(new TurnBasedMatchUpdatedBinderCallbacks(zzbVar), str, bArr, str2, participantResultArr);
    }

    public final void zza(zza.zzb zzbVar, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        ((IGamesService) zzqJ()).zza(new TurnBasedMatchUpdatedBinderCallbacks(zzbVar), str, bArr, participantResultArr);
    }

    public final void zza(zza.zzb zzbVar, String str, String[] strArr, int i, byte[] bArr, int i2) {
        ((IGamesService) zzqJ()).zza(new RequestSentBinderCallbacks(zzbVar), str, strArr, i, bArr, i2);
    }

    public final void zza(zza.zzb zzbVar, boolean z) {
        ((IGamesService) zzqJ()).zzc(new PlayersLoadedBinderCallback(zzbVar), z);
    }

    public final void zza(zza.zzb zzbVar, boolean z, Bundle bundle) {
        ((IGamesService) zzqJ()).zza(new ContactSettingsUpdatedBinderCallback(zzbVar), z, bundle);
    }

    public final void zza(zza.zzb zzbVar, boolean z, String... strArr) {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza(new EventsLoadedBinderCallback(zzbVar), z, strArr);
    }

    public final void zza(zza.zzb zzbVar, int[] iArr, int i, boolean z) {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza(new QuestsLoadedBinderCallbacks(zzbVar), iArr, i, z);
    }

    public final void zza(zza.zzb zzbVar, String[] strArr) {
        ((IGamesService) zzqJ()).zzc(new PlayersLoadedBinderCallback(zzbVar), strArr);
    }

    public final void zza(zzq zzqVar) {
        try {
            ((IGamesService) zzqJ()).zza(new InvitationReceivedBinderCallback(zzqVar), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final void zza(zzq zzqVar, zzq zzqVar2, zzq zzqVar3, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzqJ()).zza((IGamesCallbacks) new RoomBinderCallbacks(zzqVar, zzqVar2, zzqVar3), (IBinder) this.zzaEf, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final void zza(zzq zzqVar, String str) {
        try {
            ((IGamesService) zzqJ()).zzc(new RoomBinderCallbacks(zzqVar), str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final void zza(Games.BaseGamesApiMethodImpl baseGamesApiMethodImpl, String str, String str2, VideoConfiguration videoConfiguration) {
        ((IGamesService) zzqJ()).zza(new StartRecordingBinderCallback(baseGamesApiMethodImpl), str, str2, videoConfiguration);
    }

    @Override // com.google.android.gms.common.internal.zzj
    public final void zza(@NonNull IGamesService iGamesService) {
        super.zza((IInterface) iGamesService);
        if (this.zzaEe) {
            this.zzaEd.zzxh();
            this.zzaEe = false;
        }
        if (this.zzaEh.zzaCE) {
            return;
        }
        zzb(iGamesService);
    }

    public final void zza(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), "Snapshot already closed");
        Contents contentsZzsx = snapshotContents.zzsx();
        snapshotContents.close();
        try {
            ((IGamesService) zzqJ()).zza(contentsZzsx);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final String zzah(boolean z) {
        if (z && this.zzaEb != null) {
            return this.zzaEb.getPlayerId();
        }
        try {
            return ((IGamesService) zzqJ()).zzwT();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final Intent zzb(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzqJ()).zzb(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final Intent zzb(int[] iArr) {
        try {
            return ((IGamesService) zzqJ()).zzb(iArr);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected final Set zzb(Set set) {
        Scope scope = new Scope(Scopes.GAMES);
        Scope scope2 = new Scope("https://www.googleapis.com/auth/games.firstparty");
        Iterator it = set.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            Scope scope3 = (Scope) it.next();
            if (scope3.equals(scope)) {
                z2 = true;
            } else {
                z = scope3.equals(scope2) ? true : z;
            }
        }
        if (z) {
            zzx.zza(!z2, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
        } else {
            zzx.zza(z2, "Games APIs requires %s to function.", Scopes.GAMES);
        }
        return set;
    }

    public final void zzb(zza.zzb zzbVar, int i, boolean z, boolean z2) {
        ((IGamesService) zzqJ()).zzb(new PlayersLoadedBinderCallback(zzbVar), i, z, z2);
    }

    public final void zzb(zza.zzb zzbVar, String str) {
        ((IGamesService) zzqJ()).zzb(zzbVar == null ? null : new AchievementUpdatedBinderCallback(zzbVar), str, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public final void zzb(zza.zzb zzbVar, String str, int i) {
        ((IGamesService) zzqJ()).zzb(zzbVar == null ? null : new AchievementUpdatedBinderCallback(zzbVar), str, i, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public final void zzb(zza.zzb zzbVar, String str, int i, int i2, int i3, boolean z) {
        ((IGamesService) zzqJ()).zzb(new LeaderboardScoresLoadedBinderCallback(zzbVar), str, i, i2, i3, z);
    }

    public final void zzb(zza.zzb zzbVar, String str, int i, boolean z, boolean z2) {
        ((IGamesService) zzqJ()).zzb(new PlayersLoadedBinderCallback(zzbVar), str, i, z, z2);
    }

    public final void zzb(zza.zzb zzbVar, String str, String str2) {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zzf(new QuestMilestoneClaimBinderCallbacks(zzbVar, str2), str, str2);
    }

    public final void zzb(zza.zzb zzbVar, String str, String str2, int i, int i2, int i3, boolean z) {
        ((IGamesService) zzqJ()).zzb(new LeaderboardScoresLoadedBinderCallback(zzbVar), str, str2, i, i2, i3, z);
    }

    public final void zzb(zza.zzb zzbVar, String str, String str2, int i, boolean z, boolean z2) {
        ((IGamesService) zzqJ()).zzb(new PlayersLoadedBinderCallback(zzbVar), str, str2, i, z, z2);
    }

    public final void zzb(zza.zzb zzbVar, String str, String str2, boolean z) {
        ((IGamesService) zzqJ()).zza(new AchievementsLoadedBinderCallback(zzbVar), str, str2, z);
    }

    public final void zzb(zza.zzb zzbVar, String str, boolean z) {
        ((IGamesService) zzqJ()).zzc(new LeaderboardsLoadedBinderCallback(zzbVar), str, z);
    }

    public final void zzb(zza.zzb zzbVar, boolean z) {
        ((IGamesService) zzqJ()).zzb(new LeaderboardsLoadedBinderCallback(zzbVar), z);
    }

    public final void zzb(zza.zzb zzbVar, boolean z, String[] strArr) {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza(new QuestsLoadedBinderCallbacks(zzbVar), strArr, z);
    }

    public final void zzb(zza.zzb zzbVar, String[] strArr) {
        ((IGamesService) zzqJ()).zza(new RequestsUpdatedBinderCallbacks(zzbVar), strArr);
    }

    public final void zzb(zzq zzqVar) {
        try {
            ((IGamesService) zzqJ()).zzb(new MatchUpdateReceivedBinderCallback(zzqVar), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final void zzb(zzq zzqVar, zzq zzqVar2, zzq zzqVar3, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzqJ()).zza((IGamesCallbacks) new RoomBinderCallbacks(zzqVar, zzqVar2, zzqVar3), (IBinder) this.zzaEf, roomConfig.getInvitationId(), false, this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final void zzb(IGamesService iGamesService) {
        try {
            iGamesService.zza(new PopupLocationInfoBinderCallbacks(this.zzaEd), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final void zzb(String str, zza.zzb zzbVar) {
        zzx.zzh(str, "Please provide a valid serverClientId");
        ((IGamesService) zzqJ()).zza(str, new GetServerAuthCodeBinderCallbacks(zzbVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzbV, reason: merged with bridge method [inline-methods] */
    public final IGamesService zzW(IBinder iBinder) {
        return IGamesService.Stub.zzbY(iBinder);
    }

    public final Intent zzc(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzqJ()).zzc(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final void zzc(zza.zzb zzbVar, int i, boolean z, boolean z2) {
        ((IGamesService) zzqJ()).zzc(new PlayersLoadedBinderCallback(zzbVar), i, z, z2);
    }

    public final void zzc(zza.zzb zzbVar, String str) {
        ((IGamesService) zzqJ()).zzl(new TurnBasedMatchInitiatedBinderCallbacks(zzbVar), str);
    }

    public final void zzc(zza.zzb zzbVar, String str, int i) {
        ((IGamesService) zzqJ()).zzb(new PlayerXpStreamLoadedBinderCallback(zzbVar), str, i);
    }

    public final void zzc(zza.zzb zzbVar, String str, String str2) {
        ((IGamesService) zzqJ()).zzd(new TurnBasedMatchInitiatedBinderCallbacks(zzbVar), str, str2);
    }

    public final void zzc(zza.zzb zzbVar, String str, String str2, boolean z) {
        ((IGamesService) zzqJ()).zzc(new SnapshotsLoadedBinderCallbacks(zzbVar), str, str2, z);
    }

    public final void zzc(zza.zzb zzbVar, String str, boolean z) {
        ((IGamesService) zzqJ()).zzd(new LeaderboardsLoadedBinderCallback(zzbVar), str, z);
    }

    public final void zzc(zza.zzb zzbVar, boolean z) {
        ((IGamesService) zzqJ()).zza(new AchievementsLoadedBinderCallback(zzbVar), z);
    }

    public final void zzc(zza.zzb zzbVar, String[] strArr) {
        ((IGamesService) zzqJ()).zzb(new RequestsUpdatedBinderCallbacks(zzbVar), strArr);
    }

    public final void zzc(zzq zzqVar) {
        try {
            ((IGamesService) zzqJ()).zzd(new QuestUpdateBinderCallback(zzqVar), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final int zzd(byte[] bArr, String str) {
        try {
            return ((IGamesService) zzqJ()).zzb(bArr, str, (String[]) null);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public final void zzd(zza.zzb zzbVar) {
        ((IGamesService) zzqJ()).zzk(new GetAuthTokenBinderCallbacks(zzbVar));
    }

    public final void zzd(zza.zzb zzbVar, int i, boolean z, boolean z2) {
        ((IGamesService) zzqJ()).zze(new PlayersLoadedBinderCallback(zzbVar), i, z, z2);
    }

    public final void zzd(zza.zzb zzbVar, String str) {
        ((IGamesService) zzqJ()).zzm(new TurnBasedMatchInitiatedBinderCallbacks(zzbVar), str);
    }

    public final void zzd(zza.zzb zzbVar, String str, int i) {
        ((IGamesService) zzqJ()).zzc(new PlayerXpStreamLoadedBinderCallback(zzbVar), str, i);
    }

    public final void zzd(zza.zzb zzbVar, String str, String str2) {
        ((IGamesService) zzqJ()).zze(new TurnBasedMatchInitiatedBinderCallbacks(zzbVar), str, str2);
    }

    public final void zzd(zza.zzb zzbVar, String str, boolean z) {
        ((IGamesService) zzqJ()).zza(new GameMuteStatusChangedBinderCallback(zzbVar), str, z);
    }

    public final void zzd(zza.zzb zzbVar, boolean z) {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zzf(new EventsLoadedBinderCallback(zzbVar), z);
    }

    public final void zzd(zzq zzqVar) {
        try {
            ((IGamesService) zzqJ()).zzc(new RequestReceivedBinderCallback(zzqVar), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final void zzdH(String str) {
        try {
            ((IGamesService) zzqJ()).zzdP(str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final Intent zzdI(String str) {
        try {
            return ((IGamesService) zzqJ()).zzdI(str);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final void zzdJ(String str) {
        try {
            ((IGamesService) zzqJ()).zza(str, this.zzaEd.zzxj(), this.zzaEd.zzxi());
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final void zze(zza.zzb zzbVar) {
        ((IGamesService) zzqJ()).zzd(new GamesLoadedBinderCallback(zzbVar));
    }

    public final void zze(zza.zzb zzbVar, String str) {
        ((IGamesService) zzqJ()).zzo(new TurnBasedMatchLeftBinderCallbacks(zzbVar), str);
    }

    public final void zze(zza.zzb zzbVar, String str, int i) {
        ((IGamesService) zzqJ()).zzb((IGamesCallbacks) new InvitationsLoadedBinderCallback(zzbVar), str, i, false);
    }

    public final void zze(zza.zzb zzbVar, boolean z) {
        ((IGamesService) zzqJ()).zzi(new PlayerStatsLoadedBinderCallbacks(zzbVar), z);
    }

    public final void zzf(zza.zzb zzbVar) {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zza(new SignOutCompleteBinderCallbacks(zzbVar));
    }

    public final void zzf(zza.zzb zzbVar, String str) {
        ((IGamesService) zzqJ()).zzn(new TurnBasedMatchCanceledBinderCallbacks(zzbVar), str);
    }

    public final void zzf(zza.zzb zzbVar, String str, int i) {
        ((IGamesService) zzqJ()).zza((IGamesCallbacks) new RequestSummariesLoadedBinderCallbacks(zzbVar), str, i);
    }

    public final void zzf(zza.zzb zzbVar, boolean z) {
        ((IGamesService) zzqJ()).zzd(new SnapshotsLoadedBinderCallbacks(zzbVar), z);
    }

    public final void zzg(zza.zzb zzbVar) {
        ((IGamesService) zzqJ()).zzm(new VideoRecordingCapabilitiesBinderCallback(zzbVar));
    }

    public final void zzg(zza.zzb zzbVar, String str) {
        ((IGamesService) zzqJ()).zzp(new TurnBasedMatchLoadedBinderCallbacks(zzbVar), str);
    }

    public final void zzg(zza.zzb zzbVar, boolean z) {
        ((IGamesService) zzqJ()).zzg(new ProfileSettingsLoadedBinderCallback(zzbVar), z);
    }

    public final void zzgs(int i) {
        this.zzaEd.setGravity(i);
    }

    public final void zzgt(int i) {
        try {
            ((IGamesService) zzqJ()).zzgt(i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected final String zzgu() {
        return "com.google.android.gms.games.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected final String zzgv() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public final void zzh(zza.zzb zzbVar) {
        ((IGamesService) zzqJ()).zzn(new VideoRecordingAvailableBinderCallback(zzbVar));
    }

    public final void zzh(zza.zzb zzbVar, String str) {
        this.zzaDZ.flush();
        ((IGamesService) zzqJ()).zzu(new QuestAcceptedBinderCallbacks(zzbVar), str);
    }

    public final void zzh(zza.zzb zzbVar, boolean z) {
        ((IGamesService) zzqJ()).zzh(new ProfileSettingsUpdatedBinderCallback(zzbVar), z);
    }

    public final void zzi(zza.zzb zzbVar) {
        ((IGamesService) zzqJ()).zzl(new ListVideosBinderCallback(zzbVar));
    }

    public final void zzi(zza.zzb zzbVar, String str) {
        ((IGamesService) zzqJ()).zzr(new SnapshotDeletedBinderCallbacks(zzbVar), str);
    }

    public final void zzi(zza.zzb zzbVar, boolean z) {
        ((IGamesService) zzqJ()).zze(new ContactSettingsLoadedBinderCallback(zzbVar), z);
    }

    public final void zzj(zza.zzb zzbVar) {
        ((IGamesService) zzqJ()).zzh(new NotifyAclLoadedBinderCallback(zzbVar));
    }

    public final void zzj(zza.zzb zzbVar, String str) {
        ((IGamesService) zzqJ()).zzf(new GameInstancesLoadedBinderCallback(zzbVar), str);
    }

    public final void zzk(zza.zzb zzbVar) {
        ((IGamesService) zzqJ()).zzt(new InboxCountsLoadedBinderCallback(zzbVar), (String) null);
    }

    public final void zzk(zza.zzb zzbVar, String str) {
        ((IGamesService) zzqJ()).zzq(new GameSearchSuggestionsLoadedBinderCallback(zzbVar), str);
    }

    public final Intent zzl(String str, int i, int i2) {
        try {
            return ((IGamesService) zzqJ()).zzm(str, i, i2);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final void zzl(zza.zzb zzbVar) {
        ((IGamesService) zzqJ()).zzo(new ExperimentsLoadedBinderCallback(zzbVar));
    }

    public final void zzl(zza.zzb zzbVar, String str) {
        ((IGamesService) zzqJ()).zzs(new PlayerXpForGameCategoriesLoadedBinderCallback(zzbVar), str);
    }

    public final void zzm(zza.zzb zzbVar, String str) {
        ((IGamesService) zzqJ()).zzk(new InvitationsLoadedBinderCallback(zzbVar), str);
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public final boolean zzmE() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected final Bundle zzml() {
        String string = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundleZzvD = this.zzaEh.zzvD();
        bundleZzvD.putString("com.google.android.gms.games.key.gamePackageName", this.zzaEa);
        bundleZzvD.putString("com.google.android.gms.games.key.desiredLocale", string);
        bundleZzvD.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzaEd.zzxj()));
        bundleZzvD.putInt("com.google.android.gms.games.key.API_VERSION", 3);
        bundleZzvD.putBundle("com.google.android.gms.games.key.signInOptions", zzh.zza(zzqH()));
        return bundleZzvD;
    }

    public final void zzn(zza.zzb zzbVar, String str) {
        ((IGamesService) zzqJ()).zzj(new NotifyAclUpdatedBinderCallback(zzbVar), str);
    }

    public final void zzo(View view) {
        this.zzaEd.zzp(view);
    }

    public final void zzo(zza.zzb zzbVar, String str) {
        ((IGamesService) zzqJ()).zzi(new GameMuteStatusLoadedBinderCallback(zzbVar), str);
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.internal.zzk.zza
    public final Bundle zzoi() {
        try {
            Bundle bundleZzoi = ((IGamesService) zzqJ()).zzoi();
            if (bundleZzoi == null) {
                return bundleZzoi;
            }
            bundleZzoi.setClassLoader(GamesClientImpl.class.getClassLoader());
            return bundleZzoi;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final void zzp(String str, int i) {
        this.zzaDZ.zzp(str, i);
    }

    public final void zzq(String str, int i) {
        try {
            ((IGamesService) zzqJ()).zzq(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final void zzr(String str, int i) {
        try {
            ((IGamesService) zzqJ()).zzr(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final Intent zzwA() {
        try {
            return ((IGamesService) zzqJ()).zzwA();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final Intent zzwB() {
        try {
            return ((IGamesService) zzqJ()).zzwB();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final Intent zzwC() {
        try {
            return ((IGamesService) zzqJ()).zzwC();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final void zzwD() {
        try {
            ((IGamesService) zzqJ()).zzG(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final void zzwE() {
        try {
            ((IGamesService) zzqJ()).zzH(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final void zzwF() {
        try {
            ((IGamesService) zzqJ()).zzJ(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final void zzwG() {
        try {
            ((IGamesService) zzqJ()).zzI(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public final Intent zzwH() {
        try {
            return ((IGamesService) zzqJ()).zzwH();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final Intent zzwI() {
        try {
            return ((IGamesService) zzqJ()).zzwI();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final int zzwJ() {
        try {
            return ((IGamesService) zzqJ()).zzwJ();
        } catch (RemoteException e) {
            zzb(e);
            return 4368;
        }
    }

    public final String zzwK() {
        try {
            return ((IGamesService) zzqJ()).zzwK();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final int zzwL() {
        try {
            return ((IGamesService) zzqJ()).zzwL();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public final Intent zzwM() {
        try {
            return ((IGamesService) zzqJ()).zzwM();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final int zzwN() {
        try {
            return ((IGamesService) zzqJ()).zzwN();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public final int zzwO() {
        try {
            return ((IGamesService) zzqJ()).zzwO();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public final int zzwP() {
        try {
            return ((IGamesService) zzqJ()).zzwP();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public final int zzwQ() {
        try {
            return ((IGamesService) zzqJ()).zzwQ();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public final void zzwR() {
        if (isConnected()) {
            try {
                ((IGamesService) zzqJ()).zzwR();
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    public final String zzww() {
        try {
            return ((IGamesService) zzqJ()).zzww();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public final Player zzwx() {
        zzqI();
        synchronized (this) {
            if (this.zzaEb == null) {
                try {
                    PlayerBuffer playerBuffer = new PlayerBuffer(((IGamesService) zzqJ()).zzwU());
                    try {
                        if (playerBuffer.getCount() > 0) {
                            this.zzaEb = (PlayerEntity) playerBuffer.get(0).freeze();
                        }
                    } finally {
                        playerBuffer.release();
                    }
                } catch (RemoteException e) {
                    zzb(e);
                }
            }
        }
        return this.zzaEb;
    }

    public final Game zzwy() {
        zzqI();
        synchronized (this) {
            if (this.zzaEc == null) {
                try {
                    GameBuffer gameBuffer = new GameBuffer(((IGamesService) zzqJ()).zzwW());
                    try {
                        if (gameBuffer.getCount() > 0) {
                            this.zzaEc = (GameEntity) gameBuffer.get(0).freeze();
                        }
                    } finally {
                        gameBuffer.release();
                    }
                } catch (RemoteException e) {
                    zzb(e);
                }
            }
        }
        return this.zzaEc;
    }

    public final Intent zzwz() {
        try {
            return ((IGamesService) zzqJ()).zzwz();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }
}
