package com.aluracursos.consultarpeliculasstarwars.modelo;

import java.util.List;

public class Pelicula {
    private String title;
    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    private List<String> characters;

    public String getTitle() {
        return title;
    }

    public int getEpisode_id() {
        return episode_id;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public List<String> getCharacters() {
        return characters;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "title='" + title +
                ", episode_id=" + episode_id +
                ", opening_crawl='" + opening_crawl +
                ", director='" + director +
                ", producer='" + producer +
                ", release_date='" + release_date + "\n";
    }
}
