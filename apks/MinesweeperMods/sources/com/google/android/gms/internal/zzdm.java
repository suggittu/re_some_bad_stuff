package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.drive.DriveFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzhb
/* loaded from: classes2.dex */
public final class zzdm implements zzdf {
    private final com.google.android.gms.ads.internal.zze zzzA;
    private final zzfn zzzB;
    private final zzdh zzzD;

    public class zza extends zzim {
        private final String zzF;
        private final zzjp zzpD;
        private final String zzzE = "play.google.com";
        private final String zzzF = "market";
        private final int zzzG = 10;

        public zza(zzjp zzjpVar, String str) {
            this.zzpD = zzjpVar;
            this.zzF = str;
        }

        @Override // com.google.android.gms.internal.zzim
        public void onStop() {
        }

        public Intent zzT(String str) {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            intent.setData(uri);
            return intent;
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x008f, code lost:
        
            com.google.android.gms.internal.zzin.zzaK("Arrived at landing page, this ideally should not happen. Will open it in browser.");
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0097, code lost:
        
            r0 = r2;
         */
        /* JADX WARN: Removed duplicated region for block: B:55:0x010a  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x008f A[EDGE_INSN: B:65:0x008f->B:28:0x008f BREAK  A[LOOP:0: B:3:0x0003->B:36:0x00ad], SYNTHETIC] */
        @Override // com.google.android.gms.internal.zzim
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void zzbr() {
            /*
                Method dump skipped, instructions count: 272
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdm.zza.zzbr():void");
        }
    }

    public class zzb {
        private final zzjp zzpD;

        public zzb(zzjp zzjpVar) {
            this.zzpD = zzjpVar;
        }

        public Intent zza(Context context, Map map) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
            ResolveInfo resolveInfoZza;
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String strZza = (String) map.get("u");
            if (TextUtils.isEmpty(strZza)) {
                return null;
            }
            if (this.zzpD != null) {
                strZza = com.google.android.gms.ads.internal.zzr.zzbC().zza(this.zzpD, strZza);
            }
            Uri uri = Uri.parse(strZza);
            boolean z = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean z2 = Boolean.parseBoolean((String) map.get("use_running_process"));
            Uri uriBuild = "http".equalsIgnoreCase(uri.getScheme()) ? uri.buildUpon().scheme("https").build() : "https".equalsIgnoreCase(uri.getScheme()) ? uri.buildUpon().scheme("http").build() : null;
            ArrayList arrayList = new ArrayList();
            Intent intentZzd = zzd(uri);
            Intent intentZzd2 = zzd(uriBuild);
            ResolveInfo resolveInfoZza2 = zza(context, intentZzd, arrayList);
            if (resolveInfoZza2 != null) {
                return zza(intentZzd, resolveInfoZza2);
            }
            if (intentZzd2 != null && (resolveInfoZza = zza(context, intentZzd2)) != null) {
                Intent intentZza = zza(intentZzd, resolveInfoZza);
                if (zza(context, intentZza) != null) {
                    return intentZza;
                }
            }
            if (arrayList.size() == 0) {
                return intentZzd;
            }
            if (z2 && activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ResolveInfo resolveInfo = (ResolveInfo) it.next();
                    Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().processName.equals(resolveInfo.activityInfo.packageName)) {
                            return zza(intentZzd, resolveInfo);
                        }
                    }
                }
            }
            return z ? zza(intentZzd, (ResolveInfo) arrayList.get(0)) : intentZzd;
        }

        public Intent zza(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public ResolveInfo zza(Context context, Intent intent) {
            return zza(context, intent, new ArrayList());
        }

        public ResolveInfo zza(Context context, Intent intent, ArrayList arrayList) {
            ResolveInfo resolveInfo;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 65536);
            if (listQueryIntentActivities != null && resolveInfoResolveActivity != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= listQueryIntentActivities.size()) {
                        break;
                    }
                    ResolveInfo resolveInfo2 = listQueryIntentActivities.get(i2);
                    if (resolveInfoResolveActivity != null && resolveInfoResolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                        resolveInfo = resolveInfoResolveActivity;
                        break;
                    }
                    i = i2 + 1;
                }
            } else {
                resolveInfo = null;
            }
            arrayList.addAll(listQueryIntentActivities);
            return resolveInfo;
        }

        public Intent zzd(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }
    }

    public zzdm(zzdh zzdhVar, com.google.android.gms.ads.internal.zze zzeVar, zzfn zzfnVar) {
        this.zzzD = zzdhVar;
        this.zzzA = zzeVar;
        this.zzzB = zzfnVar;
    }

    private static boolean zzc(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzr.zzbE().zzhw();
            }
            if ("l".equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzr.zzbE().zzhv();
            }
            if ("c".equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzr.zzbE().zzhx();
            }
        }
        return -1;
    }

    private static void zze(zzjp zzjpVar, Map map) {
        String str = (String) map.get("u");
        if (TextUtils.isEmpty(str)) {
            zzin.zzaK("Destination url cannot be empty.");
        } else {
            new zza(zzjpVar, str).zzgd();
        }
    }

    private static void zzf(zzjp zzjpVar, Map map) {
        Context context = zzjpVar.getContext();
        if (TextUtils.isEmpty((String) map.get("u"))) {
            zzin.zzaK("Destination url cannot be empty.");
            return;
        }
        try {
            zzjpVar.zzhU().zza(new AdLauncherIntentInfoParcel(new zzb(zzjpVar).zza(context, map)));
        } catch (ActivityNotFoundException e) {
            zzin.zzaK(e.getMessage());
        }
    }

    private void zzo(boolean z) {
        if (this.zzzB != null) {
            this.zzzB.zzp(z);
        }
    }

    @Override // com.google.android.gms.internal.zzdf
    public final void zza(zzjp zzjpVar, Map map) {
        String str = (String) map.get("a");
        if (str == null) {
            zzin.zzaK("Action missing from an open GMSG.");
            return;
        }
        if (this.zzzA != null && !this.zzzA.zzbh()) {
            this.zzzA.zzq((String) map.get("u"));
            return;
        }
        zzjq zzjqVarZzhU = zzjpVar.zzhU();
        if ("expand".equalsIgnoreCase(str)) {
            if (zzjpVar.zzhY()) {
                zzin.zzaK("Cannot expand WebView that is already expanded.");
                return;
            } else {
                zzo(false);
                zzjqVarZzhU.zza(zzc(map), zzd(map));
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str)) {
            String str2 = (String) map.get("u");
            zzo(false);
            if (str2 != null) {
                zzjqVarZzhU.zza(zzc(map), zzd(map), str2);
                return;
            } else {
                zzjqVarZzhU.zza(zzc(map), zzd(map), (String) map.get("html"), (String) map.get("baseurl"));
                return;
            }
        }
        if ("in_app_purchase".equalsIgnoreCase(str)) {
            String str3 = (String) map.get("product_id");
            String str4 = (String) map.get("report_urls");
            if (this.zzzD != null) {
                if (str4 == null || str4.isEmpty()) {
                    this.zzzD.zza(str3, new ArrayList());
                    return;
                } else {
                    this.zzzD.zza(str3, new ArrayList(Arrays.asList(str4.split(" "))));
                    return;
                }
            }
            return;
        }
        if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("play_store"))) {
            zze(zzjpVar, map);
            return;
        }
        if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
            zzo(true);
            zzf(zzjpVar, map);
        } else {
            zzo(true);
            String str5 = (String) map.get("u");
            zzjqVarZzhU.zza(new AdLauncherIntentInfoParcel((String) map.get("i"), !TextUtils.isEmpty(str5) ? com.google.android.gms.ads.internal.zzr.zzbC().zza(zzjpVar, str5) : str5, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
        }
    }
}
