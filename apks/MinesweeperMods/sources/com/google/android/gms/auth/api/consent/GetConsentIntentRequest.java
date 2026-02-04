package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public class GetConsentIntentRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    private final Account zzTI;
    private final String zzVO;
    private final int zzVP;
    private final String zzVQ;
    final ScopeDetail[] zzVR;
    private final boolean zzVS;
    private final int zzVT;
    private final String zzVU;

    GetConsentIntentRequest(int i, String str, int i2, String str2, Account account, ScopeDetail[] scopeDetailArr, boolean z, int i3, String str3) {
        this.mVersionCode = i;
        this.zzVO = str;
        this.zzVP = i2;
        this.zzVQ = str2;
        this.zzTI = (Account) zzx.zzz(account);
        this.zzVR = scopeDetailArr;
        this.zzVS = z;
        this.zzVT = i3;
        this.zzVU = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzTI;
    }

    public String getCallingPackage() {
        return this.zzVO;
    }

    public int getCallingUid() {
        return this.zzVP;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public String zzmt() {
        return this.zzVQ;
    }

    public boolean zzmu() {
        return this.zzVS;
    }

    public int zzmv() {
        return this.zzVT;
    }

    public String zzmw() {
        return this.zzVU;
    }
}
