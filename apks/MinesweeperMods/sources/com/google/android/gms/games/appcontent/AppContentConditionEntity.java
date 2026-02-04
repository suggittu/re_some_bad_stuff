package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes2.dex */
public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
    public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
    private final int mVersionCode;
    private final String zzaDJ;
    private final String zzaDK;
    private final String zzaDL;
    private final Bundle zzaDM;

    AppContentConditionEntity(int i, String str, String str2, String str3, Bundle bundle) {
        this.mVersionCode = i;
        this.zzaDJ = str;
        this.zzaDK = str2;
        this.zzaDL = str3;
        this.zzaDM = bundle;
    }

    public AppContentConditionEntity(AppContentCondition appContentCondition) {
        this.mVersionCode = 1;
        this.zzaDJ = appContentCondition.zzwf();
        this.zzaDK = appContentCondition.zzwg();
        this.zzaDL = appContentCondition.zzwh();
        this.zzaDM = appContentCondition.zzwi();
    }

    static int zza(AppContentCondition appContentCondition) {
        return zzw.hashCode(appContentCondition.zzwf(), appContentCondition.zzwg(), appContentCondition.zzwh(), appContentCondition.zzwi());
    }

    static boolean zza(AppContentCondition appContentCondition, Object obj) {
        if (!(obj instanceof AppContentCondition)) {
            return false;
        }
        if (appContentCondition == obj) {
            return true;
        }
        AppContentCondition appContentCondition2 = (AppContentCondition) obj;
        return zzw.equal(appContentCondition2.zzwf(), appContentCondition.zzwf()) && zzw.equal(appContentCondition2.zzwg(), appContentCondition.zzwg()) && zzw.equal(appContentCondition2.zzwh(), appContentCondition.zzwh()) && zzw.equal(appContentCondition2.zzwi(), appContentCondition.zzwi());
    }

    static String zzb(AppContentCondition appContentCondition) {
        return zzw.zzy(appContentCondition).zzg("DefaultValue", appContentCondition.zzwf()).zzg("ExpectedValue", appContentCondition.zzwg()).zzg("Predicate", appContentCondition.zzwh()).zzg("PredicateParameters", appContentCondition.zzwi()).toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzb(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        AppContentConditionEntityCreator.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public final String zzwf() {
        return this.zzaDJ;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public final String zzwg() {
        return this.zzaDK;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public final String zzwh() {
        return this.zzaDL;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public final Bundle zzwi() {
        return this.zzaDM;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzwj, reason: merged with bridge method [inline-methods] */
    public final AppContentCondition freeze() {
        return this;
    }
}
