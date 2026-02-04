package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzg implements Parcelable.Creator {
    static void zza(PointOfInterest pointOfInterest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, pointOfInterest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) pointOfInterest.zzaTG, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, pointOfInterest.zzaTH, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, pointOfInterest.name, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzfB, reason: merged with bridge method [inline-methods] */
    public PointOfInterest createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        String strZzp = null;
        LatLng latLng = null;
        int iZzg = 0;
        String strZzp2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, LatLng.CREATOR);
                    break;
                case 3:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new zza.C0039zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new PointOfInterest(iZzg, latLng, strZzp, strZzp2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzip, reason: merged with bridge method [inline-methods] */
    public PointOfInterest[] newArray(int i) {
        return new PointOfInterest[i];
    }
}
