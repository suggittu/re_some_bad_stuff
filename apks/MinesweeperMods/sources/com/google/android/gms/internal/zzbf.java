package com.google.android.gms.internal;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
@TargetApi(14)
/* loaded from: classes2.dex */
public class zzbf extends Thread {
    private final zzbe zzsZ;
    private final zzbd zzta;
    private final zzha zztb;
    private boolean mStarted = false;
    private boolean zzsY = false;
    private boolean zzam = false;
    private final Object zzpV = new Object();
    private final int zzsK = ((Integer) zzbt.zzwk.get()).intValue();
    private final int zztd = ((Integer) zzbt.zzwl.get()).intValue();
    private final int zzsM = ((Integer) zzbt.zzwm.get()).intValue();
    private final int zzte = ((Integer) zzbt.zzwn.get()).intValue();
    private final int zztc = ((Integer) zzbt.zzwo.get()).intValue();

    @zzhb
    class zza {
        final int zztm;
        final int zztn;

        zza(int i, int i2) {
            this.zztm = i;
            this.zztn = i2;
        }
    }

    public zzbf(zzbe zzbeVar, zzbd zzbdVar, zzha zzhaVar) {
        this.zzsZ = zzbeVar;
        this.zzta = zzbdVar;
        this.zztb = zzhaVar;
        setName("ContentFetchTask");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.zzam) {
            try {
            } catch (Throwable th) {
                zzin.zzb("Error in ContentFetchTask", th);
                this.zztb.zza(th, true);
            }
            if (zzcH()) {
                Activity activity = this.zzsZ.getActivity();
                if (activity == null) {
                    zzin.zzaI("ContentFetchThread: no activity");
                } else {
                    zza(activity);
                }
            } else {
                zzin.zzaI("ContentFetchTask: sleeping");
                zzcJ();
            }
            Thread.sleep(this.zztc * 1000);
            synchronized (this.zzpV) {
                while (this.zzsY) {
                    try {
                        zzin.zzaI("ContentFetchTask: waiting");
                        this.zzpV.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void wakeup() {
        synchronized (this.zzpV) {
            this.zzsY = false;
            this.zzpV.notifyAll();
            zzin.zzaI("ContentFetchThread: wakeup");
        }
    }

    zza zza(View view, zzbc zzbcVar) {
        int i = 0;
        if (view == null) {
            return new zza(0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zza(0, 0);
            }
            zzbcVar.zzd(text.toString(), globalVisibleRect);
            return new zza(1, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzjp)) {
            zzbcVar.zzcC();
            return zza((WebView) view, zzbcVar, globalVisibleRect) ? new zza(0, 1) : new zza(0, 0);
        }
        if (!(view instanceof ViewGroup)) {
            return new zza(0, 0);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i2 = 0;
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            zza zzaVarZza = zza(viewGroup.getChildAt(i3), zzbcVar);
            i2 += zzaVarZza.zztm;
            i += zzaVarZza.zztn;
        }
        return new zza(i2, i);
    }

    void zza(Activity activity) {
        if (activity == null) {
            return;
        }
        View viewFindViewById = null;
        if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            viewFindViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
        }
        if (viewFindViewById != null) {
            zze(viewFindViewById);
        }
    }

    void zza(zzbc zzbcVar, WebView webView, String str, boolean z) {
        zzbcVar.zzcB();
        try {
            if (!TextUtils.isEmpty(str)) {
                String strOptString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    zzbcVar.zzc(strOptString, z);
                } else {
                    zzbcVar.zzc(webView.getTitle() + "\n" + strOptString, z);
                }
            }
            if (zzbcVar.zzcx()) {
                this.zzta.zzb(zzbcVar);
            }
        } catch (JSONException e) {
            zzin.zzaI("Json string may be malformed.");
        } catch (Throwable th) {
            zzin.zza("Failed to get webview content.", th);
            this.zztb.zza(th, true);
        }
    }

    boolean zza(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    @TargetApi(19)
    boolean zza(final WebView webView, final zzbc zzbcVar, final boolean z) {
        if (!zzne.zzsk()) {
            return false;
        }
        zzbcVar.zzcC();
        webView.post(new Runnable() { // from class: com.google.android.gms.internal.zzbf.2
            ValueCallback zzth = new ValueCallback() { // from class: com.google.android.gms.internal.zzbf.2.1
                @Override // android.webkit.ValueCallback
                /* renamed from: zzt, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(String str) {
                    zzbf.this.zza(zzbcVar, webView, str, z);
                }
            };

            @Override // java.lang.Runnable
            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    try {
                        webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzth);
                    } catch (Throwable th) {
                        this.zzth.onReceiveValue("");
                    }
                }
            }
        });
        return true;
    }

    public void zzcG() {
        synchronized (this.zzpV) {
            if (this.mStarted) {
                zzin.zzaI("Content hash thread already started, quiting...");
            } else {
                this.mStarted = true;
                start();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        if (zza(r0) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r1.inKeyguardRestrictedInputMode() != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
    
        if (zzs(r3) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean zzcH() {
        /*
            r7 = this;
            r2 = 0
            com.google.android.gms.internal.zzbe r0 = r7.zzsZ     // Catch: java.lang.Throwable -> L57
            android.content.Context r3 = r0.getContext()     // Catch: java.lang.Throwable -> L57
            if (r3 != 0) goto Lb
            r0 = r2
        La:
            return r0
        Lb:
            java.lang.String r0 = "activity"
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch: java.lang.Throwable -> L57
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch: java.lang.Throwable -> L57
            java.lang.String r1 = "keyguard"
            java.lang.Object r1 = r3.getSystemService(r1)     // Catch: java.lang.Throwable -> L57
            android.app.KeyguardManager r1 = (android.app.KeyguardManager) r1     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L1f
            if (r1 != 0) goto L21
        L1f:
            r0 = r2
            goto La
        L21:
            java.util.List r0 = r0.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L57
            if (r0 != 0) goto L29
            r0 = r2
            goto La
        L29:
            java.util.Iterator r4 = r0.iterator()     // Catch: java.lang.Throwable -> L57
        L2d:
            boolean r0 = r4.hasNext()     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L55
            java.lang.Object r0 = r4.next()     // Catch: java.lang.Throwable -> L57
            android.app.ActivityManager$RunningAppProcessInfo r0 = (android.app.ActivityManager.RunningAppProcessInfo) r0     // Catch: java.lang.Throwable -> L57
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L57
            int r6 = r0.pid     // Catch: java.lang.Throwable -> L57
            if (r5 != r6) goto L2d
            boolean r0 = r7.zza(r0)     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L55
            boolean r0 = r1.inKeyguardRestrictedInputMode()     // Catch: java.lang.Throwable -> L57
            if (r0 != 0) goto L55
            boolean r0 = r7.zzs(r3)     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L55
            r0 = 1
            goto La
        L55:
            r0 = r2
            goto La
        L57:
            r0 = move-exception
            r0 = r2
            goto La
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbf.zzcH():boolean");
    }

    public zzbc zzcI() {
        return this.zzta.zzcF();
    }

    public void zzcJ() {
        synchronized (this.zzpV) {
            this.zzsY = true;
            zzin.zzaI("ContentFetchThread: paused, mPause = " + this.zzsY);
        }
    }

    public boolean zzcK() {
        return this.zzsY;
    }

    boolean zze(final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable() { // from class: com.google.android.gms.internal.zzbf.1
            @Override // java.lang.Runnable
            public void run() {
                zzbf.this.zzf(view);
            }
        });
        return true;
    }

    void zzf(View view) {
        try {
            zzbc zzbcVar = new zzbc(this.zzsK, this.zztd, this.zzsM, this.zzte);
            zza zzaVarZza = zza(view, zzbcVar);
            zzbcVar.zzcD();
            if (zzaVarZza.zztm == 0 && zzaVarZza.zztn == 0) {
                return;
            }
            if (zzaVarZza.zztn == 0 && zzbcVar.zzcE() == 0) {
                return;
            }
            if (zzaVarZza.zztn == 0 && this.zzta.zza(zzbcVar)) {
                return;
            }
            this.zzta.zzc(zzbcVar);
        } catch (Exception e) {
            zzin.zzb("Exception in fetchContentOnUIThread", e);
            this.zztb.zza(e, true);
        }
    }

    boolean zzs(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }
}
