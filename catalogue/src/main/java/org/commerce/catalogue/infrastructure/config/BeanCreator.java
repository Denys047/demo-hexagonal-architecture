package org.commerce.catalogue.infrastructure.config;

import org.commerce.catalogue.application.port.input.usecase.FindProductCategoryUseCase;
import org.commerce.catalogue.infrastructure.adapter.output.jdbc.MappingSqlQueryFindProductCategoryById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class BeanCreator {

    @Bean
    public FindProductCategoryUseCase findProductCategoryInputPort(DataSource dataSource) {
        return new FindProductCategoryUseCase(
                new MappingSqlQueryFindProductCategoryById(dataSource)
        );
    }

}
