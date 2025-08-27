
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
public class SalePaymentLogRepositoryImpl implements SalePaymentLogRepository {

    private final Environment environment;

    @Autowired
    public SalePaymentLogRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(SalePaymentLog  salepaymentlog) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int salePaymentLogid = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), SalePaymentLogQuery.INSERT, true)
                .bind (salepaymentlog)
                .executeUpdate()
                .getKey(int.class);


        return salePaymentLogid;
    }

    @Override
    public void bulkCreate(List<SalePaymentLog> salepaymentlogs) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,SalePaymentLogQuery.INSERT, false);
            for (SalePaymentLog salepaymentlog : salepaymentlogs) {
                query.bind(salepaymentlog).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(SalePaymentLog salepaymentlog) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalePaymentLogQuery.UPDATE, true)
                .bind (salepaymentlog)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int salePaymentLogid) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalePaymentLogQuery.DELETE, true)
                .addParameter("salePaymentLogid", salePaymentLogid)
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
                    .execute(SalePaymentLogQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SalePaymentLog> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalePaymentLogQuery.READ, true)
                .executeAndFetch(SalePaymentLog.class);
    }
    @Override
    public List<SalePaymentLog> readBySalePaymentLogAmount(Double salePaymentLogAmount) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalePaymentLogQuery.READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGAMOUNT, true)
                .addParameter(System.getenv("API_KEY_SALEPAYM"), salePaymentLogAmount)
                .executeAndFetch(SalePaymentLog.class);
    }
    @Override
    public List<SalePaymentLog> readBySalePaymentLogCreatedAt(String salePaymentLogCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalePaymentLogQuery.READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_SALEPAYM"), salePaymentLogCreatedAt)
                .executeAndFetch(SalePaymentLog.class);
    }
    @Override
    public List<SalePaymentLog> readBySalePaymentLogEmployeeid(int salePaymentLogEmployeeid) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalePaymentLogQuery.READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGEMPLOYEEID, true)
                .addParameter(System.getenv("API_KEY_SALEPAYM"), salePaymentLogEmployeeid)
                .executeAndFetch(SalePaymentLog.class);
    }
    @Override
    public SalePaymentLog readBySalePaymentLogid(int salePaymentLogid) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalePaymentLogQuery.READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGID, true)
                .addParameter("salePaymentLogid", salePaymentLogid)
                .executeAndFetch (SalePaymentLog.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<SalePaymentLog> readBySalePaymentLogMethod(String salePaymentLogMethod) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalePaymentLogQuery.READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGMETHOD, true)
                .addParameter(System.getenv("API_KEY_SALEPAYM"), salePaymentLogMethod)
                .executeAndFetch(SalePaymentLog.class);
    }
    @Override
    public List<SalePaymentLog> readBySalePaymentLogNotes(String salePaymentLogNotes) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalePaymentLogQuery.READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGNOTES, true)
                .addParameter("salePaymentLogNotes", salePaymentLogNotes)
                .executeAndFetch(SalePaymentLog.class);
    }
    @Override
    public List<SalePaymentLog> readBySalePaymentLogSaleid(int salePaymentLogSaleid) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalePaymentLogQuery.READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGSALEID, true)
                .addParameter(System.getenv("API_KEY_SALEPAYM"), salePaymentLogSaleid)
                .executeAndFetch(SalePaymentLog.class);
    }
    @Override
    public List<SalePaymentLog> readBySalePaymentLogStatus(String salePaymentLogStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalePaymentLogQuery.READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTLOGSTATUS, true)
                .addParameter(System.getenv("API_KEY_SALEPAYM"), salePaymentLogStatus)
                .executeAndFetch(SalePaymentLog.class);
    }
    @Override
    public List<SalePaymentLog> readBySalePaymentUpdatedAt(String salePaymentUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SalePaymentLogQuery.READ_BY_SALE_PAYMENT_LOG_SALEPAYMENTUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_SALEPAYM"), salePaymentUpdatedAt)
                .executeAndFetch(SalePaymentLog.class);
    }

