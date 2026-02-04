package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class GeofencingRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zza();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final int mVersionCode;
    private final List zzaNN;
    private final int zzaNO;

    public final class Builder {
        private final List zzaNN = new ArrayList();
        private int zzaNO = 5;

        public static int zzhp(int i) {
            return i & 7;
        }

        public final Builder addGeofence(Geofence geofence) {
            zzx.zzb(geofence, "geofence can't be null.");
            zzx.zzb(geofence instanceof ParcelableGeofence, "Geofence must be created using Geofence.Builder.");
            this.zzaNN.add((ParcelableGeofence) geofence);
            return this;
        }

        public final Builder addGeofences(List list) {
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Geofence geofence = (Geofence) it.next();
                    if (geofence != null) {
                        addGeofence(geofence);
                    }
                }
            }
            return this;
        }

        public final GeofencingRequest build() {
            zzx.zzb(!this.zzaNN.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(this.zzaNN, this.zzaNO);
        }

        public final Builder setInitialTrigger(int i) {
            this.zzaNO = zzhp(i);
            return this;
        }
    }

    GeofencingRequest(int i, List list, int i2) {
        this.mVersionCode = i;
        this.zzaNN = list;
        this.zzaNO = i2;
    }

    private GeofencingRequest(List list, int i) {
        this(1, list, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List getGeofences() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zzaNN);
        return arrayList;
    }

    public int getInitialTrigger() {
        return this.zzaNO;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public List zzyI() {
        return this.zzaNN;
    }
}
