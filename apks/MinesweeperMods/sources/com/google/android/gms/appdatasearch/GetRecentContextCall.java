package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes2.dex */
public class GetRecentContextCall {

    public class Request implements SafeParcelable {
        public static final zzf CREATOR = new zzf();
        final int mVersionCode;
        public final Account zzTT;
        public final boolean zzTU;
        public final boolean zzTV;
        public final boolean zzTW;
        public final String zzTX;

        public Request() {
            this(null, false, false, false, null);
        }

        Request(int i, Account account, boolean z, boolean z2, boolean z3, String str) {
            this.mVersionCode = i;
            this.zzTT = account;
            this.zzTU = z;
            this.zzTV = z2;
            this.zzTW = z3;
            this.zzTX = str;
        }

        public Request(Account account, boolean z, boolean z2, boolean z3, String str) {
            this(1, account, z, z2, z3, str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzf zzfVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzf zzfVar = CREATOR;
            zzf.zza(this, parcel, i);
        }
    }

    public class Response implements Result, SafeParcelable {
        public static final zzg CREATOR = new zzg();
        final int mVersionCode;
        public Status zzTY;
        public List zzTZ;

        @Deprecated
        public String[] zzUa;

        public Response() {
            this.mVersionCode = 1;
        }

        Response(int i, Status status, List list, String[] strArr) {
            this.mVersionCode = i;
            this.zzTY = status;
            this.zzTZ = list;
            this.zzUa = strArr;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            zzg zzgVar = CREATOR;
            return 0;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzTY;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzg zzgVar = CREATOR;
            zzg.zza(this, parcel, i);
        }
    }
}
