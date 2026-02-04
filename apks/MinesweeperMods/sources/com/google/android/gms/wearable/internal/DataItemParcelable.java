package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class DataItemParcelable implements SafeParcelable, DataItem {
    public static final Parcelable.Creator CREATOR = new zzae();
    private final Uri mUri;
    final int mVersionCode;
    private byte[] zzaKm;
    private final Map zzbsy;

    DataItemParcelable(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.mVersionCode = i;
        this.mUri = uri;
        HashMap map = new HashMap();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (String str : bundle.keySet()) {
            map.put(str, (DataItemAssetParcelable) bundle.getParcelable(str));
        }
        this.zzbsy = map;
        this.zzaKm = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Map getAssets() {
        return this.zzbsy;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public byte[] getData() {
        return this.zzaKm;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public Uri getUri() {
        return this.mUri;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean z) {
        StringBuilder sb = new StringBuilder("DataItemParcelable[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(",dataSz=" + (this.zzaKm == null ? "null" : Integer.valueOf(this.zzaKm.length)));
        sb.append(", numAssets=" + this.zzbsy.size());
        sb.append(", uri=" + this.mUri);
        if (!z) {
            sb.append("]");
            return sb.toString();
        }
        sb.append("]\n  assets: ");
        for (String str : this.zzbsy.keySet()) {
            sb.append("\n    " + str + ": " + this.zzbsy.get(str));
        }
        sb.append("\n  ]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzIN, reason: merged with bridge method [inline-methods] */
    public DataItemParcelable freeze() {
        return this;
    }

    public Bundle zzIv() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        for (Map.Entry entry : this.zzbsy.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), new DataItemAssetParcelable((DataItemAsset) entry.getValue()));
        }
        return bundle;
    }

    @Override // com.google.android.gms.wearable.DataItem
    /* renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public DataItemParcelable setData(byte[] bArr) {
        this.zzaKm = bArr;
        return this;
    }
}
