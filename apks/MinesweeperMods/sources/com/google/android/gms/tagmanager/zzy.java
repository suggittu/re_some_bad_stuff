package com.google.android.gms.tagmanager;

import android.util.Log;

/* loaded from: classes2.dex */
public class zzy implements zzbh {
    private int zzRB = 5;

    @Override // com.google.android.gms.tagmanager.zzbh
    public void e(String str) {
        if (this.zzRB <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbh
    public void setLogLevel(int i) {
        this.zzRB = i;
    }

    @Override // com.google.android.gms.tagmanager.zzbh
    public void v(String str) {
        if (this.zzRB <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbh
    public void zzaI(String str) {
        if (this.zzRB <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbh
    public void zzaJ(String str) {
        if (this.zzRB <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbh
    public void zzaK(String str) {
        if (this.zzRB <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbh
    public void zzb(String str, Throwable th) {
        if (this.zzRB <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbh
    public void zzd(String str, Throwable th) {
        if (this.zzRB <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }
}
