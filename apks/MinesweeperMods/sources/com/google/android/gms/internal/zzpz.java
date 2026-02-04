package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsn;
import com.google.android.gms.location.places.Place;

/* loaded from: classes2.dex */
public interface zzpz {

    public final class zza extends zzsu {
        private static volatile zza[] zzaZq;
        public Integer zzaZr;
        public zze[] zzaZs;
        public zzb[] zzaZt;

        public zza() {
            zzDB();
        }

        public static zza[] zzDA() {
            if (zzaZq == null) {
                synchronized (zzss.zzbut) {
                    if (zzaZq == null) {
                        zzaZq = new zza[0];
                    }
                }
            }
            return zzaZq;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.zzaZr == null) {
                if (zzaVar.zzaZr != null) {
                    return false;
                }
            } else if (!this.zzaZr.equals(zzaVar.zzaZr)) {
                return false;
            }
            return zzss.equals(this.zzaZs, zzaVar.zzaZs) && zzss.equals(this.zzaZt, zzaVar.zzaZt);
        }

        public final int hashCode() {
            return (((((this.zzaZr == null ? 0 : this.zzaZr.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzss.hashCode(this.zzaZs)) * 31) + zzss.hashCode(this.zzaZt);
        }

        @Override // com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            if (this.zzaZr != null) {
                zzsnVar.zzA(1, this.zzaZr.intValue());
            }
            if (this.zzaZs != null && this.zzaZs.length > 0) {
                for (int i = 0; i < this.zzaZs.length; i++) {
                    zze zzeVar = this.zzaZs[i];
                    if (zzeVar != null) {
                        zzsnVar.zza(2, zzeVar);
                    }
                }
            }
            if (this.zzaZt != null && this.zzaZt.length > 0) {
                for (int i2 = 0; i2 < this.zzaZt.length; i2++) {
                    zzb zzbVar = this.zzaZt[i2];
                    if (zzbVar != null) {
                        zzsnVar.zza(3, zzbVar);
                    }
                }
            }
            super.writeTo(zzsnVar);
        }

        public final zza zzDB() {
            this.zzaZr = null;
            this.zzaZs = zze.zzDH();
            this.zzaZt = zzb.zzDC();
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzt, reason: merged with bridge method [inline-methods] */
        public final zza mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzaZr = Integer.valueOf(zzsmVar.zzJb());
                        break;
                    case 18:
                        int iZzc = zzsx.zzc(zzsmVar, 18);
                        int length = this.zzaZs == null ? 0 : this.zzaZs.length;
                        zze[] zzeVarArr = new zze[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzaZs, 0, zzeVarArr, 0, length);
                        }
                        while (length < zzeVarArr.length - 1) {
                            zzeVarArr[length] = new zze();
                            zzsmVar.zza(zzeVarArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        zzeVarArr[length] = new zze();
                        zzsmVar.zza(zzeVarArr[length]);
                        this.zzaZs = zzeVarArr;
                        break;
                    case Place.TYPE_CONVENIENCE_STORE /* 26 */:
                        int iZzc2 = zzsx.zzc(zzsmVar, 26);
                        int length2 = this.zzaZt == null ? 0 : this.zzaZt.length;
                        zzb[] zzbVarArr = new zzb[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzaZt, 0, zzbVarArr, 0, length2);
                        }
                        while (length2 < zzbVarArr.length - 1) {
                            zzbVarArr[length2] = new zzb();
                            zzsmVar.zza(zzbVarArr[length2]);
                            zzsmVar.zzIX();
                            length2++;
                        }
                        zzbVarArr[length2] = new zzb();
                        zzsmVar.zza(zzbVarArr[length2]);
                        this.zzaZt = zzbVarArr;
                        break;
                    default:
                        if (!zzsx.zzb(zzsmVar, iZzIX)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzsu
        public final int zzz() {
            int iZzz = super.zzz();
            if (this.zzaZr != null) {
                iZzz += zzsn.zzC(1, this.zzaZr.intValue());
            }
            if (this.zzaZs != null && this.zzaZs.length > 0) {
                int iZzc = iZzz;
                for (int i = 0; i < this.zzaZs.length; i++) {
                    zze zzeVar = this.zzaZs[i];
                    if (zzeVar != null) {
                        iZzc += zzsn.zzc(2, zzeVar);
                    }
                }
                iZzz = iZzc;
            }
            if (this.zzaZt != null && this.zzaZt.length > 0) {
                for (int i2 = 0; i2 < this.zzaZt.length; i2++) {
                    zzb zzbVar = this.zzaZt[i2];
                    if (zzbVar != null) {
                        iZzz += zzsn.zzc(3, zzbVar);
                    }
                }
            }
            return iZzz;
        }
    }

    public final class zzb extends zzsu {
        private static volatile zzb[] zzaZu;
        public Integer zzaZv;
        public String zzaZw;
        public zzc[] zzaZx;
        public Boolean zzaZy;
        public zzd zzaZz;

        public zzb() {
            zzDD();
        }

        public static zzb[] zzDC() {
            if (zzaZu == null) {
                synchronized (zzss.zzbut) {
                    if (zzaZu == null) {
                        zzaZu = new zzb[0];
                    }
                }
            }
            return zzaZu;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (this.zzaZv == null) {
                if (zzbVar.zzaZv != null) {
                    return false;
                }
            } else if (!this.zzaZv.equals(zzbVar.zzaZv)) {
                return false;
            }
            if (this.zzaZw == null) {
                if (zzbVar.zzaZw != null) {
                    return false;
                }
            } else if (!this.zzaZw.equals(zzbVar.zzaZw)) {
                return false;
            }
            if (!zzss.equals(this.zzaZx, zzbVar.zzaZx)) {
                return false;
            }
            if (this.zzaZy == null) {
                if (zzbVar.zzaZy != null) {
                    return false;
                }
            } else if (!this.zzaZy.equals(zzbVar.zzaZy)) {
                return false;
            }
            return this.zzaZz == null ? zzbVar.zzaZz == null : this.zzaZz.equals(zzbVar.zzaZz);
        }

        public final int hashCode() {
            return (((this.zzaZy == null ? 0 : this.zzaZy.hashCode()) + (((((this.zzaZw == null ? 0 : this.zzaZw.hashCode()) + (((this.zzaZv == null ? 0 : this.zzaZv.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + zzss.hashCode(this.zzaZx)) * 31)) * 31) + (this.zzaZz != null ? this.zzaZz.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            if (this.zzaZv != null) {
                zzsnVar.zzA(1, this.zzaZv.intValue());
            }
            if (this.zzaZw != null) {
                zzsnVar.zzn(2, this.zzaZw);
            }
            if (this.zzaZx != null && this.zzaZx.length > 0) {
                for (int i = 0; i < this.zzaZx.length; i++) {
                    zzc zzcVar = this.zzaZx[i];
                    if (zzcVar != null) {
                        zzsnVar.zza(3, zzcVar);
                    }
                }
            }
            if (this.zzaZy != null) {
                zzsnVar.zze(4, this.zzaZy.booleanValue());
            }
            if (this.zzaZz != null) {
                zzsnVar.zza(5, this.zzaZz);
            }
            super.writeTo(zzsnVar);
        }

        public final zzb zzDD() {
            this.zzaZv = null;
            this.zzaZw = null;
            this.zzaZx = zzc.zzDE();
            this.zzaZy = null;
            this.zzaZz = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzu, reason: merged with bridge method [inline-methods] */
        public final zzb mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzaZv = Integer.valueOf(zzsmVar.zzJb());
                        break;
                    case 18:
                        this.zzaZw = zzsmVar.readString();
                        break;
                    case Place.TYPE_CONVENIENCE_STORE /* 26 */:
                        int iZzc = zzsx.zzc(zzsmVar, 26);
                        int length = this.zzaZx == null ? 0 : this.zzaZx.length;
                        zzc[] zzcVarArr = new zzc[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzaZx, 0, zzcVarArr, 0, length);
                        }
                        while (length < zzcVarArr.length - 1) {
                            zzcVarArr[length] = new zzc();
                            zzsmVar.zza(zzcVarArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        zzcVarArr[length] = new zzc();
                        zzsmVar.zza(zzcVarArr[length]);
                        this.zzaZx = zzcVarArr;
                        break;
                    case 32:
                        this.zzaZy = Boolean.valueOf(zzsmVar.zzJc());
                        break;
                    case 42:
                        if (this.zzaZz == null) {
                            this.zzaZz = new zzd();
                        }
                        zzsmVar.zza(this.zzaZz);
                        break;
                    default:
                        if (!zzsx.zzb(zzsmVar, iZzIX)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzsu
        public final int zzz() {
            int iZzz = super.zzz();
            if (this.zzaZv != null) {
                iZzz += zzsn.zzC(1, this.zzaZv.intValue());
            }
            if (this.zzaZw != null) {
                iZzz += zzsn.zzo(2, this.zzaZw);
            }
            if (this.zzaZx != null && this.zzaZx.length > 0) {
                int iZzc = iZzz;
                for (int i = 0; i < this.zzaZx.length; i++) {
                    zzc zzcVar = this.zzaZx[i];
                    if (zzcVar != null) {
                        iZzc += zzsn.zzc(3, zzcVar);
                    }
                }
                iZzz = iZzc;
            }
            if (this.zzaZy != null) {
                iZzz += zzsn.zzf(4, this.zzaZy.booleanValue());
            }
            return this.zzaZz != null ? iZzz + zzsn.zzc(5, this.zzaZz) : iZzz;
        }
    }

    public final class zzc extends zzsu {
        private static volatile zzc[] zzaZA;
        public zzf zzaZB;
        public zzd zzaZC;
        public Boolean zzaZD;
        public String zzaZE;

        public zzc() {
            zzDF();
        }

        public static zzc[] zzDE() {
            if (zzaZA == null) {
                synchronized (zzss.zzbut) {
                    if (zzaZA == null) {
                        zzaZA = new zzc[0];
                    }
                }
            }
            return zzaZA;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) obj;
            if (this.zzaZB == null) {
                if (zzcVar.zzaZB != null) {
                    return false;
                }
            } else if (!this.zzaZB.equals(zzcVar.zzaZB)) {
                return false;
            }
            if (this.zzaZC == null) {
                if (zzcVar.zzaZC != null) {
                    return false;
                }
            } else if (!this.zzaZC.equals(zzcVar.zzaZC)) {
                return false;
            }
            if (this.zzaZD == null) {
                if (zzcVar.zzaZD != null) {
                    return false;
                }
            } else if (!this.zzaZD.equals(zzcVar.zzaZD)) {
                return false;
            }
            return this.zzaZE == null ? zzcVar.zzaZE == null : this.zzaZE.equals(zzcVar.zzaZE);
        }

        public final int hashCode() {
            return (((this.zzaZD == null ? 0 : this.zzaZD.hashCode()) + (((this.zzaZC == null ? 0 : this.zzaZC.hashCode()) + (((this.zzaZB == null ? 0 : this.zzaZB.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + (this.zzaZE != null ? this.zzaZE.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            if (this.zzaZB != null) {
                zzsnVar.zza(1, this.zzaZB);
            }
            if (this.zzaZC != null) {
                zzsnVar.zza(2, this.zzaZC);
            }
            if (this.zzaZD != null) {
                zzsnVar.zze(3, this.zzaZD.booleanValue());
            }
            if (this.zzaZE != null) {
                zzsnVar.zzn(4, this.zzaZE);
            }
            super.writeTo(zzsnVar);
        }

        public final zzc zzDF() {
            this.zzaZB = null;
            this.zzaZC = null;
            this.zzaZD = null;
            this.zzaZE = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzv, reason: merged with bridge method [inline-methods] */
        public final zzc mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        if (this.zzaZB == null) {
                            this.zzaZB = new zzf();
                        }
                        zzsmVar.zza(this.zzaZB);
                        break;
                    case 18:
                        if (this.zzaZC == null) {
                            this.zzaZC = new zzd();
                        }
                        zzsmVar.zza(this.zzaZC);
                        break;
                    case 24:
                        this.zzaZD = Boolean.valueOf(zzsmVar.zzJc());
                        break;
                    case 34:
                        this.zzaZE = zzsmVar.readString();
                        break;
                    default:
                        if (!zzsx.zzb(zzsmVar, iZzIX)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzsu
        public final int zzz() {
            int iZzz = super.zzz();
            if (this.zzaZB != null) {
                iZzz += zzsn.zzc(1, this.zzaZB);
            }
            if (this.zzaZC != null) {
                iZzz += zzsn.zzc(2, this.zzaZC);
            }
            if (this.zzaZD != null) {
                iZzz += zzsn.zzf(3, this.zzaZD.booleanValue());
            }
            return this.zzaZE != null ? iZzz + zzsn.zzo(4, this.zzaZE) : iZzz;
        }
    }

    public final class zzd extends zzsu {
        public Integer zzaZF;
        public Boolean zzaZG;
        public String zzaZH;
        public String zzaZI;
        public String zzaZJ;

        public zzd() {
            zzDG();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) obj;
            if (this.zzaZF == null) {
                if (zzdVar.zzaZF != null) {
                    return false;
                }
            } else if (!this.zzaZF.equals(zzdVar.zzaZF)) {
                return false;
            }
            if (this.zzaZG == null) {
                if (zzdVar.zzaZG != null) {
                    return false;
                }
            } else if (!this.zzaZG.equals(zzdVar.zzaZG)) {
                return false;
            }
            if (this.zzaZH == null) {
                if (zzdVar.zzaZH != null) {
                    return false;
                }
            } else if (!this.zzaZH.equals(zzdVar.zzaZH)) {
                return false;
            }
            if (this.zzaZI == null) {
                if (zzdVar.zzaZI != null) {
                    return false;
                }
            } else if (!this.zzaZI.equals(zzdVar.zzaZI)) {
                return false;
            }
            return this.zzaZJ == null ? zzdVar.zzaZJ == null : this.zzaZJ.equals(zzdVar.zzaZJ);
        }

        public final int hashCode() {
            return (((this.zzaZI == null ? 0 : this.zzaZI.hashCode()) + (((this.zzaZH == null ? 0 : this.zzaZH.hashCode()) + (((this.zzaZG == null ? 0 : this.zzaZG.hashCode()) + (((this.zzaZF == null ? 0 : this.zzaZF.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31) + (this.zzaZJ != null ? this.zzaZJ.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            if (this.zzaZF != null) {
                zzsnVar.zzA(1, this.zzaZF.intValue());
            }
            if (this.zzaZG != null) {
                zzsnVar.zze(2, this.zzaZG.booleanValue());
            }
            if (this.zzaZH != null) {
                zzsnVar.zzn(3, this.zzaZH);
            }
            if (this.zzaZI != null) {
                zzsnVar.zzn(4, this.zzaZI);
            }
            if (this.zzaZJ != null) {
                zzsnVar.zzn(5, this.zzaZJ);
            }
            super.writeTo(zzsnVar);
        }

        public final zzd zzDG() {
            this.zzaZF = null;
            this.zzaZG = null;
            this.zzaZH = null;
            this.zzaZI = null;
            this.zzaZJ = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzw, reason: merged with bridge method [inline-methods] */
        public final zzd mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        int iZzJb = zzsmVar.zzJb();
                        switch (iZzJb) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                this.zzaZF = Integer.valueOf(iZzJb);
                                break;
                        }
                    case 16:
                        this.zzaZG = Boolean.valueOf(zzsmVar.zzJc());
                        break;
                    case Place.TYPE_CONVENIENCE_STORE /* 26 */:
                        this.zzaZH = zzsmVar.readString();
                        break;
                    case 34:
                        this.zzaZI = zzsmVar.readString();
                        break;
                    case 42:
                        this.zzaZJ = zzsmVar.readString();
                        break;
                    default:
                        if (!zzsx.zzb(zzsmVar, iZzIX)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzsu
        public final int zzz() {
            int iZzz = super.zzz();
            if (this.zzaZF != null) {
                iZzz += zzsn.zzC(1, this.zzaZF.intValue());
            }
            if (this.zzaZG != null) {
                iZzz += zzsn.zzf(2, this.zzaZG.booleanValue());
            }
            if (this.zzaZH != null) {
                iZzz += zzsn.zzo(3, this.zzaZH);
            }
            if (this.zzaZI != null) {
                iZzz += zzsn.zzo(4, this.zzaZI);
            }
            return this.zzaZJ != null ? iZzz + zzsn.zzo(5, this.zzaZJ) : iZzz;
        }
    }

    public final class zze extends zzsu {
        private static volatile zze[] zzaZK;
        public String zzaZL;
        public zzc zzaZM;
        public Integer zzaZv;

        public zze() {
            zzDI();
        }

        public static zze[] zzDH() {
            if (zzaZK == null) {
                synchronized (zzss.zzbut) {
                    if (zzaZK == null) {
                        zzaZK = new zze[0];
                    }
                }
            }
            return zzaZK;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zzeVar = (zze) obj;
            if (this.zzaZv == null) {
                if (zzeVar.zzaZv != null) {
                    return false;
                }
            } else if (!this.zzaZv.equals(zzeVar.zzaZv)) {
                return false;
            }
            if (this.zzaZL == null) {
                if (zzeVar.zzaZL != null) {
                    return false;
                }
            } else if (!this.zzaZL.equals(zzeVar.zzaZL)) {
                return false;
            }
            return this.zzaZM == null ? zzeVar.zzaZM == null : this.zzaZM.equals(zzeVar.zzaZM);
        }

        public final int hashCode() {
            return (((this.zzaZL == null ? 0 : this.zzaZL.hashCode()) + (((this.zzaZv == null ? 0 : this.zzaZv.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + (this.zzaZM != null ? this.zzaZM.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            if (this.zzaZv != null) {
                zzsnVar.zzA(1, this.zzaZv.intValue());
            }
            if (this.zzaZL != null) {
                zzsnVar.zzn(2, this.zzaZL);
            }
            if (this.zzaZM != null) {
                zzsnVar.zza(3, this.zzaZM);
            }
            super.writeTo(zzsnVar);
        }

        public final zze zzDI() {
            this.zzaZv = null;
            this.zzaZL = null;
            this.zzaZM = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzx, reason: merged with bridge method [inline-methods] */
        public final zze mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzaZv = Integer.valueOf(zzsmVar.zzJb());
                        break;
                    case 18:
                        this.zzaZL = zzsmVar.readString();
                        break;
                    case Place.TYPE_CONVENIENCE_STORE /* 26 */:
                        if (this.zzaZM == null) {
                            this.zzaZM = new zzc();
                        }
                        zzsmVar.zza(this.zzaZM);
                        break;
                    default:
                        if (!zzsx.zzb(zzsmVar, iZzIX)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzsu
        public final int zzz() {
            int iZzz = super.zzz();
            if (this.zzaZv != null) {
                iZzz += zzsn.zzC(1, this.zzaZv.intValue());
            }
            if (this.zzaZL != null) {
                iZzz += zzsn.zzo(2, this.zzaZL);
            }
            return this.zzaZM != null ? iZzz + zzsn.zzc(3, this.zzaZM) : iZzz;
        }
    }

    public final class zzf extends zzsu {
        public Integer zzaZN;
        public String zzaZO;
        public Boolean zzaZP;
        public String[] zzaZQ;

        public zzf() {
            zzDJ();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzfVar = (zzf) obj;
            if (this.zzaZN == null) {
                if (zzfVar.zzaZN != null) {
                    return false;
                }
            } else if (!this.zzaZN.equals(zzfVar.zzaZN)) {
                return false;
            }
            if (this.zzaZO == null) {
                if (zzfVar.zzaZO != null) {
                    return false;
                }
            } else if (!this.zzaZO.equals(zzfVar.zzaZO)) {
                return false;
            }
            if (this.zzaZP == null) {
                if (zzfVar.zzaZP != null) {
                    return false;
                }
            } else if (!this.zzaZP.equals(zzfVar.zzaZP)) {
                return false;
            }
            return zzss.equals(this.zzaZQ, zzfVar.zzaZQ);
        }

        public final int hashCode() {
            return (((((this.zzaZO == null ? 0 : this.zzaZO.hashCode()) + (((this.zzaZN == null ? 0 : this.zzaZN.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + (this.zzaZP != null ? this.zzaZP.hashCode() : 0)) * 31) + zzss.hashCode(this.zzaZQ);
        }

        @Override // com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            if (this.zzaZN != null) {
                zzsnVar.zzA(1, this.zzaZN.intValue());
            }
            if (this.zzaZO != null) {
                zzsnVar.zzn(2, this.zzaZO);
            }
            if (this.zzaZP != null) {
                zzsnVar.zze(3, this.zzaZP.booleanValue());
            }
            if (this.zzaZQ != null && this.zzaZQ.length > 0) {
                for (int i = 0; i < this.zzaZQ.length; i++) {
                    String str = this.zzaZQ[i];
                    if (str != null) {
                        zzsnVar.zzn(4, str);
                    }
                }
            }
            super.writeTo(zzsnVar);
        }

        public final zzf zzDJ() {
            this.zzaZN = null;
            this.zzaZO = null;
            this.zzaZP = null;
            this.zzaZQ = zzsx.zzbuB;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzy, reason: merged with bridge method [inline-methods] */
        public final zzf mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        int iZzJb = zzsmVar.zzJb();
                        switch (iZzJb) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.zzaZN = Integer.valueOf(iZzJb);
                                break;
                        }
                    case 18:
                        this.zzaZO = zzsmVar.readString();
                        break;
                    case 24:
                        this.zzaZP = Boolean.valueOf(zzsmVar.zzJc());
                        break;
                    case 34:
                        int iZzc = zzsx.zzc(zzsmVar, 34);
                        int length = this.zzaZQ == null ? 0 : this.zzaZQ.length;
                        String[] strArr = new String[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzaZQ, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzsmVar.readString();
                            zzsmVar.zzIX();
                            length++;
                        }
                        strArr[length] = zzsmVar.readString();
                        this.zzaZQ = strArr;
                        break;
                    default:
                        if (!zzsx.zzb(zzsmVar, iZzIX)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzsu
        public final int zzz() {
            int iZzz = super.zzz();
            if (this.zzaZN != null) {
                iZzz += zzsn.zzC(1, this.zzaZN.intValue());
            }
            if (this.zzaZO != null) {
                iZzz += zzsn.zzo(2, this.zzaZO);
            }
            if (this.zzaZP != null) {
                iZzz += zzsn.zzf(3, this.zzaZP.booleanValue());
            }
            if (this.zzaZQ == null || this.zzaZQ.length <= 0) {
                return iZzz;
            }
            int iZzgO = 0;
            int i = 0;
            for (int i2 = 0; i2 < this.zzaZQ.length; i2++) {
                String str = this.zzaZQ[i2];
                if (str != null) {
                    i++;
                    iZzgO += zzsn.zzgO(str);
                }
            }
            return iZzz + iZzgO + (i * 1);
        }
    }
}
