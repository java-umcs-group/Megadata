package pl.skni.java.umcs.group.transaction.service;

import org.junit.Assert;
import org.junit.Test;
import pl.skni.java.umcs.group.ItTestHelper;
import pl.skni.java.umcs.group.transaction.model.Transaction;
import pl.skni.java.umcs.group.transaction.model.TransactionStatus;

import java.util.List;

public class TransactionServiceImplTest extends ItTestHelper {

    @Test
    public void shouldFindById() throws Exception {
        //given
        Transaction transactionFix = createTransaction();

        //when
        Transaction transactionServ = transactionService.findById(transactionFix.getId());

        //then
        Assert.assertEquals("transaction", transactionFix.getId(), transactionServ.getId());
    }

    @Test
    public void shouldFindByOrderId() throws Exception {
        //given
        Transaction transactionFix = createTransaction();

        //when
        Transaction transactionServ = transactionService.findByOrderId(transactionFix.getOrder().getOrderId());

        //then
        Assert.assertEquals("transaction", transactionFix.getOrder().getOrderId(), transactionServ.getOrder().getOrderId());

    }

    @Test
    public void shouldFindByStatus() throws Exception {
        //given
        Transaction transaction1 = createTransaction();
        Transaction transaction2 = createTransaction();
        Transaction transaction3 = createTransaction();
        Transaction transaction4 = createTransaction();
        Transaction transaction5 = createTransaction();

        transactionService.completeTransaction(transaction3.getId());
        transactionService.completeTransaction(transaction4.getId());
        transactionService.completeTransaction(transaction5.getId());

        //when
        List<Transaction> transactionsNew = transactionService.findByStatus(TransactionStatus.NEW);
        List<Transaction> transactionsCharged = transactionService.findByStatus(TransactionStatus.CHARGED);

        //then
        Assert.assertTrue("Expected >= 3, Actual:"+transactionsCharged.size(), 3 <= transactionsCharged.size());
        Assert.assertTrue("Expected >= 3, Actual:"+transactionsCharged.size(), 3 <= transactionsCharged.size());
        Assert.assertTrue("Expected >= 2, Actual:"+transactionsNew.size(), 2 <= transactionsNew.size());
        transactionsNew.stream().forEach(
                transaction ->
                        Assert.assertEquals(TransactionStatus.NEW, transaction.getStatus()));
        transactionsCharged.stream().forEach(
                transaction ->
                        Assert.assertEquals(TransactionStatus.CHARGED, transaction.getStatus()));
    }

    @Test
    public void shouldCreateTransactionProperly() {
        //given
        Transaction transactionFix = createTransaction();

        //when
        Transaction transactionServ = transactionService.createTransaction(
                transactionFix.getOrder(), transactionFix.getPaymentType()
        );

        //then
        Assert.assertEquals("order", transactionFix.getOrder(), transactionServ.getOrder());
        Assert.assertEquals("payment type", transactionFix.getPaymentType(), transactionServ.getPaymentType());
        Assert.assertEquals("cost", transactionFix.getCostTotal(), transactionServ.getCostTotal());
        Assert.assertEquals("status", transactionFix.getStatus(), transactionServ.getStatus());
        Assert.assertNotEquals("id", transactionFix.getId(), transactionServ.getId());

    }

}
