package pl.skni.java.umcs.group.product.model;

import lombok.Getter;

import javax.persistence.*;

/**
 * Created by Tomasz Szerszeń on 01.04.16.
 */

@Entity
@Table(name = "M_Opinion")
@Getter
public class Opinion {
    @Id
    @GeneratedValue
    @Column(name = "opinionId")
    Integer id;

    @Column(name = "opinion")
    String opinion;

    @Column(name = "rate")
    Integer rate;

    @JoinColumn(name = "productId")
    @ManyToOne
    Product product;

    public Opinion(String opinion, Integer rate, Product product) {
        this.opinion = opinion;
        this.rate = rate;
        this.product = product;
    }

}