@Override
public SalePaymentLogPage findSalePaymentLog(SalePaymentLogFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(SalePaymentLogQuery.READ);

    // Dynamic filters

    if (filter.getSalePaymentLogAmount() != null) {   baseSql.append(" AND salePaymentLogAmount = :salePaymentLogAmount"); }
    if (filter.getSalePaymentLogCreatedAt() != null) {   baseSql.append(" AND salePaymentLogCreatedAt = :salePaymentLogCreatedAt"); }
    if (filter.getSalePaymentLogEmployeeid() != null) {   baseSql.append(" AND salePaymentLogEmployeeid = :salePaymentLogEmployeeid"); }
    if (filter.getSalePaymentLogid() != null) {   baseSql.append(" AND salePaymentLogid = :salePaymentLogid"); }
    if (filter.getSalePaymentLogMethod() != null) {   baseSql.append(" AND salePaymentLogMethod = :salePaymentLogMethod"); }
    if (filter.getSalePaymentLogNotes() != null) {   baseSql.append(" AND salePaymentLogNotes = :salePaymentLogNotes"); }
    if (filter.getSalePaymentLogSaleid() != null) {   baseSql.append(" AND salePaymentLogSaleid = :salePaymentLogSaleid"); }
    if (filter.getSalePaymentLogStatus() != null) {   baseSql.append(" AND salePaymentLogStatus = :salePaymentLogStatus"); }
    if (filter.getSalePaymentUpdatedAt() != null) {   baseSql.append(" AND salePaymentUpdatedAt = :salePaymentUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getSalePaymentLogAmount() != null) countQuery.addParameter(System.getenv("API_KEY_SALEPAYM"), filter.getSalePaymentLogAmount());
     if (filter.getSalePaymentLogCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_SALEPAYM"), filter.getSalePaymentLogCreatedAt());
     if (filter.getSalePaymentLogEmployeeid() != null) countQuery.addParameter(System.getenv("API_KEY_SALEPAYM"), filter.getSalePaymentLogEmployeeid());
     if (filter.getSalePaymentLogid() != null) countQuery.addParameter("salePaymentLogid", filter.getSalePaymentLogid());
     if (filter.getSalePaymentLogMethod() != null) countQuery.addParameter(System.getenv("API_KEY_SALEPAYM"), filter.getSalePaymentLogMethod());
     if (filter.getSalePaymentLogNotes() != null) countQuery.addParameter("salePaymentLogNotes", filter.getSalePaymentLogNotes());
     if (filter.getSalePaymentLogSaleid() != null) countQuery.addParameter(System.getenv("API_KEY_SALEPAYM"), filter.getSalePaymentLogSaleid());
     if (filter.getSalePaymentLogStatus() != null) countQuery.addParameter(System.getenv("API_KEY_SALEPAYM"), filter.getSalePaymentLogStatus());
     if (filter.getSalePaymentUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_SALEPAYM"), filter.getSalePaymentUpdatedAt());
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

    if (filter.getSalePaymentLogAmount() != null) pageQuery.addParameter(System.getenv("API_KEY_SALEPAYM"), filter.getSalePaymentLogAmount());
    if (filter.getSalePaymentLogCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_SALEPAYM"), filter.getSalePaymentLogCreatedAt());
    if (filter.getSalePaymentLogEmployeeid() != null) pageQuery.addParameter(System.getenv("API_KEY_SALEPAYM"), filter.getSalePaymentLogEmployeeid());
    if (filter.getSalePaymentLogid() != null) pageQuery.addParameter("salePaymentLogid", filter.getSalePaymentLogid());
    if (filter.getSalePaymentLogMethod() != null) pageQuery.addParameter(System.getenv("API_KEY_SALEPAYM"), filter.getSalePaymentLogMethod());
    if (filter.getSalePaymentLogNotes() != null) pageQuery.addParameter("salePaymentLogNotes", filter.getSalePaymentLogNotes());
    if (filter.getSalePaymentLogSaleid() != null) pageQuery.addParameter(System.getenv("API_KEY_SALEPAYM"), filter.getSalePaymentLogSaleid());
    if (filter.getSalePaymentLogStatus() != null) pageQuery.addParameter(System.getenv("API_KEY_SALEPAYM"), filter.getSalePaymentLogStatus());
    if (filter.getSalePaymentUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_SALEPAYM"), filter.getSalePaymentUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<SalePaymentLog> data = pageQuery.executeAndFetch(SalePaymentLog.class);

     return new SalePaymentLogPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_SALEPAYM"),System.getenv("API_KEY_SALEPAYM"),System.getenv("API_KEY_SALEPAYM"),"salePaymentLogid",System.getenv("API_KEY_SALEPAYM"),"salePaymentLogNotes",System.getenv("API_KEY_SALEPAYM"),System.getenv("API_KEY_SALEPAYM"),System.getenv("API_KEY_SALEPAYM")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
