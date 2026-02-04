package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class ResolveAccountRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzy();
    final int mVersionCode;
    private final Account zzTI;
    private final int zzamq;
    private final GoogleSignInAccount zzamr;

    ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.mVersionCode = i;
        this.zzTI = account;
        this.zzamq = i2;
        this.zzamr = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzTI;
    }

    public int getSessionId() {
        return this.zzamq;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzy.zza(this, parcel, i);
    }

    @Nullable
    public GoogleSignInAccount zzqW() {
        return this.zzamr;
    }
}
