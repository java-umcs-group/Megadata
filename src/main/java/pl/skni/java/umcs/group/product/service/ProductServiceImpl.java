package pl.skni.java.umcs.group.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.skni.java.umcs.group.product.model.Product;
import pl.skni.java.umcs.group.productType.model.ProductType;
import pl.skni.java.umcs.group.product.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Tomasz Szerszeń on 01.04.16.
 */
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findByProductTypeId(Integer productTypeId) {
        return productRepository.findByProductTypeId(productTypeId);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByPriceBetween(BigDecimal min, BigDecimal max) {
        return productRepository.findByPriceBetween(min, max);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product createProduct(ProductType productType, String name, BigDecimal price, String specs) {
        Product product = new Product(productType,name,price,specs);
        return productRepository.save(product);
    }
}
