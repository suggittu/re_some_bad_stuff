package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@zzhb
/* loaded from: classes2.dex */
public abstract class zzhl {
    public abstract void zza(Context context, zzhf zzhfVar, VersionInfoParcel versionInfoParcel);

    protected void zze(zzhf zzhfVar) {
        zzhfVar.zzgD();
        if (zzhfVar.zzgB() != null) {
            zzhfVar.zzgB().release();
        }
    }
}
