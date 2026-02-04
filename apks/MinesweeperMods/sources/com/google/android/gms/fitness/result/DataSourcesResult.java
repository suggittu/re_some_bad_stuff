package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class DataSourcesResult implements Result, SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zze();
    private final int mVersionCode;
    private final Status zzUX;
    private final List zzaAF;

    DataSourcesResult(int i, List list, Status status) {
        this.mVersionCode = i;
        this.zzaAF = Collections.unmodifiableList(list);
        this.zzUX = status;
    }

    public DataSourcesResult(List list, Status status) {
        this.mVersionCode = 3;
        this.zzaAF = Collections.unmodifiableList(list);
        this.zzUX = status;
    }

    public static DataSourcesResult zzR(Status status) {
        return new DataSourcesResult(Collections.emptyList(), status);
    }

    private boolean zzb(DataSourcesResult dataSourcesResult) {
        return this.zzUX.equals(dataSourcesResult.zzUX) && zzw.equal(this.zzaAF, dataSourcesResult.zzaAF);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataSourcesResult) && zzb((DataSourcesResult) obj));
    }

    public List getDataSources() {
        return this.zzaAF;
    }

    public List getDataSources(DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (DataSource dataSource : this.zzaAF) {
            if (dataSource.getDataType().equals(dataType)) {
                arrayList.add(dataSource);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzaAF);
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", this.zzUX).zzg("dataSets", this.zzaAF).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
