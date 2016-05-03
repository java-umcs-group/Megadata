package pl.skni.java.umcs.group.transaction.model;

import org.junit.Assert;
import org.junit.Test;
import pl.skni.java.umcs.group.ItTestHelper;

import java.math.BigDecimal;

public class TransactionTest extends ItTestHelper {

    /**
     * Ten test jest zalezny od metody
     * {@link #createProducts()}
     */
    @Test
    public void shouldCalculateCostTotal() throws Exception {
        //given
        BigDecimal expected = BigDecimal.valueOf(2.0 * 10 + 5 * 1).setScale(2, BigDecimal.ROUND_HALF_UP);
        Transaction transaction = createTransaction();

        //when
        BigDecimal actual = transaction.getCostTotal();

        //then
        Assert.assertEquals("costTotal", expected, actual);

    }
}
