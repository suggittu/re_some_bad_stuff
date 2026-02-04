package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public final class zzc {
    public static SafeParcelable zza(Intent intent, String str, Parcelable.Creator creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return zza(byteArrayExtra, creator);
    }

    public static SafeParcelable zza(byte[] bArr, Parcelable.Creator creator) {
        zzx.zzz(creator);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) creator.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return safeParcelable;
    }

    public static void zza(SafeParcelable safeParcelable, Intent intent, String str) {
        intent.putExtra(str, zza(safeParcelable));
    }

    public static byte[] zza(SafeParcelable safeParcelable) {
        Parcel parcelObtain = Parcel.obtain();
        safeParcelable.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }
}
