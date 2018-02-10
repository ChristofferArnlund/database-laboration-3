package dbtLab3.tables;

public class Address {
    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Address(String username, String address) {

        this.username = username;
        this.address = address;
    }
}
