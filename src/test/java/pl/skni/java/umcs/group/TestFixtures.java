package pl.skni.java.umcs.group;

import pl.skni.java.umcs.group.order.model.Order;
import pl.skni.java.umcs.group.product.model.Product;
import pl.skni.java.umcs.group.product.model.ProductType;
import pl.skni.java.umcs.group.transaction.model.PaymentType;
import pl.skni.java.umcs.group.transaction.model.Transaction;
import pl.skni.java.umcs.group.user.model.Authority;
import pl.skni.java.umcs.group.user.model.Role;
import pl.skni.java.umcs.group.user.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestFixtures {

    public static final String NAME = "john123";
    public static final String PASS = "securepass";
    public static final Authority AUTHORITY = new Authority(Role.ROLE_USER);
    public static final String FIRST_NAME = "john";
    public static final String LAST_NAME = "kowalski";
    public static final String EMAIL = "johnK@mail.com";
    public static final String ADDRESS = "WA Street";
    public static final String NUMBER = "123456789024";
    public static final String ZIP_CODE = "342-2345";
    public static final String CITY = "NY";

    public  static User getUser() {
        return new User(
                NAME, PASS, AUTHORITY, FIRST_NAME, LAST_NAME,
                EMAIL, ADDRESS, NUMBER, ZIP_CODE, CITY
        );
    }

    public static Order getOrder() {
        return new Order(getProducts(), getUser(), FIRST_NAME, LAST_NAME,
                ADDRESS, CITY, ZIP_CODE, EMAIL, NUMBER
        );
    }

    public static Transaction getTransaction() {
        return  new Transaction(getOrder(), PaymentType.CASH);
    }

    public  static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product(
                new ProductType("b", "ball"), "SuperBall",
                BigDecimal.TEN, "round, super");
        Product product2 =  new Product(
                new ProductType("s", "stick"), "SuperStick",
                BigDecimal.ONE, "straight, super");
        product1.setQuantity(2);
        product2.setQuantity(5);
        products.add(product1);
        products.add(product2);
        return products;
    }
}
