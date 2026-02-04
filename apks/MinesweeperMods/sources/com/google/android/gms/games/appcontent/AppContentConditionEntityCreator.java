package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* loaded from: classes2.dex */
public class AppContentConditionEntityCreator implements Parcelable.Creator {
    static void zza(AppContentConditionEntity appContentConditionEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, appContentConditionEntity.zzwf(), false);
        zzb.zzc(parcel, 1000, appContentConditionEntity.getVersionCode());
        zzb.zza(parcel, 2, appContentConditionEntity.zzwg(), false);
        zzb.zza(parcel, 3, appContentConditionEntity.zzwh(), false);
        zzb.zza(parcel, 4, appContentConditionEntity.zzwi(), false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzei, reason: merged with bridge method [inline-methods] */
    public AppContentConditionEntity createFromParcel(Parcel parcel) {
        Bundle bundleZzr = null;
        int iZzau = zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        String strZzp2 = null;
        String strZzp3 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    strZzp3 = zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    bundleZzr = zza.zzr(parcel, iZzat);
                    break;
                case 1000:
                    iZzg = zza.zzg(parcel, iZzat);
                    break;
                default:
                    zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new zza.C0039zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new AppContentConditionEntity(iZzg, strZzp3, strZzp2, strZzp, bundleZzr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzgk, reason: merged with bridge method [inline-methods] */
    public AppContentConditionEntity[] newArray(int i) {
        return new AppContentConditionEntity[i];
    }
}
