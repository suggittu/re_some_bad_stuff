package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public class DocumentSection implements SafeParcelable {
    final int mVersionCode;
    public final String zzTO;
    final RegisterSectionInfo zzTP;
    public final int zzTQ;
    public final byte[] zzTR;
    public static final int zzTM = Integer.parseInt("-1");
    public static final zzd CREATOR = new zzd();
    private static final RegisterSectionInfo zzTN = new RegisterSectionInfo.zza("SsbContext").zzM(true).zzbB("blob").zzmh();

    DocumentSection(int i, String str, RegisterSectionInfo registerSectionInfo, int i2, byte[] bArr) {
        zzx.zzb(i2 == zzTM || zzh.zzao(i2) != null, "Invalid section type " + i2);
        this.mVersionCode = i;
        this.zzTO = str;
        this.zzTP = registerSectionInfo;
        this.zzTQ = i2;
        this.zzTR = bArr;
        String strZzmf = zzmf();
        if (strZzmf != null) {
            throw new IllegalArgumentException(strZzmf);
        }
    }

    public DocumentSection(String str, RegisterSectionInfo registerSectionInfo) {
        this(1, str, registerSectionInfo, zzTM, null);
    }

    public DocumentSection(String str, RegisterSectionInfo registerSectionInfo, String str2) {
        this(1, str, registerSectionInfo, zzh.zzbA(str2), null);
    }

    public DocumentSection(byte[] bArr, RegisterSectionInfo registerSectionInfo) {
        this(1, null, registerSectionInfo, zzTM, bArr);
    }

    public static DocumentSection zzh(byte[] bArr) {
        return new DocumentSection(bArr, zzTN);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzd zzdVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd zzdVar = CREATOR;
        zzd.zza(this, parcel, i);
    }

    public String zzmf() {
        if (this.zzTQ != zzTM && zzh.zzao(this.zzTQ) == null) {
            return "Invalid section type " + this.zzTQ;
        }
        if (this.zzTO == null || this.zzTR == null) {
            return null;
        }
        return "Both content and blobContent set";
    }
}
