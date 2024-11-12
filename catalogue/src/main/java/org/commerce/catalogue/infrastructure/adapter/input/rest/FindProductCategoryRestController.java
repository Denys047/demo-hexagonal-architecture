package org.commerce.catalogue.infrastructure.adapter.input.rest;


import lombok.RequiredArgsConstructor;
import org.commerce.catalogue.application.port.data.id.ProductCategoryId;
import org.commerce.catalogue.application.port.input.FindProductCategoryInputPort;
import org.commerce.catalogue.infrastructure.adapter.presentation.ProductCategoryPresentationV1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/catalogue/product-categories")
public class FindProductCategoryRestController {

    private final FindProductCategoryInputPort findProductCategoryInputPort;

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryPresentationV1> findProductCategory(@PathVariable("id") long id) {
        return findProductCategoryInputPort.findProductCategory(new ProductCategoryId(id))
                .map(category -> ResponseEntity.ok(
                        new ProductCategoryPresentationV1(
                                category.id().value(),
                                category.title(),
                                category.details(),
                                category.parent() != null ? category.parent().value() : null,
                                category.version()
                        )
                )).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
