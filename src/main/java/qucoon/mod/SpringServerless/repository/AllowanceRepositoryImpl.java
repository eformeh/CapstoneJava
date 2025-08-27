
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
public class AllowanceRepositoryImpl implements AllowanceRepository {

    private final Environment environment;

    @Autowired
    public AllowanceRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Allowance  allowance) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int allowanceId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), AllowanceQuery.INSERT, true)
                .bind (allowance)
                .executeUpdate()
                .getKey(int.class);


        return allowanceId;
    }

    @Override
    public void bulkCreate(List<Allowance> allowances) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,AllowanceQuery.INSERT, false);
            for (Allowance allowance : allowances) {
                query.bind(allowance).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Allowance allowance) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AllowanceQuery.UPDATE, true)
                .bind (allowance)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int allowanceId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AllowanceQuery.DELETE, true)
                .addParameter("allowanceId", allowanceId)
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
                    .execute(AllowanceQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Allowance> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AllowanceQuery.READ, true)
                .executeAndFetch(Allowance.class);
    }
    @Override
    public List<Allowance> readByAllowanceAmount(Double allowanceAmount) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AllowanceQuery.READ_BY_ALLOWANCE_ALLOWANCEAMOUNT, true)
                .addParameter("allowanceAmount", allowanceAmount)
                .executeAndFetch(Allowance.class);
    }
    @Override
    public List<Allowance> readByAllowanceCreatedAt(String allowanceCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AllowanceQuery.READ_BY_ALLOWANCE_ALLOWANCECREATEDAT, true)
                .addParameter("allowanceCreatedAt", allowanceCreatedAt)
                .executeAndFetch(Allowance.class);
    }
    @Override
    public Allowance readByAllowanceId(int allowanceId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AllowanceQuery.READ_BY_ALLOWANCE_ALLOWANCEID, true)
                .addParameter("allowanceId", allowanceId)
                .executeAndFetch (Allowance.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Allowance> readByAllowanceSalaryId(int allowanceSalaryId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AllowanceQuery.READ_BY_ALLOWANCE_ALLOWANCESALARYID, true)
                .addParameter("allowanceSalaryId", allowanceSalaryId)
                .executeAndFetch(Allowance.class);
    }
    @Override
    public List<Allowance> readByAllowanceStatus(String allowanceStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AllowanceQuery.READ_BY_ALLOWANCE_ALLOWANCESTATUS, true)
                .addParameter("allowanceStatus", allowanceStatus)
                .executeAndFetch(Allowance.class);
    }
    @Override
    public List<Allowance> readByAllowanceType(String allowanceType) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AllowanceQuery.READ_BY_ALLOWANCE_ALLOWANCETYPE, true)
                .addParameter("allowanceType", allowanceType)
                .executeAndFetch(Allowance.class);
    }
    @Override
    public List<Allowance> readByAllowanceUpdatedAt(String allowanceUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AllowanceQuery.READ_BY_ALLOWANCE_ALLOWANCEUPDATEDAT, true)
                .addParameter("allowanceUpdatedAt", allowanceUpdatedAt)
                .executeAndFetch(Allowance.class);
    }

@Override
public AllowancePage findAllowance(AllowanceFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(AllowanceQuery.READ);

    // Dynamic filters

    if (filter.getAllowanceAmount() != null) {   baseSql.append(" AND allowanceAmount = :allowanceAmount"); }
    if (filter.getAllowanceCreatedAt() != null) {   baseSql.append(" AND allowanceCreatedAt = :allowanceCreatedAt"); }
    if (filter.getAllowanceId() != null) {   baseSql.append(" AND allowanceId = :allowanceId"); }
    if (filter.getAllowanceSalaryId() != null) {   baseSql.append(" AND allowanceSalaryId = :allowanceSalaryId"); }
    if (filter.getAllowanceStatus() != null) {   baseSql.append(" AND allowanceStatus = :allowanceStatus"); }
    if (filter.getAllowanceType() != null) {   baseSql.append(" AND allowanceType = :allowanceType"); }
    if (filter.getAllowanceUpdatedAt() != null) {   baseSql.append(" AND allowanceUpdatedAt = :allowanceUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getAllowanceAmount() != null) countQuery.addParameter("allowanceAmount", filter.getAllowanceAmount());
     if (filter.getAllowanceCreatedAt() != null) countQuery.addParameter("allowanceCreatedAt", filter.getAllowanceCreatedAt());
     if (filter.getAllowanceId() != null) countQuery.addParameter("allowanceId", filter.getAllowanceId());
     if (filter.getAllowanceSalaryId() != null) countQuery.addParameter("allowanceSalaryId", filter.getAllowanceSalaryId());
     if (filter.getAllowanceStatus() != null) countQuery.addParameter("allowanceStatus", filter.getAllowanceStatus());
     if (filter.getAllowanceType() != null) countQuery.addParameter("allowanceType", filter.getAllowanceType());
     if (filter.getAllowanceUpdatedAt() != null) countQuery.addParameter("allowanceUpdatedAt", filter.getAllowanceUpdatedAt());
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

    if (filter.getAllowanceAmount() != null) pageQuery.addParameter("allowanceAmount", filter.getAllowanceAmount());
    if (filter.getAllowanceCreatedAt() != null) pageQuery.addParameter("allowanceCreatedAt", filter.getAllowanceCreatedAt());
    if (filter.getAllowanceId() != null) pageQuery.addParameter("allowanceId", filter.getAllowanceId());
    if (filter.getAllowanceSalaryId() != null) pageQuery.addParameter("allowanceSalaryId", filter.getAllowanceSalaryId());
    if (filter.getAllowanceStatus() != null) pageQuery.addParameter("allowanceStatus", filter.getAllowanceStatus());
    if (filter.getAllowanceType() != null) pageQuery.addParameter("allowanceType", filter.getAllowanceType());
    if (filter.getAllowanceUpdatedAt() != null) pageQuery.addParameter("allowanceUpdatedAt", filter.getAllowanceUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Allowance> data = pageQuery.executeAndFetch(Allowance.class);

     return new AllowancePage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "allowanceAmount","allowanceCreatedAt","allowanceId","allowanceSalaryId","allowanceStatus","allowanceType","allowanceUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
