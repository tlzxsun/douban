package org.matteo.douban.bean;

import org.matteo.douban.R;
import org.matteo.douban.util.UIUtil;

import java.io.Serializable;

/**
 * Created by matteo on 2015/6/19.
 */
public class Movie  implements Serializable {
    private String id;
    private String title;
    private String original_title;
    private String[] aka;
    private String alt;
    private String mobile_url;
    private Rating rating;
    private int ratings_count;
    private int wish_count;
    private int collect_count;
    private int do_count;
    private Image images;
    private String subtype;
    private Artist[] directors;
    private Artist[] casts;
    private Artist[] writers;
    private String website;
    private String douban_site;
    private String[] pubdates;
    private String mainland_pubdate;
    private String pubdate;
    private String year;
    private String[] languages;
    private String[] durations;
    private String[] genres;
    private String[] countries;
    private String summary;
    private int comments_count;
    private int reviews_count;
    private int seasons_count;
    private int current_season;
    private int episodes_count;
    private String scheudle_url;
    private String[] trailer_urs;
    private Photo[] photos;

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

    public String[] getAka() {
        return aka;
    }

    public void setAka(String[] aka) {
        this.aka = aka;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public int getDo_count() {
        return do_count;
    }

    public void setDo_count(int do_count) {
        this.do_count = do_count;
    }

    public Image getImages() {
        return images;
    }

    public void setImages(Image images) {
        this.images = images;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public Artist[] getDirectors() {
        return directors;
    }

    public void setDirectors(Artist[] directors) {
        this.directors = directors;
    }

    public Artist[] getCasts() {
        return casts;
    }

    public void setCasts(Artist[] casts) {
        this.casts = casts;
    }

    public Artist[] getWriters() {
        return writers;
    }

    public void setWriters(Artist[] writers) {
        this.writers = writers;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String[] getPubdates() {
        return pubdates;
    }

    public void setPubdates(String[] pubdates) {
        this.pubdates = pubdates;
    }

    public String getMainland_pubdate() {
        return mainland_pubdate;
    }

    public void setMainland_pubdate(String mainland_pubdate) {
        this.mainland_pubdate = mainland_pubdate;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String[] getDurations() {
        return durations;
    }

    public void setDurations(String[] durations) {
        this.durations = durations;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(int seasons_count) {
        this.seasons_count = seasons_count;
    }

    public int getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(int current_season) {
        this.current_season = current_season;
    }

    public int getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(int episodes_count) {
        this.episodes_count = episodes_count;
    }

    public String getScheudle_url() {
        return scheudle_url;
    }

    public void setScheudle_url(String scheudle_url) {
        this.scheudle_url = scheudle_url;
    }

    public String[] getTrailer_urs() {
        return trailer_urs;
    }

    public void setTrailer_urs(String[] trailer_urs) {
        this.trailer_urs = trailer_urs;
    }

    public Photo[] getPhotos() {
        return photos;
    }

    public void setPhotos(Photo[] photos) {
        this.photos = photos;
    }

    public String getArtists() {
        String artists = "";
        if(getDirectors() != null) {
            artists += UIUtil.getString(R.string.director) + "\n";
            for(int i = 0; i < getDirectors().length; i++) {
                Artist artist = getDirectors()[i];
                if(i != 0) {
                    artists += "\\";
                }
                artists += artist.getName();
            }
            artists += "\n";
        }
        if(getWriters() != null) {
            artists += UIUtil.getString(R.string.writer) + "\n";
            for(int i = 0; i < getWriters().length; i++) {
                Artist artist = getWriters()[i];
                if(i != 0) {
                    artists += "\\";
                }
                artists += artist.getName();
            }
            artists += "\n";
        }
        if(getCasts() != null) {
            artists += UIUtil.getString(R.string.main_actor) + "\n";
            for(int i = 0; i < getCasts().length; i++) {
                Artist artist = getCasts()[i];
                if(i != 0) {
                    artists += "\\";
                }
                artists += artist.getName();
            }
            artists += "\n";
        }
        return artists;
    }
}
