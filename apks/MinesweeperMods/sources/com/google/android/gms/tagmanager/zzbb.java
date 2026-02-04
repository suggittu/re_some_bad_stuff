package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class zzbb extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.LANGUAGE.toString();

    public zzbb() {
        super(ID, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public /* bridge */ /* synthetic */ String zzGB() {
        return super.zzGB();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public /* bridge */ /* synthetic */ Set zzGC() {
        return super.zzGC();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzP(Map map) {
        String language;
        Locale locale = Locale.getDefault();
        if (locale != null && (language = locale.getLanguage()) != null) {
            return zzdf.zzR(language.toLowerCase());
        }
        return zzdf.zzHF();
    }
}
