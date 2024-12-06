package com.sakila.entity;

public class Film {
    private int filmId;
    private String title;
    private String description;

    // Constructor con los parámetros correctos
    public Film(int filmId, String title, String description) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
    }

    // Getters y Setters (si no los tienes)
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

