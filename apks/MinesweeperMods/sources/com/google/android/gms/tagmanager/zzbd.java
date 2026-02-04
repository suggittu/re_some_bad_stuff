package com.google.android.gms.tagmanager;

import java.util.Map;

/* loaded from: classes2.dex */
class zzbd extends zzbv {
    private static final String ID = com.google.android.gms.internal.zzad.LESS_THAN.toString();

    public zzbd() {
        super(ID);
    }

    @Override // com.google.android.gms.tagmanager.zzbv
    protected boolean zza(zzde zzdeVar, zzde zzdeVar2, Map map) {
        return zzdeVar.compareTo(zzdeVar2) < 0;
    }
}
