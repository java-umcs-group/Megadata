package pl.skni.java.umcs.group.productType.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static pl.skni.java.umcs.group.helper.ValidationHelper.validateNotNullParams;

/**
 * Created by Tomasz Szerszeń on 01.04.16.
 */

@Entity
@Getter
@NoArgsConstructor
@Table(name = "M_ProductType")
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
        validateNotNullParams(shortName, longName);
        this.shortName = shortName;
        this.longName = longName;
    }

}
