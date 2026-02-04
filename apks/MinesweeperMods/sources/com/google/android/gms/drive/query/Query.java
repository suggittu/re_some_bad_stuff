package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
public class Query implements SafeParcelable {
    public static final Parcelable.Creator CREATOR = new zza();
    final int mVersionCode;
    final List zzapB;
    private final Set zzapC;
    final boolean zzarL;
    final LogicalFilter zzatV;
    final String zzatW;
    final SortOrder zzatX;
    final List zzatY;
    final boolean zzatZ;

    public class Builder {
        private Set zzapC;
        private boolean zzarL;
        private String zzatW;
        private SortOrder zzatX;
        private List zzatY;
        private boolean zzatZ;
        private final List zzaua = new ArrayList();

        public Builder(Query query) {
            this.zzaua.add(query.getFilter());
            this.zzatW = query.getPageToken();
            this.zzatX = query.getSortOrder();
            this.zzatY = query.zztJ();
            this.zzatZ = query.zztK();
            this.zzapC = query.zztL();
            this.zzarL = query.zztM();
        }

        public Builder addFilter(Filter filter) {
            if (!(filter instanceof MatchAllFilter)) {
                this.zzaua.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(new LogicalFilter(Operator.zzauC, this.zzaua), this.zzatW, this.zzatX, this.zzatY, this.zzatZ, this.zzapC, this.zzarL);
        }

        @Deprecated
        public Builder setPageToken(String str) {
            this.zzatW = str;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.zzatX = sortOrder;
            return this;
        }
    }

    private Query(int i, LogicalFilter logicalFilter, String str, SortOrder sortOrder, List list, boolean z, List list2, Set set, boolean z2) {
        this.mVersionCode = i;
        this.zzatV = logicalFilter;
        this.zzatW = str;
        this.zzatX = sortOrder;
        this.zzatY = list;
        this.zzatZ = z;
        this.zzapB = list2;
        this.zzapC = set;
        this.zzarL = z2;
    }

    Query(int i, LogicalFilter logicalFilter, String str, SortOrder sortOrder, List list, boolean z, List list2, boolean z2) {
        this(i, logicalFilter, str, sortOrder, list, z, list2, list2 == null ? null : new HashSet(list2), z2);
    }

    private Query(LogicalFilter logicalFilter, String str, SortOrder sortOrder, List list, boolean z, Set set, boolean z2) {
        this(1, logicalFilter, str, sortOrder, list, z, set == null ? null : new ArrayList(set), set, z2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzatV;
    }

    @Deprecated
    public String getPageToken() {
        return this.zzatW;
    }

    public SortOrder getSortOrder() {
        return this.zzatX;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", this.zzatV, this.zzatX, this.zzatW, this.zzapB);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public List zztJ() {
        return this.zzatY;
    }

    public boolean zztK() {
        return this.zzatZ;
    }

    public Set zztL() {
        return this.zzapC;
    }

    public boolean zztM() {
        return this.zzarL;
    }
}
