package org.commerce.catalogue.infrastructure.adapter.output.jdbc;

import org.commerce.catalogue.application.port.data.ProductCategoryData;
import org.commerce.catalogue.application.port.data.id.ProductCategoryId;
import org.commerce.catalogue.application.port.output.FindProductCategoryByIdOutputPort;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;
import java.util.Optional;

public class MappingSqlQueryFindProductCategoryById extends MappingSqlQuery<ProductCategoryData> implements FindProductCategoryByIdOutputPort {

    public MappingSqlQueryFindProductCategoryById(DataSource ds) {
        super(ds,
                """
                        SELECT id, c_title, c_details, id_parent, c_version
                        FROM catalogue.v_product_category_v1
                        WHERE id = :id
                        """);
        this.declareParameter(new SqlParameter("id", Types.BIGINT));
        this.compile();
    }

    @Override
    public Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId productCategoryId) {
        return Optional.ofNullable(this.findObjectByNamedParam(Map.of("id", productCategoryId.value())));
    }

    @Override
    protected ProductCategoryData mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductCategoryData(
                new ProductCategoryId(rs.getLong("id")),
                rs.getString("c_title"),
                rs.getString("c_details"),
                new ProductCategoryId(rs.getLong("id_parent")),
                rs.getInt("c_version")
        );
    }

}
