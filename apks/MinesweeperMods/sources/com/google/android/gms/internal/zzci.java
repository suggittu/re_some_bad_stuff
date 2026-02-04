package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;

@zzhb
/* loaded from: classes2.dex */
public class zzci extends NativeAd.Image {
    private final Drawable mDrawable;
    private final Uri mUri;
    private final double zzxV;
    private final zzch zzyL;

    public zzci(zzch zzchVar) {
        com.google.android.gms.dynamic.zzd zzdVarZzdJ;
        Uri uri = null;
        this.zzyL = zzchVar;
        try {
            zzdVarZzdJ = this.zzyL.zzdJ();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get drawable.", e);
        }
        Drawable drawable = zzdVarZzdJ != null ? (Drawable) com.google.android.gms.dynamic.zze.zzp(zzdVarZzdJ) : null;
        this.mDrawable = drawable;
        try {
            uri = this.zzyL.getUri();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get uri.", e2);
        }
        this.mUri = uri;
        double scale = 1.0d;
        try {
            scale = this.zzyL.getScale();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get scale.", e3);
        }
        this.zzxV = scale;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public Drawable getDrawable() {
        return this.mDrawable;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public double getScale() {
        return this.zzxV;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public Uri getUri() {
        return this.mUri;
    }
}
