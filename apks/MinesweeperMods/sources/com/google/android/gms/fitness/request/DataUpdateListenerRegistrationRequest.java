package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzow;

/* loaded from: classes2.dex */
public class DataUpdateListenerRegistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzk();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzow zzaAD;
    private DataType zzavT;
    private DataSource zzavU;

    public class Builder {
        private PendingIntent mPendingIntent;
        private DataType zzavT;
        private DataSource zzavU;

        public DataUpdateListenerRegistrationRequest build() {
            com.google.android.gms.common.internal.zzx.zza((this.zzavU == null && this.zzavT == null) ? false : true, "Set either dataSource or dataTYpe");
            com.google.android.gms.common.internal.zzx.zzb(this.mPendingIntent, "pendingIntent must be set");
            return new DataUpdateListenerRegistrationRequest(this);
        }

        public Builder setDataSource(DataSource dataSource) {
            com.google.android.gms.common.internal.zzx.zzz(dataSource);
            this.zzavU = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            com.google.android.gms.common.internal.zzx.zzz(dataType);
            this.zzavT = dataType;
            return this;
        }

        public Builder setPendingIntent(PendingIntent pendingIntent) {
            com.google.android.gms.common.internal.zzx.zzz(pendingIntent);
            this.mPendingIntent = pendingIntent;
            return this;
        }
    }

    DataUpdateListenerRegistrationRequest(int i, DataSource dataSource, DataType dataType, PendingIntent pendingIntent, IBinder iBinder) {
        this.mVersionCode = i;
        this.zzavU = dataSource;
        this.zzavT = dataType;
        this.mPendingIntent = pendingIntent;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    public DataUpdateListenerRegistrationRequest(DataSource dataSource, DataType dataType, PendingIntent pendingIntent, IBinder iBinder) {
        this.mVersionCode = 1;
        this.zzavU = dataSource;
        this.zzavT = dataType;
        this.mPendingIntent = pendingIntent;
        this.zzaAD = zzow.zza.zzbR(iBinder);
    }

    private DataUpdateListenerRegistrationRequest(Builder builder) {
        this(builder.zzavU, builder.zzavT, builder.mPendingIntent, null);
    }

    private boolean zzb(DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.zzavU, dataUpdateListenerRegistrationRequest.zzavU) && com.google.android.gms.common.internal.zzw.equal(this.zzavT, dataUpdateListenerRegistrationRequest.zzavT) && com.google.android.gms.common.internal.zzw.equal(this.mPendingIntent, dataUpdateListenerRegistrationRequest.mPendingIntent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataUpdateListenerRegistrationRequest) && zzb((DataUpdateListenerRegistrationRequest) obj));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public DataSource getDataSource() {
        return this.zzavU;
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.zzavU, this.zzavT, this.mPendingIntent);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg("dataSource", this.zzavU).zzg("dataType", this.zzavT).zzg("pendingIntent", this.mPendingIntent).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
