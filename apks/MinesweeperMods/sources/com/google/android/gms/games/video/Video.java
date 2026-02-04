package com.google.android.gms.games.video;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

/* loaded from: classes2.dex */
public interface Video extends Parcelable, Freezable {
    int getDuration();

    long getFileSize();

    String getPackageName();

    long getStartTime();

    String zzxX();
}
