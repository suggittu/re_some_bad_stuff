package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.zzsi;
import com.google.android.gms.internal.zzsu;

/* loaded from: classes2.dex */
public class PutDataMapRequest {
    private final DataMap zzbrd = new DataMap();
    private final PutDataRequest zzbre;

    private PutDataMapRequest(PutDataRequest putDataRequest, DataMap dataMap) {
        this.zzbre = putDataRequest;
        if (dataMap != null) {
            this.zzbrd.putAll(dataMap);
        }
    }

    public static PutDataMapRequest create(String str) {
        return new PutDataMapRequest(PutDataRequest.create(str), null);
    }

    public static PutDataMapRequest createFromDataMapItem(DataMapItem dataMapItem) {
        return new PutDataMapRequest(PutDataRequest.zzr(dataMapItem.getUri()), dataMapItem.getDataMap());
    }

    public static PutDataMapRequest createWithAutoAppendedId(String str) {
        return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(str), null);
    }

    public PutDataRequest asPutDataRequest() {
        zzsi.zza zzaVarZza = zzsi.zza(this.zzbrd);
        this.zzbre.setData(zzsu.toByteArray(zzaVarZza.zzbty));
        int size = zzaVarZza.zzbtz.size();
        for (int i = 0; i < size; i++) {
            String string = Integer.toString(i);
            Asset asset = (Asset) zzaVarZza.zzbtz.get(i);
            if (string == null) {
                throw new IllegalStateException("asset key cannot be null: " + asset);
            }
            if (asset == null) {
                throw new IllegalStateException("asset cannot be null: key=" + string);
            }
            if (Log.isLoggable(DataMap.TAG, 3)) {
                Log.d(DataMap.TAG, "asPutDataRequest: adding asset: " + string + " " + asset);
            }
            this.zzbre.putAsset(string, asset);
        }
        return this.zzbre;
    }

    public DataMap getDataMap() {
        return this.zzbrd;
    }

    public Uri getUri() {
        return this.zzbre.getUri();
    }

    public boolean isUrgent() {
        return this.zzbre.isUrgent();
    }

    public PutDataMapRequest setUrgent() {
        this.zzbre.setUrgent();
        return this;
    }
}
