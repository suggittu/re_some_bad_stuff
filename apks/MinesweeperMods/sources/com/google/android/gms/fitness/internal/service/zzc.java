package com.google.android.gms.fitness.internal.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.zzoi;
import com.google.android.gms.internal.zzow;

/* loaded from: classes2.dex */
public interface zzc extends IInterface {

    public abstract class zza extends Binder implements zzc {
        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    zza(parcel.readInt() != 0 ? (FitnessDataSourcesRequest) FitnessDataSourcesRequest.CREATOR.createFromParcel(parcel) : null, zzoi.zza.zzbD(parcel.readStrongBinder()));
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    zza(parcel.readInt() != 0 ? (FitnessSensorServiceRequest) FitnessSensorServiceRequest.CREATOR.createFromParcel(parcel) : null, zzow.zza.zzbR(parcel.readStrongBinder()));
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    zza(parcel.readInt() != 0 ? (FitnessUnregistrationRequest) FitnessUnregistrationRequest.CREATOR.createFromParcel(parcel) : null, zzow.zza.zzbR(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(FitnessDataSourcesRequest fitnessDataSourcesRequest, zzoi zzoiVar);

    void zza(FitnessUnregistrationRequest fitnessUnregistrationRequest, zzow zzowVar);

    void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, zzow zzowVar);
}
