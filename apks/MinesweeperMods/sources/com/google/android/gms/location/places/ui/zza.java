package com.google.android.gms.location.places.ui;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceImpl;

/* loaded from: classes2.dex */
abstract class zza {
    public static final int RESULT_ERROR = 2;

    /* renamed from: com.google.android.gms.location.places.ui.zza$zza, reason: collision with other inner class name */
    public abstract class AbstractC0187zza {
        protected final Intent mIntent;

        public AbstractC0187zza(String str) {
            this.mIntent = new Intent(str);
            this.mIntent.setPackage("com.google.android.gms");
        }

        protected Intent build(Activity activity) {
            Resources.Theme theme = activity.getTheme();
            TypedValue typedValue = new TypedValue();
            TypedValue typedValue2 = new TypedValue();
            if (theme.resolveAttribute(R.attr.colorPrimary, typedValue, true) && !this.mIntent.hasExtra("primary_color")) {
                this.mIntent.putExtra("primary_color", typedValue.data);
            }
            if (theme.resolveAttribute(R.attr.colorPrimaryDark, typedValue2, true) && !this.mIntent.hasExtra("primary_color_dark")) {
                this.mIntent.putExtra("primary_color_dark", typedValue2.data);
            }
            GoogleApiAvailability.getInstance().zzak(activity);
            return this.mIntent;
        }
    }

    zza() {
    }

    public static Place getPlace(Context context, Intent intent) {
        zzx.zzb(intent, "intent must not be null");
        zzx.zzb(context, "context must not be null");
        return (Place) zzc.zza(intent, "selected_place", PlaceImpl.CREATOR);
    }

    public static Status getStatus(Context context, Intent intent) {
        zzx.zzb(intent, "intent must not be null");
        zzx.zzb(context, "context must not be null");
        return (Status) zzc.zza(intent, "status", Status.CREATOR);
    }
}
