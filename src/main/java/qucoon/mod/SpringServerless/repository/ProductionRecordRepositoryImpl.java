
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
public class ProductionRecordRepositoryImpl implements ProductionRecordRepository {

    private final Environment environment;

    @Autowired
    public ProductionRecordRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(ProductionRecord  productionrecord) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int productionRecordId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), ProductionRecordQuery.INSERT, true)
                .bind (productionrecord)
                .executeUpdate()
                .getKey(int.class);


        return productionRecordId;
    }

    @Override
    public void bulkCreate(List<ProductionRecord> productionrecords) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,ProductionRecordQuery.INSERT, false);
            for (ProductionRecord productionrecord : productionrecords) {
                query.bind(productionrecord).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(ProductionRecord productionrecord) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionRecordQuery.UPDATE, true)
                .bind (productionrecord)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int productionRecordId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionRecordQuery.DELETE, true)
                .addParameter("productionRecordId", productionRecordId)
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
                    .execute(ProductionRecordQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ProductionRecord> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionRecordQuery.READ, true)
                .executeAndFetch(ProductionRecord.class);
    }
    @Override
    public List<ProductionRecord> readByProductionRecordBatchNumber(String productionRecordBatchNumber) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionRecordQuery.READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDBATCHNUMBER, true)
                .addParameter(System.getenv("API_KEY_PRODUCTI"), productionRecordBatchNumber)
                .executeAndFetch(ProductionRecord.class);
    }
    @Override
    public List<ProductionRecord> readByProductionRecordCreatedAt(String productionRecordCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionRecordQuery.READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_PRODUCTI"), productionRecordCreatedAt)
                .executeAndFetch(ProductionRecord.class);
    }
    @Override
    public List<ProductionRecord> readByProductionRecordCreatedByUserId(int productionRecordCreatedByUserId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionRecordQuery.READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDCREATEDBYUSERID, true)
                .addParameter(System.getenv("API_KEY_PRODUCTI"), productionRecordCreatedByUserId)
                .executeAndFetch(ProductionRecord.class);
    }
    @Override
    public List<ProductionRecord> readByProductionRecordDate(String productionRecordDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionRecordQuery.READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDDATE, true)
                .addParameter(System.getenv("API_KEY_PRODUCTI"), productionRecordDate)
                .executeAndFetch(ProductionRecord.class);
    }
    @Override
    public List<ProductionRecord> readByProductionRecordFinishedGoodProductId(int productionRecordFinishedGoodProductId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionRecordQuery.READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDFINISHEDGOODPRODUCTID, true)
                .addParameter(System.getenv("API_KEY_PRODUCTI"), productionRecordFinishedGoodProductId)
                .executeAndFetch(ProductionRecord.class);
    }
    @Override
    public ProductionRecord readByProductionRecordId(int productionRecordId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionRecordQuery.READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDID, true)
                .addParameter("productionRecordId", productionRecordId)
                .executeAndFetch (ProductionRecord.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<ProductionRecord> readByProductionRecordStatus(String productionRecordStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionRecordQuery.READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDSTATUS, true)
                .addParameter(System.getenv("API_KEY_PRODUCTI"), productionRecordStatus)
                .executeAndFetch(ProductionRecord.class);
    }
    @Override
    public List<ProductionRecord> readByProductionRecordUpdatedAt(String productionRecordUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionRecordQuery.READ_BY_PRODUCTION_RECORD_PRODUCTIONRECORDUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_PRODUCTI"), productionRecordUpdatedAt)
                .executeAndFetch(ProductionRecord.class);
    }
    @Override
    public List<ProductionRecord> readBySupplierPhoneNumber(String supplierPhoneNumber) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ProductionRecordQuery.READ_BY_PRODUCTION_RECORD_SUPPLIERPHONENUMBER, true)
                .addParameter("supplierPhoneNumber", supplierPhoneNumber)
                .executeAndFetch(ProductionRecord.class);
    }

@Override
public ProductionRecordPage findProductionRecord(ProductionRecordFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(ProductionRecordQuery.READ);

    // Dynamic filters

    if (filter.getProductionRecordBatchNumber() != null) {   baseSql.append(" AND productionRecordBatchNumber = :productionRecordBatchNumber"); }
    if (filter.getProductionRecordCreatedAt() != null) {   baseSql.append(" AND productionRecordCreatedAt = :productionRecordCreatedAt"); }
    if (filter.getProductionRecordCreatedByUserId() != null) {   baseSql.append(" AND productionRecordCreatedByUserId = :productionRecordCreatedByUserId"); }
    if (filter.getProductionRecordDate() != null) {   baseSql.append(" AND productionRecordDate = :productionRecordDate"); }
    if (filter.getProductionRecordFinishedGoodProductId() != null) {   baseSql.append(" AND productionRecordFinishedGoodProductId = :productionRecordFinishedGoodProductId"); }
    if (filter.getProductionRecordId() != null) {   baseSql.append(" AND productionRecordId = :productionRecordId"); }
    if (filter.getProductionRecordStatus() != null) {   baseSql.append(" AND productionRecordStatus = :productionRecordStatus"); }
    if (filter.getProductionRecordUpdatedAt() != null) {   baseSql.append(" AND productionRecordUpdatedAt = :productionRecordUpdatedAt"); }
    if (filter.getSupplierPhoneNumber() != null) {   baseSql.append(" AND supplierPhoneNumber = :supplierPhoneNumber"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getProductionRecordBatchNumber() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionRecordBatchNumber());
     if (filter.getProductionRecordCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionRecordCreatedAt());
     if (filter.getProductionRecordCreatedByUserId() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionRecordCreatedByUserId());
     if (filter.getProductionRecordDate() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionRecordDate());
     if (filter.getProductionRecordFinishedGoodProductId() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionRecordFinishedGoodProductId());
     if (filter.getProductionRecordId() != null) countQuery.addParameter("productionRecordId", filter.getProductionRecordId());
     if (filter.getProductionRecordStatus() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionRecordStatus());
     if (filter.getProductionRecordUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionRecordUpdatedAt());
     if (filter.getSupplierPhoneNumber() != null) countQuery.addParameter("supplierPhoneNumber", filter.getSupplierPhoneNumber());
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

    if (filter.getProductionRecordBatchNumber() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionRecordBatchNumber());
    if (filter.getProductionRecordCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionRecordCreatedAt());
    if (filter.getProductionRecordCreatedByUserId() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionRecordCreatedByUserId());
    if (filter.getProductionRecordDate() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionRecordDate());
    if (filter.getProductionRecordFinishedGoodProductId() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionRecordFinishedGoodProductId());
    if (filter.getProductionRecordId() != null) pageQuery.addParameter("productionRecordId", filter.getProductionRecordId());
    if (filter.getProductionRecordStatus() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionRecordStatus());
    if (filter.getProductionRecordUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_PRODUCTI"), filter.getProductionRecordUpdatedAt());
    if (filter.getSupplierPhoneNumber() != null) pageQuery.addParameter("supplierPhoneNumber", filter.getSupplierPhoneNumber());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<ProductionRecord> data = pageQuery.executeAndFetch(ProductionRecord.class);

     return new ProductionRecordPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_PRODUCTI"),System.getenv("API_KEY_PRODUCTI"),System.getenv("API_KEY_PRODUCTI"),System.getenv("API_KEY_PRODUCTI"),System.getenv("API_KEY_PRODUCTI"),"productionRecordId",System.getenv("API_KEY_PRODUCTI"),System.getenv("API_KEY_PRODUCTI"),"supplierPhoneNumber"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
