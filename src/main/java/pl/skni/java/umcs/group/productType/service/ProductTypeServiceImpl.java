package pl.skni.java.umcs.group.productType.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.skni.java.umcs.group.productType.model.ProductType;
import pl.skni.java.umcs.group.productType.repository.ProductTypeRepository;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    
    ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public ProductType findByShortName(String shortName) {
        return productTypeRepository.findByShortName(shortName);
    }

    @Override
    public ProductType findByLongName(String longName) {
        return productTypeRepository.findByLongName(longName);
    }

    @Override
    public ProductType findById(Integer productId) {
        return productTypeRepository.findOne(productId);
    }

    @Override
    public ProductType createProductType(String shortName, String longName) {
        ProductType productType = new ProductType(shortName,longName);
        return productTypeRepository.save(productType);
    }
}
