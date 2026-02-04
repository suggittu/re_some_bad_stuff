package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class ViewableItem implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzf();
    private final int versionCode;
    private String[] zzbdj;

    private ViewableItem() {
        this.versionCode = 1;
    }

    ViewableItem(int i, String[] strArr) {
        this.versionCode = i;
        this.zzbdj = strArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ViewableItem) {
            return zzw.equal(this.zzbdj, ((ViewableItem) obj).zzbdj);
        }
        return false;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbdj);
    }

    public String toString() {
        return "ViewableItem[uris=" + Arrays.toString(this.zzbdj) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public String[] zzEN() {
        return this.zzbdj;
    }
}
