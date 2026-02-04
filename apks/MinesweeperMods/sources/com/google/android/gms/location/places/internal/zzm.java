package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzm implements Parcelable.Creator {
    static void zza(PlaceLikelihoodEntity placeLikelihoodEntity, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) placeLikelihoodEntity.zzaQM, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, placeLikelihoodEntity.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, placeLikelihoodEntity.zzaQN);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzfm, reason: merged with bridge method [inline-methods] */
    public PlaceLikelihoodEntity createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        PlaceImpl placeImpl = null;
        float fZzl = 0.0f;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    placeImpl = (PlaceImpl) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PlaceImpl.CREATOR);
                    break;
                case 2:
                    fZzl = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    break;
                case 1000:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new zza.C0039zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new PlaceLikelihoodEntity(iZzg, placeImpl, fZzl);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzhZ, reason: merged with bridge method [inline-methods] */
    public PlaceLikelihoodEntity[] newArray(int i) {
        return new PlaceLikelihoodEntity[i];
    }
}
