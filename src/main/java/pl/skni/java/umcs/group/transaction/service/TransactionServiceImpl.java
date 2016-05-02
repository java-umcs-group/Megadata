package pl.skni.java.umcs.group.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.skni.java.umcs.group.order.model.Order;
import pl.skni.java.umcs.group.order.repository.OrderRepository;
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
    public Transaction findById(Integer transactionId) {
        return transactionRepository.findOne(transactionId);
    }

    @Override
    public Transaction findByOrderId(Integer orderId) {
        return transactionRepository.findByOrderOrderId(orderId);
    }

    @Override
    public List<Transaction> findByStatus(TransactionStatus transactionStatus) {
        return transactionRepository.findByStatus(transactionStatus);
    }

    @Override
    public Transaction createTransaction(Order order, PaymentType paymentType) {
        Transaction transaction = new Transaction(order, paymentType);
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction completeTransaction(Integer id) {
        Transaction one = transactionRepository.getOne(id);
        one.pay();
        return transactionRepository.save(one);
    }
}
