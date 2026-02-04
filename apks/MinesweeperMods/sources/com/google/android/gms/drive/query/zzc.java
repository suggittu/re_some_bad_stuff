package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.zzf;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class zzc implements zzf {
    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public String zzb(com.google.android.gms.drive.metadata.zzb zzbVar, Object obj) {
        return String.format("contains(%s,%s)", zzbVar.getName(), obj);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public String zzb(Operator operator, MetadataField metadataField, Object obj) {
        return String.format("cmp(%s,%s,%s)", operator.getTag(), metadataField.getName(), obj);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public String zzb(Operator operator, List list) {
        StringBuilder sb = new StringBuilder(operator.getTag() + "(");
        String str = "";
        Iterator it = list.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return sb.append(")").toString();
            }
            String str3 = (String) it.next();
            sb.append(str2);
            sb.append(str3);
            str = ",";
        }
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public String zze(MetadataField metadataField) {
        return String.format("fieldOnly(%s)", metadataField.getName());
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public String zze(MetadataField metadataField, Object obj) {
        return String.format("has(%s,%s)", metadataField.getName(), obj);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zzdh, reason: merged with bridge method [inline-methods] */
    public String zzB(String str) {
        return String.format("not(%s)", str);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zzdi, reason: merged with bridge method [inline-methods] */
    public String zzdj(String str) {
        return String.format("fullTextSearch(%s)", str);
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zztN, reason: merged with bridge method [inline-methods] */
    public String zztQ() {
        return "all()";
    }

    @Override // com.google.android.gms.drive.query.internal.zzf
    /* renamed from: zztO, reason: merged with bridge method [inline-methods] */
    public String zztP() {
        return "ownedByMe()";
    }
}
