package pl.skni.java.umcs.group.product.model;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import static pl.skni.java.umcs.group.helper.ValidationHelper.validateNotNullParams;

/**
 * Created by Tomasz Szerszeń on 01.04.16.
 */
@Entity
@Getter
@Table(name = "M_Product")
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "productId")
    Integer id;
    @Version
    Integer version;

    @JoinColumn(name = "typeId")
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.PERSIST})
    ProductType productType;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    BigDecimal price;

    @Column(name = "specs")
    String specs;
    @Setter
    @Column(name = "quantity")
    Integer quantity;

    @JoinColumn(name = "opinionId")
    @OneToMany(cascade = CascadeType.ALL)
    List<Opinion> opinions;

    public Product(ProductType productType, String name, BigDecimal price, String specs) {
        validateNotNullParams(productType, name, price, specs);
        this.productType = productType;
        this.name = name;
        this.price = price;
        this.specs = specs;
    }

    public void addOpinion(Opinion opinion) {
        validateNotNullParams(opinion);
        if (opinions != null) {
            opinions.add(opinion);
        } else {
            opinions = Lists.newArrayList(opinion);
        }
    }

}
