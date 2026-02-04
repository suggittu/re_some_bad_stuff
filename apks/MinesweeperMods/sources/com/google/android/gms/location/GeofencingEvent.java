package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class GeofencingEvent {
    private final int zzGu;
    private final int zzaNK;
    private final List zzaNL;
    private final Location zzaNM;

    private GeofencingEvent(int i, int i2, List list, Location location) {
        this.zzGu = i;
        this.zzaNK = i2;
        this.zzaNL = list;
        this.zzaNM = location;
    }

    public static GeofencingEvent fromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        return new GeofencingEvent(intent.getIntExtra("gms_error_code", -1), zzx(intent), zzy(intent), (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    private static int zzx(Intent intent) {
        int intExtra = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (intExtra == -1) {
            return -1;
        }
        if (intExtra == 1 || intExtra == 2 || intExtra == 4) {
            return intExtra;
        }
        return -1;
    }

    private static List zzy(Intent intent) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(ParcelableGeofence.zzo((byte[]) it.next()));
        }
        return arrayList2;
    }

    public int getErrorCode() {
        return this.zzGu;
    }

    public int getGeofenceTransition() {
        return this.zzaNK;
    }

    public List getTriggeringGeofences() {
        return this.zzaNL;
    }

    public Location getTriggeringLocation() {
        return this.zzaNM;
    }

    public boolean hasError() {
        return this.zzGu != -1;
    }
}
