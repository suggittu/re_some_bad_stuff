package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class Operator implements SafeParcelable {
    final String mTag;
    final int mVersionCode;
    public static final Parcelable.Creator CREATOR = new zzn();
    public static final Operator zzaux = new Operator("=");
    public static final Operator zzauy = new Operator("<");
    public static final Operator zzauz = new Operator("<=");
    public static final Operator zzauA = new Operator(">");
    public static final Operator zzauB = new Operator(">=");
    public static final Operator zzauC = new Operator("and");
    public static final Operator zzauD = new Operator("or");
    public static final Operator zzauE = new Operator("not");
    public static final Operator zzauF = new Operator("contains");

    Operator(int i, String str) {
        this.mVersionCode = i;
        this.mTag = str;
    }

    private Operator(String str) {
        this(1, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Operator operator = (Operator) obj;
            return this.mTag == null ? operator.mTag == null : this.mTag.equals(operator.mTag);
        }
        return false;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return (this.mTag == null ? 0 : this.mTag.hashCode()) + 31;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }
}
