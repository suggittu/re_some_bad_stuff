package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public class Asset implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zze();
    final int mVersionCode;
    public Uri uri;
    private byte[] zzaKm;
    private String zzbqU;
    public ParcelFileDescriptor zzbqV;

    Asset(int i, byte[] bArr, String str, ParcelFileDescriptor parcelFileDescriptor, Uri uri) {
        this.mVersionCode = i;
        this.zzaKm = bArr;
        this.zzbqU = str;
        this.zzbqV = parcelFileDescriptor;
        this.uri = uri;
    }

    public static Asset createFromBytes(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Asset data cannot be null");
        }
        return new Asset(1, bArr, null, null, null);
    }

    public static Asset createFromFd(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor == null) {
            throw new IllegalArgumentException("Asset fd cannot be null");
        }
        return new Asset(1, null, null, parcelFileDescriptor, null);
    }

    public static Asset createFromRef(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Asset digest cannot be null");
        }
        return new Asset(1, null, str, null, null);
    }

    public static Asset createFromUri(Uri uri) {
        if (uri == null) {
            throw new IllegalArgumentException("Asset uri cannot be null");
        }
        return new Asset(1, null, null, null, uri);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) obj;
        return zzw.equal(this.zzaKm, asset.zzaKm) && zzw.equal(this.zzbqU, asset.zzbqU) && zzw.equal(this.zzbqV, asset.zzbqV) && zzw.equal(this.uri, asset.uri);
    }

    public byte[] getData() {
        return this.zzaKm;
    }

    public String getDigest() {
        return this.zzbqU;
    }

    public ParcelFileDescriptor getFd() {
        return this.zzbqV;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaKm, this.zzbqU, this.zzbqV, this.uri);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asset[@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.zzbqU == null) {
            sb.append(", nodigest");
        } else {
            sb.append(", ");
            sb.append(this.zzbqU);
        }
        if (this.zzaKm != null) {
            sb.append(", size=");
            sb.append(this.zzaKm.length);
        }
        if (this.zzbqV != null) {
            sb.append(", fd=");
            sb.append(this.zzbqV);
        }
        if (this.uri != null) {
            sb.append(", uri=");
            sb.append(this.uri);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i | 1);
    }
}
