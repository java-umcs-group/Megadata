package pl.skni.java.umcs.group.transaction.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.skni.java.umcs.group.order.model.Order;
import pl.skni.java.umcs.group.order.model.OrderStatus;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "M_Transaction")
public class Transaction {
    @Id
    @GeneratedValue
    Integer id;

    @OneToOne
    @JoinColumn(name = "orderId")
    Order order;

    @Column(scale = 2)
    BigDecimal costTotal;

    @Column
    TransactionStatus status;

    @Column
    PaymentType paymentType;

    public Transaction(Order order, PaymentType paymentType) {
        this.order = order;
        this.status = TransactionStatus.NEW;
        this.paymentType = paymentType;
        setCalculatedCostTotal();
    }

    public void pay() {
        status = TransactionStatus.CHARGED;
        order.changeStatus(OrderStatus.PAID);
    }

    private void setCalculatedCostTotal() {
        this.costTotal = order.getProducts().stream()
                .map(product -> product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
