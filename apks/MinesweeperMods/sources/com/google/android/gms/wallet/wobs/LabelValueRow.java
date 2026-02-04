package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmn;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class LabelValueRow implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzc();
    private final int mVersionCode;
    String zzbqF;
    String zzbqG;
    ArrayList zzbqH;

    LabelValueRow() {
        this.mVersionCode = 1;
        this.zzbqH = zzmn.zzsa();
    }

    LabelValueRow(int i, String str, String str2, ArrayList arrayList) {
        this.mVersionCode = i;
        this.zzbqF = str;
        this.zzbqG = str2;
        this.zzbqH = arrayList;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
