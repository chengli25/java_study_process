package com.users;

/**
 * @author: Zero
 * @Date: 2021/3/14 - 18:05
 * @since: jdk 1.8
 */
public class User {
    private String username;
    private String password;
    private String email;

    public User(String username, String password, String eamil) {
        this.username = username;
        this.password = password;
        this.email = eamil;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String eamil) {
        this.email = eamil;
    }

    public User(){
        super();
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
