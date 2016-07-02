package pl.skni.java.umcs.group;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.skni.java.umcs.group.order.OrderService;
import pl.skni.java.umcs.group.product.ProductService;
import pl.skni.java.umcs.group.productType.ProductTypeService;
import pl.skni.java.umcs.group.user.UserService;
import pl.skni.java.umcs.group.order.model.Order;
import pl.skni.java.umcs.group.product.model.Product;
import pl.skni.java.umcs.group.productType.model.ProductType;
import pl.skni.java.umcs.group.shipment.model.Shipment;
import pl.skni.java.umcs.group.shipment.model.ShipmentStatus;
import pl.skni.java.umcs.group.shipment.model.ShipmentType;
import pl.skni.java.umcs.group.shipment.ShipmentService;
import pl.skni.java.umcs.group.transaction.model.PaymentType;
import pl.skni.java.umcs.group.transaction.model.Transaction;
import pl.skni.java.umcs.group.transaction.TransactionService;
import pl.skni.java.umcs.group.user.model.Authority;
import pl.skni.java.umcs.group.user.model.Role;
import pl.skni.java.umcs.group.user.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@EntityScan(basePackages = {"pl.skni.java.umcs.group"})
@ContextConfiguration(locations = "classpath*:META-INF/spring/springTestConfig.xml")
public class ItTestHelper {

    @Autowired
    protected ShipmentService shipmentService;

    @Autowired
    protected ProductTypeService productTypeService;

    @Autowired
    protected UserService userService;

    @Autowired
    protected ProductService productService;

    @Autowired
    protected OrderService orderService;

    @Autowired
    protected TransactionService transactionService;

    @Test
    public void contextLoads() {
    }

    private final String USER_NAME = "john123";
    private final String PASSWORD = "securepass";
    private final String FIRST_NAME = "john";
    private final String LAST_NAME = "kowalski";
    private final String EMAIL = "johnK@mail.com";
    private final String ADDRESS = "WA Street";
    private final String PHONE_NUMBER = "123456789024";
    private final String ZIP_CODE = "342-2345";
    private final String CITY = "NY";

    protected User createUser() {
        return userService.createUser(
                USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME,
                EMAIL, ADDRESS, PHONE_NUMBER, ZIP_CODE, CITY
        );
    }

    protected Order createOrder() {
        return orderService.createOrder(
                createProducts(), createUser(), FIRST_NAME, LAST_NAME,
                ADDRESS, CITY, ZIP_CODE, EMAIL, PHONE_NUMBER
        );
    }

    protected Transaction createTransaction() {
        return transactionService.createTransaction(createOrder(), PaymentType.CASH);
    }

    protected List<Product> createProducts() {
        List<Product> products = new ArrayList<>();
        Product product1 = productService.createProduct(
                createProductType(), "SuperBall",
                BigDecimal.TEN, "round, super"
        );
        Product product2 = productService.createProduct(
                createProductType(), "smallBall",
                BigDecimal.ONE, "small, super"
        );
        product1.setQuantity(2);
        product2.setQuantity(5);
        products.add(product1);
        products.add(product2);
        return products;
    }

    protected ProductType createProductType() {
        return productTypeService.createProductType("b", "ball");
    }

    protected Shipment createShipment() {
        return shipmentService.createShipment(createOrder(), ShipmentStatus.PENDING, ShipmentType.EXPRESS);
    }
}
