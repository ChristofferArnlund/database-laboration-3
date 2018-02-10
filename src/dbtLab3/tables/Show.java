package dbtLab3.tables;

public class Show {

    public int getShow_nr() {
        return show_nr;
    }

    public void setShow_nr(int show_nr) {
        this.show_nr = show_nr;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getTheater_name() {
        return theater_name;
    }

    public void setTheater_name(String theater_name) {
        this.theater_name = theater_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFree_seats() {
        return free_seats;
    }

    public void setFree_seats(int free_seats) {
        this.free_seats = free_seats;
    }

    private int show_nr;
    private String movie_name;
    private String theater_name;
    private String date;
    private int free_seats;

    public Show(int show_nr, String movie_name, String theater_name, String date, int free_seats) {
        this.show_nr = show_nr;
        this.movie_name = movie_name;
        this.theater_name = theater_name;
        this.date = date;
        this.free_seats = free_seats;
    }
}
