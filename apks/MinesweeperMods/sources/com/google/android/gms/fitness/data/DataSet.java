package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class DataSet implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zze();
    private final int mVersionCode;
    private final DataType zzavT;
    private final DataSource zzavU;
    private boolean zzawi;
    private final List zzawp;
    private final List zzawq;

    DataSet(int i, DataSource dataSource, DataType dataType, List list, List list2, boolean z) {
        this.zzawi = false;
        this.mVersionCode = i;
        this.zzavU = dataSource;
        this.zzavT = dataSource.getDataType();
        this.zzawi = z;
        this.zzawp = new ArrayList(list.size());
        this.zzawq = i < 2 ? Collections.singletonList(dataSource) : list2;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.zzawp.add(new DataPoint(this.zzawq, (RawDataPoint) it.next()));
        }
    }

    public DataSet(DataSource dataSource) {
        this.zzawi = false;
        this.mVersionCode = 3;
        this.zzavU = (DataSource) zzx.zzz(dataSource);
        this.zzavT = dataSource.getDataType();
        this.zzawp = new ArrayList();
        this.zzawq = new ArrayList();
        this.zzawq.add(this.zzavU);
    }

    public DataSet(RawDataSet rawDataSet, List list) {
        this.zzawi = false;
        this.mVersionCode = 3;
        this.zzavU = (DataSource) zzb(list, rawDataSet.zzaxg);
        this.zzavT = this.zzavU.getDataType();
        this.zzawq = list;
        this.zzawi = rawDataSet.zzawi;
        List list2 = rawDataSet.zzaxj;
        this.zzawp = new ArrayList(list2.size());
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            this.zzawp.add(new DataPoint(this.zzawq, (RawDataPoint) it.next()));
        }
    }

    public static DataSet create(DataSource dataSource) {
        zzx.zzb(dataSource, "DataSource should be specified");
        return new DataSet(dataSource);
    }

    private boolean zza(DataSet dataSet) {
        return zzw.equal(getDataType(), dataSet.getDataType()) && zzw.equal(this.zzavU, dataSet.zzavU) && zzw.equal(this.zzawp, dataSet.zzawp) && this.zzawi == dataSet.zzawi;
    }

    private static Object zzb(List list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public final void add(DataPoint dataPoint) {
        DataSource dataSource = dataPoint.getDataSource();
        zzx.zzb(dataSource.getStreamIdentifier().equals(this.zzavU.getStreamIdentifier()), "Conflicting data sources found %s vs %s", dataSource, this.zzavU);
        dataPoint.zzui();
        zznw.zze(dataPoint);
        zzb(dataPoint);
    }

    public final void addAll(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            add((DataPoint) it.next());
        }
    }

    public final DataPoint createDataPoint() {
        return DataPoint.create(this.zzavU);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataSet) && zza((DataSet) obj));
    }

    public final List getDataPoints() {
        return Collections.unmodifiableList(this.zzawp);
    }

    public final DataSource getDataSource() {
        return this.zzavU;
    }

    public final DataType getDataType() {
        return this.zzavU.getDataType();
    }

    final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zzw.hashCode(this.zzavU);
    }

    public final boolean isEmpty() {
        return this.zzawp.isEmpty();
    }

    public final String toString() {
        List listZzuk = zzuk();
        Object[] objArr = new Object[2];
        objArr[0] = this.zzavU.toDebugString();
        Object obj = listZzuk;
        if (this.zzawp.size() >= 10) {
            obj = String.format("%d data points, first 5: %s", Integer.valueOf(this.zzawp.size()), listZzuk.subList(0, 5));
        }
        objArr[1] = obj;
        return String.format("DataSet{%s %s}", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public final void zzb(DataPoint dataPoint) {
        this.zzawp.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource == null || this.zzawq.contains(originalDataSource)) {
            return;
        }
        this.zzawq.add(originalDataSource);
    }

    public final void zzb(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzb((DataPoint) it.next());
        }
    }

    public final boolean zzuc() {
        return this.zzawi;
    }

    final List zzuk() {
        return zzv(this.zzawq);
    }

    final List zzul() {
        return this.zzawq;
    }

    final List zzv(List list) {
        ArrayList arrayList = new ArrayList(this.zzawp.size());
        Iterator it = this.zzawp.iterator();
        while (it.hasNext()) {
            arrayList.add(new RawDataPoint((DataPoint) it.next(), list));
        }
        return arrayList;
    }
}
