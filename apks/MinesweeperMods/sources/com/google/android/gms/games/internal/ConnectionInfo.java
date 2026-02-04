package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class ConnectionInfo implements SafeParcelable {
    public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
    private final int mVersionCode;
    private final String zzaDX;
    private final int zzaDY;

    public ConnectionInfo(int i, String str, int i2) {
        this.mVersionCode = i;
        this.zzaDX = str;
        this.zzaDY = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ConnectionInfoCreator.zza(this, parcel, i);
    }

    public String zzwt() {
        return this.zzaDX;
    }

    public int zzwu() {
        return this.zzaDY;
    }
}
