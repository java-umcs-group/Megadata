package pl.skni.java.umcs.group.transaction.service;

import pl.skni.java.umcs.group.order.model.Order;
import pl.skni.java.umcs.group.transaction.model.PaymentType;
import pl.skni.java.umcs.group.transaction.model.Transaction;
import pl.skni.java.umcs.group.transaction.model.TransactionStatus;

import java.util.List;


public interface TransactionService  {
    Transaction findById(Integer transactionId);
    Transaction findByOrderId(Integer orderId);
    List<Transaction> findByStatus(TransactionStatus transactionStatus);
    Transaction createTransaction(Order order, PaymentType paymentType);
}
