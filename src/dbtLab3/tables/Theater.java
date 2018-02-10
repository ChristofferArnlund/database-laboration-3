package dbtLab3.tables;

public class Theater {
    public String theather_name;

    public String getTheather_name() {
        return theather_name;
    }

    public void setTheather_name(String theather_name) {
        this.theather_name = theather_name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int seats;

    public Theater(String theater_name, Integer seats) {
        this.theather_name=theater_name;
        this.seats=seats;
    }

}
