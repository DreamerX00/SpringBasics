package com.springBoot.Practice.Entity;

public class MusicLibrary {
    private int id;
    private String name;
    private String Artist;
    private Genre genre;
    private String duration;

    public MusicLibrary(int id, String name, String artist, Genre genre, String duration) {
        this.id = id;
        this.name = name;
        Artist = artist;
        this.genre = genre;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}

