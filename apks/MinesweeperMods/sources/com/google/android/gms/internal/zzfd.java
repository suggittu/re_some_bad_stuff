package com.google.android.gms.internal;

import android.location.Location;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzhb
/* loaded from: classes2.dex */
public final class zzfd implements MediationAdRequest {
    private final int zzCH;
    private final Date zzbf;
    private final Set zzbh;
    private final boolean zzbi;
    private final Location zzbj;
    private final int zztT;
    private final boolean zzuf;

    public zzfd(@Nullable Date date, int i, @Nullable Set set, @Nullable Location location, boolean z, int i2, boolean z2) {
        this.zzbf = date;
        this.zztT = i;
        this.zzbh = set;
        this.zzbj = location;
        this.zzbi = z;
        this.zzCH = i2;
        this.zzuf = z2;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Date getBirthday() {
        return this.zzbf;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int getGender() {
        return this.zztT;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set getKeywords() {
        return this.zzbh;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Location getLocation() {
        return this.zzbj;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isDesignedForFamilies() {
        return this.zzuf;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.zzbi;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.zzCH;
    }
}
