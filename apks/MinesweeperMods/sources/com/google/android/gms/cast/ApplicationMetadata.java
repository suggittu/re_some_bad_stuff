package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class ApplicationMetadata implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zza();
    String mName;
    private final int mVersionCode;
    String zzZC;
    List zzZD;
    String zzZE;
    Uri zzZF;
    List zzxX;

    private ApplicationMetadata() {
        this.mVersionCode = 1;
        this.zzxX = new ArrayList();
        this.zzZD = new ArrayList();
    }

    ApplicationMetadata(int i, String str, String str2, List list, List list2, String str3, Uri uri) {
        this.mVersionCode = i;
        this.zzZC = str;
        this.mName = str2;
        this.zzxX = list;
        this.zzZD = list2;
        this.zzZE = str3;
        this.zzZF = uri;
    }

    public final boolean areNamespacesSupported(List list) {
        return this.zzZD != null && this.zzZD.containsAll(list);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return zzf.zza(this.zzZC, applicationMetadata.zzZC) && zzf.zza(this.zzxX, applicationMetadata.zzxX) && zzf.zza(this.mName, applicationMetadata.mName) && zzf.zza(this.zzZD, applicationMetadata.zzZD) && zzf.zza(this.zzZE, applicationMetadata.zzZE) && zzf.zza(this.zzZF, applicationMetadata.zzZF);
    }

    public final String getApplicationId() {
        return this.zzZC;
    }

    public final List getImages() {
        return this.zzxX;
    }

    public final String getName() {
        return this.mName;
    }

    public final String getSenderAppIdentifier() {
        return this.zzZE;
    }

    public final List getSupportedNamespaces() {
        return Collections.unmodifiableList(this.zzZD);
    }

    final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.zzZC, this.mName, this.zzxX, this.zzZD, this.zzZE, this.zzZF);
    }

    public final boolean isNamespaceSupported(String str) {
        return this.zzZD != null && this.zzZD.contains(str);
    }

    public final String toString() {
        return "applicationId: " + this.zzZC + ", name: " + this.mName + ", images.count: " + (this.zzxX == null ? 0 : this.zzxX.size()) + ", namespaces.count: " + (this.zzZD != null ? this.zzZD.size() : 0) + ", senderAppIdentifier: " + this.zzZE + ", senderAppLaunchUrl: " + this.zzZF;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public final Uri zznx() {
        return this.zzZF;
    }
}
