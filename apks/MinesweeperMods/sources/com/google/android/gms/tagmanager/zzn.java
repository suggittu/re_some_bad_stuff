package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes2.dex */
class zzn extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.CONSTANT.toString();
    private static final String VALUE = com.google.android.gms.internal.zzae.VALUE.toString();

    public zzn() {
        super(ID, VALUE);
    }

    public static String zzFZ() {
        return ID;
    }

    public static String zzGa() {
        return VALUE;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzP(Map map) {
        return (zzag.zza) map.get(VALUE);
    }
}
