package pl.skni.java.umcs.group.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skni.java.umcs.group.product.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    List<Product> findByProductTypeId(Integer productTypeId);
    List<Product> findByName(String name);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

}
