package com.example.urbranfresh.ModelClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenuList {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("components")
    @Expose
    private List<Components> components = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Components> getComponents() {
        return components;
    }

    public void setComponents(List<Components> components) {
        this.components = components;
    }
}

