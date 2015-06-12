package com.appturbo.appturbotest.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lagachebaptiste on 11/06/15.
 */
public class Application implements Parcelable {
    /*
     * TODO: This class need to implement parcelable in order to be send from one Activity to another one by the Intent extra.
     */

    private String name;
    private String description;
    private String logo;
    private String screenshot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }
}
