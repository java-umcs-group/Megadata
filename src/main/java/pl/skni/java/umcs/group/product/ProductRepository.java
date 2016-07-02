package pl.skni.java.umcs.group.product;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skni.java.umcs.group.product.model.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by jakub on 02.07.16.
 */
interface ProductRepository extends JpaRepository<Product, Integer>{
    List<Product> findByProductTypeId(Integer productTypeId);

    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    List<Product> findByName(String name);
}
