package com.google.android.gms.internal;

import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzlm implements GameManagerState {
    private final String zzada;
    private final int zzadb;
    private final int zzadg;
    private final int zzadh;
    private final JSONObject zzadj;
    private final String zzadk;
    private final Map zzadm;

    public zzlm(int i, int i2, String str, JSONObject jSONObject, Collection collection, String str2, int i3) {
        this.zzadh = i;
        this.zzadg = i2;
        this.zzadk = str;
        this.zzadj = jSONObject;
        this.zzada = str2;
        this.zzadb = i3;
        this.zzadm = new HashMap(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            PlayerInfo playerInfo = (PlayerInfo) it.next();
            this.zzadm.put(playerInfo.getPlayerId(), playerInfo);
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj == null || !(obj instanceof GameManagerState)) {
            return false;
        }
        GameManagerState gameManagerState = (GameManagerState) obj;
        if (getPlayers().size() != gameManagerState.getPlayers().size()) {
            return false;
        }
        for (PlayerInfo playerInfo : getPlayers()) {
            boolean z2 = false;
            for (PlayerInfo playerInfo2 : gameManagerState.getPlayers()) {
                if (!com.google.android.gms.cast.internal.zzf.zza(playerInfo.getPlayerId(), playerInfo2.getPlayerId())) {
                    z = z2;
                } else {
                    if (!com.google.android.gms.cast.internal.zzf.zza(playerInfo, playerInfo2)) {
                        return false;
                    }
                    z = true;
                }
                z2 = z;
            }
            if (!z2) {
                return false;
            }
        }
        return this.zzadh == gameManagerState.getLobbyState() && this.zzadg == gameManagerState.getGameplayState() && this.zzadb == gameManagerState.getMaxPlayers() && com.google.android.gms.cast.internal.zzf.zza(this.zzada, gameManagerState.getApplicationName()) && com.google.android.gms.cast.internal.zzf.zza(this.zzadk, gameManagerState.getGameStatusText()) && zznb.zze(this.zzadj, gameManagerState.getGameData());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final CharSequence getApplicationName() {
        return this.zzada;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final List getConnectedControllablePlayers() {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isConnected() && playerInfo.isControllable()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final List getConnectedPlayers() {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isConnected()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final List getControllablePlayers() {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isControllable()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final JSONObject getGameData() {
        return this.zzadj;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final CharSequence getGameStatusText() {
        return this.zzadk;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final int getGameplayState() {
        return this.zzadg;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final Collection getListOfChangedPlayers(GameManagerState gameManagerState) {
        HashSet hashSet = new HashSet();
        for (PlayerInfo playerInfo : getPlayers()) {
            PlayerInfo player = gameManagerState.getPlayer(playerInfo.getPlayerId());
            if (player == null || !playerInfo.equals(player)) {
                hashSet.add(playerInfo.getPlayerId());
            }
        }
        for (PlayerInfo playerInfo2 : gameManagerState.getPlayers()) {
            if (getPlayer(playerInfo2.getPlayerId()) == null) {
                hashSet.add(playerInfo2.getPlayerId());
            }
        }
        return hashSet;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final int getLobbyState() {
        return this.zzadh;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final int getMaxPlayers() {
        return this.zzadb;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final PlayerInfo getPlayer(String str) {
        if (str == null) {
            return null;
        }
        return (PlayerInfo) this.zzadm.get(str);
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final Collection getPlayers() {
        return Collections.unmodifiableCollection(this.zzadm.values());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final List getPlayersInState(int i) {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.getPlayerState() == i) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final boolean hasGameDataChanged(GameManagerState gameManagerState) {
        return !zznb.zze(this.zzadj, gameManagerState.getGameData());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final boolean hasGameStatusTextChanged(GameManagerState gameManagerState) {
        return !com.google.android.gms.cast.internal.zzf.zza(this.zzadk, gameManagerState.getGameStatusText());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final boolean hasGameplayStateChanged(GameManagerState gameManagerState) {
        return this.zzadg != gameManagerState.getGameplayState();
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final boolean hasLobbyStateChanged(GameManagerState gameManagerState) {
        return this.zzadh != gameManagerState.getLobbyState();
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final boolean hasPlayerChanged(String str, GameManagerState gameManagerState) {
        return !com.google.android.gms.cast.internal.zzf.zza(getPlayer(str), gameManagerState.getPlayer(str));
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final boolean hasPlayerDataChanged(String str, GameManagerState gameManagerState) {
        PlayerInfo player = getPlayer(str);
        PlayerInfo player2 = gameManagerState.getPlayer(str);
        if (player == null && player2 == null) {
            return false;
        }
        if (player == null || player2 == null) {
            return true;
        }
        return !zznb.zze(player.getPlayerData(), player2.getPlayerData());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public final boolean hasPlayerStateChanged(String str, GameManagerState gameManagerState) {
        PlayerInfo player = getPlayer(str);
        PlayerInfo player2 = gameManagerState.getPlayer(str);
        if (player == null && player2 == null) {
            return false;
        }
        if (player == null || player2 == null) {
            return true;
        }
        return player.getPlayerState() != player2.getPlayerState();
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(Integer.valueOf(this.zzadh), Integer.valueOf(this.zzadg), this.zzadm, this.zzadk, this.zzadj, this.zzada, Integer.valueOf(this.zzadb));
    }
}
