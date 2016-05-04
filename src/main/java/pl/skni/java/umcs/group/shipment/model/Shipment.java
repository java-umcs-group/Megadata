package pl.skni.java.umcs.group.shipment.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.skni.java.umcs.group.order.model.Order;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
@Table(name = "M_Shipment")
public class Shipment {
    @Id
    @GeneratedValue
    Integer id;

    @OneToOne
    @JoinColumn(name = "orderId")
    Order order;

    @Setter
    @Column
    ShipmentStatus status;

    @Setter
    @Column
    ShipmentType type;

    public Shipment(Order order, ShipmentStatus status, ShipmentType type) {
        this.order = order;
        this.status = status;
        this.type = type;
    }

}
