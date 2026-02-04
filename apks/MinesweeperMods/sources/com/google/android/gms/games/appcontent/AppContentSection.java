package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

/* loaded from: classes2.dex */
public interface AppContentSection extends Parcelable, Freezable {
    List getActions();

    Bundle getExtras();

    String getId();

    String getTitle();

    String getType();

    String zzvQ();

    List zzwa();

    String zzwc();

    List zzwk();

    String zzwl();
}
