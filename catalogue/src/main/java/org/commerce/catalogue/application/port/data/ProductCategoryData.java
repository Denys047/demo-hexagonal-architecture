package org.commerce.catalogue.application.port.data;

import org.commerce.catalogue.application.port.data.id.ProductCategoryId;

public record ProductCategoryData(ProductCategoryId id, String title, String details, ProductCategoryId parent,
                                  int version) {

}
