package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzl;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.signin.internal.SignInResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
public class zzh implements zzk {
    private final Context mContext;
    private final Lock zzXG;
    private final com.google.android.gms.common.zzc zzags;
    private final Api.zza zzagt;
    private final Map zzahA;
    private final zzl zzahj;
    private ConnectionResult zzahm;
    private int zzahn;
    private int zzahp;
    private zzrn zzahs;
    private int zzaht;
    private boolean zzahu;
    private boolean zzahv;
    private com.google.android.gms.common.internal.zzp zzahw;
    private boolean zzahx;
    private boolean zzahy;
    private final com.google.android.gms.common.internal.zzf zzahz;
    private int zzaho = 0;
    private final Bundle zzahq = new Bundle();
    private final Set zzahr = new HashSet();
    private ArrayList zzahB = new ArrayList();

    class zza implements GoogleApiClient.zza {
        private final Api zzagT;
        private final int zzagU;
        private final WeakReference zzahD;

        public zza(zzh zzhVar, Api api, int i) {
            this.zzahD = new WeakReference(zzhVar);
            this.zzagT = api;
            this.zzagU = i;
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.zza
        public void zza(@NonNull ConnectionResult connectionResult) {
            zzh zzhVar = (zzh) this.zzahD.get();
            if (zzhVar == null) {
                return;
            }
            com.google.android.gms.common.internal.zzx.zza(Looper.myLooper() == zzhVar.zzahj.zzagW.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zzhVar.zzXG.lock();
            try {
                if (zzhVar.zzbz(0)) {
                    if (!connectionResult.isSuccess()) {
                        zzhVar.zzb(connectionResult, this.zzagT, this.zzagU);
                    }
                    if (zzhVar.zzpu()) {
                        zzhVar.zzpv();
                    }
                }
            } finally {
                zzhVar.zzXG.unlock();
            }
        }
    }

    class zzb extends zzf {
        private final Map zzahE;

        public zzb(Map map) {
            super();
            this.zzahE = map;
        }

        @Override // com.google.android.gms.common.api.internal.zzh.zzf
        @WorkerThread
        public void zzpt() {
            int iIsGooglePlayServicesAvailable = zzh.this.zzags.isGooglePlayServicesAvailable(zzh.this.mContext);
            if (iIsGooglePlayServicesAvailable != 0) {
                final ConnectionResult connectionResult = new ConnectionResult(iIsGooglePlayServicesAvailable, null);
                zzh.this.zzahj.zza(new zzl.zza(zzh.this) { // from class: com.google.android.gms.common.api.internal.zzh.zzb.1
                    @Override // com.google.android.gms.common.api.internal.zzl.zza
                    public void zzpt() {
                        zzh.this.zzg(connectionResult);
                    }
                });
                return;
            }
            if (zzh.this.zzahu) {
                zzh.this.zzahs.connect();
            }
            for (Api.zzb zzbVar : this.zzahE.keySet()) {
                zzbVar.zza((GoogleApiClient.zza) this.zzahE.get(zzbVar));
            }
        }
    }

    class zzc extends zzf {
        private final ArrayList zzahH;

        public zzc(ArrayList arrayList) {
            super();
            this.zzahH = arrayList;
        }

        @Override // com.google.android.gms.common.api.internal.zzh.zzf
        @WorkerThread
        public void zzpt() {
            zzh.this.zzahj.zzagW.zzahU = zzh.this.zzpA();
            Iterator it = this.zzahH.iterator();
            while (it.hasNext()) {
                ((Api.zzb) it.next()).zza(zzh.this.zzahw, zzh.this.zzahj.zzagW.zzahU);
            }
        }
    }

    class zzd extends com.google.android.gms.signin.internal.zzb {
        private final WeakReference zzahD;

        zzd(zzh zzhVar) {
            this.zzahD = new WeakReference(zzhVar);
        }

        @Override // com.google.android.gms.signin.internal.zzb, com.google.android.gms.signin.internal.zzd
        @BinderThread
        public void zzb(final SignInResponse signInResponse) {
            final zzh zzhVar = (zzh) this.zzahD.get();
            if (zzhVar == null) {
                return;
            }
            zzhVar.zzahj.zza(new zzl.zza(zzhVar) { // from class: com.google.android.gms.common.api.internal.zzh.zzd.1
                @Override // com.google.android.gms.common.api.internal.zzl.zza
                public void zzpt() {
                    zzhVar.zza(signInResponse);
                }
            });
        }
    }

    class zze implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private zze() {
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnected(Bundle bundle) {
            zzh.this.zzahs.zza(new zzd(zzh.this));
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzh.this.zzXG.lock();
            try {
                if (zzh.this.zzf(connectionResult)) {
                    zzh.this.zzpy();
                    zzh.this.zzpv();
                } else {
                    zzh.this.zzg(connectionResult);
                }
            } finally {
                zzh.this.zzXG.unlock();
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnectionSuspended(int i) {
        }
    }

    abstract class zzf implements Runnable {
        private zzf() {
        }

        @Override // java.lang.Runnable
        @WorkerThread
        public void run() {
            zzh.this.zzXG.lock();
            try {
                if (Thread.interrupted()) {
                    return;
                }
                zzpt();
            } catch (RuntimeException e) {
                zzh.this.zzahj.zza(e);
            } finally {
                zzh.this.zzXG.unlock();
            }
        }

        @WorkerThread
        protected abstract void zzpt();
    }

    public zzh(zzl zzlVar, com.google.android.gms.common.internal.zzf zzfVar, Map map, com.google.android.gms.common.zzc zzcVar, Api.zza zzaVar, Lock lock, Context context) {
        this.zzahj = zzlVar;
        this.zzahz = zzfVar;
        this.zzahA = map;
        this.zzags = zzcVar;
        this.zzagt = zzaVar;
        this.zzXG = lock;
        this.mContext = context;
    }

    private void zzZ(boolean z) {
        if (this.zzahs != null) {
            if (this.zzahs.isConnected() && z) {
                this.zzahs.zzFG();
            }
            this.zzahs.disconnect();
            this.zzahw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(SignInResponse signInResponse) {
        if (zzbz(0)) {
            ConnectionResult connectionResultZzqY = signInResponse.zzqY();
            if (!connectionResultZzqY.isSuccess()) {
                if (!zzf(connectionResultZzqY)) {
                    zzg(connectionResultZzqY);
                    return;
                } else {
                    zzpy();
                    zzpv();
                    return;
                }
            }
            ResolveAccountResponse resolveAccountResponseZzFP = signInResponse.zzFP();
            ConnectionResult connectionResultZzqY2 = resolveAccountResponseZzFP.zzqY();
            if (!connectionResultZzqY2.isSuccess()) {
                Log.wtf("GoogleApiClientConnecting", "Sign-in succeeded with resolve account failure: " + connectionResultZzqY2, new Exception());
                zzg(connectionResultZzqY2);
                return;
            }
            this.zzahv = true;
            this.zzahw = resolveAccountResponseZzFP.zzqX();
            this.zzahx = resolveAccountResponseZzFP.zzqZ();
            this.zzahy = resolveAccountResponseZzFP.zzra();
            zzpv();
        }
    }

    private boolean zza(int i, int i2, ConnectionResult connectionResult) {
        if (i2 != 1 || zze(connectionResult)) {
            return this.zzahm == null || i < this.zzahn;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(ConnectionResult connectionResult, Api api, int i) {
        if (i != 2) {
            int priority = api.zzoP().getPriority();
            if (zza(priority, i, connectionResult)) {
                this.zzahm = connectionResult;
                this.zzahn = priority;
            }
        }
        this.zzahj.zzaio.put(api.zzoR(), connectionResult);
    }

    private String zzbA(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzbz(int i) {
        if (this.zzaho == i) {
            return true;
        }
        Log.i("GoogleApiClientConnecting", this.zzahj.zzagW.zzpH());
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + zzbA(this.zzaho) + " but received callback for step " + zzbA(i), new Exception());
        zzg(new ConnectionResult(8, null));
        return false;
    }

    private boolean zze(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.zzags.zzbu(connectionResult.getErrorCode()) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzf(ConnectionResult connectionResult) {
        if (this.zzaht != 2) {
            return this.zzaht == 1 && !connectionResult.hasResolution();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzg(ConnectionResult connectionResult) {
        zzpz();
        zzZ(!connectionResult.hasResolution());
        this.zzahj.zzh(connectionResult);
        this.zzahj.zzais.zzd(connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set zzpA() {
        if (this.zzahz == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.zzahz.zzqs());
        Map mapZzqu = this.zzahz.zzqu();
        for (Api api : mapZzqu.keySet()) {
            if (!this.zzahj.zzaio.containsKey(api.zzoR())) {
                hashSet.addAll(((zzf.zza) mapZzqu.get(api)).zzXf);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzpu() {
        this.zzahp--;
        if (this.zzahp > 0) {
            return false;
        }
        if (this.zzahp < 0) {
            Log.i("GoogleApiClientConnecting", this.zzahj.zzagW.zzpH());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zzg(new ConnectionResult(8, null));
            return false;
        }
        if (this.zzahm == null) {
            return true;
        }
        this.zzahj.zzair = this.zzahn;
        zzg(this.zzahm);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzpv() {
        if (this.zzahp != 0) {
            return;
        }
        if (!this.zzahu || this.zzahv) {
            zzpw();
        }
    }

    private void zzpw() {
        ArrayList arrayList = new ArrayList();
        this.zzaho = 1;
        this.zzahp = this.zzahj.zzahT.size();
        for (Api.zzc zzcVar : this.zzahj.zzahT.keySet()) {
            if (!this.zzahj.zzaio.containsKey(zzcVar)) {
                arrayList.add(this.zzahj.zzahT.get(zzcVar));
            } else if (zzpu()) {
                zzpx();
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.zzahB.add(zzm.zzpN().submit(new zzc(arrayList)));
    }

    private void zzpx() {
        this.zzahj.zzpL();
        zzm.zzpN().execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.zzh.1
            @Override // java.lang.Runnable
            public void run() {
                zzh.this.zzags.zzal(zzh.this.mContext);
            }
        });
        if (this.zzahs != null) {
            if (this.zzahx) {
                this.zzahs.zza(this.zzahw, this.zzahy);
            }
            zzZ(false);
        }
        Iterator it = this.zzahj.zzaio.keySet().iterator();
        while (it.hasNext()) {
            ((Api.zzb) this.zzahj.zzahT.get((Api.zzc) it.next())).disconnect();
        }
        this.zzahj.zzais.zzi(this.zzahq.isEmpty() ? null : this.zzahq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzpy() {
        this.zzahu = false;
        this.zzahj.zzagW.zzahU = Collections.emptySet();
        for (Api.zzc zzcVar : this.zzahr) {
            if (!this.zzahj.zzaio.containsKey(zzcVar)) {
                this.zzahj.zzaio.put(zzcVar, new ConnectionResult(17, null));
            }
        }
    }

    private void zzpz() {
        Iterator it = this.zzahB.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.zzahB.clear();
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void begin() {
        this.zzahj.zzaio.clear();
        this.zzahu = false;
        this.zzahm = null;
        this.zzaho = 0;
        this.zzaht = 2;
        this.zzahv = false;
        this.zzahx = false;
        HashMap map = new HashMap();
        boolean z = false;
        for (Api api : this.zzahA.keySet()) {
            Api.zzb zzbVar = (Api.zzb) this.zzahj.zzahT.get(api.zzoR());
            int iIntValue = ((Integer) this.zzahA.get(api)).intValue();
            boolean z2 = (api.zzoP().getPriority() == 1) | z;
            if (zzbVar.zzmE()) {
                this.zzahu = true;
                if (iIntValue < this.zzaht) {
                    this.zzaht = iIntValue;
                }
                if (iIntValue != 0) {
                    this.zzahr.add(api.zzoR());
                }
            }
            map.put(zzbVar, new zza(this, api, iIntValue));
            z = z2;
        }
        if (z) {
            this.zzahu = false;
        }
        if (this.zzahu) {
            this.zzahz.zza(Integer.valueOf(this.zzahj.zzagW.getSessionId()));
            zze zzeVar = new zze();
            this.zzahs = (zzrn) this.zzagt.zza(this.mContext, this.zzahj.zzagW.getLooper(), this.zzahz, this.zzahz.zzqy(), zzeVar, zzeVar);
        }
        this.zzahp = this.zzahj.zzahT.size();
        this.zzahB.add(zzm.zzpN().submit(new zzb(map)));
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void connect() {
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public boolean disconnect() {
        zzpz();
        zzZ(true);
        this.zzahj.zzh(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void onConnected(Bundle bundle) {
        if (zzbz(1)) {
            if (bundle != null) {
                this.zzahq.putAll(bundle);
            }
            if (zzpu()) {
                zzpx();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void onConnectionSuspended(int i) {
        zzg(new ConnectionResult(8, null));
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public zza.AbstractC0036zza zza(zza.AbstractC0036zza abstractC0036zza) {
        this.zzahj.zzagW.zzahN.add(abstractC0036zza);
        return abstractC0036zza;
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void zza(ConnectionResult connectionResult, Api api, int i) {
        if (zzbz(1)) {
            zzb(connectionResult, api, i);
            if (zzpu()) {
                zzpx();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public zza.AbstractC0036zza zzb(zza.AbstractC0036zza abstractC0036zza) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
