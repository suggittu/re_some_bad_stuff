package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes2.dex */
public final class RequestUpdateOutcomes {
    private static final String[] zzaIX = {"requestId", "outcome"};
    private final HashMap zzaIY;
    private final int zzade;

    public final class Builder {
        private HashMap zzaIY = new HashMap();
        private int zzade = 0;

        public final Builder zzgG(int i) {
            this.zzade = i;
            return this;
        }

        public final Builder zzx(String str, int i) {
            if (RequestUpdateResultOutcome.isValid(i)) {
                this.zzaIY.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public final RequestUpdateOutcomes zzxH() {
            return new RequestUpdateOutcomes(this.zzade, this.zzaIY);
        }
    }

    private RequestUpdateOutcomes(int i, HashMap map) {
        this.zzade = i;
        this.zzaIY = map;
    }

    public static RequestUpdateOutcomes zzab(DataHolder dataHolder) {
        Builder builder = new Builder();
        builder.zzgG(dataHolder.getStatusCode());
        int count = dataHolder.getCount();
        for (int i = 0; i < count; i++) {
            int iZzbH = dataHolder.zzbH(i);
            builder.zzx(dataHolder.zzd("requestId", i, iZzbH), dataHolder.zzc("outcome", i, iZzbH));
        }
        return builder.zzxH();
    }

    public final Set getRequestIds() {
        return this.zzaIY.keySet();
    }

    public final int getRequestOutcome(String str) {
        zzx.zzb(this.zzaIY.containsKey(str), "Request " + str + " was not part of the update operation!");
        return ((Integer) this.zzaIY.get(str)).intValue();
    }
}
