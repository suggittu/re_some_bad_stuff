package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.tagmanager.zzcb;
import com.google.android.gms.tagmanager.zzt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class Container {
    private final Context mContext;
    private final String zzbhM;
    private final DataLayer zzbhN;
    private zzcp zzbhO;
    private volatile long zzbhR;
    private Map zzbhP = new HashMap();
    private Map zzbhQ = new HashMap();
    private volatile String zzbhS = "";

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map map);
    }

    class zza implements zzt.zza {
        private zza() {
        }

        @Override // com.google.android.gms.tagmanager.zzt.zza
        public Object zzc(String str, Map map) {
            FunctionCallMacroCallback functionCallMacroCallbackZzfP = Container.this.zzfP(str);
            if (functionCallMacroCallbackZzfP == null) {
                return null;
            }
            return functionCallMacroCallbackZzfP.getValue(str, map);
        }
    }

    class zzb implements zzt.zza {
        private zzb() {
        }

        @Override // com.google.android.gms.tagmanager.zzt.zza
        public Object zzc(String str, Map map) {
            FunctionCallTagCallback functionCallTagCallbackZzfQ = Container.this.zzfQ(str);
            if (functionCallTagCallbackZzfQ != null) {
                functionCallTagCallbackZzfQ.execute(str, map);
            }
            return zzdf.zzHE();
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzaf.zzj zzjVar) throws InterruptedException {
        this.mContext = context;
        this.zzbhN = dataLayer;
        this.zzbhM = str;
        this.zzbhR = j;
        zza(zzjVar.zzju);
        if (zzjVar.zzjt != null) {
            zza(zzjVar.zzjt);
        }
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzrs.zzc zzcVar) throws InterruptedException {
        this.mContext = context;
        this.zzbhN = dataLayer;
        this.zzbhM = str;
        this.zzbhR = j;
        zza(zzcVar);
    }

    private synchronized zzcp zzGc() {
        return this.zzbhO;
    }

    private void zza(zzaf.zzf zzfVar) throws InterruptedException {
        if (zzfVar == null) {
            throw new NullPointerException();
        }
        try {
            zza(zzrs.zzb(zzfVar));
        } catch (zzrs.zzg e) {
            zzbg.e("Not loading resource: " + zzfVar + " because it is invalid: " + e.toString());
        }
    }

    private void zza(zzrs.zzc zzcVar) throws InterruptedException {
        this.zzbhS = zzcVar.getVersion();
        zza(new zzcp(this.mContext, zzcVar, this.zzbhN, new zza(), new zzb(), zzfS(this.zzbhS)));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.zzbhN.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.zzbhM));
        }
    }

    private synchronized void zza(zzcp zzcpVar) {
        this.zzbhO = zzcpVar;
    }

    private void zza(zzaf.zzi[] zziVarArr) {
        ArrayList arrayList = new ArrayList();
        for (zzaf.zzi zziVar : zziVarArr) {
            arrayList.add(zziVar);
        }
        zzGc().zzF(arrayList);
    }

    public boolean getBoolean(String str) {
        zzcp zzcpVarZzGc = zzGc();
        if (zzcpVarZzGc == null) {
            zzbg.e("getBoolean called for closed container.");
            return zzdf.zzHC().booleanValue();
        }
        try {
            return zzdf.zzk((zzag.zza) zzcpVarZzGc.zzgn(str).getObject()).booleanValue();
        } catch (Exception e) {
            zzbg.e("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzHC().booleanValue();
        }
    }

    public String getContainerId() {
        return this.zzbhM;
    }

    public double getDouble(String str) {
        zzcp zzcpVarZzGc = zzGc();
        if (zzcpVarZzGc == null) {
            zzbg.e("getDouble called for closed container.");
            return zzdf.zzHB().doubleValue();
        }
        try {
            return zzdf.zzj((zzag.zza) zzcpVarZzGc.zzgn(str).getObject()).doubleValue();
        } catch (Exception e) {
            zzbg.e("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzHB().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.zzbhR;
    }

    public long getLong(String str) {
        zzcp zzcpVarZzGc = zzGc();
        if (zzcpVarZzGc == null) {
            zzbg.e("getLong called for closed container.");
            return zzdf.zzHA().longValue();
        }
        try {
            return zzdf.zzi((zzag.zza) zzcpVarZzGc.zzgn(str).getObject()).longValue();
        } catch (Exception e) {
            zzbg.e("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzHA().longValue();
        }
    }

    public String getString(String str) {
        zzcp zzcpVarZzGc = zzGc();
        if (zzcpVarZzGc == null) {
            zzbg.e("getString called for closed container.");
            return zzdf.zzHE();
        }
        try {
            return zzdf.zzg((zzag.zza) zzcpVarZzGc.zzgn(str).getObject());
        } catch (Exception e) {
            zzbg.e("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzHE();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.zzbhP) {
            this.zzbhP.put(str, functionCallMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.zzbhQ) {
            this.zzbhQ.put(str, functionCallTagCallback);
        }
    }

    void release() {
        this.zzbhO = null;
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.zzbhP) {
            this.zzbhP.remove(str);
        }
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.zzbhQ) {
            this.zzbhQ.remove(str);
        }
    }

    public String zzGb() {
        return this.zzbhS;
    }

    FunctionCallMacroCallback zzfP(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zzbhP) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.zzbhP.get(str);
        }
        return functionCallMacroCallback;
    }

    public FunctionCallTagCallback zzfQ(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzbhQ) {
            functionCallTagCallback = (FunctionCallTagCallback) this.zzbhQ.get(str);
        }
        return functionCallTagCallback;
    }

    public void zzfR(String str) {
        zzGc().zzfR(str);
    }

    zzah zzfS(String str) {
        zzcb.zzGU().zzGV().equals(zzcb.zza.CONTAINER_DEBUG);
        return new zzbo();
    }
}
