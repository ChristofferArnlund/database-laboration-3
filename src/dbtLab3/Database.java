package dbtLab3;

import dbtLab3.tables.*;

import java.sql.*;
import java.util.*;

/**
 * Database is an interface to the college application database, it
 * uses JDBC to connect to a SQLite3 file.
 */
public class Database {

    /**
     * The database connection.
     */
    private Connection conn;

    /**
     * Creates the database interface object. Connection to the
     * database is performed later.
     */
    public Database() {
        conn = null;
    }

    /**
     * Opens a connection to the database, using the specified
     * filename (if we'd used a traditional DBMS, such as PostgreSQL
     * or MariaDB, we would have specified username and password
     * instead).
     */
    public boolean openConnection(String filename) {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + filename);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Closes the connection to the database.
     */
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if the connection to the database has been established
     * 
     * @return true if the connection has been established
     */
    public boolean isConnected() {
        return conn != null;
    }



    public List<Movie> getMovies() {
        List<Movie> movies = new LinkedList<>();
        String query =
            "SELECT  *" +
            "FROM    movies";
        try (PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getString(("movie_name"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public List<Theater> getTheaters() {
        List<Theater> theaters = new LinkedList<>();
        String query =
                        "SELECT  *" +
                        "FROM    theaters";

        try (PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                theaters.add(new Theater(rs.getString("theater_name"),Integer.parseInt(rs.getString("seats"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theaters;
    }
    public List<Address> getAddresses() {
        List<Address> addresses = new LinkedList<>();
        String query =
                        "SELECT  *" +
                        "FROM    addresses";

        try (PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                addresses.add(new Address(rs.getString("username"),(rs.getString("address"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }
    public List<User> getUsers() {
        List<User> users = new LinkedList<>();
        String query =
                        "SELECT  *" +
                        "FROM    users "+
                        "JOIN addresses ON users.username=addresses.username";

        try (PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getString("username"),(rs.getString("telephone")),rs.getString("fullname"));
                users.add(u);
                if(rs.getString("address")!=null){
                    Address a = new Address(rs.getString("username"),rs.getString("address"));
                    u.setAdress(a);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public List<Reservation> getReservations() {
        List<Reservation> reservations = new LinkedList<>();
        String query =
                        "SELECT  *" +
                        "FROM    reservations";

        try (PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                reservations.add(new Reservation(Integer.parseInt(rs.getString("reservation_nbr")),rs.getString("username"),Integer.parseInt(rs.getString("show_nr"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

/* -TODO -----------------------   IMPLEMENT SEMAPHORE & CHECK FUNCTIONALITY -----------------*/
    public void makeReservations(String username, Integer show_nr) throws SQLException {

        //Update free seats in show
        String updateQuery =
                        "UPDATE shows " +
                        "SET free_seats = free_seats - 1 " +
                        "WHERE show_nr = " + show_nr;

        try (PreparedStatement ps = conn.prepareStatement(updateQuery)) {

            ps.execute();
            //System.out.println(rs.getString(""));

        } catch (SQLException e) {
            throw new SQLException("Show fully booked, sorry!");
        }

        String insertQuery =
                "INSERT "
                + "INTO   reservations (username, show_nr) "
                + "VALUES"
                + "('" + username + "',"  + show_nr + ")";

        try (PreparedStatement ps = conn.prepareStatement(insertQuery)) {

            ps.execute();
            //System.out.println(rs.getString(""));

        } catch (SQLException e) {
            throw new SQLException("Show fully booked, sorry!2");
        }

    }

    public List<Show> getShows() {
        List<Show> shows = new LinkedList<>();
        String query =
                        "SELECT  * " +
                        "FROM    shows";

        try (PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                shows.add(new Show(Integer.parseInt(rs.getString("show_nr")),rs.getString("movie_name"),rs.getString("theater_name"),rs.getString("date"),Integer.parseInt(rs.getString("free_seats"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shows;
    }

}
