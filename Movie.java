package CLASSWORK27;

import java.util.Arrays;

public class Movie implements Comparable<Movie>{
    private String name;
    private int year;
    private String description;
    private Director director;
    private Cast[] cast;


    public Movie(String name, int year, String description, Director director, Cast[] cast) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.director = director;
        this.cast = cast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Cast[] getCast() {
        return cast;
    }

    public void setCast(Cast[] cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", director=" + director +
                ", cast=" + Arrays.toString(cast) +
                '}';
    }

    @Override
    public int compareTo(Movie o) {
            return this.getDirector().getFullName().compareTo(o.getDirector().getFullName());

        }
    }

