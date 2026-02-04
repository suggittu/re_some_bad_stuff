package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.internal.zzg;

/* loaded from: classes2.dex */
public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private int mSize;
    private String zzF;
    private View zzbea;
    private int zzbeb;
    private int zzbec;
    private OnPlusOneClickListener zzbed;

    public class DefaultOnPlusOneClickListener implements View.OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener zzbee;

        public DefaultOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
            this.zzbee = onPlusOneClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = (Intent) PlusOneButton.this.zzbea.getTag();
            if (this.zzbee != null) {
                this.zzbee.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        @Override // com.google.android.gms.plus.PlusOneButton.OnPlusOneClickListener
        public void onPlusOneClick(Intent intent) {
            Context context = PlusOneButton.this.getContext();
            if (!(context instanceof Activity) || intent == null) {
                return;
            }
            ((Activity) context).startActivityForResult(intent, PlusOneButton.this.zzbec);
        }
    }

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSize = getSize(context, attributeSet);
        this.zzbeb = getAnnotation(context, attributeSet);
        this.zzbec = -1;
        zzar(getContext());
        if (isInEditMode()) {
        }
    }

    protected static int getAnnotation(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        String strZza = zzaf.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attributeSet, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(strZza)) {
            return 2;
        }
        return !"NONE".equalsIgnoreCase(strZza) ? 1 : 0;
    }

    protected static int getSize(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        String strZza = zzaf.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attributeSet, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(strZza)) {
            return 0;
        }
        if ("MEDIUM".equalsIgnoreCase(strZza)) {
            return 1;
        }
        return "TALL".equalsIgnoreCase(strZza) ? 2 : 3;
    }

    private void zzar(Context context) {
        if (this.zzbea != null) {
            removeView(this.zzbea);
        }
        this.zzbea = zzg.zza(context, this.mSize, this.zzbeb, this.zzF, this.zzbec);
        setOnPlusOneClickListener(this.zzbed);
        addView(this.zzbea);
    }

    public final void initialize(String str, int i) {
        zzx.zza(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.zzF = str;
        this.zzbec = i;
        zzar(getContext());
    }

    public final void initialize(String str, OnPlusOneClickListener onPlusOneClickListener) {
        this.zzF = str;
        this.zzbec = 0;
        zzar(getContext());
        setOnPlusOneClickListener(onPlusOneClickListener);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.zzbea.layout(0, 0, i3 - i, i4 - i2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        View view = this.zzbea;
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public final void plusOneClick() {
        this.zzbea.performClick();
    }

    public final void setAnnotation(int i) {
        this.zzbeb = i;
        zzar(getContext());
    }

    public final void setIntent(Intent intent) {
        this.zzbea.setTag(intent);
    }

    public final void setOnPlusOneClickListener(OnPlusOneClickListener onPlusOneClickListener) {
        this.zzbed = onPlusOneClickListener;
        this.zzbea.setOnClickListener(new DefaultOnPlusOneClickListener(onPlusOneClickListener));
    }

    public final void setSize(int i) {
        this.mSize = i;
        zzar(getContext());
    }
}
