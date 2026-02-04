package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Frame;

/* loaded from: classes2.dex */
public abstract class Detector {
    private Object zzbmY = new Object();
    private Processor zzbmZ;

    public class Detections {
        private SparseArray zzbna;
        private Frame.Metadata zzbnb;
        private boolean zzbnc;

        public Detections(SparseArray sparseArray, Frame.Metadata metadata, boolean z) {
            this.zzbna = sparseArray;
            this.zzbnb = metadata;
            this.zzbnc = z;
        }

        public boolean detectorIsOperational() {
            return this.zzbnc;
        }

        public SparseArray getDetectedItems() {
            return this.zzbna;
        }

        public Frame.Metadata getFrameMetadata() {
            return this.zzbnb;
        }
    }

    public interface Processor {
        void receiveDetections(Detections detections);

        void release();
    }

    public abstract SparseArray detect(Frame frame);

    public boolean isOperational() {
        return true;
    }

    public void receiveFrame(Frame frame) {
        synchronized (this.zzbmY) {
            if (this.zzbmZ == null) {
                throw new IllegalStateException("Detector processor must first be set with setProcessor in order to receive detection results.");
            }
            Frame.Metadata metadata = new Frame.Metadata(frame.getMetadata());
            metadata.zzIf();
            this.zzbmZ.receiveDetections(new Detections(detect(frame), metadata, isOperational()));
        }
    }

    public void release() {
        synchronized (this.zzbmY) {
            if (this.zzbmZ != null) {
                this.zzbmZ.release();
                this.zzbmZ = null;
            }
        }
    }

    public boolean setFocus(int i) {
        return true;
    }

    public void setProcessor(Processor processor) {
        this.zzbmZ = processor;
    }
}
