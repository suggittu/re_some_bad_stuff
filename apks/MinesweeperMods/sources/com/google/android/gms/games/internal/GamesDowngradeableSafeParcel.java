package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.internal.zzmw;

/* loaded from: classes2.dex */
public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel {
    protected static boolean zzd(Integer num) {
        if (num == null) {
            return false;
        }
        return zzmw.zzcn(num.intValue());
    }
}
