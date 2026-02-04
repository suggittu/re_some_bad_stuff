package com.google.android.gms.cast.games;

import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface GameManagerState {
    CharSequence getApplicationName();

    List getConnectedControllablePlayers();

    List getConnectedPlayers();

    List getControllablePlayers();

    JSONObject getGameData();

    CharSequence getGameStatusText();

    int getGameplayState();

    Collection getListOfChangedPlayers(GameManagerState gameManagerState);

    int getLobbyState();

    int getMaxPlayers();

    PlayerInfo getPlayer(String str);

    Collection getPlayers();

    List getPlayersInState(int i);

    boolean hasGameDataChanged(GameManagerState gameManagerState);

    boolean hasGameStatusTextChanged(GameManagerState gameManagerState);

    boolean hasGameplayStateChanged(GameManagerState gameManagerState);

    boolean hasLobbyStateChanged(GameManagerState gameManagerState);

    boolean hasPlayerChanged(String str, GameManagerState gameManagerState);

    boolean hasPlayerDataChanged(String str, GameManagerState gameManagerState);

    boolean hasPlayerStateChanged(String str, GameManagerState gameManagerState);
}
