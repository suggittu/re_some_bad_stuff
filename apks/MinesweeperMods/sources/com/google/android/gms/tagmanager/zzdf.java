package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class zzdf {
    private static final Object zzblE = null;
    private static Long zzblF = new Long(0);
    private static Double zzblG = new Double(0.0d);
    private static zzde zzblH = zzde.zzam(0);
    private static String zzblI = new String("");
    private static Boolean zzblJ = new Boolean(false);
    private static List zzblK = new ArrayList(0);
    private static Map zzblL = new HashMap();
    private static zzag.zza zzblM = zzR(zzblI);

    private static double getDouble(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        zzbg.e("getDouble received non-Number");
        return 0.0d;
    }

    public static Long zzHA() {
        return zzblF;
    }

    public static Double zzHB() {
        return zzblG;
    }

    public static Boolean zzHC() {
        return zzblJ;
    }

    public static zzde zzHD() {
        return zzblH;
    }

    public static String zzHE() {
        return zzblI;
    }

    public static zzag.zza zzHF() {
        return zzblM;
    }

    public static Object zzHz() {
        return zzblE;
    }

    public static String zzM(Object obj) {
        return obj == null ? zzblI : obj.toString();
    }

    public static zzde zzN(Object obj) {
        return obj instanceof zzde ? (zzde) obj : zzT(obj) ? zzde.zzam(zzU(obj)) : zzS(obj) ? zzde.zza(Double.valueOf(getDouble(obj))) : zzgu(zzM(obj));
    }

    public static Long zzO(Object obj) {
        return zzT(obj) ? Long.valueOf(zzU(obj)) : zzgv(zzM(obj));
    }

    public static Double zzP(Object obj) {
        return zzS(obj) ? Double.valueOf(getDouble(obj)) : zzgw(zzM(obj));
    }

    public static Boolean zzQ(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : zzgx(zzM(obj));
    }

    public static zzag.zza zzR(Object obj) {
        boolean z = false;
        zzag.zza zzaVar = new zzag.zza();
        if (obj instanceof zzag.zza) {
            return (zzag.zza) obj;
        }
        if (obj instanceof String) {
            zzaVar.type = 1;
            zzaVar.zzjx = (String) obj;
        } else if (obj instanceof List) {
            zzaVar.type = 2;
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                zzag.zza zzaVarZzR = zzR(it.next());
                if (zzaVarZzR == zzblM) {
                    return zzblM;
                }
                boolean z3 = z2 || zzaVarZzR.zzjH;
                arrayList.add(zzaVarZzR);
                z2 = z3;
            }
            zzaVar.zzjy = (zzag.zza[]) arrayList.toArray(new zzag.zza[0]);
            z = z2;
        } else if (obj instanceof Map) {
            zzaVar.type = 3;
            Set<Map.Entry> setEntrySet = ((Map) obj).entrySet();
            ArrayList arrayList2 = new ArrayList(setEntrySet.size());
            ArrayList arrayList3 = new ArrayList(setEntrySet.size());
            boolean z4 = false;
            for (Map.Entry entry : setEntrySet) {
                zzag.zza zzaVarZzR2 = zzR(entry.getKey());
                zzag.zza zzaVarZzR3 = zzR(entry.getValue());
                if (zzaVarZzR2 == zzblM || zzaVarZzR3 == zzblM) {
                    return zzblM;
                }
                boolean z5 = z4 || zzaVarZzR2.zzjH || zzaVarZzR3.zzjH;
                arrayList2.add(zzaVarZzR2);
                arrayList3.add(zzaVarZzR3);
                z4 = z5;
            }
            zzaVar.zzjz = (zzag.zza[]) arrayList2.toArray(new zzag.zza[0]);
            zzaVar.zzjA = (zzag.zza[]) arrayList3.toArray(new zzag.zza[0]);
            z = z4;
        } else if (zzS(obj)) {
            zzaVar.type = 1;
            zzaVar.zzjx = obj.toString();
        } else if (zzT(obj)) {
            zzaVar.type = 6;
            zzaVar.zzjD = zzU(obj);
        } else {
            if (!(obj instanceof Boolean)) {
                zzbg.e("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
                return zzblM;
            }
            zzaVar.type = 8;
            zzaVar.zzjE = ((Boolean) obj).booleanValue();
        }
        zzaVar.zzjH = z;
        return zzaVar;
    }

    private static boolean zzS(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof zzde) && ((zzde) obj).zzHu());
    }

    private static boolean zzT(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof zzde) && ((zzde) obj).zzHv());
    }

    private static long zzU(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzbg.e("getInt64 received non-Number");
        return 0L;
    }

    public static String zzg(zzag.zza zzaVar) {
        return zzM(zzl(zzaVar));
    }

    public static zzag.zza zzgt(String str) {
        zzag.zza zzaVar = new zzag.zza();
        zzaVar.type = 5;
        zzaVar.zzjC = str;
        return zzaVar;
    }

    private static zzde zzgu(String str) {
        try {
            return zzde.zzgs(str);
        } catch (NumberFormatException e) {
            zzbg.e("Failed to convert '" + str + "' to a number.");
            return zzblH;
        }
    }

    private static Long zzgv(String str) {
        zzde zzdeVarZzgu = zzgu(str);
        return zzdeVarZzgu == zzblH ? zzblF : Long.valueOf(zzdeVarZzgu.longValue());
    }

    private static Double zzgw(String str) {
        zzde zzdeVarZzgu = zzgu(str);
        return zzdeVarZzgu == zzblH ? zzblG : Double.valueOf(zzdeVarZzgu.doubleValue());
    }

    private static Boolean zzgx(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : zzblJ;
    }

    public static zzde zzh(zzag.zza zzaVar) {
        return zzN(zzl(zzaVar));
    }

    public static Long zzi(zzag.zza zzaVar) {
        return zzO(zzl(zzaVar));
    }

    public static Double zzj(zzag.zza zzaVar) {
        return zzP(zzl(zzaVar));
    }

    public static Boolean zzk(zzag.zza zzaVar) {
        return zzQ(zzl(zzaVar));
    }

    public static Object zzl(zzag.zza zzaVar) {
        int i = 0;
        if (zzaVar == null) {
            return zzblE;
        }
        switch (zzaVar.type) {
            case 1:
                break;
            case 2:
                ArrayList arrayList = new ArrayList(zzaVar.zzjy.length);
                zzag.zza[] zzaVarArr = zzaVar.zzjy;
                int length = zzaVarArr.length;
                while (i < length) {
                    Object objZzl = zzl(zzaVarArr[i]);
                    if (objZzl == zzblE) {
                        break;
                    } else {
                        arrayList.add(objZzl);
                        i++;
                    }
                }
                break;
            case 3:
                if (zzaVar.zzjz.length == zzaVar.zzjA.length) {
                    HashMap map = new HashMap(zzaVar.zzjA.length);
                    while (i < zzaVar.zzjz.length) {
                        Object objZzl2 = zzl(zzaVar.zzjz[i]);
                        Object objZzl3 = zzl(zzaVar.zzjA[i]);
                        if (objZzl2 == zzblE || objZzl3 == zzblE) {
                            break;
                        } else {
                            map.put(objZzl2, objZzl3);
                            i++;
                        }
                    }
                    break;
                } else {
                    zzbg.e("Converting an invalid value to object: " + zzaVar.toString());
                    break;
                }
                break;
            case 4:
                zzbg.e("Trying to convert a macro reference to object");
                break;
            case 5:
                zzbg.e("Trying to convert a function id to object");
                break;
            case 6:
                break;
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                zzag.zza[] zzaVarArr2 = zzaVar.zzjF;
                int length2 = zzaVarArr2.length;
                while (i < length2) {
                    String strZzg = zzg(zzaVarArr2[i]);
                    if (strZzg == zzblI) {
                        break;
                    } else {
                        stringBuffer.append(strZzg);
                        i++;
                    }
                }
                break;
            case 8:
                break;
            default:
                zzbg.e("Failed to convert a value of type: " + zzaVar.type);
                break;
        }
        return zzblE;
    }
}
