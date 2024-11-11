package org.commerce.catalogue.application.port.input.usecase;

import org.commerce.catalogue.application.port.data.ProductCategoryData;
import org.commerce.catalogue.application.port.data.id.ProductCategoryId;
import org.commerce.catalogue.application.port.input.FindProductCategoryInputPort;
import org.commerce.catalogue.application.port.output.FindProductCategoryByIdOutputPort;

import java.util.Optional;

public class FindProductCategoryUseCase implements FindProductCategoryInputPort {

    private final FindProductCategoryByIdOutputPort findProductCategoryByIdOutputPort;

    public FindProductCategoryUseCase(FindProductCategoryByIdOutputPort findProductCategoryByIdOutputPort) {
        this.findProductCategoryByIdOutputPort = findProductCategoryByIdOutputPort;
    }

    @Override
    public Optional<ProductCategoryData> findProductCategory(ProductCategoryId id) {
        return findProductCategoryByIdOutputPort.findProductCategoryById(id);
    }

}
