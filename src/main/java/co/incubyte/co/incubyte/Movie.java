package co.incubyte.co.incubyte;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
    private String name;
    private String image;
    private String date;
    private float rating;
    private int count;

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
}
