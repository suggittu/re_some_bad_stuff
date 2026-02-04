package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.Collections;
import java.util.List;

@zzhb
/* loaded from: classes2.dex */
public class zzbn implements zzbo {
    @Override // com.google.android.gms.internal.zzbo
    public List zza(AdRequestInfoParcel adRequestInfoParcel) {
        return adRequestInfoParcel.zzHJ == null ? Collections.emptyList() : adRequestInfoParcel.zzHJ;
    }
}
