package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class ListSubscriptionsResult implements Result, SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzh();
    private final int mVersionCode;
    private final Status zzUX;
    private final List zzaBM;

    ListSubscriptionsResult(int i, List list, Status status) {
        this.mVersionCode = i;
        this.zzaBM = list;
        this.zzUX = status;
    }

    public ListSubscriptionsResult(List list, Status status) {
        this.mVersionCode = 3;
        this.zzaBM = Collections.unmodifiableList(list);
        this.zzUX = (Status) zzx.zzb(status, "status");
    }

    public static ListSubscriptionsResult zzT(Status status) {
        return new ListSubscriptionsResult(Collections.emptyList(), status);
    }

    private boolean zzb(ListSubscriptionsResult listSubscriptionsResult) {
        return this.zzUX.equals(listSubscriptionsResult.zzUX) && zzw.equal(this.zzaBM, listSubscriptionsResult.zzaBM);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ListSubscriptionsResult) && zzb((ListSubscriptionsResult) obj));
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    public List getSubscriptions() {
        return this.zzaBM;
    }

    public List getSubscriptions(DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (Subscription subscription : this.zzaBM) {
            if (dataType.equals(subscription.zzuy())) {
                arrayList.add(subscription);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, this.zzaBM);
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", this.zzUX).zzg("subscriptions", this.zzaBM).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
