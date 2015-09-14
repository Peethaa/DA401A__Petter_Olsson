package com.example.petter.assignment_2;

/**
 * Created by Petter on 11-09-2015.
 */
public class Movie {

    public String title;
    public String year;
    public String plot;
    public int poster;
    public int fanart;

    public Movie(String title, String year, String plot, int poster, int fanart){
        this.title = title;
        this.year = year;
        this.plot = plot;
        this.poster = poster;
        this.fanart = fanart;
    }
}