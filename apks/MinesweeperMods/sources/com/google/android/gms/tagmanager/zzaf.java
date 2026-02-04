package com.google.android.gms.tagmanager;

import java.util.Map;

/* loaded from: classes2.dex */
public class zzaf extends zzcz {
    private static final String ID = com.google.android.gms.internal.zzad.EQUALS.toString();

    public zzaf() {
        super(ID);
    }

    @Override // com.google.android.gms.tagmanager.zzcz
    protected boolean zza(String str, String str2, Map map) {
        return str.equals(str2);
    }
}
