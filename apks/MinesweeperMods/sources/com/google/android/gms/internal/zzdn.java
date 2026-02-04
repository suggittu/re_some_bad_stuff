package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzdn implements zzdf {
    private final zza zzzH;

    public interface zza {
        void zzb(RewardItemParcel rewardItemParcel);

        void zzbq();
    }

    public zzdn(zza zzaVar) {
        this.zzzH = zzaVar;
    }

    public static void zza(zzjp zzjpVar, zza zzaVar) {
        zzjpVar.zzhU().zza("/reward", new zzdn(zzaVar));
    }

    private void zze(Map map) throws NumberFormatException {
        int i;
        String str;
        try {
            i = Integer.parseInt((String) map.get("amount"));
            str = (String) map.get("type");
        } catch (NumberFormatException e) {
            zzin.zzd("Unable to parse reward amount.", e);
        }
        RewardItemParcel rewardItemParcel = !TextUtils.isEmpty(str) ? new RewardItemParcel(str, i) : null;
        this.zzzH.zzb(rewardItemParcel);
    }

    private void zzf(Map map) {
        this.zzzH.zzbq();
    }

    @Override // com.google.android.gms.internal.zzdf
    public void zza(zzjp zzjpVar, Map map) throws NumberFormatException {
        String str = (String) map.get("action");
        if ("grant".equals(str)) {
            zze(map);
        } else if ("video_start".equals(str)) {
            zzf(map);
        }
    }
}
