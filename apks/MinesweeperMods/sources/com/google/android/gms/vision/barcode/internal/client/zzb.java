package com.google.android.gms.vision.barcode.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

/* loaded from: classes2.dex */
public interface zzb extends IInterface {

    public abstract class zza extends Binder implements zzb {

        /* renamed from: com.google.android.gms.vision.barcode.internal.client.zzb$zza$zza, reason: collision with other inner class name */
        class C0261zza implements zzb {
            private IBinder zzoz;

            C0261zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.vision.barcode.internal.client.zzb
            public Barcode[] zza(com.google.android.gms.dynamic.zzd zzdVar, FrameMetadataParcel frameMetadataParcel) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    parcelObtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (frameMetadataParcel != null) {
                        parcelObtain.writeInt(1);
                        frameMetadataParcel.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Barcode[]) parcelObtain2.createTypedArray(Barcode.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.vision.barcode.internal.client.zzb
            public Barcode[] zzb(com.google.android.gms.dynamic.zzd zzdVar, FrameMetadataParcel frameMetadataParcel) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    parcelObtain.writeStrongBinder(zzdVar != null ? zzdVar.asBinder() : null);
                    if (frameMetadataParcel != null) {
                        parcelObtain.writeInt(1);
                        frameMetadataParcel.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Barcode[]) parcelObtain2.createTypedArray(Barcode.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzb zzed(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzb)) ? new C0261zza(iBinder) : (zzb) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    Barcode[] barcodeArrZza = zza(zzd.zza.zzbs(parcel.readStrongBinder()), parcel.readInt() != 0 ? FrameMetadataParcel.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(barcodeArrZza, 1);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    Barcode[] barcodeArrZzb = zzb(zzd.zza.zzbs(parcel.readStrongBinder()), parcel.readInt() != 0 ? FrameMetadataParcel.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeTypedArray(barcodeArrZzb, 1);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Barcode[] zza(com.google.android.gms.dynamic.zzd zzdVar, FrameMetadataParcel frameMetadataParcel);

    Barcode[] zzb(com.google.android.gms.dynamic.zzd zzdVar, FrameMetadataParcel frameMetadataParcel);
}
