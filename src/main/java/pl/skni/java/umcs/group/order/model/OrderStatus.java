package pl.skni.java.umcs.group.order.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Grzegorz on 2016-04-01.
 */
@Entity
@Data
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
}
