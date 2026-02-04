package com.google.android.gms.wallet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.zzsd;
import com.google.android.gms.internal.zzse;
import com.google.android.gms.internal.zzsg;
import com.google.android.gms.internal.zzsh;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class Wallet {
    private static final Api.zzc zzUI = new Api.zzc();
    private static final Api.zza zzUJ = new Api.zza() { // from class: com.google.android.gms.wallet.Wallet.1
        @Override // com.google.android.gms.common.api.Api.zza
        public final zzse zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, WalletOptions walletOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            if (walletOptions == null) {
                walletOptions = new WalletOptions();
            }
            return new zzse(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, walletOptions.theme, walletOptions.zzbpL);
        }
    };
    public static final Api API = new Api("Wallet.API", zzUJ, zzUI);
    public static final Payments Payments = new zzsd();
    public static final com.google.android.gms.wallet.wobs.zzj zzbpJ = new zzsh();
    public static final com.google.android.gms.wallet.firstparty.zza zzbpK = new zzsg();

    public final class WalletOptions implements Api.ApiOptions.HasOptions {
        public final int environment;
        public final int theme;
        private final boolean zzbpL;

        public final class Builder {
            private int zzbpM = 3;
            private int mTheme = 0;
            private boolean zzbpN = true;

            public final WalletOptions build() {
                return new WalletOptions(this);
            }

            public final Builder setEnvironment(int i) {
                if (i != 0 && i != 2 && i != 1 && i != 3) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", Integer.valueOf(i)));
                }
                this.zzbpM = i;
                return this;
            }

            public final Builder setTheme(int i) {
                if (i != 0 && i != 1) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", Integer.valueOf(i)));
                }
                this.mTheme = i;
                return this;
            }

            public final Builder useGoogleWallet() {
                this.zzbpN = false;
                return this;
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.zzbpM;
            this.theme = builder.mTheme;
            this.zzbpL = builder.zzbpN;
        }
    }

    public abstract class zza extends zza.AbstractC0036zza {
        public zza(GoogleApiClient googleApiClient) {
            super(Wallet.zzUI, googleApiClient);
        }
    }

    public abstract class zzb extends zza {
        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String str, String str2, int i) {
        Payments.changeMaskedWallet(googleApiClient, str, str2, i);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int i) {
        Payments.checkForPreAuthorization(googleApiClient, i);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest fullWalletRequest, int i) {
        Payments.loadFullWallet(googleApiClient, fullWalletRequest, i);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest maskedWalletRequest, int i) {
        Payments.loadMaskedWallet(googleApiClient, maskedWalletRequest, i);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        Payments.notifyTransactionStatus(googleApiClient, notifyTransactionStatusRequest);
    }
}
