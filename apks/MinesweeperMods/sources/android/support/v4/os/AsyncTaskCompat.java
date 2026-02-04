package android.support.v4.os;

import android.os.AsyncTask;
import android.os.Build;

/* loaded from: classes2.dex */
public final class AsyncTaskCompat {
    private AsyncTaskCompat() {
    }

    public static AsyncTask executeParallel(AsyncTask asyncTask, Object... objArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (Build.VERSION.SDK_INT >= 11) {
            AsyncTaskCompatHoneycomb.executeParallel(asyncTask, objArr);
        } else {
            asyncTask.execute(objArr);
        }
        return asyncTask;
    }
}
