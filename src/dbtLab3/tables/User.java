package dbtLab3.tables;

public class User {
    private String username;
    private String telephone;
    private String fullname;

    private Address adress;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    public User(String username, String telephone, String fullname) {

        this.username = username;
        this.telephone = telephone;
        this.fullname = fullname;

    }



}
