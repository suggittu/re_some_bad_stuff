package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

/* loaded from: classes2.dex */
public class zzg implements zzf {
    private Boolean zzaut = false;

    private zzg() {
    }

    public static boolean zza(Filter filter) {
        if (filter == null) {
            return false;
        }
        return ((Boolean) filter.zza(new zzg())).booleanValue();
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public Boolean zzb(com.google.android.gms.drive.metadata.zzb zzbVar, Object obj) {
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public Boolean zzb(Operator operator, MetadataField metadataField, Object obj) {
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public Boolean zzb(Operator operator, List list) {
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public Boolean zzB(Boolean bool) {
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zzdk, reason: merged with bridge method [inline-methods] */
    public Boolean zzdj(String str) {
        if (!str.isEmpty()) {
            this.zzaut = true;
        }
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public Boolean zze(MetadataField metadataField) {
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public Boolean zze(MetadataField metadataField, Object obj) {
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zztR, reason: merged with bridge method [inline-methods] */
    public Boolean zztQ() {
        return this.zzaut;
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zztS, reason: merged with bridge method [inline-methods] */
    public Boolean zztP() {
        return this.zzaut;
    }
}
