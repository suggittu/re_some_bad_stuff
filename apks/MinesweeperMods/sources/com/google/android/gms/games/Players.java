package com.google.android.gms.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

/* loaded from: classes2.dex */
public interface Players {
    public static final String EXTRA_PLAYER_SEARCH_RESULTS = "player_search_results";

    public interface LoadPlayersResult extends Releasable, Result {
        PlayerBuffer getPlayers();
    }

    public interface LoadProfileSettingsResult extends Result {
    }

    public interface LoadXpForGameCategoriesResult extends Result {
    }

    public interface LoadXpForGamesResult extends Result {
    }

    public interface LoadXpStreamResult extends Result {
    }

    Intent getCompareProfileIntent(GoogleApiClient googleApiClient, Player player);

    Player getCurrentPlayer(GoogleApiClient googleApiClient);

    String getCurrentPlayerId(GoogleApiClient googleApiClient);

    Intent getPlayerSearchIntent(GoogleApiClient googleApiClient);

    PendingResult loadConnectedPlayers(GoogleApiClient googleApiClient, boolean z);

    PendingResult loadInvitablePlayers(GoogleApiClient googleApiClient, int i, boolean z);

    PendingResult loadMoreInvitablePlayers(GoogleApiClient googleApiClient, int i);

    PendingResult loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i);

    PendingResult loadPlayer(GoogleApiClient googleApiClient, String str);

    PendingResult loadPlayer(GoogleApiClient googleApiClient, String str, boolean z);

    PendingResult loadRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i, boolean z);
}
