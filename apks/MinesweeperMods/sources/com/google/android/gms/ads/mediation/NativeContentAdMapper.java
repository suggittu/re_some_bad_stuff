package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class NativeContentAdMapper extends NativeAdMapper {
    private NativeAd.Image zzOp;
    private String zzxW;
    private List zzxX;
    private String zzxY;
    private String zzya;
    private String zzyh;

    public final String getAdvertiser() {
        return this.zzyh;
    }

    public final String getBody() {
        return this.zzxY;
    }

    public final String getCallToAction() {
        return this.zzya;
    }

    public final String getHeadline() {
        return this.zzxW;
    }

    public final List getImages() {
        return this.zzxX;
    }

    public final NativeAd.Image getLogo() {
        return this.zzOp;
    }

    public final void setAdvertiser(String str) {
        this.zzyh = str;
    }

    public final void setBody(String str) {
        this.zzxY = str;
    }

    public final void setCallToAction(String str) {
        this.zzya = str;
    }

    public final void setHeadline(String str) {
        this.zzxW = str;
    }

    public final void setImages(List list) {
        this.zzxX = list;
    }

    public final void setLogo(NativeAd.Image image) {
        this.zzOp = image;
    }
}
