package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class StringToIntConverter implements SafeParcelable, FastJsonResponse.zza {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private final HashMap zzamG;
    private final HashMap zzamH;
    private final ArrayList zzamI;

    public final class Entry implements SafeParcelable {
        public static final zzc CREATOR = new zzc();
        final int versionCode;
        final String zzamJ;
        final int zzamK;

        Entry(int i, String str, int i2) {
            this.versionCode = i;
            this.zzamJ = str;
            this.zzamK = i2;
        }

        Entry(String str, int i) {
            this.versionCode = 1;
            this.zzamJ = str;
            this.zzamK = i;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            zzc zzcVar = CREATOR;
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            zzc zzcVar = CREATOR;
            zzc.zza(this, parcel, i);
        }
    }

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.zzamG = new HashMap();
        this.zzamH = new HashMap();
        this.zzamI = null;
    }

    StringToIntConverter(int i, ArrayList arrayList) {
        this.mVersionCode = i;
        this.zzamG = new HashMap();
        this.zzamH = new HashMap();
        this.zzamI = null;
        zzd(arrayList);
    }

    private void zzd(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzh(entry.zzamJ, entry.zzamK);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb zzbVar = CREATOR;
        zzb.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final String convertBack(Integer num) {
        String str = (String) this.zzamH.get(num);
        return (str == null && this.zzamG.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public final StringToIntConverter zzh(String str, int i) {
        this.zzamG.put(str, Integer.valueOf(i));
        this.zzamH.put(Integer.valueOf(i), str);
        return this;
    }

    final ArrayList zzri() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzamG.keySet()) {
            arrayList.add(new Entry(str, ((Integer) this.zzamG.get(str)).intValue()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    public final int zzrj() {
        return 7;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    public final int zzrk() {
        return 0;
    }
}
