package pl.skni.java.umcs.group.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Grzegorz on 2016-04-01.
 */
@Entity
public class OrderStatus {
    @Id
    @GeneratedValue
    private Integer statusId;
    private String status;

    public OrderStatus(String status) {
        this.status = status;
    }

    public OrderStatus() {
    }

    public String getStatus() {
        return status;
    }
}
