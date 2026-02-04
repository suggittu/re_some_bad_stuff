package com.google.android.gms.location.places;

import android.support.annotation.Nullable;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

/* loaded from: classes2.dex */
public interface AutocompletePrediction extends Freezable {

    @Deprecated
    public interface Substring {
        int getLength();

        int getOffset();
    }

    @Deprecated
    String getDescription();

    CharSequence getFullText(@Nullable CharacterStyle characterStyle);

    @Deprecated
    List getMatchedSubstrings();

    @Nullable
    String getPlaceId();

    @Nullable
    List getPlaceTypes();

    CharSequence getPrimaryText(@Nullable CharacterStyle characterStyle);

    CharSequence getSecondaryText(@Nullable CharacterStyle characterStyle);
}
