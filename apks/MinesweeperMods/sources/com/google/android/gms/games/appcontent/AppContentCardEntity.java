package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class AppContentCardEntity implements SafeParcelable, AppContentCard {
    public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
    private final ArrayList mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzJN;
    private final ArrayList zzaDF;
    private final int zzaDG;
    private final String zzaDH;
    private final int zzaDI;
    private final ArrayList zzaDv;
    private final String zzaDw;
    private final String zzapg;
    private final String zzaxl;
    private final String zzyv;

    AppContentCardEntity(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, String str, int i2, String str2, Bundle bundle, String str3, String str4, int i3, String str5, String str6) {
        this.mVersionCode = i;
        this.mActions = arrayList;
        this.zzaDF = arrayList2;
        this.zzaDv = arrayList3;
        this.zzaDw = str;
        this.zzaDG = i2;
        this.zzaxl = str2;
        this.mExtras = bundle;
        this.zzyv = str6;
        this.zzaDH = str3;
        this.zzapg = str4;
        this.zzaDI = i3;
        this.zzJN = str5;
    }

    public AppContentCardEntity(AppContentCard appContentCard) {
        this.mVersionCode = 4;
        this.zzaDw = appContentCard.zzvQ();
        this.zzaDG = appContentCard.zzwb();
        this.zzaxl = appContentCard.getDescription();
        this.mExtras = appContentCard.getExtras();
        this.zzyv = appContentCard.getId();
        this.zzapg = appContentCard.getTitle();
        this.zzaDH = appContentCard.zzwc();
        this.zzaDI = appContentCard.zzwd();
        this.zzJN = appContentCard.getType();
        List actions = appContentCard.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        List listZzwa = appContentCard.zzwa();
        int size2 = listZzwa.size();
        this.zzaDF = new ArrayList(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.zzaDF.add((AppContentAnnotationEntity) ((AppContentAnnotation) listZzwa.get(i2)).freeze());
        }
        List listZzvP = appContentCard.zzvP();
        int size3 = listZzvP.size();
        this.zzaDv = new ArrayList(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.zzaDv.add((AppContentConditionEntity) ((AppContentCondition) listZzvP.get(i3)).freeze());
        }
    }

    static int zza(AppContentCard appContentCard) {
        return zzw.hashCode(appContentCard.getActions(), appContentCard.zzwa(), appContentCard.zzvP(), appContentCard.zzvQ(), Integer.valueOf(appContentCard.zzwb()), appContentCard.getDescription(), appContentCard.getExtras(), appContentCard.getId(), appContentCard.zzwc(), appContentCard.getTitle(), Integer.valueOf(appContentCard.zzwd()), appContentCard.getType());
    }

    static boolean zza(AppContentCard appContentCard, Object obj) {
        if (!(obj instanceof AppContentCard)) {
            return false;
        }
        if (appContentCard == obj) {
            return true;
        }
        AppContentCard appContentCard2 = (AppContentCard) obj;
        return zzw.equal(appContentCard2.getActions(), appContentCard.getActions()) && zzw.equal(appContentCard2.zzwa(), appContentCard.zzwa()) && zzw.equal(appContentCard2.zzvP(), appContentCard.zzvP()) && zzw.equal(appContentCard2.zzvQ(), appContentCard.zzvQ()) && zzw.equal(Integer.valueOf(appContentCard2.zzwb()), Integer.valueOf(appContentCard.zzwb())) && zzw.equal(appContentCard2.getDescription(), appContentCard.getDescription()) && zzw.equal(appContentCard2.getExtras(), appContentCard.getExtras()) && zzw.equal(appContentCard2.getId(), appContentCard.getId()) && zzw.equal(appContentCard2.zzwc(), appContentCard.zzwc()) && zzw.equal(appContentCard2.getTitle(), appContentCard.getTitle()) && zzw.equal(Integer.valueOf(appContentCard2.zzwd()), Integer.valueOf(appContentCard.zzwd())) && zzw.equal(appContentCard2.getType(), appContentCard.getType());
    }

    static String zzb(AppContentCard appContentCard) {
        return zzw.zzy(appContentCard).zzg("Actions", appContentCard.getActions()).zzg("Annotations", appContentCard.zzwa()).zzg("Conditions", appContentCard.zzvP()).zzg("ContentDescription", appContentCard.zzvQ()).zzg("CurrentSteps", Integer.valueOf(appContentCard.zzwb())).zzg("Description", appContentCard.getDescription()).zzg("Extras", appContentCard.getExtras()).zzg("Id", appContentCard.getId()).zzg("Subtitle", appContentCard.zzwc()).zzg("Title", appContentCard.getTitle()).zzg("TotalSteps", Integer.valueOf(appContentCard.zzwd())).zzg("Type", appContentCard.getType()).toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final List getActions() {
        return new ArrayList(this.mActions);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final String getDescription() {
        return this.zzaxl;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final String getId() {
        return this.zzyv;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final String getTitle() {
        return this.zzapg;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
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
        AppContentCardEntityCreator.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final List zzvP() {
        return new ArrayList(this.zzaDv);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final String zzvQ() {
        return this.zzaDw;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final List zzwa() {
        return new ArrayList(this.zzaDF);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final int zzwb() {
        return this.zzaDG;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final String zzwc() {
        return this.zzaDH;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public final int zzwd() {
        return this.zzaDI;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzwe, reason: merged with bridge method [inline-methods] */
    public final AppContentCard freeze() {
        return this;
    }
}
