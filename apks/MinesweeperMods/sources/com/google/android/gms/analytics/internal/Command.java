package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class Command implements Parcelable {

    @Deprecated
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.analytics.internal.Command.1
        @Override // android.os.Parcelable.Creator
        @Deprecated
        /* renamed from: zzag, reason: merged with bridge method [inline-methods] */
        public final Command[] newArray(int i) {
            return new Command[i];
        }

        @Override // android.os.Parcelable.Creator
        @Deprecated
        /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
        public final Command createFromParcel(Parcel parcel) {
            return new Command(parcel);
        }
    };
    private String mValue;
    private String zzRt;
    private String zzyv;

    @Deprecated
    public Command() {
    }

    @Deprecated
    Command(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Deprecated
    private void readFromParcel(Parcel parcel) {
        this.zzyv = parcel.readString();
        this.zzRt = parcel.readString();
        this.mValue = parcel.readString();
    }

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzyv;
    }

    public String getValue() {
        return this.mValue;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzyv);
        parcel.writeString(this.zzRt);
        parcel.writeString(this.mValue);
    }
}
