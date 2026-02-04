package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zze implements Parcelable.Creator {
    static void zza(DriveId driveId, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, driveId.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, driveId.zzaoL, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, driveId.zzaoM);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, driveId.zzaou);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, driveId.zzaoN);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzaK, reason: merged with bridge method [inline-methods] */
    public DriveId createFromParcel(Parcel parcel) {
        long jZzi = 0;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        int iZzg2 = -1;
        long jZzi2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 4:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 5:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new zza.C0039zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new DriveId(iZzg, strZzp, jZzi2, jZzi, iZzg2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzct, reason: merged with bridge method [inline-methods] */
    public DriveId[] newArray(int i) {
        return new DriveId[i];
    }
}
