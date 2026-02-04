package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

/* loaded from: classes2.dex */
public interface AppContentCard extends Parcelable, Freezable {
    List getActions();

    String getDescription();

    Bundle getExtras();

    String getId();

    String getTitle();

    String getType();

    List zzvP();

    String zzvQ();

    List zzwa();

    int zzwb();

    String zzwc();

    int zzwd();
}
