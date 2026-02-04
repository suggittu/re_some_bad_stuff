package com.google.android.gms.internal;

import java.util.Map;

@zzhb
/* loaded from: classes2.dex */
public class zzdl implements zzdf {
    static final Map zzzC = zzmr.zza("resize", 1, "playVideo", 2, "storePicture", 3, "createCalendarEvent", 4, "setOrientationProperties", 5, "closeResizedAd", 6);
    private final com.google.android.gms.ads.internal.zze zzzA;
    private final zzfn zzzB;

    public zzdl(com.google.android.gms.ads.internal.zze zzeVar, zzfn zzfnVar) {
        this.zzzA = zzeVar;
        this.zzzB = zzfnVar;
    }

    @Override // com.google.android.gms.internal.zzdf
    public void zza(zzjp zzjpVar, Map map) {
        int iIntValue = ((Integer) zzzC.get((String) map.get("a"))).intValue();
        if (iIntValue != 5 && this.zzzA != null && !this.zzzA.zzbh()) {
            this.zzzA.zzq(null);
        }
        switch (iIntValue) {
            case 1:
                this.zzzB.zzi(map);
                break;
            case 2:
            default:
                zzin.zzaJ("Unknown MRAID command called.");
                break;
            case 3:
                new zzfp(zzjpVar, map).execute();
                break;
            case 4:
                new zzfm(zzjpVar, map).execute();
                break;
            case 5:
                new zzfo(zzjpVar, map).execute();
                break;
            case 6:
                this.zzzB.zzp(true);
                break;
        }
    }
}
