package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmr;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class DriveSpace implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzg();
    public static final DriveSpace zzaoP = new DriveSpace("DRIVE");
    public static final DriveSpace zzaoQ = new DriveSpace("APP_DATA_FOLDER");
    public static final DriveSpace zzaoR = new DriveSpace("PHOTOS");
    public static final Set zzaoS = zzmr.zza(zzaoP, zzaoQ, zzaoR);
    public static final String zzaoT = TextUtils.join(",", zzaoS.toArray());
    private static final Pattern zzaoU = Pattern.compile("[A-Z0-9_]*");
    private final String mName;
    final int mVersionCode;

    DriveSpace(int i, String str) {
        this.mVersionCode = i;
        this.mName = (String) zzx.zzz(str);
    }

    private DriveSpace(String str) {
        this(1, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != DriveSpace.class) {
            return false;
        }
        return this.mName.equals(((DriveSpace) obj).mName);
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        return 1247068382 ^ this.mName.hashCode();
    }

    public String toString() {
        return this.mName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
