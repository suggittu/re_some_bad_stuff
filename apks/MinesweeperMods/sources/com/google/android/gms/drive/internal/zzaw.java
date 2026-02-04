package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.Contents;

/* loaded from: classes2.dex */
public class zzaw implements Parcelable.Creator {
    static void zza(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, onContentsResponse.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) onContentsResponse.zzara, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, onContentsResponse.zzasf);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzbz, reason: merged with bridge method [inline-methods] */
    public OnContentsResponse createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        Contents contents = null;
        int iZzg = 0;
        boolean zZzc = false;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    contents = (Contents) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Contents.CREATOR);
                    break;
                case 3:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new zza.C0039zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new OnContentsResponse(iZzg, contents, zZzc);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzdu, reason: merged with bridge method [inline-methods] */
    public OnContentsResponse[] newArray(int i) {
        return new OnContentsResponse[i];
    }
}
