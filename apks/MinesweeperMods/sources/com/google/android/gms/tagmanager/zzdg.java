package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.zzag;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class zzdg extends zzdd {
    private static final String ID = com.google.android.gms.internal.zzad.UNIVERSAL_ANALYTICS.toString();
    private static final String zzblN = com.google.android.gms.internal.zzae.ACCOUNT.toString();
    private static final String zzblO = com.google.android.gms.internal.zzae.ANALYTICS_PASS_THROUGH.toString();
    private static final String zzblP = com.google.android.gms.internal.zzae.ENABLE_ECOMMERCE.toString();
    private static final String zzblQ = com.google.android.gms.internal.zzae.ECOMMERCE_USE_DATA_LAYER.toString();
    private static final String zzblR = com.google.android.gms.internal.zzae.ECOMMERCE_MACRO_DATA.toString();
    private static final String zzblS = com.google.android.gms.internal.zzae.ANALYTICS_FIELDS.toString();
    private static final String zzblT = com.google.android.gms.internal.zzae.TRACK_TRANSACTION.toString();
    private static final String zzblU = com.google.android.gms.internal.zzae.TRANSACTION_DATALAYER_MAP.toString();
    private static final String zzblV = com.google.android.gms.internal.zzae.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static final List zzblW = Arrays.asList(ProductAction.ACTION_DETAIL, ProductAction.ACTION_CHECKOUT, ProductAction.ACTION_CHECKOUT_OPTION, "click", ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, ProductAction.ACTION_PURCHASE, ProductAction.ACTION_REFUND);
    private static final Pattern zzblX = Pattern.compile("dimension(\\d+)");
    private static final Pattern zzblY = Pattern.compile("metric(\\d+)");
    private static Map zzblZ;
    private static Map zzbma;
    private final DataLayer zzbhN;
    private final Set zzbmb;
    private final zzdc zzbmc;

    public zzdg(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new zzdc(context));
    }

    zzdg(Context context, DataLayer dataLayer, zzdc zzdcVar) {
        super(ID, new String[0]);
        this.zzbhN = dataLayer;
        this.zzbmc = zzdcVar;
        this.zzbmb = new HashSet();
        this.zzbmb.add("");
        this.zzbmb.add("0");
        this.zzbmb.add("false");
    }

    private Double zzV(Object obj) {
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Cannot convert the object to Double: " + e.getMessage());
            }
        }
        if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
        if (obj instanceof Double) {
            return (Double) obj;
        }
        throw new RuntimeException("Cannot convert the object to Double: " + obj.toString());
    }

    private Integer zzW(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Cannot convert the object to Integer: " + e.getMessage());
            }
        }
        if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        throw new RuntimeException("Cannot convert the object to Integer: " + obj.toString());
    }

    private Promotion zzZ(Map map) {
        Promotion promotion = new Promotion();
        String str = (String) map.get("id");
        if (str != null) {
            promotion.setId(String.valueOf(str));
        }
        String str2 = (String) map.get("name");
        if (str2 != null) {
            promotion.setName(String.valueOf(str2));
        }
        String str3 = (String) map.get("creative");
        if (str3 != null) {
            promotion.setCreative(String.valueOf(str3));
        }
        String str4 = (String) map.get("position");
        if (str4 != null) {
            promotion.setPosition(String.valueOf(str4));
        }
        return promotion;
    }

    private void zza(Tracker tracker, Map map) {
        String strZzgy = zzgy("transactionId");
        if (strZzgy == null) {
            zzbg.e("Cannot find transactionId in data layer.");
            return;
        }
        LinkedList linkedList = new LinkedList();
        try {
            Map mapZzm = zzm((zzag.zza) map.get(zzblS));
            mapZzm.put("&t", "transaction");
            for (Map.Entry entry : zzab(map).entrySet()) {
                zze(mapZzm, (String) entry.getValue(), zzgy((String) entry.getKey()));
            }
            linkedList.add(mapZzm);
            List<Map> listZzgz = zzgz("transactionProducts");
            if (listZzgz != null) {
                for (Map map2 : listZzgz) {
                    if (map2.get("name") == null) {
                        zzbg.e("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map mapZzm2 = zzm((zzag.zza) map.get(zzblS));
                    mapZzm2.put("&t", "item");
                    mapZzm2.put("&ti", strZzgy);
                    for (Map.Entry entry2 : zzac(map).entrySet()) {
                        zze(mapZzm2, (String) entry2.getValue(), (String) map2.get(entry2.getKey()));
                    }
                    linkedList.add(mapZzm2);
                }
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                tracker.send((Map) it.next());
            }
        } catch (IllegalArgumentException e) {
            zzbg.zzb("Unable to send transaction", e);
        }
    }

    private Product zzaa(Map map) throws NumberFormatException {
        Product product = new Product();
        Object obj = map.get("id");
        if (obj != null) {
            product.setId(String.valueOf(obj));
        }
        Object obj2 = map.get("name");
        if (obj2 != null) {
            product.setName(String.valueOf(obj2));
        }
        Object obj3 = map.get("brand");
        if (obj3 != null) {
            product.setBrand(String.valueOf(obj3));
        }
        Object obj4 = map.get("category");
        if (obj4 != null) {
            product.setCategory(String.valueOf(obj4));
        }
        Object obj5 = map.get("variant");
        if (obj5 != null) {
            product.setVariant(String.valueOf(obj5));
        }
        Object obj6 = map.get("coupon");
        if (obj6 != null) {
            product.setCouponCode(String.valueOf(obj6));
        }
        Object obj7 = map.get("position");
        if (obj7 != null) {
            product.setPosition(zzW(obj7).intValue());
        }
        Object obj8 = map.get("price");
        if (obj8 != null) {
            product.setPrice(zzV(obj8).doubleValue());
        }
        Object obj9 = map.get("quantity");
        if (obj9 != null) {
            product.setQuantity(zzW(obj9).intValue());
        }
        for (String str : map.keySet()) {
            Matcher matcher = zzblX.matcher(str);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(str)));
                } catch (NumberFormatException e) {
                    zzbg.zzaK("illegal number in custom dimension value: " + str);
                }
            } else {
                Matcher matcher2 = zzblY.matcher(str);
                if (matcher2.matches()) {
                    try {
                        product.setCustomMetric(Integer.parseInt(matcher2.group(1)), zzW(map.get(str)).intValue());
                    } catch (NumberFormatException e2) {
                        zzbg.zzaK("illegal number in custom metric value: " + str);
                    }
                }
            }
        }
        return product;
    }

    private Map zzab(Map map) {
        zzag.zza zzaVar = (zzag.zza) map.get(zzblU);
        if (zzaVar != null) {
            return zzc(zzaVar);
        }
        if (zzblZ == null) {
            HashMap map2 = new HashMap();
            map2.put("transactionId", "&ti");
            map2.put("transactionAffiliation", "&ta");
            map2.put("transactionTax", "&tt");
            map2.put("transactionShipping", "&ts");
            map2.put("transactionTotal", "&tr");
            map2.put("transactionCurrency", "&cu");
            zzblZ = map2;
        }
        return zzblZ;
    }

    private Map zzac(Map map) {
        zzag.zza zzaVar = (zzag.zza) map.get(zzblV);
        if (zzaVar != null) {
            return zzc(zzaVar);
        }
        if (zzbma == null) {
            HashMap map2 = new HashMap();
            map2.put("name", "&in");
            map2.put("sku", "&ic");
            map2.put("category", "&iv");
            map2.put("price", "&ip");
            map2.put("quantity", "&iq");
            map2.put("currency", "&cu");
            zzbma = map2;
        }
        return zzbma;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void zzb(com.google.android.gms.analytics.Tracker r8, java.util.Map r9) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzdg.zzb(com.google.android.gms.analytics.Tracker, java.util.Map):void");
    }

    private Map zzc(zzag.zza zzaVar) {
        Object objZzl = zzdf.zzl(zzaVar);
        if (!(objZzl instanceof Map)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : ((Map) objZzl).entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private ProductAction zzd(String str, Map map) {
        ProductAction productAction = new ProductAction(str);
        Object obj = map.get("id");
        if (obj != null) {
            productAction.setTransactionId(String.valueOf(obj));
        }
        Object obj2 = map.get("affiliation");
        if (obj2 != null) {
            productAction.setTransactionAffiliation(String.valueOf(obj2));
        }
        Object obj3 = map.get("coupon");
        if (obj3 != null) {
            productAction.setTransactionCouponCode(String.valueOf(obj3));
        }
        Object obj4 = map.get("list");
        if (obj4 != null) {
            productAction.setProductActionList(String.valueOf(obj4));
        }
        Object obj5 = map.get("option");
        if (obj5 != null) {
            productAction.setCheckoutOptions(String.valueOf(obj5));
        }
        Object obj6 = map.get("revenue");
        if (obj6 != null) {
            productAction.setTransactionRevenue(zzV(obj6).doubleValue());
        }
        Object obj7 = map.get("tax");
        if (obj7 != null) {
            productAction.setTransactionTax(zzV(obj7).doubleValue());
        }
        Object obj8 = map.get("shipping");
        if (obj8 != null) {
            productAction.setTransactionShipping(zzV(obj8).doubleValue());
        }
        Object obj9 = map.get("step");
        if (obj9 != null) {
            productAction.setCheckoutStep(zzW(obj9).intValue());
        }
        return productAction;
    }

    private void zze(Map map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private String zzgy(String str) {
        Object obj = this.zzbhN.get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    private List zzgz(String str) {
        Object obj = this.zzbhN.get(str);
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof List)) {
            throw new IllegalArgumentException("transactionProducts should be of type List.");
        }
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            if (!(it.next() instanceof Map)) {
                throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
            }
        }
        return (List) obj;
    }

    private boolean zzj(Map map, String str) {
        zzag.zza zzaVar = (zzag.zza) map.get(str);
        if (zzaVar == null) {
            return false;
        }
        return zzdf.zzk(zzaVar).booleanValue();
    }

    private Map zzm(zzag.zza zzaVar) {
        Map mapZzc;
        if (zzaVar != null && (mapZzc = zzc(zzaVar)) != null) {
            String str = (String) mapZzc.get("&aip");
            if (str != null && this.zzbmb.contains(str.toLowerCase())) {
                mapZzc.remove("&aip");
            }
            return mapZzc;
        }
        return new HashMap();
    }

    @Override // com.google.android.gms.tagmanager.zzdd, com.google.android.gms.tagmanager.zzak
    public /* bridge */ /* synthetic */ boolean zzFW() {
        return super.zzFW();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public /* bridge */ /* synthetic */ String zzGB() {
        return super.zzGB();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public /* bridge */ /* synthetic */ Set zzGC() {
        return super.zzGC();
    }

    @Override // com.google.android.gms.tagmanager.zzdd, com.google.android.gms.tagmanager.zzak
    public /* bridge */ /* synthetic */ zzag.zza zzP(Map map) {
        return super.zzP(map);
    }

    @Override // com.google.android.gms.tagmanager.zzdd
    public void zzR(Map map) {
        Tracker trackerZzgq = this.zzbmc.zzgq("_GTM_DEFAULT_TRACKER_");
        trackerZzgq.enableAdvertisingIdCollection(zzj(map, "collect_adid"));
        if (zzj(map, zzblP)) {
            zzb(trackerZzgq, map);
            return;
        }
        if (zzj(map, zzblO)) {
            trackerZzgq.send(zzm((zzag.zza) map.get(zzblS)));
        } else if (zzj(map, zzblT)) {
            zza(trackerZzgq, map);
        } else {
            zzbg.zzaK("Ignoring unknown tag.");
        }
    }
}
