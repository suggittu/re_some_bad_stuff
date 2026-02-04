package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.PopupManager;

/* loaded from: classes2.dex */
public final class PopupLocationInfoParcelable implements SafeParcelable {
    public static final PopupLocationInfoParcelableCreator CREATOR = new PopupLocationInfoParcelableCreator();
    private final int mVersionCode;
    private final Bundle zzaFH;
    private final IBinder zzaFI;

    PopupLocationInfoParcelable(int i, Bundle bundle, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzaFH = bundle;
        this.zzaFI = iBinder;
    }

    public PopupLocationInfoParcelable(PopupManager.PopupLocationInfo popupLocationInfo) {
        this.mVersionCode = 1;
        this.zzaFH = popupLocationInfo.zzxg();
        this.zzaFI = popupLocationInfo.zzaFL;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    public final IBinder getWindowToken() {
        return this.zzaFI;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        PopupLocationInfoParcelableCreator.zza(this, parcel, i);
    }

    public final Bundle zzxg() {
        return this.zzaFH;
    }
}
