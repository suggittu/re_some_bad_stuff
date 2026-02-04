package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzp;
import java.util.Collection;

/* loaded from: classes2.dex */
public class GetServiceRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzi();
    final int version;
    final int zzall;
    int zzalm;
    String zzaln;
    IBinder zzalo;
    Scope[] zzalp;
    Bundle zzalq;
    Account zzalr;

    public GetServiceRequest(int i) {
        this.version = 2;
        this.zzalm = com.google.android.gms.common.zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzall = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account) {
        this.version = i;
        this.zzall = i2;
        this.zzalm = i3;
        this.zzaln = str;
        if (i < 2) {
            this.zzalr = zzaO(iBinder);
        } else {
            this.zzalo = iBinder;
            this.zzalr = account;
        }
        this.zzalp = scopeArr;
        this.zzalq = bundle;
    }

    private Account zzaO(IBinder iBinder) {
        if (iBinder != null) {
            return zza.zza(zzp.zza.zzaP(iBinder));
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public GetServiceRequest zzb(zzp zzpVar) {
        if (zzpVar != null) {
            this.zzalo = zzpVar.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzc(Account account) {
        this.zzalr = account;
        return this;
    }

    public GetServiceRequest zzcG(String str) {
        this.zzaln = str;
        return this;
    }

    public GetServiceRequest zzd(Collection collection) {
        this.zzalp = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public GetServiceRequest zzj(Bundle bundle) {
        this.zzalq = bundle;
        return this;
    }
}
