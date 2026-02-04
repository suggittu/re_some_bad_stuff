package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class AppContentActionEntity implements SafeParcelable, AppContentAction {
    public static final AppContentActionEntityCreator CREATOR = new AppContentActionEntityCreator();
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzJN;
    private final ArrayList zzaDv;
    private final String zzaDw;
    private final AppContentAnnotationEntity zzaDx;
    private final String zzaDy;
    private final String zzyv;

    AppContentActionEntity(int i, ArrayList arrayList, String str, Bundle bundle, String str2, String str3, AppContentAnnotationEntity appContentAnnotationEntity, String str4) {
        this.mVersionCode = i;
        this.zzaDx = appContentAnnotationEntity;
        this.zzaDv = arrayList;
        this.zzaDw = str;
        this.mExtras = bundle;
        this.zzyv = str3;
        this.zzaDy = str4;
        this.zzJN = str2;
    }

    public AppContentActionEntity(AppContentAction appContentAction) {
        this.mVersionCode = 5;
        this.zzaDx = (AppContentAnnotationEntity) appContentAction.zzvO().freeze();
        this.zzaDw = appContentAction.zzvQ();
        this.mExtras = appContentAction.getExtras();
        this.zzyv = appContentAction.getId();
        this.zzaDy = appContentAction.zzvR();
        this.zzJN = appContentAction.getType();
        List listZzvP = appContentAction.zzvP();
        int size = listZzvP.size();
        this.zzaDv = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzaDv.add((AppContentConditionEntity) ((AppContentCondition) listZzvP.get(i)).freeze());
        }
    }

    static int zza(AppContentAction appContentAction) {
        return zzw.hashCode(appContentAction.zzvO(), appContentAction.zzvP(), appContentAction.zzvQ(), appContentAction.getExtras(), appContentAction.getId(), appContentAction.zzvR(), appContentAction.getType());
    }

    static boolean zza(AppContentAction appContentAction, Object obj) {
        if (!(obj instanceof AppContentAction)) {
            return false;
        }
        if (appContentAction == obj) {
            return true;
        }
        AppContentAction appContentAction2 = (AppContentAction) obj;
        return zzw.equal(appContentAction2.zzvO(), appContentAction.zzvO()) && zzw.equal(appContentAction2.zzvP(), appContentAction.zzvP()) && zzw.equal(appContentAction2.zzvQ(), appContentAction.zzvQ()) && zzw.equal(appContentAction2.getExtras(), appContentAction.getExtras()) && zzw.equal(appContentAction2.getId(), appContentAction.getId()) && zzw.equal(appContentAction2.zzvR(), appContentAction.zzvR()) && zzw.equal(appContentAction2.getType(), appContentAction.getType());
    }

    static String zzb(AppContentAction appContentAction) {
        return zzw.zzy(appContentAction).zzg("Annotation", appContentAction.zzvO()).zzg("Conditions", appContentAction.zzvP()).zzg("ContentDescription", appContentAction.zzvQ()).zzg("Extras", appContentAction.getExtras()).zzg("Id", appContentAction.getId()).zzg("OverflowText", appContentAction.zzvR()).zzg("Type", appContentAction.getType()).toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public final Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public final String getId() {
        return this.zzyv;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public final String getType() {
        return this.zzJN;
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
        AppContentActionEntityCreator.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public final AppContentAnnotation zzvO() {
        return this.zzaDx;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public final List zzvP() {
        return new ArrayList(this.zzaDv);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public final String zzvQ() {
        return this.zzaDw;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public final String zzvR() {
        return this.zzaDy;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzvS, reason: merged with bridge method [inline-methods] */
    public final AppContentAction freeze() {
        return this;
    }
}
