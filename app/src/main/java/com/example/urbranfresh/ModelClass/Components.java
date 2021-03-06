package com.example.urbranfresh.ModelClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Components {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("StaticBanner")
    @Expose
    private List<StaticBanner> staticBanner = null;
    @SerializedName("categorydata")
    @Expose
    private List<Categorydatum> categorydata = null;
    @SerializedName("AdsBanner")
    @Expose
    private List<AdsBanner> adsBanner = null;
    @SerializedName("CarouselBanner")
    @Expose
    private List<Object> carouselBanner = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StaticBanner> getStaticBanner() {
        return staticBanner;
    }

    public void setStaticBanner(List<StaticBanner> staticBanner) {
        this.staticBanner = staticBanner;
    }

    public List<Categorydatum> getCategorydata() {
        return categorydata;
    }

    public void setCategorydata(List<Categorydatum> categorydata) {
        this.categorydata = categorydata;
    }

    public List<AdsBanner> getAdsBanner() {
        return adsBanner;
    }

    public void setAdsBanner(List<AdsBanner> adsBanner) {
        this.adsBanner = adsBanner;
    }

    public List<Object> getCarouselBanner() {
        return carouselBanner;
    }

    public void setCarouselBanner(List<Object> carouselBanner) {
        this.carouselBanner = carouselBanner;
    }
}
