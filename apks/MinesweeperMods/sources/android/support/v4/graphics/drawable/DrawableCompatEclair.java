package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
class DrawableCompatEclair {
    DrawableCompatEclair() {
    }

    public static Drawable wrapForTinting(Drawable drawable) {
        return !(drawable instanceof DrawableWrapperEclair) ? new DrawableWrapperEclair(drawable) : drawable;
    }
}
