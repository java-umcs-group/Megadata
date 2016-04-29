package pl.skni.java.umcs.group.transaction.service;

import org.springframework.stereotype.Service;
import pl.skni.java.umcs.group.order.model.Order;
import pl.skni.java.umcs.group.transaction.model.PaymentType;
import pl.skni.java.umcs.group.transaction.model.Transaction;
import pl.skni.java.umcs.group.transaction.model.TransactionStatus;

import java.util.List;

@Service
public interface TransactionService  {
    Transaction getByOrder(Order order);
    List<Transaction> getByStatus(TransactionStatus transactionStatus);
    Transaction createTransaction(Order order, PaymentType paymentType);
}
