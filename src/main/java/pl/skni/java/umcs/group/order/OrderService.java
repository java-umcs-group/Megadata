package pl.skni.java.umcs.group.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.skni.java.umcs.group.order.model.Order;
import pl.skni.java.umcs.group.order.model.OrderStatus;
import pl.skni.java.umcs.group.product.model.Product;
import pl.skni.java.umcs.group.user.model.User;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Grzegorz on 2016-04-01.
 */
@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findByStatus(OrderStatus orderStatus) {
        return orderRepository.findByStatus(orderStatus);
    }

    public Order createOrder(List<Product> products, @Nullable User user, String firstName, String lastName, String address, String city, String zipCode, String email, String phoneNumber) {

        Order order = new Order(products, user, firstName, lastName, address, city,
                zipCode, email, phoneNumber);
        return orderRepository.save(order);
    }

    public Order findById(Integer id) {
        return orderRepository.findOne(id);
    }

    public List<Order> findByUserId(Integer userId) {
        return orderRepository.findByUserUserId(userId);
    }
}
