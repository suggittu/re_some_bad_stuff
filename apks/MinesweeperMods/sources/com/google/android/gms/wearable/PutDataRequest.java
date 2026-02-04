package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class PutDataRequest implements SafeParcelable {
    public static final String WEAR_URI_SCHEME = "wear";
    private final Uri mUri;
    final int mVersionCode;
    private byte[] zzaKm;
    private final Bundle zzbrh;
    private long zzbri;
    public static final Parcelable.Creator CREATOR = new zzh();
    private static final long zzbrf = TimeUnit.MINUTES.toMillis(30);
    private static final Random zzbrg = new SecureRandom();

    private PutDataRequest(int i, Uri uri) {
        this(i, uri, new Bundle(), null, zzbrf);
    }

    PutDataRequest(int i, Uri uri, Bundle bundle, byte[] bArr, long j) {
        this.mVersionCode = i;
        this.mUri = uri;
        this.zzbrh = bundle;
        this.zzbrh.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.zzaKm = bArr;
        this.zzbri = j;
    }

    public static PutDataRequest create(String str) {
        return zzr(zzgL(str));
    }

    public static PutDataRequest createFromDataItem(DataItem dataItem) {
        PutDataRequest putDataRequestZzr = zzr(dataItem.getUri());
        for (Map.Entry entry : dataItem.getAssets().entrySet()) {
            if (((DataItemAsset) entry.getValue()).getId() == null) {
                throw new IllegalStateException("Cannot create an asset for a put request without a digest: " + ((String) entry.getKey()));
            }
            putDataRequestZzr.putAsset((String) entry.getKey(), Asset.createFromRef(((DataItemAsset) entry.getValue()).getId()));
        }
        putDataRequestZzr.setData(dataItem.getData());
        return putDataRequestZzr;
    }

    public static PutDataRequest createWithAutoAppendedId(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!str.endsWith("/")) {
            sb.append("/");
        }
        sb.append("PN").append(zzbrg.nextLong());
        return new PutDataRequest(2, zzgL(sb.toString()));
    }

    private static Uri zzgL(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        }
        if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
        if (str.startsWith("//")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
        return new Uri.Builder().scheme(WEAR_URI_SCHEME).path(str).build();
    }

    public static PutDataRequest zzr(Uri uri) {
        return new PutDataRequest(2, uri);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Asset getAsset(String str) {
        return (Asset) this.zzbrh.getParcelable(str);
    }

    public Map getAssets() {
        HashMap map = new HashMap();
        for (String str : this.zzbrh.keySet()) {
            map.put(str, (Asset) this.zzbrh.getParcelable(str));
        }
        return Collections.unmodifiableMap(map);
    }

    public byte[] getData() {
        return this.zzaKm;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean hasAsset(String str) {
        return this.zzbrh.containsKey(str);
    }

    public boolean isUrgent() {
        return this.zzbri == 0;
    }

    public PutDataRequest putAsset(String str, Asset asset) {
        zzx.zzz(str);
        zzx.zzz(asset);
        this.zzbrh.putParcelable(str, asset);
        return this;
    }

    public PutDataRequest removeAsset(String str) {
        this.zzbrh.remove(str);
        return this;
    }

    public PutDataRequest setData(byte[] bArr) {
        this.zzaKm = bArr;
        return this;
    }

    public PutDataRequest setUrgent() {
        this.zzbri = 0L;
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable(DataMap.TAG, 3));
    }

    public String toString(boolean z) {
        StringBuilder sb = new StringBuilder("PutDataRequest[");
        sb.append("dataSz=" + (this.zzaKm == null ? "null" : Integer.valueOf(this.zzaKm.length)));
        sb.append(", numAssets=" + this.zzbrh.size());
        sb.append(", uri=" + this.mUri);
        sb.append(", syncDeadline=" + this.zzbri);
        if (!z) {
            sb.append("]");
            return sb.toString();
        }
        sb.append("]\n  assets: ");
        for (String str : this.zzbrh.keySet()) {
            sb.append("\n    " + str + ": " + this.zzbrh.getParcelable(str));
        }
        sb.append("\n  ]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public Bundle zzIv() {
        return this.zzbrh;
    }

    public long zzIw() {
        return this.zzbri;
    }
}
