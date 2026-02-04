package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzi;

/* loaded from: classes2.dex */
public final class TileOverlayOptions implements SafeParcelable {
    public static final zzo CREATOR = new zzo();
    private final int mVersionCode;
    private com.google.android.gms.maps.model.internal.zzi zzaTP;
    private TileProvider zzaTQ;
    private boolean zzaTR;
    private float zzaTh;
    private boolean zzaTi;

    public TileOverlayOptions() {
        this.zzaTi = true;
        this.zzaTR = true;
        this.mVersionCode = 1;
    }

    TileOverlayOptions(int i, IBinder iBinder, boolean z, float f, boolean z2) {
        this.zzaTi = true;
        this.zzaTR = true;
        this.mVersionCode = i;
        this.zzaTP = zzi.zza.zzdm(iBinder);
        this.zzaTQ = this.zzaTP == null ? null : new TileProvider() { // from class: com.google.android.gms.maps.model.TileOverlayOptions.1
            private final com.google.android.gms.maps.model.internal.zzi zzaTS;

            {
                this.zzaTS = TileOverlayOptions.this.zzaTP;
            }

            @Override // com.google.android.gms.maps.model.TileProvider
            public Tile getTile(int i2, int i3, int i4) {
                try {
                    return this.zzaTS.getTile(i2, i3, i4);
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
        this.zzaTi = z;
        this.zzaTh = f;
        this.zzaTR = z2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final TileOverlayOptions fadeIn(boolean z) {
        this.zzaTR = z;
        return this;
    }

    public final boolean getFadeIn() {
        return this.zzaTR;
    }

    public final TileProvider getTileProvider() {
        return this.zzaTQ;
    }

    final int getVersionCode() {
        return this.mVersionCode;
    }

    public final float getZIndex() {
        return this.zzaTh;
    }

    public final boolean isVisible() {
        return this.zzaTi;
    }

    public final TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.zzaTQ = tileProvider;
        this.zzaTP = this.zzaTQ == null ? null : new zzi.zza() { // from class: com.google.android.gms.maps.model.TileOverlayOptions.2
            @Override // com.google.android.gms.maps.model.internal.zzi
            public Tile getTile(int i, int i2, int i3) {
                return tileProvider.getTile(i, i2, i3);
            }
        };
        return this;
    }

    public final TileOverlayOptions visible(boolean z) {
        this.zzaTi = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }

    public final TileOverlayOptions zIndex(float f) {
        this.zzaTh = f;
        return this;
    }

    final IBinder zzAm() {
        return this.zzaTP.asBinder();
    }
}
