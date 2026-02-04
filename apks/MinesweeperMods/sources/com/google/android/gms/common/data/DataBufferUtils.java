package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class DataBufferUtils {
    private DataBufferUtils() {
    }

    public static ArrayList freezeAndClose(DataBuffer dataBuffer) {
        ArrayList arrayList = new ArrayList(dataBuffer.getCount());
        try {
            Iterator it = dataBuffer.iterator();
            while (it.hasNext()) {
                arrayList.add(((Freezable) it.next()).freeze());
            }
            return arrayList;
        } finally {
            dataBuffer.close();
        }
    }

    public static boolean hasData(DataBuffer dataBuffer) {
        return dataBuffer != null && dataBuffer.getCount() > 0;
    }

    public static boolean hasNextPage(DataBuffer dataBuffer) {
        Bundle bundleZzpZ = dataBuffer.zzpZ();
        return (bundleZzpZ == null || bundleZzpZ.getString("next_page_token") == null) ? false : true;
    }

    public static boolean hasPrevPage(DataBuffer dataBuffer) {
        Bundle bundleZzpZ = dataBuffer.zzpZ();
        return (bundleZzpZ == null || bundleZzpZ.getString("prev_page_token") == null) ? false : true;
    }
}
