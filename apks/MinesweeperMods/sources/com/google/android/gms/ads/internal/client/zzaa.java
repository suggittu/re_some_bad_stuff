package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzhb;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzhb
/* loaded from: classes2.dex */
public final class zzaa {
    public static final String DEVICE_ID_EMULATOR = zzn.zzcS().zzaH("emulator");
    private final Date zzbf;
    private final Set zzbh;
    private final Location zzbj;
    private final boolean zzpE;
    private final int zztT;
    private final int zztW;
    private final String zztX;
    private final String zztZ;
    private final Bundle zzuA;
    private final Map zzuB;
    private final SearchAdRequest zzuC;
    private final Set zzuD;
    private final Set zzuE;
    private final Bundle zzub;
    private final String zzud;
    private final boolean zzuf;

    public final class zza {
        private Date zzbf;
        private Location zzbj;
        private String zztX;
        private String zztZ;
        private String zzud;
        private boolean zzuf;
        private final HashSet zzuF = new HashSet();
        private final Bundle zzuA = new Bundle();
        private final HashMap zzuG = new HashMap();
        private final HashSet zzuH = new HashSet();
        private final Bundle zzub = new Bundle();
        private final HashSet zzuI = new HashSet();
        private int zztT = -1;
        private boolean zzpE = false;
        private int zztW = -1;

        public final void setManualImpressionsEnabled(boolean z) {
            this.zzpE = z;
        }

        public final void zzA(String str) {
            this.zzuF.add(str);
        }

        public final void zzB(String str) {
            this.zzuH.add(str);
        }

        public final void zzC(String str) {
            this.zzuH.remove(str);
        }

        public final void zzD(String str) {
            this.zztZ = str;
        }

        public final void zzE(String str) {
            this.zztX = str;
        }

        public final void zzF(String str) {
            this.zzud = str;
        }

        public final void zzG(String str) {
            this.zzuI.add(str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Deprecated
        public final void zza(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.zzuG.put(networkExtras.getClass(), networkExtras);
            }
        }

        public final void zza(Class cls, Bundle bundle) {
            this.zzuA.putBundle(cls.getName(), bundle);
        }

        public final void zza(String str, String str2) {
            this.zzub.putString(str, str2);
        }

        public final void zza(Date date) {
            this.zzbf = date;
        }

        public final void zzb(Location location) {
            this.zzbj = location;
        }

        public final void zzb(Class cls, Bundle bundle) {
            if (this.zzuA.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
                this.zzuA.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
            }
            this.zzuA.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
        }

        public final void zzk(boolean z) {
            this.zztW = z ? 1 : 0;
        }

        public final void zzl(boolean z) {
            this.zzuf = z;
        }

        public final void zzn(int i) {
            this.zztT = i;
        }
    }

    public zzaa(zza zzaVar) {
        this(zzaVar, null);
    }

    public zzaa(zza zzaVar, SearchAdRequest searchAdRequest) {
        this.zzbf = zzaVar.zzbf;
        this.zztZ = zzaVar.zztZ;
        this.zztT = zzaVar.zztT;
        this.zzbh = Collections.unmodifiableSet(zzaVar.zzuF);
        this.zzbj = zzaVar.zzbj;
        this.zzpE = zzaVar.zzpE;
        this.zzuA = zzaVar.zzuA;
        this.zzuB = Collections.unmodifiableMap(zzaVar.zzuG);
        this.zztX = zzaVar.zztX;
        this.zzud = zzaVar.zzud;
        this.zzuC = searchAdRequest;
        this.zztW = zzaVar.zztW;
        this.zzuD = Collections.unmodifiableSet(zzaVar.zzuH);
        this.zzub = zzaVar.zzub;
        this.zzuE = Collections.unmodifiableSet(zzaVar.zzuI);
        this.zzuf = zzaVar.zzuf;
    }

    public final Date getBirthday() {
        return this.zzbf;
    }

    public final String getContentUrl() {
        return this.zztZ;
    }

    public final Bundle getCustomEventExtrasBundle(Class cls) {
        Bundle bundle = this.zzuA.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getClass().getName());
        }
        return null;
    }

    public final Bundle getCustomTargeting() {
        return this.zzub;
    }

    public final int getGender() {
        return this.zztT;
    }

    public final Set getKeywords() {
        return this.zzbh;
    }

    public final Location getLocation() {
        return this.zzbj;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzpE;
    }

    @Deprecated
    public final NetworkExtras getNetworkExtras(Class cls) {
        return (NetworkExtras) this.zzuB.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class cls) {
        return this.zzuA.getBundle(cls.getName());
    }

    public final String getPublisherProvidedId() {
        return this.zztX;
    }

    public final boolean isDesignedForFamilies() {
        return this.zzuf;
    }

    public final boolean isTestDevice(Context context) {
        return this.zzuD.contains(zzn.zzcS().zzT(context));
    }

    public final String zzcZ() {
        return this.zzud;
    }

    public final SearchAdRequest zzda() {
        return this.zzuC;
    }

    public final Map zzdb() {
        return this.zzuB;
    }

    public final Bundle zzdc() {
        return this.zzuA;
    }

    public final int zzdd() {
        return this.zztW;
    }

    public final Set zzde() {
        return this.zzuE;
    }
}
