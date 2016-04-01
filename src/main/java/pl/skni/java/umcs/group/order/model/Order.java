package pl.skni.java.umcs.group.order.model;

import lombok.Data;
import pl.skni.java.umcs.group.product.model.Product;
import pl.skni.java.umcs.group.user.model.User;

import javax.persistence.*;

/**
 * Created by Grzegorz on 2016-04-01.
 */
@Entity
@Data
public class Order {

    @Id
    @GeneratedValue
    private Integer orderId;

    @OneToMany
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Embedded
    private OrderDetails orderDetails;

    @OneToOne
    @JoinColumn(name = "statusId")
    private OrderStatus status;


}
