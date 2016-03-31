package pl.skni.java.umcs.group.user.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Jakub Pyda on 31.03.2016.
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    Integer Id;

    String firstName;
    String lastName;
    String email;
    String password;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User() {
    }
}
