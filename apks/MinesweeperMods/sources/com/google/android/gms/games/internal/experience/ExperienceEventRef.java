package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.GameRef;

/* loaded from: classes2.dex */
public final class ExperienceEventRef extends zzc implements ExperienceEvent {
    private final GameRef zzaIk;

    public ExperienceEventRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        if (zzcB("external_game_id")) {
            this.zzaIk = null;
        } else {
            this.zzaIk = new GameRef(this.zzahi, this.zzaje);
        }
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String getIconImageUrl() {
        return getString("icon_url");
    }
}
