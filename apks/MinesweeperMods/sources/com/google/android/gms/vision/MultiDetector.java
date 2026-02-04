package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class MultiDetector extends Detector {
    private List zzbno;

    public class Builder {
        private MultiDetector zzbnp = new MultiDetector();

        public Builder add(Detector detector) {
            this.zzbnp.zzbno.add(detector);
            return this;
        }

        public MultiDetector build() {
            if (this.zzbnp.zzbno.size() == 0) {
                throw new RuntimeException("No underlying detectors added to MultiDetector.");
            }
            return this.zzbnp;
        }
    }

    private MultiDetector() {
        this.zzbno = new ArrayList();
    }

    @Override // com.google.android.gms.vision.Detector
    public SparseArray detect(Frame frame) {
        SparseArray sparseArray = new SparseArray();
        Iterator it = this.zzbno.iterator();
        while (it.hasNext()) {
            SparseArray sparseArrayDetect = ((Detector) it.next()).detect(frame);
            for (int i = 0; i < sparseArrayDetect.size(); i++) {
                int iKeyAt = sparseArrayDetect.keyAt(i);
                if (sparseArray.get(iKeyAt) != null) {
                    throw new IllegalStateException("Detection ID overlap for id = " + iKeyAt + ".  This means that one of the detectors is not using global IDs.");
                }
                sparseArray.append(iKeyAt, sparseArrayDetect.valueAt(i));
            }
        }
        return sparseArray;
    }

    @Override // com.google.android.gms.vision.Detector
    public boolean isOperational() {
        Iterator it = this.zzbno.iterator();
        while (it.hasNext()) {
            if (!((Detector) it.next()).isOperational()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.vision.Detector
    public void receiveFrame(Frame frame) {
        Iterator it = this.zzbno.iterator();
        while (it.hasNext()) {
            ((Detector) it.next()).receiveFrame(frame);
        }
    }

    @Override // com.google.android.gms.vision.Detector
    public void release() {
        Iterator it = this.zzbno.iterator();
        while (it.hasNext()) {
            ((Detector) it.next()).release();
        }
        this.zzbno.clear();
    }

    @Override // com.google.android.gms.vision.Detector
    public void setProcessor(Detector.Processor processor) {
        throw new UnsupportedOperationException("MultiDetector.setProcessor is not supported.  You should set a processor instance on each underlying detector instead.");
    }
}
