package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzam;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class HitBuilders {

    @Deprecated
    public class AppViewBuilder extends HitBuilder {
        public AppViewBuilder() {
            set("&t", "screenview");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public class EventBuilder extends HitBuilder {
        public EventBuilder() {
            set("&t", "event");
        }

        public EventBuilder(String str, String str2) {
            this();
            setCategory(str);
            setAction(str2);
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public EventBuilder setAction(String str) {
            set("&ea", str);
            return this;
        }

        public EventBuilder setCategory(String str) {
            set("&ec", str);
            return this;
        }

        public EventBuilder setLabel(String str) {
            set("&el", str);
            return this;
        }

        public EventBuilder setValue(long j) {
            set("&ev", Long.toString(j));
            return this;
        }
    }

    public class ExceptionBuilder extends HitBuilder {
        public ExceptionBuilder() {
            set("&t", "exception");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ExceptionBuilder setDescription(String str) {
            set("&exd", str);
            return this;
        }

        public ExceptionBuilder setFatal(boolean z) {
            set("&exf", zzam.zzK(z));
            return this;
        }
    }

    public class HitBuilder {
        ProductAction zzPn;
        private Map zzPm = new HashMap();
        Map zzPo = new HashMap();
        List zzPp = new ArrayList();
        List zzPq = new ArrayList();

        protected HitBuilder() {
        }

        public HitBuilder addImpression(Product product, String str) {
            if (product == null) {
                zzae.zzaK("product should be non-null");
            } else {
                if (str == null) {
                    str = "";
                }
                if (!this.zzPo.containsKey(str)) {
                    this.zzPo.put(str, new ArrayList());
                }
                ((List) this.zzPo.get(str)).add(product);
            }
            return this;
        }

        public HitBuilder addProduct(Product product) {
            if (product == null) {
                zzae.zzaK("product should be non-null");
            } else {
                this.zzPq.add(product);
            }
            return this;
        }

        public HitBuilder addPromotion(Promotion promotion) {
            if (promotion == null) {
                zzae.zzaK("promotion should be non-null");
            } else {
                this.zzPp.add(promotion);
            }
            return this;
        }

        public Map build() {
            HashMap map = new HashMap(this.zzPm);
            if (this.zzPn != null) {
                map.putAll(this.zzPn.build());
            }
            Iterator it = this.zzPp.iterator();
            int i = 1;
            while (it.hasNext()) {
                map.putAll(((Promotion) it.next()).zzba(zzc.zzZ(i)));
                i++;
            }
            Iterator it2 = this.zzPq.iterator();
            int i2 = 1;
            while (it2.hasNext()) {
                map.putAll(((Product) it2.next()).zzba(zzc.zzX(i2)));
                i2++;
            }
            int i3 = 1;
            for (Map.Entry entry : this.zzPo.entrySet()) {
                List list = (List) entry.getValue();
                String strZzac = zzc.zzac(i3);
                Iterator it3 = list.iterator();
                int i4 = 1;
                while (it3.hasNext()) {
                    map.putAll(((Product) it3.next()).zzba(strZzac + zzc.zzab(i4)));
                    i4++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    map.put(strZzac + "nm", entry.getKey());
                }
                i3++;
            }
            return map;
        }

        protected String get(String str) {
            return (String) this.zzPm.get(str);
        }

        public final HitBuilder set(String str, String str2) {
            if (str != null) {
                this.zzPm.put(str, str2);
            } else {
                zzae.zzaK(" HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final HitBuilder setAll(Map map) {
            if (map != null) {
                this.zzPm.putAll(new HashMap(map));
            }
            return this;
        }

        public HitBuilder setCampaignParamsFromUrl(String str) throws UnsupportedEncodingException {
            String strZzbu = zzam.zzbu(str);
            if (!TextUtils.isEmpty(strZzbu)) {
                Map mapZzbs = zzam.zzbs(strZzbu);
                set("&cc", (String) mapZzbs.get("utm_content"));
                set("&cm", (String) mapZzbs.get("utm_medium"));
                set("&cn", (String) mapZzbs.get("utm_campaign"));
                set("&cs", (String) mapZzbs.get("utm_source"));
                set("&ck", (String) mapZzbs.get("utm_term"));
                set("&ci", (String) mapZzbs.get("utm_id"));
                set("&anid", (String) mapZzbs.get("anid"));
                set("&gclid", (String) mapZzbs.get("gclid"));
                set("&dclid", (String) mapZzbs.get("dclid"));
                set("&aclid", (String) mapZzbs.get("aclid"));
                set("&gmob_t", (String) mapZzbs.get("gmob_t"));
            }
            return this;
        }

        public HitBuilder setCustomDimension(int i, String str) {
            set(zzc.zzT(i), str);
            return this;
        }

        public HitBuilder setCustomMetric(int i, float f) {
            set(zzc.zzV(i), Float.toString(f));
            return this;
        }

        protected HitBuilder setHitType(String str) {
            set("&t", str);
            return this;
        }

        public HitBuilder setNewSession() {
            set("&sc", "start");
            return this;
        }

        public HitBuilder setNonInteraction(boolean z) {
            set("&ni", zzam.zzK(z));
            return this;
        }

        public HitBuilder setProductAction(ProductAction productAction) {
            this.zzPn = productAction;
            return this;
        }

        public HitBuilder setPromotionAction(String str) {
            this.zzPm.put("&promoa", str);
            return this;
        }
    }

    @Deprecated
    public class ItemBuilder extends HitBuilder {
        public ItemBuilder() {
            set("&t", "item");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ItemBuilder setCategory(String str) {
            set("&iv", str);
            return this;
        }

        public ItemBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public ItemBuilder setName(String str) {
            set("&in", str);
            return this;
        }

        public ItemBuilder setPrice(double d) {
            set("&ip", Double.toString(d));
            return this;
        }

        public ItemBuilder setQuantity(long j) {
            set("&iq", Long.toString(j));
            return this;
        }

        public ItemBuilder setSku(String str) {
            set("&ic", str);
            return this;
        }

        public ItemBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }

    public class ScreenViewBuilder extends HitBuilder {
        public ScreenViewBuilder() {
            set("&t", "screenview");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public class SocialBuilder extends HitBuilder {
        public SocialBuilder() {
            set("&t", "social");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public SocialBuilder setAction(String str) {
            set("&sa", str);
            return this;
        }

        public SocialBuilder setNetwork(String str) {
            set("&sn", str);
            return this;
        }

        public SocialBuilder setTarget(String str) {
            set("&st", str);
            return this;
        }
    }

    public class TimingBuilder extends HitBuilder {
        public TimingBuilder() {
            set("&t", "timing");
        }

        public TimingBuilder(String str, String str2, long j) {
            this();
            setVariable(str2);
            setValue(j);
            setCategory(str);
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TimingBuilder setCategory(String str) {
            set("&utc", str);
            return this;
        }

        public TimingBuilder setLabel(String str) {
            set("&utl", str);
            return this;
        }

        public TimingBuilder setValue(long j) {
            set("&utt", Long.toString(j));
            return this;
        }

        public TimingBuilder setVariable(String str) {
            set("&utv", str);
            return this;
        }
    }

    @Deprecated
    public class TransactionBuilder extends HitBuilder {
        public TransactionBuilder() {
            set("&t", "transaction");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TransactionBuilder setAffiliation(String str) {
            set("&ta", str);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public TransactionBuilder setRevenue(double d) {
            set("&tr", Double.toString(d));
            return this;
        }

        public TransactionBuilder setShipping(double d) {
            set("&ts", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTax(double d) {
            set("&tt", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }
}
