package pl.skni.java.umcs.group.product.model;

import lombok.Getter;

import javax.persistence.*;

/**
 * Created by Tomasz Szerszeń on 01.04.16.
 */

@Entity
@Table(name = "M_Product_Type")
@Getter
public class ProductType {
    @Id
    @GeneratedValue
    @Column(name = "typeId")
    Integer id;

    @Column(name = "shortName")
    String shortName;

    @Column(name = "longName")
    String longName;

    public ProductType(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }

}
