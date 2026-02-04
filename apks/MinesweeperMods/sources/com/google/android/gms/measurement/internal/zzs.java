package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.zzpz;

/* loaded from: classes2.dex */
class zzs {
    final boolean zzaWY;
    final int zzaWZ;
    long zzaXa;
    float zzaXb;
    long zzaXc;
    float zzaXd;
    long zzaXe;
    float zzaXf;
    final boolean zzaXg;

    public zzs(zzpz.zzd zzdVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzdVar);
        boolean z = (zzdVar.zzaZF == null || zzdVar.zzaZF.intValue() == 0) ? false : zzdVar.zzaZF.intValue() == 4 ? !(zzdVar.zzaZI == null || zzdVar.zzaZJ == null) : zzdVar.zzaZH != null;
        if (z) {
            this.zzaWZ = zzdVar.zzaZF.intValue();
            this.zzaWY = zzdVar.zzaZG != null && zzdVar.zzaZG.booleanValue();
            if (zzdVar.zzaZF.intValue() == 4) {
                if (this.zzaWY) {
                    this.zzaXd = Float.parseFloat(zzdVar.zzaZI);
                    this.zzaXf = Float.parseFloat(zzdVar.zzaZJ);
                } else {
                    this.zzaXc = Long.parseLong(zzdVar.zzaZI);
                    this.zzaXe = Long.parseLong(zzdVar.zzaZJ);
                }
            } else if (this.zzaWY) {
                this.zzaXb = Float.parseFloat(zzdVar.zzaZH);
            } else {
                this.zzaXa = Long.parseLong(zzdVar.zzaZH);
            }
        } else {
            this.zzaWZ = 0;
            this.zzaWY = false;
        }
        this.zzaXg = z;
    }

    public Boolean zzac(long j) {
        if (this.zzaXg && !this.zzaWY) {
            switch (this.zzaWZ) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
            return null;
        }
        return null;
    }

    public Boolean zzi(float f) {
        if (this.zzaXg && this.zzaWY) {
            switch (this.zzaWZ) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
            return null;
        }
        return null;
    }
}
