
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
public class PayPeriodRepositoryImpl implements PayPeriodRepository {

    private final Environment environment;

    @Autowired
    public PayPeriodRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(PayPeriod  payperiod) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int payPeriodId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), PayPeriodQuery.INSERT, true)
                .bind (payperiod)
                .executeUpdate()
                .getKey(int.class);


        return payPeriodId;
    }

    @Override
    public void bulkCreate(List<PayPeriod> payperiods) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,PayPeriodQuery.INSERT, false);
            for (PayPeriod payperiod : payperiods) {
                query.bind(payperiod).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(PayPeriod payperiod) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PayPeriodQuery.UPDATE, true)
                .bind (payperiod)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int payPeriodId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PayPeriodQuery.DELETE, true)
                .addParameter("payPeriodId", payPeriodId)
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
                    .execute(PayPeriodQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<PayPeriod> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PayPeriodQuery.READ, true)
                .executeAndFetch(PayPeriod.class);
    }
    @Override
    public List<PayPeriod> readByPayPeriodCreatedAt(String payPeriodCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PayPeriodQuery.READ_BY_PAY_PERIOD_PAYPERIODCREATEDAT, true)
                .addParameter("payPeriodCreatedAt", payPeriodCreatedAt)
                .executeAndFetch(PayPeriod.class);
    }
    @Override
    public List<PayPeriod> readByPayPeriodEndDate(String payPeriodEndDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PayPeriodQuery.READ_BY_PAY_PERIOD_PAYPERIODENDDATE, true)
                .addParameter("payPeriodEndDate", payPeriodEndDate)
                .executeAndFetch(PayPeriod.class);
    }
    @Override
    public PayPeriod readByPayPeriodId(int payPeriodId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PayPeriodQuery.READ_BY_PAY_PERIOD_PAYPERIODID, true)
                .addParameter("payPeriodId", payPeriodId)
                .executeAndFetch (PayPeriod.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<PayPeriod> readByPayPeriodName(String payPeriodName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PayPeriodQuery.READ_BY_PAY_PERIOD_PAYPERIODNAME, true)
                .addParameter("payPeriodName", payPeriodName)
                .executeAndFetch(PayPeriod.class);
    }
    @Override
    public List<PayPeriod> readByPayPeriodPeriodType(String payPeriodPeriodType) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PayPeriodQuery.READ_BY_PAY_PERIOD_PAYPERIODPERIODTYPE, true)
                .addParameter("payPeriodPeriodType", payPeriodPeriodType)
                .executeAndFetch(PayPeriod.class);
    }
    @Override
    public List<PayPeriod> readByPayPeriodStartDate(String payPeriodStartDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PayPeriodQuery.READ_BY_PAY_PERIOD_PAYPERIODSTARTDATE, true)
                .addParameter("payPeriodStartDate", payPeriodStartDate)
                .executeAndFetch(PayPeriod.class);
    }
    @Override
    public List<PayPeriod> readByPayPeriodStatus(String payPeriodStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PayPeriodQuery.READ_BY_PAY_PERIOD_PAYPERIODSTATUS, true)
                .addParameter("payPeriodStatus", payPeriodStatus)
                .executeAndFetch(PayPeriod.class);
    }
    @Override
    public List<PayPeriod> readByPayPeriodUpdatedAt(String payPeriodUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),PayPeriodQuery.READ_BY_PAY_PERIOD_PAYPERIODUPDATEDAT, true)
                .addParameter("payPeriodUpdatedAt", payPeriodUpdatedAt)
                .executeAndFetch(PayPeriod.class);
    }

@Override
public PayPeriodPage findPayPeriod(PayPeriodFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(PayPeriodQuery.READ);

    // Dynamic filters

    if (filter.getPayPeriodCreatedAt() != null) {   baseSql.append(" AND payPeriodCreatedAt = :payPeriodCreatedAt"); }
    if (filter.getPayPeriodEndDate() != null) {   baseSql.append(" AND payPeriodEndDate = :payPeriodEndDate"); }
    if (filter.getPayPeriodId() != null) {   baseSql.append(" AND payPeriodId = :payPeriodId"); }
    if (filter.getPayPeriodName() != null) {   baseSql.append(" AND payPeriodName = :payPeriodName"); }
    if (filter.getPayPeriodPeriodType() != null) {   baseSql.append(" AND payPeriodPeriodType = :payPeriodPeriodType"); }
    if (filter.getPayPeriodStartDate() != null) {   baseSql.append(" AND payPeriodStartDate = :payPeriodStartDate"); }
    if (filter.getPayPeriodStatus() != null) {   baseSql.append(" AND payPeriodStatus = :payPeriodStatus"); }
    if (filter.getPayPeriodUpdatedAt() != null) {   baseSql.append(" AND payPeriodUpdatedAt = :payPeriodUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getPayPeriodCreatedAt() != null) countQuery.addParameter("payPeriodCreatedAt", filter.getPayPeriodCreatedAt());
     if (filter.getPayPeriodEndDate() != null) countQuery.addParameter("payPeriodEndDate", filter.getPayPeriodEndDate());
     if (filter.getPayPeriodId() != null) countQuery.addParameter("payPeriodId", filter.getPayPeriodId());
     if (filter.getPayPeriodName() != null) countQuery.addParameter("payPeriodName", filter.getPayPeriodName());
     if (filter.getPayPeriodPeriodType() != null) countQuery.addParameter("payPeriodPeriodType", filter.getPayPeriodPeriodType());
     if (filter.getPayPeriodStartDate() != null) countQuery.addParameter("payPeriodStartDate", filter.getPayPeriodStartDate());
     if (filter.getPayPeriodStatus() != null) countQuery.addParameter("payPeriodStatus", filter.getPayPeriodStatus());
     if (filter.getPayPeriodUpdatedAt() != null) countQuery.addParameter("payPeriodUpdatedAt", filter.getPayPeriodUpdatedAt());
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

    if (filter.getPayPeriodCreatedAt() != null) pageQuery.addParameter("payPeriodCreatedAt", filter.getPayPeriodCreatedAt());
    if (filter.getPayPeriodEndDate() != null) pageQuery.addParameter("payPeriodEndDate", filter.getPayPeriodEndDate());
    if (filter.getPayPeriodId() != null) pageQuery.addParameter("payPeriodId", filter.getPayPeriodId());
    if (filter.getPayPeriodName() != null) pageQuery.addParameter("payPeriodName", filter.getPayPeriodName());
    if (filter.getPayPeriodPeriodType() != null) pageQuery.addParameter("payPeriodPeriodType", filter.getPayPeriodPeriodType());
    if (filter.getPayPeriodStartDate() != null) pageQuery.addParameter("payPeriodStartDate", filter.getPayPeriodStartDate());
    if (filter.getPayPeriodStatus() != null) pageQuery.addParameter("payPeriodStatus", filter.getPayPeriodStatus());
    if (filter.getPayPeriodUpdatedAt() != null) pageQuery.addParameter("payPeriodUpdatedAt", filter.getPayPeriodUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<PayPeriod> data = pageQuery.executeAndFetch(PayPeriod.class);

     return new PayPeriodPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "payPeriodCreatedAt","payPeriodEndDate","payPeriodId","payPeriodName","payPeriodPeriodType","payPeriodStartDate","payPeriodStatus","payPeriodUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
