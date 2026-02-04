package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zza;
import com.google.android.gms.fitness.request.zzq;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzow;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class StartBleScanRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzad();
    private final int mVersionCode;
    private final zzow zzaAD;
    private final zzq zzaBA;
    private final int zzaBB;
    private final List zzawe;

    public class Builder {
        private zzq zzaBA;
        private DataType[] zzaAY = new DataType[0];
        private int zzaBB = 10;

        public StartBleScanRequest build() {
            com.google.android.gms.common.internal.zzx.zza(this.zzaBA != null, "Must set BleScanCallback");
            return new StartBleScanRequest(this);
        }

        public Builder setBleScanCallback(BleScanCallback bleScanCallback) {
            zza(zza.C0068zza.zzuJ().zza(bleScanCallback));
            return this;
        }

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.zzaAY = dataTypeArr;
            return this;
        }

        public Builder setTimeoutSecs(int i) {
            com.google.android.gms.common.internal.zzx.zzb(i > 0, "Stop time must be greater than zero");
            com.google.android.gms.common.internal.zzx.zzb(i <= 60, "Stop time must be less than 1 minute");
            this.zzaBB = i;
            return this;
        }

        public Builder zza(zzq zzqVar) {
            this.zzaBA = zzqVar;
            return this;
        }
    }

    StartBleScanRequest(int i, List list, IBinder iBinder, int i2, IBinder iBinder2) {
        this.mVersionCode = i;
        this.zzawe = list;
        this.zzaBA = zzq.zza.zzbU(iBinder);
        this.zzaBB = i2;
        this.zzaAD = zzow.zza.zzbR(iBinder2);
    }

    private StartBleScanRequest(Builder builder) {
        this(zzmn.zzb(builder.zzaAY), builder.zzaBA, builder.zzaBB, null);
    }

    public StartBleScanRequest(StartBleScanRequest startBleScanRequest, zzow zzowVar) {
        this(startBleScanRequest.zzawe, startBleScanRequest.zzaBA, startBleScanRequest.zzaBB, zzowVar);
    }

    public StartBleScanRequest(List list, zzq zzqVar, int i, zzow zzowVar) {
        this.mVersionCode = 4;
        this.zzawe = list;
        this.zzaBA = zzqVar;
        this.zzaBB = i;
        this.zzaAD = zzowVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public List getDataTypes() {
        return Collections.unmodifiableList(this.zzawe);
    }

    public int getTimeoutSecs() {
        return this.zzaBB;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg("dataTypes", this.zzawe).zzg("timeoutSecs", Integer.valueOf(this.zzaBB)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzad.zza(this, parcel, i);
    }

    public IBinder zzvg() {
        return this.zzaBA.asBinder();
    }
}
