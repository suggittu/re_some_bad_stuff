package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzo implements Parcelable.Creator {
    static void zza(ChannelImpl channelImpl, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, channelImpl.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, channelImpl.getToken(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, channelImpl.getNodeId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, channelImpl.getPath(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzig, reason: merged with bridge method [inline-methods] */
    public ChannelImpl createFromParcel(Parcel parcel) {
        String strZzp = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        String strZzp2 = null;
        int iZzg = 0;
        String strZzp3 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new zza.C0039zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new ChannelImpl(iZzg, strZzp2, strZzp3, strZzp);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzlJ, reason: merged with bridge method [inline-methods] */
    public ChannelImpl[] newArray(int i) {
        return new ChannelImpl[i];
    }
}
