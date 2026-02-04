package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzp;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzmf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
public final class zzj extends GoogleApiClient implements zzp.zza {
    private final Context mContext;
    private final Lock zzXG;
    private final int zzagp;
    private final Looper zzagr;
    private final com.google.android.gms.common.zzc zzags;
    final Api.zza zzagt;
    final Map zzahA;
    private final com.google.android.gms.common.internal.zzk zzahL;
    private volatile boolean zzahO;
    private final zza zzahR;
    zzc zzahS;
    final Map zzahT;
    private com.google.android.gms.common.api.zza zzahX;
    private final ArrayList zzahY;
    private Integer zzahZ;
    final com.google.android.gms.common.internal.zzf zzahz;
    private zzp zzahM = null;
    final Queue zzahN = new LinkedList();
    private long zzahP = 120000;
    private long zzahQ = 5000;
    Set zzahU = new HashSet();
    private final Set zzahV = Collections.newSetFromMap(new WeakHashMap());
    final Set zzahW = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    Set zzaia = null;
    private final zzd zzaib = new zzd() { // from class: com.google.android.gms.common.api.internal.zzj.1
        @Override // com.google.android.gms.common.api.internal.zzj.zzd
        public void zzc(zze zzeVar) {
            zzj.this.zzahW.remove(zzeVar);
            if (zzeVar.zzpa() == null || zzj.this.zzahX == null) {
                return;
            }
            zzj.this.zzahX.remove(zzeVar.zzpa().intValue());
        }
    };
    private final zzk.zza zzaic = new zzk.zza() { // from class: com.google.android.gms.common.api.internal.zzj.2
        @Override // com.google.android.gms.common.internal.zzk.zza
        public boolean isConnected() {
            return zzj.this.isConnected();
        }

        @Override // com.google.android.gms.common.internal.zzk.zza
        public Bundle zzoi() {
            return null;
        }
    };

