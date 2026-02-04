package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public final class Application implements SafeParcelable {
    private final int mVersionCode;
    private final String zzTJ;
    private final String zzadc;
    private final String zzawb;
    public static final Application zzawa = new Application("com.google.android.gms", String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), null);
    public static final Parcelable.Creator CREATOR = new zza();

    Application(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.zzTJ = (String) zzx.zzz(str);
        this.zzadc = "";
        this.zzawb = str3;
    }

    public Application(String str, String str2, String str3) {
        this(1, str, "", str3);
    }

    private boolean zza(Application application) {
        return this.zzTJ.equals(application.zzTJ) && zzw.equal(this.zzadc, application.zzadc) && zzw.equal(this.zzawb, application.zzawb);
    }

    public static Application zzdn(String str) {
        return zzg(str, null, null);
    }

    public static Application zzg(String str, String str2, String str3) {
        return "com.google.android.gms".equals(str) ? zzawa : new Application(str, str2, str3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj || ((obj instanceof Application) && zza((Application) obj));
    }

    public final String getPackageName() {
        return this.zzTJ;
    }

    public final String getVersion() {
        return this.zzadc;
    }

    final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zzw.hashCode(this.zzTJ, this.zzadc, this.zzawb);
    }

    public final String toString() {
        return String.format("Application{%s:%s:%s}", this.zzTJ, this.zzadc, this.zzawb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public final String zzua() {
        return this.zzawb;
    }
}
