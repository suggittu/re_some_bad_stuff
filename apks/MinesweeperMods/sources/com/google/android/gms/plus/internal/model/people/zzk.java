package com.google.android.gms.plus.internal.model.people;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.model.people.Person;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzk extends com.google.android.gms.common.data.zzc implements Person {
    public zzk(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getAboutMe() {
        return null;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final Person.AgeRange getAgeRange() {
        return null;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getBirthday() {
        return null;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getBraggingRights() {
        return null;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final int getCircledByCount() {
        return 0;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final Person.Cover getCover() {
        return null;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getCurrentLocation() {
        return null;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getDisplayName() {
        return getString("displayName");
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final int getGender() {
        return 0;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getId() {
        return getString("personId");
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final Person.Image getImage() {
        return new PersonEntity.ImageEntity(getString("image"));
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getLanguage() {
        return null;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final Person.Name getName() {
        return null;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getNickname() {
        return null;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final int getObjectType() {
        return PersonEntity.zza.zzfH(getString("objectType"));
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final int getPlusOneCount() {
        return 0;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final int getRelationshipStatus() {
        return 0;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getTagline() {
        return null;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getUrl() {
        return getString(PlusShare.KEY_CALL_TO_ACTION_URL);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasAboutMe() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasAgeRange() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasBirthday() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasBraggingRights() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasCircledByCount() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasCover() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasCurrentLocation() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasDisplayName() {
        return true;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasGender() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasId() {
        return true;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasImage() {
        return true;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasIsPlusUser() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasLanguage() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasName() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasNickname() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasObjectType() {
        return true;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasOrganizations() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasPlacesLived() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasPlusOneCount() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasRelationshipStatus() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasTagline() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasUrl() {
        return true;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasUrls() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasVerified() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean isPlusUser() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean isVerified() {
        return false;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    /* renamed from: zzFA, reason: merged with bridge method [inline-methods] */
    public final ArrayList getOrganizations() {
        return null;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    /* renamed from: zzFB, reason: merged with bridge method [inline-methods] */
    public final ArrayList getPlacesLived() {
        return null;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    /* renamed from: zzFC, reason: merged with bridge method [inline-methods] */
    public final ArrayList getUrls() {
        return null;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzFD, reason: merged with bridge method [inline-methods] */
    public final Person freeze() {
        return new PersonEntity(getDisplayName(), getId(), (PersonEntity.ImageEntity) getImage(), getObjectType(), getUrl());
    }
}
