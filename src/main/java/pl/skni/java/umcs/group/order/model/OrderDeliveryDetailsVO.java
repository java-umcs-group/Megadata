package pl.skni.java.umcs.group.order.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Jakub Pyda on 01.04.2016.
 */
@Embeddable
@Getter
@NoArgsConstructor
public class OrderDeliveryDetailsVO {

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

    public OrderDeliveryDetailsVO(String firstName, String lastName, String address, String city, String zipCode, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
