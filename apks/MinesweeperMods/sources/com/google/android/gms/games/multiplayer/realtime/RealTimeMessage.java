package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public final class RealTimeMessage implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.games.multiplayer.realtime.RealTimeMessage.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: zzeu, reason: merged with bridge method [inline-methods] */
        public final RealTimeMessage createFromParcel(Parcel parcel) {
            return new RealTimeMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: zzgK, reason: merged with bridge method [inline-methods] */
        public final RealTimeMessage[] newArray(int i) {
            return new RealTimeMessage[i];
        }
    };
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String zzaJR;
    private final byte[] zzaJS;
    private final int zzaJT;

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String str, byte[] bArr, int i) {
        this.zzaJR = (String) zzx.zzz(str);
        this.zzaJS = (byte[]) ((byte[]) zzx.zzz(bArr)).clone();
        this.zzaJT = i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final byte[] getMessageData() {
        return this.zzaJS;
    }

    public final String getSenderParticipantId() {
        return this.zzaJR;
    }

    public final boolean isReliable() {
        return this.zzaJT == 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzaJR);
        parcel.writeByteArray(this.zzaJS);
        parcel.writeInt(this.zzaJT);
    }
}
