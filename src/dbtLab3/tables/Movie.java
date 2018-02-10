package dbtLab3.tables;

public class Movie {

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    private String movie_name;

    public Movie (String movie_name){


        this.movie_name = movie_name;
    }
}
