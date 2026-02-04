package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes2.dex */
public final class NotifyTransactionStatusRequest implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzn();
    final int mVersionCode;
    int status;
    String zzboo;
    String zzbpz;

    public final class Builder {
        private Builder() {
        }

        public final NotifyTransactionStatusRequest build() {
            zzx.zzb(!TextUtils.isEmpty(NotifyTransactionStatusRequest.this.zzboo), "googleTransactionId is required");
            zzx.zzb(NotifyTransactionStatusRequest.this.status > 0 && NotifyTransactionStatusRequest.this.status <= 8, "status is an unrecognized value");
            return NotifyTransactionStatusRequest.this;
        }

        public final Builder setDetailedReason(String str) {
            NotifyTransactionStatusRequest.this.zzbpz = str;
            return this;
        }

        public final Builder setGoogleTransactionId(String str) {
            NotifyTransactionStatusRequest.this.zzboo = str;
            return this;
        }

        public final Builder setStatus(int i) {
            NotifyTransactionStatusRequest.this.status = i;
            return this;
        }
    }

    public interface Status {
        public static final int SUCCESS = 1;

        public interface Error {
            public static final int AVS_DECLINE = 7;
            public static final int BAD_CARD = 4;
            public static final int BAD_CVC = 3;
            public static final int DECLINED = 5;
            public static final int FRAUD_DECLINE = 8;
            public static final int OTHER = 6;
            public static final int UNKNOWN = 2;
        }
    }

    NotifyTransactionStatusRequest() {
        this.mVersionCode = 1;
    }

    NotifyTransactionStatusRequest(int i, String str, int i2, String str2) {
        this.mVersionCode = i;
        this.zzboo = str;
        this.status = i2;
        this.zzbpz = str2;
    }

    public static Builder newBuilder() {
        NotifyTransactionStatusRequest notifyTransactionStatusRequest = new NotifyTransactionStatusRequest();
        notifyTransactionStatusRequest.getClass();
        return new Builder();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getDetailedReason() {
        return this.zzbpz;
    }

    public final String getGoogleTransactionId() {
        return this.zzboo;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }
}
