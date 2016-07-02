package pl.skni.java.umcs.group.order;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skni.java.umcs.group.order.model.Order;
import pl.skni.java.umcs.group.order.model.OrderStatus;

import java.util.List;

/**
 * Created by jakub on 02.07.16.
 */
interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByStatus(OrderStatus orderStatus);

    List<Order> findByUserUserId(Integer userId);
}
