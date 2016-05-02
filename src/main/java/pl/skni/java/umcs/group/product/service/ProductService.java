package pl.skni.java.umcs.group.product.service;

import pl.skni.java.umcs.group.product.model.Product;
import pl.skni.java.umcs.group.productType.model.ProductType;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Tomasz Szerszeń on 01.04.16.
 */
public interface ProductService {
    List<Product> findByProductTypeId(Integer productTypeId);
    List<Product> findByName(String name);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
    Product findById(Integer id);
    Product createProduct(ProductType productType, String name, BigDecimal price, String specs);
}
