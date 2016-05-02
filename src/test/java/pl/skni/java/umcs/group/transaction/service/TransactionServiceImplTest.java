package pl.skni.java.umcs.group.transaction.service;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import pl.skni.java.umcs.group.ItTestHelper;
import pl.skni.java.umcs.group.transaction.model.Transaction;
import pl.skni.java.umcs.group.transaction.model.TransactionStatus;

import java.util.List;

public class TransactionServiceImplTest extends ItTestHelper {

    @Test
    public void shouldFindById() throws Exception {
        //given
        Transaction transactionFix = getTransaction();

        //when
        Transaction transactionServ = transactionService.findById(transactionFix.getId());

        //then
        Assert.assertEquals("transaction", transactionFix.getId(), transactionServ.getId());
    }

    @Test
    public void shouldFindByOrderId() throws Exception {
        //given
        Transaction transactionFix = getTransaction();

        //when
        Transaction transactionServ = transactionService.findByOrderId(transactionFix.getOrder().getOrderId());

        //then
        Assert.assertEquals("transaction", transactionFix.getOrder().getOrderId(), transactionServ.getOrder().getOrderId());

    }

    @Test
    @Ignore
    public void shouldFindByStatus() throws Exception {
        //given
        Transaction transaction1 = getTransaction();
        Transaction transaction2 = getTransaction();
        Transaction transaction3 = getTransaction();
        Transaction transaction4 = getTransaction();
        Transaction transaction5 = getTransaction();
        transaction3.pay();
        transaction4.pay();
        transaction5.pay();

        //when
        List<Transaction> transactionsNew = transactionService.findByStatus(TransactionStatus.NEW);
        List<Transaction> transactionsCharged = transactionService.findByStatus(TransactionStatus.CHARGED);

        //then
        Assert.assertEquals("size of charged",3 ,transactionsCharged.size());
        Assert.assertEquals("size of new",2 ,transactionsNew.size());
        transactionsNew.stream().forEach(
                transaction ->
                        Assert.assertEquals(TransactionStatus.NEW,transaction.getStatus()));
        transactionsCharged.stream().forEach(
                transaction ->
                        Assert.assertEquals(TransactionStatus.CHARGED,transaction.getStatus()));
    }

    @Test
    public void shouldCreateTransactionProperly() {
        //given
        Transaction transactionFix = getTransaction();

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
