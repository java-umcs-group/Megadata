package pl.skni.java.umcs.group.productType.service;

import pl.skni.java.umcs.group.productType.model.ProductType;

public interface ProductTypeService {
    ProductType findByShortName(String shortName);
    ProductType findByLongName(String longName);
    ProductType findById(Integer productId);
    ProductType createProductType(String shortName, String longName);
}
