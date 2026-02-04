package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

/* loaded from: classes2.dex */
public class MessageEventParcelable implements SafeParcelable, MessageEvent {
    public static final Parcelable.Creator CREATOR = new zzba();
    private final String mPath;
    final int mVersionCode;
    private final byte[] zzaKm;
    private final String zzaPI;
    private final int zzaox;

    MessageEventParcelable(int i, int i2, String str, byte[] bArr, String str2) {
        this.mVersionCode = i;
        this.zzaox = i2;
        this.mPath = str;
        this.zzaKm = bArr;
        this.zzaPI = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public byte[] getData() {
        return this.zzaKm;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public String getPath() {
        return this.mPath;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public int getRequestId() {
        return this.zzaox;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public String getSourceNodeId() {
        return this.zzaPI;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.zzaox + "," + this.mPath + ", size=" + (this.zzaKm == null ? "null" : Integer.valueOf(this.zzaKm.length)) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzba.zza(this, parcel, i);
    }
}
