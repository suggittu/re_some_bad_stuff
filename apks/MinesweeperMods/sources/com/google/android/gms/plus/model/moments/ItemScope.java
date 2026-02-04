package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public interface ItemScope extends Freezable {

    public class Builder {
        private String mName;
        private String zzF;
        private String zzJN;
        private double zzaNF;
        private double zzaNG;
        private String zzaxl;
        private final Set zzbeN = new HashSet();
        private ItemScopeEntity zzbeO;
        private List zzbeP;
        private ItemScopeEntity zzbeQ;
        private String zzbeR;
        private String zzbeS;
        private String zzbeT;
        private List zzbeU;
        private int zzbeV;
        private List zzbeW;
        private ItemScopeEntity zzbeX;
        private List zzbeY;
        private String zzbeZ;
        private String zzbfA;
        private String zzbfB;
        private String zzbfC;
        private ItemScopeEntity zzbfD;
        private String zzbfE;
        private String zzbfF;
        private String zzbfG;
        private String zzbfH;
        private String zzbfa;
        private ItemScopeEntity zzbfb;
        private String zzbfc;
        private String zzbfd;
        private List zzbfe;
        private String zzbff;
        private String zzbfg;
        private String zzbfh;
        private String zzbfi;
        private String zzbfj;
        private String zzbfk;
        private String zzbfl;
        private String zzbfm;
        private ItemScopeEntity zzbfn;
        private String zzbfo;
        private String zzbfp;
        private String zzbfq;
        private ItemScopeEntity zzbfr;
        private ItemScopeEntity zzbfs;
        private ItemScopeEntity zzbft;
        private List zzbfu;
        private String zzbfv;
        private String zzbfw;
        private String zzbfx;
        private String zzbfy;
        private ItemScopeEntity zzbfz;
        private String zztZ;
        private String zzyv;

        public ItemScope build() {
            return new ItemScopeEntity(this.zzbeN, this.zzbeO, this.zzbeP, this.zzbeQ, this.zzbeR, this.zzbeS, this.zzbeT, this.zzbeU, this.zzbeV, this.zzbeW, this.zzbeX, this.zzbeY, this.zzbeZ, this.zzbfa, this.zzbfb, this.zzbfc, this.zzbfd, this.zztZ, this.zzbfe, this.zzbff, this.zzbfg, this.zzbfh, this.zzaxl, this.zzbfi, this.zzbfj, this.zzbfk, this.zzbfl, this.zzbfm, this.zzbfn, this.zzbfo, this.zzbfp, this.zzyv, this.zzbfq, this.zzbfr, this.zzaNF, this.zzbfs, this.zzaNG, this.mName, this.zzbft, this.zzbfu, this.zzbfv, this.zzbfw, this.zzbfx, this.zzbfy, this.zzbfz, this.zzbfA, this.zzbfB, this.zzbfC, this.zzbfD, this.zzbfE, this.zzbfF, this.zzJN, this.zzF, this.zzbfG, this.zzbfH);
        }

        public Builder setAbout(ItemScope itemScope) {
            this.zzbeO = (ItemScopeEntity) itemScope;
            this.zzbeN.add(2);
            return this;
        }

        public Builder setAdditionalName(List list) {
            this.zzbeP = list;
            this.zzbeN.add(3);
            return this;
        }

        public Builder setAddress(ItemScope itemScope) {
            this.zzbeQ = (ItemScopeEntity) itemScope;
            this.zzbeN.add(4);
            return this;
        }

        public Builder setAddressCountry(String str) {
            this.zzbeR = str;
            this.zzbeN.add(5);
            return this;
        }

        public Builder setAddressLocality(String str) {
            this.zzbeS = str;
            this.zzbeN.add(6);
            return this;
        }

        public Builder setAddressRegion(String str) {
            this.zzbeT = str;
            this.zzbeN.add(7);
            return this;
        }

        public Builder setAssociated_media(List list) {
            this.zzbeU = list;
            this.zzbeN.add(8);
            return this;
        }

        public Builder setAttendeeCount(int i) {
            this.zzbeV = i;
            this.zzbeN.add(9);
            return this;
        }

        public Builder setAttendees(List list) {
            this.zzbeW = list;
            this.zzbeN.add(10);
            return this;
        }

        public Builder setAudio(ItemScope itemScope) {
            this.zzbeX = (ItemScopeEntity) itemScope;
            this.zzbeN.add(11);
            return this;
        }

        public Builder setAuthor(List list) {
            this.zzbeY = list;
            this.zzbeN.add(12);
            return this;
        }

        public Builder setBestRating(String str) {
            this.zzbeZ = str;
            this.zzbeN.add(13);
            return this;
        }

        public Builder setBirthDate(String str) {
            this.zzbfa = str;
            this.zzbeN.add(14);
            return this;
        }

        public Builder setByArtist(ItemScope itemScope) {
            this.zzbfb = (ItemScopeEntity) itemScope;
            this.zzbeN.add(15);
            return this;
        }

        public Builder setCaption(String str) {
            this.zzbfc = str;
            this.zzbeN.add(16);
            return this;
        }

        public Builder setContentSize(String str) {
            this.zzbfd = str;
            this.zzbeN.add(17);
            return this;
        }

        public Builder setContentUrl(String str) {
            this.zztZ = str;
            this.zzbeN.add(18);
            return this;
        }

        public Builder setContributor(List list) {
            this.zzbfe = list;
            this.zzbeN.add(19);
            return this;
        }

        public Builder setDateCreated(String str) {
            this.zzbff = str;
            this.zzbeN.add(20);
            return this;
        }

        public Builder setDateModified(String str) {
            this.zzbfg = str;
            this.zzbeN.add(21);
            return this;
        }

        public Builder setDatePublished(String str) {
            this.zzbfh = str;
            this.zzbeN.add(22);
            return this;
        }

        public Builder setDescription(String str) {
            this.zzaxl = str;
            this.zzbeN.add(23);
            return this;
        }

        public Builder setDuration(String str) {
            this.zzbfi = str;
            this.zzbeN.add(24);
            return this;
        }

        public Builder setEmbedUrl(String str) {
            this.zzbfj = str;
            this.zzbeN.add(25);
            return this;
        }

        public Builder setEndDate(String str) {
            this.zzbfk = str;
            this.zzbeN.add(26);
            return this;
        }

        public Builder setFamilyName(String str) {
            this.zzbfl = str;
            this.zzbeN.add(27);
            return this;
        }

        public Builder setGender(String str) {
            this.zzbfm = str;
            this.zzbeN.add(28);
            return this;
        }

        public Builder setGeo(ItemScope itemScope) {
            this.zzbfn = (ItemScopeEntity) itemScope;
            this.zzbeN.add(29);
            return this;
        }

        public Builder setGivenName(String str) {
            this.zzbfo = str;
            this.zzbeN.add(30);
            return this;
        }

        public Builder setHeight(String str) {
            this.zzbfp = str;
            this.zzbeN.add(31);
            return this;
        }

        public Builder setId(String str) {
            this.zzyv = str;
            this.zzbeN.add(32);
            return this;
        }

        public Builder setImage(String str) {
            this.zzbfq = str;
            this.zzbeN.add(33);
            return this;
        }

        public Builder setInAlbum(ItemScope itemScope) {
            this.zzbfr = (ItemScopeEntity) itemScope;
            this.zzbeN.add(34);
            return this;
        }

        public Builder setLatitude(double d) {
            this.zzaNF = d;
            this.zzbeN.add(36);
            return this;
        }

        public Builder setLocation(ItemScope itemScope) {
            this.zzbfs = (ItemScopeEntity) itemScope;
            this.zzbeN.add(37);
            return this;
        }

        public Builder setLongitude(double d) {
            this.zzaNG = d;
            this.zzbeN.add(38);
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            this.zzbeN.add(39);
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope itemScope) {
            this.zzbft = (ItemScopeEntity) itemScope;
            this.zzbeN.add(40);
            return this;
        }

        public Builder setPerformers(List list) {
            this.zzbfu = list;
            this.zzbeN.add(41);
            return this;
        }

        public Builder setPlayerType(String str) {
            this.zzbfv = str;
            this.zzbeN.add(42);
            return this;
        }

        public Builder setPostOfficeBoxNumber(String str) {
            this.zzbfw = str;
            this.zzbeN.add(43);
            return this;
        }

        public Builder setPostalCode(String str) {
            this.zzbfx = str;
            this.zzbeN.add(44);
            return this;
        }

        public Builder setRatingValue(String str) {
            this.zzbfy = str;
            this.zzbeN.add(45);
            return this;
        }

        public Builder setReviewRating(ItemScope itemScope) {
            this.zzbfz = (ItemScopeEntity) itemScope;
            this.zzbeN.add(46);
            return this;
        }

        public Builder setStartDate(String str) {
            this.zzbfA = str;
            this.zzbeN.add(47);
            return this;
        }

        public Builder setStreetAddress(String str) {
            this.zzbfB = str;
            this.zzbeN.add(48);
            return this;
        }

        public Builder setText(String str) {
            this.zzbfC = str;
            this.zzbeN.add(49);
            return this;
        }

        public Builder setThumbnail(ItemScope itemScope) {
            this.zzbfD = (ItemScopeEntity) itemScope;
            this.zzbeN.add(50);
            return this;
        }

        public Builder setThumbnailUrl(String str) {
            this.zzbfE = str;
            this.zzbeN.add(51);
            return this;
        }

        public Builder setTickerSymbol(String str) {
            this.zzbfF = str;
            this.zzbeN.add(52);
            return this;
        }

        public Builder setType(String str) {
            this.zzJN = str;
            this.zzbeN.add(53);
            return this;
        }

        public Builder setUrl(String str) {
            this.zzF = str;
            this.zzbeN.add(54);
            return this;
        }

        public Builder setWidth(String str) {
            this.zzbfG = str;
            this.zzbeN.add(55);
            return this;
        }

        public Builder setWorstRating(String str) {
            this.zzbfH = str;
            this.zzbeN.add(56);
            return this;
        }
    }

    ItemScope getAbout();

    List getAdditionalName();

    ItemScope getAddress();

    String getAddressCountry();

    String getAddressLocality();

    String getAddressRegion();

    List getAssociated_media();

    int getAttendeeCount();

    List getAttendees();

    ItemScope getAudio();

    List getAuthor();

    String getBestRating();

    String getBirthDate();

    ItemScope getByArtist();

    String getCaption();

    String getContentSize();

    String getContentUrl();

    List getContributor();

    String getDateCreated();

    String getDateModified();

    String getDatePublished();

    String getDescription();

    String getDuration();

    String getEmbedUrl();

    String getEndDate();

    String getFamilyName();

    String getGender();

    ItemScope getGeo();

    String getGivenName();

    String getHeight();

    String getId();

    String getImage();

    ItemScope getInAlbum();

    double getLatitude();

    ItemScope getLocation();

    double getLongitude();

    String getName();

    ItemScope getPartOfTVSeries();

    List getPerformers();

    String getPlayerType();

    String getPostOfficeBoxNumber();

    String getPostalCode();

    String getRatingValue();

    ItemScope getReviewRating();

    String getStartDate();

    String getStreetAddress();

    String getText();

    ItemScope getThumbnail();

    String getThumbnailUrl();

    String getTickerSymbol();

    String getType();

    String getUrl();

    String getWidth();

    String getWorstRating();

    boolean hasAbout();

    boolean hasAdditionalName();

    boolean hasAddress();

    boolean hasAddressCountry();

    boolean hasAddressLocality();

    boolean hasAddressRegion();

    boolean hasAssociated_media();

    boolean hasAttendeeCount();

    boolean hasAttendees();

    boolean hasAudio();

    boolean hasAuthor();

    boolean hasBestRating();

    boolean hasBirthDate();

    boolean hasByArtist();

    boolean hasCaption();

    boolean hasContentSize();

    boolean hasContentUrl();

    boolean hasContributor();

    boolean hasDateCreated();

    boolean hasDateModified();

    boolean hasDatePublished();

    boolean hasDescription();

    boolean hasDuration();

    boolean hasEmbedUrl();

    boolean hasEndDate();

    boolean hasFamilyName();

    boolean hasGender();

    boolean hasGeo();

    boolean hasGivenName();

    boolean hasHeight();

    boolean hasId();

    boolean hasImage();

    boolean hasInAlbum();

    boolean hasLatitude();

    boolean hasLocation();

    boolean hasLongitude();

    boolean hasName();

    boolean hasPartOfTVSeries();

    boolean hasPerformers();

    boolean hasPlayerType();

    boolean hasPostOfficeBoxNumber();

    boolean hasPostalCode();

    boolean hasRatingValue();

    boolean hasReviewRating();

    boolean hasStartDate();

    boolean hasStreetAddress();

    boolean hasText();

    boolean hasThumbnail();

    boolean hasThumbnailUrl();

    boolean hasTickerSymbol();

    boolean hasType();

    boolean hasUrl();

    boolean hasWidth();

    boolean hasWorstRating();
}
