package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.zzau;
import com.google.android.gms.wearable.internal.zzav;

/* loaded from: classes2.dex */
public interface zzax extends IInterface {

    public abstract class zza extends Binder implements zzax {

        /* renamed from: com.google.android.gms.wearable.internal.zzax$zza$zza, reason: collision with other inner class name */
        class C0268zza implements zzax {
            private IBinder zzoz;

            C0268zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, byte b) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeByte(b);
                    this.zzoz.transact(53, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(43, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, Uri uri) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, Uri uri, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(40, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, Asset asset) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    if (asset != null) {
                        parcelObtain.writeInt(1);
                        asset.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, ConnectionConfiguration connectionConfiguration) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    if (connectionConfiguration != null) {
                        parcelObtain.writeInt(1);
                        connectionConfiguration.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, PutDataRequest putDataRequest) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    if (putDataRequest != null) {
                        parcelObtain.writeInt(1);
                        putDataRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, AddListenerRequest addListenerRequest) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    if (addListenerRequest != null) {
                        parcelObtain.writeInt(1);
                        addListenerRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, AncsNotificationParcelable ancsNotificationParcelable) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    if (ancsNotificationParcelable != null) {
                        parcelObtain.writeInt(1);
                        ancsNotificationParcelable.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(27, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, RemoveListenerRequest removeListenerRequest) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    if (removeListenerRequest != null) {
                        parcelObtain.writeInt(1);
                        removeListenerRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, zzau zzauVar, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeStrongBinder(zzauVar != null ? zzauVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(34, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(42, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, String str, ParcelFileDescriptor parcelFileDescriptor) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        parcelObtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(38, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        parcelObtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    this.zzoz.transact(39, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.zzoz.transact(31, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, String str, String str2, byte[] bArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    this.zzoz.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zza(zzav zzavVar, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(48, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzb(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzb(zzav zzavVar, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(28, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzb(zzav zzavVar, Uri uri) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzb(zzav zzavVar, Uri uri, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(41, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzb(zzav zzavVar, ConnectionConfiguration connectionConfiguration) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    if (connectionConfiguration != null) {
                        parcelObtain.writeInt(1);
                        connectionConfiguration.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzb(zzav zzavVar, zzau zzauVar, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeStrongBinder(zzauVar != null ? zzauVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(35, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzb(zzav zzavVar, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzb(zzav zzavVar, String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(33, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzb(zzav zzavVar, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(50, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzc(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzc(zzav zzavVar, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(29, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzc(zzav zzavVar, Uri uri) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzc(zzav zzavVar, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(24, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzd(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzd(zzav zzavVar, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(46, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zze(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zze(zzav zzavVar, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(47, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzf(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzf(zzav zzavVar, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(32, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzg(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(25, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzh(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(26, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzi(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(30, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzj(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(37, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzk(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(49, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzl(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(51, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzm(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(52, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzn(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzo(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.wearable.internal.zzax
            public void zzp(zzav zzavVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    parcelObtain.writeStrongBinder(zzavVar != null ? zzavVar.asBinder() : null);
                    this.zzoz.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzax zzeu(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzax)) ? new C0268zza(iBinder) : (zzax) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 2:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt() != 0 ? (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzn(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzo(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzp(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt() != 0 ? (PutDataRequest) PutDataRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Asset) Asset.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzd(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt() != 0 ? (AddListenerRequest) AddListenerRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt() != 0 ? (RemoveListenerRequest) RemoveListenerRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zze(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzf(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt() != 0 ? (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzg(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_CONVENIENCE_STORE /* 26 */:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzh(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_COURTHOUSE /* 27 */:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt() != 0 ? (AncsNotificationParcelable) AncsNotificationParcelable.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_DENTIST /* 28 */:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_DEPARTMENT_STORE /* 29 */:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzc(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzi(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzf(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), zzau.zza.zzer(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(zzav.zza.zzes(parcel.readStrongBinder()), zzau.zza.zzer(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzj(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null, parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 46:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzd(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zze(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_HINDU_TEMPLE /* 48 */:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_HOME_GOODS_STORE /* 49 */:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzk(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_HOSPITAL /* 50 */:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzb(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_INSURANCE_AGENCY /* 51 */:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzl(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_JEWELRY_STORE /* 52 */:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zzm(zzav.zza.zzes(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_LAUNDRY /* 53 */:
                    parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    zza(zzav.zza.zzes(parcel.readStrongBinder()), parcel.readByte());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.wearable.internal.IWearableService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzav zzavVar);

    void zza(zzav zzavVar, byte b);

    void zza(zzav zzavVar, int i);

    void zza(zzav zzavVar, Uri uri);

    void zza(zzav zzavVar, Uri uri, int i);

    void zza(zzav zzavVar, Asset asset);

    void zza(zzav zzavVar, ConnectionConfiguration connectionConfiguration);

    void zza(zzav zzavVar, PutDataRequest putDataRequest);

    void zza(zzav zzavVar, AddListenerRequest addListenerRequest);

    void zza(zzav zzavVar, AncsNotificationParcelable ancsNotificationParcelable);

    void zza(zzav zzavVar, RemoveListenerRequest removeListenerRequest);

    void zza(zzav zzavVar, zzau zzauVar, String str);

    void zza(zzav zzavVar, String str);

    void zza(zzav zzavVar, String str, int i);

    void zza(zzav zzavVar, String str, ParcelFileDescriptor parcelFileDescriptor);

    void zza(zzav zzavVar, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2);

    void zza(zzav zzavVar, String str, String str2);

    void zza(zzav zzavVar, String str, String str2, byte[] bArr);

    void zza(zzav zzavVar, boolean z);

    void zzb(zzav zzavVar);

    void zzb(zzav zzavVar, int i);

    void zzb(zzav zzavVar, Uri uri);

    void zzb(zzav zzavVar, Uri uri, int i);

    void zzb(zzav zzavVar, ConnectionConfiguration connectionConfiguration);

    void zzb(zzav zzavVar, zzau zzauVar, String str);

    void zzb(zzav zzavVar, String str);

    void zzb(zzav zzavVar, String str, int i);

    void zzb(zzav zzavVar, boolean z);

    void zzc(zzav zzavVar);

    void zzc(zzav zzavVar, int i);

    void zzc(zzav zzavVar, Uri uri);

    void zzc(zzav zzavVar, String str);

    void zzd(zzav zzavVar);

    void zzd(zzav zzavVar, String str);

    void zze(zzav zzavVar);

    void zze(zzav zzavVar, String str);

    void zzf(zzav zzavVar);

    void zzf(zzav zzavVar, String str);

    void zzg(zzav zzavVar);

    void zzh(zzav zzavVar);

    void zzi(zzav zzavVar);

    void zzj(zzav zzavVar);

    void zzk(zzav zzavVar);

    void zzl(zzav zzavVar);

    void zzm(zzav zzavVar);

    void zzn(zzav zzavVar);

    void zzo(zzav zzavVar);

    void zzp(zzav zzavVar);
}
