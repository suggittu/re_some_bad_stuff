package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.dynamic.zzh;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzsf;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

/* loaded from: classes2.dex */
public final class SupportWalletFragment extends Fragment {
    private zzb zzbpW;
    private WalletFragmentOptions zzbqa;
    private WalletFragmentInitParams zzbqb;
    private MaskedWalletRequest zzbqc;
    private MaskedWallet zzbqd;
    private Boolean zzbqe;
    private boolean mCreated = false;
    private final zzh zzbpX = zzh.zza(this);
    private final zzc zzbpY = new zzc();
    private zza zzbpZ = new zza(this);
    private final Fragment zzalg = this;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
    }

    class zza extends zzry.zza {
        private OnStateChangedListener zzbqf;
        private final SupportWalletFragment zzbqg;

        zza(SupportWalletFragment supportWalletFragment) {
            this.zzbqg = supportWalletFragment;
        }

        @Override // com.google.android.gms.internal.zzry
        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzbqf != null) {
                this.zzbqf.onStateChanged(this.zzbqg, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzbqf = onStateChangedListener;
        }
    }

    class zzb implements LifecycleDelegate {
        private final zzrx zzbqh;

        private zzb(zzrx zzrxVar) {
            this.zzbqh = zzrxVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getState() {
            try {
                return this.zzbqh.getState();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void initialize(WalletFragmentInitParams walletFragmentInitParams) {
            try {
                this.zzbqh.initialize(walletFragmentInitParams);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onActivityResult(int i, int i2, Intent intent) {
            try {
                this.zzbqh.onActivityResult(i, i2, intent);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnabled(boolean z) {
            try {
                this.zzbqh.setEnabled(z);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.zzbqh.updateMaskedWallet(maskedWallet);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
            try {
                this.zzbqh.updateMaskedWalletRequest(maskedWalletRequest);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onCreate(Bundle bundle) {
            try {
                this.zzbqh.onCreate(bundle);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.zzp(this.zzbqh.onCreateView(zze.zzC(layoutInflater), zze.zzC(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroy() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroyView() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.zzbqh.zza(zze.zzC(activity), (WalletFragmentOptions) bundle.getParcelable("extraWalletFragmentOptions"), bundle2);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onLowMemory() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onPause() {
            try {
                this.zzbqh.onPause();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onResume() {
            try {
                this.zzbqh.onResume();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.zzbqh.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStart() {
            try {
                this.zzbqh.onStart();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStop() {
            try {
                this.zzbqh.onStop();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

    class zzc extends com.google.android.gms.dynamic.zza implements View.OnClickListener {
        private zzc() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentActivity activity = SupportWalletFragment.this.zzalg.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void zza(FrameLayout frameLayout) {
            WalletFragmentStyle fragmentStyle;
            int iZza = -1;
            int iZza2 = -2;
            Button button = new Button(SupportWalletFragment.this.zzalg.getActivity());
            button.setText(R.string.wallet_buy_button_place_holder);
            if (SupportWalletFragment.this.zzbqa != null && (fragmentStyle = SupportWalletFragment.this.zzbqa.getFragmentStyle()) != null) {
                DisplayMetrics displayMetrics = SupportWalletFragment.this.zzalg.getResources().getDisplayMetrics();
                iZza = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                iZza2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
            }
            button.setLayoutParams(new ViewGroup.LayoutParams(iZza, iZza2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void zza(zzf zzfVar) {
            FragmentActivity activity = SupportWalletFragment.this.zzalg.getActivity();
            if (SupportWalletFragment.this.zzbpW == null && SupportWalletFragment.this.mCreated && activity != null) {
                try {
                    zzrx zzrxVarZza = zzsf.zza(activity, SupportWalletFragment.this.zzbpX, SupportWalletFragment.this.zzbqa, SupportWalletFragment.this.zzbpZ);
                    SupportWalletFragment.this.zzbpW = new zzb(zzrxVarZza);
                    SupportWalletFragment.this.zzbqa = null;
                    zzfVar.zza(SupportWalletFragment.this.zzbpW);
                    if (SupportWalletFragment.this.zzbqb != null) {
                        SupportWalletFragment.this.zzbpW.initialize(SupportWalletFragment.this.zzbqb);
                        SupportWalletFragment.this.zzbqb = null;
                    }
                    if (SupportWalletFragment.this.zzbqc != null) {
                        SupportWalletFragment.this.zzbpW.updateMaskedWalletRequest(SupportWalletFragment.this.zzbqc);
                        SupportWalletFragment.this.zzbqc = null;
                    }
                    if (SupportWalletFragment.this.zzbqd != null) {
                        SupportWalletFragment.this.zzbpW.updateMaskedWallet(SupportWalletFragment.this.zzbqd);
                        SupportWalletFragment.this.zzbqd = null;
                    }
                    if (SupportWalletFragment.this.zzbqe != null) {
                        SupportWalletFragment.this.zzbpW.setEnabled(SupportWalletFragment.this.zzbqe.booleanValue());
                        SupportWalletFragment.this.zzbqe = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions walletFragmentOptions) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", walletFragmentOptions);
        supportWalletFragment.zzalg.setArguments(bundle);
        return supportWalletFragment;
    }

    public final int getState() {
        if (this.zzbpW != null) {
            return this.zzbpW.getState();
        }
        return 0;
    }

    public final void initialize(WalletFragmentInitParams walletFragmentInitParams) {
        if (this.zzbpW != null) {
            this.zzbpW.initialize(walletFragmentInitParams);
            this.zzbqb = null;
        } else {
            if (this.zzbqb != null) {
                Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
                return;
            }
            this.zzbqb = walletFragmentInitParams;
            if (this.zzbqc != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzbqd != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.zzbpW != null) {
            this.zzbpW.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        WalletFragmentOptions walletFragmentOptions;
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) bundle.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzbqb != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.zzbqb = walletFragmentInitParams;
            }
            if (this.zzbqc == null) {
                this.zzbqc = (MaskedWalletRequest) bundle.getParcelable("maskedWalletRequest");
            }
            if (this.zzbqd == null) {
                this.zzbqd = (MaskedWallet) bundle.getParcelable("maskedWallet");
            }
            if (bundle.containsKey("walletFragmentOptions")) {
                this.zzbqa = (WalletFragmentOptions) bundle.getParcelable("walletFragmentOptions");
            }
            if (bundle.containsKey("enabled")) {
                this.zzbqe = Boolean.valueOf(bundle.getBoolean("enabled"));
            }
        } else if (this.zzalg.getArguments() != null && (walletFragmentOptions = (WalletFragmentOptions) this.zzalg.getArguments().getParcelable("extraWalletFragmentOptions")) != null) {
            walletFragmentOptions.zzbc(this.zzalg.getActivity());
            this.zzbqa = walletFragmentOptions;
        }
        this.mCreated = true;
        this.zzbpY.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.zzbpY.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    @Override // android.support.v4.app.Fragment
    public final void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        if (this.zzbqa == null) {
            this.zzbqa = WalletFragmentOptions.zzb(activity, attributeSet);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("attrKeyWalletFragmentOptions", this.zzbqa);
        this.zzbpY.onInflate(activity, bundle2, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public final void onPause() {
        super.onPause();
        this.zzbpY.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        this.zzbpY.onResume();
        FragmentManager supportFragmentManager = this.zzalg.getActivity().getSupportFragmentManager();
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (fragmentFindFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzalg.getActivity()), this.zzalg.getActivity(), -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzbpY.onSaveInstanceState(bundle);
        if (this.zzbqb != null) {
            bundle.putParcelable("walletFragmentInitParams", this.zzbqb);
            this.zzbqb = null;
        }
        if (this.zzbqc != null) {
            bundle.putParcelable("maskedWalletRequest", this.zzbqc);
            this.zzbqc = null;
        }
        if (this.zzbqd != null) {
            bundle.putParcelable("maskedWallet", this.zzbqd);
            this.zzbqd = null;
        }
        if (this.zzbqa != null) {
            bundle.putParcelable("walletFragmentOptions", this.zzbqa);
            this.zzbqa = null;
        }
        if (this.zzbqe != null) {
            bundle.putBoolean("enabled", this.zzbqe.booleanValue());
            this.zzbqe = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onStart() {
        super.onStart();
        this.zzbpY.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public final void onStop() {
        super.onStop();
        this.zzbpY.onStop();
    }

    public final void setEnabled(boolean z) {
        if (this.zzbpW == null) {
            this.zzbqe = Boolean.valueOf(z);
        } else {
            this.zzbpW.setEnabled(z);
            this.zzbqe = null;
        }
    }

    public final void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.zzbpZ.zza(onStateChangedListener);
    }

    public final void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzbpW == null) {
            this.zzbqd = maskedWallet;
        } else {
            this.zzbpW.updateMaskedWallet(maskedWallet);
            this.zzbqd = null;
        }
    }

    public final void updateMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) {
        if (this.zzbpW == null) {
            this.zzbqc = maskedWalletRequest;
        } else {
            this.zzbpW.updateMaskedWalletRequest(maskedWalletRequest);
            this.zzbqc = null;
        }
    }
}
