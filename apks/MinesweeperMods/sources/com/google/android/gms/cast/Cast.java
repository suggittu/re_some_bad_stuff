package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzh;
import com.google.android.gms.cast.internal.zzk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class Cast {
    public static final int ACTIVE_INPUT_STATE_NO = 0;
    public static final int ACTIVE_INPUT_STATE_UNKNOWN = -1;
    public static final int ACTIVE_INPUT_STATE_YES = 1;
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    public static final int STANDBY_STATE_NO = 0;
    public static final int STANDBY_STATE_UNKNOWN = -1;
    public static final int STANDBY_STATE_YES = 1;
    private static final Api.zza zzUJ = new Api.zza() { // from class: com.google.android.gms.cast.Cast.1
        @Override // com.google.android.gms.common.api.Api.zza
        public final zze zza(Context context, Looper looper, zzf zzfVar, CastOptions castOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(castOptions, "Setting the API options is required.");
            return new zze(context, looper, zzfVar, castOptions.zzZL, castOptions.zzZN, castOptions.zzZM, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api API = new Api("Cast.API", zzUJ, zzk.zzUI);
    public static final CastApi CastApi = new CastApi.zza();

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public interface CastApi {

        public final class zza implements CastApi {
            @Override // com.google.android.gms.cast.Cast.CastApi
            public final int getActiveInputState(GoogleApiClient googleApiClient) {
                return ((zze) googleApiClient.zza(zzk.zzUI)).zzol();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) {
                return ((zze) googleApiClient.zza(zzk.zzUI)).getApplicationMetadata();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final String getApplicationStatus(GoogleApiClient googleApiClient) {
                return ((zze) googleApiClient.zza(zzk.zzUI)).getApplicationStatus();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final int getStandbyState(GoogleApiClient googleApiClient) {
                return ((zze) googleApiClient.zza(zzk.zzUI)).zzom();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final double getVolume(GoogleApiClient googleApiClient) {
                return ((zze) googleApiClient.zza(zzk.zzUI)).zzok();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final boolean isMute(GoogleApiClient googleApiClient) {
                return ((zze) googleApiClient.zza(zzk.zzUI)).isMute();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final PendingResult joinApplication(GoogleApiClient googleApiClient) {
                return zza(googleApiClient, null, null, null);
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final PendingResult joinApplication(GoogleApiClient googleApiClient, String str) {
                return zza(googleApiClient, str, null, null);
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final PendingResult joinApplication(GoogleApiClient googleApiClient, String str, String str2) {
                return zza(googleApiClient, str, str2, null);
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final PendingResult launchApplication(GoogleApiClient googleApiClient, final String str) {
                return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.2
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
                    public void zza(zze zzeVar) {
                        try {
                            zzeVar.zza(str, false, (zza.zzb) this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final PendingResult launchApplication(GoogleApiClient googleApiClient, final String str, final LaunchOptions launchOptions) {
                return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.3
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
                    public void zza(zze zzeVar) {
                        try {
                            zzeVar.zza(str, launchOptions, this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            @Deprecated
            public final PendingResult launchApplication(GoogleApiClient googleApiClient, String str, boolean z) {
                return launchApplication(googleApiClient, str, new LaunchOptions.Builder().setRelaunchIfRunning(z).build());
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final PendingResult leaveApplication(GoogleApiClient googleApiClient) {
                return googleApiClient.zzb(new zzh(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.5
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
                    public void zza(zze zzeVar) {
                        try {
                            zzeVar.zzb(this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException {
                try {
                    ((zze) googleApiClient.zza(zzk.zzUI)).zzcg(str);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final void requestStatus(GoogleApiClient googleApiClient) throws IOException {
                try {
                    ((zze) googleApiClient.zza(zzk.zzUI)).zzoj();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final PendingResult sendMessage(GoogleApiClient googleApiClient, final String str, final String str2) {
                return googleApiClient.zzb(new zzh(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
                    public void zza(zze zzeVar) {
                        try {
                            zzeVar.zza(str, str2, this);
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException {
                try {
                    ((zze) googleApiClient.zza(zzk.zzUI)).zza(str, messageReceivedCallback);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException {
                try {
                    ((zze) googleApiClient.zza(zzk.zzUI)).zzX(z);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final void setVolume(GoogleApiClient googleApiClient, double d) throws IOException {
                try {
                    ((zze) googleApiClient.zza(zzk.zzUI)).zzf(d);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final PendingResult stopApplication(GoogleApiClient googleApiClient) {
                return googleApiClient.zzb(new zzh(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.6
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
                    public void zza(zze zzeVar) {
                        try {
                            zzeVar.zza("", this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public final PendingResult stopApplication(GoogleApiClient googleApiClient, final String str) {
                return googleApiClient.zzb(new zzh(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.7
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
                    public void zza(zze zzeVar) {
                        if (TextUtils.isEmpty(str)) {
                            zze(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            zzeVar.zza(str, this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            public final PendingResult zza(GoogleApiClient googleApiClient, final String str, final String str2, final JoinOptions joinOptions) {
                return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.4
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
                    public void zza(zze zzeVar) {
                        try {
                            zzeVar.zza(str, str2, joinOptions, this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }
        }

        int getActiveInputState(GoogleApiClient googleApiClient);

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient);

        String getApplicationStatus(GoogleApiClient googleApiClient);

        int getStandbyState(GoogleApiClient googleApiClient);

        double getVolume(GoogleApiClient googleApiClient);

        boolean isMute(GoogleApiClient googleApiClient);

        PendingResult joinApplication(GoogleApiClient googleApiClient);

        PendingResult joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str);

        void requestStatus(GoogleApiClient googleApiClient);

        PendingResult sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback);

        void setMute(GoogleApiClient googleApiClient, boolean z);

        void setVolume(GoogleApiClient googleApiClient, double d);

        PendingResult stopApplication(GoogleApiClient googleApiClient);

        PendingResult stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public final class CastOptions implements Api.ApiOptions.HasOptions {
        final CastDevice zzZL;
        final Listener zzZM;
        private final int zzZN;

        public final class Builder {
            CastDevice zzZO;
            Listener zzZP;
            private int zzZQ;

            public Builder(CastDevice castDevice, Listener listener) {
                zzx.zzb(castDevice, "CastDevice parameter cannot be null");
                zzx.zzb(listener, "CastListener parameter cannot be null");
                this.zzZO = castDevice;
                this.zzZP = listener;
                this.zzZQ = 0;
            }

            public final CastOptions build() {
                return new CastOptions(this);
            }

            public final Builder setVerboseLoggingEnabled(boolean z) {
                if (z) {
                    this.zzZQ |= 1;
                } else {
                    this.zzZQ &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.zzZL = builder.zzZO;
            this.zzZM = builder.zzZP;
            this.zzZN = builder.zzZQ;
        }

        @Deprecated
        public static Builder builder(CastDevice castDevice, Listener listener) {
            return new Builder(castDevice, listener);
        }
    }

    public class Listener {
        public void onActiveInputStateChanged(int i) {
        }

        public void onApplicationDisconnected(int i) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onStandbyStateChanged(int i) {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    abstract class zza extends com.google.android.gms.cast.internal.zzb {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzo, reason: merged with bridge method [inline-methods] */
        public ApplicationConnectionResult zzc(final Status status) {
            return new ApplicationConnectionResult() { // from class: com.google.android.gms.cast.Cast.zza.1
                @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
                public String getApplicationStatus() {
                    return null;
                }

                @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
                public String getSessionId() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    private Cast() {
    }
}
