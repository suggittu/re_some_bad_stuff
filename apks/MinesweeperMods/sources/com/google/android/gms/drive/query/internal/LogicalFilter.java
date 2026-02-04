package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class LogicalFilter extends AbstractFilter {
    public static final Parcelable.Creator CREATOR = new zzk();
    final int mVersionCode;
    private List zzaua;
    final Operator zzaug;
    final List zzauv;

    LogicalFilter(int i, Operator operator, List list) {
        this.mVersionCode = i;
        this.zzaug = operator;
        this.zzauv = list;
    }

    public LogicalFilter(Operator operator, Filter filter, Filter... filterArr) {
        this.mVersionCode = 1;
        this.zzaug = operator;
        this.zzauv = new ArrayList(filterArr.length + 1);
        this.zzauv.add(new FilterHolder(filter));
        this.zzaua = new ArrayList(filterArr.length + 1);
        this.zzaua.add(filter);
        for (Filter filter2 : filterArr) {
            this.zzauv.add(new FilterHolder(filter2));
            this.zzaua.add(filter2);
        }
    }

    public LogicalFilter(Operator operator, Iterable iterable) {
        this.mVersionCode = 1;
        this.zzaug = operator;
        this.zzaua = new ArrayList();
        this.zzauv = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Filter filter = (Filter) it.next();
            this.zzaua.add(filter);
            this.zzauv.add(new FilterHolder(filter));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public Object zza(zzf zzfVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.zzauv.iterator();
        while (it.hasNext()) {
            arrayList.add(((FilterHolder) it.next()).getFilter().zza(zzfVar));
        }
        return zzfVar.zzb(this.zzaug, arrayList);
    }
}
