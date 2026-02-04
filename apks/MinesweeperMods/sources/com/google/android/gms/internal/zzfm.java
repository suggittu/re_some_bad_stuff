package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.R;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;

@zzhb
/* loaded from: classes2.dex */
public class zzfm extends zzfs {
    private final Context mContext;
    private String zzCU;
    private long zzCV;
    private long zzCW;
    private String zzCX;
    private String zzCY;
    private final Map zzxA;

    public zzfm(zzjp zzjpVar, Map map) {
        super(zzjpVar, "createCalendarEvent");
        this.zzxA = map;
        this.mContext = zzjpVar.zzhP();
        zzeK();
    }

    private String zzaj(String str) {
        return TextUtils.isEmpty((CharSequence) this.zzxA.get(str)) ? "" : (String) this.zzxA.get(str);
    }

    private long zzak(String str) {
        String str2 = (String) this.zzxA.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    private void zzeK() {
        this.zzCU = zzaj(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        this.zzCX = zzaj("summary");
        this.zzCV = zzak("start_ticks");
        this.zzCW = zzak("end_ticks");
        this.zzCY = zzaj("location");
    }

    @TargetApi(14)
    Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.zzCU);
        data.putExtra("eventLocation", this.zzCY);
        data.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzCX);
        if (this.zzCV > -1) {
            data.putExtra("beginTime", this.zzCV);
        }
        if (this.zzCW > -1) {
            data.putExtra("endTime", this.zzCW);
        }
        data.setFlags(DriveFile.MODE_READ_ONLY);
        return data;
    }

    public void execute() {
        if (this.mContext == null) {
            zzam("Activity context is not available.");
            return;
        }
        if (!com.google.android.gms.ads.internal.zzr.zzbC().zzM(this.mContext).zzdo()) {
            zzam("This feature is not available on the device.");
            return;
        }
        AlertDialog.Builder builderZzL = com.google.android.gms.ads.internal.zzr.zzbC().zzL(this.mContext);
        builderZzL.setTitle(com.google.android.gms.ads.internal.zzr.zzbF().zzd(R.string.create_calendar_title, "Create calendar event"));
        builderZzL.setMessage(com.google.android.gms.ads.internal.zzr.zzbF().zzd(R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
        builderZzL.setPositiveButton(com.google.android.gms.ads.internal.zzr.zzbF().zzd(R.string.accept, "Accept"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.zzfm.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                com.google.android.gms.ads.internal.zzr.zzbC().zzb(zzfm.this.mContext, zzfm.this.createIntent());
            }
        });
        builderZzL.setNegativeButton(com.google.android.gms.ads.internal.zzr.zzbF().zzd(R.string.decline, "Decline"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.zzfm.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                zzfm.this.zzam("Operation denied by user.");
            }
        });
        builderZzL.create().show();
    }
}
