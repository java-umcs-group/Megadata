package pl.skni.java.umcs.group.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.skni.java.umcs.group.order.model.Order;
import pl.skni.java.umcs.group.transaction.model.PaymentType;
import pl.skni.java.umcs.group.transaction.model.Transaction;
import pl.skni.java.umcs.group.transaction.model.TransactionStatus;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction findById(Integer transactionId) {
        return transactionRepository.findOne(transactionId);
    }

    public Transaction findByOrderId(Integer orderId) {
        return transactionRepository.findByOrderOrderId(orderId);
    }

    public List<Transaction> findByStatus(TransactionStatus transactionStatus) {
        return transactionRepository.findByStatus(transactionStatus);
    }

    public Transaction createTransaction(Order order, PaymentType paymentType) {
        Transaction transaction = new Transaction(order, paymentType);
        return transactionRepository.save(transaction);
    }

    public Transaction completeTransaction(Integer id) {
        Transaction one = transactionRepository.getOne(id);
        one.pay();
        return transactionRepository.save(one);
    }
}
