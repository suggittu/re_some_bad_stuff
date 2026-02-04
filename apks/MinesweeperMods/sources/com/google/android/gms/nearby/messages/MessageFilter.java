package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class MessageFilter implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    public static final MessageFilter INCLUDE_ALL_MY_TYPES = new Builder().includeAllMyTypes().build();
    final int mVersionCode;
    private final List zzbbB;
    private final List zzbbC;
    private final boolean zzbbD;

    public final class Builder {
        private boolean zzbbD;
        private final List zzbbE = new ArrayList();
        private final List zzbbC = new ArrayList();

        private Builder zzS(String str, String str2) {
            this.zzbbE.add(new MessageType(str, str2));
            return this;
        }

        public final MessageFilter build() {
            zzx.zza(this.zzbbD || !this.zzbbE.isEmpty(), "At least one of the include methods must be called.");
            return new MessageFilter(this.zzbbE, this.zzbbC, this.zzbbD);
        }

        public final Builder includeAllMyTypes() {
            this.zzbbD = true;
            return this;
        }

        public final Builder includeFilter(MessageFilter messageFilter) {
            this.zzbbE.addAll(messageFilter.zzEo());
            this.zzbbC.addAll(messageFilter.zzEq());
            this.zzbbD |= messageFilter.zzEp();
            return this;
        }

        public final Builder includeNamespacedType(String str, String str2) {
            zzx.zzb((str == null || str.isEmpty() || str.contains("*")) ? false : true, "namespace(%s) cannot be null, empty or contain (*).", str);
            zzx.zzb((str2 == null || str2.contains("*")) ? false : true, "type(%s) cannot be null or contain (*).", str2);
            return zzS(str, str2);
        }
    }

    MessageFilter(int i, List list, List list2, boolean z) {
        this.mVersionCode = i;
        this.zzbbB = Collections.unmodifiableList((List) zzx.zzz(list));
        this.zzbbD = z;
        this.zzbbC = Collections.unmodifiableList(list2 == null ? Collections.emptyList() : list2);
    }

    private MessageFilter(List list, List list2, boolean z) {
        this(1, list, list2, z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageFilter)) {
            return false;
        }
        MessageFilter messageFilter = (MessageFilter) obj;
        return this.zzbbD == messageFilter.zzbbD && zzw.equal(this.zzbbB, messageFilter.zzbbB) && zzw.equal(this.zzbbC, messageFilter.zzbbC);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbbB, this.zzbbC, Boolean.valueOf(this.zzbbD));
    }

    public String toString() {
        return "MessageFilter{includeAllMyTypes=" + this.zzbbD + ", messageTypes=" + this.zzbbB + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    List zzEo() {
        return this.zzbbB;
    }

    boolean zzEp() {
        return this.zzbbD;
    }

    List zzEq() {
        return this.zzbbC;
    }
}
