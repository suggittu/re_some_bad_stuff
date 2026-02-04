package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class MultiProcessor implements Detector.Processor {
    private int zzbne;
    private Factory zzbnq;
    private SparseArray zzbnr;

    public class Builder {
        private MultiProcessor zzbns = new MultiProcessor();

        public Builder(Factory factory) {
            if (factory == null) {
                throw new IllegalArgumentException("No factory supplied.");
            }
            this.zzbns.zzbnq = factory;
        }

        public MultiProcessor build() {
            return this.zzbns;
        }

        public Builder setMaxGapFrames(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Invalid max gap: " + i);
            }
            this.zzbns.zzbne = i;
            return this;
        }
    }

    public interface Factory {
        Tracker create(Object obj);
    }

    class zza {
        private Tracker zzbnd;
        private int zzbnh;

        private zza() {
            this.zzbnh = 0;
        }

        static /* synthetic */ int zzb(zza zzaVar) {
            int i = zzaVar.zzbnh;
            zzaVar.zzbnh = i + 1;
            return i;
        }
    }

    private MultiProcessor() {
        this.zzbnr = new SparseArray();
        this.zzbne = 3;
    }

    private void zza(Detector.Detections detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int iKeyAt = detectedItems.keyAt(i);
            Object objValueAt = detectedItems.valueAt(i);
            if (this.zzbnr.get(iKeyAt) == null) {
                zza zzaVar = new zza();
                zzaVar.zzbnd = this.zzbnq.create(objValueAt);
                zzaVar.zzbnd.onNewItem(iKeyAt, objValueAt);
                this.zzbnr.append(iKeyAt, zzaVar);
            }
        }
    }

    private void zzb(Detector.Detections detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        HashSet hashSet = new HashSet();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzbnr.size()) {
                break;
            }
            int iKeyAt = this.zzbnr.keyAt(i2);
            if (detectedItems.get(iKeyAt) == null) {
                zza zzaVar = (zza) this.zzbnr.valueAt(i2);
                zza.zzb(zzaVar);
                if (zzaVar.zzbnh >= this.zzbne) {
                    zzaVar.zzbnd.onDone();
                    hashSet.add(Integer.valueOf(iKeyAt));
                } else {
                    zzaVar.zzbnd.onMissing(detections);
                }
            }
            i = i2 + 1;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.zzbnr.delete(((Integer) it.next()).intValue());
        }
    }

    private void zzc(Detector.Detections detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int iKeyAt = detectedItems.keyAt(i);
            Object objValueAt = detectedItems.valueAt(i);
            zza zzaVar = (zza) this.zzbnr.get(iKeyAt);
            zzaVar.zzbnh = 0;
            zzaVar.zzbnd.onUpdate(detections, objValueAt);
        }
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void receiveDetections(Detector.Detections detections) {
        zza(detections);
        zzb(detections);
        zzc(detections);
    }

    @Override // com.google.android.gms.vision.Detector.Processor
    public void release() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzbnr.size()) {
                this.zzbnr.clear();
                return;
            } else {
                ((zza) this.zzbnr.valueAt(i2)).zzbnd.onDone();
                i = i2 + 1;
            }
        }
    }
}
