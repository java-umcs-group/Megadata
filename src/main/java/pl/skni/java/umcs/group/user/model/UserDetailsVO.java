package pl.skni.java.umcs.group.user.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Jakub Pyda on 01.04.2016.
 */
@Embeddable
@Getter
public class UserDetailsVO {

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "city")
    private String city;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "zipCode")
    private String zipCode;
    @Column(name = "phoneNumber")
    private String phoneNumber;

    public UserDetailsVO(String firstName, String lastName, String city, String email, String address, String zipCode, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.email = email;
        this.address = address;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }
}
