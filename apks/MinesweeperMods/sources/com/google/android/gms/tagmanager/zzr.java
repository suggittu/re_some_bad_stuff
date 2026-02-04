package com.google.android.gms.tagmanager;

import java.util.Map;

/* loaded from: classes2.dex */
class zzr extends zzcz {
    private static final String ID = com.google.android.gms.internal.zzad.CONTAINS.toString();

    public zzr() {
        super(ID);
    }

    @Override // com.google.android.gms.tagmanager.zzcz
    protected boolean zza(String str, String str2, Map map) {
        return str.contains(str2);
    }
}
