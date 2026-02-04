package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* loaded from: classes2.dex */
public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private Boolean zzaRQ;
    private Boolean zzaRW;
    private StreetViewPanoramaCamera zzaSD;
    private String zzaSE;
    private LatLng zzaSF;
    private Integer zzaSG;
    private Boolean zzaSH;
    private Boolean zzaSI;
    private Boolean zzaSJ;

    public StreetViewPanoramaOptions() {
        this.zzaSH = true;
        this.zzaRW = true;
        this.zzaSI = true;
        this.zzaSJ = true;
        this.mVersionCode = 1;
    }

    StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5) {
        this.zzaSH = true;
        this.zzaRW = true;
        this.zzaSI = true;
        this.zzaSJ = true;
        this.mVersionCode = i;
        this.zzaSD = streetViewPanoramaCamera;
        this.zzaSF = latLng;
        this.zzaSG = num;
        this.zzaSE = str;
        this.zzaSH = com.google.android.gms.maps.internal.zza.zza(b);
        this.zzaRW = com.google.android.gms.maps.internal.zza.zza(b2);
        this.zzaSI = com.google.android.gms.maps.internal.zza.zza(b3);
        this.zzaSJ = com.google.android.gms.maps.internal.zza.zza(b4);
        this.zzaRQ = com.google.android.gms.maps.internal.zza.zza(b5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final Boolean getPanningGesturesEnabled() {
        return this.zzaSI;
    }

    public final String getPanoramaId() {
        return this.zzaSE;
    }

    public final LatLng getPosition() {
        return this.zzaSF;
    }

    public final Integer getRadius() {
        return this.zzaSG;
    }

    public final Boolean getStreetNamesEnabled() {
        return this.zzaSJ;
    }

    public final StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.zzaSD;
    }

    public final Boolean getUseViewLifecycleInFragment() {
        return this.zzaRQ;
    }

    public final Boolean getUserNavigationEnabled() {
        return this.zzaSH;
    }

    final int getVersionCode() {
        return this.mVersionCode;
    }

    public final Boolean getZoomGesturesEnabled() {
        return this.zzaRW;
    }

    public final StreetViewPanoramaOptions panningGesturesEnabled(boolean z) {
        this.zzaSI = Boolean.valueOf(z);
        return this;
    }

    public final StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.zzaSD = streetViewPanoramaCamera;
        return this;
    }

    public final StreetViewPanoramaOptions panoramaId(String str) {
        this.zzaSE = str;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latLng) {
        this.zzaSF = latLng;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latLng, Integer num) {
        this.zzaSF = latLng;
        this.zzaSG = num;
        return this;
    }

    public final StreetViewPanoramaOptions streetNamesEnabled(boolean z) {
        this.zzaSJ = Boolean.valueOf(z);
        return this;
    }

    public final StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z) {
        this.zzaRQ = Boolean.valueOf(z);
        return this;
    }

    public final StreetViewPanoramaOptions userNavigationEnabled(boolean z) {
        this.zzaSH = Boolean.valueOf(z);
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public final StreetViewPanoramaOptions zoomGesturesEnabled(boolean z) {
        this.zzaRW = Boolean.valueOf(z);
        return this;
    }

    final byte zzAa() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaSH);
    }

    final byte zzAb() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaSI);
    }

    final byte zzAc() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaSJ);
    }

    final byte zzzL() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRQ);
    }

    final byte zzzP() {
        return com.google.android.gms.maps.internal.zza.zze(this.zzaRW);
    }
}
