
package   qucoon.mod.SpringServerless.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.repository.query.*;
import qucoon.mod.SpringServerless.utility.Environment;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.model.request.*;
import qucoon.mod.SpringServerless.repository.page.*;
import qucoon.mod.SpringServerless.model.entity.Module;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import java.util.List;

import static qucoon.mod.SpringServerless.repository.query.QueryUtils.createQueryWithoutOnMappingFailure;


@Repository
public class ProductionMaterialRepositoryImpl implements ProductionMaterialRepository {

    private final Environment environment;

    @Autowired
    public ProductionMaterialRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(ProductionMaterial  productionmaterial) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int productionMaterialId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), ProductionMaterialQuery.INSERT, true)
                .bind (productionmaterial)
                .executeUpdate()
                .getKey(int.class);


        return productionMaterialId;
    }

    @Override
    public void bulkCreate(List<ProductionMaterial> productionmaterials) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,ProductionMaterialQuery.INSERT, false);
            for (ProductionMaterial productionmaterial : productionmaterials) {
                query.bind(productionmaterial).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(ProductionMaterial productionmaterial) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionMaterialQuery.UPDATE, true)
                .bind (productionmaterial)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int productionMaterialId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionMaterialQuery.DELETE, true)
                .addParameter(System.getenv("API_KEY_PRODUCTI"), productionMaterialId)
                .executeUpdate()
                .getResult();
    }

    @Override
    public boolean truncate() {
        try {
            assert environment.getDatabaseUtil().getSql2oConnection() != null;
            return environment.getDatabaseUtil().getSql2oConnection()
                    .getJdbcConnection()
                    .createStatement()
                    .execute(ProductionMaterialQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ProductionMaterial> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionMaterialQuery.READ, true)
                .executeAndFetch(ProductionMaterial.class);
    }
    @Override
    public List<ProductionMaterial> readByProductionMaterialCreatedAt(String productionMaterialCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionMaterialQuery.READ_BY_PRODUCTION_MATERIAL_PRODUCTIONMATERIALCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_PRODUCTI"), productionMaterialCreatedAt)
                .executeAndFetch(ProductionMaterial.class);
    }
    @Override
    public ProductionMaterial readByProductionMaterialId(int productionMaterialId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionMaterialQuery.READ_BY_PRODUCTION_MATERIAL_PRODUCTIONMATERIALID, true)
                .addParameter(System.getenv("API_KEY_PRODUCTI"), productionMaterialId)
                .executeAndFetch (ProductionMaterial.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<ProductionMaterial> readByProductionMaterialInventoryItemId(int productionMaterialInventoryItemId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionMaterialQuery.READ_BY_PRODUCTION_MATERIAL_PRODUCTIONMATERIALINVENTORYITEMID, true)
                .addParameter(System.getenv("API_KEY_PRODUCTI"), productionMaterialInventoryItemId)
                .executeAndFetch(ProductionMaterial.class);
    }
    @Override
    public List<ProductionMaterial> readByProductionMaterialProductionRecordId(int productionMaterialProductionRecordId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionMaterialQuery.READ_BY_PRODUCTION_MATERIAL_PRODUCTIONMATERIALPRODUCTIONRECORDID, true)
                .addParameter(System.getenv("API_KEY_PRODUCTI"), productionMaterialProductionRecordId)
                .executeAndFetch(ProductionMaterial.class);
    }
    @Override
    public List<ProductionMaterial> readByProductionMaterialQuantityConsumed(int productionMaterialQuantityConsumed) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionMaterialQuery.READ_BY_PRODUCTION_MATERIAL_PRODUCTIONMATERIALQUANTITYCONSUMED, true)
                .addParameter(System.getenv("API_KEY_PRODUCTI"), productionMaterialQuantityConsumed)
                .executeAndFetch(ProductionMaterial.class);
    }
    @Override
    public List<ProductionMaterial> readByProductionMaterialStatus(String productionMaterialStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionMaterialQuery.READ_BY_PRODUCTION_MATERIAL_PRODUCTIONMATERIALSTATUS, true)
                .addParameter(System.getenv("API_KEY_PRODUCTI"), productionMaterialStatus)
                .executeAndFetch(ProductionMaterial.class);
    }
    @Override
    public List<ProductionMaterial> readByProductionMaterialUpdatedAt(String productionMaterialUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionMaterialQuery.READ_BY_PRODUCTION_MATERIAL_PRODUCTIONMATERIALUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_PRODUCTI"), productionMaterialUpdatedAt)
                .executeAndFetch(ProductionMaterial.class);
    }

