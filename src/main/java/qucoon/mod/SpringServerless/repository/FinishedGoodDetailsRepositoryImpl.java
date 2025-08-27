
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
public class FinishedGoodDetailsRepositoryImpl implements FinishedGoodDetailsRepository {

    private final Environment environment;

    @Autowired
    public FinishedGoodDetailsRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(FinishedGoodDetails  finishedgooddetails) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int finishedGoodDetailsId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), FinishedGoodDetailsQuery.INSERT, true)
                .bind (finishedgooddetails)
                .executeUpdate()
                .getKey(int.class);


        return finishedGoodDetailsId;
    }

    @Override
    public void bulkCreate(List<FinishedGoodDetails> finishedgooddetailss) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,FinishedGoodDetailsQuery.INSERT, false);
            for (FinishedGoodDetails finishedgooddetails : finishedgooddetailss) {
                query.bind(finishedgooddetails).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(FinishedGoodDetails finishedgooddetails) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),FinishedGoodDetailsQuery.UPDATE, true)
                .bind (finishedgooddetails)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int finishedGoodDetailsId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),FinishedGoodDetailsQuery.DELETE, true)
                .addParameter(System.getenv("API_KEY_FINISHED"), finishedGoodDetailsId)
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
                    .execute(FinishedGoodDetailsQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<FinishedGoodDetails> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),FinishedGoodDetailsQuery.READ, true)
                .executeAndFetch(FinishedGoodDetails.class);
    }
    @Override
    public List<FinishedGoodDetails> readByFinishedGoodDetailsCreatedAt(String finishedGoodDetailsCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),FinishedGoodDetailsQuery.READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_FINISHED"), finishedGoodDetailsCreatedAt)
                .executeAndFetch(FinishedGoodDetails.class);
    }
    @Override
    public List<FinishedGoodDetails> readByFinishedGoodDetailsExpiryDate(String finishedGoodDetailsExpiryDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),FinishedGoodDetailsQuery.READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSEXPIRYDATE, true)
                .addParameter(System.getenv("API_KEY_FINISHED"), finishedGoodDetailsExpiryDate)
                .executeAndFetch(FinishedGoodDetails.class);
    }
    @Override
    public FinishedGoodDetails readByFinishedGoodDetailsId(int finishedGoodDetailsId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),FinishedGoodDetailsQuery.READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSID, true)
                .addParameter(System.getenv("API_KEY_FINISHED"), finishedGoodDetailsId)
                .executeAndFetch (FinishedGoodDetails.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<FinishedGoodDetails> readByFinishedGoodDetailsInventoryItemId(int finishedGoodDetailsInventoryItemId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),FinishedGoodDetailsQuery.READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSINVENTORYITEMID, true)
                .addParameter(System.getenv("API_KEY_FINISHED"), finishedGoodDetailsInventoryItemId)
                .executeAndFetch(FinishedGoodDetails.class);
    }
    @Override
    public List<FinishedGoodDetails> readByFinishedGoodDetailsManufacturingDate(String finishedGoodDetailsManufacturingDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),FinishedGoodDetailsQuery.READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSMANUFACTURINGDATE, true)
                .addParameter(System.getenv("API_KEY_FINISHED"), finishedGoodDetailsManufacturingDate)
                .executeAndFetch(FinishedGoodDetails.class);
    }
    @Override
    public List<FinishedGoodDetails> readByFinishedGoodDetailsProductId(int finishedGoodDetailsProductId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),FinishedGoodDetailsQuery.READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSPRODUCTID, true)
                .addParameter(System.getenv("API_KEY_FINISHED"), finishedGoodDetailsProductId)
                .executeAndFetch(FinishedGoodDetails.class);
    }
    @Override
    public List<FinishedGoodDetails> readByFinishedGoodDetailsStatus(String finishedGoodDetailsStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),FinishedGoodDetailsQuery.READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSSTATUS, true)
                .addParameter(System.getenv("API_KEY_FINISHED"), finishedGoodDetailsStatus)
                .executeAndFetch(FinishedGoodDetails.class);
    }
    @Override
    public List<FinishedGoodDetails> readByFinishedGoodDetailsUpdatedAt(String finishedGoodDetailsUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),FinishedGoodDetailsQuery.READ_BY_FINISHED_GOOD_DETAILS_FINISHEDGOODDETAILSUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_FINISHED"), finishedGoodDetailsUpdatedAt)
                .executeAndFetch(FinishedGoodDetails.class);
    }

