package com.google.android.gms.vision;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;

/* loaded from: classes2.dex */
public abstract class FocusingProcessor implements Detector.Processor {
    private Detector zzbmN;
    private Tracker zzbnd;
    private int zzbng;
    private int zzbne = 3;
    private boolean zzbnf = false;
    private int zzbnh = 0;

    public FocusingProcessor(Detector detector, Tracker tracker) {
        this.zzbmN = detector;
        this.zzbnd = tracker;
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void receiveDetections(Detector.Detections detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        if (detectedItems.size() == 0) {
            if (this.zzbnh == this.zzbne) {
                this.zzbnd.onDone();
                this.zzbnf = false;
            } else {
                this.zzbnd.onMissing(detections);
            }
            this.zzbnh++;
            return;
        }
        this.zzbnh = 0;
        if (this.zzbnf) {
            Object obj = detectedItems.get(this.zzbng);
            if (obj != null) {
                this.zzbnd.onUpdate(detections, obj);
                return;
            } else {
                this.zzbnd.onDone();
                this.zzbnf = false;
            }
        }
        int iSelectFocus = selectFocus(detections);
        Object obj2 = detectedItems.get(iSelectFocus);
        if (obj2 == null) {
            Log.w("FocusingProcessor", "Invalid focus selected: " + iSelectFocus);
            return;
        }
        this.zzbnf = true;
        this.zzbng = iSelectFocus;
        this.zzbmN.setFocus(this.zzbng);
        this.zzbnd.onNewItem(this.zzbng, obj2);
        this.zzbnd.onUpdate(detections, obj2);
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void release() {
        this.zzbnd.onDone();
    }

    public abstract int selectFocus(Detector.Detections detections);

    protected void zzkq(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid max gap: " + i);
        }
        this.zzbne = i;
    }
}
