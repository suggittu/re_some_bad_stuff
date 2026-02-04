package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzad implements DataItem {
    private Uri mUri;
    private byte[] zzaKm;
    private Map zzbsy;

    public zzad(DataItem dataItem) {
        this.mUri = dataItem.getUri();
        this.zzaKm = dataItem.getData();
        HashMap map = new HashMap();
        for (Map.Entry entry : dataItem.getAssets().entrySet()) {
            if (entry.getKey() != null) {
                map.put(entry.getKey(), ((DataItemAsset) entry.getValue()).freeze());
            }
        }
        this.zzbsy = Collections.unmodifiableMap(map);
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

    @Override // com.google.android.gms.wearable.DataItem
    public DataItem setData(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean z) {
        StringBuilder sb = new StringBuilder("DataItemEntity{ ");
        sb.append("uri=" + this.mUri);
        sb.append(", dataSz=" + (this.zzaKm == null ? "null" : Integer.valueOf(this.zzaKm.length)));
        sb.append(", numAssets=" + this.zzbsy.size());
        if (z && !this.zzbsy.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            Iterator it = this.zzbsy.entrySet().iterator();
            while (true) {
                String str2 = str;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                sb.append(str2 + ((String) entry.getKey()) + ": " + ((DataItemAsset) entry.getValue()).getId());
                str = ", ";
            }
            sb.append("]");
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzIM, reason: merged with bridge method [inline-methods] */
    public DataItem freeze() {
        return this;
    }
}
