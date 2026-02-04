package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzbm;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhc;
import com.google.android.gms.internal.zzhd;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzit;
import com.google.android.gms.internal.zzji;

@zzhb
/* loaded from: classes2.dex */
public abstract class zzd implements zzc.zza, zzit {
    private final zzji zzHl;
    private final zzc.zza zzHm;
    private final Object zzpV = new Object();

    @zzhb
    public final class zza extends zzd {
        private final Context mContext;

        public zza(Context context, zzji zzjiVar, zzc.zza zzaVar) {
            super(zzjiVar, zzaVar);
            this.mContext = context;
        }

        @Override // com.google.android.gms.ads.internal.request.zzd, com.google.android.gms.internal.zzit
        public final /* synthetic */ Object zzgd() {
            return super.zzgd();
        }

        @Override // com.google.android.gms.ads.internal.request.zzd
        public final void zzgr() {
        }

        @Override // com.google.android.gms.ads.internal.request.zzd
        public final zzj zzgs() {
            return zzhd.zza(this.mContext, new zzbm((String) zzbt.zzvB.get()), zzhc.zzgA());
        }
    }

    @zzhb
    public class zzb extends zzd implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private Context mContext;
        private zzji zzHl;
        private final zzc.zza zzHm;
        protected zze zzHp;
        private boolean zzHq;
        private VersionInfoParcel zzpT;
        private final Object zzpV;

        public zzb(Context context, VersionInfoParcel versionInfoParcel, zzji zzjiVar, zzc.zza zzaVar) {
            Looper mainLooper;
            super(zzjiVar, zzaVar);
            this.zzpV = new Object();
            this.mContext = context;
            this.zzpT = versionInfoParcel;
            this.zzHl = zzjiVar;
            this.zzHm = zzaVar;
            if (((Boolean) zzbt.zzwa.get()).booleanValue()) {
                this.zzHq = true;
                mainLooper = zzr.zzbO().zzhC();
            } else {
                mainLooper = context.getMainLooper();
            }
            this.zzHp = new zze(context, mainLooper, this, this, this.zzpT.zzNa);
            connect();
        }

        protected void connect() {
            this.zzHp.zzqG();
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnected(Bundle bundle) {
            zzgd();
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzin.zzaI("Cannot connect to remote service, fallback to local instance.");
            zzgt().zzgd();
            Bundle bundle = new Bundle();
            bundle.putString("action", "gms_connection_failed_fallback_to_local");
            zzr.zzbC().zzb(this.mContext, this.zzpT.afmaVersion, "gmob-apps", bundle, true);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnectionSuspended(int i) {
            zzin.zzaI("Disconnected from remote ad request service.");
        }

        @Override // com.google.android.gms.ads.internal.request.zzd, com.google.android.gms.internal.zzit
        public /* synthetic */ Object zzgd() {
            return super.zzgd();
        }

        @Override // com.google.android.gms.ads.internal.request.zzd
        public void zzgr() {
            synchronized (this.zzpV) {
                if (this.zzHp.isConnected() || this.zzHp.isConnecting()) {
                    this.zzHp.disconnect();
                }
                Binder.flushPendingCommands();
                if (this.zzHq) {
                    zzr.zzbO().zzhD();
                    this.zzHq = false;
                }
            }
        }

        @Override // com.google.android.gms.ads.internal.request.zzd
        public zzj zzgs() {
            zzj zzjVarZzgw;
            synchronized (this.zzpV) {
                try {
                    zzjVarZzgw = this.zzHp.zzgw();
                } catch (DeadObjectException | IllegalStateException e) {
                    zzjVarZzgw = null;
                }
            }
            return zzjVarZzgw;
        }

        zzit zzgt() {
            return new zza(this.mContext, this.zzHl, this.zzHm);
        }
    }

    public zzd(zzji zzjiVar, zzc.zza zzaVar) {
        this.zzHl = zzjiVar;
        this.zzHm = zzaVar;
    }

    @Override // com.google.android.gms.internal.zzit
    public void cancel() {
        zzgr();
    }

    boolean zza(zzj zzjVar, AdRequestInfoParcel adRequestInfoParcel) {
        try {
            zzjVar.zza(adRequestInfoParcel, new zzg(this));
            return true;
        } catch (RemoteException e) {
            zzin.zzd("Could not fetch ad response from ad request service.", e);
            zzr.zzbF().zzb((Throwable) e, true);
            this.zzHm.zzb(new AdResponseParcel(0));
            return false;
        } catch (NullPointerException e2) {
            zzin.zzd("Could not fetch ad response from ad request service due to an Exception.", e2);
            zzr.zzbF().zzb((Throwable) e2, true);
            this.zzHm.zzb(new AdResponseParcel(0));
            return false;
        } catch (SecurityException e3) {
            zzin.zzd("Could not fetch ad response from ad request service due to an Exception.", e3);
            zzr.zzbF().zzb((Throwable) e3, true);
            this.zzHm.zzb(new AdResponseParcel(0));
            return false;
        } catch (Throwable th) {
            zzin.zzd("Could not fetch ad response from ad request service due to an Exception.", th);
            zzr.zzbF().zzb(th, true);
            this.zzHm.zzb(new AdResponseParcel(0));
            return false;
        }
    }

    @Override // com.google.android.gms.ads.internal.request.zzc.zza
    public void zzb(AdResponseParcel adResponseParcel) {
        synchronized (this.zzpV) {
            this.zzHm.zzb(adResponseParcel);
            zzgr();
        }
    }

    @Override // com.google.android.gms.internal.zzit
    /* renamed from: zzga, reason: merged with bridge method [inline-methods] */
    public Void zzgd() {
        final zzj zzjVarZzgs = zzgs();
        if (zzjVarZzgs == null) {
            this.zzHm.zzb(new AdResponseParcel(0));
            zzgr();
        } else {
            this.zzHl.zza(new zzji.zzc() { // from class: com.google.android.gms.ads.internal.request.zzd.1
                @Override // com.google.android.gms.internal.zzji.zzc
                /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
                public void zze(AdRequestInfoParcel adRequestInfoParcel) {
                    if (zzd.this.zza(zzjVarZzgs, adRequestInfoParcel)) {
                        return;
                    }
                    zzd.this.zzgr();
                }
            }, new zzji.zza() { // from class: com.google.android.gms.ads.internal.request.zzd.2
                @Override // com.google.android.gms.internal.zzji.zza
                public void run() {
                    zzd.this.zzgr();
                }
            });
        }
        return null;
    }

    public abstract void zzgr();

    public abstract zzj zzgs();
}
