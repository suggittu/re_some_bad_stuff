package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
class DrawableCompatKitKat {
    DrawableCompatKitKat() {
    }

    public static int getAlpha(Drawable drawable) {
        return drawable.getAlpha();
    }

    public static boolean isAutoMirrored(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static void setAutoMirrored(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static Drawable wrapForTinting(Drawable drawable) {
        return !(drawable instanceof DrawableWrapperKitKat) ? new DrawableWrapperKitKat(drawable) : drawable;
    }
}
