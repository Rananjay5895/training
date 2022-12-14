package co.incubyte.co.incubyte;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
    private String name;
    private String image;
    private String date;
    private float rating;
    private int count;
    private String description;
    private String backgroundImage;
    private float popularity;
    private int id;
    private String language;

    public Movie(@JsonProperty("title") String name,@JsonProperty("poster_path") String image,@JsonProperty("release_date") String date,@JsonProperty("vote_average") float rating,@JsonProperty("vote_count") int count) {
        this.name = name;
        this.image = image;
        this.date = date;
        this.rating = rating;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDate() {
        return date;
    }

    public float getRating() {
        return rating;
    }

    public int getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public float getPopularity() {
        return popularity;
    }

    public int getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }
}
