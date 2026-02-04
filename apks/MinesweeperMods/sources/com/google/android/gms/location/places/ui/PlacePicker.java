package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.zza;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes2.dex */
public class PlacePicker extends zza {
    public static final int RESULT_ERROR = 2;

    public class IntentBuilder extends zza.AbstractC0187zza {
        public IntentBuilder() {
            super("com.google.android.gms.location.places.ui.PICK_PLACE");
            this.mIntent.putExtra("gmscore_client_jar_version", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        }

        @Override // com.google.android.gms.location.places.ui.zza.AbstractC0187zza
        public Intent build(Activity activity) {
            return super.build(activity);
        }

        public IntentBuilder setLatLngBounds(LatLngBounds latLngBounds) {
            zzx.zzz(latLngBounds);
            zzc.zza(latLngBounds, this.mIntent, "latlng_bounds");
            return this;
        }
    }

    private PlacePicker() {
    }

    @Deprecated
    public static String getAttributions(Intent intent) {
        return intent.getStringExtra("third_party_attributions");
    }

    public static LatLngBounds getLatLngBounds(Intent intent) {
        return (LatLngBounds) zzc.zza(intent, "final_latlng_bounds", LatLngBounds.CREATOR);
    }

    public static Place getPlace(Context context, Intent intent) {
        return zza.getPlace(context, intent);
    }

    @Deprecated
    public static Place getPlace(Intent intent, Context context) {
        return zza.getPlace(context, intent);
    }
}
