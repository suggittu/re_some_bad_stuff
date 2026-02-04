package ru.anna.chinagame;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

/* loaded from: classes.dex */
public class DownloadUtility {
    private static final String[] DOWNLOAD_FILE_TYPES = {".jpg", ".png", ".bmp", ".mp3", ".mp4"};

    public static void downloadFile(Context context, String url, String fileName) {
        if (Build.VERSION.SDK_INT > 13) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
            Log.e("test", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            if (url.contains(".apk")) {
                request.setMimeType("application/vnd.android.package-archive");
            }
            DownloadManager manager = (DownloadManager) context.getSystemService("download");
            manager.enqueue(request);
            return;
        }
        if (url != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
            }
        }
    }

    public static boolean isDownloadableFile(String url) {
        int index = url.indexOf("?");
        if (index > -1) {
            url = url.substring(0, index);
        }
        String url2 = url.toLowerCase();
        for (String type : DOWNLOAD_FILE_TYPES) {
            if (url2.endsWith(type)) {
                return true;
            }
        }
        return false;
    }

    public static String getFileName(String url) {
        int index = url.indexOf("?");
        if (index > -1) {
            url = url.substring(0, index);
        }
        String url2 = url.toLowerCase();
        int index2 = url2.lastIndexOf("/");
        return index2 > -1 ? url2.substring(index2 + 1, url2.length()) : Long.toString(System.currentTimeMillis());
    }
}
