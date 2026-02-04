package com.google.android.gms.internal;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzlo {
    private final int zzabo;
    private final String zzacX;
    private final JSONObject zzadn;

    public zzlo(String str, int i, JSONObject jSONObject) {
        this.zzacX = str;
        this.zzabo = i;
        this.zzadn = jSONObject;
    }

    public zzlo(JSONObject jSONObject) {
        this(jSONObject.optString("playerId"), jSONObject.optInt("playerState"), jSONObject.optJSONObject("playerData"));
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzlo)) {
            return false;
        }
        zzlo zzloVar = (zzlo) obj;
        return this.zzabo == zzloVar.getPlayerState() && com.google.android.gms.cast.internal.zzf.zza(this.zzacX, zzloVar.getPlayerId()) && zznb.zze(this.zzadn, zzloVar.getPlayerData());
    }

    public final JSONObject getPlayerData() {
        return this.zzadn;
    }

    public final String getPlayerId() {
        return this.zzacX;
    }

    public final int getPlayerState() {
        return this.zzabo;
    }
}
