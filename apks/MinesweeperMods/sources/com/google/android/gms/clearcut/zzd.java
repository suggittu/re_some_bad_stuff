package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

/* loaded from: classes2.dex */
public class zzd implements Parcelable.Creator {
    static void zza(LogEventParcelable logEventParcelable, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, logEventParcelable.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) logEventParcelable.zzafh, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, logEventParcelable.zzafi, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, logEventParcelable.zzafj, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzaf, reason: merged with bridge method [inline-methods] */
    public LogEventParcelable createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        byte[] bArrZzs = null;
        PlayLoggerContext playLoggerContext = null;
        int iZzg = 0;
        int[] iArrZzv = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    playLoggerContext = (PlayLoggerContext) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PlayLoggerContext.CREATOR);
                    break;
                case 3:
                    bArrZzs = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, iZzat);
                    break;
                case 4:
                    iArrZzv = com.google.android.gms.common.internal.safeparcel.zza.zzv(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new zza.C0039zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new LogEventParcelable(iZzg, playLoggerContext, bArrZzs, iArrZzv);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzbs, reason: merged with bridge method [inline-methods] */
    public LogEventParcelable[] newArray(int i) {
        return new LogEventParcelable[i];
    }
}
