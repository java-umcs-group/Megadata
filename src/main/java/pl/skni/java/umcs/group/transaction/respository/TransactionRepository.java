package pl.skni.java.umcs.group.transaction.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skni.java.umcs.group.order.model.Order;
import pl.skni.java.umcs.group.transaction.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findByOrder(Order order);
//    List<Transaction> findByTransactionStatus(TransactionStatus transactionStatus);
}
