package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.location.places.Place;

/* loaded from: classes2.dex */
public interface zzrq {

    public final class zza extends zzso {
        public long zzbmd;
        public zzaf.zzj zzbme;
        public zzaf.zzf zzju;

        public zza() {
            zzHG();
        }

        public static zza zzy(byte[] bArr) {
            return (zza) zzsu.mergeFrom(new zza(), bArr);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.zzbmd != zzaVar.zzbmd) {
                return false;
            }
            if (this.zzju == null) {
                if (zzaVar.zzju != null) {
                    return false;
                }
            } else if (!this.zzju.equals(zzaVar.zzju)) {
                return false;
            }
            if (this.zzbme == null) {
                if (zzaVar.zzbme != null) {
                    return false;
                }
            } else if (!this.zzbme.equals(zzaVar.zzbme)) {
                return false;
            }
            return (this.zzbuj == null || this.zzbuj.isEmpty()) ? zzaVar.zzbuj == null || zzaVar.zzbuj.isEmpty() : this.zzbuj.equals(zzaVar.zzbuj);
        }

        public final int hashCode() {
            int iHashCode = 0;
            int iHashCode2 = ((this.zzbme == null ? 0 : this.zzbme.hashCode()) + (((this.zzju == null ? 0 : this.zzju.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzbmd ^ (this.zzbmd >>> 32)))) * 31)) * 31)) * 31;
            if (this.zzbuj != null && !this.zzbuj.isEmpty()) {
                iHashCode = this.zzbuj.hashCode();
            }
            return iHashCode2 + iHashCode;
        }

        @Override // com.google.android.gms.internal.zzso, com.google.android.gms.internal.zzsu
        public final void writeTo(zzsn zzsnVar) throws zzsn.zza {
            zzsnVar.zzb(1, this.zzbmd);
            if (this.zzju != null) {
                zzsnVar.zza(2, this.zzju);
            }
            if (this.zzbme != null) {
                zzsnVar.zza(3, this.zzbme);
            }
            super.writeTo(zzsnVar);
        }

        public final zza zzHG() {
            this.zzbmd = 0L;
            this.zzju = null;
            this.zzbme = null;
            this.zzbuj = null;
            this.zzbuu = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzsu
        /* renamed from: zzJ, reason: merged with bridge method [inline-methods] */
        public final zza mergeFrom(zzsm zzsmVar) throws zzst {
            while (true) {
                int iZzIX = zzsmVar.zzIX();
                switch (iZzIX) {
                    case 0:
                        break;
                    case 8:
                        this.zzbmd = zzsmVar.zzJa();
                        break;
                    case 18:
                        if (this.zzju == null) {
                            this.zzju = new zzaf.zzf();
                        }
                        zzsmVar.zza(this.zzju);
                        break;
                    case Place.TYPE_CONVENIENCE_STORE /* 26 */:
                        if (this.zzbme == null) {
                            this.zzbme = new zzaf.zzj();
                        }
                        zzsmVar.zza(this.zzbme);
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
            int iZzz = super.zzz() + zzsn.zzd(1, this.zzbmd);
            if (this.zzju != null) {
                iZzz += zzsn.zzc(2, this.zzju);
            }
            return this.zzbme != null ? iZzz + zzsn.zzc(3, this.zzbme) : iZzz;
        }
    }
}
