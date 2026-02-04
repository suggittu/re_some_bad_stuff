package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.games.quest.Quests;

/* loaded from: classes2.dex */
public interface zzh extends IInterface {

    public abstract class zza extends Binder implements zzh {

        /* renamed from: com.google.android.gms.auth.api.signin.internal.zzh$zza$zza, reason: collision with other inner class name */
        class C0032zza implements zzh {
            private IBinder zzoz;

            C0032zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zzh
            public void zza(zzg zzgVar, GoogleSignInOptions googleSignInOptions) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    parcelObtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    if (googleSignInOptions != null) {
                        parcelObtain.writeInt(1);
                        googleSignInOptions.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(Quests.SELECT_COMPLETED_UNCLAIMED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zzh
            public void zza(zzg zzgVar, SignInConfiguration signInConfiguration) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    parcelObtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    if (signInConfiguration != null) {
                        parcelObtain.writeInt(1);
                        signInConfiguration.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zzh
            public void zza(zzg zzgVar, SignInConfiguration signInConfiguration, SignInAccount signInAccount, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    parcelObtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    if (signInConfiguration != null) {
                        parcelObtain.writeInt(1);
                        signInConfiguration.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (signInAccount != null) {
                        parcelObtain.writeInt(1);
                        signInAccount.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    this.zzoz.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zzh
            public void zzb(zzg zzgVar, GoogleSignInOptions googleSignInOptions) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    parcelObtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    if (googleSignInOptions != null) {
                        parcelObtain.writeInt(1);
                        googleSignInOptions.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(102, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.auth.api.signin.internal.zzh
            public void zzb(zzg zzgVar, SignInConfiguration signInConfiguration) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    parcelObtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    if (signInConfiguration != null) {
                        parcelObtain.writeInt(1);
                        signInConfiguration.writeToParcel(parcelObtain, 0);
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

            @Override // com.google.android.gms.auth.api.signin.internal.zzh
            public void zzc(zzg zzgVar, GoogleSignInOptions googleSignInOptions) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    parcelObtain.writeStrongBinder(zzgVar != null ? zzgVar.asBinder() : null);
                    if (googleSignInOptions != null) {
                        parcelObtain.writeInt(1);
                        googleSignInOptions.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(Quests.SELECT_RECENTLY_FAILED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzh zzaD(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzh)) ? new C0032zza(iBinder) : (zzh) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zza(zzg.zza.zzaC(parcel.readStrongBinder()), parcel.readInt() != 0 ? (SignInConfiguration) SignInConfiguration.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zzb(zzg.zza.zzaC(parcel.readStrongBinder()), parcel.readInt() != 0 ? (SignInConfiguration) SignInConfiguration.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zza(zzg.zza.zzaC(parcel.readStrongBinder()), parcel.readInt() != 0 ? (SignInConfiguration) SignInConfiguration.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (SignInAccount) SignInAccount.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case Quests.SELECT_COMPLETED_UNCLAIMED /* 101 */:
                    parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zza(zzg.zza.zzaC(parcel.readStrongBinder()), parcel.readInt() != 0 ? (GoogleSignInOptions) GoogleSignInOptions.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 102:
                    parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zzb(zzg.zza.zzaC(parcel.readStrongBinder()), parcel.readInt() != 0 ? (GoogleSignInOptions) GoogleSignInOptions.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case Quests.SELECT_RECENTLY_FAILED /* 103 */:
                    parcel.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    zzc(zzg.zza.zzaC(parcel.readStrongBinder()), parcel.readInt() != 0 ? (GoogleSignInOptions) GoogleSignInOptions.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.auth.api.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzg zzgVar, GoogleSignInOptions googleSignInOptions);

    void zza(zzg zzgVar, SignInConfiguration signInConfiguration);

    void zza(zzg zzgVar, SignInConfiguration signInConfiguration, SignInAccount signInAccount, String str);

    void zzb(zzg zzgVar, GoogleSignInOptions googleSignInOptions);

    void zzb(zzg zzgVar, SignInConfiguration signInConfiguration);

    void zzc(zzg zzgVar, GoogleSignInOptions googleSignInOptions);
}
