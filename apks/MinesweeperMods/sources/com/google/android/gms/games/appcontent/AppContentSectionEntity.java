package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class AppContentSectionEntity implements SafeParcelable, AppContentSection {
    public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();
    private final ArrayList mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzJN;
    private final ArrayList zzaDF;
    private final String zzaDH;
    private final ArrayList zzaDO;
    private final String zzaDP;
    private final String zzaDw;
    private final String zzapg;
    private final String zzyv;

    AppContentSectionEntity(int i, ArrayList arrayList, ArrayList arrayList2, String str, Bundle bundle, String str2, String str3, String str4, String str5, String str6, ArrayList arrayList3) {
        this.mVersionCode = i;
        this.mActions = arrayList;
        this.zzaDF = arrayList3;
        this.zzaDO = arrayList2;
        this.zzaDP = str6;
        this.zzaDw = str;
        this.mExtras = bundle;
        this.zzyv = str5;
        this.zzaDH = str2;
        this.zzapg = str3;
        this.zzJN = str4;
    }

    public AppContentSectionEntity(AppContentSection appContentSection) {
        this.mVersionCode = 5;
        this.zzaDP = appContentSection.zzwl();
        this.zzaDw = appContentSection.zzvQ();
        this.mExtras = appContentSection.getExtras();
        this.zzyv = appContentSection.getId();
        this.zzaDH = appContentSection.zzwc();
        this.zzapg = appContentSection.getTitle();
        this.zzJN = appContentSection.getType();
        List actions = appContentSection.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        List listZzwk = appContentSection.zzwk();
        int size2 = listZzwk.size();
        this.zzaDO = new ArrayList(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.zzaDO.add((AppContentCardEntity) ((AppContentCard) listZzwk.get(i2)).freeze());
        }
        List listZzwa = appContentSection.zzwa();
        int size3 = listZzwa.size();
        this.zzaDF = new ArrayList(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.zzaDF.add((AppContentAnnotationEntity) ((AppContentAnnotation) listZzwa.get(i3)).freeze());
        }
    }

    static int zza(AppContentSection appContentSection) {
        return zzw.hashCode(appContentSection.getActions(), appContentSection.zzwa(), appContentSection.zzwk(), appContentSection.zzwl(), appContentSection.zzvQ(), appContentSection.getExtras(), appContentSection.getId(), appContentSection.zzwc(), appContentSection.getTitle(), appContentSection.getType());
    }

    static boolean zza(AppContentSection appContentSection, Object obj) {
        if (!(obj instanceof AppContentSection)) {
            return false;
        }
        if (appContentSection == obj) {
            return true;
        }
        AppContentSection appContentSection2 = (AppContentSection) obj;
        return zzw.equal(appContentSection2.getActions(), appContentSection.getActions()) && zzw.equal(appContentSection2.zzwa(), appContentSection.zzwa()) && zzw.equal(appContentSection2.zzwk(), appContentSection.zzwk()) && zzw.equal(appContentSection2.zzwl(), appContentSection.zzwl()) && zzw.equal(appContentSection2.zzvQ(), appContentSection.zzvQ()) && zzw.equal(appContentSection2.getExtras(), appContentSection.getExtras()) && zzw.equal(appContentSection2.getId(), appContentSection.getId()) && zzw.equal(appContentSection2.zzwc(), appContentSection.zzwc()) && zzw.equal(appContentSection2.getTitle(), appContentSection.getTitle()) && zzw.equal(appContentSection2.getType(), appContentSection.getType());
    }

    static String zzb(AppContentSection appContentSection) {
        return zzw.zzy(appContentSection).zzg("Actions", appContentSection.getActions()).zzg("Annotations", appContentSection.zzwa()).zzg("Cards", appContentSection.zzwk()).zzg("CardType", appContentSection.zzwl()).zzg("ContentDescription", appContentSection.zzvQ()).zzg("Extras", appContentSection.getExtras()).zzg("Id", appContentSection.getId()).zzg("Subtitle", appContentSection.zzwc()).zzg("Title", appContentSection.getTitle()).zzg("Type", appContentSection.getType()).toString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final List getActions() {
        return new ArrayList(this.mActions);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final String getId() {
        return this.zzyv;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final String getTitle() {
        return this.zzapg;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
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
        AppContentSectionEntityCreator.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final String zzvQ() {
        return this.zzaDw;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final List zzwa() {
        return new ArrayList(this.zzaDF);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final String zzwc() {
        return this.zzaDH;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final List zzwk() {
        return new ArrayList(this.zzaDO);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public final String zzwl() {
        return this.zzaDP;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzwm, reason: merged with bridge method [inline-methods] */
    public final AppContentSection freeze() {
        return this;
    }
}
