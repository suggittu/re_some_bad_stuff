package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.zzow;

/* loaded from: classes2.dex */
public class SubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzaf();
    private final int mVersionCode;
    private final zzow zzaAD;
    private Subscription zzaBC;
    private final boolean zzaBD;

    SubscribeRequest(int i, Subscription subscription, boolean z, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaBC = subscription;
        this.zzaBD = z;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    public SubscribeRequest(Subscription subscription, boolean z, zzow zzowVar) {
        this.mVersionCode = 3;
        this.zzaBC = subscription;
        this.zzaBD = z;
        this.zzaAD = zzowVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg("subscription", this.zzaBC).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaf.zza(this, parcel, i);
    }

    public Subscription zzvh() {
        return this.zzaBC;
    }

    public boolean zzvi() {
        return this.zzaBD;
    }
}
