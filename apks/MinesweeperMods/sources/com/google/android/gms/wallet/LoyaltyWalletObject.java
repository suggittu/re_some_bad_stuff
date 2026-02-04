package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TimeInterval;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class LoyaltyWalletObject implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzk();
    private final int mVersionCode;
    int state;
    String zzaQZ;
    String zzboP;
    String zzboQ;
    String zzboR;
    String zzboS;
    String zzboT;
    String zzboU;
    String zzboV;
    String zzboW;
    ArrayList zzboX;
    TimeInterval zzboY;
    ArrayList zzboZ;
    String zzbpa;
    String zzbpb;
    ArrayList zzbpc;
    boolean zzbpd;
    ArrayList zzbpe;
    ArrayList zzbpf;
    ArrayList zzbpg;
    LoyaltyPoints zzbph;
    String zzio;

    LoyaltyWalletObject() {
        this.mVersionCode = 4;
        this.zzboX = zzmn.zzsa();
        this.zzboZ = zzmn.zzsa();
        this.zzbpc = zzmn.zzsa();
        this.zzbpe = zzmn.zzsa();
        this.zzbpf = zzmn.zzsa();
        this.zzbpg = zzmn.zzsa();
    }

    LoyaltyWalletObject(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, ArrayList arrayList, TimeInterval timeInterval, ArrayList arrayList2, String str11, String str12, ArrayList arrayList3, boolean z, ArrayList arrayList4, ArrayList arrayList5, ArrayList arrayList6, LoyaltyPoints loyaltyPoints) {
        this.mVersionCode = i;
        this.zzio = str;
        this.zzboP = str2;
        this.zzboQ = str3;
        this.zzboR = str4;
        this.zzaQZ = str5;
        this.zzboS = str6;
        this.zzboT = str7;
        this.zzboU = str8;
        this.zzboV = str9;
        this.zzboW = str10;
        this.state = i2;
        this.zzboX = arrayList;
        this.zzboY = timeInterval;
        this.zzboZ = arrayList2;
        this.zzbpa = str11;
        this.zzbpb = str12;
        this.zzbpc = arrayList3;
        this.zzbpd = z;
        this.zzbpe = arrayList4;
        this.zzbpf = arrayList5;
        this.zzbpg = arrayList6;
        this.zzbph = loyaltyPoints;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAccountId() {
        return this.zzboP;
    }

    public final String getAccountName() {
        return this.zzaQZ;
    }

    public final String getBarcodeAlternateText() {
        return this.zzboS;
    }

    public final String getBarcodeType() {
        return this.zzboT;
    }

    public final String getBarcodeValue() {
        return this.zzboU;
    }

    public final String getId() {
        return this.zzio;
    }

    public final String getIssuerName() {
        return this.zzboQ;
    }

    public final String getProgramName() {
        return this.zzboR;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
