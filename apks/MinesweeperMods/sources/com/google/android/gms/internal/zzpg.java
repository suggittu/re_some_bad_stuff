package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzou;
import com.google.android.gms.internal.zzov;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class zzpg implements SessionsApi {

    class zza extends zzou.zza {
        private final zza.zzb zzamC;

        private zza(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzou
        public void zza(SessionReadResult sessionReadResult) {
            this.zzamC.zzs(sessionReadResult);
        }
    }

    class zzb extends zzov.zza {
        private final zza.zzb zzamC;

        private zzb(zza.zzb zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzov
        public void zza(SessionStopResult sessionStopResult) {
            this.zzamC.zzs(sessionStopResult);
        }
    }

    private PendingResult zza(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new zzof.zza(googleApiClient) { // from class: com.google.android.gms.internal.zzpg.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzO, reason: merged with bridge method [inline-methods] */
            public SessionStopResult zzc(Status status) {
                return SessionStopResult.zzV(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzof zzofVar) {
                ((zzoq) zzofVar.zzqJ()).zza(new SessionStopRequest(str, str2, new zzb(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult insertSession(GoogleApiClient googleApiClient, final SessionInsertRequest sessionInsertRequest) {
        return googleApiClient.zza(new zzof.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpg.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzof zzofVar) {
                ((zzoq) zzofVar.zzqJ()).zza(new SessionInsertRequest(sessionInsertRequest, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult readSession(GoogleApiClient googleApiClient, final SessionReadRequest sessionReadRequest) {
        return googleApiClient.zza(new zzof.zza(googleApiClient) { // from class: com.google.android.gms.internal.zzpg.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* renamed from: zzP, reason: merged with bridge method [inline-methods] */
            public SessionReadResult zzc(Status status) {
                return SessionReadResult.zzU(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzof zzofVar) {
                ((zzoq) zzofVar.zzqJ()).zza(new SessionReadRequest(sessionReadRequest, new zza(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult registerForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, pendingIntent, 0);
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult startSession(GoogleApiClient googleApiClient, final Session session) {
        com.google.android.gms.common.internal.zzx.zzb(session, "Session cannot be null");
        com.google.android.gms.common.internal.zzx.zzb(session.getEndTime(TimeUnit.MILLISECONDS) == 0, "Cannot start a session which has already ended");
        return googleApiClient.zzb(new zzof.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpg.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzof zzofVar) {
                ((zzoq) zzofVar.zzqJ()).zza(new SessionStartRequest(session, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult stopSession(GoogleApiClient googleApiClient, String str) {
        return zza(googleApiClient, (String) null, str);
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult unregisterForSessions(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new zzof.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpg.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzof zzofVar) {
                ((zzoq) zzofVar.zzqJ()).zza(new SessionUnregistrationRequest(pendingIntent, new zzph(this)));
            }
        });
    }

    public PendingResult zza(GoogleApiClient googleApiClient, final PendingIntent pendingIntent, final int i) {
        return googleApiClient.zzb(new zzof.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpg.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzof zzofVar) {
                ((zzoq) zzofVar.zzqJ()).zza(new SessionRegistrationRequest(pendingIntent, new zzph(this), i));
            }
        });
    }
}
