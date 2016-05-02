package pl.skni.java.umcs.group.order.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.skni.java.umcs.group.product.model.Product;
import pl.skni.java.umcs.group.user.model.User;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Grzegorz on 2016-04-01.
 */
@Entity
@Getter
@Table(name = "L_Order")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private Integer orderId;

    @ManyToMany
    @JoinTable(name = "M_L_Order_Product")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "userId")
    @Nullable
    private User user;

    @Embedded
    private OrderDeliveryDetailsVO orderDetails;

    @Column
    private OrderStatus status;


    public Order(List<Product> products, @Nullable User user, String firstName, String lastName, String address, String city, String zipCode, String email, String phoneNumber ) {
        this.products = products;
        this.user = user;
        this.status = OrderStatus.NEW;
        this.orderDetails = new OrderDeliveryDetailsVO(firstName, lastName, address, city, zipCode, email, phoneNumber);
    }

    public void changeStatus(OrderStatus orderStatus) {
        //todo status validation
        this.status = orderStatus;
    }

}
