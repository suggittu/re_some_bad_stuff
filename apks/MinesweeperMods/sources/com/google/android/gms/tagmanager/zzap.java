package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* loaded from: classes2.dex */
class zzap extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.HASH.toString();
    private static final String zzbiQ = com.google.android.gms.internal.zzae.ARG0.toString();
    private static final String zzbiW = com.google.android.gms.internal.zzae.ALGORITHM.toString();
    private static final String zzbiS = com.google.android.gms.internal.zzae.INPUT_FORMAT.toString();

    public zzap() {
        super(ID, zzbiQ);
    }

    private byte[] zzg(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzP(Map map) {
        byte[] bArrZzfO;
        zzag.zza zzaVar = (zzag.zza) map.get(zzbiQ);
        if (zzaVar == null || zzaVar == zzdf.zzHF()) {
            return zzdf.zzHF();
        }
        String strZzg = zzdf.zzg(zzaVar);
        zzag.zza zzaVar2 = (zzag.zza) map.get(zzbiW);
        String strZzg2 = zzaVar2 == null ? "MD5" : zzdf.zzg(zzaVar2);
        zzag.zza zzaVar3 = (zzag.zza) map.get(zzbiS);
        String strZzg3 = zzaVar3 == null ? "text" : zzdf.zzg(zzaVar3);
        if ("text".equals(strZzg3)) {
            bArrZzfO = strZzg.getBytes();
        } else {
            if (!"base16".equals(strZzg3)) {
                zzbg.e("Hash: unknown input format: " + strZzg3);
                return zzdf.zzHF();
            }
            bArrZzfO = zzk.zzfO(strZzg);
        }
        try {
            return zzdf.zzR(zzk.zzj(zzg(strZzg2, bArrZzfO)));
        } catch (NoSuchAlgorithmException e) {
            zzbg.e("Hash: unknown algorithm: " + strZzg2);
            return zzdf.zzHF();
        }
    }
}
