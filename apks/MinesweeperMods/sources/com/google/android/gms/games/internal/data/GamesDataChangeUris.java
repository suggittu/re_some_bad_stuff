package com.google.android.gms.games.internal.data;

import android.net.Uri;
import com.google.android.gms.games.Games;

/* loaded from: classes2.dex */
public final class GamesDataChangeUris {
    private static final Uri zzaIa;
    public static final Uri zzaIb;
    public static final Uri zzaIc;

    static {
        Uri uriBuild = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
        zzaIa = uriBuild;
        zzaIb = uriBuild.buildUpon().appendPath("invitations").build();
        zzaIc = zzaIa.buildUpon().appendEncodedPath(Games.EXTRA_PLAYER_IDS).build();
    }
}
