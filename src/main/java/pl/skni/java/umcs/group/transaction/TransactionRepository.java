package pl.skni.java.umcs.group.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skni.java.umcs.group.transaction.model.Transaction;
import pl.skni.java.umcs.group.transaction.model.TransactionStatus;

import java.util.List;

interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findByOrderOrderId(Integer orderId);
    List<Transaction> findByStatus(TransactionStatus transactionStatus);
}
