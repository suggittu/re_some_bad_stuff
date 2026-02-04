package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.drive.internal.zzt;
import com.google.android.gms.drive.zzi;
import com.google.android.gms.internal.zzna;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class zzv implements DriveContents {
    private final Contents zzara;
    private boolean mClosed = false;
    private boolean zzarb = false;
    private boolean zzarc = false;

    public zzv(Contents contents) {
        this.zzara = (Contents) com.google.android.gms.common.internal.zzx.zzz(contents);
    }

    @Override // com.google.android.gms.drive.DriveContents
    public PendingResult commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        return zza(googleApiClient, metadataChangeSet, null);
    }

    @Override // com.google.android.gms.drive.DriveContents
    public PendingResult commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, ExecutionOptions executionOptions) {
        return zza(googleApiClient, metadataChangeSet, executionOptions == null ? null : com.google.android.gms.drive.zzi.zzb(executionOptions));
    }

    @Override // com.google.android.gms.drive.DriveContents
    public void discard(GoogleApiClient googleApiClient) throws IOException {
        if (zzsz()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        zzsy();
        ((AnonymousClass4) googleApiClient.zzb(new zzt.zza(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzv.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zzuVar.zzte().zza(new CloseContentsRequest(zzv.this.zzara.getRequestId(), false), new zzbu(this));
            }
        })).setResultCallback(new ResultCallback() { // from class: com.google.android.gms.drive.internal.zzv.3
            @Override // com.google.android.gms.common.api.ResultCallback
            /* renamed from: zzp, reason: merged with bridge method [inline-methods] */
            public void onResult(Status status) {
                if (status.isSuccess()) {
                    zzz.zzy("DriveContentsImpl", "Contents discarded");
                } else {
                    zzz.zzA("DriveContentsImpl", "Error discarding contents");
                }
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveContents
    public DriveId getDriveId() {
        return this.zzara.getDriveId();
    }

    @Override // com.google.android.gms.drive.DriveContents
    public InputStream getInputStream() {
        if (zzsz()) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        }
        if (this.zzara.getMode() != 268435456) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        }
        if (this.zzarb) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        }
        this.zzarb = true;
        return this.zzara.getInputStream();
    }

    @Override // com.google.android.gms.drive.DriveContents
    public int getMode() {
        return this.zzara.getMode();
    }

    @Override // com.google.android.gms.drive.DriveContents
    public OutputStream getOutputStream() {
        if (zzsz()) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        }
        if (this.zzara.getMode() != 536870912) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        }
        if (this.zzarc) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        }
        this.zzarc = true;
        return this.zzara.getOutputStream();
    }

    @Override // com.google.android.gms.drive.DriveContents
    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (zzsz()) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        }
        return this.zzara.getParcelFileDescriptor();
    }

    @Override // com.google.android.gms.drive.DriveContents
    public PendingResult reopenForWrite(GoogleApiClient googleApiClient) throws IOException {
        if (zzsz()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        if (this.zzara.getMode() != 268435456) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        }
        zzsy();
        return googleApiClient.zza(new zzs.zzc(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzv.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                zzuVar.zzte().zza(new OpenContentsRequest(zzv.this.getDriveId(), DriveFile.MODE_WRITE_ONLY, zzv.this.zzara.getRequestId()), new zzbl(this, null));
            }
        });
    }

    public PendingResult zza(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet, final com.google.android.gms.drive.zzi zziVar) throws IOException {
        if (zziVar == null) {
            zziVar = new zzi.zza().build();
        }
        if (this.zzara.getMode() == 268435456) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        }
        if (ExecutionOptions.zzcv(zziVar.zzsD()) && !this.zzara.zzsv()) {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
        zziVar.zzg(googleApiClient);
        if (zzsz()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        if (getDriveId() == null) {
            throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
        }
        if (metadataChangeSet == null) {
            metadataChangeSet = MetadataChangeSet.zzapd;
        }
        zzsy();
        return googleApiClient.zzb(new zzt.zza(googleApiClient) { // from class: com.google.android.gms.drive.internal.zzv.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
            public void zza(zzu zzuVar) {
                metadataChangeSet.zzsL().setContext(zzuVar.getContext());
                zzuVar.zzte().zza(new CloseContentsAndUpdateMetadataRequest(zzv.this.zzara.getDriveId(), metadataChangeSet.zzsL(), zzv.this.zzara.getRequestId(), zzv.this.zzara.zzsv(), zziVar), new zzbu(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveContents
    public Contents zzsx() {
        return this.zzara;
    }

    @Override // com.google.android.gms.drive.DriveContents
    public void zzsy() throws IOException {
        zzna.zza(this.zzara.getParcelFileDescriptor());
        this.mClosed = true;
    }

    @Override // com.google.android.gms.drive.DriveContents
    public boolean zzsz() {
        return this.mClosed;
    }
}
