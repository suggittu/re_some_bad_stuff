package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzaf extends com.google.android.gms.common.data.zzc implements DataItem {
    private final int zzaDQ;

    public zzaf(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaDQ = i2;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Map getAssets() {
        HashMap map = new HashMap(this.zzaDQ);
        for (int i = 0; i < this.zzaDQ; i++) {
            zzac zzacVar = new zzac(this.zzahi, this.zzaje + i);
            if (zzacVar.getDataItemKey() != null) {
                map.put(zzacVar.getDataItemKey(), zzacVar);
            }
        }
        return map;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final byte[] getData() {
        return getByteArray("data");
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Uri getUri() {
        return Uri.parse(getString("path"));
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final DataItem setData(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public final String toString(boolean z) {
        byte[] data = getData();
        Map assets = getAssets();
        StringBuilder sb = new StringBuilder("DataItemInternal{ ");
        sb.append("uri=" + getUri());
        sb.append(", dataSz=" + (data == null ? "null" : Integer.valueOf(data.length)));
        sb.append(", numAssets=" + assets.size());
        if (z && !assets.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            Iterator it = assets.entrySet().iterator();
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
    public final DataItem freeze() {
        return new zzad(this);
    }
}
