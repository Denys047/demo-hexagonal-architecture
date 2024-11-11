package org.commerce.catalogue.application.port.output;

import org.commerce.catalogue.application.port.data.ProductCategoryData;
import org.commerce.catalogue.application.port.data.id.ProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryByIdOutputPort {

    Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId productCategoryId);

}
