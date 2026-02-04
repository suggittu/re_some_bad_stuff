package android.support.v4.media;

import android.content.Intent;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.support.v4.media.IMediaBrowserServiceAdapterApi21;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class MediaBrowserServiceCompatApi21 {

    class MediaBrowserServiceAdaptorApi21 {
        ServiceBinderProxyApi21 mBinder;

        class ServiceBinderProxyApi21 extends IMediaBrowserServiceAdapterApi21.Stub {
            final ServiceImplApi21 mServiceImpl;

            ServiceBinderProxyApi21(ServiceImplApi21 serviceImplApi21) {
                this.mServiceImpl = serviceImplApi21;
            }

            @Override // android.support.v4.media.IMediaBrowserServiceAdapterApi21.Stub
            public void addSubscription(String str, Object obj) {
                this.mServiceImpl.addSubscription(str, new ServiceCallbacksApi21(obj));
            }

            @Override // android.support.v4.media.IMediaBrowserServiceAdapterApi21.Stub
            public void connect(String str, Bundle bundle, Object obj) {
                this.mServiceImpl.connect(str, bundle, new ServiceCallbacksApi21(obj));
            }

            @Override // android.support.v4.media.IMediaBrowserServiceAdapterApi21.Stub
            public void disconnect(Object obj) {
                this.mServiceImpl.disconnect(new ServiceCallbacksApi21(obj));
            }

            @Override // android.support.v4.media.IMediaBrowserServiceAdapterApi21.Stub
            public void getMediaItem(String str, ResultReceiver resultReceiver) {
            }

            @Override // android.support.v4.media.IMediaBrowserServiceAdapterApi21.Stub
            public void removeSubscription(String str, Object obj) {
                this.mServiceImpl.removeSubscription(str, new ServiceCallbacksApi21(obj));
            }
        }

        MediaBrowserServiceAdaptorApi21() {
        }

        public IBinder onBind(Intent intent) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction())) {
                return this.mBinder;
            }
            return null;
        }

        public void onCreate(ServiceImplApi21 serviceImplApi21) {
            this.mBinder = new ServiceBinderProxyApi21(serviceImplApi21);
        }
    }

    public interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String str, Object obj, Bundle bundle);

        void onConnectFailed();

        void onLoadChildren(String str, List list);
    }

    public class ServiceCallbacksApi21 implements ServiceCallbacks {
        private static Object sNullParceledListSliceObj;
        private final IMediaBrowserServiceCallbacksAdapterApi21 mCallbacks;

        static {
            MediaBrowser.MediaItem mediaItem = new MediaBrowser.MediaItem(new MediaDescription.Builder().setMediaId("android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM").build(), 0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediaItem);
            sNullParceledListSliceObj = ParceledListSliceAdapterApi21.newInstance(arrayList);
        }

        ServiceCallbacksApi21(Object obj) {
            this.mCallbacks = new IMediaBrowserServiceCallbacksAdapterApi21(obj);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCallbacks
        public IBinder asBinder() {
            return this.mCallbacks.asBinder();
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCallbacks
        public void onConnect(String str, Object obj, Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.mCallbacks.onConnect(str, obj, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCallbacks
        public void onConnectFailed() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.mCallbacks.onConnectFailed();
        }

        @Override // android.support.v4.media.MediaBrowserServiceCompatApi21.ServiceCallbacks
        public void onLoadChildren(String str, List list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            ArrayList arrayList;
            Object objNewInstance = null;
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Parcel parcel = (Parcel) it.next();
                    parcel.setDataPosition(0);
                    arrayList2.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                    parcel.recycle();
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            if (Build.VERSION.SDK_INT <= 23) {
                objNewInstance = arrayList == null ? sNullParceledListSliceObj : ParceledListSliceAdapterApi21.newInstance(arrayList);
            } else if (arrayList != null) {
                objNewInstance = ParceledListSliceAdapterApi21.newInstance(arrayList);
            }
            this.mCallbacks.onLoadChildren(str, objNewInstance);
        }
    }

    public interface ServiceImplApi21 {
        void addSubscription(String str, ServiceCallbacks serviceCallbacks);

        void connect(String str, Bundle bundle, ServiceCallbacks serviceCallbacks);

        void disconnect(ServiceCallbacks serviceCallbacks);

        void removeSubscription(String str, ServiceCallbacks serviceCallbacks);
    }

    MediaBrowserServiceCompatApi21() {
    }

    public static Object createService() {
        return new MediaBrowserServiceAdaptorApi21();
    }

    public static IBinder onBind(Object obj, Intent intent) {
        return ((MediaBrowserServiceAdaptorApi21) obj).onBind(intent);
    }

    public static void onCreate(Object obj, ServiceImplApi21 serviceImplApi21) {
        ((MediaBrowserServiceAdaptorApi21) obj).onCreate(serviceImplApi21);
    }
}
