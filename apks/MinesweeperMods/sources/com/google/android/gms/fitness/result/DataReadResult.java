package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class DataReadResult implements Result, SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzc();
    private final int mVersionCode;
    private final Status zzUX;
    private final List zzaBF;
    private int zzaBG;
    private final List zzaBH;
    private final List zzawg;
    private final List zzawq;

    DataReadResult(int i, List list, Status status, List list2, int i2, List list3, List list4) {
        this.mVersionCode = i;
        this.zzUX = status;
        this.zzaBG = i2;
        this.zzawq = list3;
        this.zzaBH = list4;
        this.zzawg = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.zzawg.add(new DataSet((RawDataSet) it.next(), list3));
        }
        this.zzaBF = new ArrayList(list2.size());
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.zzaBF.add(new Bucket((RawBucket) it2.next(), list3));
        }
    }

    public DataReadResult(List list, List list2, Status status) {
        this.mVersionCode = 5;
        this.zzawg = list;
        this.zzUX = status;
        this.zzaBF = list2;
        this.zzaBG = 1;
        this.zzawq = new ArrayList();
        this.zzaBH = new ArrayList();
    }

    public static DataReadResult zza(Status status, DataReadRequest dataReadRequest) {
        ArrayList arrayList = new ArrayList();
        Iterator it = dataReadRequest.getDataSources().iterator();
        while (it.hasNext()) {
            arrayList.add(DataSet.create((DataSource) it.next()));
        }
        Iterator it2 = dataReadRequest.getDataTypes().iterator();
        while (it2.hasNext()) {
            arrayList.add(DataSet.create(new DataSource.Builder().setDataType((DataType) it2.next()).setType(1).setName("Default").build()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    private void zza(Bucket bucket, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Bucket bucket2 = (Bucket) it.next();
            if (bucket2.zzb(bucket)) {
                Iterator it2 = bucket.getDataSets().iterator();
                while (it2.hasNext()) {
                    zza((DataSet) it2.next(), bucket2.getDataSets());
                }
                return;
            }
        }
        this.zzaBF.add(bucket);
    }

    private void zza(DataSet dataSet, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DataSet dataSet2 = (DataSet) it.next();
            if (dataSet2.getDataSource().equals(dataSet.getDataSource())) {
                dataSet2.zzb(dataSet.getDataPoints());
                return;
            }
        }
        list.add(dataSet);
    }

    private boolean zzc(DataReadResult dataReadResult) {
        return this.zzUX.equals(dataReadResult.zzUX) && zzw.equal(this.zzawg, dataReadResult.zzawg) && zzw.equal(this.zzaBF, dataReadResult.zzaBF);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataReadResult) && zzc((DataReadResult) obj));
    }

    public List getBuckets() {
        return this.zzaBF;
    }

    public DataSet getDataSet(DataSource dataSource) {
        for (DataSet dataSet : this.zzawg) {
            if (dataSource.equals(dataSet.getDataSource())) {
                return dataSet;
            }
        }
        return DataSet.create(dataSource);
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzawg) {
            if (dataType.equals(dataSet.getDataType())) {
                return dataSet;
            }
        }
        return DataSet.create(new DataSource.Builder().setDataType(dataType).setType(1).build());
    }

    public List getDataSets() {
        return this.zzawg;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzawg, this.zzaBF);
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", this.zzUX).zzg("dataSets", this.zzawg.size() > 5 ? this.zzawg.size() + " data sets" : this.zzawg).zzg("buckets", this.zzaBF.size() > 5 ? this.zzaBF.size() + " buckets" : this.zzaBF).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public void zzb(DataReadResult dataReadResult) {
        Iterator it = dataReadResult.getDataSets().iterator();
        while (it.hasNext()) {
            zza((DataSet) it.next(), this.zzawg);
        }
        Iterator it2 = dataReadResult.getBuckets().iterator();
        while (it2.hasNext()) {
            zza((Bucket) it2.next(), this.zzaBF);
        }
    }

    List zzul() {
        return this.zzawq;
    }

    public int zzvj() {
        return this.zzaBG;
    }

    List zzvk() {
        ArrayList arrayList = new ArrayList(this.zzaBF.size());
        Iterator it = this.zzaBF.iterator();
        while (it.hasNext()) {
            arrayList.add(new RawBucket((Bucket) it.next(), this.zzawq, this.zzaBH));
        }
        return arrayList;
    }

    List zzvl() {
        ArrayList arrayList = new ArrayList(this.zzawg.size());
        Iterator it = this.zzawg.iterator();
        while (it.hasNext()) {
            arrayList.add(new RawDataSet((DataSet) it.next(), this.zzawq, this.zzaBH));
        }
        return arrayList;
    }

    List zzvm() {
        return this.zzaBH;
    }
}
