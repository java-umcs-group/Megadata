package pl.skni.java.umcs.group.order.service;

import pl.skni.java.umcs.group.order.model.Order;
import pl.skni.java.umcs.group.order.model.OrderStatus;
import pl.skni.java.umcs.group.product.model.Product;
import pl.skni.java.umcs.group.user.model.User;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Grzegorz on 2016-04-01.
 */
public interface OrderService {
    List<Order> findByStatus(OrderStatus orderStatus);
    List<Order> findByUserId(Integer userId);
    Order createOrder(List<Product> products, @Nullable User user, String firstName, String lastName, String address, String city, String zipCode, String email, String phoneNumber );
    Order findById(Integer id);
}
