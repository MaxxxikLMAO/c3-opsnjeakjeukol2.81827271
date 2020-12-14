package cz.educanet.mavenz;

public class User {

    private String username;
    private String password;
    private String firstName;
    private String surname;
    private String email;

    public User(String username, String password, String firstName, String surname, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String renameUser(String newUsername) {
        return username = newUsername;
    }


}
