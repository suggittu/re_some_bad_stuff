package com.google.android.gms.appinvite;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class PreviewActivity extends Activity {
    public static final String ACTION_PREVIEW = "com.google.android.gms.appinvite.ACTION_PREVIEW";
    public static final String EXTRA_LAYOUT_RES_ID = "com.google.android.gms.appinvite.LAYOUT_RES_ID";
    public static final String EXTRA_TABS = "com.google.android.gms.appinvite.TABS";
    public static final String EXTRA_VIEWS = "com.google.android.gms.appinvite.VIEWS";
    public static final String KEY_TAB_CONTENT_ID = "tabContentId";
    public static final String KEY_TAB_TAG = "tabTag";
    public static final String KEY_TEXT_VIEW_IS_TITLE = "TextView_isTitle";
    public static final String KEY_TEXT_VIEW_TEXT = "TextView_text";
    public static final String KEY_TEXT_VIEW_TEXT_COLOR = "TextView_textColor";
    public static final String KEY_VIEW_BACKGROUND_COLOR = "View_backgroundColor";
    public static final String KEY_VIEW_ID = "View_id";
    public static final String KEY_VIEW_MIN_HEIGHT = "View_minHeight";
    public static final String KEY_VIEW_ON_CLICK_LISTENER = "View_onClickListener";
    public static final String KEY_WEB_VIEW_DATA = "WebView_data";
    public static final String ON_CLICK_LISTENER_CLOSE = "close";

    private View zza(Context context, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = LayoutInflater.from(context).inflate(bundle.getInt(EXTRA_LAYOUT_RES_ID), viewGroup, false);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(EXTRA_VIEWS);
        if (parcelableArrayList != null) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                zza(viewInflate, (Bundle) it.next());
            }
        }
        return viewInflate;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void zza(android.view.View r9, android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.appinvite.PreviewActivity.zza(android.view.View, android.os.Bundle):void");
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getCallingActivity() == null || !"com.google.android.gms".equals(getCallingActivity().getPackageName())) {
            finish();
            return;
        }
        try {
            Context contextCreatePackageContext = createPackageContext("com.google.android.gms", 0);
            Bundle extras = getIntent().getExtras();
            View viewZza = zza(contextCreatePackageContext, null, extras);
            if (viewZza == null) {
                finish();
                return;
            }
            TabHost tabHost = (TabHost) viewZza.findViewById(R.id.tabhost);
            TabWidget tabWidget = (TabWidget) viewZza.findViewById(R.id.tabs);
            ArrayList parcelableArrayList = extras.getParcelableArrayList(EXTRA_TABS);
            if (tabHost != null && tabWidget != null && parcelableArrayList != null) {
                tabHost.setup();
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    Bundle bundle2 = (Bundle) it.next();
                    TabHost.TabSpec tabSpecNewTabSpec = tabHost.newTabSpec(bundle2.getString(KEY_TAB_TAG));
                    tabSpecNewTabSpec.setContent(bundle2.getInt(KEY_TAB_CONTENT_ID));
                    tabSpecNewTabSpec.setIndicator(zza(contextCreatePackageContext, tabWidget, bundle2));
                    tabHost.addTab(tabSpecNewTabSpec);
                }
            }
            setContentView(viewZza);
        } catch (PackageManager.NameNotFoundException e) {
            finish();
        }
    }
}
