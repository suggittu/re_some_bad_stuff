package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsn;

/* loaded from: classes2.dex */
public interface zzpm {

    public final class zza extends zzso {
        public C0151zza[] zzaMo;

        /* renamed from: com.google.android.gms.internal.zzpm$zza$zza, reason: collision with other inner class name */
        public final class C0151zza extends zzso {
            private static volatile C0151zza[] zzaMp;
            public int viewId;
            public String zzaMq;
            public String zzaMr;

            public C0151zza() {
                zzyr();
            }

            public static C0151zza[] zzyq() {
                if (zzaMp == null) {
                    synchronized (zzss.zzbut) {
                        if (zzaMp == null) {
                            zzaMp = new C0151zza[0];
                        }
                    }
                }
                return zzaMp;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof C0151zza)) {
                    return false;
                }
                C0151zza c0151zza = (C0151zza) obj;
                if (this.zzaMq == null) {
                    if (c0151zza.zzaMq != null) {
                        return false;
                    }
                } else if (!this.zzaMq.equals(c0151zza.zzaMq)) {
                    return false;
                }
                if (this.zzaMr == null) {
                    if (c0151zza.zzaMr != null) {
                        return false;
                    }
                } else if (!this.zzaMr.equals(c0151zza.zzaMr)) {
                    return false;
                }
                if (this.viewId != c0151zza.viewId) {
                    return false;
                }
                return (this.zzbuj == null || this.zzbuj.isEmpty()) ? c0151zza.zzbuj == null || c0151zza.zzbuj.isEmpty() : this.zzbuj.equals(c0151zza.zzbuj);
            }

