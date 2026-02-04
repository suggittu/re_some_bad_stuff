package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.zzqm;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.AppMetadata;

/* loaded from: classes2.dex */
public interface zzqn extends IInterface {

    public abstract class zza extends Binder implements zzqn {

        /* renamed from: com.google.android.gms.internal.zzqn$zza$zza, reason: collision with other inner class name */
        class C0160zza implements zzqn {
            private IBinder zzoz;

            C0160zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.internal.zzqn
            public String zzEk() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    this.zzoz.transact(Place.TYPE_POSTAL_CODE_PREFIX, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqn
            public void zzF(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_POST_BOX, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqn
            public void zza(zzqm zzqmVar, int i, long j, long j2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    parcelObtain.writeStrongBinder(zzqmVar != null ? zzqmVar.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    this.zzoz.transact(Place.TYPE_COUNTRY, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqn
            public void zza(zzqm zzqmVar, String str, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    parcelObtain.writeStrongBinder(zzqmVar != null ? zzqmVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_LOCALITY, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqn
            public void zza(zzqm zzqmVar, String str, long j, long j2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    parcelObtain.writeStrongBinder(zzqmVar != null ? zzqmVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    this.zzoz.transact(Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqn
            public void zza(zzqm zzqmVar, String str, AppMetadata appMetadata, long j, long j2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    parcelObtain.writeStrongBinder(zzqmVar != null ? zzqmVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (appMetadata != null) {
                        parcelObtain.writeInt(1);
                        appMetadata.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeLong(j);
                    parcelObtain.writeLong(j2);
                    this.zzoz.transact(1001, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqn
            public void zza(zzqm zzqmVar, String str, String str2, byte[] bArr, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    parcelObtain.writeStrongBinder(zzqmVar != null ? zzqmVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(1007, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqn
            public void zza(zzqm zzqmVar, String str, byte[] bArr, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    parcelObtain.writeStrongBinder(zzqmVar != null ? zzqmVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_INTERSECTION, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqn
            public void zza(String[] strArr, byte[] bArr, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_NATURAL_FEATURE, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqn
            public void zzag(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(1002, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqn
            public void zzah(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_FLOOR, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqn
            public void zzai(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_POINT_OF_INTEREST, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqn
            public String zzaj(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_POSTAL_CODE, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqn
            public void zzb(String[] strArr, byte[] bArr, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_NEIGHBORHOOD, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqn
            public void zzh(String str, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_COLLOQUIAL_AREA, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.internal.zzqn
            public void zzi(String str, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(Place.TYPE_POLITICAL, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzqn zzdx(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzqn)) ? new C0160zza(iBinder) : (zzqn) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1001:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(zzqm.zza.zzdw(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (AppMetadata) AppMetadata.CREATOR.createFromParcel(parcel) : null, parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1002:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzag(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_3 /* 1003 */:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(zzqm.zza.zzdw(parcel.readStrongBinder()), parcel.readString(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_COLLOQUIAL_AREA /* 1004 */:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzh(parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_COUNTRY /* 1005 */:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(zzqm.zza.zzdw(parcel.readStrongBinder()), parcel.readInt(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_FLOOR /* 1006 */:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzah(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1007:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(zzqm.zza.zzdw(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createByteArray(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_INTERSECTION /* 1008 */:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(zzqm.zza.zzdw(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_LOCALITY /* 1009 */:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(zzqm.zza.zzdw(parcel.readStrongBinder()), parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_NATURAL_FEATURE /* 1010 */:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zza(parcel.createStringArray(), parcel.createByteArray(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_NEIGHBORHOOD /* 1011 */:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzb(parcel.createStringArray(), parcel.createByteArray(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_POLITICAL /* 1012 */:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzi(parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_POINT_OF_INTEREST /* 1013 */:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzai(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_POST_BOX /* 1014 */:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    zzF(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_POSTAL_CODE /* 1015 */:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    String strZzaj = zzaj(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeString(strZzaj);
                    return true;
                case Place.TYPE_POSTAL_CODE_PREFIX /* 1016 */:
                    parcel.enforceInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    String strZzEk = zzEk();
                    parcel2.writeNoException();
                    parcel2.writeString(strZzEk);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String zzEk();

    void zzF(long j);

    void zza(zzqm zzqmVar, int i, long j, long j2);

    void zza(zzqm zzqmVar, String str, long j);

    void zza(zzqm zzqmVar, String str, long j, long j2);

    void zza(zzqm zzqmVar, String str, AppMetadata appMetadata, long j, long j2);

    void zza(zzqm zzqmVar, String str, String str2, byte[] bArr, long j);

    void zza(zzqm zzqmVar, String str, byte[] bArr, long j);

    void zza(String[] strArr, byte[] bArr, long j);

    void zzag(long j);

    void zzah(long j);

    void zzai(long j);

    String zzaj(long j);

    void zzb(String[] strArr, byte[] bArr, long j);

    void zzh(String str, long j);

    void zzi(String str, long j);
}
