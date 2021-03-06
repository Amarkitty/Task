package com.example.urbranfresh.ModelClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdsBanner {

    @SerializedName("banner_id")
    @Expose
    private Integer bannerId;
    @SerializedName("banner_name")
    @Expose
    private String bannerName;
    @SerializedName("banner_description")
    @Expose
    private String bannerDescription;
    @SerializedName("banner_alt")
    @Expose
    private String bannerAlt;
    @SerializedName("banner_image")
    @Expose
    private String bannerImage;
    @SerializedName("url_type")
    @Expose
    private String urlType;
    @SerializedName("url_id")
    @Expose
    private Integer urlId;

    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getBannerDescription() {
        return bannerDescription;
    }

    public void setBannerDescription(String bannerDescription) {
        this.bannerDescription = bannerDescription;
    }

    public String getBannerAlt() {
        return bannerAlt;
    }

    public void setBannerAlt(String bannerAlt) {
        this.bannerAlt = bannerAlt;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    public Integer getUrlId() {
        return urlId;
    }

    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }
}
