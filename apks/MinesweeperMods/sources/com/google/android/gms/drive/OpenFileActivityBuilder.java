package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.zzu;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;

/* loaded from: classes2.dex */
public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String zzapg;
    private String[] zzaph;
    private Filter zzapi;
    private DriveId zzapj;

    public IntentSender build(GoogleApiClient googleApiClient) {
        zzx.zza(googleApiClient.isConnected(), "Client must be connected");
        if (this.zzaph == null) {
            this.zzaph = new String[0];
        }
        if (this.zzaph.length > 0 && this.zzapi != null) {
            throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
        }
        try {
            return ((zzu) googleApiClient.zza(Drive.zzUI)).zzte().zza(new OpenFileIntentSenderRequest(this.zzapg, this.zzaph, this.zzapj, this.zzapi == null ? null : new FilterHolder(this.zzapi)));
        } catch (RemoteException e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId driveId) {
        this.zzapj = (DriveId) zzx.zzz(driveId);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String str) {
        this.zzapg = (String) zzx.zzz(str);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] strArr) {
        zzx.zzb(strArr != null, "mimeTypes may not be null");
        this.zzaph = strArr;
        return this;
    }

    public OpenFileActivityBuilder setSelectionFilter(Filter filter) {
        zzx.zzb(filter != null, "filter may not be null");
        zzx.zzb(com.google.android.gms.drive.query.internal.zzg.zza(filter) ? false : true, "FullTextSearchFilter cannot be used as a selection filter");
        this.zzapi = filter;
        return this;
    }
}
