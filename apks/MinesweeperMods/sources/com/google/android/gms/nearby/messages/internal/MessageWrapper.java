package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;

/* loaded from: classes2.dex */
public class MessageWrapper implements SafeParcelable {
    public static final zzl CREATOR = new zzl();
    final int mVersionCode;
    public final Message zzbcu;

    MessageWrapper(int i, Message message) {
        this.mVersionCode = i;
        this.zzbcu = (Message) zzx.zzz(message);
    }

    public static final MessageWrapper zzb(Message message) {
        return new MessageWrapper(1, message);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzl zzlVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageWrapper) {
            return zzw.equal(this.zzbcu, ((MessageWrapper) obj).zzbcu);
        }
        return false;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbcu);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl zzlVar = CREATOR;
        zzl.zza(this, parcel, i);
    }
}
