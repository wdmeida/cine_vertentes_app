package activities.cineplaza.ifsudestemg.br.cineplazaapp.model;

import android.util.Log;

/**
 * Created by wagner on 05/09/16.
 */
public class Movie {
    private Long id;
    private String name;
    private String cover;
    private String trailer;
    private String genre;
    private String duration;
    private String classification;
    private String exibition;
    private String week;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getExibition() {
        return exibition;
    }

    public void setExibition(String exibition) {
        this.exibition = exibition;
    }
}
