package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zznm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class MetadataBundle implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzh();
    final int mVersionCode;
    final Bundle zzasQ;

    MetadataBundle(int i, Bundle bundle) {
        this.mVersionCode = i;
        this.zzasQ = (Bundle) zzx.zzz(bundle);
        this.zzasQ.setClassLoader(getClass().getClassLoader());
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzasQ.keySet()) {
            if (zze.zzdc(str) == null) {
                arrayList.add(str);
                zzz.zzz("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.zzasQ.remove((String) it.next());
        }
    }

    private MetadataBundle(Bundle bundle) {
        this(1, bundle);
    }

    public static MetadataBundle zzb(MetadataField metadataField, Object obj) {
        MetadataBundle metadataBundleZztE = zztE();
        metadataBundleZztE.zzc(metadataField, obj);
        return metadataBundleZztE;
    }

    public static MetadataBundle zztE() {
        return new MetadataBundle(new Bundle());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> setKeySet = this.zzasQ.keySet();
        if (!setKeySet.equals(metadataBundle.zzasQ.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            if (!zzw.equal(this.zzasQ.get(str), metadataBundle.zzasQ.get(str))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = 1;
        Iterator<String> it = this.zzasQ.keySet().iterator();
        while (true) {
            int i = iHashCode;
            if (!it.hasNext()) {
                return i;
            }
            iHashCode = this.zzasQ.get(it.next()).hashCode() + (i * 31);
        }
    }

    public final void setContext(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zznm.zzatz);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.zzc(context.getCacheDir());
        }
    }

    public final String toString() {
        return "MetadataBundle [values=" + this.zzasQ + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public final Object zza(MetadataField metadataField) {
        return metadataField.zzm(this.zzasQ);
    }

    public final void zzc(MetadataField metadataField, Object obj) {
        if (zze.zzdc(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.zza(obj, this.zzasQ);
    }

    public final boolean zzc(MetadataField metadataField) {
        return this.zzasQ.containsKey(metadataField.getName());
    }

    public final MetadataBundle zztF() {
        return new MetadataBundle(new Bundle(this.zzasQ));
    }

    public final Set zztG() {
        HashSet hashSet = new HashSet();
        Iterator<String> it = this.zzasQ.keySet().iterator();
        while (it.hasNext()) {
            hashSet.add(zze.zzdc(it.next()));
        }
        return hashSet;
    }
}
