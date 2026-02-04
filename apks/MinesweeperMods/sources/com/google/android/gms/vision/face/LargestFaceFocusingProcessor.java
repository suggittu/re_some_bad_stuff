package com.google.android.gms.vision.face;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.FocusingProcessor;
import com.google.android.gms.vision.Tracker;

/* loaded from: classes2.dex */
public class LargestFaceFocusingProcessor extends FocusingProcessor {

    public class Builder {
        private LargestFaceFocusingProcessor zzbnO;

        public Builder(Detector detector, Tracker tracker) {
            this.zzbnO = new LargestFaceFocusingProcessor(detector, tracker);
        }

        public LargestFaceFocusingProcessor build() {
            return this.zzbnO;
        }

        public Builder setMaxGapFrames(int i) {
            this.zzbnO.zzkq(i);
            return this;
        }
    }

    public LargestFaceFocusingProcessor(Detector detector, Tracker tracker) {
        super(detector, tracker);
    }

    @Override // com.google.android.gms.vision.FocusingProcessor
    public int selectFocus(Detector.Detections detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        if (detectedItems.size() == 0) {
            throw new IllegalArgumentException("No faces for selectFocus.");
        }
        int iKeyAt = detectedItems.keyAt(0);
        int i = 1;
        int i2 = iKeyAt;
        float width = ((Face) detectedItems.valueAt(0)).getWidth();
        while (true) {
            int i3 = i;
            if (i3 >= detectedItems.size()) {
                return i2;
            }
            int iKeyAt2 = detectedItems.keyAt(i3);
            float width2 = ((Face) detectedItems.valueAt(i3)).getWidth();
            if (width2 > width) {
                width = width2;
                i2 = iKeyAt2;
            }
            i = i3 + 1;
        }
    }
}
