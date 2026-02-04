package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.zza;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes2.dex */
public class PlaceAutocomplete extends zza {
    public static final int MODE_FULLSCREEN = 1;
    public static final int MODE_OVERLAY = 2;
    public static final int RESULT_ERROR = 2;

    public class IntentBuilder extends zza.AbstractC0187zza {
        public IntentBuilder(int i) {
            super("com.google.android.gms.location.places.ui.AUTOCOMPLETE");
            this.mIntent.putExtra("gmscore_client_jar_version", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            this.mIntent.putExtra("mode", i);
            this.mIntent.putExtra("origin", 2);
        }

        @Override // com.google.android.gms.location.places.ui.zza.AbstractC0187zza
        public Intent build(Activity activity) {
            return super.build(activity);
        }

        public IntentBuilder setBoundsBias(@Nullable LatLngBounds latLngBounds) {
            if (latLngBounds != null) {
                this.mIntent.putExtra("bounds", latLngBounds);
            } else {
                this.mIntent.removeExtra("bounds");
            }
            return this;
        }

        public IntentBuilder setFilter(@Nullable AutocompleteFilter autocompleteFilter) {
            if (autocompleteFilter != null) {
                this.mIntent.putExtra("filter", autocompleteFilter);
            } else {
                this.mIntent.removeExtra("filter");
            }
            return this;
        }

        public IntentBuilder zzeq(@Nullable String str) {
            if (str != null) {
                this.mIntent.putExtra("initial_query", str);
            } else {
                this.mIntent.removeExtra("initial_query");
            }
            return this;
        }

        public IntentBuilder zzig(int i) {
            this.mIntent.putExtra("origin", i);
            return this;
        }
    }

    private PlaceAutocomplete() {
    }

    public static Place getPlace(Context context, Intent intent) {
        return zza.getPlace(context, intent);
    }

    public static Status getStatus(Context context, Intent intent) {
        return zza.getStatus(context, intent);
    }
}
