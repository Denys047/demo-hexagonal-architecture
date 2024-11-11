package org.commerce.catalogue.application.port.input;

import org.commerce.catalogue.application.port.data.ProductCategoryData;
import org.commerce.catalogue.application.port.data.id.ProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryInputPort {

    Optional<ProductCategoryData> findProductCategory(ProductCategoryId id);

}
