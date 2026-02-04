package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;

/* loaded from: classes2.dex */
public final class PlacesOptions implements Api.ApiOptions.Optional {
    public final String zzaPU;
    public final int zzaPV;

    public class Builder {
        private int zzaPV = 0;
        private String zzaPW;

        public PlacesOptions build() {
            return new PlacesOptions(this);
        }
    }

    private PlacesOptions(Builder builder) {
        this.zzaPU = builder.zzaPW;
        this.zzaPV = builder.zzaPV;
    }
}
