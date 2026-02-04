package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzkk implements com.google.android.gms.appdatasearch.zzk, AppIndexApi {

    @Deprecated
    final class zza implements AppIndexApi.ActionResult {
        private zzkk zzUD;
        private PendingResult zzUE;
        private Action zzUF;

        zza(zzkk zzkkVar, PendingResult pendingResult, Action action) {
            this.zzUD = zzkkVar;
            this.zzUE = pendingResult;
            this.zzUF = action;
        }

        @Override // com.google.android.gms.appindexing.AppIndexApi.ActionResult
        public final PendingResult end(GoogleApiClient googleApiClient) {
            return this.zzUD.zza(googleApiClient, zzkj.zza(this.zzUF, System.currentTimeMillis(), googleApiClient.getContext().getPackageName(), 2));
        }

        @Override // com.google.android.gms.appindexing.AppIndexApi.ActionResult
        public final PendingResult getPendingResult() {
            return this.zzUE;
        }
    }

    abstract class zzb extends zza.AbstractC0036zza {
        public zzb(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.appdatasearch.zza.zzTy, googleApiClient);
        }

        protected abstract void zza(zzkf zzkfVar);

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0036zza
        public final void zza(zzki zzkiVar) {
            zza(zzkiVar.zzmj());
        }
    }

    abstract class zzc extends zzb {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    final class zzd extends zzkh {
        public zzd(zza.zzb zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.internal.zzkh, com.google.android.gms.internal.zzkg
        public final void zza(Status status) {
            this.zzUz.zzs(status);
        }
    }

    public static Intent zza(String str, Uri uri) {
        zzb(str, uri);
        if (zzk(uri)) {
            return new Intent("android.intent.action.VIEW", uri);
        }
        if (zzl(uri)) {
            return new Intent("android.intent.action.VIEW", zzj(uri));
        }
        throw new RuntimeException("appIndexingUri is neither an HTTP(S) URL nor an \"android-app://\" URL: " + uri);
    }

    private PendingResult zza(GoogleApiClient googleApiClient, Action action, int i) {
        return zza(googleApiClient, zzkj.zza(action, System.currentTimeMillis(), googleApiClient.getContext().getPackageName(), i));
    }

    private static void zzb(String str, Uri uri) {
        if (zzk(uri)) {
            if (uri.getHost().isEmpty()) {
                throw new IllegalArgumentException("AppIndex: The web URL must have a host (follow the format http(s)://<host>/[path]). Provided URI: " + uri);
            }
        } else {
            if (!zzl(uri)) {
                throw new IllegalArgumentException("AppIndex: The URI scheme must either be 'http(s)' or 'android-app'. If the latter, it must follow the format 'android-app://<package_name>/<scheme>/[host_path]'. Provided URI: " + uri);
            }
            if (str != null && !str.equals(uri.getHost())) {
                throw new IllegalArgumentException("AppIndex: The android-app URI host must match the package name and follow the format android-app://<package_name>/<scheme>/[host_path]. Provided URI: " + uri);
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.isEmpty() || pathSegments.get(0).isEmpty()) {
                throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
            }
        }
    }

    private static Uri zzj(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String str = pathSegments.get(0);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(str);
        if (pathSegments.size() > 1) {
            builder.authority(pathSegments.get(1));
            int i = 2;
            while (true) {
                int i2 = i;
                if (i2 >= pathSegments.size()) {
                    break;
                }
                builder.appendPath(pathSegments.get(i2));
                i = i2 + 1;
            }
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return builder.build();
    }

    private static boolean zzk(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    private static boolean zzl(Uri uri) {
        return "android-app".equals(uri.getScheme());
    }

    public static void zzt(List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzb(null, ((AppIndexApi.AppIndexingLink) it.next()).appIndexingUrl);
        }
    }

    @Override // com.google.android.gms.appindexing.AppIndexApi
    public final AppIndexApi.ActionResult action(GoogleApiClient googleApiClient, Action action) {
        return new zza(this, zza(googleApiClient, action, 1), action);
    }

    @Override // com.google.android.gms.appindexing.AppIndexApi
    public final PendingResult end(GoogleApiClient googleApiClient, Action action) {
        return zza(googleApiClient, action, 2);
    }

    @Override // com.google.android.gms.appindexing.AppIndexApi
    public final PendingResult start(GoogleApiClient googleApiClient, Action action) {
        return zza(googleApiClient, action, 1);
    }

    @Override // com.google.android.gms.appindexing.AppIndexApi
    public final PendingResult view(GoogleApiClient googleApiClient, Activity activity, Intent intent, String str, Uri uri, List list) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzt(list);
        return zza(googleApiClient, new UsageInfo(packageName, intent, str, uri, null, list, 1));
    }

    @Override // com.google.android.gms.appindexing.AppIndexApi
    public final PendingResult view(GoogleApiClient googleApiClient, Activity activity, Uri uri, String str, Uri uri2, List list) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzb(packageName, uri);
        return view(googleApiClient, activity, zza(packageName, uri), str, uri2, list);
    }

    @Override // com.google.android.gms.appindexing.AppIndexApi
    public final PendingResult viewEnd(GoogleApiClient googleApiClient, Activity activity, Intent intent) {
        return zza(googleApiClient, new UsageInfo.zza().zza(UsageInfo.zza(googleApiClient.getContext().getPackageName(), intent)).zzw(System.currentTimeMillis()).zzar(0).zzas(2).zzmi());
    }

    @Override // com.google.android.gms.appindexing.AppIndexApi
    public final PendingResult viewEnd(GoogleApiClient googleApiClient, Activity activity, Uri uri) {
        return viewEnd(googleApiClient, activity, zza(googleApiClient.getContext().getPackageName(), uri));
    }

    public final PendingResult zza(GoogleApiClient googleApiClient, final UsageInfo... usageInfoArr) {
        final String packageName = googleApiClient.getContext().getPackageName();
        return googleApiClient.zza(new zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzkk.1
            @Override // com.google.android.gms.internal.zzkk.zzb
            protected void zza(zzkf zzkfVar) {
                zzkfVar.zza(new zzd(this), packageName, usageInfoArr);
            }
        });
    }
}
