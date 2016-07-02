package pl.skni.java.umcs.group.productType;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skni.java.umcs.group.productType.model.ProductType;

interface ProductTypeRepository  extends JpaRepository<ProductType, Integer> {
    ProductType findByShortName(String shortName);
    ProductType findByLongName(String longName);
}
