package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzad;
import com.google.android.gms.maps.internal.zzo;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class MapView extends FrameLayout {
    private GoogleMap zzaSd;
    private final zzb zzaSj;

    class zza implements MapLifecycleDelegate {
        private final ViewGroup zzaSk;
        private final IMapViewDelegate zzaSl;
        private View zzaSm;

        public zza(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.zzaSl = (IMapViewDelegate) zzx.zzz(iMapViewDelegate);
            this.zzaSk = (ViewGroup) zzx.zzz(viewGroup);
        }

        @Override // com.google.android.gms.maps.internal.MapLifecycleDelegate
        public void getMapAsync(final OnMapReadyCallback onMapReadyCallback) {
            try {
                this.zzaSl.getMapAsync(new zzo.zza() { // from class: com.google.android.gms.maps.MapView.zza.1
                    @Override // com.google.android.gms.maps.internal.zzo
                    public void zza(IGoogleMapDelegate iGoogleMapDelegate) {
                        onMapReadyCallback.onMapReady(new GoogleMap(iGoogleMapDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onCreate(Bundle bundle) {
            try {
                this.zzaSl.onCreate(bundle);
                this.zzaSm = (View) zze.zzp(this.zzaSl.getView());
                this.zzaSk.removeAllViews();
                this.zzaSk.addView(this.zzaSm);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroy() {
            try {
                this.zzaSl.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onEnterAmbient(Bundle bundle) {
            try {
                this.zzaSl.onEnterAmbient(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onExitAmbient() {
            try {
                this.zzaSl.onExitAmbient();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onLowMemory() {
            try {
                this.zzaSl.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onPause() {
            try {
                this.zzaSl.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onResume() {
            try {
                this.zzaSl.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.zzaSl.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStart() {
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public void onStop() {
        }

        public IMapViewDelegate zzzX() {
            return this.zzaSl;
        }
    }

    class zzb extends com.google.android.gms.dynamic.zza {
        private final Context mContext;
        protected zzf zzaSh;
        private final List zzaSi = new ArrayList();
        private final ViewGroup zzaSo;
        private final GoogleMapOptions zzaSp;

        zzb(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.zzaSo = viewGroup;
            this.mContext = context;
            this.zzaSp = googleMapOptions;
        }

        public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            if (zztU() != null) {
                ((zza) zztU()).getMapAsync(onMapReadyCallback);
            } else {
                this.zzaSi.add(onMapReadyCallback);
            }
        }

        public void onEnterAmbient(Bundle bundle) {
            if (zztU() != null) {
                ((zza) zztU()).onEnterAmbient(bundle);
            }
        }

        public void onExitAmbient() {
            if (zztU() != null) {
                ((zza) zztU()).onExitAmbient();
            }
        }

        @Override // com.google.android.gms.dynamic.zza
        protected void zza(zzf zzfVar) {
            this.zzaSh = zzfVar;
            zzzW();
        }

        public void zzzW() {
            if (this.zzaSh == null || zztU() != null) {
                return;
            }
            try {
                MapsInitializer.initialize(this.mContext);
                IMapViewDelegate iMapViewDelegateZza = zzad.zzaO(this.mContext).zza(zze.zzC(this.mContext), this.zzaSp);
                if (iMapViewDelegateZza == null) {
                    return;
                }
                this.zzaSh.zza(new zza(this.zzaSo, iMapViewDelegateZza));
                Iterator it = this.zzaSi.iterator();
                while (it.hasNext()) {
                    ((zza) zztU()).getMapAsync((OnMapReadyCallback) it.next());
                }
                this.zzaSi.clear();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            } catch (GooglePlayServicesNotAvailableException e2) {
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.zzaSj = new zzb(this, context, null);
        zzex();
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzaSj = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        zzex();
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzaSj = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        zzex();
    }

    public MapView(Context context, GoogleMapOptions googleMapOptions) {
        super(context);
        this.zzaSj = new zzb(this, context, googleMapOptions);
        zzex();
    }

    private void zzex() {
        setClickable(true);
    }

    @Deprecated
    public final GoogleMap getMap() {
        if (this.zzaSd != null) {
            return this.zzaSd;
        }
        this.zzaSj.zzzW();
        if (this.zzaSj.zztU() == null) {
            return null;
        }
        try {
            this.zzaSd = new GoogleMap(((zza) this.zzaSj.zztU()).zzzX().getMap());
            return this.zzaSd;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        zzx.zzcD("getMapAsync() must be called on the main thread");
        this.zzaSj.getMapAsync(onMapReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        this.zzaSj.onCreate(bundle);
        if (this.zzaSj.zztU() == null) {
            com.google.android.gms.dynamic.zza.zzb(this);
        }
    }

    public final void onDestroy() {
        this.zzaSj.onDestroy();
    }

    public final void onEnterAmbient(Bundle bundle) {
        zzx.zzcD("onEnterAmbient() must be called on the main thread");
        this.zzaSj.onEnterAmbient(bundle);
    }

    public final void onExitAmbient() {
        zzx.zzcD("onExitAmbient() must be called on the main thread");
        this.zzaSj.onExitAmbient();
    }

    public final void onLowMemory() {
        this.zzaSj.onLowMemory();
    }

    public final void onPause() {
        this.zzaSj.onPause();
    }

    public final void onResume() {
        this.zzaSj.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.zzaSj.onSaveInstanceState(bundle);
    }
}
