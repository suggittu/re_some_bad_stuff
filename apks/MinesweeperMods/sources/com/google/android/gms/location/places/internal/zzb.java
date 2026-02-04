package com.google.android.gms.location.places.internal;

import android.support.annotation.Nullable;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class zzb extends zzt implements AutocompletePrediction {
    public zzb(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    private String zzzh() {
        return zzG("ap_description", "");
    }

    private String zzzi() {
        return zzG("ap_primary_text", "");
    }

    private String zzzj() {
        return zzG("ap_secondary_text", "");
    }

    private List zzzk() {
        return zza("ap_matched_subscriptions", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
    }

    private List zzzl() {
        return zza("ap_primary_text_matched", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
    }

    private List zzzm() {
        return zza("ap_secondary_text_matched", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public String getDescription() {
        return zzzh();
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public CharSequence getFullText(@Nullable CharacterStyle characterStyle) {
        return zzc.zza(zzzh(), zzzk(), characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public List getMatchedSubstrings() {
        return zzzk();
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public String getPlaceId() {
        return zzG("ap_place_id", null);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public List getPlaceTypes() {
        return zza("ap_place_types", Collections.emptyList());
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public CharSequence getPrimaryText(@Nullable CharacterStyle characterStyle) {
        return zzc.zza(zzzi(), zzzl(), characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public CharSequence getSecondaryText(@Nullable CharacterStyle characterStyle) {
        return zzc.zza(zzzj(), zzzm(), characterStyle);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzzf, reason: merged with bridge method [inline-methods] */
    public AutocompletePrediction freeze() {
        return AutocompletePredictionEntity.zza(getPlaceId(), getPlaceTypes(), zzzg(), zzzh(), zzzk(), zzzi(), zzzl(), zzzj(), zzzm());
    }

    public int zzzg() {
        return zzz("ap_personalization_type", 6);
    }
}
