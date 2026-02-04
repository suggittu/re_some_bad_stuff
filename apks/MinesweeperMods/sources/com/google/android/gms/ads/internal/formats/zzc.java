package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzhb;

@zzhb
/* loaded from: classes2.dex */
public class zzc extends zzch.zza {
    private final Uri mUri;
    private final Drawable zzxU;
    private final double zzxV;

    public zzc(Drawable drawable, Uri uri, double d) {
        this.zzxU = drawable;
        this.mUri = uri;
        this.zzxV = d;
    }

    @Override // com.google.android.gms.internal.zzch
    public double getScale() {
        return this.zzxV;
    }

    @Override // com.google.android.gms.internal.zzch
    public Uri getUri() {
        return this.mUri;
    }

    @Override // com.google.android.gms.internal.zzch
    public com.google.android.gms.dynamic.zzd zzdJ() {
        return com.google.android.gms.dynamic.zze.zzC(this.zzxU);
    }
}