            public final int hashCode() {
                int iHashCode = 0;
                int iHashCode2 = ((((this.zzaMr == null ? 0 : this.zzaMr.hashCode()) + (((this.zzaMq == null ? 0 : this.zzaMq.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + this.viewId) * 31;
                if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                    iHashCode = this.zzbuj.hashCode();
                }
                return iHashCode2 + iHashCode;
            }

            @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
            public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
                if (!this.zzaMq.equals("")) {
                    zzsnVar.zzn(1, this.zzaMq);
                }
                if (!this.zzaMr.equals("")) {
                    zzsnVar.zzn(2, this.zzaMr);
                }
                if (this.viewId != 0) {
                    zzsnVar.zzA(3, this.viewId);
                }
                super.writeTo(zzsnVar);
            }

            @Override // com.google.android.gms.internal.zzsu
            /* renamed from: zzp, reason: merged with bridge method [inline-methods] */
            public final C0151zza mergeFrom(zzsm zzsmVar) throws zzst {
                while (true) {
                    int iZzIX = zzsmVar.zzIX();
                    switch (iZzIX) {
                        case 0:
                            break;
                        case 10:
                            this.zzaMq = zzsmVar.readString();
                            break;
                        case 18:
                            this.zzaMr = zzsmVar.readString();
                            break;
                        case 24:
                            this.viewId = zzsmVar.zzJb();
                            break;
                        default:
                            if (!zza(zzsmVar, iZzIX)) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            public final C0151zza zzyr() {
                this.zzaMq = "";
                this.zzaMr = "";
                this.viewId = 0;
                this.zzbuj = null;
                this.zzbuu = -1;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
            public final int zzz() {
                int iZzz = super.zzz();
                if (!this.zzaMq.equals("")) {
                    iZzz += zzsn.zzo(1, this.zzaMq);
                }
                if (!this.zzaMr.equals("")) {
                    iZzz += zzsn.zzo(2, this.zzaMr);
                }
                return this.viewId != 0 ? iZzz + zzsn.zzC(3, this.viewId) : iZzz;
            }
        }

        public zza() {
            zzyp();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (zzss.equals(this.zzaMo, zzaVar.zzaMo)) {
                return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzaVar.zzbuj == null || zzaVar.zzbuj.isEmpty() : this.zzbuj.equals(zzaVar.zzbuj);
            }
            return false;
        }

        public final int hashCode() {
            return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzaMo)) * 31);
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            if (this.zzaMo != null && this.zzaMo.length > 0) {
                for (int i = 0; i < this.zzaMo.length; i++) {
                    C0151zza c0151zza = this.zzaMo[i];
                    if (c0151zza != null) {
                        zzsnVar.zza(1, c0151zza);
                    }
                }
            }
            super.writeTo(zzsnVar);
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzo, reason: merged with bridge method [inline-methods] */
        public final zza mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        int iZzc = zzsx.zzc(zzsmVar, 10);
                        int length = this.zzaMo == null ? 0 : this.zzaMo.length;
                        C0151zza[] c0151zzaArr = new C0151zza[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzaMo, 0, c0151zzaArr, 0, length);
                        }
                        while (length < c0151zzaArr.length - 1) {
                            c0151zzaArr[length] = new C0151zza();
                            zzsmVar.zza(c0151zzaArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        c0151zzaArr[length] = new C0151zza();
                        zzsmVar.zza(c0151zzaArr[length]);
                        this.zzaMo = c0151zzaArr;
                        break;
                    default:
                        if (!zza(zzsmVar, iZzIX)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public final zza zzyp() {
            this.zzaMo = C0151zza.zzyq();
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public final int zzz() {
            int iZzz = super.zzz();
            if (this.zzaMo != null && this.zzaMo.length > 0) {
                for (int i = 0; i < this.zzaMo.length; i++) {
                    C0151zza c0151zza = this.zzaMo[i];
                    if (c0151zza != null) {
                        iZzz += zzsn.zzc(1, c0151zza);
                    }
                }
            }
            return iZzz;
        }
    }

    public final class zzb extends zzso {
        private static volatile zzb[] zzaMs;
        public String name;
        public zzd zzaMt;

        public zzb() {
            zzyt();
        }

        public static zzb[] zzys() {
            if (zzaMs == null) {
                synchronized (zzss.zzbut) {
                    if (zzaMs == null) {
                        zzaMs = new zzb[0];
                    }
                }
            }
            return zzaMs;
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
            if (this.zzaMt == null) {
                if (zzbVar.zzaMt != null) {
                    return false;
                }
            } else if (!this.zzaMt.equals(zzbVar.zzaMt)) {
                return false;
            }
            return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzbVar.zzbuj == null || zzbVar.zzbuj.isEmpty() : this.zzbuj.equals(zzbVar.zzbuj);
        }

        public final int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.zzaMt == null ? 0 : this.zzaMt.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                iHashCode = this.zzbuj.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            if (!this.name.equals("")) {
                zzsnVar.zzn(1, this.name);
            }
            if (this.zzaMt != null) {
                zzsnVar.zza(2, this.zzaMt);
            }
            super.writeTo(zzsnVar);
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
        public final zzb mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzsmVar.readString();
                        break;
                    case 18:
                        if (this.zzaMt == null) {
                            this.zzaMt = new zzd();
                        }
                        zzsmVar.zza(this.zzaMt);
                        break;
                    default:
                        if (!zza(zzsmVar, iZzIX)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public final zzb zzyt() {
            this.name = "";
            this.zzaMt = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public final int zzz() {
            int iZzz = super.zzz();
            if (!this.name.equals("")) {
                iZzz += zzsn.zzo(1, this.name);
            }
            return this.zzaMt != null ? iZzz + zzsn.zzc(2, this.zzaMt) : iZzz;
        }
    }

    public final class zzc extends zzso {
        public String type;
        public zzb[] zzaMu;

        public zzc() {
            zzyu();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) obj;
            if (this.type == null) {
                if (zzcVar.type != null) {
                    return false;
                }
            } else if (!this.type.equals(zzcVar.type)) {
                return false;
            }
            if (zzss.equals(this.zzaMu, zzcVar.zzaMu)) {
                return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzcVar.zzbuj == null || zzcVar.zzbuj.isEmpty() : this.zzbuj.equals(zzcVar.zzbuj);
            }
            return false;
        }

        public final int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((((this.type == null ? 0 : this.type.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzss.hashCode(this.zzaMu)) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                iHashCode = this.zzbuj.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            if (!this.type.equals("")) {
                zzsnVar.zzn(1, this.type);
            }
            if (this.zzaMu != null && this.zzaMu.length > 0) {
                for (int i = 0; i < this.zzaMu.length; i++) {
                    zzb zzbVar = this.zzaMu[i];
                    if (zzbVar != null) {
                        zzsnVar.zza(2, zzbVar);
                    }
                }
            }
            super.writeTo(zzsnVar);
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzr, reason: merged with bridge method [inline-methods] */
        public final zzc mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 10:
                        this.type = zzsmVar.readString();
                        break;
                    case 18:
                        int iZzc = zzsx.zzc(zzsmVar, 18);
                        int length = this.zzaMu == null ? 0 : this.zzaMu.length;
                        zzb[] zzbVarArr = new zzb[iZzc + length];
                        if (length != 0) {
                            System.arraycopy(this.zzaMu, 0, zzbVarArr, 0, length);
                        }
                        while (length < zzbVarArr.length - 1) {
                            zzbVarArr[length] = new zzb();
                            zzsmVar.zza(zzbVarArr[length]);
                            zzsmVar.zzIX();
                            length++;
                        }
                        zzbVarArr[length] = new zzb();
                        zzsmVar.zza(zzbVarArr[length]);
                        this.zzaMu = zzbVarArr;
                        break;
                    default:
                        if (!zza(zzsmVar, iZzIX)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public final zzc zzyu() {
            this.type = "";
            this.zzaMu = zzb.zzys();
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public final int zzz() {
            int iZzz = super.zzz();
            if (!this.type.equals("")) {
                iZzz += zzsn.zzo(1, this.type);
            }
            if (this.zzaMu == null || this.zzaMu.length <= 0) {
                return iZzz;
            }
            int iZzc = iZzz;
            for (int i = 0; i < this.zzaMu.length; i++) {
                zzb zzbVar = this.zzaMu[i];
                if (zzbVar != null) {
                    iZzc += zzsn.zzc(2, zzbVar);
                }
            }
            return iZzc;
        }
    }

    public final class zzd extends zzso {
        public boolean zzaMv;
        public long zzaMw;
        public double zzaMx;
        public zzc zzaMy;
        public String zzamJ;

        public zzd() {
            zzyv();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) obj;
            if (this.zzaMv != zzdVar.zzaMv) {
                return false;
            }
            if (this.zzamJ == null) {
                if (zzdVar.zzamJ != null) {
                    return false;
                }
            } else if (!this.zzamJ.equals(zzdVar.zzamJ)) {
                return false;
            }
            if (this.zzaMw == zzdVar.zzaMw && Double.doubleToLongBits(this.zzaMx) == Double.doubleToLongBits(zzdVar.zzaMx)) {
                if (this.zzaMy == null) {
                    if (zzdVar.zzaMy != null) {
                        return false;
                    }
                } else if (!this.zzaMy.equals(zzdVar.zzaMy)) {
                    return false;
                }
                return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzdVar.zzbuj == null || zzdVar.zzbuj.isEmpty() : this.zzbuj.equals(zzdVar.zzbuj);
            }
            return false;
        }

        public final int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = (((this.zzamJ == null ? 0 : this.zzamJ.hashCode()) + (((this.zzaMv ? 1231 : 1237) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + ((int) (this.zzaMw ^ (this.zzaMw >>> 32)));
            long jDoubleToLongBits = Double.doubleToLongBits(this.zzaMx);
            int iHashCode3 = ((this.zzaMy == null ? 0 : this.zzaMy.hashCode()) + (((iHashCode2 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31)) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                iHashCode = this.zzbuj.hashCode();
            }
            return iHashCode3 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            if (this.zzaMv) {
                zzsnVar.zze(1, this.zzaMv);
            }
            if (!this.zzamJ.equals("")) {
                zzsnVar.zzn(2, this.zzamJ);
            }
            if (this.zzaMw != 0) {
                zzsnVar.zzb(3, this.zzaMw);
            }
            if (Double.doubleToLongBits(this.zzaMx) != Double.doubleToLongBits(0.0d)) {
                zzsnVar.zza(4, this.zzaMx);
            }
            if (this.zzaMy != null) {
                zzsnVar.zza(5, this.zzaMy);
            }
            super.writeTo(zzsnVar);
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzs, reason: merged with bridge method [inline-methods] */
        public final zzd mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzaMv = zzsmVar.zzJc();
                        break;
                    case 18:
                        this.zzamJ = zzsmVar.readString();
                        break;
                    case 24:
                        this.zzaMw = zzsmVar.zzJa();
                        break;
                    case 33:
                        this.zzaMx = zzsmVar.readDouble();
                        break;
                    case 42:
                        if (this.zzaMy == null) {
                            this.zzaMy = new zzc();
                        }
                        zzsmVar.zza(this.zzaMy);
                        break;
                    default:
                        if (!zza(zzsmVar, iZzIX)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }

        public final zzd zzyv() {
            this.zzaMv = false;
            this.zzamJ = "";
            this.zzaMw = 0L;
            this.zzaMx = 0.0d;
            this.zzaMy = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public final int zzz() {
            int iZzz = super.zzz();
            if (this.zzaMv) {
                iZzz += zzsn.zzf(1, this.zzaMv);
            }
            if (!this.zzamJ.equals("")) {
                iZzz += zzsn.zzo(2, this.zzamJ);
            }
            if (this.zzaMw != 0) {
                iZzz += zzsn.zzd(3, this.zzaMw);
            }
            if (Double.doubleToLongBits(this.zzaMx) != Double.doubleToLongBits(0.0d)) {
                iZzz += zzsn.zzb(4, this.zzaMx);
            }
            return this.zzaMy != null ? iZzz + zzsn.zzc(5, this.zzaMy) : iZzz;
        }
    }
}
