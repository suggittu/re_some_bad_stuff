package com.google.android.gms.internal;

import com.google.android.gms.internal.zzsn;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.places.Place;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzsj extends zzso {
    public zza[] zzbtA;

    public final class zza extends zzso {
        private static volatile zza[] zzbtB;
        public String name;
        public C0174zza zzbtC;

        /* renamed from: com.google.android.gms.internal.zzsj$zza$zza, reason: collision with other inner class name */
        public final class C0174zza extends zzso {
            private static volatile C0174zza[] zzbtD;
            public int type;
            public C0175zza zzbtE;

            /* renamed from: com.google.android.gms.internal.zzsj$zza$zza$zza, reason: collision with other inner class name */
            public final class C0175zza extends zzso {
                public byte[] zzbtF;
                public String zzbtG;
                public double zzbtH;
                public float zzbtI;
                public long zzbtJ;
                public int zzbtK;
                public int zzbtL;
                public boolean zzbtM;
                public zza[] zzbtN;
                public C0174zza[] zzbtO;
                public String[] zzbtP;
                public long[] zzbtQ;
                public float[] zzbtR;
                public long zzbtS;

                public C0175zza() {
                    zzIV();
                }

                public final boolean equals(Object obj) {
                    if (obj == this) {
                        return true;
                    }
                    if (!(obj instanceof C0175zza)) {
                        return false;
                    }
                    C0175zza c0175zza = (C0175zza) obj;
                    if (!Arrays.equals(this.zzbtF, c0175zza.zzbtF)) {
                        return false;
                    }
                    if (this.zzbtG == null) {
                        if (c0175zza.zzbtG != null) {
                            return false;
                        }
                    } else if (!this.zzbtG.equals(c0175zza.zzbtG)) {
                        return false;
                    }
                    if (Double.doubleToLongBits(this.zzbtH) == Double.doubleToLongBits(c0175zza.zzbtH) && Float.floatToIntBits(this.zzbtI) == Float.floatToIntBits(c0175zza.zzbtI) && this.zzbtJ == c0175zza.zzbtJ && this.zzbtK == c0175zza.zzbtK && this.zzbtL == c0175zza.zzbtL && this.zzbtM == c0175zza.zzbtM && zzss.equals(this.zzbtN, c0175zza.zzbtN) && zzss.equals(this.zzbtO, c0175zza.zzbtO) && zzss.equals(this.zzbtP, c0175zza.zzbtP) && zzss.equals(this.zzbtQ, c0175zza.zzbtQ) && zzss.equals(this.zzbtR, c0175zza.zzbtR) && this.zzbtS == c0175zza.zzbtS) {
                        return (this.zzbuj == null || this.zzbuj.isEmpty()) ? c0175zza.zzbuj == null || c0175zza.zzbuj.isEmpty() : this.zzbuj.equals(c0175zza.zzbuj);
                    }
                    return false;
                }

                public final int hashCode() {
                    int iHashCode = 0;
                    int iHashCode2 = (this.zzbtG == null ? 0 : this.zzbtG.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.zzbtF)) * 31);
                    long jDoubleToLongBits = Double.doubleToLongBits(this.zzbtH);
                    int iFloatToIntBits = ((((((((((((((this.zzbtM ? 1231 : 1237) + (((((((((((iHashCode2 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.zzbtI)) * 31) + ((int) (this.zzbtJ ^ (this.zzbtJ >>> 32)))) * 31) + this.zzbtK) * 31) + this.zzbtL) * 31)) * 31) + zzss.hashCode(this.zzbtN)) * 31) + zzss.hashCode(this.zzbtO)) * 31) + zzss.hashCode(this.zzbtP)) * 31) + zzss.hashCode(this.zzbtQ)) * 31) + zzss.hashCode(this.zzbtR)) * 31) + ((int) (this.zzbtS ^ (this.zzbtS >>> 32)))) * 31;
                    if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                        iHashCode = this.zzbuj.hashCode();
                    }
                    return iFloatToIntBits + iHashCode;
                }

                @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
                public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
                    if (!Arrays.equals(this.zzbtF, zzsx.zzbuD)) {
                        zzsnVar.zza(1, this.zzbtF);
                    }
                    if (!this.zzbtG.equals("")) {
                        zzsnVar.zzn(2, this.zzbtG);
                    }
                    if (Double.doubleToLongBits(this.zzbtH) != Double.doubleToLongBits(0.0d)) {
                        zzsnVar.zza(3, this.zzbtH);
                    }
                    if (Float.floatToIntBits(this.zzbtI) != Float.floatToIntBits(0.0f)) {
                        zzsnVar.zzb(4, this.zzbtI);
                    }
                    if (this.zzbtJ != 0) {
                        zzsnVar.zzb(5, this.zzbtJ);
                    }
                    if (this.zzbtK != 0) {
                        zzsnVar.zzA(6, this.zzbtK);
                    }
                    if (this.zzbtL != 0) {
                        zzsnVar.zzB(7, this.zzbtL);
                    }
                    if (this.zzbtM) {
                        zzsnVar.zze(8, this.zzbtM);
                    }
                    if (this.zzbtN != null && this.zzbtN.length > 0) {
                        for (int i = 0; i < this.zzbtN.length; i++) {
                            zza zzaVar = this.zzbtN[i];
                            if (zzaVar != null) {
                                zzsnVar.zza(9, zzaVar);
                            }
                        }
                    }
                    if (this.zzbtO != null && this.zzbtO.length > 0) {
                        for (int i2 = 0; i2 < this.zzbtO.length; i2++) {
                            C0174zza c0174zza = this.zzbtO[i2];
                            if (c0174zza != null) {
                                zzsnVar.zza(10, c0174zza);
                            }
                        }
                    }
                    if (this.zzbtP != null && this.zzbtP.length > 0) {
                        for (int i3 = 0; i3 < this.zzbtP.length; i3++) {
                            String str = this.zzbtP[i3];
                            if (str != null) {
                                zzsnVar.zzn(11, str);
                            }
                        }
                    }
                    if (this.zzbtQ != null && this.zzbtQ.length > 0) {
                        for (int i4 = 0; i4 < this.zzbtQ.length; i4++) {
                            zzsnVar.zzb(12, this.zzbtQ[i4]);
                        }
                    }
                    if (this.zzbtS != 0) {
                        zzsnVar.zzb(13, this.zzbtS);
                    }
                    if (this.zzbtR != null && this.zzbtR.length > 0) {
                        for (int i5 = 0; i5 < this.zzbtR.length; i5++) {
                            zzsnVar.zzb(14, this.zzbtR[i5]);
                        }
                    }
                    super.writeTo(zzsnVar);
                }

                public final C0175zza zzIV() {
                    this.zzbtF = zzsx.zzbuD;
                    this.zzbtG = "";
                    this.zzbtH = 0.0d;
                    this.zzbtI = 0.0f;
                    this.zzbtJ = 0L;
                    this.zzbtK = 0;
                    this.zzbtL = 0;
                    this.zzbtM = false;
                    this.zzbtN = zza.zzIR();
                    this.zzbtO = C0174zza.zzIT();
                    this.zzbtP = zzsx.zzbuB;
                    this.zzbtQ = zzsx.zzbux;
                    this.zzbtR = zzsx.zzbuy;
                    this.zzbtS = 0L;
                    this.zzbuj = null;
                    this.zzbuu = -1;
                    return this;
                }

                @Override // com.google.android.gms.internal.zzsu
                /* renamed from: zzN, reason: merged with bridge method [inline-methods] */
                public final C0175zza mergeFrom(zzsm zzsmVar) throws zzst {
                    while (true) {
                        int iZzIX = zzsmVar.zzIX();
                        switch (iZzIX) {
                            case 0:
                                break;
                            case 10:
                                this.zzbtF = zzsmVar.readBytes();
                                break;
                            case 18:
                                this.zzbtG = zzsmVar.readString();
                                break;
                            case 25:
                                this.zzbtH = zzsmVar.readDouble();
                                break;
                            case 37:
                                this.zzbtI = zzsmVar.readFloat();
                                break;
                            case 40:
                                this.zzbtJ = zzsmVar.zzJa();
                                break;
                            case Place.TYPE_HINDU_TEMPLE /* 48 */:
                                this.zzbtK = zzsmVar.zzJb();
                                break;
                            case Place.TYPE_LIQUOR_STORE /* 56 */:
                                this.zzbtL = zzsmVar.zzJd();
                                break;
                            case 64:
                                this.zzbtM = zzsmVar.zzJc();
                                break;
                            case Place.TYPE_PLACE_OF_WORSHIP /* 74 */:
                                int iZzc = zzsx.zzc(zzsmVar, 74);
                                int length = this.zzbtN == null ? 0 : this.zzbtN.length;
                                zza[] zzaVarArr = new zza[iZzc + length];
                                if (length != 0) {
                                    System.arraycopy(this.zzbtN, 0, zzaVarArr, 0, length);
                                }
                                while (length < zzaVarArr.length - 1) {
                                    zzaVarArr[length] = new zza();
                                    zzsmVar.zza(zzaVarArr[length]);
                                    zzsmVar.zzIX();
                                    length++;
                                }
                                zzaVarArr[length] = new zza();
                                zzsmVar.zza(zzaVarArr[length]);
                                this.zzbtN = zzaVarArr;
                                break;
                            case Place.TYPE_SCHOOL /* 82 */:
                                int iZzc2 = zzsx.zzc(zzsmVar, 82);
                                int length2 = this.zzbtO == null ? 0 : this.zzbtO.length;
                                C0174zza[] c0174zzaArr = new C0174zza[iZzc2 + length2];
                                if (length2 != 0) {
                                    System.arraycopy(this.zzbtO, 0, c0174zzaArr, 0, length2);
                                }
                                while (length2 < c0174zzaArr.length - 1) {
                                    c0174zzaArr[length2] = new C0174zza();
                                    zzsmVar.zza(c0174zzaArr[length2]);
                                    zzsmVar.zzIX();
                                    length2++;
                                }
                                c0174zzaArr[length2] = new C0174zza();
                                zzsmVar.zza(c0174zzaArr[length2]);
                                this.zzbtO = c0174zzaArr;
                                break;
                            case Place.TYPE_SYNAGOGUE /* 90 */:
                                int iZzc3 = zzsx.zzc(zzsmVar, 90);
                                int length3 = this.zzbtP == null ? 0 : this.zzbtP.length;
                                String[] strArr = new String[iZzc3 + length3];
                                if (length3 != 0) {
                                    System.arraycopy(this.zzbtP, 0, strArr, 0, length3);
                                }
                                while (length3 < strArr.length - 1) {
                                    strArr[length3] = zzsmVar.readString();
                                    zzsmVar.zzIX();
                                    length3++;
                                }
                                strArr[length3] = zzsmVar.readString();
                                this.zzbtP = strArr;
                                break;
                            case Place.TYPE_ZOO /* 96 */:
                                int iZzc4 = zzsx.zzc(zzsmVar, 96);
                                int length4 = this.zzbtQ == null ? 0 : this.zzbtQ.length;
                                long[] jArr = new long[iZzc4 + length4];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzbtQ, 0, jArr, 0, length4);
                                }
                                while (length4 < jArr.length - 1) {
                                    jArr[length4] = zzsmVar.zzJa();
                                    zzsmVar.zzIX();
                                    length4++;
                                }
                                jArr[length4] = zzsmVar.zzJa();
                                this.zzbtQ = jArr;
                                break;
                            case 98:
                                int iZzmq = zzsmVar.zzmq(zzsmVar.zzJf());
                                int position = zzsmVar.getPosition();
                                int i = 0;
                                while (zzsmVar.zzJk() > 0) {
                                    zzsmVar.zzJa();
                                    i++;
                                }
                                zzsmVar.zzms(position);
                                int length5 = this.zzbtQ == null ? 0 : this.zzbtQ.length;
                                long[] jArr2 = new long[i + length5];
                                if (length5 != 0) {
                                    System.arraycopy(this.zzbtQ, 0, jArr2, 0, length5);
                                }
                                while (length5 < jArr2.length) {
                                    jArr2[length5] = zzsmVar.zzJa();
                                    length5++;
                                }
                                this.zzbtQ = jArr2;
                                zzsmVar.zzmr(iZzmq);
                                break;
                            case LocationRequest.PRIORITY_LOW_POWER /* 104 */:
                                this.zzbtS = zzsmVar.zzJa();
                                break;
                            case 114:
                                int iZzJf = zzsmVar.zzJf();
                                int iZzmq2 = zzsmVar.zzmq(iZzJf);
                                int i2 = iZzJf / 4;
                                int length6 = this.zzbtR == null ? 0 : this.zzbtR.length;
                                float[] fArr = new float[i2 + length6];
                                if (length6 != 0) {
                                    System.arraycopy(this.zzbtR, 0, fArr, 0, length6);
                                }
                                while (length6 < fArr.length) {
                                    fArr[length6] = zzsmVar.readFloat();
                                    length6++;
                                }
                                this.zzbtR = fArr;
                                zzsmVar.zzmr(iZzmq2);
                                break;
                            case 117:
                                int iZzc5 = zzsx.zzc(zzsmVar, 117);
                                int length7 = this.zzbtR == null ? 0 : this.zzbtR.length;
                                float[] fArr2 = new float[iZzc5 + length7];
                                if (length7 != 0) {
                                    System.arraycopy(this.zzbtR, 0, fArr2, 0, length7);
                                }
                                while (length7 < fArr2.length - 1) {
                                    fArr2[length7] = zzsmVar.readFloat();
                                    zzsmVar.zzIX();
                                    length7++;
                                }
                                fArr2[length7] = zzsmVar.readFloat();
                                this.zzbtR = fArr2;
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

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
                public final int zzz() {
                    int iZzz = super.zzz();
                    if (!Arrays.equals(this.zzbtF, zzsx.zzbuD)) {
                        iZzz += zzsn.zzb(1, this.zzbtF);
                    }
                    if (!this.zzbtG.equals("")) {
                        iZzz += zzsn.zzo(2, this.zzbtG);
                    }
                    if (Double.doubleToLongBits(this.zzbtH) != Double.doubleToLongBits(0.0d)) {
                        iZzz += zzsn.zzb(3, this.zzbtH);
                    }
                    if (Float.floatToIntBits(this.zzbtI) != Float.floatToIntBits(0.0f)) {
                        iZzz += zzsn.zzc(4, this.zzbtI);
                    }
                    if (this.zzbtJ != 0) {
                        iZzz += zzsn.zzd(5, this.zzbtJ);
                    }
                    if (this.zzbtK != 0) {
                        iZzz += zzsn.zzC(6, this.zzbtK);
                    }
                    if (this.zzbtL != 0) {
                        iZzz += zzsn.zzD(7, this.zzbtL);
                    }
                    if (this.zzbtM) {
                        iZzz += zzsn.zzf(8, this.zzbtM);
                    }
                    if (this.zzbtN != null && this.zzbtN.length > 0) {
                        int iZzc = iZzz;
                        for (int i = 0; i < this.zzbtN.length; i++) {
                            zza zzaVar = this.zzbtN[i];
                            if (zzaVar != null) {
                                iZzc += zzsn.zzc(9, zzaVar);
                            }
                        }
                        iZzz = iZzc;
                    }
                    if (this.zzbtO != null && this.zzbtO.length > 0) {
                        int iZzc2 = iZzz;
                        for (int i2 = 0; i2 < this.zzbtO.length; i2++) {
                            C0174zza c0174zza = this.zzbtO[i2];
                            if (c0174zza != null) {
                                iZzc2 += zzsn.zzc(10, c0174zza);
                            }
                        }
                        iZzz = iZzc2;
                    }
                    if (this.zzbtP != null && this.zzbtP.length > 0) {
                        int iZzgO = 0;
                        int i3 = 0;
                        for (int i4 = 0; i4 < this.zzbtP.length; i4++) {
                            String str = this.zzbtP[i4];
                            if (str != null) {
                                i3++;
                                iZzgO += zzsn.zzgO(str);
                            }
                        }
                        iZzz = iZzz + iZzgO + (i3 * 1);
                    }
                    if (this.zzbtQ != null && this.zzbtQ.length > 0) {
                        int iZzas = 0;
                        for (int i5 = 0; i5 < this.zzbtQ.length; i5++) {
                            iZzas += zzsn.zzas(this.zzbtQ[i5]);
                        }
                        iZzz = iZzz + iZzas + (this.zzbtQ.length * 1);
                    }
                    if (this.zzbtS != 0) {
                        iZzz += zzsn.zzd(13, this.zzbtS);
                    }
                    return (this.zzbtR == null || this.zzbtR.length <= 0) ? iZzz : iZzz + (this.zzbtR.length * 4) + (this.zzbtR.length * 1);
                }
            }

            public C0174zza() {
                zzIU();
            }

            public static C0174zza[] zzIT() {
                if (zzbtD == null) {
                    synchronized (zzss.zzbut) {
                        if (zzbtD == null) {
                            zzbtD = new C0174zza[0];
                        }
                    }
                }
                return zzbtD;
            }

            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof C0174zza)) {
                    return false;
                }
                C0174zza c0174zza = (C0174zza) obj;
                if (this.type != c0174zza.type) {
                    return false;
                }
                if (this.zzbtE == null) {
                    if (c0174zza.zzbtE != null) {
                        return false;
                    }
                } else if (!this.zzbtE.equals(c0174zza.zzbtE)) {
                    return false;
                }
                return (this.zzbuj == null || this.zzbuj.isEmpty()) ? c0174zza.zzbuj == null || c0174zza.zzbuj.isEmpty() : this.zzbuj.equals(c0174zza.zzbuj);
            }

            public final int hashCode() {
                int iHashCode = 0;
                int iHashCode2 = ((this.zzbtE == null ? 0 : this.zzbtE.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31)) * 31;
                if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                    iHashCode = this.zzbuj.hashCode();
                }
                return iHashCode2 + iHashCode;
            }

            @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
            public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
                zzsnVar.zzA(1, this.type);
                if (this.zzbtE != null) {
                    zzsnVar.zza(2, this.zzbtE);
                }
                super.writeTo(zzsnVar);
            }

            public final C0174zza zzIU() {
                this.type = 1;
                this.zzbtE = null;
                this.zzbuj = null;
                this.zzbuu = -1;
                return this;
            }

            @Override // com.google.android.gms.internal.zzsu
            /* renamed from: zzM, reason: merged with bridge method [inline-methods] */
            public final C0174zza mergeFrom(zzsm zzsmVar) throws zzst {
                while (true) {
                    int iZzIX = zzsmVar.zzIX();
                    switch (iZzIX) {
                        case 0:
                            break;
                        case 8:
                            int iZzJb = zzsmVar.zzJb();
                            switch (iZzJb) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                    this.type = iZzJb;
                                    break;
                            }
                        case 18:
                            if (this.zzbtE == null) {
                                this.zzbtE = new C0175zza();
                            }
                            zzsmVar.zza(this.zzbtE);
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

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
            public final int zzz() {
                int iZzz = super.zzz() + zzsn.zzC(1, this.type);
                return this.zzbtE != null ? iZzz + zzsn.zzc(2, this.zzbtE) : iZzz;
            }
        }

        public zza() {
            zzIS();
        }

        public static zza[] zzIR() {
            if (zzbtB == null) {
                synchronized (zzss.zzbut) {
                    if (zzbtB == null) {
                        zzbtB = new zza[0];
                    }
                }
            }
            return zzbtB;
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
            if (this.zzbtC == null) {
                if (zzaVar.zzbtC != null) {
                    return false;
                }
            } else if (!this.zzbtC.equals(zzaVar.zzbtC)) {
                return false;
            }
            return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzaVar.zzbuj == null || zzaVar.zzbuj.isEmpty() : this.zzbuj.equals(zzaVar.zzbuj);
        }

        public final int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.zzbtC == null ? 0 : this.zzbtC.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                iHashCode = this.zzbuj.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            zzsnVar.zzn(1, this.name);
            if (this.zzbtC != null) {
                zzsnVar.zza(2, this.zzbtC);
            }
            super.writeTo(zzsnVar);
        }

        public final zza zzIS() {
            this.name = "";
            this.zzbtC = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzL, reason: merged with bridge method [inline-methods] */
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
                        if (this.zzbtC == null) {
                            this.zzbtC = new C0174zza();
                        }
                        zzsmVar.zza(this.zzbtC);
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

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public final int zzz() {
            int iZzz = super.zzz() + zzsn.zzo(1, this.name);
            return this.zzbtC != null ? iZzz + zzsn.zzc(2, this.zzbtC) : iZzz;
        }
    }

    public zzsj() {
        zzIQ();
    }

    public static zzsj zzA(byte[] bArr) {
        return (zzsj) zzsu.mergeFrom(new zzsj(), bArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzsj)) {
            return false;
        }
        zzsj zzsjVar = (zzsj) obj;
        if (zzss.equals(this.zzbtA, zzsjVar.zzbtA)) {
            return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzsjVar.zzbuj == null || zzsjVar.zzbuj.isEmpty() : this.zzbuj.equals(zzsjVar.zzbuj);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zzbuj == null || this.zzbuj.isEmpty()) ? 0 : this.zzbuj.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzss.hashCode(this.zzbtA)) * 31);
    }

    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
        if (this.zzbtA != null && this.zzbtA.length > 0) {
            for (int i = 0; i < this.zzbtA.length; i++) {
                zza zzaVar = this.zzbtA[i];
                if (zzaVar != null) {
                    zzsnVar.zza(1, zzaVar);
                }
            }
        }
        super.writeTo(zzsnVar);
    }

    public final zzsj zzIQ() {
        this.zzbtA = zza.zzIR();
        this.zzbuj = null;
        this.zzbuu = -1;
        return this;
    }

    @Override // com.google.android.gms.internal.zzsu
    /* renamed from: zzK, reason: merged with bridge method [inline-methods] */
    public final zzsj mergeFrom(zzsm zzsmVar) throws zzst {
        while (true) {
            int iZzIX = zzsmVar.zzIX();
            switch (iZzIX) {
                case 0:
                    break;
                case 10:
                    int iZzc = zzsx.zzc(zzsmVar, 10);
                    int length = this.zzbtA == null ? 0 : this.zzbtA.length;
                    zza[] zzaVarArr = new zza[iZzc + length];
                    if (length != 0) {
                        System.arraycopy(this.zzbtA, 0, zzaVarArr, 0, length);
                    }
                    while (length < zzaVarArr.length - 1) {
                        zzaVarArr[length] = new zza();
                        zzsmVar.zza(zzaVarArr[length]);
                        zzsmVar.zzIX();
                        length++;
                    }
                    zzaVarArr[length] = new zza();
                    zzsmVar.zza(zzaVarArr[length]);
                    this.zzbtA = zzaVarArr;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
    public final int zzz() {
        int iZzz = super.zzz();
        if (this.zzbtA != null && this.zzbtA.length > 0) {
            for (int i = 0; i < this.zzbtA.length; i++) {
                zza zzaVar = this.zzbtA[i];
                if (zzaVar != null) {
                    iZzz += zzsn.zzc(1, zzaVar);
                }
            }
        }
        return iZzz;
    }
}
