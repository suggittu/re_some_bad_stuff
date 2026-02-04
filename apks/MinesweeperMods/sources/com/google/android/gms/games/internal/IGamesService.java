package com.google.android.gms.games.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.AchievementEntity;
import com.google.android.gms.games.internal.IGamesCallbacks;
import com.google.android.gms.games.internal.IGamesClient;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.video.VideoConfiguration;
import com.google.android.gms.location.places.PlacesStatusCodes;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.safetynet.SafetyNetStatusCodes;
import java.util.List;

/* loaded from: classes2.dex */
public interface IGamesService extends IInterface {

    public abstract class Stub extends Binder implements IGamesService {

        class Proxy implements IGamesService {
            private IBinder zzoz;

            Proxy(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzE(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.zzoz.transact(5065, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzF(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzF(String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.zzoz.transact(8025, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzG(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(5059, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzH(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(8013, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzI(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzJ(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(12012, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzK(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(15502, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int zza(IGamesCallbacks iGamesCallbacks, byte[] bArr, String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.zzoz.transact(5033, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zza(int i, byte[] bArr, int i2, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(10012, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zza(PlayerEntity playerEntity) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (playerEntity != null) {
                        parcelObtain.writeInt(1);
                        playerEntity.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(15503, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zza(AchievementEntity achievementEntity) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (achievementEntity != null) {
                        parcelObtain.writeInt(1);
                        achievementEntity.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(13005, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zza(ZInvitationCluster zInvitationCluster, Account account, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (zInvitationCluster != null) {
                        parcelObtain.writeInt(1);
                        zInvitationCluster.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (account != null) {
                        parcelObtain.writeInt(1);
                        account.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    this.zzoz.transact(21006, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zza(ZInvitationCluster zInvitationCluster, String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (zInvitationCluster != null) {
                        parcelObtain.writeInt(1);
                        zInvitationCluster.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.zzoz.transact(10021, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zza(GameRequestCluster gameRequestCluster, Account account) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (gameRequestCluster != null) {
                        parcelObtain.writeInt(1);
                        gameRequestCluster.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (account != null) {
                        parcelObtain.writeInt(1);
                        account.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(21005, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zza(GameRequestCluster gameRequestCluster, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (gameRequestCluster != null) {
                        parcelObtain.writeInt(1);
                        gameRequestCluster.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    this.zzoz.transact(10022, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zza(RoomEntity roomEntity, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (roomEntity != null) {
                        parcelObtain.writeInt(1);
                        roomEntity.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(9011, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zza(String str, boolean z, boolean z2, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(SafetyNetStatusCodes.SAFE_BROWSING_MISSING_API_KEY, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zza(ParticipantEntity[] participantEntityArr, Account account, String str, Uri uri, Uri uri2, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeTypedArray(participantEntityArr, 0);
                    if (account != null) {
                        parcelObtain.writeInt(1);
                        account.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (uri2 != null) {
                        parcelObtain.writeInt(1);
                        uri2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str2);
                    this.zzoz.transact(21004, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zza(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeTypedArray(participantEntityArr, 0);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (uri2 != null) {
                        parcelObtain.writeInt(1);
                        uri2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(9031, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zza(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2, String str3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeTypedArray(participantEntityArr, 0);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (uri2 != null) {
                        parcelObtain.writeInt(1);
                        uri2.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeString(str3);
                    this.zzoz.transact(14003, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IBinder iBinder, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(Contents contents) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (contents != null) {
                        parcelObtain.writeInt(1);
                        contents.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(12019, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(10016, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, int i, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.zzoz.transact(10009, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, int i, int i2, boolean z, boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.zzoz.transact(5044, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, int i, int i2, String[] strArr, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStringArray(strArr);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, int i, String str, String[] strArr, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(14002, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.zzoz.transact(FitnessStatusCodes.INCONSISTENT_PACKAGE_NAME, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, int i, int[] iArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeIntArray(iArr);
                    this.zzoz.transact(10018, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(5058, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, long j, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(8018, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, Bundle bundle, int i, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.zzoz.transact(5021, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeStrongBinder(iBinder);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStringArray(strArr);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(5030, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, IBinder iBinder, String str, boolean z, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeStrongBinder(iBinder);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(5031, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(FitnessStatusCodes.DISABLED_BLUETOOTH, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(10011, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(FitnessStatusCodes.DATASET_TIMESTAMP_INCONSISTENT_WITH_UPDATE_TIME_RANGE, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(5025, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(8023, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.zzoz.transact(5045, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    parcelObtain.writeInt(z3 ? 1 : 0);
                    parcelObtain.writeInt(z4 ? 1 : 0);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INACTIVE_MATCH, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, int i, int[] iArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeIntArray(iArr);
                    this.zzoz.transact(10019, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(5016, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, long j, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str2);
                    this.zzoz.transact(GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(5023, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    if (snapshotMetadataChangeEntity != null) {
                        parcelObtain.writeInt(1);
                        snapshotMetadataChangeEntity.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (contents != null) {
                        parcelObtain.writeInt(1);
                        contents.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(12007, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.zzoz.transact(5038, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.zzoz.transact(8001, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.zzoz.transact(10010, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(5039, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.zzoz.transact(9028, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (snapshotMetadataChangeEntity != null) {
                        parcelObtain.writeInt(1);
                        snapshotMetadataChangeEntity.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (contents != null) {
                        parcelObtain.writeInt(1);
                        contents.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(12033, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, VideoConfiguration videoConfiguration) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    if (videoConfiguration != null) {
                        parcelObtain.writeInt(1);
                        videoConfiguration.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(19003, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int[] iArr, int i, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeIntArray(iArr);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(12015, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringArray(strArr);
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_INVALID_ROOM, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(12028, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(5054, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, boolean z, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(15001, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeTypedArray(participantResultArr, 0);
                    this.zzoz.transact(8007, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeTypedArray(participantResultArr, 0);
                    this.zzoz.transact(8008, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, int[] iArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeIntArray(iArr);
                    this.zzoz.transact(8017, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String str, String[] strArr, int i, byte[] bArr, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeInt(i2);
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_LEFT_ROOM, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, boolean z, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(5063, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, boolean z, String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeStringArray(strArr);
                    this.zzoz.transact(12031, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, int[] iArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeIntArray(iArr);
                    this.zzoz.transact(8003, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, int[] iArr, int i, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeIntArray(iArr);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(12010, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeStringArray(strArr);
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_NETWORK_FAILURE, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesCallbacks iGamesCallbacks, String[] strArr, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeStringArray(strArr);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(12029, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(IGamesClient iGamesClient, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesClient != null ? iGamesClient.asBinder() : null);
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(15501, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(String str, Account account) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    if (account != null) {
                        parcelObtain.writeInt(1);
                        account.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(21003, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(String str, IBinder iBinder, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(13002, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zza(String str, IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(20001, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzai(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(5068, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzaj(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(12026, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzak(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(13001, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int zzb(byte[] bArr, String str, String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStringArray(strArr);
                    this.zzoz.transact(5034, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzb(int i, int i2, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(PlacesStatusCodes.INVALID_APP, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzb(int[] iArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeIntArray(iArr);
                    this.zzoz.transact(12030, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(long j, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(8019, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5017, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.zzoz.transact(5046, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(8012, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, long j, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(8020, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(FitnessStatusCodes.DATA_SOURCE_NOT_FOUND, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(12023, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(FitnessStatusCodes.INVALID_SESSION_TIMESTAMPS, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(GamesStatusCodes.STATUS_PARTICIPANT_NOT_CONNECTED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(10017, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.zzoz.transact(5501, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(5024, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.zzoz.transact(5041, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(5040, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.zzoz.transact(12018, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MATCH_NOT_FOUND, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, String str, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_STATE, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(IGamesCallbacks iGamesCallbacks, String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeStringArray(strArr);
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzb(String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStringArray(strArr);
                    this.zzoz.transact(15002, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzc(int i, int i2, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(9009, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzc(long j, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(8021, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzc(IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5022, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzc(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.zzoz.transact(5048, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzc(IGamesCallbacks iGamesCallbacks, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(10001, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzc(IGamesCallbacks iGamesCallbacks, long j, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_LICENSE_FAILED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzc(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(5032, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzc(IGamesCallbacks iGamesCallbacks, String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(12024, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzc(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.zzoz.transact(PlacesStatusCodes.USAGE_LIMIT_EXCEEDED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzc(IGamesCallbacks iGamesCallbacks, String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.zzoz.transact(8011, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzc(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(12003, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzc(IGamesCallbacks iGamesCallbacks, String str, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzc(IGamesCallbacks iGamesCallbacks, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(8027, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzc(IGamesCallbacks iGamesCallbacks, String[] strArr) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeStringArray(strArr);
                    this.zzoz.transact(10020, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzd(long j, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzd(IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5026, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzd(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzd(IGamesCallbacks iGamesCallbacks, long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeLong(j);
                    this.zzoz.transact(12011, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzd(IGamesCallbacks iGamesCallbacks, long j, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(12013, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzd(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(5037, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzd(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.zzoz.transact(9020, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzd(IGamesCallbacks iGamesCallbacks, String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.zzoz.transact(8015, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzd(IGamesCallbacks iGamesCallbacks, String str, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MATCH_ERROR_ALREADY_REMATCHED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzd(IGamesCallbacks iGamesCallbacks, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(12002, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzd(String str, String str2, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(5051, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzdI(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    this.zzoz.transact(12034, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public String zzdK(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    this.zzoz.transact(5064, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public String zzdL(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    this.zzoz.transact(5035, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzdM(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    this.zzoz.transact(5050, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int zzdN(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    this.zzoz.transact(5060, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Uri zzdO(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    this.zzoz.transact(5066, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzdP(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    this.zzoz.transact(8002, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzdQ(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    this.zzoz.transact(PlacesStatusCodes.INVALID_ARGUMENT, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public ParcelFileDescriptor zzdR(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    this.zzoz.transact(9030, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Account zzdS(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    this.zzoz.transact(21002, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zze(long j, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(12014, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zze(IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5027, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zze(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.zzoz.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zze(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(5042, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zze(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.zzoz.transact(12021, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zze(IGamesCallbacks iGamesCallbacks, String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.zzoz.transact(8016, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zze(IGamesCallbacks iGamesCallbacks, String str, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(12006, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zze(IGamesCallbacks iGamesCallbacks, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(12032, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zze(String str, String str2, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(8026, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzf(IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5047, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzf(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(5043, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzf(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(z2 ? 1 : 0);
                    this.zzoz.transact(12022, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzf(IGamesCallbacks iGamesCallbacks, String str, String str2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.zzoz.transact(12009, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzf(IGamesCallbacks iGamesCallbacks, String str, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(13006, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzf(IGamesCallbacks iGamesCallbacks, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(12016, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzg(IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5049, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzg(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(5052, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzg(IGamesCallbacks iGamesCallbacks, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(13003, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzgt(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(5036, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public RoomEntity zzh(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(5053, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (RoomEntity) RoomEntity.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzh(IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5056, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzh(IGamesCallbacks iGamesCallbacks, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(13004, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzi(IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(5062, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzi(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(5061, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzi(IGamesCallbacks iGamesCallbacks, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(17001, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzj(IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(11001, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzj(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(5057, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzk(IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(19001, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzk(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(GamesStatusCodes.STATUS_REAL_TIME_MESSAGE_SEND_FAILED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzl(IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(19004, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzl(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(ConnectionsStatusCodes.STATUS_NOT_CONNECTED_TO_ENDPOINT, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzm(String str, int i, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.zzoz.transact(18001, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzm(IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(21007, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzm(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(8006, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public ParcelFileDescriptor zzn(Uri uri) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(GamesStatusCodes.STATUS_MATCH_ERROR_LOCALLY_MODIFIED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzn(IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(21008, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzn(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(8009, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzo(IGamesCallbacks iGamesCallbacks) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.zzoz.transact(21009, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzo(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(8010, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Bundle zzoi() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(FitnessStatusCodes.APP_MISMATCH, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzp(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(8014, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzp(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(12017, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzq(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(PlacesStatusCodes.KEY_INVALID, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzq(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(5029, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzr(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(12020, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzr(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(5028, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzs(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(12005, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzt(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(12027, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzt(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(5055, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzu(IGamesCallbacks iGamesCallbacks, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    parcelObtain.writeString(str);
                    this.zzoz.transact(12008, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzu(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(10014, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzv(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.zzoz.transact(14001, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzwA() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(PlacesStatusCodes.RATE_LIMIT_EXCEEDED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzwB() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(PlacesStatusCodes.DEVICE_RATE_LIMIT_EXCEEDED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzwC() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(PlacesStatusCodes.KEY_EXPIRED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzwH() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(9010, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzwI() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(9012, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int zzwJ() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(9019, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public String zzwK() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int zzwL() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(8024, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzwM() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(10015, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int zzwN() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(10013, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int zzwO() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(10023, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int zzwP() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(12035, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int zzwQ() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(12036, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzwR() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public String zzwT() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(FitnessStatusCodes.AGGREGATION_NOT_SUPPORTED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public DataHolder zzwU() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(FitnessStatusCodes.UNSUPPORTED_ACCOUNT, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public boolean zzwV() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(5067, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public DataHolder zzwW() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(5502, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzwX() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(8022, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzwY() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(9013, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzwZ() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(11002, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public String zzww() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzwz() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(PlacesStatusCodes.ACCESS_NOT_CONFIGURED, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public boolean zzxa() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(12025, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void zzxb() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(15504, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzxc() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(16001, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent zzxd() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(19002, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Account zzxe() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(21001, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public List zzxf() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.zzoz.transact(21010, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readArrayList(getClass().getClassLoader());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesService");
        }

        public static IGamesService zzbY(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGamesService)) ? new Proxy(iBinder) : (IGamesService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case FitnessStatusCodes.CONFLICTING_DATA_TYPE /* 5001 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzF(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.INCONSISTENT_DATA_TYPE /* 5002 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.DATA_TYPE_NOT_FOUND /* 5003 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String strZzwK = zzwK();
                    parcel2.writeNoException();
                    parcel2.writeString(strZzwK);
                    return true;
                case FitnessStatusCodes.APP_MISMATCH /* 5004 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Bundle bundleZzoi = zzoi();
                    parcel2.writeNoException();
                    if (bundleZzoi == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    bundleZzoi.writeToParcel(parcel2, 1);
                    return true;
                case FitnessStatusCodes.UNKNOWN_AUTH_ERROR /* 5005 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.MISSING_BLE_PERMISSION /* 5006 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwR();
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.UNSUPPORTED_PLATFORM /* 5007 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String strZzww = zzww();
                    parcel2.writeNoException();
                    parcel2.writeString(strZzww);
                    return true;
                case FitnessStatusCodes.AGGREGATION_NOT_SUPPORTED /* 5012 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String strZzwT = zzwT();
                    parcel2.writeNoException();
                    parcel2.writeString(strZzwT);
                    return true;
                case FitnessStatusCodes.UNSUPPORTED_ACCOUNT /* 5013 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    DataHolder dataHolderZzwU = zzwU();
                    parcel2.writeNoException();
                    if (dataHolderZzwU == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    dataHolderZzwU.writeToParcel(parcel2, 1);
                    return true;
                case FitnessStatusCodes.DISABLED_BLUETOOTH /* 5014 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.INCONSISTENT_PACKAGE_NAME /* 5015 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5016:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5017:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.DATA_SOURCE_NOT_FOUND /* 5018 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.DATASET_TIMESTAMP_INCONSISTENT_WITH_UPDATE_TIME_RANGE /* 5019 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case FitnessStatusCodes.INVALID_SESSION_TIMESTAMPS /* 5020 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5021:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5022:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5023:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5024:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5025:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5026:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5027:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zze(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5028:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzr(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5029:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzq(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5030:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readStrongBinder(), parcel.readInt(), parcel.createStringArray(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0, parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5031:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readStrongBinder(), parcel.readString(), parcel.readInt() != 0, parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5032:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5033:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int iZza = zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.createByteArray(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iZza);
                    return true;
                case 5034:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int iZzb = zzb(parcel.createByteArray(), parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzb);
                    return true;
                case 5035:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String strZzdL = zzdL(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strZzdL);
                    return true;
                case 5036:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzgt(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5037:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5038:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5039:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5040:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5041:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5042:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zze(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5043:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzf(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5044:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5045:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5046:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5047:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzf(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5048:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5049:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzg(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5050:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzdM(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5051:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5052:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzg(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5053:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    RoomEntity roomEntityZzh = zzh(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    if (roomEntityZzh == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    roomEntityZzh.writeToParcel(parcel2, 1);
                    return true;
                case 5054:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5055:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzt(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5056:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzh(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5057:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzj(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5058:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5059:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzG(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5060:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int iZzdN = zzdN(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzdN);
                    return true;
                case 5061:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzi(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5062:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzi(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5063:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt() != 0, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5064:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String strZzdK = zzdK(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(strZzdK);
                    return true;
                case 5065:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzE(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5066:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Uri uriZzdO = zzdO(parcel.readString());
                    parcel2.writeNoException();
                    if (uriZzdO == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    uriZzdO.writeToParcel(parcel2, 1);
                    return true;
                case 5067:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    boolean zZzwV = zzwV();
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzwV ? 1 : 0);
                    return true;
                case 5068:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzai(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5501:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5502:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    DataHolder dataHolderZzwW = zzwW();
                    parcel2.writeNoException();
                    if (dataHolderZzwW == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    dataHolderZzwW.writeToParcel(parcel2, 1);
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER /* 6001 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE /* 6002 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED /* 6003 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION /* 6004 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zze(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_INACTIVE_MATCH /* 6501 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_STATE /* 6502 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION /* 6503 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS /* 6504 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_ALREADY_REMATCHED /* 6505 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_NOT_FOUND /* 6506 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_LOCALLY_MODIFIED /* 6507 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ParcelFileDescriptor parcelFileDescriptorZzn = zzn(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (parcelFileDescriptorZzn == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    parcelFileDescriptorZzn.writeToParcel(parcel2, 1);
                    return true;
                case GamesStatusCodes.STATUS_REAL_TIME_MESSAGE_SEND_FAILED /* 7001 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzk(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID /* 7002 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_PARTICIPANT_NOT_CONNECTED /* 7003 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzdP(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.createIntArray());
                    parcel2.writeNoException();
                    return true;
                case ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED /* 8004 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.createStringArray(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case ConnectionsStatusCodes.STATUS_NOT_CONNECTED_TO_ENDPOINT /* 8005 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzl(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8006:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzm(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8007:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray(), parcel.readString(), (ParticipantResult[]) parcel.createTypedArray(ParticipantResult.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 8008:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray(), (ParticipantResult[]) parcel.createTypedArray(ParticipantResult.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 8009:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzn(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8010:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzo(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8011:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8012:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 8013:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzH(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 8014:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzp(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8015:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8016:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zze(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8017:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.createIntArray());
                    parcel2.writeNoException();
                    return true;
                case 8018:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8019:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8020:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8021:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8022:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwX();
                    parcel2.writeNoException();
                    return true;
                case 8023:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 8024:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int iZzwL = zzwL();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzwL);
                    return true;
                case 8025:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzF(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8026:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zze(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8027:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case PlacesStatusCodes.USAGE_LIMIT_EXCEEDED /* 9001 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case PlacesStatusCodes.KEY_INVALID /* 9002 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzq(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case PlacesStatusCodes.ACCESS_NOT_CONFIGURED /* 9003 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzwz = zzwz();
                    parcel2.writeNoException();
                    if (intentZzwz == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzwz.writeToParcel(parcel2, 1);
                    return true;
                case PlacesStatusCodes.INVALID_ARGUMENT /* 9004 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzdQ = zzdQ(parcel.readString());
                    parcel2.writeNoException();
                    if (intentZzdQ == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzdQ.writeToParcel(parcel2, 1);
                    return true;
                case PlacesStatusCodes.RATE_LIMIT_EXCEEDED /* 9005 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzwA = zzwA();
                    parcel2.writeNoException();
                    if (intentZzwA == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzwA.writeToParcel(parcel2, 1);
                    return true;
                case PlacesStatusCodes.DEVICE_RATE_LIMIT_EXCEEDED /* 9006 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzwB = zzwB();
                    parcel2.writeNoException();
                    if (intentZzwB == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzwB.writeToParcel(parcel2, 1);
                    return true;
                case PlacesStatusCodes.KEY_EXPIRED /* 9007 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzwC = zzwC();
                    parcel2.writeNoException();
                    if (intentZzwC == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzwC.writeToParcel(parcel2, 1);
                    return true;
                case PlacesStatusCodes.INVALID_APP /* 9008 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzb = zzb(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (intentZzb == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzb.writeToParcel(parcel2, 1);
                    return true;
                case 9009:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzc = zzc(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (intentZzc == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzc.writeToParcel(parcel2, 1);
                    return true;
                case 9010:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzwH = zzwH();
                    parcel2.writeNoException();
                    if (intentZzwH == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzwH.writeToParcel(parcel2, 1);
                    return true;
                case 9011:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZza = zza(parcel.readInt() != 0 ? (RoomEntity) RoomEntity.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    if (intentZza == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZza.writeToParcel(parcel2, 1);
                    return true;
                case 9012:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzwI = zzwI();
                    parcel2.writeNoException();
                    if (intentZzwI == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzwI.writeToParcel(parcel2, 1);
                    return true;
                case 9013:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzwY = zzwY();
                    parcel2.writeNoException();
                    if (intentZzwY == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzwY.writeToParcel(parcel2, 1);
                    return true;
                case 9019:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int iZzwJ = zzwJ();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzwJ);
                    return true;
                case 9020:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 9028:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 9030:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ParcelFileDescriptor parcelFileDescriptorZzdR = zzdR(parcel.readString());
                    parcel2.writeNoException();
                    if (parcelFileDescriptorZzdR == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    parcelFileDescriptorZzdR.writeToParcel(parcel2, 1);
                    return true;
                case 9031:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZza2 = zza((ParticipantEntity[]) parcel.createTypedArray(ParticipantEntity.CREATOR), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (intentZza2 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZza2.writeToParcel(parcel2, 1);
                    return true;
                case 10001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED /* 10002 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzI(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_LICENSE_FAILED /* 10003 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED /* 10004 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_LEFT_ROOM /* 10005 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.createStringArray(), parcel.readInt(), parcel.createByteArray(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_NETWORK_FAILURE /* 10006 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED /* 10007 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_INVALID_ROOM /* 10008 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 10009:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10010:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10011:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10012:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZza3 = zza(parcel.readInt(), parcel.createByteArray(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    if (intentZza3 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZza3.writeToParcel(parcel2, 1);
                    return true;
                case 10013:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int iZzwN = zzwN();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzwN);
                    return true;
                case 10014:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzu(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10015:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzwM = zzwM();
                    parcel2.writeNoException();
                    if (intentZzwM == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzwM.writeToParcel(parcel2, 1);
                    return true;
                case 10016:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10017:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 10018:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt(), parcel.createIntArray());
                    parcel2.writeNoException();
                    return true;
                case 10019:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.createIntArray());
                    parcel2.writeNoException();
                    return true;
                case 10020:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 10021:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZza4 = zza(parcel.readInt() != 0 ? ZInvitationCluster.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (intentZza4 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZza4.writeToParcel(parcel2, 1);
                    return true;
                case 10022:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZza5 = zza(parcel.readInt() != 0 ? GameRequestCluster.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    if (intentZza5 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZza5.writeToParcel(parcel2, 1);
                    return true;
                case 10023:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int iZzwO = zzwO();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzwO);
                    return true;
                case 11001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzj(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzwZ();
                    parcel2.writeNoException();
                    return true;
                case SafetyNetStatusCodes.SAFE_BROWSING_MISSING_API_KEY /* 12001 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZza6 = zza(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt());
                    parcel2.writeNoException();
                    if (intentZza6 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZza6.writeToParcel(parcel2, 1);
                    return true;
                case 12002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12005:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzs(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12006:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zze(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12007:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? SnapshotMetadataChangeEntity.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Contents) Contents.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12008:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzu(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12009:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzf(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12010:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.createIntArray(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12011:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 12012:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzJ(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 12013:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzd(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12014:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zze(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12015:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createIntArray(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12016:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzf(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12017:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzp(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 12018:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12019:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(parcel.readInt() != 0 ? (Contents) Contents.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12020:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzr(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12021:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zze(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12022:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzf(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12023:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 12024:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzc(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 12025:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    boolean zZzxa = zzxa();
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzxa ? 1 : 0);
                    return true;
                case 12026:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzaj(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12027:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzt(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12028:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12029:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.createStringArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12030:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzb2 = zzb(parcel.createIntArray());
                    parcel2.writeNoException();
                    if (intentZzb2 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzb2.writeToParcel(parcel2, 1);
                    return true;
                case 12031:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt() != 0, parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 12032:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zze(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12033:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? SnapshotMetadataChangeEntity.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Contents) Contents.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12034:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzdI = zzdI(parcel.readString());
                    parcel2.writeNoException();
                    if (intentZzdI == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzdI.writeToParcel(parcel2, 1);
                    return true;
                case 12035:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int iZzwP = zzwP();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzwP);
                    return true;
                case 12036:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int iZzwQ = zzwQ();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzwQ);
                    return true;
                case 13001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzak(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 13002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(parcel.readString(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 13003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzg(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 13004:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzh(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 13005:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZza7 = zza(parcel.readInt() != 0 ? (AchievementEntity) AchievementEntity.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (intentZza7 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZza7.writeToParcel(parcel2, 1);
                    return true;
                case 13006:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzf(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 14001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzv = zzv(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (intentZzv == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzv.writeToParcel(parcel2, 1);
                    return true;
                case 14002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.createStringArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 14003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZza8 = zza((ParticipantEntity[]) parcel.createTypedArray(ParticipantEntity.CREATOR), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    if (intentZza8 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZza8.writeToParcel(parcel2, 1);
                    return true;
                case 15001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 15002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzb(parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 15501:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesClient.Stub.zzbX(parcel.readStrongBinder()), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 15502:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzK(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 15503:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZza9 = zza(parcel.readInt() != 0 ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (intentZza9 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZza9.writeToParcel(parcel2, 1);
                    return true;
                case 15504:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzxb();
                    parcel2.writeNoException();
                    return true;
                case 16001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzxc = zzxc();
                    parcel2.writeNoException();
                    if (intentZzxc == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzxc.writeToParcel(parcel2, 1);
                    return true;
                case 17001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzi(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 18001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzm = zzm(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (intentZzm == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzm.writeToParcel(parcel2, 1);
                    return true;
                case 19001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzk(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 19002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZzxd = zzxd();
                    parcel2.writeNoException();
                    if (intentZzxd == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZzxd.writeToParcel(parcel2, 1);
                    return true;
                case 19003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (VideoConfiguration) VideoConfiguration.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 19004:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzl(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 20001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(parcel.readString(), IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Account accountZzxe = zzxe();
                    parcel2.writeNoException();
                    if (accountZzxe == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    accountZzxe.writeToParcel(parcel2, 1);
                    return true;
                case 21002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Account accountZzdS = zzdS(parcel.readString());
                    parcel2.writeNoException();
                    if (accountZzdS == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    accountZzdS.writeToParcel(parcel2, 1);
                    return true;
                case 21003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zza(parcel.readString(), parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 21004:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZza10 = zza((ParticipantEntity[]) parcel.createTypedArray(ParticipantEntity.CREATOR), parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    if (intentZza10 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZza10.writeToParcel(parcel2, 1);
                    return true;
                case 21005:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZza11 = zza(parcel.readInt() != 0 ? GameRequestCluster.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (intentZza11 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZza11.writeToParcel(parcel2, 1);
                    return true;
                case 21006:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent intentZza12 = zza(parcel.readInt() != 0 ? ZInvitationCluster.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    if (intentZza12 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    intentZza12.writeToParcel(parcel2, 1);
                    return true;
                case 21007:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzm(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21008:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzn(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21009:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    zzo(IGamesCallbacks.Stub.zzbW(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21010:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    List listZzxf = zzxf();
                    parcel2.writeNoException();
                    parcel2.writeList(listZzxf);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.games.internal.IGamesService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zzE(String str, String str2);

    void zzF(long j);

    void zzF(String str, String str2);

    void zzG(long j);

    void zzH(long j);

    void zzI(long j);

    void zzJ(long j);

    void zzK(long j);

    int zza(IGamesCallbacks iGamesCallbacks, byte[] bArr, String str, String str2);

    Intent zza(int i, byte[] bArr, int i2, String str);

    Intent zza(PlayerEntity playerEntity);

    Intent zza(AchievementEntity achievementEntity);

    Intent zza(ZInvitationCluster zInvitationCluster, Account account, String str);

    Intent zza(ZInvitationCluster zInvitationCluster, String str, String str2);

    Intent zza(GameRequestCluster gameRequestCluster, Account account);

    Intent zza(GameRequestCluster gameRequestCluster, String str);

    Intent zza(RoomEntity roomEntity, int i);

    Intent zza(String str, boolean z, boolean z2, int i);

    Intent zza(ParticipantEntity[] participantEntityArr, Account account, String str, Uri uri, Uri uri2, String str2);

    Intent zza(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2);

    Intent zza(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2, String str3);

    void zza(IBinder iBinder, Bundle bundle);

    void zza(Contents contents);

    void zza(IGamesCallbacks iGamesCallbacks);

    void zza(IGamesCallbacks iGamesCallbacks, int i);

    void zza(IGamesCallbacks iGamesCallbacks, int i, int i2, int i3);

    void zza(IGamesCallbacks iGamesCallbacks, int i, int i2, boolean z, boolean z2);

    void zza(IGamesCallbacks iGamesCallbacks, int i, int i2, String[] strArr, Bundle bundle);

    void zza(IGamesCallbacks iGamesCallbacks, int i, String str, String[] strArr, boolean z);

    void zza(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2);

    void zza(IGamesCallbacks iGamesCallbacks, int i, int[] iArr);

    void zza(IGamesCallbacks iGamesCallbacks, long j);

    void zza(IGamesCallbacks iGamesCallbacks, long j, String str);

    void zza(IGamesCallbacks iGamesCallbacks, Bundle bundle, int i, int i2);

    void zza(IGamesCallbacks iGamesCallbacks, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j);

    void zza(IGamesCallbacks iGamesCallbacks, IBinder iBinder, String str, boolean z, long j);

    void zza(IGamesCallbacks iGamesCallbacks, String str);

    void zza(IGamesCallbacks iGamesCallbacks, String str, int i);

    void zza(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z);

    void zza(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle);

    void zza(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z);

    void zza(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2);

    void zza(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2, boolean z3, boolean z4);

    void zza(IGamesCallbacks iGamesCallbacks, String str, int i, int[] iArr);

    void zza(IGamesCallbacks iGamesCallbacks, String str, long j);

    void zza(IGamesCallbacks iGamesCallbacks, String str, long j, String str2);

    void zza(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle);

    void zza(IGamesCallbacks iGamesCallbacks, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents);

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2);

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2);

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3);

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z);

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2);

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents);

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, VideoConfiguration videoConfiguration);

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z);

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, int[] iArr, int i, boolean z);

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr);

    void zza(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr, boolean z);

    void zza(IGamesCallbacks iGamesCallbacks, String str, boolean z);

    void zza(IGamesCallbacks iGamesCallbacks, String str, boolean z, int i);

    void zza(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr);

    void zza(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, ParticipantResult[] participantResultArr);

    void zza(IGamesCallbacks iGamesCallbacks, String str, int[] iArr);

    void zza(IGamesCallbacks iGamesCallbacks, String str, String[] strArr, int i, byte[] bArr, int i2);

    void zza(IGamesCallbacks iGamesCallbacks, boolean z);

    void zza(IGamesCallbacks iGamesCallbacks, boolean z, Bundle bundle);

    void zza(IGamesCallbacks iGamesCallbacks, boolean z, String[] strArr);

    void zza(IGamesCallbacks iGamesCallbacks, int[] iArr);

    void zza(IGamesCallbacks iGamesCallbacks, int[] iArr, int i, boolean z);

    void zza(IGamesCallbacks iGamesCallbacks, String[] strArr);

    void zza(IGamesCallbacks iGamesCallbacks, String[] strArr, boolean z);

    void zza(IGamesClient iGamesClient, long j);

    void zza(String str, Account account);

    void zza(String str, IBinder iBinder, Bundle bundle);

    void zza(String str, IGamesCallbacks iGamesCallbacks);

    void zzai(boolean z);

    void zzaj(boolean z);

    void zzak(boolean z);

    int zzb(byte[] bArr, String str, String[] strArr);

    Intent zzb(int i, int i2, boolean z);

    Intent zzb(int[] iArr);

    void zzb(long j, String str);

    void zzb(IGamesCallbacks iGamesCallbacks);

    void zzb(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2);

    void zzb(IGamesCallbacks iGamesCallbacks, long j);

    void zzb(IGamesCallbacks iGamesCallbacks, long j, String str);

    void zzb(IGamesCallbacks iGamesCallbacks, String str);

    void zzb(IGamesCallbacks iGamesCallbacks, String str, int i);

    void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z);

    void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle);

    void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z);

    void zzb(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2);

    void zzb(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle);

    void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2);

    void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z);

    void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2);

    void zzb(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z);

    void zzb(IGamesCallbacks iGamesCallbacks, String str, boolean z);

    void zzb(IGamesCallbacks iGamesCallbacks, boolean z);

    void zzb(IGamesCallbacks iGamesCallbacks, String[] strArr);

    void zzb(String[] strArr);

    Intent zzc(int i, int i2, boolean z);

    void zzc(long j, String str);

    void zzc(IGamesCallbacks iGamesCallbacks);

    void zzc(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2);

    void zzc(IGamesCallbacks iGamesCallbacks, long j);

    void zzc(IGamesCallbacks iGamesCallbacks, long j, String str);

    void zzc(IGamesCallbacks iGamesCallbacks, String str);

    void zzc(IGamesCallbacks iGamesCallbacks, String str, int i);

    void zzc(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2);

    void zzc(IGamesCallbacks iGamesCallbacks, String str, String str2);

    void zzc(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z);

    void zzc(IGamesCallbacks iGamesCallbacks, String str, boolean z);

    void zzc(IGamesCallbacks iGamesCallbacks, boolean z);

    void zzc(IGamesCallbacks iGamesCallbacks, String[] strArr);

    void zzd(long j, String str);

    void zzd(IGamesCallbacks iGamesCallbacks);

    void zzd(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2);

    void zzd(IGamesCallbacks iGamesCallbacks, long j);

    void zzd(IGamesCallbacks iGamesCallbacks, long j, String str);

    void zzd(IGamesCallbacks iGamesCallbacks, String str);

    void zzd(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2);

    void zzd(IGamesCallbacks iGamesCallbacks, String str, String str2);

    void zzd(IGamesCallbacks iGamesCallbacks, String str, boolean z);

    void zzd(IGamesCallbacks iGamesCallbacks, boolean z);

    void zzd(String str, String str2, int i);

    Intent zzdI(String str);

    String zzdK(String str);

    String zzdL(String str);

    void zzdM(String str);

    int zzdN(String str);

    Uri zzdO(String str);

    void zzdP(String str);

    Intent zzdQ(String str);

    ParcelFileDescriptor zzdR(String str);

    Account zzdS(String str);

    void zze(long j, String str);

    void zze(IGamesCallbacks iGamesCallbacks);

    void zze(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2);

    void zze(IGamesCallbacks iGamesCallbacks, String str);

    void zze(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2);

    void zze(IGamesCallbacks iGamesCallbacks, String str, String str2);

    void zze(IGamesCallbacks iGamesCallbacks, String str, boolean z);

    void zze(IGamesCallbacks iGamesCallbacks, boolean z);

    void zze(String str, String str2, int i);

    void zzf(IGamesCallbacks iGamesCallbacks);

    void zzf(IGamesCallbacks iGamesCallbacks, String str);

    void zzf(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2);

    void zzf(IGamesCallbacks iGamesCallbacks, String str, String str2);

    void zzf(IGamesCallbacks iGamesCallbacks, String str, boolean z);

    void zzf(IGamesCallbacks iGamesCallbacks, boolean z);

    void zzg(IGamesCallbacks iGamesCallbacks);

    void zzg(IGamesCallbacks iGamesCallbacks, String str);

    void zzg(IGamesCallbacks iGamesCallbacks, boolean z);

    void zzgt(int i);

    RoomEntity zzh(IGamesCallbacks iGamesCallbacks, String str);

    void zzh(IGamesCallbacks iGamesCallbacks);

    void zzh(IGamesCallbacks iGamesCallbacks, boolean z);

    void zzi(IGamesCallbacks iGamesCallbacks);

    void zzi(IGamesCallbacks iGamesCallbacks, String str);

    void zzi(IGamesCallbacks iGamesCallbacks, boolean z);

    void zzj(IGamesCallbacks iGamesCallbacks);

    void zzj(IGamesCallbacks iGamesCallbacks, String str);

    void zzk(IGamesCallbacks iGamesCallbacks);

    void zzk(IGamesCallbacks iGamesCallbacks, String str);

    void zzl(IGamesCallbacks iGamesCallbacks);

    void zzl(IGamesCallbacks iGamesCallbacks, String str);

    Intent zzm(String str, int i, int i2);

    void zzm(IGamesCallbacks iGamesCallbacks);

    void zzm(IGamesCallbacks iGamesCallbacks, String str);

    ParcelFileDescriptor zzn(Uri uri);

    void zzn(IGamesCallbacks iGamesCallbacks);

    void zzn(IGamesCallbacks iGamesCallbacks, String str);

    void zzo(IGamesCallbacks iGamesCallbacks);

    void zzo(IGamesCallbacks iGamesCallbacks, String str);

    Bundle zzoi();

    void zzp(IGamesCallbacks iGamesCallbacks, String str);

    void zzp(String str, int i);

    void zzq(IGamesCallbacks iGamesCallbacks, String str);

    void zzq(String str, int i);

    void zzr(IGamesCallbacks iGamesCallbacks, String str);

    void zzr(String str, int i);

    void zzs(IGamesCallbacks iGamesCallbacks, String str);

    void zzt(IGamesCallbacks iGamesCallbacks, String str);

    void zzt(String str, int i);

    void zzu(IGamesCallbacks iGamesCallbacks, String str);

    void zzu(String str, int i);

    Intent zzv(String str, int i);

    Intent zzwA();

    Intent zzwB();

    Intent zzwC();

    Intent zzwH();

    Intent zzwI();

    int zzwJ();

    String zzwK();

    int zzwL();

    Intent zzwM();

    int zzwN();

    int zzwO();

    int zzwP();

    int zzwQ();

    void zzwR();

    String zzwT();

    DataHolder zzwU();

    boolean zzwV();

    DataHolder zzwW();

    void zzwX();

    Intent zzwY();

    void zzwZ();

    String zzww();

    Intent zzwz();

    boolean zzxa();

    void zzxb();

    Intent zzxc();

    Intent zzxd();

    Account zzxe();

    List zzxf();
}
