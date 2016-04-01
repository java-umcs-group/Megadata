package pl.skni.java.umcs.group.product.model;

import lombok.Getter;

import javax.persistence.*;

/**
 * Created by Tomasz Szerszeń on 01.04.16.
 */

@Entity
@Table(name = "M_Warehouse")
@Getter
public class Warehouse {
    @Id
    @GeneratedValue
    @Column(name = "warehouseId")
    Integer id;

    @Column(name = "quantity")
    Integer quantity;

    @JoinColumn(name = "productId")
    @OneToOne
    Product product;

    public Warehouse(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
}
