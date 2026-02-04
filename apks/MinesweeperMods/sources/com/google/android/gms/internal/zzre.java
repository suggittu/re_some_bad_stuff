package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafetyNetApi;
import java.util.List;

/* loaded from: classes2.dex */
public class zzre implements SafetyNetApi {

    class zza implements SafetyNetApi.AttestationResult {
        private final Status zzUX;
        private final AttestationData zzbgB;

        public zza(Status status, AttestationData attestationData) {
            this.zzUX = status;
            this.zzbgB = attestationData;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.AttestationResult
        public String getJwsResult() {
            if (this.zzbgB == null) {
                return null;
            }
            return this.zzbgB.getJwsResult();
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    abstract class zzb extends zzrb {
        protected zzrc zzbgC;

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzbgC = new zzra() { // from class: com.google.android.gms.internal.zzre.zzb.1
                @Override // com.google.android.gms.internal.zzra, com.google.android.gms.internal.zzrc
                public void zza(Status status, AttestationData attestationData) {
                    zzb.this.zza(new zza(status, attestationData));
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzbh, reason: merged with bridge method [inline-methods] */
        public SafetyNetApi.AttestationResult zzc(Status status) {
            return new zza(status, null);
        }
    }

    abstract class zzc extends zzrb {
        protected zzrc zzbgC;

        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzbgC = new zzra() { // from class: com.google.android.gms.internal.zzre.zzc.1
                @Override // com.google.android.gms.internal.zzra, com.google.android.gms.internal.zzrc
                public void zza(Status status, SafeBrowsingData safeBrowsingData) {
                    zzc.this.zza(new zzd(status, safeBrowsingData));
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzbi, reason: merged with bridge method [inline-methods] */
        public SafetyNetApi.SafeBrowsingResult zzc(Status status) {
            return new zzd(status, null);
        }
    }

    class zzd implements SafetyNetApi.SafeBrowsingResult {
        private Status zzUX;
        private final SafeBrowsingData zzbgF;
        private String zzbgv;

        public zzd(Status status, SafeBrowsingData safeBrowsingData) {
            this.zzUX = status;
            this.zzbgF = safeBrowsingData;
            this.zzbgv = null;
            if (this.zzbgF != null) {
                this.zzbgv = this.zzbgF.getMetadata();
            } else if (this.zzUX.isSuccess()) {
                this.zzUX = new Status(8);
            }
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult
        public String getMetadata() {
            return this.zzbgv;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult attest(GoogleApiClient googleApiClient, final byte[] bArr) {
        return googleApiClient.zza(new zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzre.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzrf zzrfVar) {
                zzrfVar.zza(this.zzbgC, bArr);
            }
        });
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult lookupUri(GoogleApiClient googleApiClient, final List list, final String str) {
        if (list == null) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
        return googleApiClient.zza(new zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzre.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzrf zzrfVar) {
                zzrfVar.zza(this.zzbgC, list, 1, str);
            }
        });
    }
}
