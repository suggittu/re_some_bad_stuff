package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class PlusSession implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    private final int mVersionCode;
    private final String zzVa;
    private final String zzada;
    private final String[] zzber;
    private final String[] zzbes;
    private final String[] zzbet;
    private final String zzbeu;
    private final String zzbev;
    private final String zzbew;
    private final PlusCommonExtras zzbex;

    PlusSession(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.mVersionCode = i;
        this.zzVa = str;
        this.zzber = strArr;
        this.zzbes = strArr2;
        this.zzbet = strArr3;
        this.zzbeu = str2;
        this.zzbev = str3;
        this.zzada = str4;
        this.zzbew = str5;
        this.zzbex = plusCommonExtras;
    }

    public PlusSession(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.mVersionCode = 1;
        this.zzVa = str;
        this.zzber = strArr;
        this.zzbes = strArr2;
        this.zzbet = strArr3;
        this.zzbeu = str2;
        this.zzbev = str3;
        this.zzada = str4;
        this.zzbew = null;
        this.zzbex = plusCommonExtras;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusSession)) {
            return false;
        }
        PlusSession plusSession = (PlusSession) obj;
        return this.mVersionCode == plusSession.mVersionCode && zzw.equal(this.zzVa, plusSession.zzVa) && Arrays.equals(this.zzber, plusSession.zzber) && Arrays.equals(this.zzbes, plusSession.zzbes) && Arrays.equals(this.zzbet, plusSession.zzbet) && zzw.equal(this.zzbeu, plusSession.zzbeu) && zzw.equal(this.zzbev, plusSession.zzbev) && zzw.equal(this.zzada, plusSession.zzada) && zzw.equal(this.zzbew, plusSession.zzbew) && zzw.equal(this.zzbex, plusSession.zzbex);
    }

    public String getAccountName() {
        return this.zzVa;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.zzVa, this.zzber, this.zzbes, this.zzbet, this.zzbeu, this.zzbev, this.zzada, this.zzbew, this.zzbex);
    }

    public String toString() {
        return zzw.zzy(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("accountName", this.zzVa).zzg("requestedScopes", this.zzber).zzg("visibleActivities", this.zzbes).zzg("requiredFeatures", this.zzbet).zzg("packageNameForAuth", this.zzbeu).zzg("callingPackageName", this.zzbev).zzg("applicationName", this.zzada).zzg("extra", this.zzbex.toString()).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public String[] zzFd() {
        return this.zzber;
    }

    public String[] zzFe() {
        return this.zzbes;
    }

    public String[] zzFf() {
        return this.zzbet;
    }

    public String zzFg() {
        return this.zzbeu;
    }

    public String zzFh() {
        return this.zzbev;
    }

    public String zzFi() {
        return this.zzbew;
    }

    public PlusCommonExtras zzFj() {
        return this.zzbex;
    }

    public Bundle zzFk() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.zzbex.zzJ(bundle);
        return bundle;
    }

    public String zznX() {
        return this.zzada;
    }
}
