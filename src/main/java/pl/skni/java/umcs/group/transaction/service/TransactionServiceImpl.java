package pl.skni.java.umcs.group.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.skni.java.umcs.group.order.model.Order;
import pl.skni.java.umcs.group.transaction.model.PaymentType;
import pl.skni.java.umcs.group.transaction.model.Transaction;
import pl.skni.java.umcs.group.transaction.model.TransactionStatus;
import pl.skni.java.umcs.group.transaction.respository.TransactionRepository;

import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction getByOrder(Order order) {
       return transactionRepository.findByOrder(order);
    }

    @Override
    public List<Transaction> getByStatus(TransactionStatus transactionStatus) {
//        return transactionRepository.findByTransactionStatus(transactionStatus);
    return  null;
    }

    @Override
    public Transaction createTransaction(Order order, PaymentType paymentType) {
        Transaction transaction = new Transaction(order,paymentType);
        return transactionRepository.save(transaction);
    }
}
