package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.location.places.internal.zze;
import com.google.android.gms.location.places.internal.zzk;

/* loaded from: classes2.dex */
public class Places {
    public static final Api.zzc zzaPN = new Api.zzc();
    public static final Api.zzc zzaPO = new Api.zzc();
    public static final Api GEO_DATA_API = new Api("Places.GEO_DATA_API", new zze.zza(null), zzaPN);
    public static final Api PLACE_DETECTION_API = new Api("Places.PLACE_DETECTION_API", new zzk.zza(null), zzaPO);
    public static final GeoDataApi GeoDataApi = new com.google.android.gms.location.places.internal.zzd();
    public static final PlaceDetectionApi PlaceDetectionApi = new com.google.android.gms.location.places.internal.zzj();

    private Places() {
    }
}
