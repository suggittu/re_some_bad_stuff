package com.google.android.gms.games.leaderboard;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class LeaderboardScoreBufferHeader {
    private final Bundle zzUH;

    public final class Builder {
        private Builder() {
        }
    }

    public LeaderboardScoreBufferHeader(Bundle bundle) {
        this.zzUH = bundle == null ? new Bundle() : bundle;
    }

    public final Bundle asBundle() {
        return this.zzUH;
    }
}