@Override
public ProductionMaterialPage findProductionMaterial(ProductionMaterialFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(ProductionMaterialQuery.READ);

    // Dynamic filters

    if (filter.getProductionMaterialCreatedAt() != null) {   baseSql.append(" AND productionMaterialCreatedAt = :productionMaterialCreatedAt"); }
    if (filter.getProductionMaterialId() != null) {   baseSql.append(" AND productionMaterialId = :productionMaterialId"); }
    if (filter.getProductionMaterialInventoryItemId() != null) {   baseSql.append(" AND productionMaterialInventoryItemId = :productionMaterialInventoryItemId"); }
    if (filter.getProductionMaterialProductionRecordId() != null) {   baseSql.append(" AND productionMaterialProductionRecordId = :productionMaterialProductionRecordId"); }
    if (filter.getProductionMaterialQuantityConsumed() != null) {   baseSql.append(" AND productionMaterialQuantityConsumed = :productionMaterialQuantityConsumed"); }
    if (filter.getProductionMaterialStatus() != null) {   baseSql.append(" AND productionMaterialStatus = :productionMaterialStatus"); }
    if (filter.getProductionMaterialUpdatedAt() != null) {   baseSql.append(" AND productionMaterialUpdatedAt = :productionMaterialUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getProductionMaterialCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionMaterialCreatedAt());
     if (filter.getProductionMaterialId() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionMaterialId());
     if (filter.getProductionMaterialInventoryItemId() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionMaterialInventoryItemId());
     if (filter.getProductionMaterialProductionRecordId() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionMaterialProductionRecordId());
     if (filter.getProductionMaterialQuantityConsumed() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionMaterialQuantityConsumed());
     if (filter.getProductionMaterialStatus() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionMaterialStatus());
     if (filter.getProductionMaterialUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionMaterialUpdatedAt());
     if (filter.getSearch() != null) countQuery.addParameter("search", "%" + filter.getSearch() + "%");
     Long total = countQuery.executeScalar(Long.class);

   // MSSQL pagination requires ORDER BY for OFFSET/FETCH
    String validSortDir = filter.getSortDir().equalsIgnoreCase("ASC") ? "ASC" : "DESC";
    String orderBy = " ORDER BY " + sanitizeSortBy(filter.getSortBy()) + " " + validSortDir;
     // Append order and pagination
     StringBuilder pageSql_old = new StringBuilder(baseSql)
             .append(" ORDER BY ").append (filter.getSortBy())
             .append(" ").append (filter.getSortDir())
             .append("  OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY");
    // Build pagination SQL
    String pageSql = baseSql.toString() + orderBy +
" OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY";

     // Fetch page data
     var pageQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             pageSql.toString(),
             true);

    if (filter.getProductionMaterialCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionMaterialCreatedAt());
    if (filter.getProductionMaterialId() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionMaterialId());
    if (filter.getProductionMaterialInventoryItemId() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionMaterialInventoryItemId());
    if (filter.getProductionMaterialProductionRecordId() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionMaterialProductionRecordId());
    if (filter.getProductionMaterialQuantityConsumed() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionMaterialQuantityConsumed());
    if (filter.getProductionMaterialStatus() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionMaterialStatus());
    if (filter.getProductionMaterialUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionMaterialUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<ProductionMaterial> data = pageQuery.executeAndFetch(ProductionMaterial.class);

     return new ProductionMaterialPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_PRODUCTI"),System.getenv("API_KEY_PRODUCTI"),System.getenv("API_KEY_PRODUCTI"),System.getenv("API_KEY_PRODUCTI"),System.getenv("API_KEY_PRODUCTI"),System.getenv("API_KEY_PRODUCTI"),System.getenv("API_KEY_PRODUCTI")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