    final class zza extends Handler {
        zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    zzj.this.zzpD();
                    break;
                case 2:
                    zzj.this.resume();
                    break;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                    break;
            }
        }
    }

    class zzb implements IBinder.DeathRecipient, zzd {
        private final WeakReference zzaii;
        private final WeakReference zzaij;
        private final WeakReference zzaik;

        private zzb(zze zzeVar, com.google.android.gms.common.api.zza zzaVar, IBinder iBinder) {
            this.zzaij = new WeakReference(zzaVar);
            this.zzaii = new WeakReference(zzeVar);
            this.zzaik = new WeakReference(iBinder);
        }

        private void zzpI() {
            zze zzeVar = (zze) this.zzaii.get();
            com.google.android.gms.common.api.zza zzaVar = (com.google.android.gms.common.api.zza) this.zzaij.get();
            if (zzaVar != null && zzeVar != null) {
                zzaVar.remove(zzeVar.zzpa().intValue());
            }
            IBinder iBinder = (IBinder) this.zzaik.get();
            if (this.zzaik != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            zzpI();
        }

        @Override // com.google.android.gms.common.api.internal.zzj.zzd
        public void zzc(zze zzeVar) {
            zzpI();
        }
    }

    class zzc extends zzn {
        private WeakReference zzail;

        zzc(zzj zzjVar) {
            this.zzail = new WeakReference(zzjVar);
        }

        @Override // com.google.android.gms.common.api.internal.zzn
        public void zzpJ() {
            zzj zzjVar = (zzj) this.zzail.get();
            if (zzjVar == null) {
                return;
            }
            zzjVar.resume();
        }
    }

    interface zzd {
        void zzc(zze zzeVar);
    }

    interface zze {
        void cancel();

        boolean isReady();

        void zza(zzd zzdVar);

        void zzb(Api.zzb zzbVar);

        Api.zzc zzoR();

        Integer zzpa();

        void zzpe();

        void zzpg();

        void zzw(Status status);

        void zzx(Status status);
    }

    public zzj(Context context, Lock lock, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, com.google.android.gms.common.zzc zzcVar, Api.zza zzaVar, Map map, List list, List list2, Map map2, int i, int i2, ArrayList arrayList) {
        this.zzahZ = null;
        this.mContext = context;
        this.zzXG = lock;
        this.zzahL = new com.google.android.gms.common.internal.zzk(looper, this.zzaic);
        this.zzagr = looper;
        this.zzahR = new zza(looper);
        this.zzags = zzcVar;
        this.zzagp = i;
        if (this.zzagp >= 0) {
            this.zzahZ = Integer.valueOf(i2);
        }
        this.zzahA = map;
        this.zzahT = map2;
        this.zzahY = arrayList;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.zzahL.registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) it.next());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.zzahL.registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) it2.next());
        }
        this.zzahz = zzfVar;
        this.zzagt = zzaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resume() {
        this.zzXG.lock();
        try {
            if (zzpB()) {
                zzpC();
            }
        } finally {
            this.zzXG.unlock();
        }
    }

    public static int zza(Iterable iterable, boolean z) {
        Iterator it = iterable.iterator();
        boolean z2 = false;
        boolean z3 = false;
        while (it.hasNext()) {
            Api.zzb zzbVar = (Api.zzb) it.next();
            if (zzbVar.zzmE()) {
                z3 = true;
            }
            z2 = zzbVar.zznb() ? true : z2;
        }
        if (z3) {
            return (z2 && z) ? 2 : 1;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(final GoogleApiClient googleApiClient, final zzv zzvVar, final boolean z) {
        zzmf.zzamA.zzf(googleApiClient).setResultCallback(new ResultCallback() { // from class: com.google.android.gms.common.api.internal.zzj.5
            @Override // com.google.android.gms.common.api.ResultCallback
            /* renamed from: zzp, reason: merged with bridge method [inline-methods] */
            public void onResult(@NonNull Status status) {
                com.google.android.gms.auth.api.signin.internal.zzq.zzaf(zzj.this.mContext).zznr();
                if (status.isSuccess() && zzj.this.isConnected()) {
                    zzj.this.reconnect();
                }
                zzvVar.zza(status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    private static void zza(zze zzeVar, com.google.android.gms.common.api.zza zzaVar, IBinder iBinder) throws RemoteException {
        if (zzeVar.isReady()) {
            zzeVar.zza(new zzb(zzeVar, zzaVar, iBinder));
            return;
        }
        if (iBinder == null || !iBinder.isBinderAlive()) {
            zzeVar.zza(null);
            zzeVar.cancel();
            zzaVar.remove(zzeVar.zzpa().intValue());
        } else {
            zzb zzbVar = new zzb(zzeVar, zzaVar, iBinder);
            zzeVar.zza(zzbVar);
            try {
                iBinder.linkToDeath(zzbVar, 0);
            } catch (RemoteException e) {
                zzeVar.cancel();
                zzaVar.remove(zzeVar.zzpa().intValue());
            }
        }
    }

    private void zzbB(int i) {
        if (this.zzahZ == null) {
            this.zzahZ = Integer.valueOf(i);
        } else if (this.zzahZ.intValue() != i) {
            throw new IllegalStateException("Cannot use sign-in mode: " + zzbC(i) + ". Mode was already set to " + zzbC(this.zzahZ.intValue()));
        }
        if (this.zzahM != null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (Api.zzb zzbVar : this.zzahT.values()) {
            if (zzbVar.zzmE()) {
                z2 = true;
            }
            z = zzbVar.zznb() ? true : z;
        }
        switch (this.zzahZ.intValue()) {
            case 1:
                if (!z2) {
                    throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                }
                if (z) {
                    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
                break;
            case 2:
                if (z2) {
                    this.zzahM = new com.google.android.gms.common.api.internal.zzd(this.mContext, this, this.zzXG, this.zzagr, this.zzags, this.zzahT, this.zzahz, this.zzahA, this.zzagt, this.zzahY);
                    return;
                }
                break;
        }
        this.zzahM = new zzl(this.mContext, this, this.zzXG, this.zzagr, this.zzags, this.zzahT, this.zzahz, this.zzahA, this.zzagt, this.zzahY, this);
    }

    static String zzbC(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void zzpC() {
        this.zzahL.zzqR();
        this.zzahM.connect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzpD() {
        this.zzXG.lock();
        try {
            if (zzpF()) {
                zzpC();
            }
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect() {
        com.google.android.gms.common.internal.zzx.zza(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zzXG.lock();
        try {
            if (this.zzagp >= 0) {
                com.google.android.gms.common.internal.zzx.zza(this.zzahZ != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzahZ == null) {
                this.zzahZ = Integer.valueOf(zza(this.zzahT.values(), false));
            } else if (this.zzahZ.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbB(this.zzahZ.intValue());
            this.zzahL.zzqR();
            return this.zzahM.blockingConnect();
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        com.google.android.gms.common.internal.zzx.zza(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        com.google.android.gms.common.internal.zzx.zzb(timeUnit, "TimeUnit must not be null");
        this.zzXG.lock();
        try {
            if (this.zzahZ == null) {
                this.zzahZ = Integer.valueOf(zza(this.zzahT.values(), false));
            } else if (this.zzahZ.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbB(this.zzahZ.intValue());
            this.zzahL.zzqR();
            return this.zzahM.blockingConnect(j, timeUnit);
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final PendingResult clearDefaultAccountAndReconnect() {
        com.google.android.gms.common.internal.zzx.zza(isConnected(), "GoogleApiClient is not connected yet.");
        com.google.android.gms.common.internal.zzx.zza(this.zzahZ.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        final zzv zzvVar = new zzv(this);
        if (this.zzahT.containsKey(zzmf.zzUI)) {
            zza((GoogleApiClient) this, zzvVar, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient googleApiClientBuild = new GoogleApiClient.Builder(this.mContext).addApi(zzmf.API).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() { // from class: com.google.android.gms.common.api.internal.zzj.3
                @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
                public void onConnected(Bundle bundle) {
                    zzj.this.zza((GoogleApiClient) atomicReference.get(), zzvVar, true);
                }

                @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
                public void onConnectionSuspended(int i) {
                }
            }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() { // from class: com.google.android.gms.common.api.internal.zzj.4
                @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
                public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                    zzvVar.zza(new Status(8));
                }
            }).setHandler(this.zzahR).build();
            atomicReference.set(googleApiClientBuild);
            googleApiClientBuild.connect();
        }
        return zzvVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect() {
        this.zzXG.lock();
        try {
            if (this.zzagp >= 0) {
                com.google.android.gms.common.internal.zzx.zza(this.zzahZ != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzahZ == null) {
                this.zzahZ = Integer.valueOf(zza(this.zzahT.values(), false));
            } else if (this.zzahZ.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.zzahZ.intValue());
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void connect(int i) {
        boolean z = true;
        this.zzXG.lock();
        if (i != 3 && i != 1 && i != 2) {
            z = false;
        }
        try {
            com.google.android.gms.common.internal.zzx.zzb(z, "Illegal sign-in mode: " + i);
            zzbB(i);
            zzpC();
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void disconnect() {
        this.zzXG.lock();
        try {
            zzaa((this.zzahM == null || this.zzahM.disconnect()) ? false : true);
            Iterator it = this.zzahV.iterator();
            while (it.hasNext()) {
                ((zzq) it.next()).clear();
            }
            this.zzahV.clear();
            for (zze zzeVar : this.zzahN) {
                zzeVar.zza(null);
                zzeVar.cancel();
            }
            this.zzahN.clear();
            if (this.zzahM == null) {
                return;
            }
            zzpF();
            this.zzahL.zzqQ();
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.mContext);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.zzahO);
        printWriter.append(" mWorkQueue.size()=").print(this.zzahN.size());
        printWriter.append(" mUnconsumedRunners.size()=").println(this.zzahW.size());
        if (this.zzahM != null) {
            this.zzahM.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @NonNull
    public final ConnectionResult getConnectionResult(@NonNull Api api) {
        this.zzXG.lock();
        try {
            if (!isConnected() && !zzpB()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (!this.zzahT.containsKey(api.zzoR())) {
                throw new IllegalArgumentException(api.getName() + " was never registered with GoogleApiClient");
            }
            ConnectionResult connectionResult = this.zzahM.getConnectionResult(api);
            if (connectionResult == null) {
                if (zzpB()) {
                    connectionResult = ConnectionResult.zzafB;
                } else {
                    Log.i("GoogleApiClientImpl", zzpH());
                    Log.wtf("GoogleApiClientImpl", api.getName() + " requested in getConnectionResult is not connected but is not present in the failed  connections map", new Exception());
                    connectionResult = new ConnectionResult(8, null);
                }
            }
            return connectionResult;
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context getContext() {
        return this.mContext;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper getLooper() {
        return this.zzagr;
    }

    public final int getSessionId() {
        return System.identityHashCode(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean hasConnectedApi(@NonNull Api api) {
        Api.zzb zzbVar = (Api.zzb) this.zzahT.get(api.zzoR());
        return zzbVar != null && zzbVar.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnected() {
        return this.zzahM != null && this.zzahM.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnecting() {
        return this.zzahM != null && this.zzahM.isConnecting();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.zzahL.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zzahL.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zzahL.registerConnectionCallbacks(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzahL.registerConnectionFailedListener(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void stopAutoManage(@NonNull final FragmentActivity fragmentActivity) {
        if (this.zzagp < 0) {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
        zzw zzwVarZza = zzw.zza(fragmentActivity);
        if (zzwVarZza == null) {
            new Handler(this.mContext.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.common.api.internal.zzj.6
                @Override // java.lang.Runnable
                public void run() {
                    if (fragmentActivity.isFinishing() || fragmentActivity.getSupportFragmentManager().isDestroyed()) {
                        return;
                    }
                    zzw.zzb(fragmentActivity).zzbD(zzj.this.zzagp);
                }
            });
        } else {
            zzwVarZza.zzbD(this.zzagp);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zzahL.unregisterConnectionCallbacks(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzahL.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @NonNull
    public final Api.zzb zza(@NonNull Api.zzc zzcVar) {
        Api.zzb zzbVar = (Api.zzb) this.zzahT.get(zzcVar);
        com.google.android.gms.common.internal.zzx.zzb(zzbVar, "Appropriate Api was not requested.");
        return zzbVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final zza.AbstractC0036zza zza(@NonNull zza.AbstractC0036zza abstractC0036zza) {
        com.google.android.gms.common.internal.zzx.zzb(abstractC0036zza.zzoR() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        com.google.android.gms.common.internal.zzx.zzb(this.zzahT.containsKey(abstractC0036zza.zzoR()), "GoogleApiClient is not configured to use the API required for this call.");
        this.zzXG.lock();
        try {
            if (this.zzahM == null) {
                this.zzahN.add(abstractC0036zza);
            } else {
                abstractC0036zza = this.zzahM.zza(abstractC0036zza);
            }
            return abstractC0036zza;
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zza(zzx zzxVar) {
        this.zzXG.lock();
        try {
            if (this.zzaia == null) {
                this.zzaia = new HashSet();
            }
            this.zzaia.add(zzxVar);
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean zza(@NonNull Api api) {
        return this.zzahT.containsKey(api.zzoR());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean zza(zzu zzuVar) {
        return this.zzahM != null && this.zzahM.zza(zzuVar);
    }

    final void zzaa(boolean z) throws RemoteException {
        for (zze zzeVar : this.zzahW) {
            if (zzeVar.zzpa() != null) {
                zzeVar.zzpe();
                zza(zzeVar, this.zzahX, zza(zzeVar.zzoR()).zzoT());
                this.zzahW.remove(zzeVar);
            } else if (z) {
                zzeVar.zzpg();
            } else {
                zzeVar.cancel();
                this.zzahW.remove(zzeVar);
            }
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final zza.AbstractC0036zza zzb(@NonNull zza.AbstractC0036zza abstractC0036zza) {
        com.google.android.gms.common.internal.zzx.zzb(abstractC0036zza.zzoR() != null, "This task can not be executed (it's probably a Batch or malformed)");
        this.zzXG.lock();
        try {
            if (this.zzahM == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (zzpB()) {
                this.zzahN.add(abstractC0036zza);
                while (!this.zzahN.isEmpty()) {
                    zze zzeVar = (zze) this.zzahN.remove();
                    zzb(zzeVar);
                    zzeVar.zzw(Status.zzagE);
                }
            } else {
                abstractC0036zza = this.zzahM.zzb(abstractC0036zza);
            }
            return abstractC0036zza;
        } finally {
            this.zzXG.unlock();
        }
    }

    final void zzb(zze zzeVar) {
        this.zzahW.add(zzeVar);
        zzeVar.zza(this.zzaib);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zzb(zzx zzxVar) {
        this.zzXG.lock();
        try {
            if (this.zzaia == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.zzaia.remove(zzxVar)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!zzpG()) {
                this.zzahM.zzpj();
            }
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzp.zza
    public final void zzc(int i, boolean z) {
        if (i == 1 && !z) {
            zzpE();
        }
        for (zze zzeVar : this.zzahW) {
            if (z) {
                zzeVar.zzpe();
            }
            zzeVar.zzx(new Status(8, "The connection to Google Play services was lost"));
        }
        this.zzahW.clear();
        this.zzahL.zzbT(i);
        this.zzahL.zzqQ();
        if (i == 2) {
            zzpC();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzp.zza
    public final void zzd(ConnectionResult connectionResult) {
        if (!this.zzags.zzd(this.mContext, connectionResult.getErrorCode())) {
            zzpF();
        }
        if (zzpB()) {
            return;
        }
        this.zzahL.zzk(connectionResult);
        this.zzahL.zzqQ();
    }

    @Override // com.google.android.gms.common.api.internal.zzp.zza
    public final void zzi(Bundle bundle) {
        while (!this.zzahN.isEmpty()) {
            zzb((zza.AbstractC0036zza) this.zzahN.remove());
        }
        this.zzahL.zzk(bundle);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zzoW() {
        if (this.zzahM != null) {
            this.zzahM.zzoW();
        }
    }

    final boolean zzpB() {
        return this.zzahO;
    }

    final void zzpE() {
        if (zzpB()) {
            return;
        }
        this.zzahO = true;
        if (this.zzahS == null) {
            this.zzahS = (zzc) zzn.zza(this.mContext.getApplicationContext(), new zzc(this), this.zzags);
        }
        this.zzahR.sendMessageDelayed(this.zzahR.obtainMessage(1), this.zzahP);
        this.zzahR.sendMessageDelayed(this.zzahR.obtainMessage(2), this.zzahQ);
    }

    final boolean zzpF() {
        if (!zzpB()) {
            return false;
        }
        this.zzahO = false;
        this.zzahR.removeMessages(2);
        this.zzahR.removeMessages(1);
        if (this.zzahS != null) {
            this.zzahS.unregister();
            this.zzahS = null;
        }
        return true;
    }

    final boolean zzpG() {
        this.zzXG.lock();
        try {
            if (this.zzaia != null) {
                z = this.zzaia.isEmpty() ? false : true;
            }
            return z;
        } finally {
            this.zzXG.unlock();
        }
    }

    final String zzpH() {
        StringWriter stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final zzq zzr(@NonNull Object obj) {
        com.google.android.gms.common.internal.zzx.zzb(obj, "Listener must not be null");
        this.zzXG.lock();
        try {
            zzq zzqVar = new zzq(this.zzagr, obj);
            this.zzahV.add(zzqVar);
            return zzqVar;
        } finally {
            this.zzXG.unlock();
        }
    }
}
