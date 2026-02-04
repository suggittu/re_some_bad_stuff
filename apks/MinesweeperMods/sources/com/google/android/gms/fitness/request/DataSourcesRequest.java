package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzoi;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class DataSourcesRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzh();
    private final int mVersionCode;
    private final List zzaAV;
    private final boolean zzaAW;
    private final zzoi zzaAX;
    private final List zzawe;

    public class Builder {
        private DataType[] zzaAY = new DataType[0];
        private int[] zzaAZ = {0, 1};
        private boolean zzaAW = false;

        public DataSourcesRequest build() {
            com.google.android.gms.common.internal.zzx.zza(this.zzaAY.length > 0, "Must add at least one data type");
            com.google.android.gms.common.internal.zzx.zza(this.zzaAZ.length > 0, "Must add at least one data source type");
            return new DataSourcesRequest(this);
        }

        public Builder setDataSourceTypes(int... iArr) {
            this.zzaAZ = iArr;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.zzaAY = dataTypeArr;
            return this;
        }
    }

    DataSourcesRequest(int i, List list, List list2, boolean z, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzawe = list;
        this.zzaAV = list2;
        this.zzaAW = z;
        this.zzaAX = zzoi.zza.zzbD(iBinder);
    }

    private DataSourcesRequest(Builder builder) {
        this(zzmn.zzb(builder.zzaAY), Arrays.asList(zzmn.zza(builder.zzaAZ)), builder.zzaAW, null);
    }

    public DataSourcesRequest(DataSourcesRequest dataSourcesRequest, zzoi zzoiVar) {
        this(dataSourcesRequest.zzawe, dataSourcesRequest.zzaAV, dataSourcesRequest.zzaAW, zzoiVar);
    }

    public DataSourcesRequest(List list, List list2, boolean z, zzoi zzoiVar) {
        this.mVersionCode = 4;
        this.zzawe = list;
        this.zzaAV = list2;
        this.zzaAW = z;
        this.zzaAX = zzoiVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAX == null) {
            return null;
        }
        return this.zzaAX.asBinder();
    }

    public List getDataTypes() {
        return this.zzawe;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        zzw.zza zzaVarZzg = com.google.android.gms.common.internal.zzw.zzy(this).zzg("dataTypes", this.zzawe).zzg("sourceTypes", this.zzaAV);
        if (this.zzaAW) {
            zzaVarZzg.zzg("includeDbOnlySources", "true");
        }
        return zzaVarZzg.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public List zzuT() {
        return this.zzaAV;
    }

    public boolean zzuU() {
        return this.zzaAW;
    }
}
