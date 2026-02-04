package com.google.android.gms.gcm;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.iid.InstanceID;
import java.io.IOException;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class GcmPubSub {
    private static GcmPubSub zzaLE;
    private static final Pattern zzaLG = Pattern.compile("/topics/[a-zA-Z0-9-_.~%]{1,900}");
    private InstanceID zzaLF;

    private GcmPubSub(Context context) {
        this.zzaLF = InstanceID.getInstance(context);
    }

    public static synchronized GcmPubSub getInstance(Context context) {
        if (zzaLE == null) {
            zzaLE = new GcmPubSub(context);
        }
        return zzaLE;
    }

    @RequiresPermission("com.google.android.c2dm.permission.RECEIVE")
    public void subscribe(String str, String str2, Bundle bundle) throws IOException {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Invalid appInstanceToken: " + str);
        }
        if (str2 == null || !zzaLG.matcher(str2).matches()) {
            throw new IllegalArgumentException("Invalid topic name: " + str2);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("gcm.topic", str2);
        this.zzaLF.getToken(str, str2, bundle);
    }

    @RequiresPermission("com.google.android.c2dm.permission.RECEIVE")
    public void unsubscribe(String str, String str2) throws IOException {
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", str2);
        this.zzaLF.zzb(str, str2, bundle);
    }
}
