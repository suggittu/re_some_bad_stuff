package com.google.android.gms.drive;

import com.google.android.gms.drive.ExecutionOptions;

/* loaded from: classes2.dex */
public class zzh extends ExecutionOptions {
    private String zzaoY;
    private String zzaoZ;

    public class zza extends ExecutionOptions.Builder {
        private String zzaoY;
        private String zzaoZ;

        @Override // com.google.android.gms.drive.ExecutionOptions.Builder
        /* renamed from: zzad, reason: merged with bridge method [inline-methods] */
        public zza setNotifyOnCompletion(boolean z) {
            super.setNotifyOnCompletion(z);
            return this;
        }

        @Override // com.google.android.gms.drive.ExecutionOptions.Builder
        /* renamed from: zzcY, reason: merged with bridge method [inline-methods] */
        public zza setTrackingTag(String str) {
            super.setTrackingTag(str);
            return this;
        }

        @Override // com.google.android.gms.drive.ExecutionOptions.Builder
        /* renamed from: zzcx, reason: merged with bridge method [inline-methods] */
        public zza setConflictStrategy(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.gms.drive.ExecutionOptions.Builder
        /* renamed from: zzsH, reason: merged with bridge method [inline-methods] */
        public zzh build() {
            zzsE();
            return new zzh(this.zzaoV, this.zzaoW, this.zzaoY, this.zzaoZ, this.zzaoX);
        }
    }

    private zzh(String str, boolean z, String str2, String str3, int i) {
        super(str, z, i);
        this.zzaoY = str2;
        this.zzaoZ = str3;
    }

    public static zzh zza(ExecutionOptions executionOptions) {
        zza zzaVar = new zza();
        if (executionOptions != null) {
            if (executionOptions.zzsD() != 0) {
                throw new IllegalStateException("May not set a conflict strategy for new file creation.");
            }
            String strZzsB = executionOptions.zzsB();
            if (strZzsB != null) {
                zzaVar.setTrackingTag(strZzsB);
            }
            zzaVar.setNotifyOnCompletion(executionOptions.zzsC());
        }
        return zzaVar.build();
    }

    public String zzsF() {
        return this.zzaoY;
    }

    public String zzsG() {
        return this.zzaoZ;
    }
}
