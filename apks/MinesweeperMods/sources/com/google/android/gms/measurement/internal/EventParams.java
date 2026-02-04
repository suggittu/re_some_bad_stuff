package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class EventParams implements SafeParcelable, Iterable {
    public static final zzj CREATOR = new zzj();
    public final int versionCode;
    private final Bundle zzaVS;

    EventParams(int i, Bundle bundle) {
        this.versionCode = i;
        this.zzaVS = bundle;
    }

    EventParams(Bundle bundle) {
        com.google.android.gms.common.internal.zzx.zzz(bundle);
        this.zzaVS = bundle;
        this.versionCode = 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    Object get(String str) {
        return this.zzaVS.get(str);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new Iterator() { // from class: com.google.android.gms.measurement.internal.EventParams.1
            Iterator zzaVT;

            {
                this.zzaVT = EventParams.this.zzaVS.keySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.zzaVT.hasNext();
            }

            @Override // java.util.Iterator
            public String next() {
                return (String) this.zzaVT.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Remove not supported");
            }
        };
    }

    public int size() {
        return this.zzaVS.size();
    }

    public String toString() {
        return this.zzaVS.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public Bundle zzCC() {
        return new Bundle(this.zzaVS);
    }
}
