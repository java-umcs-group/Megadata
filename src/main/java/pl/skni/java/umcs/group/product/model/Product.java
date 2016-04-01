package pl.skni.java.umcs.group.product.model;

import lombok.Getter;
import org.crsh.cli.Man;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Tomasz Szerszeń on 01.04.16.
 */
@Entity
@Table(name = "M_Product")
@Getter
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "productId")
    Integer id;

    @JoinColumn(name = "typeId")
    @ManyToOne
    @Column(name = "type")
    Integer type;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "specs")
    String specs;

    @JoinColumn(name = "opinionId")
    @OneToMany
    List<Opinion> opinions;

    public Product(Integer type, String name, BigDecimal price, String specs, List<Opinion> opinions) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.specs = specs;
        this.opinions = opinions;
    }

}
