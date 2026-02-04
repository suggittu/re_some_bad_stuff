package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.zzex;
import java.util.Map;

@zzhb
/* loaded from: classes2.dex */
public final class zzew extends zzex.zza {
    private Map zzCG;

    private zzey zzah(String str) {
        try {
            Class<?> cls = Class.forName(str, false, zzew.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.newInstance();
                return new zzfj(mediationAdapter, (NetworkExtras) this.zzCG.get(mediationAdapter.getAdditionalParametersType()));
            }
            if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                return new zzfe((com.google.android.gms.ads.mediation.MediationAdapter) cls.newInstance());
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
            throw new RemoteException();
        } catch (Throwable th) {
            return zzai(str);
        }
    }

    private zzey zzai(String str) throws RemoteException {
        try {
            com.google.android.gms.ads.internal.util.client.zzb.zzaI("Reflection failed, retrying using direct instantiation");
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not instantiate mediation adapter: " + str + ". ", th);
        }
        if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
            return new zzfe(new AdMobAdapter());
        }
        if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
            return new zzfe(new AdUrlAdapter());
        }
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            return new zzfe(new CustomEventAdapter());
        }
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            com.google.ads.mediation.customevent.CustomEventAdapter customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
            return new zzfj(customEventAdapter, (CustomEventExtras) this.zzCG.get(customEventAdapter.getAdditionalParametersType()));
        }
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.zzex
    public final zzey zzaf(String str) {
        return zzah(str);
    }

    @Override // com.google.android.gms.internal.zzex
    public final boolean zzag(String str) {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzew.class.getClassLoader()));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaK("Could not load custom event implementation class: " + str + ", assuming old implementation.");
            return false;
        }
    }

    public final void zzg(Map map) {
        this.zzCG = map;
    }
}
