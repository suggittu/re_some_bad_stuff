package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class SharedContent implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzc();
    private final int versionCode;

    @Deprecated
    private String zzbdg;
    private ViewableItem[] zzbdh;
    private LocalContent[] zzbdi;

    private SharedContent() {
        this.versionCode = 2;
    }

    SharedContent(int i, String str, ViewableItem[] viewableItemArr, LocalContent[] localContentArr) {
        this.versionCode = i;
        this.zzbdg = str;
        this.zzbdh = viewableItemArr;
        this.zzbdi = localContentArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SharedContent)) {
            return false;
        }
        SharedContent sharedContent = (SharedContent) obj;
        return zzw.equal(this.zzbdh, sharedContent.zzbdh) && zzw.equal(this.zzbdi, sharedContent.zzbdi) && zzw.equal(this.zzbdg, sharedContent.zzbdg);
    }

    public String getUri() {
        return this.zzbdg;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbdh, this.zzbdi, this.zzbdg);
    }

    public String toString() {
        return "SharedContent[viewableItems=" + Arrays.toString(this.zzbdh) + ", localContents=" + Arrays.toString(this.zzbdi) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public ViewableItem[] zzEL() {
        return this.zzbdh;
    }

    public LocalContent[] zzEM() {
        return this.zzbdi;
    }
}
