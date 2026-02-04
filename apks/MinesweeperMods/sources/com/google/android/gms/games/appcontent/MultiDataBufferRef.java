package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class MultiDataBufferRef extends zzc {
    protected final ArrayList zzaDN;

    protected MultiDataBufferRef(ArrayList arrayList, int i, int i2) {
        super((DataHolder) arrayList.get(i), i2);
        this.zzaDN = arrayList;
    }
}
