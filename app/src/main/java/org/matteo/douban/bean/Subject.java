package org.matteo.douban.bean;

import java.io.Serializable;

/**
 * Created by matteo on 2016/4/7.
 */
public class Subject implements Serializable{

    private String id;
    private String title;
    private String original_title;
    private String alt;
    private Image images;
    private Rating rating;
    private String[] pubdates;
    private String year;
    private String subtype;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Image getImages() {
        return images;
    }

    public void setImages(Image images) {
        this.images = images;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String[] getPubdates() {
        return pubdates;
    }

    public void setPubdates(String[] pubdates) {
        this.pubdates = pubdates;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }
}
