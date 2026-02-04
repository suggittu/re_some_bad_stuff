package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class AppVisibleCustomProperties implements SafeParcelable, Iterable {
    public static final Parcelable.Creator CREATOR = new com.google.android.gms.drive.metadata.internal.zza();
    public static final AppVisibleCustomProperties zzasK = new zza().zztA();
    final int mVersionCode;
    final List zzasL;

    public class zza {
        private final Map zzasM = new HashMap();

        public zza zza(CustomPropertyKey customPropertyKey, String str) {
            zzx.zzb(customPropertyKey, "key");
            this.zzasM.put(customPropertyKey, new CustomProperty(customPropertyKey, str));
            return this;
        }

        public zza zza(CustomProperty customProperty) {
            zzx.zzb(customProperty, "property");
            this.zzasM.put(customProperty.zztB(), customProperty);
            return this;
        }

        public AppVisibleCustomProperties zztA() {
            return new AppVisibleCustomProperties(this.zzasM.values());
        }
    }

    AppVisibleCustomProperties(int i, Collection collection) {
        this.mVersionCode = i;
        zzx.zzz(collection);
        this.zzasL = new ArrayList(collection);
    }

    private AppVisibleCustomProperties(Collection collection) {
        this(1, collection);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return zztz().equals(((AppVisibleCustomProperties) obj).zztz());
    }

    public final int hashCode() {
        return zzw.hashCode(this.zzasL);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zzasL.iterator();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.drive.metadata.internal.zza.zza(this, parcel, i);
    }

    public final Map zztz() {
        HashMap map = new HashMap(this.zzasL.size());
        for (CustomProperty customProperty : this.zzasL) {
            map.put(customProperty.zztB(), customProperty.getValue());
        }
        return Collections.unmodifiableMap(map);
    }
}
