package by.hvalinskii.controller;

public class User {
    private long user_id;
    private String login;
    private String password;
    private String role;

    public User() {
    }

    public User(long user_id, String login, String password, String role) {
        this.user_id = user_id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
