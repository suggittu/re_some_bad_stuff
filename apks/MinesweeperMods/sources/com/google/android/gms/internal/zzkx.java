package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.consent.GetConsentIntentRequest;

/* loaded from: classes2.dex */
public interface zzkx extends IInterface {

    public abstract class zza extends Binder implements zzkx {

        /* renamed from: com.google.android.gms.internal.zzkx$zza$zza, reason: collision with other inner class name */
        class C0117zza implements zzkx {
            private IBinder zzoz;

            C0117zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.internal.zzkx
            public Intent zza(GetConsentIntentRequest getConsentIntentRequest) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.consent.internal.IConsentService");
                    if (getConsentIntentRequest != null) {
                        parcelObtain.writeInt(1);
                        getConsentIntentRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzkx zzau(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.consent.internal.IConsentService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzkx)) ? new C0117zza(iBinder) : (zzkx) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.auth.api.consent.internal.IConsentService");
                    Intent intentZza = zza(parcel.readInt() != 0 ? (GetConsentIntentRequest) GetConsentIntentRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (intentZza != null) {
                        parcel2.writeInt(1);
                        intentZza.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.auth.api.consent.internal.IConsentService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Intent zza(GetConsentIntentRequest getConsentIntentRequest);
}
