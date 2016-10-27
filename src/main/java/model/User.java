package model;

import javax.persistence.*;

/**
 * Created by slava23 on 10/11/2016.
 */
@Entity
public class User {

    @Id
    private int id;

    private String role;

    private String login;

    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
