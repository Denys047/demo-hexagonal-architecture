package org.commerce.catalogue.application.port.output.usecase;

import org.commerce.catalogue.application.port.data.ProductCategoryData;
import org.commerce.catalogue.application.port.data.id.ProductCategoryId;
import org.commerce.catalogue.application.port.output.FindProductCategoryByIdOutputPort;

import java.util.Optional;

public class FindProductCategoryByIdUsecase implements FindProductCategoryByIdOutputPort {

    @Override
    public Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId productCategoryId) {
        return Optional.empty();
    }

}
