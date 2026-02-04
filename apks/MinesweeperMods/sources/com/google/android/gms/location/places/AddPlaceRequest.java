package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class AddPlaceRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    private final String mName;
    final int mVersionCode;
    private final LatLng zzaPc;
    private final List zzaPd;
    private final String zzaPe;
    private final Uri zzaPf;
    private final String zzawc;

    AddPlaceRequest(int i, String str, LatLng latLng, String str2, List list, String str3, Uri uri) {
        this.mVersionCode = i;
        this.mName = zzx.zzcM(str);
        this.zzaPc = (LatLng) zzx.zzz(latLng);
        this.zzawc = zzx.zzcM(str2);
        this.zzaPd = new ArrayList((Collection) zzx.zzz(list));
        zzx.zzb(!this.zzaPd.isEmpty(), "At least one place type should be provided.");
        zzx.zzb((TextUtils.isEmpty(str3) && uri == null) ? false : true, "One of phone number or URI should be provided.");
        this.zzaPe = str3;
        this.zzaPf = uri;
    }

    public AddPlaceRequest(String str, LatLng latLng, String str2, List list, Uri uri) {
        this(str, latLng, str2, list, null, (Uri) zzx.zzz(uri));
    }

    public AddPlaceRequest(String str, LatLng latLng, String str2, List list, String str3) {
        this(str, latLng, str2, list, zzx.zzcM(str3), null);
    }

    public AddPlaceRequest(String str, LatLng latLng, String str2, List list, String str3, Uri uri) {
        this(0, str, latLng, str2, list, str3, uri);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.zzawc;
    }

    public LatLng getLatLng() {
        return this.zzaPc;
    }

    public String getName() {
        return this.mName;
    }

    @Nullable
    public String getPhoneNumber() {
        return this.zzaPe;
    }

    public List getPlaceTypes() {
        return this.zzaPd;
    }

    @Nullable
    public Uri getWebsiteUri() {
        return this.zzaPf;
    }

    public String toString() {
        return zzw.zzy(this).zzg("name", this.mName).zzg("latLng", this.zzaPc).zzg("address", this.zzawc).zzg("placeTypes", this.zzaPd).zzg("phoneNumer", this.zzaPe).zzg("websiteUri", this.zzaPf).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
