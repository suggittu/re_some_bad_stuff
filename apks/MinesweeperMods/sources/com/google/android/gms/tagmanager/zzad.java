package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes2.dex */
class zzad extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.ENCODE.toString();
    private static final String zzbiQ = com.google.android.gms.internal.zzae.ARG0.toString();
    private static final String zzbiR = com.google.android.gms.internal.zzae.NO_PADDING.toString();
    private static final String zzbiS = com.google.android.gms.internal.zzae.INPUT_FORMAT.toString();
    private static final String zzbiT = com.google.android.gms.internal.zzae.OUTPUT_FORMAT.toString();

    public zzad() {
        super(ID, zzbiQ);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzP(Map map) {
        byte[] bArrDecode;
        String strEncodeToString;
        zzag.zza zzaVar = (zzag.zza) map.get(zzbiQ);
        if (zzaVar == null || zzaVar == zzdf.zzHF()) {
            return zzdf.zzHF();
        }
        String strZzg = zzdf.zzg(zzaVar);
        zzag.zza zzaVar2 = (zzag.zza) map.get(zzbiS);
        String strZzg2 = zzaVar2 == null ? "text" : zzdf.zzg(zzaVar2);
        zzag.zza zzaVar3 = (zzag.zza) map.get(zzbiT);
        String strZzg3 = zzaVar3 == null ? "base16" : zzdf.zzg(zzaVar3);
        int i = 2;
        zzag.zza zzaVar4 = (zzag.zza) map.get(zzbiR);
        if (zzaVar4 != null && zzdf.zzk(zzaVar4).booleanValue()) {
            i = 3;
        }
        try {
            if ("text".equals(strZzg2)) {
                bArrDecode = strZzg.getBytes();
            } else if ("base16".equals(strZzg2)) {
                bArrDecode = zzk.zzfO(strZzg);
            } else if ("base64".equals(strZzg2)) {
                bArrDecode = Base64.decode(strZzg, i);
            } else {
                if (!"base64url".equals(strZzg2)) {
                    zzbg.e("Encode: unknown input format: " + strZzg2);
                    return zzdf.zzHF();
                }
                bArrDecode = Base64.decode(strZzg, i | 8);
            }
            if ("base16".equals(strZzg3)) {
                strEncodeToString = zzk.zzj(bArrDecode);
            } else if ("base64".equals(strZzg3)) {
                strEncodeToString = Base64.encodeToString(bArrDecode, i);
            } else {
                if (!"base64url".equals(strZzg3)) {
                    zzbg.e("Encode: unknown output format: " + strZzg3);
                    return zzdf.zzHF();
                }
                strEncodeToString = Base64.encodeToString(bArrDecode, i | 8);
            }
            return zzdf.zzR(strEncodeToString);
        } catch (IllegalArgumentException e) {
            zzbg.e("Encode: invalid input:");
            return zzdf.zzHF();
        }
    }
}
