package android.support.v4.media;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
class IMediaBrowserServiceCallbacksAdapterApi21 {
    private Method mAsBinderMethod;
    Object mCallbackObject;
    private Method mOnConnectFailedMethod;
    private Method mOnConnectMethod;
    private Method mOnLoadChildrenMethod;

    class Stub {
        static Method sAsInterfaceMethod;

        static {
            try {
                sAsInterfaceMethod = Class.forName("android.service.media.IMediaBrowserServiceCallbacks$Stub").getMethod("asInterface", IBinder.class);
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        Stub() {
        }

        static Object asInterface(IBinder iBinder) {
            try {
                return sAsInterfaceMethod.invoke(null, iBinder);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    IMediaBrowserServiceCallbacksAdapterApi21(Object obj) throws ClassNotFoundException {
        this.mCallbackObject = obj;
        try {
            Class<?> cls = Class.forName("android.service.media.IMediaBrowserServiceCallbacks");
            Class<?> cls2 = Class.forName("android.content.pm.ParceledListSlice");
            this.mAsBinderMethod = cls.getMethod("asBinder", new Class[0]);
            this.mOnConnectMethod = cls.getMethod("onConnect", String.class, MediaSession.Token.class, Bundle.class);
            this.mOnConnectFailedMethod = cls.getMethod("onConnectFailed", new Class[0]);
            this.mOnLoadChildrenMethod = cls.getMethod("onLoadChildren", String.class, cls2);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    IBinder asBinder() {
        try {
            return (IBinder) this.mAsBinderMethod.invoke(this.mCallbackObject, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    void onConnect(String str, Object obj, Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.mOnConnectMethod.invoke(this.mCallbackObject, str, obj, bundle);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    void onConnectFailed() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.mOnConnectFailedMethod.invoke(this.mCallbackObject, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    void onLoadChildren(String str, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.mOnLoadChildrenMethod.invoke(this.mCallbackObject, str, obj);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
