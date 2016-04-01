package pl.skni.java.umcs.group.order.model;

import lombok.Getter;
import pl.skni.java.umcs.group.product.model.Product;
import pl.skni.java.umcs.group.user.model.User;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Grzegorz on 2016-04-01.
 */
@Entity
@Getter
public class Order {

    @Id
    @GeneratedValue
    private Integer orderId;

    @ManyToMany
    @JoinTable(name = "M_L_Order_Product")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Embedded
    private OrderDeliveryDetails orderDetails;

    @Column
    private OrderStatus status;


    public Order(List<Product> products, User user,String firstName, String lastName, String address, String city, String zipCode, String email, String phoneNumber ) {
        this.products = products;
        this.user = user;
        this.status = OrderStatus.NEW;
        this.orderDetails = new OrderDeliveryDetails(firstName, lastName, address, city, zipCode, email, phoneNumber);
    }

    public void changeStatus(OrderStatus orderStatus) {
        //todo status validation
        this.status = orderStatus;
    }

}
