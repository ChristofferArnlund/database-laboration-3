package dbtLab3.tables;

public class Reservation {
    private int reservation_nbr;
    private String username;
    private int show_nr;

    public int getReservation_nbr() {
        return reservation_nbr;
    }

    public void setReservation_nbr(int reservation_nbr) {
        this.reservation_nbr = reservation_nbr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getShow_nr() {
        return show_nr;
    }

    public void setShow_nr(int show_nr) {
        this.show_nr = show_nr;
    }

    public Reservation(int reservation_nbr, String username, int show_nr) {
        this.reservation_nbr = reservation_nbr;
        this.username = username;
        this.show_nr = show_nr;
    }
}
