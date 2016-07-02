package pl.skni.java.umcs.group.productType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.skni.java.umcs.group.productType.model.ProductType;

@Service
public class ProductTypeService {
    
    private ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    public ProductType findByShortName(String shortName) {
        return productTypeRepository.findByShortName(shortName);
    }

    public ProductType findByLongName(String longName) {
        return productTypeRepository.findByLongName(longName);
    }

    public ProductType findById(Integer productId) {
        return productTypeRepository.findOne(productId);
    }

    public ProductType createProductType(String shortName, String longName) {
        ProductType productType = new ProductType(shortName,longName);
        return productTypeRepository.save(productType);
    }
}
