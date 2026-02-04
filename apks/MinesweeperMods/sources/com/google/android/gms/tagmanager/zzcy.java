package com.google.android.gms.tagmanager;

import java.util.Map;

/* loaded from: classes2.dex */
class zzcy extends zzcz {
    private static final String ID = com.google.android.gms.internal.zzad.STARTS_WITH.toString();

    public zzcy() {
        super(ID);
    }

    @Override // com.google.android.gms.tagmanager.zzcz
    protected boolean zza(String str, String str2, Map map) {
        return str.startsWith(str2);
    }
}
