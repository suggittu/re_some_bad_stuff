package com.google.android.gms.vision.face;

import android.graphics.PointF;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class Face {
    public static final float UNCOMPUTED_PROBABILITY = -1.0f;
    private int mId;
    private float zzaTm;
    private float zzaTn;
    private float zzbnA;
    private float zzbnB;
    private List zzbnC;
    private float zzbnD;
    private float zzbnE;
    private float zzbnF;
    private PointF zzbnz;

    public Face(int i, PointF pointF, float f, float f2, float f3, float f4, Landmark[] landmarkArr, float f5, float f6, float f7) {
        this.mId = i;
        this.zzbnz = pointF;
        this.zzaTm = f;
        this.zzaTn = f2;
        this.zzbnA = f3;
        this.zzbnB = f4;
        this.zzbnC = Arrays.asList(landmarkArr);
        if (f5 < 0.0f || f5 > 1.0f) {
            this.zzbnD = -1.0f;
        } else {
            this.zzbnD = f5;
        }
        if (f6 < 0.0f || f6 > 1.0f) {
            this.zzbnE = -1.0f;
        } else {
            this.zzbnE = f6;
        }
        if (this.zzbnF < 0.0f || this.zzbnF > 1.0f) {
            this.zzbnF = -1.0f;
        } else {
            this.zzbnF = f7;
        }
    }

    public float getEulerY() {
        return this.zzbnA;
    }

    public float getEulerZ() {
        return this.zzbnB;
    }

    public float getHeight() {
        return this.zzaTn;
    }

    public int getId() {
        return this.mId;
    }

    public float getIsLeftEyeOpenProbability() {
        return this.zzbnD;
    }

    public float getIsRightEyeOpenProbability() {
        return this.zzbnE;
    }

    public float getIsSmilingProbability() {
        return this.zzbnF;
    }

    public List getLandmarks() {
        return this.zzbnC;
    }

    public PointF getPosition() {
        return new PointF(this.zzbnz.x - (this.zzaTm / 2.0f), this.zzbnz.y - (this.zzaTn / 2.0f));
    }

    public float getWidth() {
        return this.zzaTm;
    }
}
