package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsn;

/* loaded from: classes2.dex */
public interface zzsy {

    public final class zza extends zzsu {
        public String name;
        public zzb[] zzbuE;

        public zza() {
            zzJz();
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
            return zzss.equals(this.zzbuE, zzaVar.zzbuE);
        }

        public final int hashCode() {
            return (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzss.hashCode(this.zzbuE);
        }

        @Override // com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            if (this.name != null) {
                zzsnVar.zzn(1, this.name);
            }
            if (this.zzbuE != null && this.zzbuE.length > 0) {
                for (int i = 0; i < this.zzbuE.length; i++) {
                    zzb zzbVar = this.zzbuE[i];
                    if (zzbVar != null) {
                        zzsnVar.zza(2, zzbVar);
                    }
                }
            }
            super.writeTo(zzsnVar);
        }

        public final zza zzJz() {
            this.name = null;
            this.zzbuE = zzb.zzJA();
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzQ, reason: merged with bridge method [inline-methods] */
        public final zza mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzsmVar.readString();
                        break;
                    case 18:
                        int iZzc = zzsx.zzc(zzsmVar, 18);
                        int length = this.zzbuE == null ? 0 : this.zzbuE.length;
                        zzb[] zzbVarArr = new zzb[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzbuE, 0, zzbVarArr, 0, length);
                        }
                        while (length < zzbVarArr.length - 1) {
                            zzbVarArr[length] = new zzb();
                            zzsmVar.zza(zzbVarArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        zzbVarArr[length] = new zzb();
                        zzsmVar.zza(zzbVarArr[length]);
                        this.zzbuE = zzbVarArr;
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
            if (this.name != null) {
                iZzz += zzsn.zzo(1, this.name);
            }
            if (this.zzbuE == null || this.zzbuE.length <= 0) {
                return iZzz;
            }
            int iZzc = iZzz;
            for (int i = 0; i < this.zzbuE.length; i++) {
                zzb zzbVar = this.zzbuE[i];
                if (zzbVar != null) {
                    iZzc += zzsn.zzc(2, zzbVar);
                }
            }
            return iZzc;
        }
    }

    public final class zzb extends zzsu {
        private static volatile zzb[] zzbuF;
        public String name;
        public Integer zzbuG;
        public Boolean zzbuH;

        public zzb() {
            zzJB();
        }

        public static zzb[] zzJA() {
            if (zzbuF == null) {
                synchronized (zzss.zzbut) {
                    if (zzbuF == null) {
                        zzbuF = new zzb[0];
                    }
                }
            }
            return zzbuF;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (this.name == null) {
                if (zzbVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzbVar.name)) {
                return false;
            }
            if (this.zzbuG == null) {
                if (zzbVar.zzbuG != null) {
                    return false;
                }
            } else if (!this.zzbuG.equals(zzbVar.zzbuG)) {
                return false;
            }
            return this.zzbuH == null ? zzbVar.zzbuH == null : this.zzbuH.equals(zzbVar.zzbuH);
        }

        public final int hashCode() {
            return (((this.zzbuG == null ? 0 : this.zzbuG.intValue()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + (this.zzbuH != null ? this.zzbuH.hashCode() : 0);
        }

        @Override // com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            if (this.name != null) {
                zzsnVar.zzn(1, this.name);
            }
            if (this.zzbuG != null) {
                zzsnVar.zzA(3, this.zzbuG.intValue());
            }
            if (this.zzbuH != null) {
                zzsnVar.zze(4, this.zzbuH.booleanValue());
            }
            super.writeTo(zzsnVar);
        }

        public final zzb zzJB() {
            this.name = null;
            this.zzbuG = null;
            this.zzbuH = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzR, reason: merged with bridge method [inline-methods] */
        public final zzb mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzsmVar.readString();
                        break;
                    case 24:
                        int iZzJb = zzsmVar.zzJb();
                        switch (iZzJb) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                this.zzbuG = Integer.valueOf(iZzJb);
                                break;
                        }
                    case 32:
                        this.zzbuH = Boolean.valueOf(zzsmVar.zzJc());
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
            if (this.name != null) {
                iZzz += zzsn.zzo(1, this.name);
            }
            if (this.zzbuG != null) {
                iZzz += zzsn.zzC(3, this.zzbuG.intValue());
            }
            return this.zzbuH != null ? iZzz + zzsn.zzf(4, this.zzbuH.booleanValue()) : iZzz;
        }
    }
}
