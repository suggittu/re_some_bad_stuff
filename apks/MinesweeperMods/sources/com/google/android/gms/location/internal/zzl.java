package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.internal.zzh;
import com.google.android.gms.location.internal.zzj;
import java.util.List;

/* loaded from: classes2.dex */
public class zzl extends com.google.android.gms.location.internal.zzb {
    private final zzk zzaOM;

    final class zza extends zzh.zza {
        private zza.zzb zzaON;

        public zza(zza.zzb zzbVar) {
            this.zzaON = zzbVar;
        }

        @Override // com.google.android.gms.location.internal.zzh
        public final void zza(int i, PendingIntent pendingIntent) {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
        }

        @Override // com.google.android.gms.location.internal.zzh
        public final void zza(int i, String[] strArr) {
            if (this.zzaON == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            this.zzaON.zzs(LocationStatusCodes.zzhz(LocationStatusCodes.zzhy(i)));
            this.zzaON = null;
        }

        @Override // com.google.android.gms.location.internal.zzh
        public final void zzb(int i, String[] strArr) {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
        }
    }

    final class zzb extends zzh.zza {
        private zza.zzb zzaON;

        public zzb(zza.zzb zzbVar) {
            this.zzaON = zzbVar;
        }

        private void zzhC(int i) {
            if (this.zzaON == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
                return;
            }
            this.zzaON.zzs(LocationStatusCodes.zzhz(LocationStatusCodes.zzhy(i)));
            this.zzaON = null;
        }

        @Override // com.google.android.gms.location.internal.zzh
        public final void zza(int i, PendingIntent pendingIntent) {
            zzhC(i);
        }

        @Override // com.google.android.gms.location.internal.zzh
        public final void zza(int i, String[] strArr) {
            Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
        }

        @Override // com.google.android.gms.location.internal.zzh
        public final void zzb(int i, String[] strArr) {
            zzhC(i);
        }
    }

    final class zzc extends zzj.zza {
        private zza.zzb zzaON;

        public zzc(zza.zzb zzbVar) {
            zzx.zzb(zzbVar != null, "listener can't be null.");
            this.zzaON = zzbVar;
        }

        @Override // com.google.android.gms.location.internal.zzj
        public final void zza(LocationSettingsResult locationSettingsResult) {
            this.zzaON.zzs(locationSettingsResult);
            this.zzaON = null;
        }
    }

    public zzl(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, com.google.android.gms.common.internal.zzf.zzat(context));
    }

    public zzl(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, zzfVar);
        this.zzaOM = new zzk(context, this.zzaOt);
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        synchronized (this.zzaOM) {
            if (isConnected()) {
                try {
                    this.zzaOM.removeAllListeners();
                    this.zzaOM.zzyP();
                } catch (Exception e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
                super.disconnect();
            } else {
                super.disconnect();
            }
        }
    }

    public Location getLastLocation() {
        return this.zzaOM.getLastLocation();
    }

    public void zza(long j, PendingIntent pendingIntent) {
        zzqI();
        zzx.zzz(pendingIntent);
        zzx.zzb(j >= 0, "detectionIntervalMillis must be >= 0");
        ((zzi) zzqJ()).zza(j, true, pendingIntent);
    }

    public void zza(PendingIntent pendingIntent) {
        zzqI();
        zzx.zzz(pendingIntent);
        ((zzi) zzqJ()).zza(pendingIntent);
    }

    public void zza(PendingIntent pendingIntent, zza.zzb zzbVar) {
        zzqI();
        zzx.zzb(pendingIntent, "PendingIntent must be specified.");
        zzx.zzb(zzbVar, "ResultHolder not provided.");
        ((zzi) zzqJ()).zza(pendingIntent, new zzb(zzbVar), getContext().getPackageName());
    }

    public void zza(PendingIntent pendingIntent, zzg zzgVar) {
        this.zzaOM.zza(pendingIntent, zzgVar);
    }

    public void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zza.zzb zzbVar) {
        zzqI();
        zzx.zzb(geofencingRequest, "geofencingRequest can't be null.");
        zzx.zzb(pendingIntent, "PendingIntent must be specified.");
        zzx.zzb(zzbVar, "ResultHolder not provided.");
        ((zzi) zzqJ()).zza(geofencingRequest, pendingIntent, new zza(zzbVar));
    }

    public void zza(LocationCallback locationCallback, zzg zzgVar) {
        this.zzaOM.zza(locationCallback, zzgVar);
    }

    public void zza(LocationListener locationListener, zzg zzgVar) {
        this.zzaOM.zza(locationListener, zzgVar);
    }

    public void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzg zzgVar) {
        this.zzaOM.zza(locationRequest, pendingIntent, zzgVar);
    }

    public void zza(LocationRequest locationRequest, LocationListener locationListener, Looper looper, zzg zzgVar) {
        synchronized (this.zzaOM) {
            this.zzaOM.zza(locationRequest, locationListener, looper, zzgVar);
        }
    }

    public void zza(LocationSettingsRequest locationSettingsRequest, zza.zzb zzbVar, String str) {
        zzqI();
        zzx.zzb(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        zzx.zzb(zzbVar != null, "listener can't be null.");
        ((zzi) zzqJ()).zza(locationSettingsRequest, new zzc(zzbVar), str);
    }

    public void zza(LocationRequestInternal locationRequestInternal, LocationCallback locationCallback, Looper looper, zzg zzgVar) {
        synchronized (this.zzaOM) {
            this.zzaOM.zza(locationRequestInternal, locationCallback, looper, zzgVar);
        }
    }

    public void zza(zzg zzgVar) {
        this.zzaOM.zza(zzgVar);
    }

    public void zza(List list, zza.zzb zzbVar) {
        zzqI();
        zzx.zzb(list != null && list.size() > 0, "geofenceRequestIds can't be null nor empty.");
        zzx.zzb(zzbVar, "ResultHolder not provided.");
        ((zzi) zzqJ()).zza((String[]) list.toArray(new String[0]), new zzb(zzbVar), getContext().getPackageName());
    }

    public void zzam(boolean z) {
        this.zzaOM.zzam(z);
    }

    public void zzc(Location location) {
        this.zzaOM.zzc(location);
    }

    public LocationAvailability zzyO() {
        return this.zzaOM.zzyO();
    }
}
