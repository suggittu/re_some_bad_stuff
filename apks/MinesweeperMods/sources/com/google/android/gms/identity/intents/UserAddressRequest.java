package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class UserAddressRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zza();
    private final int mVersionCode;
    List zzaMA;

    public final class Builder {
        private Builder() {
        }

        public final Builder addAllowedCountrySpecification(CountrySpecification countrySpecification) {
            if (UserAddressRequest.this.zzaMA == null) {
                UserAddressRequest.this.zzaMA = new ArrayList();
            }
            UserAddressRequest.this.zzaMA.add(countrySpecification);
            return this;
        }

        public final Builder addAllowedCountrySpecifications(Collection collection) {
            if (UserAddressRequest.this.zzaMA == null) {
                UserAddressRequest.this.zzaMA = new ArrayList();
            }
            UserAddressRequest.this.zzaMA.addAll(collection);
            return this;
        }

        public final UserAddressRequest build() {
            if (UserAddressRequest.this.zzaMA != null) {
                UserAddressRequest.this.zzaMA = Collections.unmodifiableList(UserAddressRequest.this.zzaMA);
            }
            return UserAddressRequest.this;
        }
    }

    UserAddressRequest() {
        this.mVersionCode = 1;
    }

    UserAddressRequest(int i, List list) {
        this.mVersionCode = i;
        this.zzaMA = list;
    }

    public static Builder newBuilder() {
        UserAddressRequest userAddressRequest = new UserAddressRequest();
        userAddressRequest.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
