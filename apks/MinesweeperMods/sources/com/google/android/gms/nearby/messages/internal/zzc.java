package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzc implements Parcelable.Creator {
    static void zza(HandleClientLifecycleEventRequest handleClientLifecycleEventRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, handleClientLifecycleEventRequest.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) handleClientLifecycleEventRequest.zzbcs, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, handleClientLifecycleEventRequest.zzbct);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzgi, reason: merged with bridge method [inline-methods] */
    public HandleClientLifecycleEventRequest createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        ClientAppContext clientAppContext = null;
        int iZzg = 0;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    clientAppContext = (ClientAppContext) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ClientAppContext.CREATOR);
                    break;
                case 3:
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
        return new HandleClientLifecycleEventRequest(iZzg, clientAppContext, iZzg2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzjn, reason: merged with bridge method [inline-methods] */
    public HandleClientLifecycleEventRequest[] newArray(int i) {
        return new HandleClientLifecycleEventRequest[i];
    }
}
