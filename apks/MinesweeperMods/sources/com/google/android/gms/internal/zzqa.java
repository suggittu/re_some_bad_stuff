package com.google.android.gms.internal;

import com.google.android.gms.internal.zzpz;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.location.places.Place;

/* loaded from: classes2.dex */
public interface zzqa {

    public final class zza extends zzsu {
        private static volatile zza[] zzaZR;
        public String name;
        public Boolean zzaZS;

        public zza() {
            zzDL();
        }

        public static zza[] zzDK() {
            if (zzaZR == null) {
                synchronized (zzss.zzbut) {
                    if (zzaZR == null) {
                        zzaZR = new zza[0];
                    }
                }
            }
            return zzaZR;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.name == null) {
                if (zzaVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzaVar.name)) {
                return false;
            }
            return this.zzaZS == null ? zzaVar.zzaZS == null : this.zzaZS.equals(zzaVar.zzaZS);
        }

        public final int hashCode() {
            return (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + (this.zzaZS != null ? this.zzaZS.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            if (this.name != null) {
                zzsnVar.zzn(1, this.name);
            }
            if (this.zzaZS != null) {
                zzsnVar.zze(2, this.zzaZS.booleanValue());
            }
            super.writeTo(zzsnVar);
        }

        public final zza zzDL() {
            this.name = null;
            this.zzaZS = null;
            this.zzbuu = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzsu
        public final int zzz() {
            int iZzz = super.zzz();
            if (this.name != null) {
                iZzz += zzsn.zzo(1, this.name);
            }
            return this.zzaZS != null ? iZzz + zzsn.zzf(2, this.zzaZS.booleanValue()) : iZzz;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzz, reason: merged with bridge method [inline-methods] */
        public final zza mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzsmVar.readString();
                        break;
                    case 16:
                        this.zzaZS = Boolean.valueOf(zzsmVar.zzJc());
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
    }

    public final class zzb extends zzsu {
        public String zzaVt;
        public Long zzaZT;
        public Integer zzaZU;
        public zzc[] zzaZV;
        public zza[] zzaZW;
        public zzpz.zza[] zzaZX;

        public zzb() {
            zzDM();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (this.zzaZT == null) {
                if (zzbVar.zzaZT != null) {
                    return false;
                }
            } else if (!this.zzaZT.equals(zzbVar.zzaZT)) {
                return false;
            }
            if (this.zzaVt == null) {
                if (zzbVar.zzaVt != null) {
                    return false;
                }
            } else if (!this.zzaVt.equals(zzbVar.zzaVt)) {
                return false;
            }
            if (this.zzaZU == null) {
                if (zzbVar.zzaZU != null) {
                    return false;
                }
            } else if (!this.zzaZU.equals(zzbVar.zzaZU)) {
                return false;
            }
            return zzss.equals(this.zzaZV, zzbVar.zzaZV) && zzss.equals(this.zzaZW, zzbVar.zzaZW) && zzss.equals(this.zzaZX, zzbVar.zzaZX);
        }

        public final int hashCode() {
            return (((((((((this.zzaVt == null ? 0 : this.zzaVt.hashCode()) + (((this.zzaZT == null ? 0 : this.zzaZT.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + (this.zzaZU != null ? this.zzaZU.hashCode() : 0)) * 31) + zzss.hashCode(this.zzaZV)) * 31) + zzss.hashCode(this.zzaZW)) * 31) + zzss.hashCode(this.zzaZX);
        }

        @Override // com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            if (this.zzaZT != null) {
                zzsnVar.zzb(1, this.zzaZT.longValue());
            }
            if (this.zzaVt != null) {
                zzsnVar.zzn(2, this.zzaVt);
            }
            if (this.zzaZU != null) {
                zzsnVar.zzA(3, this.zzaZU.intValue());
            }
            if (this.zzaZV != null && this.zzaZV.length > 0) {
                for (int i = 0; i < this.zzaZV.length; i++) {
                    zzc zzcVar = this.zzaZV[i];
                    if (zzcVar != null) {
                        zzsnVar.zza(4, zzcVar);
                    }
                }
            }
            if (this.zzaZW != null && this.zzaZW.length > 0) {
                for (int i2 = 0; i2 < this.zzaZW.length; i2++) {
                    zza zzaVar = this.zzaZW[i2];
                    if (zzaVar != null) {
                        zzsnVar.zza(5, zzaVar);
                    }
                }
            }
            if (this.zzaZX != null && this.zzaZX.length > 0) {
                for (int i3 = 0; i3 < this.zzaZX.length; i3++) {
                    zzpz.zza zzaVar2 = this.zzaZX[i3];
                    if (zzaVar2 != null) {
                        zzsnVar.zza(6, zzaVar2);
                    }
                }
            }
            super.writeTo(zzsnVar);
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzA, reason: merged with bridge method [inline-methods] */
        public final zzb mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzaZT = Long.valueOf(zzsmVar.zzJa());
                        break;
                    case 18:
                        this.zzaVt = zzsmVar.readString();
                        break;
                    case 24:
                        this.zzaZU = Integer.valueOf(zzsmVar.zzJb());
                        break;
                    case 34:
                        int iZzc = zzsx.zzc(zzsmVar, 34);
                        int length = this.zzaZV == null ? 0 : this.zzaZV.length;
                        zzc[] zzcVarArr = new zzc[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzaZV, 0, zzcVarArr, 0, length);
                        }
                        while (length < zzcVarArr.length - 1) {
                            zzcVarArr[length] = new zzc();
                            zzsmVar.zza(zzcVarArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        zzcVarArr[length] = new zzc();
                        zzsmVar.zza(zzcVarArr[length]);
                        this.zzaZV = zzcVarArr;
                        break;
                    case 42:
                        int iZzc2 = zzsx.zzc(zzsmVar, 42);
                        int length2 = this.zzaZW == null ? 0 : this.zzaZW.length;
                        zza[] zzaVarArr = new zza[iZzc2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzaZW, 0, zzaVarArr, 0, length2);
                        }
                        while (length2 < zzaVarArr.length - 1) {
                            zzaVarArr[length2] = new zza();
                            zzsmVar.zza(zzaVarArr[length2]);
                            zzsmVar.zzIX();
                            length2++;
                        }
                        zzaVarArr[length2] = new zza();
                        zzsmVar.zza(zzaVarArr[length2]);
                        this.zzaZW = zzaVarArr;
                        break;
                    case Place.TYPE_HOSPITAL /* 50 */:
                        int iZzc3 = zzsx.zzc(zzsmVar, 50);
                        int length3 = this.zzaZX == null ? 0 : this.zzaZX.length;
                        zzpz.zza[] zzaVarArr2 = new zzpz.zza[iZzc3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzaZX, 0, zzaVarArr2, 0, length3);
                        }
                        while (length3 < zzaVarArr2.length - 1) {
                            zzaVarArr2[length3] = new zzpz.zza();
                            zzsmVar.zza(zzaVarArr2[length3]);
                            zzsmVar.zzIX();
                            length3++;
                        }
                        zzaVarArr2[length3] = new zzpz.zza();
                        zzsmVar.zza(zzaVarArr2[length3]);
                        this.zzaZX = zzaVarArr2;
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

        public final zzb zzDM() {
            this.zzaZT = null;
            this.zzaVt = null;
            this.zzaZU = null;
            this.zzaZV = zzc.zzDN();
            this.zzaZW = zza.zzDK();
            this.zzaZX = zzpz.zza.zzDA();
            this.zzbuu = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzsu
        public final int zzz() {
            int iZzz = super.zzz();
            if (this.zzaZT != null) {
                iZzz += zzsn.zzd(1, this.zzaZT.longValue());
            }
            if (this.zzaVt != null) {
                iZzz += zzsn.zzo(2, this.zzaVt);
            }
            if (this.zzaZU != null) {
                iZzz += zzsn.zzC(3, this.zzaZU.intValue());
            }
            if (this.zzaZV != null && this.zzaZV.length > 0) {
                int iZzc = iZzz;
                for (int i = 0; i < this.zzaZV.length; i++) {
                    zzc zzcVar = this.zzaZV[i];
                    if (zzcVar != null) {
                        iZzc += zzsn.zzc(4, zzcVar);
                    }
                }
                iZzz = iZzc;
            }
            if (this.zzaZW != null && this.zzaZW.length > 0) {
                int iZzc2 = iZzz;
                for (int i2 = 0; i2 < this.zzaZW.length; i2++) {
                    zza zzaVar = this.zzaZW[i2];
                    if (zzaVar != null) {
                        iZzc2 += zzsn.zzc(5, zzaVar);
                    }
                }
                iZzz = iZzc2;
            }
            if (this.zzaZX != null && this.zzaZX.length > 0) {
                for (int i3 = 0; i3 < this.zzaZX.length; i3++) {
                    zzpz.zza zzaVar2 = this.zzaZX[i3];
                    if (zzaVar2 != null) {
                        iZzz += zzsn.zzc(6, zzaVar2);
                    }
                }
            }
            return iZzz;
        }
    }

    public final class zzc extends zzsu {
        private static volatile zzc[] zzaZY;
        public String key;
        public String value;

        public zzc() {
            zzDO();
        }

        public static zzc[] zzDN() {
            if (zzaZY == null) {
                synchronized (zzss.zzbut) {
                    if (zzaZY == null) {
                        zzaZY = new zzc[0];
                    }
                }
            }
            return zzaZY;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) obj;
            if (this.key == null) {
                if (zzcVar.key != null) {
                    return false;
                }
            } else if (!this.key.equals(zzcVar.key)) {
                return false;
            }
            return this.value == null ? zzcVar.value == null : this.value.equals(zzcVar.value);
        }

        public final int hashCode() {
            return (((this.key == null ? 0 : this.key.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + (this.value != null ? this.value.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            if (this.key != null) {
                zzsnVar.zzn(1, this.key);
            }
            if (this.value != null) {
                zzsnVar.zzn(2, this.value);
            }
            super.writeTo(zzsnVar);
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzB, reason: merged with bridge method [inline-methods] */
        public final zzc mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.key = zzsmVar.readString();
                        break;
                    case 18:
                        this.value = zzsmVar.readString();
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

        public final zzc zzDO() {
            this.key = null;
            this.value = null;
            this.zzbuu = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzsu
        public final int zzz() {
            int iZzz = super.zzz();
            if (this.key != null) {
                iZzz += zzsn.zzo(1, this.key);
            }
            return this.value != null ? iZzz + zzsn.zzo(2, this.value) : iZzz;
        }
    }
}
