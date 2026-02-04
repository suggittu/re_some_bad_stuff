package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzh implements Parcelable.Creator {
    static void zza(GeneratePasswordRequest generatePasswordRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) generatePasswordRequest.zzmr(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, generatePasswordRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzL, reason: merged with bridge method [inline-methods] */
    public GeneratePasswordRequest createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        PasswordSpecification passwordSpecification = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    passwordSpecification = (PasswordSpecification) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PasswordSpecification.CREATOR);
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
        return new GeneratePasswordRequest(iZzg, passwordSpecification);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: zzaG, reason: merged with bridge method [inline-methods] */
    public GeneratePasswordRequest[] newArray(int i) {
        return new GeneratePasswordRequest[i];
    }
}
