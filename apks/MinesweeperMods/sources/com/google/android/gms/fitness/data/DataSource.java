package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public class DataSource implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzf();
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW = 0;
    private final String mName;
    private final int mVersionCode;
    private final int zzabB;
    private final DataType zzavT;
    private final Device zzawr;
    private final Application zzaws;
    private final String zzawt;
    private final String zzawu;

    public final class Builder {
        private String mName;
        private DataType zzavT;
        private Device zzawr;
        private Application zzaws;
        private int zzabB = -1;
        private String zzawt = "";

        public final DataSource build() {
            zzx.zza(this.zzavT != null, "Must set data type");
            zzx.zza(this.zzabB >= 0, "Must set data source type");
            return new DataSource(this);
        }

        public final Builder setAppPackageName(Context context) {
            return setAppPackageName(context.getPackageName());
        }

        public final Builder setAppPackageName(String str) {
            this.zzaws = Application.zzdn(str);
            return this;
        }

        public final Builder setDataType(DataType dataType) {
            this.zzavT = dataType;
            return this;
        }

        public final Builder setDevice(Device device) {
            this.zzawr = device;
            return this;
        }

        public final Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public final Builder setStreamName(String str) {
            zzx.zzb(str != null, "Must specify a valid stream name");
            this.zzawt = str;
            return this;
        }

        public final Builder setType(int i) {
            this.zzabB = i;
            return this;
        }
    }

    DataSource(int i, DataType dataType, String str, int i2, Device device, Application application, String str2) {
        this.mVersionCode = i;
        this.zzavT = dataType;
        this.zzabB = i2;
        this.mName = str;
        this.zzawr = device;
        this.zzaws = application;
        this.zzawt = str2;
        this.zzawu = zzun();
    }

    private DataSource(Builder builder) {
        this.mVersionCode = 3;
        this.zzavT = builder.zzavT;
        this.zzabB = builder.zzabB;
        this.mName = builder.mName;
        this.zzawr = builder.zzawr;
        this.zzaws = builder.zzaws;
        this.zzawt = builder.zzawt;
        this.zzawu = zzun();
    }

    public static DataSource extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (DataSource) com.google.android.gms.common.internal.safeparcel.zzc.zza(intent, EXTRA_DATA_SOURCE, CREATOR);
    }

    private String getTypeString() {
        switch (this.zzabB) {
            case 0:
                return "raw";
            case 1:
                return "derived";
            default:
                throw new IllegalArgumentException("invalid type value");
        }
    }

    private boolean zza(DataSource dataSource) {
        return this.zzawu.equals(dataSource.zzawu);
    }

    private String zzun() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTypeString());
        sb.append(":").append(this.zzavT.getName());
        if (this.zzaws != null) {
            sb.append(":").append(this.zzaws.getPackageName());
        }
        if (this.zzawr != null) {
            sb.append(":").append(this.zzawr.getStreamIdentifier());
        }
        if (this.zzawt != null) {
            sb.append(":").append(this.zzawt);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataSource) && zza((DataSource) obj));
    }

    public String getAppPackageName() {
        if (this.zzaws == null) {
            return null;
        }
        return this.zzaws.getPackageName();
    }

    public DataType getDataType() {
        return this.zzavT;
    }

    public Device getDevice() {
        return this.zzawr;
    }

    public String getName() {
        return this.mName;
    }

    public String getStreamIdentifier() {
        return this.zzawu;
    }

    public String getStreamName() {
        return this.zzawt;
    }

    public int getType() {
        return this.zzabB;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return this.zzawu.hashCode();
    }

    public String toDebugString() {
        return (this.zzabB == 0 ? "r" : "d") + ":" + this.zzavT.zzuo() + (this.zzaws == null ? "" : this.zzaws.equals(Application.zzawa) ? ":gms" : ":" + this.zzaws.getPackageName()) + (this.zzawr != null ? ":" + this.zzawr.getModel() + ":" + this.zzawr.getUid() : "") + (this.zzawt != null ? ":" + this.zzawt : "");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataSource{");
        sb.append(getTypeString());
        if (this.mName != null) {
            sb.append(":").append(this.mName);
        }
        if (this.zzaws != null) {
            sb.append(":").append(this.zzaws);
        }
        if (this.zzawr != null) {
            sb.append(":").append(this.zzawr);
        }
        if (this.zzawt != null) {
            sb.append(":").append(this.zzawt);
        }
        sb.append(":").append(this.zzavT);
        return sb.append("}").toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public Application zzum() {
        return this.zzaws;
    }
}
