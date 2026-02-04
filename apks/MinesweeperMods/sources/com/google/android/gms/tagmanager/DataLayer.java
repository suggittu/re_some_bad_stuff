package com.google.android.gms.tagmanager;

import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] zzbir = "gtm.lifetime".toString().split("\\.");
    private static final Pattern zzbis = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap zzbit;
    private final Map zzbiu;
    private final ReentrantLock zzbiv;
    private final LinkedList zzbiw;
    private final zzc zzbix;
    private final CountDownLatch zzbiy;

    final class zza {
        public final Object zzNc;
        public final String zzvs;

        zza(String str, Object obj) {
            this.zzvs = str;
            this.zzNc = obj;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.zzvs.equals(zzaVar.zzvs) && this.zzNc.equals(zzaVar.zzNc);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.zzvs.hashCode()), Integer.valueOf(this.zzNc.hashCode())});
        }

        public final String toString() {
            return "Key: " + this.zzvs + " value: " + this.zzNc.toString();
        }
    }

    interface zzb {
        void zzQ(Map map);
    }

    interface zzc {

        public interface zza {
            void zzB(List list);
        }

        void zza(zza zzaVar);

        void zza(List list, long j);

        void zzfZ(String str);
    }

    DataLayer() {
        this(new zzc() { // from class: com.google.android.gms.tagmanager.DataLayer.1
            @Override // com.google.android.gms.tagmanager.DataLayer.zzc
            public void zza(zzc.zza zzaVar) {
                zzaVar.zzB(new ArrayList());
            }

            @Override // com.google.android.gms.tagmanager.DataLayer.zzc
            public void zza(List list, long j) {
            }

            @Override // com.google.android.gms.tagmanager.DataLayer.zzc
            public void zzfZ(String str) {
            }
        });
    }

    DataLayer(zzc zzcVar) {
        this.zzbix = zzcVar;
        this.zzbit = new ConcurrentHashMap();
        this.zzbiu = new HashMap();
        this.zzbiv = new ReentrantLock();
        this.zzbiw = new LinkedList();
        this.zzbiy = new CountDownLatch(1);
        zzGn();
    }

    public static List listOf(Object... objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static Map mapOf(Object... objArr) {
        if (objArr.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        HashMap map = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return map;
            }
            if (!(objArr[i2] instanceof String)) {
                throw new IllegalArgumentException("key is not a string: " + objArr[i2]);
            }
            map.put((String) objArr[i2], objArr[i2 + 1]);
            i = i2 + 2;
        }
    }

    private void zzGn() {
        this.zzbix.zza(new zzc.zza() { // from class: com.google.android.gms.tagmanager.DataLayer.2
            @Override // com.google.android.gms.tagmanager.DataLayer.zzc.zza
            public void zzB(List list) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zza zzaVar = (zza) it.next();
                    DataLayer.this.zzS(DataLayer.this.zzn(zzaVar.zzvs, zzaVar.zzNc));
                }
                DataLayer.this.zzbiy.countDown();
            }
        });
    }

    private void zzGo() {
        int i = 0;
        do {
            int i2 = i;
            Map map = (Map) this.zzbiw.poll();
            if (map == null) {
                return;
            }
            zzX(map);
            i = i2 + 1;
        } while (i <= 500);
        this.zzbiw.clear();
        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzS(Map map) {
        this.zzbiv.lock();
        try {
            this.zzbiw.offer(map);
            if (this.zzbiv.getHoldCount() == 1) {
                zzGo();
            }
            zzT(map);
        } finally {
            this.zzbiv.unlock();
        }
    }

    private void zzT(Map map) {
        Long lZzU = zzU(map);
        if (lZzU == null) {
            return;
        }
        List listZzW = zzW(map);
        listZzW.remove("gtm.lifetime");
        this.zzbix.zza(listZzW, lZzU.longValue());
    }

    private Long zzU(Map map) {
        Object objZzV = zzV(map);
        if (objZzV == null) {
            return null;
        }
        return zzfY(objZzV.toString());
    }

    private Object zzV(Map map) {
        String[] strArr = zzbir;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            String str = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(str);
        }
        return obj;
    }

    private List zzW(Map map) {
        ArrayList arrayList = new ArrayList();
        zza(map, "", arrayList);
        return arrayList;
    }

    private void zzX(Map map) {
        synchronized (this.zzbiu) {
            for (String str : map.keySet()) {
                zzd(zzn(str, map.get(str)), this.zzbiu);
            }
        }
        zzY(map);
    }

    private void zzY(Map map) {
        Iterator it = this.zzbit.keySet().iterator();
        while (it.hasNext()) {
            ((zzb) it.next()).zzQ(map);
        }
    }

    private void zza(Map map, String str, Collection collection) {
        for (Map.Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                zza((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new zza(str2, entry.getValue()));
            }
        }
    }

    static Long zzfY(String str) throws NumberFormatException {
        long j;
        Matcher matcher = zzbis.matcher(str);
        if (!matcher.matches()) {
            zzbg.zzaJ("unknown _lifetime: " + str);
            return null;
        }
        try {
            j = Long.parseLong(matcher.group(1));
        } catch (NumberFormatException e) {
            zzbg.zzaK("illegal number in _lifetime value: " + str);
            j = 0;
        }
        if (j <= 0) {
            zzbg.zzaJ("non-positive _lifetime: " + str);
            return null;
        }
        String strGroup = matcher.group(2);
        if (strGroup.length() == 0) {
            return Long.valueOf(j);
        }
        switch (strGroup.charAt(0)) {
            case 'd':
                break;
            case LocationRequest.PRIORITY_LOW_POWER /* 104 */:
                break;
            case 'm':
                break;
            case 's':
                break;
            default:
                zzbg.zzaK("unknown units in _lifetime: " + str);
                break;
        }
        return null;
    }

    public Object get(String str) {
        synchronized (this.zzbiu) {
            Object obj = this.zzbiu;
            String[] strArrSplit = str.split("\\.");
            int length = strArrSplit.length;
            Object obj2 = obj;
            int i = 0;
            while (i < length) {
                String str2 = strArrSplit[i];
                if (!(obj2 instanceof Map)) {
                    return null;
                }
                Object obj3 = ((Map) obj2).get(str2);
                if (obj3 == null) {
                    return null;
                }
                i++;
                obj2 = obj3;
            }
            return obj2;
        }
    }

    public void push(String str, Object obj) throws InterruptedException {
        push(zzn(str, obj));
    }

    public void push(Map map) throws InterruptedException {
        try {
            this.zzbiy.await();
        } catch (InterruptedException e) {
            zzbg.zzaK("DataLayer.push: unexpected InterruptedException");
        }
        zzS(map);
    }

    public void pushEvent(String str, Map map) throws InterruptedException {
        HashMap map2 = new HashMap(map);
        map2.put("event", str);
        push(map2);
    }

    public String toString() {
        String string;
        synchronized (this.zzbiu) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : this.zzbiu.entrySet()) {
                sb.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", entry.getKey(), entry.getValue()));
            }
            string = sb.toString();
        }
        return string;
    }

    void zza(zzb zzbVar) {
        this.zzbit.put(zzbVar, 0);
    }

    void zzb(List list, List list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            Object obj = list.get(i2);
            if (obj instanceof List) {
                if (!(list2.get(i2) instanceof List)) {
                    list2.set(i2, new ArrayList());
                }
                zzb((List) obj, (List) list2.get(i2));
            } else if (obj instanceof Map) {
                if (!(list2.get(i2) instanceof Map)) {
                    list2.set(i2, new HashMap());
                }
                zzd((Map) obj, (Map) list2.get(i2));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i2, obj);
            }
            i = i2 + 1;
        }
    }

    void zzd(Map map, Map map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                zzb((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                zzd((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    void zzfX(String str) throws InterruptedException {
        push(str, null);
        this.zzbix.zzfZ(str);
    }

    Map zzn(String str, Object obj) {
        HashMap map = new HashMap();
        String[] strArrSplit = str.toString().split("\\.");
        int i = 0;
        HashMap map2 = map;
        while (i < strArrSplit.length - 1) {
            HashMap map3 = new HashMap();
            map2.put(strArrSplit[i], map3);
            i++;
            map2 = map3;
        }
        map2.put(strArrSplit[strArrSplit.length - 1], obj);
        return map;
    }
}
