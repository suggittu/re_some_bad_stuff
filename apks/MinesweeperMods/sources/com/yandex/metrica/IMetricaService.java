package com.yandex.metrica;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IMetricaService extends IInterface {
    void reportData(Bundle bundle) throws RemoteException;

    void reportEvent(String str, int i, String str2, Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IMetricaService {
        public Stub() {
            attachInterface(this, "com.yandex.metrica.IMetricaService");
        }

        public static IMetricaService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface("com.yandex.metrica.IMetricaService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMetricaService)) {
                return (IMetricaService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.yandex.metrica.IMetricaService");
                    reportEvent(data.readString(), data.readInt(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case 2:
                    data.enforceInterface("com.yandex.metrica.IMetricaService");
                    reportData(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.yandex.metrica.IMetricaService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IMetricaService {
            private IBinder a;

            Proxy(IBinder remote) {
                this.a = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.yandex.metrica.IMetricaService
            public void reportEvent(String event, int type, String value, Bundle libCfg) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.yandex.metrica.IMetricaService");
                    parcelObtain.writeString(event);
                    parcelObtain.writeInt(type);
                    parcelObtain.writeString(value);
                    if (libCfg != null) {
                        parcelObtain.writeInt(1);
                        libCfg.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.yandex.metrica.IMetricaService
            public void reportData(Bundle data) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.yandex.metrica.IMetricaService");
                    if (data != null) {
                        parcelObtain.writeInt(1);
                        data.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }
}
