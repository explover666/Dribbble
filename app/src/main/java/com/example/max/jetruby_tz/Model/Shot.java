package com.example.max.jetruby_tz.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shot {

    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("animated")
    @Expose
    public Boolean animated;
    @SerializedName("images")
    @Expose
    public Images images;


    public class Images {

        @SerializedName("hidpi")
        @Expose
        public String hidpi;
        @SerializedName("normal")
        @Expose
        public String normal;
    }
}
