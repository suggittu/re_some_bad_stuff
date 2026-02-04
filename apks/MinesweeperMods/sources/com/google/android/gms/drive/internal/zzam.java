package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;
import com.google.android.gms.drive.internal.zzan;
import com.google.android.gms.drive.internal.zzao;
import com.google.android.gms.location.places.Place;

/* loaded from: classes2.dex */
public interface zzam extends IInterface {

    public abstract class zza extends Binder implements zzam {

        /* renamed from: com.google.android.gms.drive.internal.zzam$zza$zza, reason: collision with other inner class name */
        class C0047zza implements zzam {
            private IBinder zzoz;

            C0047zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.zzoz;
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileIntentSenderRequest != null) {
                        parcelObtain.writeInt(1);
                        createFileIntentSenderRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openFileIntentSenderRequest != null) {
                        parcelObtain.writeInt(1);
                        openFileIntentSenderRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.zzoz.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public DriveServiceResponse zza(OpenContentsRequest openContentsRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openContentsRequest != null) {
                        parcelObtain.writeInt(1);
                        openContentsRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (DriveServiceResponse) DriveServiceResponse.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public DriveServiceResponse zza(StreamContentsRequest streamContentsRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (streamContentsRequest != null) {
                        parcelObtain.writeInt(1);
                        streamContentsRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(56, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (DriveServiceResponse) DriveServiceResponse.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (realtimeDocumentSyncRequest != null) {
                        parcelObtain.writeInt(1);
                        realtimeDocumentSyncRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(34, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(AddEventListenerRequest addEventListenerRequest, zzao zzaoVar, String str, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addEventListenerRequest != null) {
                        parcelObtain.writeInt(1);
                        addEventListenerRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzaoVar != null ? zzaoVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(AddPermissionRequest addPermissionRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addPermissionRequest != null) {
                        parcelObtain.writeInt(1);
                        addPermissionRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(48, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(AuthorizeAccessRequest authorizeAccessRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (authorizeAccessRequest != null) {
                        parcelObtain.writeInt(1);
                        authorizeAccessRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (cancelPendingActionsRequest != null) {
                        parcelObtain.writeInt(1);
                        cancelPendingActionsRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(37, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(ChangeResourceParentsRequest changeResourceParentsRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (changeResourceParentsRequest != null) {
                        parcelObtain.writeInt(1);
                        changeResourceParentsRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(55, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (checkResourceIdsExistRequest != null) {
                        parcelObtain.writeInt(1);
                        checkResourceIdsExistRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(30, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsAndUpdateMetadataRequest != null) {
                        parcelObtain.writeInt(1);
                        closeContentsAndUpdateMetadataRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(CloseContentsRequest closeContentsRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsRequest != null) {
                        parcelObtain.writeInt(1);
                        closeContentsRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(ControlProgressRequest controlProgressRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (controlProgressRequest != null) {
                        parcelObtain.writeInt(1);
                        controlProgressRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(53, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(CreateContentsRequest createContentsRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createContentsRequest != null) {
                        parcelObtain.writeInt(1);
                        createContentsRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(CreateFileRequest createFileRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileRequest != null) {
                        parcelObtain.writeInt(1);
                        createFileRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(CreateFolderRequest createFolderRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFolderRequest != null) {
                        parcelObtain.writeInt(1);
                        createFolderRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(DeleteResourceRequest deleteResourceRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (deleteResourceRequest != null) {
                        parcelObtain.writeInt(1);
                        deleteResourceRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(24, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(DisconnectRequest disconnectRequest) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (disconnectRequest != null) {
                        parcelObtain.writeInt(1);
                        disconnectRequest.writeToParcel(parcelObtain, 0);
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

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(FetchThumbnailRequest fetchThumbnailRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (fetchThumbnailRequest != null) {
                        parcelObtain.writeInt(1);
                        fetchThumbnailRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(42, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(GetChangesRequest getChangesRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getChangesRequest != null) {
                        parcelObtain.writeInt(1);
                        getChangesRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(44, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getDriveIdFromUniqueIdentifierRequest != null) {
                        parcelObtain.writeInt(1);
                        getDriveIdFromUniqueIdentifierRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(29, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(GetMetadataRequest getMetadataRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getMetadataRequest != null) {
                        parcelObtain.writeInt(1);
                        getMetadataRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(GetPermissionsRequest getPermissionsRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getPermissionsRequest != null) {
                        parcelObtain.writeInt(1);
                        getPermissionsRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(47, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(ListParentsRequest listParentsRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (listParentsRequest != null) {
                        parcelObtain.writeInt(1);
                        listParentsRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(LoadRealtimeRequest loadRealtimeRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (loadRealtimeRequest != null) {
                        parcelObtain.writeInt(1);
                        loadRealtimeRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(27, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(QueryRequest queryRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        parcelObtain.writeInt(1);
                        queryRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(QueryRequest queryRequest, zzao zzaoVar, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        parcelObtain.writeInt(1);
                        queryRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzaoVar != null ? zzaoVar.asBinder() : null);
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(51, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(RemoveEventListenerRequest removeEventListenerRequest, zzao zzaoVar, String str, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removeEventListenerRequest != null) {
                        parcelObtain.writeInt(1);
                        removeEventListenerRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzaoVar != null ? zzaoVar.asBinder() : null);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(RemovePermissionRequest removePermissionRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removePermissionRequest != null) {
                        parcelObtain.writeInt(1);
                        removePermissionRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(50, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setFileUploadPreferencesRequest != null) {
                        parcelObtain.writeInt(1);
                        setFileUploadPreferencesRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(36, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(SetPinnedDownloadPreferencesRequest setPinnedDownloadPreferencesRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setPinnedDownloadPreferencesRequest != null) {
                        parcelObtain.writeInt(1);
                        setPinnedDownloadPreferencesRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(33, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(SetResourceParentsRequest setResourceParentsRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setResourceParentsRequest != null) {
                        parcelObtain.writeInt(1);
                        setResourceParentsRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(28, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(TrashResourceRequest trashResourceRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (trashResourceRequest != null) {
                        parcelObtain.writeInt(1);
                        trashResourceRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (unsubscribeResourceRequest != null) {
                        parcelObtain.writeInt(1);
                        unsubscribeResourceRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(46, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(UntrashResourceRequest untrashResourceRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (untrashResourceRequest != null) {
                        parcelObtain.writeInt(1);
                        untrashResourceRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(38, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(UpdateMetadataRequest updateMetadataRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updateMetadataRequest != null) {
                        parcelObtain.writeInt(1);
                        updateMetadataRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(UpdatePermissionRequest updatePermissionRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updatePermissionRequest != null) {
                        parcelObtain.writeInt(1);
                        updatePermissionRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(49, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zza(zzao zzaoVar, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    parcelObtain.writeStrongBinder(zzaoVar != null ? zzaoVar.asBinder() : null);
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(52, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zzb(QueryRequest queryRequest, zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        parcelObtain.writeInt(1);
                        queryRequest.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zzb(zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(31, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zzc(zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(32, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zzd(zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(35, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zze(zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(41, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zzf(zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(43, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zzg(zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(54, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void zzh(zzan zzanVar) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    parcelObtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.zzoz.transact(57, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static zzam zzba(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzam)) ? new C0047zza(iBinder) : (zzam) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (GetMetadataRequest) GetMetadataRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (QueryRequest) QueryRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (UpdateMetadataRequest) UpdateMetadataRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (CreateContentsRequest) CreateContentsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (CreateFileRequest) CreateFileRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (CreateFolderRequest) CreateFolderRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    DriveServiceResponse driveServiceResponseZza = zza(parcel.readInt() != 0 ? (OpenContentsRequest) OpenContentsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (driveServiceResponseZza != null) {
                        parcel2.writeInt(1);
                        driveServiceResponseZza.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (CloseContentsRequest) CloseContentsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    IntentSender intentSenderZza = zza(parcel.readInt() != 0 ? (OpenFileIntentSenderRequest) OpenFileIntentSenderRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (intentSenderZza != null) {
                        parcel2.writeInt(1);
                        intentSenderZza.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    IntentSender intentSenderZza2 = zza(parcel.readInt() != 0 ? (CreateFileIntentSenderRequest) CreateFileIntentSenderRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (intentSenderZza2 != null) {
                        parcel2.writeInt(1);
                        intentSenderZza2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (AuthorizeAccessRequest) AuthorizeAccessRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (ListParentsRequest) ListParentsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (AddEventListenerRequest) AddEventListenerRequest.CREATOR.createFromParcel(parcel) : null, zzao.zza.zzbc(parcel.readStrongBinder()), parcel.readString(), zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (RemoveEventListenerRequest) RemoveEventListenerRequest.CREATOR.createFromParcel(parcel) : null, zzao.zza.zzbc(parcel.readStrongBinder()), parcel.readString(), zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (DisconnectRequest) DisconnectRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (TrashResourceRequest) TrashResourceRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (CloseContentsAndUpdateMetadataRequest) CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzb(parcel.readInt() != 0 ? (QueryRequest) QueryRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (DeleteResourceRequest) DeleteResourceRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_COURTHOUSE /* 27 */:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (LoadRealtimeRequest) LoadRealtimeRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_DENTIST /* 28 */:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (SetResourceParentsRequest) SetResourceParentsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_DEPARTMENT_STORE /* 29 */:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (GetDriveIdFromUniqueIdentifierRequest) GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (CheckResourceIdsExistRequest) CheckResourceIdsExistRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzb(zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzc(zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (SetPinnedDownloadPreferencesRequest) SetPinnedDownloadPreferencesRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (RealtimeDocumentSyncRequest) RealtimeDocumentSyncRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzd(zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (SetFileUploadPreferencesRequest) SetFileUploadPreferencesRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (CancelPendingActionsRequest) CancelPendingActionsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (UntrashResourceRequest) UntrashResourceRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zze(zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (FetchThumbnailRequest) FetchThumbnailRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzf(zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (GetChangesRequest) GetChangesRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 46:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (UnsubscribeResourceRequest) UnsubscribeResourceRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (GetPermissionsRequest) GetPermissionsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_HINDU_TEMPLE /* 48 */:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (AddPermissionRequest) AddPermissionRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_HOME_GOODS_STORE /* 49 */:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (UpdatePermissionRequest) UpdatePermissionRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_HOSPITAL /* 50 */:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (RemovePermissionRequest) RemovePermissionRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_INSURANCE_AGENCY /* 51 */:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (QueryRequest) QueryRequest.CREATOR.createFromParcel(parcel) : null, zzao.zza.zzbc(parcel.readStrongBinder()), zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_JEWELRY_STORE /* 52 */:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(zzao.zza.zzbc(parcel.readStrongBinder()), zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_LAUNDRY /* 53 */:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (ControlProgressRequest) ControlProgressRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_LAWYER /* 54 */:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzg(zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_LIBRARY /* 55 */:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zza(parcel.readInt() != 0 ? (ChangeResourceParentsRequest) ChangeResourceParentsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Place.TYPE_LIQUOR_STORE /* 56 */:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    DriveServiceResponse driveServiceResponseZza2 = zza(parcel.readInt() != 0 ? (StreamContentsRequest) StreamContentsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (driveServiceResponseZza2 != null) {
                        parcel2.writeInt(1);
                        driveServiceResponseZza2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case Place.TYPE_LOCAL_GOVERNMENT_OFFICE /* 57 */:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    zzh(zzan.zza.zzbb(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.drive.internal.IDriveService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest);

    IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest);

    DriveServiceResponse zza(OpenContentsRequest openContentsRequest, zzan zzanVar);

    DriveServiceResponse zza(StreamContentsRequest streamContentsRequest, zzan zzanVar);

    void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzan zzanVar);

    void zza(AddEventListenerRequest addEventListenerRequest, zzao zzaoVar, String str, zzan zzanVar);

    void zza(AddPermissionRequest addPermissionRequest, zzan zzanVar);

    void zza(AuthorizeAccessRequest authorizeAccessRequest, zzan zzanVar);

    void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzan zzanVar);

    void zza(ChangeResourceParentsRequest changeResourceParentsRequest, zzan zzanVar);

    void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzan zzanVar);

    void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzan zzanVar);

    void zza(CloseContentsRequest closeContentsRequest, zzan zzanVar);

    void zza(ControlProgressRequest controlProgressRequest, zzan zzanVar);

    void zza(CreateContentsRequest createContentsRequest, zzan zzanVar);

    void zza(CreateFileRequest createFileRequest, zzan zzanVar);

    void zza(CreateFolderRequest createFolderRequest, zzan zzanVar);

    void zza(DeleteResourceRequest deleteResourceRequest, zzan zzanVar);

    void zza(DisconnectRequest disconnectRequest);

    void zza(FetchThumbnailRequest fetchThumbnailRequest, zzan zzanVar);

    void zza(GetChangesRequest getChangesRequest, zzan zzanVar);

    void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzan zzanVar);

    void zza(GetMetadataRequest getMetadataRequest, zzan zzanVar);

    void zza(GetPermissionsRequest getPermissionsRequest, zzan zzanVar);

    void zza(ListParentsRequest listParentsRequest, zzan zzanVar);

    void zza(LoadRealtimeRequest loadRealtimeRequest, zzan zzanVar);

    void zza(QueryRequest queryRequest, zzan zzanVar);

    void zza(QueryRequest queryRequest, zzao zzaoVar, zzan zzanVar);

    void zza(RemoveEventListenerRequest removeEventListenerRequest, zzao zzaoVar, String str, zzan zzanVar);

    void zza(RemovePermissionRequest removePermissionRequest, zzan zzanVar);

    void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzan zzanVar);

    void zza(SetPinnedDownloadPreferencesRequest setPinnedDownloadPreferencesRequest, zzan zzanVar);

    void zza(SetResourceParentsRequest setResourceParentsRequest, zzan zzanVar);

    void zza(TrashResourceRequest trashResourceRequest, zzan zzanVar);

    void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzan zzanVar);

    void zza(UntrashResourceRequest untrashResourceRequest, zzan zzanVar);

    void zza(UpdateMetadataRequest updateMetadataRequest, zzan zzanVar);

    void zza(UpdatePermissionRequest updatePermissionRequest, zzan zzanVar);

    void zza(zzan zzanVar);

    void zza(zzao zzaoVar, zzan zzanVar);

    void zzb(QueryRequest queryRequest, zzan zzanVar);

    void zzb(zzan zzanVar);

    void zzc(zzan zzanVar);

    void zzd(zzan zzanVar);

    void zze(zzan zzanVar);

    void zzf(zzan zzanVar);

    void zzg(zzan zzanVar);

    void zzh(zzan zzanVar);
}
