package com.google.android.gms.cast.games;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzli;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class GameManagerClient {
    public static final int GAMEPLAY_STATE_LOADING = 1;
    public static final int GAMEPLAY_STATE_PAUSED = 3;
    public static final int GAMEPLAY_STATE_RUNNING = 2;
    public static final int GAMEPLAY_STATE_SHOWING_INFO_SCREEN = 4;
    public static final int GAMEPLAY_STATE_UNKNOWN = 0;
    public static final int LOBBY_STATE_CLOSED = 2;
    public static final int LOBBY_STATE_OPEN = 1;
    public static final int LOBBY_STATE_UNKNOWN = 0;
    public static final int PLAYER_STATE_AVAILABLE = 3;
    public static final int PLAYER_STATE_DROPPED = 1;
    public static final int PLAYER_STATE_IDLE = 5;
    public static final int PLAYER_STATE_PLAYING = 6;
    public static final int PLAYER_STATE_QUIT = 2;
    public static final int PLAYER_STATE_READY = 4;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int STATUS_INCORRECT_VERSION = 2150;
    public static final int STATUS_TOO_MANY_PLAYERS = 2151;
    private final zzli zzacy;

    public interface GameManagerInstanceResult extends Result {
        GameManagerClient getGameManagerClient();
    }

    public interface GameManagerResult extends Result {
        JSONObject getExtraMessageData();

        String getPlayerId();

        long getRequestId();
    }

    public interface Listener {
        void onGameMessageReceived(String str, JSONObject jSONObject);

        void onStateChanged(GameManagerState gameManagerState, GameManagerState gameManagerState2);
    }

    public GameManagerClient(zzli zzliVar) {
        this.zzacy = zzliVar;
    }

    public static PendingResult getInstanceFor(GoogleApiClient googleApiClient, String str) {
        return zza(new zzli(googleApiClient, str, Cast.CastApi));
    }

    static PendingResult zza(zzli zzliVar) {
        return zzliVar.zza(new GameManagerClient(zzliVar));
    }

    private PendingResult zza(String str, int i, JSONObject jSONObject) {
        return this.zzacy.zza(str, i, jSONObject);
    }

    public final void dispose() {
        this.zzacy.dispose();
    }

    public final synchronized GameManagerState getCurrentState() {
        return this.zzacy.getCurrentState();
    }

    public final String getLastUsedPlayerId() {
        return this.zzacy.getLastUsedPlayerId();
    }

    public final boolean isDisposed() {
        return this.zzacy.isDisposed();
    }

    public final void sendGameMessage(String str, JSONObject jSONObject) {
        this.zzacy.sendGameMessage(str, jSONObject);
    }

    public final void sendGameMessage(JSONObject jSONObject) {
        sendGameMessage(getLastUsedPlayerId(), jSONObject);
    }

    public final PendingResult sendGameRequest(String str, JSONObject jSONObject) {
        return this.zzacy.sendGameRequest(str, jSONObject);
    }

    public final PendingResult sendGameRequest(JSONObject jSONObject) {
        return sendGameRequest(getLastUsedPlayerId(), jSONObject);
    }

    public final PendingResult sendPlayerAvailableRequest(String str, JSONObject jSONObject) {
        return zza(str, 3, jSONObject);
    }

    public final PendingResult sendPlayerAvailableRequest(JSONObject jSONObject) {
        return zza(getLastUsedPlayerId(), 3, jSONObject);
    }

    public final PendingResult sendPlayerIdleRequest(String str, JSONObject jSONObject) {
        return zza(str, 5, jSONObject);
    }

    public final PendingResult sendPlayerIdleRequest(JSONObject jSONObject) {
        return zza(getLastUsedPlayerId(), 5, jSONObject);
    }

    public final PendingResult sendPlayerPlayingRequest(String str, JSONObject jSONObject) {
        return zza(str, 6, jSONObject);
    }

    public final PendingResult sendPlayerPlayingRequest(JSONObject jSONObject) {
        return zza(getLastUsedPlayerId(), 6, jSONObject);
    }

    public final PendingResult sendPlayerQuitRequest(String str, JSONObject jSONObject) {
        return zza(str, 2, jSONObject);
    }

    public final PendingResult sendPlayerQuitRequest(JSONObject jSONObject) {
        return zza(getLastUsedPlayerId(), 2, jSONObject);
    }

    public final PendingResult sendPlayerReadyRequest(String str, JSONObject jSONObject) {
        return zza(str, 4, jSONObject);
    }

    public final PendingResult sendPlayerReadyRequest(JSONObject jSONObject) {
        return zza(getLastUsedPlayerId(), 4, jSONObject);
    }

    public final void setListener(Listener listener) {
        this.zzacy.setListener(listener);
    }

    public final void setSessionLabel(String str) {
        this.zzacy.setSessionLabel(str);
    }
}
