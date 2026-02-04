package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzoj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class DataTypeCreateRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzi();
    private final String mName;
    private final int mVersionCode;
    private final zzoj zzaBa;
    private final List zzawE;

    public class Builder {
        private String mName;
        private List zzawE = new ArrayList();

        public Builder addField(Field field) {
            if (!this.zzawE.contains(field)) {
                this.zzawE.add(field);
            }
            return this;
        }

        public Builder addField(String str, int i) {
            com.google.android.gms.common.internal.zzx.zzb((str == null || str.isEmpty()) ? false : true, "Invalid name specified");
            return addField(Field.zzn(str, i));
        }

        public DataTypeCreateRequest build() {
            com.google.android.gms.common.internal.zzx.zza(this.mName != null, "Must set the name");
            com.google.android.gms.common.internal.zzx.zza(this.zzawE.isEmpty() ? false : true, "Must specify the data fields");
            return new DataTypeCreateRequest(this);
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }
    }

    DataTypeCreateRequest(int i, String str, List list, IBinder iBinder) {
        this.mVersionCode = i;
        this.mName = str;
        this.zzawE = Collections.unmodifiableList(list);
        this.zzaBa = zzoj.zza.zzbE(iBinder);
    }

    private DataTypeCreateRequest(Builder builder) {
        this(builder.mName, builder.zzawE, null);
    }

    public DataTypeCreateRequest(DataTypeCreateRequest dataTypeCreateRequest, zzoj zzojVar) {
        this(dataTypeCreateRequest.mName, dataTypeCreateRequest.zzawE, zzojVar);
    }

    public DataTypeCreateRequest(String str, List list, zzoj zzojVar) {
        this.mVersionCode = 3;
        this.mName = str;
        this.zzawE = Collections.unmodifiableList(list);
        this.zzaBa = zzojVar;
    }

    private boolean zzb(DataTypeCreateRequest dataTypeCreateRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.mName, dataTypeCreateRequest.mName) && com.google.android.gms.common.internal.zzw.equal(this.zzawE, dataTypeCreateRequest.zzawE);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataTypeCreateRequest) && zzb((DataTypeCreateRequest) obj));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaBa == null) {
            return null;
        }
        return this.zzaBa.asBinder();
    }

    public List getFields() {
        return this.zzawE;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.mName, this.zzawE);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg("name", this.mName).zzg("fields", this.zzawE).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
