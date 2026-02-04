package com.google.android.gms.location.places.internal;

import android.text.SpannableString;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class zzc {
    public static CharSequence zza(String str, List list, CharacterStyle characterStyle) {
        if (characterStyle == null) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AutocompletePredictionEntity.SubstringEntity substringEntity = (AutocompletePredictionEntity.SubstringEntity) it.next();
            spannableString.setSpan(CharacterStyle.wrap(characterStyle), substringEntity.getOffset(), substringEntity.getLength() + substringEntity.getOffset(), 0);
        }
        return spannableString;
    }

    public static String zzj(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        return zzv.zzcL(", ").zza(collection);
    }
}
