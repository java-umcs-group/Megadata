package pl.skni.java.umcs.group.order.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Grzegorz on 2016-04-01.
 */
@Entity
@Data
public class Order {
    @Id
    @GeneratedValue
    private Integer orderId;//pk

    @OneToMany
    @JoinColumn(name = "productId")
    private Integer productId;//fk

    @ManyToOne
    @JoinColumn(name = "userId")
    private Integer userId;//fk

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zipCode;
    private String email;
    private String phone;

    @OneToOne
    @JoinColumn(name = "statusId")
    private Integer status;//fk

    public Order(Integer productId, Integer userId, String firstName, String lastName, String address, String city, String zipCode, String email, String phone, Integer status) {
        this.productId = productId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public Order() {
    }
}
