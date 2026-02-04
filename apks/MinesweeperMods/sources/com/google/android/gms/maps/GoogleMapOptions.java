package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;

/* loaded from: classes2.dex */
public final class GoogleMapOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final int mVersionCode;
    private Boolean zzaRP;
    private Boolean zzaRQ;
    private int zzaRR;
    private CameraPosition zzaRS;
    private Boolean zzaRT;
    private Boolean zzaRU;
    private Boolean zzaRV;
    private Boolean zzaRW;
    private Boolean zzaRX;
    private Boolean zzaRY;
    private Boolean zzaRZ;
    private Boolean zzaSa;
    private Boolean zzaSb;

    public GoogleMapOptions() {
        this.zzaRR = -1;
        this.mVersionCode = 1;
    }

    GoogleMapOptions(int i, byte b, byte b2, int i2, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11) {
        this.zzaRR = -1;
        this.mVersionCode = i;
        this.zzaRP = com.google.android.gms.maps.internal.zza.zza(b);
        this.zzaRQ = com.google.android.gms.maps.internal.zza.zza(b2);
        this.zzaRR = i2;
        this.zzaRS = cameraPosition;
        this.zzaRT = com.google.android.gms.maps.internal.zza.zza(b3);
        this.zzaRU = com.google.android.gms.maps.internal.zza.zza(b4);
        this.zzaRV = com.google.android.gms.maps.internal.zza.zza(b5);
        this.zzaRW = com.google.android.gms.maps.internal.zza.zza(b6);
        this.zzaRX = com.google.android.gms.maps.internal.zza.zza(b7);
        this.zzaRY = com.google.android.gms.maps.internal.zza.zza(b8);
        this.zzaRZ = com.google.android.gms.maps.internal.zza.zza(b9);
        this.zzaSa = com.google.android.gms.maps.internal.zza.zza(b10);
        this.zzaSb = com.google.android.gms.maps.internal.zza.zza(b11);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(typedArrayObtainAttributes.getInt(R.styleable.MapAttrs_mapType, -1));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiCompass, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_liteMode, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiMapToolbar, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_ambientEnabled)) {
            googleMapOptions.ambientEnabled(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_ambientEnabled, false));
        }
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attributeSet));
        typedArrayObtainAttributes.recycle();
        return googleMapOptions;
    }

    public final GoogleMapOptions ambientEnabled(boolean z) {
        this.zzaSb = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.zzaRS = cameraPosition;
        return this;
    }

    public final GoogleMapOptions compassEnabled(boolean z) {
        this.zzaRU = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final Boolean getAmbientEnabled() {
        return this.zzaSb;
    }

    public final CameraPosition getCamera() {
        return this.zzaRS;
    }

    public final Boolean getCompassEnabled() {
        return this.zzaRU;
    }

    public final Boolean getLiteMode() {
        return this.zzaRZ;
    }

    public final Boolean getMapToolbarEnabled() {
        return this.zzaSa;
    }

    public final int getMapType() {
        return this.zzaRR;
    }

    public final Boolean getRotateGesturesEnabled() {
        return this.zzaRY;
    }

    public final Boolean getScrollGesturesEnabled() {
        return this.zzaRV;
    }

    public final Boolean getTiltGesturesEnabled() {
        return this.zzaRX;
    }

    public final Boolean getUseViewLifecycleInFragment() {
        return this.zzaRQ;
    }

    final int getVersionCode() {
        return this.mVersionCode;
    }

    public final Boolean getZOrderOnTop() {
        return this.zzaRP;
    }

    public final Boolean getZoomControlsEnabled() {
        return this.zzaRT;
    }

    public final Boolean getZoomGesturesEnabled() {
        return this.zzaRW;
    }

    public final GoogleMapOptions liteMode(boolean z) {
        this.zzaRZ = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions mapToolbarEnabled(boolean z) {
        this.zzaSa = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions mapType(int i) {
        this.zzaRR = i;
        return this;
    }

    public final GoogleMapOptions rotateGesturesEnabled(boolean z) {
        this.zzaRY = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions scrollGesturesEnabled(boolean z) {
        this.zzaRV = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions tiltGesturesEnabled(boolean z) {
        this.zzaRX = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions useViewLifecycleInFragment(boolean z) {
        this.zzaRQ = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public final GoogleMapOptions zOrderOnTop(boolean z) {
        this.zzaRP = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions zoomControlsEnabled(boolean z) {
        this.zzaRT = Boolean.valueOf(z);
        return this;
    }

    public final GoogleMapOptions zoomGesturesEnabled(boolean z) {
        this.zzaRW = Boolean.valueOf(z);
        return this;
    }

    final byte zzzK() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRP);
    }

    final byte zzzL() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRQ);
    }

    final byte zzzM() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRT);
    }

    final byte zzzN() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRU);
    }

    final byte zzzO() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRV);
    }

    final byte zzzP() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRW);
    }

    final byte zzzQ() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRX);
    }

    final byte zzzR() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRY);
    }

    final byte zzzS() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRZ);
    }

    final byte zzzT() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaSa);
    }

    final byte zzzU() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaSb);
    }
}
