package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes2.dex */
class zzg extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.APP_NAME.toString();
    private final Context mContext;

    public zzg(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzP(Map map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return zzdf.zzR(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (PackageManager.NameNotFoundException e) {
            zzbg.zzb("App name is not found.", e);
            return zzdf.zzHF();
        }
    }
}
