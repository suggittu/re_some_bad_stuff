package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzhb
/* loaded from: classes2.dex */
public class zzfq {
    private final boolean zzDu;
    private final boolean zzDv;
    private final boolean zzDw;
    private final boolean zzDx;
    private final boolean zzDy;

    public final class zza {
        private boolean zzDu;
        private boolean zzDv;
        private boolean zzDw;
        private boolean zzDx;
        private boolean zzDy;

        public final zzfq zzeP() {
            return new zzfq(this);
        }

        public final zza zzq(boolean z) {
            this.zzDu = z;
            return this;
        }

        public final zza zzr(boolean z) {
            this.zzDv = z;
            return this;
        }

        public final zza zzs(boolean z) {
            this.zzDw = z;
            return this;
        }

        public final zza zzt(boolean z) {
            this.zzDx = z;
            return this;
        }

        public final zza zzu(boolean z) {
            this.zzDy = z;
            return this;
        }
    }

    private zzfq(zza zzaVar) {
        this.zzDu = zzaVar.zzDu;
        this.zzDv = zzaVar.zzDv;
        this.zzDw = zzaVar.zzDw;
        this.zzDx = zzaVar.zzDx;
        this.zzDy = zzaVar.zzDy;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zzDu).put("tel", this.zzDv).put("calendar", this.zzDw).put("storePicture", this.zzDx).put("inlineVideo", this.zzDy);
        } catch (JSONException e) {
            zzin.zzb("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
