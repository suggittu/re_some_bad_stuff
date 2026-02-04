package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RawRes;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public class TagManager {
    private static TagManager zzblm;
    private final Context mContext;
    private final DataLayer zzbhN;
    private final zzs zzbkh;
    private final zza zzblj;
    private final zzct zzblk;
    private final ConcurrentMap zzbll;

    public interface zza {
        zzp zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzs zzsVar);
    }

    TagManager(Context context, zza zzaVar, DataLayer dataLayer, zzct zzctVar) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.zzblk = zzctVar;
        this.zzblj = zzaVar;
        this.zzbll = new ConcurrentHashMap();
        this.zzbhN = dataLayer;
        this.zzbhN.zza(new DataLayer.zzb() { // from class: com.google.android.gms.tagmanager.TagManager.1
            @Override // com.google.android.gms.tagmanager.DataLayer.zzb
            public void zzQ(Map map) {
                Object obj = map.get("event");
                if (obj != null) {
                    TagManager.this.zzgp(obj.toString());
                }
            }
        });
        this.zzbhN.zza(new zzd(this.mContext));
        this.zzbkh = new zzs();
        zzHt();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (zzblm == null) {
                if (context == null) {
                    zzbg.e("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                zzblm = new TagManager(context, new zza() { // from class: com.google.android.gms.tagmanager.TagManager.2
                    @Override // com.google.android.gms.tagmanager.TagManager.zza
                    public final zzp zza(Context context2, TagManager tagManager2, Looper looper, String str, int i, zzs zzsVar) {
                        return new zzp(context2, tagManager2, looper, str, i, zzsVar);
                    }
                }, new DataLayer(new zzw(context)), zzcu.zzHo());
            }
            tagManager = zzblm;
        }
        return tagManager;
    }

    @TargetApi(14)
    private void zzHt() {
        if (Build.VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new ComponentCallbacks2() { // from class: com.google.android.gms.tagmanager.TagManager.3
                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(Configuration configuration) {
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                }

                @Override // android.content.ComponentCallbacks2
                public void onTrimMemory(int i) {
                    if (i == 20) {
                        TagManager.this.dispatch();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzgp(String str) {
        Iterator it = this.zzbll.keySet().iterator();
        while (it.hasNext()) {
            ((zzo) it.next()).zzfR(str);
        }
    }

    public void dispatch() {
        this.zzblk.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.zzbhN;
    }

    public PendingResult loadContainerDefaultOnly(String str, @RawRes int i) {
        zzp zzpVarZza = this.zzblj.zza(this.mContext, this, null, str, i, this.zzbkh);
        zzpVarZza.zzGg();
        return zzpVarZza;
    }

    public PendingResult loadContainerDefaultOnly(String str, @RawRes int i, Handler handler) {
        zzp zzpVarZza = this.zzblj.zza(this.mContext, this, handler.getLooper(), str, i, this.zzbkh);
        zzpVarZza.zzGg();
        return zzpVarZza;
    }

    public PendingResult loadContainerPreferFresh(String str, @RawRes int i) {
        zzp zzpVarZza = this.zzblj.zza(this.mContext, this, null, str, i, this.zzbkh);
        zzpVarZza.zzGi();
        return zzpVarZza;
    }

    public PendingResult loadContainerPreferFresh(String str, @RawRes int i, Handler handler) {
        zzp zzpVarZza = this.zzblj.zza(this.mContext, this, handler.getLooper(), str, i, this.zzbkh);
        zzpVarZza.zzGi();
        return zzpVarZza;
    }

    public PendingResult loadContainerPreferNonDefault(String str, @RawRes int i) {
        zzp zzpVarZza = this.zzblj.zza(this.mContext, this, null, str, i, this.zzbkh);
        zzpVarZza.zzGh();
        return zzpVarZza;
    }

    public PendingResult loadContainerPreferNonDefault(String str, @RawRes int i, Handler handler) {
        zzp zzpVarZza = this.zzblj.zza(this.mContext, this, handler.getLooper(), str, i, this.zzbkh);
        zzpVarZza.zzGh();
        return zzpVarZza;
    }

    public void setVerboseLoggingEnabled(boolean z) {
        zzbg.setLogLevel(z ? 2 : 5);
    }

    public void zza(zzo zzoVar) {
        this.zzbll.put(zzoVar, true);
    }

    public boolean zzb(zzo zzoVar) {
        return this.zzbll.remove(zzoVar) != null;
    }

    synchronized boolean zzp(Uri uri) {
        boolean z;
        zzcb zzcbVarZzGU = zzcb.zzGU();
        if (zzcbVarZzGU.zzp(uri)) {
            String containerId = zzcbVarZzGU.getContainerId();
            switch (zzcbVarZzGU.zzGV()) {
                case NONE:
                    for (zzo zzoVar : this.zzbll.keySet()) {
                        if (zzoVar.getContainerId().equals(containerId)) {
                            zzoVar.zzfT(null);
                            zzoVar.refresh();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (zzo zzoVar2 : this.zzbll.keySet()) {
                        if (zzoVar2.getContainerId().equals(containerId)) {
                            zzoVar2.zzfT(zzcbVarZzGU.zzGW());
                            zzoVar2.refresh();
                        } else if (zzoVar2.zzGd() != null) {
                            zzoVar2.zzfT(null);
                            zzoVar2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
