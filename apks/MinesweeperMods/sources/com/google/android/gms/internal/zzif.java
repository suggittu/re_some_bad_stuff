package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zzhb
/* loaded from: classes2.dex */
public class zzif {
    public final int errorCode;
    public final int orientation;
    public final List zzBQ;
    public final List zzBR;
    public final long zzBU;
    public final zzen zzCp;
    public final zzey zzCq;
    public final String zzCr;
    public final zzeq zzCs;
    public final zzjp zzED;
    public final long zzHS;
    public final boolean zzHT;
    public final long zzHU;
    public final List zzHV;
    public final String zzHY;
    public final AdRequestParcel zzHt;
    public final String zzHw;

    @Nullable
    public final RewardItemParcel zzIj;

    @Nullable
    public final List zzIl;
    public final boolean zzIm;
    public final JSONObject zzKT;
    public boolean zzKU;
    public final zzeo zzKV;
    public final AdSizeParcel zzKW;

    @Nullable
    public final List zzKX;
    public final long zzKY;
    public final long zzKZ;
    public final zzh.zza zzLa;
    public boolean zzLb;
    public boolean zzLc;

    @zzhb
    public final class zza {
        public final int errorCode;
        public final JSONObject zzKT;
        public final zzeo zzKV;
        public final long zzKY;
        public final long zzKZ;
        public final AdRequestInfoParcel zzLd;
        public final AdResponseParcel zzLe;
        public final AdSizeParcel zzrp;

        public zza(AdRequestInfoParcel adRequestInfoParcel, AdResponseParcel adResponseParcel, zzeo zzeoVar, AdSizeParcel adSizeParcel, int i, long j, long j2, JSONObject jSONObject) {
            this.zzLd = adRequestInfoParcel;
            this.zzLe = adResponseParcel;
            this.zzKV = zzeoVar;
            this.zzrp = adSizeParcel;
            this.errorCode = i;
            this.zzKY = j;
            this.zzKZ = j2;
            this.zzKT = jSONObject;
        }
    }

    public zzif(AdRequestParcel adRequestParcel, zzjp zzjpVar, List list, int i, List list2, List list3, int i2, long j, String str, boolean z, zzen zzenVar, zzey zzeyVar, String str2, zzeo zzeoVar, zzeq zzeqVar, long j2, AdSizeParcel adSizeParcel, long j3, long j4, long j5, String str3, JSONObject jSONObject, zzh.zza zzaVar, RewardItemParcel rewardItemParcel, List list4, List list5, boolean z2) {
        this.zzLb = false;
        this.zzLc = false;
        this.zzHt = adRequestParcel;
        this.zzED = zzjpVar;
        this.zzBQ = zzj(list);
        this.errorCode = i;
        this.zzBR = zzj(list2);
        this.zzHV = zzj(list3);
        this.orientation = i2;
        this.zzBU = j;
        this.zzHw = str;
        this.zzHT = z;
        this.zzCp = zzenVar;
        this.zzCq = zzeyVar;
        this.zzCr = str2;
        this.zzKV = zzeoVar;
        this.zzCs = zzeqVar;
        this.zzHU = j2;
        this.zzKW = adSizeParcel;
        this.zzHS = j3;
        this.zzKY = j4;
        this.zzKZ = j5;
        this.zzHY = str3;
        this.zzKT = jSONObject;
        this.zzLa = zzaVar;
        this.zzIj = rewardItemParcel;
        this.zzKX = zzj(list4);
        this.zzIl = zzj(list5);
        this.zzIm = z2;
    }

    public zzif(zza zzaVar, zzjp zzjpVar, zzen zzenVar, zzey zzeyVar, String str, zzeq zzeqVar, zzh.zza zzaVar2) {
        this(zzaVar.zzLd.zzHt, zzjpVar, zzaVar.zzLe.zzBQ, zzaVar.errorCode, zzaVar.zzLe.zzBR, zzaVar.zzLe.zzHV, zzaVar.zzLe.orientation, zzaVar.zzLe.zzBU, zzaVar.zzLd.zzHw, zzaVar.zzLe.zzHT, zzenVar, zzeyVar, str, zzaVar.zzKV, zzeqVar, zzaVar.zzLe.zzHU, zzaVar.zzrp, zzaVar.zzLe.zzHS, zzaVar.zzKY, zzaVar.zzKZ, zzaVar.zzLe.zzHY, zzaVar.zzKT, zzaVar2, zzaVar.zzLe.zzIj, zzaVar.zzLe.zzIk, zzaVar.zzLe.zzIk, zzaVar.zzLe.zzIm);
    }

    @Nullable
    private static List zzj(@Nullable List list) {
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public boolean zzcv() {
        if (this.zzED == null || this.zzED.zzhU() == null) {
            return false;
        }
        return this.zzED.zzhU().zzcv();
    }
}
