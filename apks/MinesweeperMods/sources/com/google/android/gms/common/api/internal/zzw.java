package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
public class zzw extends Fragment implements DialogInterface.OnCancelListener {
    private boolean mStarted;
    private ConnectionResult zzaiB;
    protected zzn zzaiD;
    private boolean zzaiz;
    private int zzaiA = -1;
    private final Handler zzaiC = new Handler(Looper.getMainLooper());
    private final SparseArray zzaiE = new SparseArray();

    class zza implements GoogleApiClient.OnConnectionFailedListener {
        public final int zzaiF;
        public final GoogleApiClient zzaiG;
        public final GoogleApiClient.OnConnectionFailedListener zzaiH;

        public zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.zzaiF = i;
            this.zzaiG = googleApiClient;
            this.zzaiH = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append((CharSequence) str).append("GoogleApiClient #").print(this.zzaiF);
            printWriter.println(":");
            this.zzaiG.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzw.this.zzaiC.post(zzw.this.new zzb(this.zzaiF, connectionResult));
        }

        public void zzpR() {
            this.zzaiG.unregisterConnectionFailedListener(this);
            this.zzaiG.disconnect();
        }
    }

    class zzb implements Runnable {
        private final int zzaiJ;
        private final ConnectionResult zzaiK;

        public zzb(int i, ConnectionResult connectionResult) {
            this.zzaiJ = i;
            this.zzaiK = connectionResult;
        }

        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            if (!zzw.this.mStarted || zzw.this.zzaiz) {
                return;
            }
            zzw.this.zzaiz = true;
            zzw.this.zzaiA = this.zzaiJ;
            zzw.this.zzaiB = this.zzaiK;
            if (this.zzaiK.hasResolution()) {
                try {
                    this.zzaiK.startResolutionForResult(zzw.this.getActivity(), ((zzw.this.getActivity().getSupportFragmentManager().getFragments().indexOf(zzw.this) + 1) << 16) + 1);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    zzw.this.zzpP();
                    return;
                }
            }
            if (zzw.this.zzpQ().isUserResolvableError(this.zzaiK.getErrorCode())) {
                zzw.this.zzb(this.zzaiJ, this.zzaiK);
            } else if (this.zzaiK.getErrorCode() == 18) {
                zzw.this.zzc(this.zzaiJ, this.zzaiK);
            } else {
                zzw.this.zza(this.zzaiJ, this.zzaiK);
            }
        }
    }

    @Nullable
    public static zzw zza(FragmentActivity fragmentActivity) {
        com.google.android.gms.common.internal.zzx.zzcD("Must be called from main thread of process");
        try {
            zzw zzwVar = (zzw) fragmentActivity.getSupportFragmentManager().findFragmentByTag("GmsSupportLifecycleFrag");
            if (zzwVar == null || zzwVar.isRemoving()) {
                return null;
            }
            return zzwVar;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFrag is not a SupportLifecycleFragment", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Unresolved error while connecting client. Stopping auto-manage.");
        zza zzaVar = (zza) this.zzaiE.get(i);
        if (zzaVar != null) {
            zzbD(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zzaVar.zzaiH;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        zzpP();
    }

    public static zzw zzb(FragmentActivity fragmentActivity) throws ClassNotFoundException {
        zzw zzwVarZza = zza(fragmentActivity);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (zzwVarZza == null) {
            zzwVarZza = zzpO();
            if (zzwVarZza == null) {
                Log.w("GmsSupportLifecycleFrag", "Unable to find connection error message resources (Did you include play-services-base and the proper proguard rules?); error dialogs may be unavailable.");
                zzwVarZza = new zzw();
            }
            supportFragmentManager.beginTransaction().add(zzwVarZza, "GmsSupportLifecycleFrag").commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
        }
        return zzwVarZza;
    }

    private static String zzi(ConnectionResult connectionResult) {
        return connectionResult.getErrorMessage() + " (" + connectionResult.getErrorCode() + ": " + com.google.android.gms.common.zze.getErrorString(connectionResult.getErrorCode()) + ')';
    }

    @Nullable
    private static zzw zzpO() throws ClassNotFoundException {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.android.gms.common.api.internal.SupportLifecycleFragmentImpl");
        } catch (ClassNotFoundException | LinkageError | SecurityException e) {
            if (Log.isLoggable("GmsSupportLifecycleFrag", 3)) {
                Log.d("GmsSupportLifecycleFrag", "Unable to find SupportLifecycleFragmentImpl class", e);
            }
            cls = null;
        }
        if (cls != null) {
            try {
                return (zzw) cls.newInstance();
            } catch (ExceptionInInitializerError | IllegalAccessException | InstantiationException | RuntimeException e2) {
                if (Log.isLoggable("GmsSupportLifecycleFrag", 3)) {
                    Log.d("GmsSupportLifecycleFrag", "Unable to instantiate SupportLifecycleFragmentImpl class", e2);
                }
            }
        }
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzaiE.size()) {
                return;
            }
            ((zza) this.zzaiE.valueAt(i2)).dump(str, fileDescriptor, printWriter, strArr);
            i = i2 + 1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0005  */
    @Override // android.support.v4.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            switch(r5) {
                case 1: goto L1b;
                case 2: goto Lc;
                default: goto L5;
            }
        L5:
            r0 = r1
        L6:
            if (r0 == 0) goto L2b
            r4.zzpP()
        Lb:
            return
        Lc:
            com.google.android.gms.common.zzc r2 = r4.zzpQ()
            android.support.v4.app.FragmentActivity r3 = r4.getActivity()
            int r2 = r2.isGooglePlayServicesAvailable(r3)
            if (r2 != 0) goto L5
            goto L6
        L1b:
            r2 = -1
            if (r6 == r2) goto L6
            if (r6 != 0) goto L5
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult
            r2 = 13
            r3 = 0
            r0.<init>(r2, r3)
            r4.zzaiB = r0
            goto L5
        L2b:
            int r0 = r4.zzaiA
            com.google.android.gms.common.ConnectionResult r1 = r4.zzaiB
            r4.zza(r0, r1)
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzw.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        zza(this.zzaiA, new ConnectionResult(13, null));
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzaiz = bundle.getBoolean("resolving_error", false);
            this.zzaiA = bundle.getInt("failed_client_id", -1);
            if (this.zzaiA >= 0) {
                this.zzaiB = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.zzaiz);
        if (this.zzaiA >= 0) {
            bundle.putInt("failed_client_id", this.zzaiA);
            bundle.putInt("failed_status", this.zzaiB.getErrorCode());
            bundle.putParcelable("failed_resolution", this.zzaiB.getResolution());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.mStarted = true;
        if (this.zzaiz) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzaiE.size()) {
                return;
            }
            ((zza) this.zzaiE.valueAt(i2)).zzaiG.connect();
            i = i2 + 1;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        int i = 0;
        super.onStop();
        this.mStarted = false;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzaiE.size()) {
                return;
            }
            ((zza) this.zzaiE.valueAt(i2)).zzaiG.disconnect();
            i = i2 + 1;
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        com.google.android.gms.common.internal.zzx.zzb(googleApiClient, "GoogleApiClient instance cannot be null");
        com.google.android.gms.common.internal.zzx.zza(this.zzaiE.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        this.zzaiE.put(i, new zza(i, googleApiClient, onConnectionFailedListener));
        if (!this.mStarted || this.zzaiz) {
            return;
        }
        googleApiClient.connect();
    }

    protected void zzb(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Failed to connect due to user resolvable error " + zzi(connectionResult));
        zza(i, connectionResult);
    }

    public void zzbD(int i) {
        zza zzaVar = (zza) this.zzaiE.get(i);
        this.zzaiE.remove(i);
        if (zzaVar != null) {
            zzaVar.zzpR();
        }
    }

    protected void zzc(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Unable to connect, GooglePlayServices is updating.");
        zza(i, connectionResult);
    }

    protected void zzpP() {
        int i = 0;
        this.zzaiz = false;
        this.zzaiA = -1;
        this.zzaiB = null;
        if (this.zzaiD != null) {
            this.zzaiD.unregister();
            this.zzaiD = null;
        }
        while (true) {
            int i2 = i;
            if (i2 >= this.zzaiE.size()) {
                return;
            }
            ((zza) this.zzaiE.valueAt(i2)).zzaiG.connect();
            i = i2 + 1;
        }
    }

    protected com.google.android.gms.common.zzc zzpQ() {
        return com.google.android.gms.common.zzc.zzoK();
    }
}
