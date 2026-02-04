package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zznb;
import com.google.android.gms.internal.zznc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class FastJsonResponse {

    public class Field implements SafeParcelable {
        public static final com.google.android.gms.common.server.response.zza CREATOR = new com.google.android.gms.common.server.response.zza();
        private final int mVersionCode;
        protected final int zzamL;
        protected final boolean zzamM;
        protected final int zzamN;
        protected final boolean zzamO;
        protected final String zzamP;
        protected final int zzamQ;
        protected final Class zzamR;
        protected final String zzamS;
        private FieldMappingDictionary zzamT;
        private zza zzamU;

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            this.mVersionCode = i;
            this.zzamL = i2;
            this.zzamM = z;
            this.zzamN = i3;
            this.zzamO = z2;
            this.zzamP = str;
            this.zzamQ = i4;
            if (str2 == null) {
                this.zzamR = null;
                this.zzamS = null;
            } else {
                this.zzamR = SafeParcelResponse.class;
                this.zzamS = str2;
            }
            if (converterWrapper == null) {
                this.zzamU = null;
            } else {
                this.zzamU = converterWrapper.zzrh();
            }
        }

        protected Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class cls, zza zzaVar) {
            this.mVersionCode = 1;
            this.zzamL = i;
            this.zzamM = z;
            this.zzamN = i2;
            this.zzamO = z2;
            this.zzamP = str;
            this.zzamQ = i3;
            this.zzamR = cls;
            if (cls == null) {
                this.zzamS = null;
            } else {
                this.zzamS = cls.getCanonicalName();
            }
            this.zzamU = zzaVar;
        }

        public static Field zza(String str, int i, zza zzaVar, boolean z) {
            return new Field(zzaVar.zzrj(), z, zzaVar.zzrk(), false, str, i, null, zzaVar);
        }

        public static Field zza(String str, int i, Class cls) {
            return new Field(11, false, 11, false, str, i, cls, null);
        }

        public static Field zzb(String str, int i, Class cls) {
            return new Field(11, true, 11, true, str, i, cls, null);
        }

        public static Field zzi(String str, int i) {
            return new Field(0, false, 0, false, str, i, null, null);
        }

        public static Field zzj(String str, int i) {
            return new Field(4, false, 4, false, str, i, null, null);
        }

        public static Field zzk(String str, int i) {
            return new Field(6, false, 6, false, str, i, null, null);
        }

        public static Field zzl(String str, int i) {
            return new Field(7, false, 7, false, str, i, null, null);
        }

        public static Field zzm(String str, int i) {
            return new Field(7, true, 7, true, str, i, null, null);
        }

        public Object convertBack(Object obj) {
            return this.zzamU.convertBack(obj);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            com.google.android.gms.common.server.response.zza zzaVar = CREATOR;
            return 0;
        }

        public int getVersionCode() {
            return this.mVersionCode;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Field\n");
            sb.append("            versionCode=").append(this.mVersionCode).append('\n');
            sb.append("                 typeIn=").append(this.zzamL).append('\n');
            sb.append("            typeInArray=").append(this.zzamM).append('\n');
            sb.append("                typeOut=").append(this.zzamN).append('\n');
            sb.append("           typeOutArray=").append(this.zzamO).append('\n');
            sb.append("        outputFieldName=").append(this.zzamP).append('\n');
            sb.append("      safeParcelFieldId=").append(this.zzamQ).append('\n');
            sb.append("       concreteTypeName=").append(zzru()).append('\n');
            if (zzrt() != null) {
                sb.append("     concreteType.class=").append(zzrt().getCanonicalName()).append('\n');
            }
            sb.append("          converterName=").append(this.zzamU == null ? "null" : this.zzamU.getClass().getCanonicalName()).append('\n');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            com.google.android.gms.common.server.response.zza zzaVar = CREATOR;
            com.google.android.gms.common.server.response.zza.zza(this, parcel, i);
        }

        public void zza(FieldMappingDictionary fieldMappingDictionary) {
            this.zzamT = fieldMappingDictionary;
        }

        public int zzrj() {
            return this.zzamL;
        }

        public int zzrk() {
            return this.zzamN;
        }

        public Field zzro() {
            return new Field(this.mVersionCode, this.zzamL, this.zzamM, this.zzamN, this.zzamO, this.zzamP, this.zzamQ, this.zzamS, zzrw());
        }

        public boolean zzrp() {
            return this.zzamM;
        }

        public boolean zzrq() {
            return this.zzamO;
        }

        public String zzrr() {
            return this.zzamP;
        }

        public int zzrs() {
            return this.zzamQ;
        }

        public Class zzrt() {
            return this.zzamR;
        }

        String zzru() {
            if (this.zzamS == null) {
                return null;
            }
            return this.zzamS;
        }

        public boolean zzrv() {
            return this.zzamU != null;
        }

        ConverterWrapper zzrw() {
            if (this.zzamU == null) {
                return null;
            }
            return ConverterWrapper.zza(this.zzamU);
        }

        public Map zzrx() {
            zzx.zzz(this.zzamS);
            zzx.zzz(this.zzamT);
            return this.zzamT.zzcR(this.zzamS);
        }
    }

    public interface zza {
        Object convertBack(Object obj);

        int zzrj();

        int zzrk();
    }

    private void zza(StringBuilder sb, Field field, Object obj) {
        if (field.zzrj() == 11) {
            sb.append(((FastJsonResponse) field.zzrt().cast(obj)).toString());
        } else {
            if (field.zzrj() != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(zznb.zzcU((String) obj));
            sb.append("\"");
        }
    }

    private void zza(StringBuilder sb, Field field, ArrayList arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                zza(sb, field, obj);
            }
        }
        sb.append("]");
    }

    public String toString() {
        Map mapZzrl = zzrl();
        StringBuilder sb = new StringBuilder(100);
        for (String str : mapZzrl.keySet()) {
            Field field = (Field) mapZzrl.get(str);
            if (zza(field)) {
                Object objZza = zza(field, zzb(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"").append(str).append("\":");
                if (objZza != null) {
                    switch (field.zzrk()) {
                        case 8:
                            sb.append("\"").append(zzmo.zzj((byte[]) objZza)).append("\"");
                            break;
                        case 9:
                            sb.append("\"").append(zzmo.zzk((byte[]) objZza)).append("\"");
                            break;
                        case 10:
                            zznc.zza(sb, (HashMap) objZza);
                            break;
                        default:
                            if (field.zzrp()) {
                                zza(sb, field, (ArrayList) objZza);
                                break;
                            } else {
                                zza(sb, field, objZza);
                                break;
                            }
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    protected Object zza(Field field, Object obj) {
        return field.zzamU != null ? field.convertBack(obj) : obj;
    }

    protected boolean zza(Field field) {
        return field.zzrk() == 11 ? field.zzrq() ? zzcQ(field.zzrr()) : zzcP(field.zzrr()) : zzcO(field.zzrr());
    }

    protected Object zzb(Field field) {
        String strZzrr = field.zzrr();
        if (field.zzrt() == null) {
            return zzcN(field.zzrr());
        }
        zzx.zza(zzcN(field.zzrr()) == null, "Concrete field shouldn't be value object: %s", field.zzrr());
        HashMap mapZzrn = field.zzrq() ? zzrn() : zzrm();
        if (mapZzrn != null) {
            return mapZzrn.get(strZzrr);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(strZzrr.charAt(0)) + strZzrr.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract Object zzcN(String str);

    protected abstract boolean zzcO(String str);

    protected boolean zzcP(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean zzcQ(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public abstract Map zzrl();

    public HashMap zzrm() {
        return null;
    }

    public HashMap zzrn() {
        return null;
    }
}
