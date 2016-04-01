package pl.skni.java.umcs.group.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Grzegorz on 2016-04-01.
 */
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Integer orderId;

    private Integer productId;

    private Integer userId;

    private Integer status;
}
