package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzc implements Parcelable.Creator {
    static void zza(SharedContent sharedContent, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, sharedContent.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, sharedContent.getUri(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable[]) sharedContent.zzEL(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, (Parcelable[]) sharedContent.zzEM(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzgs, reason: merged with bridge method [inline-methods] */
    public SharedContent createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        ViewableItem[] viewableItemArr = null;
        String strZzp = null;
        int iZzg = 0;
        LocalContent[] localContentArr = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
                case 3:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 8:
                    viewableItemArr = (ViewableItem[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat, ViewableItem.CREATOR);
                    break;
                case 9:
                    localContentArr = (LocalContent[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat, LocalContent.CREATOR);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new zza.C0039zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new SharedContent(iZzg, strZzp, viewableItemArr, localContentArr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzjy, reason: merged with bridge method [inline-methods] */
    public SharedContent[] newArray(int i) {
        return new SharedContent[i];
    }
}
