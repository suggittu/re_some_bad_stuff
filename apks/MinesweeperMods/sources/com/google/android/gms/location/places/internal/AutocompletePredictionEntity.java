package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class AutocompletePredictionEntity implements SafeParcelable, AutocompletePrediction {
    public static final Parcelable.Creator CREATOR = new zza();
    private static final List zzaQc = Collections.emptyList();
    final int mVersionCode;
    final String zzaPH;
    final List zzaPd;
    final String zzaQd;
    final List zzaQe;
    final int zzaQf;
    final String zzaQg;
    final List zzaQh;
    final String zzaQi;
    final List zzaQj;

    public class SubstringEntity implements SafeParcelable, AutocompletePrediction.Substring {
        public static final Parcelable.Creator CREATOR = new zzu();
        final int mLength;
        final int mOffset;
        final int mVersionCode;

        public SubstringEntity(int i, int i2, int i3) {
            this.mVersionCode = i;
            this.mOffset = i2;
            this.mLength = i3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubstringEntity)) {
                return false;
            }
            SubstringEntity substringEntity = (SubstringEntity) obj;
            return zzw.equal(Integer.valueOf(this.mOffset), Integer.valueOf(substringEntity.mOffset)) && zzw.equal(Integer.valueOf(this.mLength), Integer.valueOf(substringEntity.mLength));
        }

        @Override // com.google.android.gms.location.places.AutocompletePrediction.Substring
        public int getLength() {
            return this.mLength;
        }

        @Override // com.google.android.gms.location.places.AutocompletePrediction.Substring
        public int getOffset() {
            return this.mOffset;
        }

        public int hashCode() {
            return zzw.hashCode(Integer.valueOf(this.mOffset), Integer.valueOf(this.mLength));
        }

        public String toString() {
            return zzw.zzy(this).zzg("offset", Integer.valueOf(this.mOffset)).zzg("length", Integer.valueOf(this.mLength)).toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzu.zza(this, parcel, i);
        }
    }

    AutocompletePredictionEntity(int i, String str, List list, int i2, String str2, List list2, String str3, List list3, String str4, List list4) {
        this.mVersionCode = i;
        this.zzaPH = str;
        this.zzaPd = list;
        this.zzaQf = i2;
        this.zzaQd = str2;
        this.zzaQe = list2;
        this.zzaQg = str3;
        this.zzaQh = list3;
        this.zzaQi = str4;
        this.zzaQj = list4;
    }

    public static AutocompletePredictionEntity zza(String str, List list, int i, String str2, List list2, String str3, List list3, String str4, List list4) {
        return new AutocompletePredictionEntity(0, str, list, i, (String) zzx.zzz(str2), list2, str3, list3, str4, list4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompletePredictionEntity)) {
            return false;
        }
        AutocompletePredictionEntity autocompletePredictionEntity = (AutocompletePredictionEntity) obj;
        return zzw.equal(this.zzaPH, autocompletePredictionEntity.zzaPH) && zzw.equal(this.zzaPd, autocompletePredictionEntity.zzaPd) && zzw.equal(Integer.valueOf(this.zzaQf), Integer.valueOf(autocompletePredictionEntity.zzaQf)) && zzw.equal(this.zzaQd, autocompletePredictionEntity.zzaQd) && zzw.equal(this.zzaQe, autocompletePredictionEntity.zzaQe) && zzw.equal(this.zzaQg, autocompletePredictionEntity.zzaQg) && zzw.equal(this.zzaQh, autocompletePredictionEntity.zzaQh) && zzw.equal(this.zzaQi, autocompletePredictionEntity.zzaQi) && zzw.equal(this.zzaQj, autocompletePredictionEntity.zzaQj);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public String getDescription() {
        return this.zzaQd;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public CharSequence getFullText(@Nullable CharacterStyle characterStyle) {
        return zzc.zza(this.zzaQd, this.zzaQe, characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public List getMatchedSubstrings() {
        return this.zzaQe;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    @Nullable
    public String getPlaceId() {
        return this.zzaPH;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public List getPlaceTypes() {
        return this.zzaPd;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public CharSequence getPrimaryText(@Nullable CharacterStyle characterStyle) {
        return zzc.zza(this.zzaQg, this.zzaQh, characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public CharSequence getSecondaryText(@Nullable CharacterStyle characterStyle) {
        return zzc.zza(this.zzaQi, this.zzaQj, characterStyle);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaPH, this.zzaPd, Integer.valueOf(this.zzaQf), this.zzaQd, this.zzaQe, this.zzaQg, this.zzaQh, this.zzaQi, this.zzaQj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzw.zzy(this).zzg("placeId", this.zzaPH).zzg("placeTypes", this.zzaPd).zzg("fullText", this.zzaQd).zzg("fullTextMatchedSubstrings", this.zzaQe).zzg("primaryText", this.zzaQg).zzg("primaryTextMatchedSubstrings", this.zzaQh).zzg("secondaryText", this.zzaQi).zzg("secondaryTextMatchedSubstrings", this.zzaQj).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzzf, reason: merged with bridge method [inline-methods] */
    public AutocompletePrediction freeze() {
        return this;
    }
}
