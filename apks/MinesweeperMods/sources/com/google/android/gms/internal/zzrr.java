package com.google.android.gms.internal;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzrr {
    private final Context mContext;
    private String zzbio;
    private final zzrt zzbmf;
    Map zzbmg;
    private final Map zzbmh;
    private final zzmq zzqW;

    public zzrr(Context context) {
        this(context, new HashMap(), new zzrt(context), zzmt.zzsc());
    }

    zzrr(Context context, Map map, zzrt zzrtVar, zzmq zzmqVar) {
        this.zzbio = null;
        this.zzbmg = new HashMap();
        this.mContext = context;
        this.zzqW = zzmqVar;
        this.zzbmf = zzrtVar;
        this.zzbmh = map;
    }

    public void zzgB(String str) {
        this.zzbio = str;
    }
}
