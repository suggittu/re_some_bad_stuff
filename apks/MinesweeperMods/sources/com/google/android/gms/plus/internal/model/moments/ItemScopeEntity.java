package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class ItemScopeEntity extends FastSafeParcelableJsonResponse implements ItemScope {
    public static final zza CREATOR = new zza();
    private static final HashMap zzbeM;
    String mName;
    final int mVersionCode;
    String zzF;
    String zzJN;
    double zzaNF;
    double zzaNG;
    String zzaxl;
    final Set zzbeN;
    ItemScopeEntity zzbeO;
    List zzbeP;
    ItemScopeEntity zzbeQ;
    String zzbeR;
    String zzbeS;
    String zzbeT;
    List zzbeU;
    int zzbeV;
    List zzbeW;
    ItemScopeEntity zzbeX;
    List zzbeY;
    String zzbeZ;
    String zzbfA;
    String zzbfB;
    String zzbfC;
    ItemScopeEntity zzbfD;
    String zzbfE;
    String zzbfF;
    String zzbfG;
    String zzbfH;
    String zzbfa;
    ItemScopeEntity zzbfb;
    String zzbfc;
    String zzbfd;
    List zzbfe;
    String zzbff;
    String zzbfg;
    String zzbfh;
    String zzbfi;
    String zzbfj;
    String zzbfk;
    String zzbfl;
    String zzbfm;
    ItemScopeEntity zzbfn;
    String zzbfo;
    String zzbfp;
    String zzbfq;
    ItemScopeEntity zzbfr;
    ItemScopeEntity zzbfs;
    ItemScopeEntity zzbft;
    List zzbfu;
    String zzbfv;
    String zzbfw;
    String zzbfx;
    String zzbfy;
    ItemScopeEntity zzbfz;
    String zztZ;
    String zzyv;

    static {
        HashMap map = new HashMap();
        zzbeM = map;
        map.put("about", FastJsonResponse.Field.zza("about", 2, ItemScopeEntity.class));
        zzbeM.put("additionalName", FastJsonResponse.Field.zzm("additionalName", 3));
        zzbeM.put("address", FastJsonResponse.Field.zza("address", 4, ItemScopeEntity.class));
        zzbeM.put("addressCountry", FastJsonResponse.Field.zzl("addressCountry", 5));
        zzbeM.put("addressLocality", FastJsonResponse.Field.zzl("addressLocality", 6));
        zzbeM.put("addressRegion", FastJsonResponse.Field.zzl("addressRegion", 7));
        zzbeM.put("associated_media", FastJsonResponse.Field.zzb("associated_media", 8, ItemScopeEntity.class));
        zzbeM.put("attendeeCount", FastJsonResponse.Field.zzi("attendeeCount", 9));
        zzbeM.put("attendees", FastJsonResponse.Field.zzb("attendees", 10, ItemScopeEntity.class));
        zzbeM.put("audio", FastJsonResponse.Field.zza("audio", 11, ItemScopeEntity.class));
        zzbeM.put("author", FastJsonResponse.Field.zzb("author", 12, ItemScopeEntity.class));
        zzbeM.put("bestRating", FastJsonResponse.Field.zzl("bestRating", 13));
        zzbeM.put("birthDate", FastJsonResponse.Field.zzl("birthDate", 14));
        zzbeM.put("byArtist", FastJsonResponse.Field.zza("byArtist", 15, ItemScopeEntity.class));
        zzbeM.put("caption", FastJsonResponse.Field.zzl("caption", 16));
        zzbeM.put("contentSize", FastJsonResponse.Field.zzl("contentSize", 17));
        zzbeM.put("contentUrl", FastJsonResponse.Field.zzl("contentUrl", 18));
        zzbeM.put("contributor", FastJsonResponse.Field.zzb("contributor", 19, ItemScopeEntity.class));
        zzbeM.put("dateCreated", FastJsonResponse.Field.zzl("dateCreated", 20));
        zzbeM.put("dateModified", FastJsonResponse.Field.zzl("dateModified", 21));
        zzbeM.put("datePublished", FastJsonResponse.Field.zzl("datePublished", 22));
        zzbeM.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        zzbeM.put("duration", FastJsonResponse.Field.zzl("duration", 24));
        zzbeM.put("embedUrl", FastJsonResponse.Field.zzl("embedUrl", 25));
        zzbeM.put("endDate", FastJsonResponse.Field.zzl("endDate", 26));
        zzbeM.put("familyName", FastJsonResponse.Field.zzl("familyName", 27));
        zzbeM.put("gender", FastJsonResponse.Field.zzl("gender", 28));
        zzbeM.put("geo", FastJsonResponse.Field.zza("geo", 29, ItemScopeEntity.class));
        zzbeM.put("givenName", FastJsonResponse.Field.zzl("givenName", 30));
        zzbeM.put("height", FastJsonResponse.Field.zzl("height", 31));
        zzbeM.put("id", FastJsonResponse.Field.zzl("id", 32));
        zzbeM.put("image", FastJsonResponse.Field.zzl("image", 33));
        zzbeM.put("inAlbum", FastJsonResponse.Field.zza("inAlbum", 34, ItemScopeEntity.class));
        zzbeM.put("latitude", FastJsonResponse.Field.zzj("latitude", 36));
        zzbeM.put("location", FastJsonResponse.Field.zza("location", 37, ItemScopeEntity.class));
        zzbeM.put("longitude", FastJsonResponse.Field.zzj("longitude", 38));
        zzbeM.put("name", FastJsonResponse.Field.zzl("name", 39));
        zzbeM.put("partOfTVSeries", FastJsonResponse.Field.zza("partOfTVSeries", 40, ItemScopeEntity.class));
        zzbeM.put("performers", FastJsonResponse.Field.zzb("performers", 41, ItemScopeEntity.class));
        zzbeM.put("playerType", FastJsonResponse.Field.zzl("playerType", 42));
        zzbeM.put("postOfficeBoxNumber", FastJsonResponse.Field.zzl("postOfficeBoxNumber", 43));
        zzbeM.put("postalCode", FastJsonResponse.Field.zzl("postalCode", 44));
        zzbeM.put("ratingValue", FastJsonResponse.Field.zzl("ratingValue", 45));
        zzbeM.put("reviewRating", FastJsonResponse.Field.zza("reviewRating", 46, ItemScopeEntity.class));
        zzbeM.put("startDate", FastJsonResponse.Field.zzl("startDate", 47));
        zzbeM.put("streetAddress", FastJsonResponse.Field.zzl("streetAddress", 48));
        zzbeM.put("text", FastJsonResponse.Field.zzl("text", 49));
        zzbeM.put("thumbnail", FastJsonResponse.Field.zza("thumbnail", 50, ItemScopeEntity.class));
        zzbeM.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        zzbeM.put("tickerSymbol", FastJsonResponse.Field.zzl("tickerSymbol", 52));
        zzbeM.put("type", FastJsonResponse.Field.zzl("type", 53));
        zzbeM.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 54));
        zzbeM.put("width", FastJsonResponse.Field.zzl("width", 55));
        zzbeM.put("worstRating", FastJsonResponse.Field.zzl("worstRating", 56));
    }

    public ItemScopeEntity() {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
    }

    ItemScopeEntity(Set set, int i, ItemScopeEntity itemScopeEntity, List list, ItemScopeEntity itemScopeEntity2, String str, String str2, String str3, List list2, int i2, List list3, ItemScopeEntity itemScopeEntity3, List list4, String str4, String str5, ItemScopeEntity itemScopeEntity4, String str6, String str7, String str8, List list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ItemScopeEntity itemScopeEntity5, String str18, String str19, String str20, String str21, ItemScopeEntity itemScopeEntity6, double d, ItemScopeEntity itemScopeEntity7, double d2, String str22, ItemScopeEntity itemScopeEntity8, List list6, String str23, String str24, String str25, String str26, ItemScopeEntity itemScopeEntity9, String str27, String str28, String str29, ItemScopeEntity itemScopeEntity10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.zzbeN = set;
        this.mVersionCode = i;
        this.zzbeO = itemScopeEntity;
        this.zzbeP = list;
        this.zzbeQ = itemScopeEntity2;
        this.zzbeR = str;
        this.zzbeS = str2;
        this.zzbeT = str3;
        this.zzbeU = list2;
        this.zzbeV = i2;
        this.zzbeW = list3;
        this.zzbeX = itemScopeEntity3;
        this.zzbeY = list4;
        this.zzbeZ = str4;
        this.zzbfa = str5;
        this.zzbfb = itemScopeEntity4;
        this.zzbfc = str6;
        this.zzbfd = str7;
        this.zztZ = str8;
        this.zzbfe = list5;
        this.zzbff = str9;
        this.zzbfg = str10;
        this.zzbfh = str11;
        this.zzaxl = str12;
        this.zzbfi = str13;
        this.zzbfj = str14;
        this.zzbfk = str15;
        this.zzbfl = str16;
        this.zzbfm = str17;
        this.zzbfn = itemScopeEntity5;
        this.zzbfo = str18;
        this.zzbfp = str19;
        this.zzyv = str20;
        this.zzbfq = str21;
        this.zzbfr = itemScopeEntity6;
        this.zzaNF = d;
        this.zzbfs = itemScopeEntity7;
        this.zzaNG = d2;
        this.mName = str22;
        this.zzbft = itemScopeEntity8;
        this.zzbfu = list6;
        this.zzbfv = str23;
        this.zzbfw = str24;
        this.zzbfx = str25;
        this.zzbfy = str26;
        this.zzbfz = itemScopeEntity9;
        this.zzbfA = str27;
        this.zzbfB = str28;
        this.zzbfC = str29;
        this.zzbfD = itemScopeEntity10;
        this.zzbfE = str30;
        this.zzbfF = str31;
        this.zzJN = str32;
        this.zzF = str33;
        this.zzbfG = str34;
        this.zzbfH = str35;
    }

    public ItemScopeEntity(Set set, ItemScopeEntity itemScopeEntity, List list, ItemScopeEntity itemScopeEntity2, String str, String str2, String str3, List list2, int i, List list3, ItemScopeEntity itemScopeEntity3, List list4, String str4, String str5, ItemScopeEntity itemScopeEntity4, String str6, String str7, String str8, List list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ItemScopeEntity itemScopeEntity5, String str18, String str19, String str20, String str21, ItemScopeEntity itemScopeEntity6, double d, ItemScopeEntity itemScopeEntity7, double d2, String str22, ItemScopeEntity itemScopeEntity8, List list6, String str23, String str24, String str25, String str26, ItemScopeEntity itemScopeEntity9, String str27, String str28, String str29, ItemScopeEntity itemScopeEntity10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.zzbeN = set;
        this.mVersionCode = 1;
        this.zzbeO = itemScopeEntity;
        this.zzbeP = list;
        this.zzbeQ = itemScopeEntity2;
        this.zzbeR = str;
        this.zzbeS = str2;
        this.zzbeT = str3;
        this.zzbeU = list2;
        this.zzbeV = i;
        this.zzbeW = list3;
        this.zzbeX = itemScopeEntity3;
        this.zzbeY = list4;
        this.zzbeZ = str4;
        this.zzbfa = str5;
        this.zzbfb = itemScopeEntity4;
        this.zzbfc = str6;
        this.zzbfd = str7;
        this.zztZ = str8;
        this.zzbfe = list5;
        this.zzbff = str9;
        this.zzbfg = str10;
        this.zzbfh = str11;
        this.zzaxl = str12;
        this.zzbfi = str13;
        this.zzbfj = str14;
        this.zzbfk = str15;
        this.zzbfl = str16;
        this.zzbfm = str17;
        this.zzbfn = itemScopeEntity5;
        this.zzbfo = str18;
        this.zzbfp = str19;
        this.zzyv = str20;
        this.zzbfq = str21;
        this.zzbfr = itemScopeEntity6;
        this.zzaNF = d;
        this.zzbfs = itemScopeEntity7;
        this.zzaNG = d2;
        this.mName = str22;
        this.zzbft = itemScopeEntity8;
        this.zzbfu = list6;
        this.zzbfv = str23;
        this.zzbfw = str24;
        this.zzbfx = str25;
        this.zzbfy = str26;
        this.zzbfz = itemScopeEntity9;
        this.zzbfA = str27;
        this.zzbfB = str28;
        this.zzbfC = str29;
        this.zzbfD = itemScopeEntity10;
        this.zzbfE = str30;
        this.zzbfF = str31;
        this.zzJN = str32;
        this.zzF = str33;
        this.zzbfG = str34;
        this.zzbfH = str35;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        zza zzaVar = CREATOR;
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ItemScopeEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ItemScopeEntity itemScopeEntity = (ItemScopeEntity) obj;
        for (FastJsonResponse.Field field : zzbeM.values()) {
            if (zza(field)) {
                if (itemScopeEntity.zza(field) && zzb(field).equals(itemScopeEntity.zzb(field))) {
                }
                return false;
            }
            if (itemScopeEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final ItemScope getAbout() {
        return this.zzbeO;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final List getAdditionalName() {
        return this.zzbeP;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final ItemScope getAddress() {
        return this.zzbeQ;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getAddressCountry() {
        return this.zzbeR;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getAddressLocality() {
        return this.zzbeS;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getAddressRegion() {
        return this.zzbeT;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final List getAssociated_media() {
        return (ArrayList) this.zzbeU;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final int getAttendeeCount() {
        return this.zzbeV;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final List getAttendees() {
        return (ArrayList) this.zzbeW;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final ItemScope getAudio() {
        return this.zzbeX;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final List getAuthor() {
        return (ArrayList) this.zzbeY;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getBestRating() {
        return this.zzbeZ;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getBirthDate() {
        return this.zzbfa;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final ItemScope getByArtist() {
        return this.zzbfb;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getCaption() {
        return this.zzbfc;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getContentSize() {
        return this.zzbfd;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getContentUrl() {
        return this.zztZ;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final List getContributor() {
        return (ArrayList) this.zzbfe;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getDateCreated() {
        return this.zzbff;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getDateModified() {
        return this.zzbfg;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getDatePublished() {
        return this.zzbfh;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getDescription() {
        return this.zzaxl;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getDuration() {
        return this.zzbfi;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getEmbedUrl() {
        return this.zzbfj;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getEndDate() {
        return this.zzbfk;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getFamilyName() {
        return this.zzbfl;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getGender() {
        return this.zzbfm;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final ItemScope getGeo() {
        return this.zzbfn;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getGivenName() {
        return this.zzbfo;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getHeight() {
        return this.zzbfp;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getId() {
        return this.zzyv;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getImage() {
        return this.zzbfq;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final ItemScope getInAlbum() {
        return this.zzbfr;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final double getLatitude() {
        return this.zzaNF;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final ItemScope getLocation() {
        return this.zzbfs;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final double getLongitude() {
        return this.zzaNG;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getName() {
        return this.mName;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final ItemScope getPartOfTVSeries() {
        return this.zzbft;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final List getPerformers() {
        return (ArrayList) this.zzbfu;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getPlayerType() {
        return this.zzbfv;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getPostOfficeBoxNumber() {
        return this.zzbfw;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getPostalCode() {
        return this.zzbfx;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getRatingValue() {
        return this.zzbfy;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final ItemScope getReviewRating() {
        return this.zzbfz;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getStartDate() {
        return this.zzbfA;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getStreetAddress() {
        return this.zzbfB;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getText() {
        return this.zzbfC;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final ItemScope getThumbnail() {
        return this.zzbfD;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getThumbnailUrl() {
        return this.zzbfE;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getTickerSymbol() {
        return this.zzbfF;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getType() {
        return this.zzJN;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getUrl() {
        return this.zzF;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getWidth() {
        return this.zzbfG;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final String getWorstRating() {
        return this.zzbfH;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasAbout() {
        return this.zzbeN.contains(2);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasAdditionalName() {
        return this.zzbeN.contains(3);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasAddress() {
        return this.zzbeN.contains(4);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasAddressCountry() {
        return this.zzbeN.contains(5);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasAddressLocality() {
        return this.zzbeN.contains(6);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasAddressRegion() {
        return this.zzbeN.contains(7);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasAssociated_media() {
        return this.zzbeN.contains(8);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasAttendeeCount() {
        return this.zzbeN.contains(9);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasAttendees() {
        return this.zzbeN.contains(10);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasAudio() {
        return this.zzbeN.contains(11);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasAuthor() {
        return this.zzbeN.contains(12);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasBestRating() {
        return this.zzbeN.contains(13);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasBirthDate() {
        return this.zzbeN.contains(14);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasByArtist() {
        return this.zzbeN.contains(15);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasCaption() {
        return this.zzbeN.contains(16);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasContentSize() {
        return this.zzbeN.contains(17);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasContentUrl() {
        return this.zzbeN.contains(18);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasContributor() {
        return this.zzbeN.contains(19);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasDateCreated() {
        return this.zzbeN.contains(20);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasDateModified() {
        return this.zzbeN.contains(21);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasDatePublished() {
        return this.zzbeN.contains(22);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasDescription() {
        return this.zzbeN.contains(23);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasDuration() {
        return this.zzbeN.contains(24);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasEmbedUrl() {
        return this.zzbeN.contains(25);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasEndDate() {
        return this.zzbeN.contains(26);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasFamilyName() {
        return this.zzbeN.contains(27);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasGender() {
        return this.zzbeN.contains(28);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasGeo() {
        return this.zzbeN.contains(29);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasGivenName() {
        return this.zzbeN.contains(30);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasHeight() {
        return this.zzbeN.contains(31);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasId() {
        return this.zzbeN.contains(32);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasImage() {
        return this.zzbeN.contains(33);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasInAlbum() {
        return this.zzbeN.contains(34);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasLatitude() {
        return this.zzbeN.contains(36);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasLocation() {
        return this.zzbeN.contains(37);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasLongitude() {
        return this.zzbeN.contains(38);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasName() {
        return this.zzbeN.contains(39);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasPartOfTVSeries() {
        return this.zzbeN.contains(40);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasPerformers() {
        return this.zzbeN.contains(41);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasPlayerType() {
        return this.zzbeN.contains(42);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasPostOfficeBoxNumber() {
        return this.zzbeN.contains(43);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasPostalCode() {
        return this.zzbeN.contains(44);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasRatingValue() {
        return this.zzbeN.contains(45);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasReviewRating() {
        return this.zzbeN.contains(46);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasStartDate() {
        return this.zzbeN.contains(47);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasStreetAddress() {
        return this.zzbeN.contains(48);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasText() {
        return this.zzbeN.contains(49);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasThumbnail() {
        return this.zzbeN.contains(50);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasThumbnailUrl() {
        return this.zzbeN.contains(51);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasTickerSymbol() {
        return this.zzbeN.contains(52);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasType() {
        return this.zzbeN.contains(53);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasUrl() {
        return this.zzbeN.contains(54);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasWidth() {
        return this.zzbeN.contains(55);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public final boolean hasWorstRating() {
        return this.zzbeN.contains(56);
    }

    public final int hashCode() {
        int iHashCode = 0;
        Iterator it = zzbeM.values().iterator();
        while (true) {
            int i = iHashCode;
            if (!it.hasNext()) {
                return i;
            }
            FastJsonResponse.Field field = (FastJsonResponse.Field) it.next();
            if (zza(field)) {
                iHashCode = zzb(field).hashCode() + i + field.zzrs();
            } else {
                iHashCode = i;
            }
        }
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zza zzaVar = CREATOR;
        zza.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: zzFl, reason: merged with bridge method [inline-methods] */
    public final HashMap zzrl() {
        return zzbeM;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: zzFm, reason: merged with bridge method [inline-methods] */
    public final ItemScopeEntity freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final boolean zza(FastJsonResponse.Field field) {
        return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final Object zzb(FastJsonResponse.Field field) {
        switch (field.zzrs()) {
            case 2:
                return this.zzbeO;
            case 3:
                return this.zzbeP;
            case 4:
                return this.zzbeQ;
            case 5:
                return this.zzbeR;
            case 6:
                return this.zzbeS;
            case 7:
                return this.zzbeT;
            case 8:
                return this.zzbeU;
            case 9:
                return Integer.valueOf(this.zzbeV);
            case 10:
                return this.zzbeW;
            case 11:
                return this.zzbeX;
            case 12:
                return this.zzbeY;
            case 13:
                return this.zzbeZ;
            case 14:
                return this.zzbfa;
            case 15:
                return this.zzbfb;
            case 16:
                return this.zzbfc;
            case 17:
                return this.zzbfd;
            case 18:
                return this.zztZ;
            case 19:
                return this.zzbfe;
            case 20:
                return this.zzbff;
            case 21:
                return this.zzbfg;
            case 22:
                return this.zzbfh;
            case 23:
                return this.zzaxl;
            case 24:
                return this.zzbfi;
            case 25:
                return this.zzbfj;
            case Place.TYPE_CONVENIENCE_STORE /* 26 */:
                return this.zzbfk;
            case Place.TYPE_COURTHOUSE /* 27 */:
                return this.zzbfl;
            case Place.TYPE_DENTIST /* 28 */:
                return this.zzbfm;
            case Place.TYPE_DEPARTMENT_STORE /* 29 */:
                return this.zzbfn;
            case 30:
                return this.zzbfo;
            case 31:
                return this.zzbfp;
            case 32:
                return this.zzyv;
            case 33:
                return this.zzbfq;
            case 34:
                return this.zzbfr;
            case 35:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            case 36:
                return Double.valueOf(this.zzaNF);
            case 37:
                return this.zzbfs;
            case 38:
                return Double.valueOf(this.zzaNG);
            case 39:
                return this.mName;
            case 40:
                return this.zzbft;
            case 41:
                return this.zzbfu;
            case 42:
                return this.zzbfv;
            case 43:
                return this.zzbfw;
            case 44:
                return this.zzbfx;
            case 45:
                return this.zzbfy;
            case 46:
                return this.zzbfz;
            case 47:
                return this.zzbfA;
            case Place.TYPE_HINDU_TEMPLE /* 48 */:
                return this.zzbfB;
            case Place.TYPE_HOME_GOODS_STORE /* 49 */:
                return this.zzbfC;
            case Place.TYPE_HOSPITAL /* 50 */:
                return this.zzbfD;
            case Place.TYPE_INSURANCE_AGENCY /* 51 */:
                return this.zzbfE;
            case Place.TYPE_JEWELRY_STORE /* 52 */:
                return this.zzbfF;
            case Place.TYPE_LAUNDRY /* 53 */:
                return this.zzJN;
            case Place.TYPE_LAWYER /* 54 */:
                return this.zzF;
            case Place.TYPE_LIBRARY /* 55 */:
                return this.zzbfG;
            case Place.TYPE_LIQUOR_STORE /* 56 */:
                return this.zzbfH;
        }
    }
}
