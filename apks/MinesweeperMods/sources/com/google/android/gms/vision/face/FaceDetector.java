package com.google.android.gms.vision.face;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.internal.client.FaceSettingsParcel;
import com.google.android.gms.vision.face.internal.client.zzg;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import com.google.android.gms.vision.zza;
import java.nio.ByteBuffer;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class FaceDetector extends Detector {
    public static final int ACCURATE_MODE = 1;
    public static final int ALL_CLASSIFICATIONS = 1;
    public static final int ALL_LANDMARKS = 1;
    public static final int FAST_MODE = 0;
    public static final int NO_CLASSIFICATIONS = 0;
    public static final int NO_LANDMARKS = 0;
    private final zza zzbnG;
    private final zzg zzbnH;
    private boolean zzbnI;
    private final Object zzpV;

    public class Builder {
        private final Context mContext;
        private int zzbnJ = 0;
        private boolean zzbnK = false;
        private int zzbnL = 0;
        private boolean zzbnM = true;
        private int zzaoy = 0;
        private float zzbnN = -1.0f;

        public Builder(Context context) {
            this.mContext = context;
        }

        public FaceDetector build() {
            FaceSettingsParcel faceSettingsParcel = new FaceSettingsParcel();
            faceSettingsParcel.mode = this.zzaoy;
            faceSettingsParcel.zzbnV = this.zzbnJ;
            faceSettingsParcel.zzbnW = this.zzbnL;
            faceSettingsParcel.zzbnX = this.zzbnK;
            faceSettingsParcel.zzbnY = this.zzbnM;
            faceSettingsParcel.zzbnZ = this.zzbnN;
            return new FaceDetector(new zzg(this.mContext, faceSettingsParcel));
        }

        public Builder setClassificationType(int i) {
            if (i != 0 && i != 1) {
                throw new IllegalArgumentException("Invalid classification type: " + i);
            }
            this.zzbnL = i;
            return this;
        }

        public Builder setLandmarkType(int i) {
            if (i != 0 && i != 1) {
                throw new IllegalArgumentException("Invalid landmark type: " + i);
            }
            this.zzbnJ = i;
            return this;
        }

        public Builder setMinFaceSize(float f) {
            if (f < 0.0f || f > 1.0f) {
                throw new IllegalArgumentException("Invalid proportional face size: " + f);
            }
            this.zzbnN = f;
            return this;
        }

        public Builder setMode(int i) {
            switch (i) {
                case 0:
                case 1:
                    this.zzaoy = i;
                    return this;
                default:
                    throw new IllegalArgumentException("Invalid mode: " + i);
            }
        }

        public Builder setProminentFaceOnly(boolean z) {
            this.zzbnK = z;
            return this;
        }

        public Builder setTrackingEnabled(boolean z) {
            this.zzbnM = z;
            return this;
        }
    }

    private FaceDetector() {
        this.zzbnG = new zza();
        this.zzpV = new Object();
        this.zzbnI = true;
        throw new IllegalStateException("Default constructor called");
    }

    private FaceDetector(zzg zzgVar) {
        this.zzbnG = new zza();
        this.zzpV = new Object();
        this.zzbnI = true;
        this.zzbnH = zzgVar;
    }

    @Override // com.google.android.gms.vision.Detector
    public final SparseArray detect(Frame frame) {
        Face[] faceArrZzb;
        if (frame == null) {
            throw new IllegalArgumentException("No frame supplied.");
        }
        ByteBuffer grayscaleImageData = frame.getGrayscaleImageData();
        synchronized (this.zzpV) {
            if (!this.zzbnI) {
                throw new RuntimeException("Cannot use detector after release()");
            }
            faceArrZzb = this.zzbnH.zzb(grayscaleImageData, FrameMetadataParcel.zzc(frame));
        }
        HashSet hashSet = new HashSet();
        SparseArray sparseArray = new SparseArray(faceArrZzb.length);
        int iMax = 0;
        for (Face face : faceArrZzb) {
            int id = face.getId();
            iMax = Math.max(iMax, id);
            if (hashSet.contains(Integer.valueOf(id))) {
                id = iMax + 1;
                iMax = id;
            }
            hashSet.add(Integer.valueOf(id));
            sparseArray.append(this.zzbnG.zzkr(id), face);
        }
        return sparseArray;
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this.zzpV) {
                if (this.zzbnI) {
                    Log.w("FaceDetector", "FaceDetector was not released with FaceDetector.release()");
                    release();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.vision.Detector
    public final boolean isOperational() {
        return this.zzbnH.isOperational();
    }

    @Override // com.google.android.gms.vision.Detector
    public final void release() {
        synchronized (this.zzpV) {
            if (this.zzbnI) {
                this.zzbnH.zzIh();
                this.zzbnI = false;
            }
        }
    }

    @Override // com.google.android.gms.vision.Detector
    public final boolean setFocus(int i) {
        boolean zZzkJ;
        int iZzks = this.zzbnG.zzks(i);
        synchronized (this.zzpV) {
            if (!this.zzbnI) {
                throw new RuntimeException("Cannot use detector after release()");
            }
            zZzkJ = this.zzbnH.zzkJ(iZzks);
        }
        return zZzkJ;
    }
}