@Override
public FinishedGoodDetailsPage findFinishedGoodDetails(FinishedGoodDetailsFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(FinishedGoodDetailsQuery.READ);

    // Dynamic filters

    if (filter.getFinishedGoodDetailsCreatedAt() != null) {   baseSql.append(" AND finishedGoodDetailsCreatedAt = :finishedGoodDetailsCreatedAt"); }
    if (filter.getFinishedGoodDetailsExpiryDate() != null) {   baseSql.append(" AND finishedGoodDetailsExpiryDate = :finishedGoodDetailsExpiryDate"); }
    if (filter.getFinishedGoodDetailsId() != null) {   baseSql.append(" AND finishedGoodDetailsId = :finishedGoodDetailsId"); }
    if (filter.getFinishedGoodDetailsInventoryItemId() != null) {   baseSql.append(" AND finishedGoodDetailsInventoryItemId = :finishedGoodDetailsInventoryItemId"); }
    if (filter.getFinishedGoodDetailsManufacturingDate() != null) {   baseSql.append(" AND finishedGoodDetailsManufacturingDate = :finishedGoodDetailsManufacturingDate"); }
    if (filter.getFinishedGoodDetailsProductId() != null) {   baseSql.append(" AND finishedGoodDetailsProductId = :finishedGoodDetailsProductId"); }
    if (filter.getFinishedGoodDetailsStatus() != null) {   baseSql.append(" AND finishedGoodDetailsStatus = :finishedGoodDetailsStatus"); }
    if (filter.getFinishedGoodDetailsUpdatedAt() != null) {   baseSql.append(" AND finishedGoodDetailsUpdatedAt = :finishedGoodDetailsUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getFinishedGoodDetailsCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsCreatedAt());
     if (filter.getFinishedGoodDetailsExpiryDate() != null) countQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsExpiryDate());
     if (filter.getFinishedGoodDetailsId() != null) countQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsId());
     if (filter.getFinishedGoodDetailsInventoryItemId() != null) countQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsInventoryItemId());
     if (filter.getFinishedGoodDetailsManufacturingDate() != null) countQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsManufacturingDate());
     if (filter.getFinishedGoodDetailsProductId() != null) countQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsProductId());
     if (filter.getFinishedGoodDetailsStatus() != null) countQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsStatus());
     if (filter.getFinishedGoodDetailsUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsUpdatedAt());
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

    if (filter.getFinishedGoodDetailsCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsCreatedAt());
    if (filter.getFinishedGoodDetailsExpiryDate() != null) pageQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsExpiryDate());
    if (filter.getFinishedGoodDetailsId() != null) pageQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsId());
    if (filter.getFinishedGoodDetailsInventoryItemId() != null) pageQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsInventoryItemId());
    if (filter.getFinishedGoodDetailsManufacturingDate() != null) pageQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsManufacturingDate());
    if (filter.getFinishedGoodDetailsProductId() != null) pageQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsProductId());
    if (filter.getFinishedGoodDetailsStatus() != null) pageQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsStatus());
    if (filter.getFinishedGoodDetailsUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_FINISHED"), filter.getFinishedGoodDetailsUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<FinishedGoodDetails> data = pageQuery.executeAndFetch(FinishedGoodDetails.class);

     return new FinishedGoodDetailsPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_FINISHED"),System.getenv("API_KEY_FINISHED"),System.getenv("API_KEY_FINISHED"),System.getenv("API_KEY_FINISHED"),System.getenv("API_KEY_FINISHED"),System.getenv("API_KEY_FINISHED"),System.getenv("API_KEY_FINISHED"),System.getenv("API_KEY_FINISHED")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
