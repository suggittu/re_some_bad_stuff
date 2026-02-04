package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zzoz;

/* loaded from: classes2.dex */
public final class Device implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzi();
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;
    private final int mVersionCode;
    private final int zzabB;
    private final String zzadc;
    private final String zzawI;
    private final String zzawJ;
    private final String zzawK;
    private final int zzawL;

    Device(int i, String str, String str2, String str3, String str4, int i2, int i3) {
        this.mVersionCode = i;
        this.zzawI = (String) zzx.zzz(str);
        this.zzawJ = (String) zzx.zzz(str2);
        this.zzadc = "";
        this.zzawK = (String) zzx.zzz(str4);
        this.zzabB = i2;
        this.zzawL = i3;
    }

    public Device(String str, String str2, String str3, int i) {
        this(str, str2, "", str3, i, 0);
    }

    public Device(String str, String str2, String str3, String str4, int i, int i2) {
        this(1, str, str2, "", str4, i, i2);
    }

    public static Device getLocalDevice(Context context) {
        int iZzaG = zznv.zzaG(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, zzaC(context), iZzaG, 2);
    }

    private boolean zza(Device device) {
        return zzw.equal(this.zzawI, device.zzawI) && zzw.equal(this.zzawJ, device.zzawJ) && zzw.equal(this.zzadc, device.zzadc) && zzw.equal(this.zzawK, device.zzawK) && this.zzabB == device.zzabB && this.zzawL == device.zzawL;
    }

    private static String zzaC(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    private boolean zzus() {
        return zzur() == 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof Device) && zza((Device) obj));
    }

    public final String getManufacturer() {
        return this.zzawI;
    }

    public final String getModel() {
        return this.zzawJ;
    }

    final String getStreamIdentifier() {
        return String.format("%s:%s:%s", this.zzawI, this.zzawJ, this.zzawK);
    }

    public final int getType() {
        return this.zzabB;
    }

    public final String getUid() {
        return this.zzawK;
    }

    public final String getVersion() {
        return this.zzadc;
    }

    final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zzw.hashCode(this.zzawI, this.zzawJ, this.zzadc, this.zzawK, Integer.valueOf(this.zzabB));
    }

    public final String toString() {
        return String.format("Device{%s:%s:%s:%s}", getStreamIdentifier(), this.zzadc, Integer.valueOf(this.zzabB), Integer.valueOf(this.zzawL));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public final int zzur() {
        return this.zzawL;
    }

    public final String zzut() {
        return zzus() ? this.zzawK : zzoz.zzdF(this.zzawK);
    }
}
