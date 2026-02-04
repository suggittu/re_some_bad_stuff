package com.google.android.gms.internal;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.util.Map;
import java.util.Set;

@zzhb
/* loaded from: classes2.dex */
public class zzfn extends zzfs {
    static final Set zzDa = zzmr.zzc("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private AdSizeParcel zzCh;
    private String zzDb;
    private boolean zzDc;
    private int zzDd;
    private int zzDe;
    private int zzDf;
    private int zzDg;
    private final Activity zzDh;
    private ImageView zzDi;
    private LinearLayout zzDj;
    private zzft zzDk;
    private PopupWindow zzDl;
    private RelativeLayout zzDm;
    private ViewGroup zzDn;
    private int zzoG;
    private int zzoH;
    private final zzjp zzpD;
    private final Object zzpV;

    public zzfn(zzjp zzjpVar, zzft zzftVar) {
        super(zzjpVar, "resize");
        this.zzDb = "top-right";
        this.zzDc = true;
        this.zzDd = 0;
        this.zzDe = 0;
        this.zzoH = -1;
        this.zzDf = 0;
        this.zzDg = 0;
        this.zzoG = -1;
        this.zzpV = new Object();
        this.zzpD = zzjpVar;
        this.zzDh = zzjpVar.zzhP();
        this.zzDk = zzftVar;
    }

    private int[] zzeM() {
        if (!zzeO()) {
            return null;
        }
        if (this.zzDc) {
            return new int[]{this.zzDd + this.zzDf, this.zzDe + this.zzDg};
        }
        int[] iArrZzf = com.google.android.gms.ads.internal.zzr.zzbC().zzf(this.zzDh);
        int[] iArrZzh = com.google.android.gms.ads.internal.zzr.zzbC().zzh(this.zzDh);
        int i = iArrZzf[0];
        int i2 = this.zzDd + this.zzDf;
        int i3 = this.zzDe + this.zzDg;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.zzoG + i2 > i) {
            i2 = i - this.zzoG;
        }
        if (i3 < iArrZzh[0]) {
            i3 = iArrZzh[0];
        } else if (this.zzoH + i3 > iArrZzh[1]) {
            i3 = iArrZzh[1] - this.zzoH;
        }
        return new int[]{i2, i3};
    }

    private void zzh(Map map) {
        if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
            this.zzoG = com.google.android.gms.ads.internal.zzr.zzbC().zzaD((String) map.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
            this.zzoH = com.google.android.gms.ads.internal.zzr.zzbC().zzaD((String) map.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
            this.zzDf = com.google.android.gms.ads.internal.zzr.zzbC().zzaD((String) map.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
            this.zzDg = com.google.android.gms.ads.internal.zzr.zzbC().zzaD((String) map.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
            this.zzDc = Boolean.parseBoolean((String) map.get("allowOffscreen"));
        }
        String str = (String) map.get("customClosePosition");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zzDb = str;
    }

    public void zza(int i, int i2, boolean z) {
        synchronized (this.zzpV) {
            this.zzDd = i;
            this.zzDe = i2;
            if (this.zzDl != null && z) {
                int[] iArrZzeM = zzeM();
                if (iArrZzeM != null) {
                    this.zzDl.update(com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDh, iArrZzeM[0]), com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDh, iArrZzeM[1]), this.zzDl.getWidth(), this.zzDl.getHeight());
                    zzd(iArrZzeM[0], iArrZzeM[1]);
                } else {
                    zzp(true);
                }
            }
        }
    }

    void zzc(int i, int i2) {
        if (this.zzDk != null) {
            this.zzDk.zza(i, i2, this.zzoG, this.zzoH);
        }
    }

    void zzd(int i, int i2) {
        zzb(i, i2 - com.google.android.gms.ads.internal.zzr.zzbC().zzh(this.zzDh)[0], this.zzoG, this.zzoH);
    }

    public void zze(int i, int i2) {
        this.zzDd = i;
        this.zzDe = i2;
    }

    boolean zzeL() {
        return this.zzoG >= 0 && this.zzoH >= 0;
    }

    public boolean zzeN() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzDl != null;
        }
        return z;
    }

    boolean zzeO() {
        int i;
        int i2;
        int[] iArrZzf = com.google.android.gms.ads.internal.zzr.zzbC().zzf(this.zzDh);
        int[] iArrZzh = com.google.android.gms.ads.internal.zzr.zzbC().zzh(this.zzDh);
        int i3 = iArrZzf[0];
        int i4 = iArrZzf[1];
        if (this.zzoG < 50 || this.zzoG > i3) {
            zzin.zzaK("Width is too small or too large.");
            return false;
        }
        if (this.zzoH < 50 || this.zzoH > i4) {
            zzin.zzaK("Height is too small or too large.");
            return false;
        }
        if (this.zzoH == i4 && this.zzoG == i3) {
            zzin.zzaK("Cannot resize to a full-screen ad.");
            return false;
        }
        if (this.zzDc) {
            switch (this.zzDb) {
                case "top-left":
                    i = this.zzDf + this.zzDd;
                    i2 = this.zzDe + this.zzDg;
                    break;
                case "top-center":
                    i = ((this.zzDd + this.zzDf) + (this.zzoG / 2)) - 25;
                    i2 = this.zzDe + this.zzDg;
                    break;
                case "center":
                    i = ((this.zzDd + this.zzDf) + (this.zzoG / 2)) - 25;
                    i2 = ((this.zzDe + this.zzDg) + (this.zzoH / 2)) - 25;
                    break;
                case "bottom-left":
                    i = this.zzDf + this.zzDd;
                    i2 = ((this.zzDe + this.zzDg) + this.zzoH) - 50;
                    break;
                case "bottom-center":
                    i = ((this.zzDd + this.zzDf) + (this.zzoG / 2)) - 25;
                    i2 = ((this.zzDe + this.zzDg) + this.zzoH) - 50;
                    break;
                case "bottom-right":
                    i = ((this.zzDd + this.zzDf) + this.zzoG) - 50;
                    i2 = ((this.zzDe + this.zzDg) + this.zzoH) - 50;
                    break;
                default:
                    i = ((this.zzDd + this.zzDf) + this.zzoG) - 50;
                    i2 = this.zzDe + this.zzDg;
                    break;
            }
            if (i < 0 || i + 50 > i3 || i2 < iArrZzh[0] || i2 + 50 > iArrZzh[1]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0155  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void zzi(java.util.Map r13) {
        /*
            Method dump skipped, instructions count: 722
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfn.zzi(java.util.Map):void");
    }

    public void zzp(boolean z) {
        synchronized (this.zzpV) {
            if (this.zzDl != null) {
                this.zzDl.dismiss();
                this.zzDm.removeView(this.zzpD.getView());
                if (this.zzDn != null) {
                    this.zzDn.removeView(this.zzDi);
                    this.zzDn.addView(this.zzpD.getView());
                    this.zzpD.zza(this.zzCh);
                }
                if (z) {
                    zzao("default");
                    if (this.zzDk != null) {
                        this.zzDk.zzbf();
                    }
                }
                this.zzDl = null;
                this.zzDm = null;
                this.zzDn = null;
                this.zzDj = null;
            }
        }
    }
}
