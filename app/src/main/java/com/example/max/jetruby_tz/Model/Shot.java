package com.example.max.jetruby_tz.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shot {

    @Expose
    public String title;
    @Expose
    public String description;
    @Expose
    public Boolean animated;
    @Expose
    public Images images;

    public class Images {
        @Expose
        public String hidpi;
        @Expose
        public String normal;
    }
}
