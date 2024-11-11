package com.moviehouse.movieservice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    public Movie(long id, String original_title, String original_language, String overview, String release_date, String backdrop_path, long vote_count, float vote_average, boolean video, String title, String poster_path, long popularity, boolean adult, long[] genre_ids) {
        this.id = id;
        this.original_title = original_title;
        this.original_language = original_language;
        this.overview = overview;
        this.release_date = release_date;
        this.backdrop_path = backdrop_path;
        this.vote_count = vote_count;
        this.vote_average = vote_average;
        this.video = video;
        this.title = title;
        this.poster_path = poster_path;
        this.popularity = popularity;
        this.adult = adult;
        this.genre_ids = genre_ids;
    }
    public Movie(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String original_title;
    private String original_language;
    private String overview;
    private String release_date;
    private String backdrop_path;

    private long vote_count;
    private float vote_average;

    private boolean video;

    private String title;
    private String poster_path;

    private long popularity;

    private boolean adult;

    private long[] genre_ids;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public long getVote_count() {
        return vote_count;
    }

    public void setVote_count(long vote_count) {
        this.vote_count = vote_count;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public long getPopularity() {
        return popularity;
    }

    public void setPopularity(long popularity) {
        this.popularity = popularity;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public long[] getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(long[] genre_ids) {
        this.genre_ids = genre_ids;
    }
}
