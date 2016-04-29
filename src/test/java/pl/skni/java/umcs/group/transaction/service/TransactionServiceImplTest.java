package pl.skni.java.umcs.group.transaction.service;

import org.junit.Assert;
import org.junit.Test;
import pl.skni.java.umcs.group.ItTestHelper;
import pl.skni.java.umcs.group.TestFixtures;
import pl.skni.java.umcs.group.transaction.model.Transaction;

public class TransactionServiceImplTest extends ItTestHelper {

    @Test
    public void getByOrder() throws Exception {

    }

    @Test
    public void getByStatus() throws Exception {

    }

    @Test
    public void createTransaction() throws Exception {
        //given
        Transaction transactionFix = TestFixtures.getTransaction();
        //when
        Transaction  transactionServ = transactionService.createTransaction(
                transactionFix.getOrder(),transactionFix.getPaymentType()
        );
        //then
        Assert.assertEquals("order", transactionFix.getOrder(),transactionServ.getOrder());
        Assert.assertEquals("payment type", transactionFix.getPaymentType(),transactionServ.getPaymentType());
        Assert.assertEquals("cost", transactionFix.getCostTotal(),transactionServ.getCostTotal());
        Assert.assertEquals("status", transactionFix.getStatus(),transactionServ.getStatus());
        Assert.assertNotEquals("id", transactionFix.getId(),transactionServ.getId());

    }

}
